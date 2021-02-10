# Project Title

QA Engineering Assessment Challenge; The goal is to sketch a test approach to test the document upload process in the web site: https://www.studydrive.net


## Getting Started

The system under test is the document upload process in the web site: https://www.studydrive.net. The version of the system is not communicated.

### Prerequisites

The computer where you want to run these tests needs to be connected to the internet to get the last driver for each browser.

All browsers need to be up-to-date that the tests can run.


## Running the tests

To run the test: you can run Runner.java or from the terminal run:  mvn test. A vedio is attached to this work to show you the execution.

You can also change the browser in which you want to execute the tests in the configuration file as we did at the end of the video.
## Test Environment


This example is based on the following technologies and platforms.

* Windows Platform for development
* Java as the programming language
* Intellij as development IDE
* Chrome Version 88.0.4324.150 (Official Build) (64-bit)

## Used Framework:

In our solution, we choose Cucumber framework and Appium libraries. Cucumber is one of the more widely used BDD (Behavior Driven Development testing frameworks.

## Test Framework structure:
In our framework, we have:

 * feature folder contains only features that are business readable and understandable. Mainly it contains the main function and the designed test case with a specific language called Gherkin

 * java folder: contains all java code

 * Steps folder contains the java code that implements the features.

 * Runner folder contains the class that run all tests
 
 * Page Object folder contains all android element located by page
  
 * Helpers folder contains functions that are called multiple time in the code. This will facilitate their use and maintainability.
  
 * Hook folder contains the steps to execute before and after each test.
 
 * Base folder is used to pass the same driver 
 
 * Configuration folder contains the used configuration during the execution.
 
 * resources folder: can contain some CSV or JSON files for some data input to be tested or used. This will facilitate their use and maintainability.

## Authors

* **Sirine Mrabet** - *Initial work* 


## Acknowledgments

* Code reusability

## To make it better
* Test in parallel
* Android test
* Security tests
* Performance Test
* Compatibility Test

