package com.tecruz.qrcodescanner.ui

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class QRCodeScannerScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testQRCodeScannerScreen_noQrCode() {
        val viewModel = QRScannerViewModel()
        composeTestRule.setContent {
            QRCodeScannerScreen(viewModel)
        }

        composeTestRule.onNodeWithText("Scan a QR Code").assertExists()
    }

    @Test
    fun testQRCodeScannerScreen_withQrCode() {
        val viewModel = QRScannerViewModel()
        val qrCodeData = "test qr code data"

        composeTestRule.setContent {
            QRCodeScannerScreen(viewModel)
        }

        viewModel.onQrCodeScanned(qrCodeData)

        composeTestRule.onNodeWithText("Scanned Data: $qrCodeData").assertExists()
    }
}