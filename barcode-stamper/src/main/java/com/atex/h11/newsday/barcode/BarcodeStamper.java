package com.atex.h11.newsday.barcode;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
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
		logger.info("barcode-stamper initiated. Arguments: " + Arrays.toString(args));
		
		try {
			
			
		} catch (Exception e) {
        	logger.log(Level.SEVERE, "Error encountered", e);
        	
        } finally {
		    logger.exiting(loggerName, "main");        	        	        	
        }
	}
	
}
