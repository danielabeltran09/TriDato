package com.trudato.commons.util;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.logging.Logger;

/**
 * Utility to read text from images
 */
public final class TextReader {

    // Private constructor of this class
    private TextReader() {
        // There are no fields required to initialize
    }

    /**
     * Gets the text contained on an image
     * @param imageLocation The image location in case the file is saved in this machine
     * @return A string containing the text in the image
     */
    public static String getImgText(final String imageLocation) {

        return getImgText(new File(imageLocation));
    }

    /**
     * Gets the text contained on an image
     * @param file The file of the image
     * @return A string containing the text in the image
     */
    public static String getImgText(final File file) {

        final ITesseract instance = new Tesseract();
        try {

            return instance.doOCR(file);
        } catch (TesseractException e) {

            e.getMessage();
            return "Error while reading image";
        }
    }

    /**
     * Gets the text contained on an image
     * @param image The buffered image
     * @return A string containing the text in the image
     */
    public static String getImgText(final BufferedImage image) {

        final ITesseract instance = new Tesseract();
        try {

            return instance.doOCR(image);
        } catch (TesseractException e) {

            e.getMessage();
            return "Error while reading image";
        }
    }
}
