package edu.sjsu.twitter.bean;

/**
 * 
 * @author Yamini Muralidharen
 *
 */

public class AvailableTrends {
	private String country;
	private String name;

	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getCountry() {
		return country;
	}
	
	
	@Override
	public String toString() {
		return "AvailableTrends [country=" + country + " , " + "name=" + name + "]";
	}

}
