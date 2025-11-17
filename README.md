# QR Code Scanner

[![Android CI](https://github.com/tecruz/QrCodeScanner/actions/workflows/android-ci.yml/badge.svg)](https://github.com/tecruz/QrCodeScanner/actions/workflows/android-ci.yml)
[![Codecove](https://codecov.io/gh/tecruz/QrCodeScanner/graph/badge.svg?token=YOUR_CODECOV_TOKEN)](https://codecov.io/gh/tecruz/QrCodeScanner)

A simple QR code scanner app for Android, built with Kotlin and Jetpack Compose.

## Screenshot

| ![Screenshot 1](art/screenshot-1.png) | ![Screenshot 2](art/screenshot-2.png) |
|---|---|

## Features

*   Scans QR codes using the device's camera.
*   Displays the scanned QR code data.

## Building the Project

To build the project, you can use the following Gradle command:

```bash
./gradlew assembleDebug
```

## Running Tests

To run the unit and instrumented tests, you can use the following Gradle command:

```bash
./gradlew testDebugUnitTest
./gradlew connectedAndroidTest
```

### Code Coverage

To generate a code coverage report, run the following Gradle command:

```bash
./gradlew jacocoTestReport
```

The report will be generated in `app/build/reports/jacoco/jacocoTestReport/html/index.html`.

## Technologies Used

*   [Kotlin](https://kotlinlang.org/)
*   [Jetpack Compose](https://developer.android.com/jetpack/compose)
*   [CameraX](https://developer.android.com/training/camerax)
*   [ML Kit Barcode Scanning](https://developers.google.com/ml-kit/vision/barcode-scanning)
*   [MockK](https://mockk.io/) for mocking in tests.
*   [JaCoCo](https://www.jacoco.org/jacoco/) for code coverage.
*   [GitHub Actions](https://github.com/features/actions) for CI.
*   [Dependabot](https://docs.github.com/en/code-security/dependabot) for dependency updates.
