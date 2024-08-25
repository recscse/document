package com.example.document.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class QRCodeGenerator {

    public static void generateQRCode(String uniqueId, String filePath) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(uniqueId, BarcodeFormat.QR_CODE, 200, 200);
        Path path = Paths.get(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }
}
