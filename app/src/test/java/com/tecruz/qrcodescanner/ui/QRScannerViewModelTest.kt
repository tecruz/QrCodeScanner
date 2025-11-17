package com.tecruz.qrcodescanner.ui

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class QRScannerViewModelTest {

    private lateinit var viewModel: QRScannerViewModel

    @Before
    fun setup() {
        viewModel = QRScannerViewModel()
    }

    @Test
    fun `onQrCodeScanned updates qrCodeData`() = runTest {
        val testData = "test qr code"
        viewModel.onQrCodeScanned(testData)
        assertEquals(testData, viewModel.qrCodeData.value)
    }
}