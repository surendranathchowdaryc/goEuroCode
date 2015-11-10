package com.goeuro.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.goeuro.entity.LocationInfo;
import com.goeuro.utility.GoEuroConstants;
/**
 * Contains all the methods implementations that interact and enrich the data fetched from GoEuro service end-points
 * @author surendranath
 *
 */
public class GoEuroServicesImpl implements GoEuroServices {
	private static final Logger logger = LoggerFactory.getLogger(GoEuroServices.class);

	public JSONArray getAllLocationsByCityName(String cityName) {
		logger.info("Inside method getLocationDetailsByCityName");
		if((cityName == null) || cityName.trim() == "") {
			return null;
		} 
		
		RestTemplate restTemplate = new RestTemplate();
		JSONArray allLocations = null;
		try {
			String responseEntity = restTemplate.getForObject(GoEuroConstants.LOCATION_API_URI, String.class, cityName.trim());
			allLocations = new JSONArray(responseEntity); 
		} catch(Exception e) {
			logger.error("In method getLocationDetailsByCityName we got error as " + e.getMessage());
		}
		return allLocations;
	}

	public List<LocationInfo> getAllLocationsInfoInCondensedForm(JSONArray allLocations) {
		logger.info("Inside method getAllLocationsInfoInCondensedForm");
		List<LocationInfo> locationInfoList = new ArrayList<LocationInfo>();
		if(allLocations != null) {
			try {
				for (int loc = 0; loc < allLocations.length(); loc++) {
				    JSONObject location = allLocations.getJSONObject(loc);
				    String id = location.get("_id").toString();
				    String name = location.getString("name");
				    String type = location.getString("type");
				    
				    JSONObject geoPosition = location.getJSONObject("geo_position");
				    String latitude = null;
				    String longitude = null;
				    if(geoPosition != null) {
				    	latitude = geoPosition.get("latitude").toString();
				    	longitude = geoPosition.get("longitude").toString();
				    }
				    locationInfoList.add(new LocationInfo(id, name, type, latitude, longitude));
				}
			} catch(Exception e) {
				logger.error("In method getAllLocationsInfoInCondensedForm we got error as " + e.getMessage());
			}
			
		}
		return locationInfoList;
	}
}
