[![Build Status](https://travis-ci.org/valery1707/jcommander-ext.svg)](https://travis-ci.org/valery1707/jcommander-ext)
[![Coverage Status](https://coveralls.io/repos/valery1707/jcommander-ext/badge.svg)](https://coveralls.io/r/valery1707/jcommander-ext)

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/name.valery1707/jcommander-ext/badge.svg)](https://maven-badges.herokuapp.com/maven-central/name.valery1707/jcommander-ext)
[![License](https://img.shields.io/github/license/valery1707/jcommander-ext.svg)](http://opensource.org/licenses/MIT)

[JCommander](https://github.com/cbeust/jcommander) is very good command line parsing framework for Java.

> "Because life is too short to parse command line parameters"
> &copy; [Cédric Beust](http://jcommander.org/)

JCommander not only can parse program arguments, it also has an extension point for validation of argument values.
At the same time JCommander does not contain (at least in version `1.64`) any validators.

This library is designed to correct this omission.

### Validators

Some validators is `ready to use`, but I can't guess all useful cases and many validators designed to be useful after simple extension without any logic implementation.

Example: if you need validate argument value to be within some borders, you need only:

1. extend class `InRange`
1. create default constructor
1. pass in super constructor required borders
1. use your class in `@Parameter#validateValueWith`

Validators list:

1. [Common](http://www.javadoc.io/doc/name.valery1707/jcommander-validator-core)
    1. Range: `InRange`, `NotInRange`
    1. Collection: `InCollection`
1. [Number](http://www.javadoc.io/doc/name.valery1707/jcommander-validator-number)
    1. Equal: `EqualTo`, `NotEqualTo`
    1. Greater: `GreaterThan`, `GreaterThanOrEqualTo`
    1. Less: `LessThan`, `LessThanOrEqualTo`
    1. Zero-compare: `EqualToZero`, `NotEqualToZero`, `GreaterThanZero`, `GreaterThanOrEqualToZero`, `LessThanZero`, `LessThanOrEqualToZero`
1. [IO](http://www.javadoc.io/doc/name.valery1707/jcommander-validator-io)
    1. Base: `Exists`, `NotExists`
    1. File: `ExistsFile`, `ExistsFileReadable`, `ExistsFileWritable`, `ExistsFileExecutable`
    1. Directory: `ExistsDirectory`, `ExistsDirectoryReadable`, `ExistsDirectoryWritable`, `ExistsDirectoryExecutable`

### Build

Build with code coverage report: `clean package jacoco:report`
