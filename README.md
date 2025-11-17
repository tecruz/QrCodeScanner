# QR Code Scanner

[![Android CI](https://github.com/tecruz/QrCodeScanner/actions/workflows/android-ci.yml/badge.svg)](https://github.com/tecruz/QrCodeScanner/actions/workflows/android-ci.yml)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=tecruz_QrCodeScanner&metric=alert_status&token=7c8d1859b931fd8dc71226a291c2f02cbc5cef78)](https://sonarcloud.io/summary/new_code?id=tecruz_QrCodeScanner)
[![codecov](https://codecov.io/gh/tecruz/QrCodeScanner/graph/badge.svg?token=oiPuzwlvJN)](https://codecov.io/gh/tecruz/QrCodeScanner)

A simple QR code scanner app for Android, built with Kotlin and Jetpack Compose.

## Screenshot

<img width="230" height="510" alt="Captura de ecrã 2025-11-17 121738" src="https://github.com/user-attachments/assets/6967c0cc-7ecc-4957-8d6e-4664a67569fd" />

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
