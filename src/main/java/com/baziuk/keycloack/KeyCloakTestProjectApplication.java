package com.baziuk.keycloack;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class KeyCloakTestProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeyCloakTestProjectApplication.class, args);

    }


}
