package com.tecruz.qrcodescanner.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class QRScannerViewModel : ViewModel() {
    private val _qrCodeData = MutableStateFlow<String?>("")
    val qrCodeData: StateFlow<String?> = _qrCodeData

    fun onQrCodeScanned(data: String) {
        _qrCodeData.value = data
    }
}