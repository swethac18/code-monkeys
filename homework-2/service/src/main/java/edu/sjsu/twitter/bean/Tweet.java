package edu.sjsu.twitter.bean;

/**
 * 
 * @author Vijay Samuel
 *
 */

public class Tweet {
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return "Tweet: [text: " + this.text + "]";
	}
}
