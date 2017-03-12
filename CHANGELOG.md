CHANGELOG
=========

1.0.1 - under develop
--------
12.03.2017

- added this changelog

**library:**
- start adding test
- FIX BUG in `ValidatedObservableField` in `setValue`
- make `ValidatedObservableField.validate()` public
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
