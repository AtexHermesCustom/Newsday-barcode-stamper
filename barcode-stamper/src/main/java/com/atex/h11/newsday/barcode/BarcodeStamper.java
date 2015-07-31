package com.atex.h11.newsday.barcode;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
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
    private static Properties props = null;
	
	public static void main(String[] args) {
		logger.entering(loggerName, "main");
		logger.info("barcode-stamper initiated. Arguments: " + Arrays.toString(args));
		
		String propsPath = args[0];
		String origPdfPath = args[1];
		String barcodePath = args[2];
		String destPdfPath = args[3];
		
		try {
			props.load(new FileInputStream(propsPath));
			stamp(origPdfPath, barcodePath, destPdfPath);
			
		} catch (Exception e) {
        	logger.log(Level.SEVERE, "Error encountered", e);
        	
        } finally {
        	logger.info("barcode-stamper done.");
		    logger.exiting(loggerName, "main");        	        	        	
        }
	}
	
	private static void stamp(String origPdfPath, String imagePath, String destPdfPath) 
			throws IOException, DocumentException {
		
		// retrieve settings from properties file
		float absX = Float.parseFloat(props.getProperty("absoluteX"));
		float absY = Float.parseFloat(props.getProperty("absoluteY"));
		float rotDeg = Float.parseFloat(props.getProperty("rotationDegrees"));
		float fitW = Float.parseFloat(props.getProperty("fitWidth"));
		float fitH = Float.parseFloat(props.getProperty("fitHeight"));
		
    	PdfReader pdfReader = new PdfReader(origPdfPath);
        PdfStamper pdfStamper = new PdfStamper(pdfReader,
              new FileOutputStream(destPdfPath));

        Image image = Image.getInstance(imagePath);

        for(int i=1; i<= pdfReader.getNumberOfPages(); i++){
            //PdfContentByte content = pdfStamper.getUnderContent(i);
        	PdfContentByte content = pdfStamper.getOverContent(i);
        	
        	/* sample
            image.setAbsolutePosition(370f, 765f);
            //image.setInitialRotation(90);
            image.setRotationDegrees(270);
            image.scaleToFit(160, 160);
            */
        	
            image.setAbsolutePosition(absX, absY);
            image.setRotationDegrees(rotDeg);
            image.scaleToFit(fitW, fitH);
            
            content.addImage(image);
        }

        pdfStamper.close();
	}
	
}
