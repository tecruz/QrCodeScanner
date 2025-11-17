package com.tecruz.qrcodescanner.ui

import android.media.Image
import android.util.Log
import androidx.camera.core.ImageProxy
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import com.google.mlkit.vision.barcode.BarcodeScanner
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.common.InputImage
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.slot
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class BarcodeAnalyzerTest {

    private lateinit var viewModel: QRScannerViewModel
    private lateinit var barcodeAnalyzer: BarcodeAnalyzer
    private val imageProxy = mockk<ImageProxy>(relaxed = true)
    private val mediaImage = mockk<Image>(relaxed = true)
    private val barcode = mockk<Barcode>(relaxed = true)
    private val task = mockk<Task<List<Barcode>>>(relaxed = true)
    private val scanner = mockk<BarcodeScanner>(relaxed = true)
    private val inputImage = mockk<InputImage>(relaxed = true)

    @Before
    fun setup() {
        mockkStatic(BarcodeScanning::class)
        mockkStatic(InputImage::class)
        mockkStatic(Log::class)
        every { BarcodeScanning.getClient() } returns scanner
        every { InputImage.fromMediaImage(any(), any()) } returns inputImage
        every { Log.e(any(), any()) } returns 0
        viewModel = mockk(relaxed = true)
        barcodeAnalyzer = BarcodeAnalyzer(viewModel)
        every { imageProxy.image } returns mediaImage
        every { scanner.process(any<InputImage>()) } returns task

        every { task.addOnSuccessListener(any()) } returns task
        every { task.addOnFailureListener(any()) } returns task
        every { task.addOnCompleteListener(any()) } returns task
    }

    @Test
    fun `analyze successfuly scans barcode`() {
        val slot = slot<OnSuccessListener<List<Barcode>>>()
        every { task.addOnSuccessListener(capture(slot)) } answers {            
            slot.captured.onSuccess(listOf(barcode))
            task
        }
        val rawValue = "test_qr_code"
        every { barcode.rawValue } returns rawValue

        barcodeAnalyzer.analyze(imageProxy)

        verify { viewModel.onQrCodeScanned(rawValue) }
    }

    @Test
    fun `analyze closes image proxy on completion`() {
        val slot = slot<OnCompleteListener<List<Barcode>>>()
        every { task.addOnCompleteListener(capture(slot)) } answers {            
            slot.captured.onComplete(task)
            task
        }

        barcodeAnalyzer.analyze(imageProxy)

        verify { imageProxy.close() }
    }

    @Test
    fun `analyze handles failure`() {
        val slot = slot<OnFailureListener>()
        val exception = Exception("test_exception")
        every { task.addOnFailureListener(capture(slot)) } answers {            
            slot.captured.onFailure(exception)
            task
        }

        barcodeAnalyzer.analyze(imageProxy)

        verify(exactly = 0) { viewModel.onQrCodeScanned(any()) }
    }
}