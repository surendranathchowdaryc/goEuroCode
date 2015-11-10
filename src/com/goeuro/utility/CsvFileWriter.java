package com.goeuro.utility;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Contains handy generic csv file writing method implementation(s)
 * @author surendranath
 *
 */
public class CsvFileWriter {
	private static final Logger logger = LoggerFactory.getLogger(CsvFileWriter.class);
	
	public static <T> void writeCsvFile(String fileName, List<T> objectList, String csvHeader) {
		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter(fileName.trim());
			fileWriter.append(GoEuroConstants.CSV_HEADERS_FOR_CONDENSED_LOCATION_DISPLAY);
			fileWriter.append(GoEuroConstants.NEW_LINE_SEPARATOR);
			
			for (T t : objectList) {
				fileWriter.append(t.toString());
				fileWriter.append(GoEuroConstants.NEW_LINE_SEPARATOR);
			}
			logger.info("CSV file was created successfully with file name = " + fileName);
			
		} catch (Exception e) {
			logger.error("Error in CsvFileWriter with file name " + e.getMessage());
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				logger.error("Error while flushing/closing fileWriter !!!" + e.getMessage());
			}
			
		}
	}
		
}
