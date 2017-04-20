#!/usr/bin/env bash

version=${tag}
# Release version
if [ "${version}" = "" ] ; then
  version=$(cat pom.xml | grep --extended-regexp --regexp="<version>[0-9.]+(-SNAPSHOT)?</version>" | head -n1 | sed -r 's_.*<version>([0-9.]+)(-SNAPSHOT)?</version>.*_\1_')
fi

# Next version
if [ "${next}" = "" ] ; then
  version_1=$(echo -n "${version}" | cut -d '.' -f1)
  version_2=$(echo -n "${version}" | cut -d '.' -f2)
  version_3=$(echo -n "${version}" | cut -d '.' -f3)
  next=${version_1}.${version_2}.$[${version_3} + 1]
fi

# Changelog for release
changelog_s=$(grep -F -e '# CURRENT' -n CHANGELOG.md | cut -d ':' -f1 | head --lines=1)
changelog_f=$(grep -E -e '# [0-9.]+' -n CHANGELOG.md | cut -d ':' -f1 | head --lines=1)
changelog_s=$[${changelog_s} + 2]
changelog_f=$[${changelog_f} - 1]
changelog_l=$[${changelog_f} - ${changelog_s}]
changelog=$(cat CHANGELOG.md | tail --lines=+${changelog_s} | head --lines=${changelog_l})

gpg_pass=$(cat ../settings.xml | grep 'gpg.passphrase' | grep --only-matching '>.*<' | cut -c 2- | rev | cut -c 2- | rev)

# Tests
echo "Release version: ${version}"
echo "Next version: ${next}"
echo "Changelog: ${changelog}"
echo "GPG: md5($(echo ${gpg_pass} | md5sum)), length(${#gpg_pass})"
gpg --list-keys
git status
exit 1

# Update version
sed --in-place "s/# CURRENT/# CURRENT\n\n# ${version}/g" CHANGELOG.md
mvn versions:set "-DnewVersion=${version}"

# Build and sign
mvn clean install -P release -Dgpg.passphrase=${gpg_pass}

# Commit and tag
git commit -am "Release version ${version}"
git tag --local-user='valery1707@gmail.com' -m "Release version ${version}" v${version}

# Deploy artifact to Maven Central
mvn deploy -P release --settings ../settings.xml

# Next development iteration
mvn versions:set "-DnewVersion=${next}-SNAPSHOT"
git commit -am "Prepare for next development iteration"

# Push
git push --all origin
git push --tags origin

# Update Github release
mvn github-release-plugin:release -P release --settings ../settings.xml -Dgithub.tag="${version}" -Dgithub.releaseName="v${version}" -Dgithub.description="${changelog}"
