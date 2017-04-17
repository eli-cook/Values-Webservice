# Values-Webservice
A quick web service project demonstration for Kochava interview

This is a simple RESTful web service that accepts a set of numbers and calculates the sum of the numbers. This service has one resource called values. POSTing a value to the values resource adds the value to the service. DELETEing values will clear all the values from the service. GETting sum/values will return the sum of all the values in the service.

These design requirements were specified by Kochava.

## Install
In Linux, 
```sh
$ bash gradlew build
```
In Windows,
```cmd
> gradlew.bat
```
## Usage
From root directory,

In Linux
```sh
$ java -jar build/libs/KochavaRESTService-0.1.0.jar
```
In Windows,
```cmd
> java -jar build\libs\KochavaRESTService-0.1.0.jar
```
