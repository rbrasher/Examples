package com.comfycouch.examples.adt.cityradar;

public class City {

	private final String mName;
	private final double mLatitude;
	private final double mLongitude;
	private double mDistanceToUser;
	private double mBearingToUser;
	
	public City(final String pName, final double pLatitude, final double pLongitude) {
		this.mName = pName;
		this.mLatitude = pLatitude;
		this.mLongitude = pLongitude;
	}
	
	public final String getName() {
		return this.mName;
	}
	
	public final double getLatitude() {
		return this.mLatitude;
	}
	
	public final double getLongitude() {
		return this.mLongitude;
	}
	
	public double getDistanceToUser() {
		return this.mDistanceToUser;
	}
	
	public void setDistanceToUser(final double pDistanceToUser) {
		this.mDistanceToUser = pDistanceToUser;
	}
	
	public double getBearingToUser() {
		return this.mBearingToUser;
	}
	
	public void setBearingToUser(final double pBearingToUser) {
		this.mBearingToUser = pBearingToUser;
	}
}
