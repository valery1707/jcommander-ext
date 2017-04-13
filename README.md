[![Build Status](https://travis-ci.org/valery1707/jcommander-ext.svg)](https://travis-ci.org/valery1707/jcommander-ext)
[![Coverage Status](https://coveralls.io/repos/valery1707/jcommander-ext/badge.svg)](https://coveralls.io/r/valery1707/jcommander-ext)
[![License](https://img.shields.io/github/license/valery1707/jcommander-ext.svg)](http://opensource.org/licenses/MIT)

This library contains many extensions for [JCommander](https://github.com/cbeust/jcommander).
JCommander is command line parsing framework for Java.

### Validators

1. Number
  1. Equal: `EqualTo`, `NotEqualTo`
  1. Greater: `GreaterThan`, `GreaterThanOrEqualTo`
  1. Less: `LessThan`, `LessThanOrEqualTo`
  1. Zero-compare: `EqualToZero`, `NotEqualToZero`, `GreaterThanZero`, `GreaterThanOrEqualToZero`, `LessThanZero`, `LessThanOrEqualToZero`
  1. Range: `InRange`
1. IO
  1. Base: `Exists`, `NotExists`
  1. File: `ExistsFile`, `ExistsFileReadable`, `ExistsFileWritable`, `ExistsFileExecutable`
  1. Directory: `ExistsDirectory`, `ExistsDirectoryReadable`, `ExistsDirectoryWritable`, `ExistsDirectoryExecutable`

### Build

Build with code coverage report: `clean package jacoco:report`
