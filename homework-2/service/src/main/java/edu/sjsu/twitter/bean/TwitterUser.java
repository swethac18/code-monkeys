package edu.sjsu.twitter.bean;

/**
 * 
 * @author Swetha Chandrasekar
 *
 */

public class TwitterUser
{
	private long id;

	public long getId() { return this.id; }

	public void setId(long id) { this.id = id; }

	private String id_str;

	public String getIdStr() { return this.id_str; }

	public void setIdStr(String id_str) { this.id_str = id_str; }

	private String name;

	public String getName() { return this.name; }

	public void setName(String name) { this.name = name; }

	private String screen_name;

	public String getScreenName() { return this.screen_name; }

	public void setScreenName(String screen_name) { this.screen_name = screen_name; }

	private String location;

	public String getLocation() { return this.location; }

	public void setLocation(String location) { this.location = location; }

	private String description;

	public String getDescription() { return this.description; }

	public void setDescription(String description) { this.description = description; }

	private Object url;

	public Object getUrl() { return this.url; }

	public void setUrl(Object url) { this.url = url; }

	private Entities2 entities;

	public Entities2 getEntities() { return this.entities; }

	public void setEntities(Entities2 entities) { this.entities = entities; }

	private int followers_count;

	public int getFollowersCount() { return this.followers_count; }

	public void setFollowersCount(int followers_count) { this.followers_count = followers_count; }

	private int friends_count;

	public int getFriendsCount() { return this.friends_count; }

	public void setFriendsCount(int friends_count) { this.friends_count = friends_count; }

	private int listed_count;

	public int getListedCount() { return this.listed_count; }

	public void setListedCount(int listed_count) { this.listed_count = listed_count; }

	private String created_at;

	public String getCreatedAt() { return this.created_at; }

	public void setCreatedAt(String created_at) { this.created_at = created_at; }

	private int favourites_count;

	public int getFavouritesCount() { return this.favourites_count; }

	public void setFavouritesCount(int favourites_count) { this.favourites_count = favourites_count; }

	private Object utc_offset;

	public Object getUtcOffset() { return this.utc_offset; }

	public void setUtcOffset(Object utc_offset) { this.utc_offset = utc_offset; }

	private Object time_zone;

	public Object getTimeZone() { return this.time_zone; }

	public void setTimeZone(Object time_zone) { this.time_zone = time_zone; }

	private boolean geo_enabled;

	public boolean getGeoEnabled() { return this.geo_enabled; }

	public void setGeoEnabled(boolean geo_enabled) { this.geo_enabled = geo_enabled; }

	private boolean verified;

	public boolean getVerified() { return this.verified; }

	public void setVerified(boolean verified) { this.verified = verified; }

	private int statuses_count;

	public int getStatusesCount() { return this.statuses_count; }

	public void setStatusesCount(int statuses_count) { this.statuses_count = statuses_count; }

	private String lang;

	public String getLang() { return this.lang; }

	public void setLang(String lang) { this.lang = lang; }

	private boolean contributors_enabled;

	public boolean getContributorsEnabled() { return this.contributors_enabled; }

	public void setContributorsEnabled(boolean contributors_enabled) { this.contributors_enabled = contributors_enabled; }

	private boolean is_translator;

	public boolean getIsTranslator() { return this.is_translator; }

	public void setIsTranslator(boolean is_translator) { this.is_translator = is_translator; }

	private boolean is_translation_enabled;

	public boolean getIsTranslationEnabled() { return this.is_translation_enabled; }

	public void setIsTranslationEnabled(boolean is_translation_enabled) { this.is_translation_enabled = is_translation_enabled; }

	private String profile_background_color;

	public String getProfileBackgroundColor() { return this.profile_background_color; }

	public void setProfileBackgroundColor(String profile_background_color) { this.profile_background_color = profile_background_color; }

	private Object profile_background_image_url;

	public Object getProfileBackgroundImageUrl() { return this.profile_background_image_url; }

	public void setProfileBackgroundImageUrl(Object profile_background_image_url) { this.profile_background_image_url = profile_background_image_url; }

	private Object profile_background_image_url_https;

	public Object getProfileBackgroundImageUrlHttps() { return this.profile_background_image_url_https; }

	public void setProfileBackgroundImageUrlHttps(Object profile_background_image_url_https) { this.profile_background_image_url_https = profile_background_image_url_https; }

	private boolean profile_background_tile;

	public boolean getProfileBackgroundTile() { return this.profile_background_tile; }

	public void setProfileBackgroundTile(boolean profile_background_tile) { this.profile_background_tile = profile_background_tile; }

	private String profile_image_url;

	public String getProfileImageUrl() { return this.profile_image_url; }

	public void setProfileImageUrl(String profile_image_url) { this.profile_image_url = profile_image_url; }

	private String profile_image_url_https;

	public String getProfileImageUrlHttps() { return this.profile_image_url_https; }

	public void setProfileImageUrlHttps(String profile_image_url_https) { this.profile_image_url_https = profile_image_url_https; }

	private String profile_link_color;

	public String getProfileLinkColor() { return this.profile_link_color; }

	public void setProfileLinkColor(String profile_link_color) { this.profile_link_color = profile_link_color; }

	private String profile_sidebar_border_color;

	public String getProfileSidebarBorderColor() { return this.profile_sidebar_border_color; }

	public void setProfileSidebarBorderColor(String profile_sidebar_border_color) { this.profile_sidebar_border_color = profile_sidebar_border_color; }

	private String profile_sidebar_fill_color;

	public String getProfileSidebarFillColor() { return this.profile_sidebar_fill_color; }

	public void setProfileSidebarFillColor(String profile_sidebar_fill_color) { this.profile_sidebar_fill_color = profile_sidebar_fill_color; }

	private String profile_text_color;

	public String getProfileTextColor() { return this.profile_text_color; }

	public void setProfileTextColor(String profile_text_color) { this.profile_text_color = profile_text_color; }

	private boolean profile_use_background_image;

	public boolean getProfileUseBackgroundImage() { return this.profile_use_background_image; }

	public void setProfileUseBackgroundImage(boolean profile_use_background_image) { this.profile_use_background_image = profile_use_background_image; }

	private boolean has_extended_profile;

	public boolean getHasExtendedProfile() { return this.has_extended_profile; }

	public void setHasExtendedProfile(boolean has_extended_profile) { this.has_extended_profile = has_extended_profile; }

	private boolean default_profile;

	public boolean getDefaultProfile() { return this.default_profile; }

	public void setDefaultProfile(boolean default_profile) { this.default_profile = default_profile; }

	private boolean default_profile_image;

	public boolean getDefaultProfileImage() { return this.default_profile_image; }

	public void setDefaultProfileImage(boolean default_profile_image) { this.default_profile_image = default_profile_image; }

	private boolean following;

	public boolean getFollowing() { return this.following; }

	public void setFollowing(boolean following) { this.following = following; }

	private boolean follow_request_sent;

	public boolean getFollowRequestSent() { return this.follow_request_sent; }

	public void setFollowRequestSent(boolean follow_request_sent) { this.follow_request_sent = follow_request_sent; }

	private boolean notifications;

	public boolean getNotifications() { return this.notifications; }

	public void setNotifications(boolean notifications) { this.notifications = notifications; }

	private String translator_type;

	public String getTranslatorType() { return this.translator_type; }

	public void setTranslatorType(String translator_type) { this.translator_type = translator_type; }
}
