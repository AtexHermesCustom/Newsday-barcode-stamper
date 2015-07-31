package com.atex.h11.newsday.barcode;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class BarcodeStamper {
	private static final String loggerName = BarcodeStamper.class.getName();
    private static final Logger logger = Logger.getLogger(loggerName);	
	
	public static void main(String[] args) {
		logger.entering(loggerName, "main");
		logger.info("Budget Export started. Arguments: " + Arrays.toString(args));
		
		
	}
	
}
