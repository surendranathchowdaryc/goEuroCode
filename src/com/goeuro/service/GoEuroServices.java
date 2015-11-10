package com.goeuro.service;

import java.util.List;

import org.json.JSONArray;

import com.goeuro.entity.LocationInfo;

/**
 * Contains all the methods that interact and enrich the data fetched from GoEuro service end-points 
 * @author surendranath
 *
 */
public interface GoEuroServices {
	/**
	 * Get all the details related to each of the locations present in the city
	 * @param cityName name of the city
	 * @return json array containing info about various important locations present in the city
	 */
	public JSONArray getAllLocationsByCityName(String cityName);
	
	/**
	 * Get the most important parameters of location(s) information for display in mobile and other use-cases
	 * @param allLocations json array containing info about various important locations present in the city
	 * @return list of most important parameters of location(s)
	 */
	public List<LocationInfo> getAllLocationsInfoInCondensedForm(JSONArray allLocations);
}
