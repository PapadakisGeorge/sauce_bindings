---
id: contributing
title: Become an OSS Contributor
sidebar_label: Contribute
---
Sauce Labs is proudly based on open source technologies and encourages open source projects like Sauce Bindings. If you would like to contribute there are several ways of doing so.

## Code of Conduct

## Requirements

## Find a Way To Contribute

The project offers a variety of ways to contribute:

* contributing code
* improving documentation
* create educational content (blog posts, tutorials, videos, etc.)
* spread the good word about the Sauce Bindings (e.g. via Twitter)
* [create bugs](https://github.com/saucelabs/sauce_bindings/issues) if you discover them while using Sauce Bindings
* See something you'd like fixed? Have a good idea for how to improve Sauce Bindings? [Create an issue](https://github.com/saucelabs/sauce_bindings/issues) or add to an existing issue. 

-   **Development**: Bug fixes and implementing new features are welcome. There are also [good first issues](https://github.com/saucelabs/sauce_bindings/issues?q=is%3Aissue+is%3Aopen+label%3A%22good+first+issue%22) labeled if you'd like to get started on development but don't know how. Please fork this this repository and open a pull request if you'd like to contribute this way.

## Contributing Docs

A great way to start working with any open source project is through improving documentation. You can add or edit doc strings, either in a pull request or directly from GitHub. You can edit a file in GitHub as long as you're signed in and create a pull request from those edits.

## Contributing Code

We love and welcome contributions from the community! We have several language bindings that we support. 
For all of the bindings you need to do the following first

1.Fork the latest code to your account

2.Clone the code onto your local computer

```bash
git clone https://github.com/saucelabs/sauce_bindings.git
``` 

3.Navigate to project directory

### Java

Run tests with `make java_tests`. All of the tests should pass.

### Python

Run tests with `make python_tests`. All of the tests should pass.

### C#

1.Open the solution, build, and run the tests. 
You can do this using the IDE or you can do this using command line:
```bash
cd YOUR REPO LOCATION\dotnet\SimpleSauce.Test
dotnet test -v n
```
All tests should pass

### Ruby

Run tests with `make ruby_tests`. All of the tests should pass.

2.Implement your feature and make sure you add tests

3.Submit a pull request