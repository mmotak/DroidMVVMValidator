CHANGELOG
=========

1.0.2
--------
26.03.2017
**Released**

25.03.2017

**library:**
- added `setErrorMessage` to `ValidatedObservableField`
- added call `notifyChange` into: `validate`, `hideErrorMessage`
- updated `validate`, now it return true if there was an rule to validate
- added more tests

19.03.2017

- added travis 
- added code cov
- fix some configurator for travis

1.0.1
--------
13.03.2017
**Released**

**library:**
- FIXED BUG: `android:allowBackup="false"` in `AndroidManifest.xml`
- fixed building errors while making aar file
- added `Valid` imterface
- added `ValidatorRule` class - now we can create `Rule` with lambda
- added method `withRule` to `RuleCommand.Builder` to add `Rule` created with lambda

**sample application:**
- added example with rule using OR expression
- fix lint warnings
- added example to show how create `Rule` with lambda

12.03.2017

- added this changelog

**library:**
- start adding test
- FIXED BUG in `ValidatedObservableField` in `setValue`
- made `ValidatedObservableField.validate()` public
- added new constructor to `ValidatedObservableField`
- added javadocs to some classes
- added tests for `ValidatedObservableField`
- added tests coverage tool: jacoco-android

**sample application:**
- reorganize the application
- main view is a list of all exemples
- each sub view have seperated example
- added example: single rule, multi rules, rules that validate values from others fields


1.0.0
--------
04.03.2017

- created base core of this library
- created sample app

**library:**
- added `Rule`
- added `ValidatedObservableField`
- added `RuleCommand`
- added `AbstractRule` as base for `Rule` implementations
- added implementations for Rules: `RegexRule`, `MinimumLengthRule`, `MaximumLengthRule`

**sample application:**
- added Main Activity with View Model
- added ValidatedObservableField to View Model
