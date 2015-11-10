package com.goeuro.entity;

/**
 * Entity for storing the most important parameters pertaining to a location
 * @author surendranath
 *
 */
public class LocationInfo {
	private String id;
	private String name;
	private String type;
	private String latitude;
	private String longitude;
	
	public LocationInfo(String id, String name, String type, String latitude, String longitude) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		return (sb.append(getId()).append(", ").
				append(getName()).append(", ").
				append(getType()).append(", ").
				append(getLatitude()).append(", ").
				append(getLongitude())).toString();
	}

}
