package com.delivery.qr;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.util.HashMap;
public class QRCodeGenerator {


    public static void main(String[] args) {
        try {
            String productCode = "PROD123"; 
            String filePath = "QRCode.png"; 
            int width = 300;
            int height = 300;

            HashMap<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

            BitMatrix matrix = new MultiFormatWriter().encode(
                    productCode,
                    BarcodeFormat.QR_CODE,
                    width,
                    height,
                    hints
            );

            Path path = FileSystems.getDefault().getPath(filePath);
            MatrixToImageWriter.writeToPath(matrix, "PNG", path);

            System.out.println("✅ QR Code generated at: " + path.toAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
