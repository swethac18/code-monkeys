package edu.sjsu.twitter.bean;

/**
 * 
 * @author Harani Balakrishnan
 *
 */

public class Trend {
	private String name;
	private String url;
	private String tweet_volume;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTweet_volume() {
		return tweet_volume;
	}
	public void setTweet_volume(String tweet_volume) {
		this.tweet_volume = tweet_volume;
	}
}
