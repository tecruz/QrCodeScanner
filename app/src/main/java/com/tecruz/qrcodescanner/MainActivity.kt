package com.tecruz.qrcodescanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.tecruz.qrcodescanner.ui.QRCodeScannerScreen
import com.tecruz.qrcodescanner.ui.QRScannerViewModel
import com.tecruz.qrcodescanner.ui.theme.QrCodeScannerTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPermissionsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QrCodeScannerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val cameraPermissionState =
                        rememberPermissionState(permission = android.Manifest.permission.CAMERA)

                    LaunchedEffect(Unit) {
                        if (!cameraPermissionState.status.isGranted) {
                            cameraPermissionState.launchPermissionRequest()
                        }
                    }
                    val viewModel = QRScannerViewModel()
                    QRCodeScannerScreen(viewModel)
                }

            }
        }
    }
}