package edu.sjsu.twitter.bean;

/**
 * 
 * @author Yamini Muralidharen
 *
 */

public class Favourites {
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "FavouritesList [text=" + text + "]";
	}
}
