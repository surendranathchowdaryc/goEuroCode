package com.goeuro.test;

import java.util.List;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.goeuro.entity.LocationInfo;
import com.goeuro.service.GoEuroServices;
import com.goeuro.service.GoEuroServicesImpl;
import com.goeuro.utility.CsvFileWriter;
import com.goeuro.utility.GoEuroConstants;
/**
 * 
 * @author surendranath
 *
 */
public class GoEuroSearch {
	private static final Logger logger = LoggerFactory.getLogger(GoEuroSearch.class);
	
	public static void main(String[] args) {
		try{
			searchByCityTest(args[0]);
		} catch(Exception e) {
			logger.error("Enter city name!!!");
		}
		
	}
	
	public static void searchByCityTest(String cityName) {
		GoEuroServices ges = new GoEuroServicesImpl();
		
		JSONArray allLocations = ges.getAllLocationsByCityName(cityName);
		if((allLocations != null) && (allLocations.length() != 0)) {
			List<LocationInfo> locationInfoList = ges.getAllLocationsInfoInCondensedForm(allLocations);
			CsvFileWriter.writeCsvFile(cityName, locationInfoList, GoEuroConstants.CSV_HEADERS_FOR_CONDENSED_LOCATION_DISPLAY);
		} else {
			logger.info("No info is fetched for display. Enter proper city name!!!");
		}
		
	}

}
