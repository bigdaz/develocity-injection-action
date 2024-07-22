# Develocity injection for GitHub Actions

This repository provides Develocity injection support for GitHub Actions, via a composite action implementation for both Gradle and Maven.

When applied, the action will enable Develocity for each subsequent Gradle/Maven execution.
Build Scan links are published to the Job Summary for easy access.

These actions are designed as an example to be copied and modified. As such, the Develocity URL is currently hard-coded into the action implementation. 
This value could easily be extracted into an input parameter.

Example workflows using these actions:

## Gradle

```
name: Gradle Build

on:
  push:

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
    - uses: actions/checkout@v4
    - uses: actions/setup-java@v4
      with:
        distribution: 'temurin'
        java-version: 11

    - name: Inject Develocity for Gradle
      uses: bigdaz/develocity-injection-action/dv-inject-gradle@main
      with:
        develocity-access-key: ${{ secrets.DEVELOCITY_ACCESS_KEY }}

    - name: Build with Gradle
      run: ./gradlew build
```

## Maven

```
name: Maven Build

on:
  push:

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
    - uses: actions/checkout@v4
    - uses: actions/setup-java@v4
      with:
        distribution: 'temurin'
        java-version: 11

    - name: Inject Develocity for Maven
      uses: bigdaz/develocity-injection-action/dv-inject-maven@main
      with:
        develocity-access-key: ${{ secrets.DEVELOCITY_ACCESS_KEY }}

    - name: Build with Maven
      run: ./mvnw -B verify
```
