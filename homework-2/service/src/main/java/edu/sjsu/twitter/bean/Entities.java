package edu.sjsu.twitter.bean;

import java.util.ArrayList;

/**
 * 
 * @author Swetha Chandrasekar
 *
 */

public class Entities
{
	private ArrayList<Object> hashtags;

	public ArrayList<Object> getHashtags() { return this.hashtags; }

	public void setHashtags(ArrayList<Object> hashtags) { this.hashtags = hashtags; }

	private ArrayList<Object> symbols;

	public ArrayList<Object> getSymbols() { return this.symbols; }

	public void setSymbols(ArrayList<Object> symbols) { this.symbols = symbols; }

	private ArrayList<Object> user_mentions;

	public ArrayList<Object> getUserMentions() { return this.user_mentions; }

	public void setUserMentions(ArrayList<Object> user_mentions) { this.user_mentions = user_mentions; }

	private ArrayList<Object> urls;

	public ArrayList<Object> getUrls() { return this.urls; }

	public void setUrls(ArrayList<Object> urls) { this.urls = urls; }
}
