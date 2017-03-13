# DroidMVVMValidator
[![Download](https://api.bintray.com/packages/mmotak/snipcorp/droid-mvvm-validator/images/download.svg)](https://bintray.com/mmotak/snipcorp/droid-mvvm-validator/_latestVersion)

Simple and light library to do validate observable fields with MVVM for android

Usage
-----

Each **ValidatedObservableField<T>** work like **ObservableField<T>**, but it have 3 observables properties:
- **value** - contains the value of type T
- **valid** - boolean true if ALL Rules are valid
- **errorMessage** - contains NULL or errorMessage from first invalid Rule

Rules are validated one by one (the order is important), the first invalid Rule will break the chain and set errorMessage.
Rules are validated onPropertyChange.
You can create your own rules using Rule interface.
You can use single Rule or many by RuleCommand.

```java
    public ValidatedObservableField<String> userName = new ValidatedObservableField<>("",
            new RuleCommand.Builder<String>()
                    .withRule(new RegexRule("[a-z]+", "Only small letters")) // THE ORDER IS IMPORTANT!
                    .withRule(new MinimumLengthRule(3, "Three or more characters"))
                    .withRule(new MaximumLengthRule(12, "No more then twelve characters"))
                    .build());
```

```xml
            <android.support.design.widget.TextInputLayout
                app:setError="@{viewModel.userName.errorMessage}">

                <android.support.design.widget.TextInputEditText
                    android:text="@={viewModel.userName.value}"/>

            </android.support.design.widget.TextInputLayout>
			
			<Button
            android:visibility="@{viewModel.userName.valid ? View.VISIBLE : View.GONE}"/>
```

Download
--------

You can depend on the library through Gradle:

```groovy
    repositories {
        jcenter()
    }

dependencies {
  compile 'pl.com.mmotak.validator:droid-mvvm-validator:1.0.0'
}
```

Changelog
---------

See [CHANGELOG.md](CHANGELOG.md) file.


License
-------

    Copyright 2017 Maciej Motak

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
