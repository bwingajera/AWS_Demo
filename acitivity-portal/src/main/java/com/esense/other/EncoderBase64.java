package com.esense.other;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class EncoderBase64 {

	public static String encodeFileToBase64Binary(MultipartFile file) throws IOException {
	//    File file = new File(fileName);
	    byte[] encoded = org.apache.commons.codec.binary.Base64.encodeBase64(file.getBytes());
	    return new String(encoded, StandardCharsets.US_ASCII);
	}
}
