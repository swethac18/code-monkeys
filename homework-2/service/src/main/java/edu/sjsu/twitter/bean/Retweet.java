package edu.sjsu.twitter.bean;

/**
 * 
 * @author Swetha Chandrasekar
 *
 */

public class Retweet
{
	private String created_at;

	public String getCreatedAt() { return this.created_at; }

	public void setCreatedAt(String created_at) { this.created_at = created_at; }

	private long id;

	public long getId() { return this.id; }

	public void setId(long id) { this.id = id; }

	private String id_str;

	public String getIdStr() { return this.id_str; }

	public void setIdStr(String id_str) { this.id_str = id_str; }

	private String text;

	public String getText() { return this.text; }

	public void setText(String text) { this.text = text; }

	private boolean truncated;

	public boolean getTruncated() { return this.truncated; }

	public void setTruncated(boolean truncated) { this.truncated = truncated; }

	private Entities entities;

	public Entities getEntities() { return this.entities; }

	public void setEntities(Entities entities) { this.entities = entities; }

	private String source;

	public String getSource() { return this.source; }

	public void setSource(String source) { this.source = source; }

	private Object in_reply_to_status_id;

	public Object getInReplyToStatusId() { return this.in_reply_to_status_id; }

	public void setInReplyToStatusId(Object in_reply_to_status_id) { this.in_reply_to_status_id = in_reply_to_status_id; }

	private Object in_reply_to_status_id_str;

	public Object getInReplyToStatusIdStr() { return this.in_reply_to_status_id_str; }

	public void setInReplyToStatusIdStr(Object in_reply_to_status_id_str) { this.in_reply_to_status_id_str = in_reply_to_status_id_str; }

	private Object in_reply_to_user_id;

	public Object getInReplyToUserId() { return this.in_reply_to_user_id; }

	public void setInReplyToUserId(Object in_reply_to_user_id) { this.in_reply_to_user_id = in_reply_to_user_id; }

	private Object in_reply_to_user_id_str;

	public Object getInReplyToUserIdStr() { return this.in_reply_to_user_id_str; }

	public void setInReplyToUserIdStr(Object in_reply_to_user_id_str) { this.in_reply_to_user_id_str = in_reply_to_user_id_str; }

	private Object in_reply_to_screen_name;

	public Object getInReplyToScreenName() { return this.in_reply_to_screen_name; }

	public void setInReplyToScreenName(Object in_reply_to_screen_name) { this.in_reply_to_screen_name = in_reply_to_screen_name; }

	private TwitterUser user;

	public TwitterUser getUser() { return this.user; }

	public void setUser(TwitterUser user) { this.user = user; }

	private Object geo;

	public Object getGeo() { return this.geo; }

	public void setGeo(Object geo) { this.geo = geo; }

	private Object coordinates;

	public Object getCoordinates() { return this.coordinates; }

	public void setCoordinates(Object coordinates) { this.coordinates = coordinates; }

	private Object place;

	public Object getPlace() { return this.place; }

	public void setPlace(Object place) { this.place = place; }

	private Object contributors;

	public Object getContributors() { return this.contributors; }

	public void setContributors(Object contributors) { this.contributors = contributors; }

	private boolean is_quote_status;

	public boolean getIsQuoteStatus() { return this.is_quote_status; }

	public void setIsQuoteStatus(boolean is_quote_status) { this.is_quote_status = is_quote_status; }

	private int retweet_count;

	public int getRetweetCount() { return this.retweet_count; }

	public void setRetweetCount(int retweet_count) { this.retweet_count = retweet_count; }

	private int favorite_count;

	public int getFavoriteCount() { return this.favorite_count; }

	public void setFavoriteCount(int favorite_count) { this.favorite_count = favorite_count; }

	private boolean favorited;

	public boolean getFavorited() { return this.favorited; }

	public void setFavorited(boolean favorited) { this.favorited = favorited; }

	private boolean retweeted;

	public boolean getRetweeted() { return this.retweeted; }

	public void setRetweeted(boolean retweeted) { this.retweeted = retweeted; }

	private String lang;

	public String getLang() { return this.lang; }

	public void setLang(String lang) { this.lang = lang; }
}
