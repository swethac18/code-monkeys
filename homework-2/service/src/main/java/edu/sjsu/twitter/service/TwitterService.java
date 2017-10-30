package edu.sjsu.twitter.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;

import org.apache.camel.BeanInject;
import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.rs.security.oauth.client.OAuthClientUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import edu.sjsu.twitter.bean.AvailableTrends;
import edu.sjsu.twitter.bean.Favourites;
import edu.sjsu.twitter.bean.LookUpUser;
import edu.sjsu.twitter.bean.Retweet;
import edu.sjsu.twitter.bean.Suggest;
import edu.sjsu.twitter.bean.Trends;
import edu.sjsu.twitter.bean.Tweet;
import edu.sjsu.twitter.bean.TwitterConfig;

/**
 * 
 * @author Vijay Samuel
 *
 */

public class TwitterService implements Service {
	/**
	 * 
	 * @author Vijay Samuel
	 *
	 */
	private static final String FRIENDS_TIMELINE_URI = "https://api.twitter.com/1.1/statuses/home_timeline.json";
    
	/**
	 * 
	 * @author Harani Balakrishnan
	 *
	 */
	private static final String STATUS_MENTIONS_URI ="https://api.twitter.com/1.1/statuses/mentions_timeline.json";
    private static final String TRENDS_URI = "https://api.twitter.com/1.1/trends/place.json?id=1";
    private static final String USER_SUGGESTIONS_URI = "https://api.twitter.com/1.1/users/suggestions.json";
    /**
	 * 
	 * @author Swetha Chandrasekar
	 *
	 */
    private static final String USER_LOOKUP_URI ="https://api.twitter.com/1.1/users/lookup.json?screen_name=katyperry,sachin_rt,vjsamuel_,ladygaga";
	private static final String RETWEET_URI = "https://api.twitter.com/1.1/statuses/retweets_of_me.json";
	/**
	 * 
	 * @author Yamini Muralidharen
	 *
	 */
	private static final String FAVOURITES_URL ="https://api.twitter.com/1.1/favorites/list.json";
	private static final String AVAILABLE_TRENDS_URL ="https://api.twitter.com/1.1/trends/available.json";
	  
	
    private Bus bus;
    
    @BeanInject("TwitterConfig")
    TwitterConfig config;
    
    /**
     * 
     * @author Vijay Samuel
     *
     */
    @Override
    public List<Tweet> getHomeTimeline() throws Exception {
    	WebClient client = getWebClient(FRIENDS_TIMELINE_URI, bus);
    	client.header("Authorization", getOauthToken(FRIENDS_TIMELINE_URI, "GET"));
    	Response response = client.invoke("GET", null);
    
    	if (response.getStatus() == 200) {
    		Type listType = new TypeToken<ArrayList<Tweet>>(){}.getType();
        	List<Tweet> tweets = new Gson().fromJson(response.readEntity(String.class), listType);
            client.close();
            return tweets;	
    	} else {
    		Exception e =  generateError(response);
    		throw e;
    	}
    }
    
    /**
	 * 
	 * @author Harani Balakrishnan
	 *
	 */
    @Override
    public List<Tweet> getMentions() throws Exception {
    	WebClient client = getWebClient(STATUS_MENTIONS_URI, bus);
    	client.header("Authorization", getOauthToken(STATUS_MENTIONS_URI, "GET"));
    	Response response = client.invoke("GET", null);
    	
    	if (response.getStatus() == 200) {
    		Type listType = new TypeToken<ArrayList<Tweet>>(){}.getType();
        	List<Tweet> tweets = new Gson().fromJson(response.readEntity(String.class), listType);
            client.close();
            return tweets;	
    	} else {
    		Exception e =  generateError(response);
    		throw e;
    	}
    }
    
    /**
	 * 
	 * @author Harani Balakrishnan
	 *
	 */
    @Override
    public List<Trends> getTrends() throws Exception {
    	WebClient client = getWebClient(TRENDS_URI, bus);
    	client.header("Authorization", getOauthToken(TRENDS_URI, "GET"));
    	Response response = client.invoke("GET", null);
   
    	if (response.getStatus() == 200) {
    		Type listType = new TypeToken<ArrayList<Trends>>(){}.getType();
    		String resp = response.readEntity(String.class);
        	List<Trends> trends = new Gson().fromJson(resp, listType);
            client.close();
            return trends;	
    	} else {
    		Exception e =  generateError(response);
    		throw e;
    	}
    }
    
    /**
	 * 
	 * @author Harani Balakrishnan
	 *
	 */
    @Override
    public List<Suggest> userSuggestions() throws Exception {
    	WebClient client = getWebClient( USER_SUGGESTIONS_URI, bus);
    	client.header("Authorization", getOauthToken(USER_SUGGESTIONS_URI, "GET"));
    	Response response = client.invoke("GET", null);
   
    	if (response.getStatus() == 200) {
    		Type listType = new TypeToken<ArrayList<Suggest>>(){}.getType();
    		String resp = response.readEntity(String.class);
        	List<Suggest> suggests = new Gson().fromJson(resp, listType);
            client.close();
            return suggests;	
    	} else {
    		Exception e =  generateError(response);
    		throw e;
    	}
    }

    /**
	 * 
	 * @author Swetha Chandrasekar
	 *
	 */
	@Override
	public List<LookUpUser> getTwitterUsers() throws Exception {
		WebClient client = getWebClient(USER_LOOKUP_URI, bus);
		client.header("Authorization",getOauthToken(USER_LOOKUP_URI, "GET"));
		Response response = client.invoke("GET", null);
		
		if (response.getStatus() == 200) {
			Type listType = new TypeToken<ArrayList<LookUpUser>>() {}.getType();
			List<LookUpUser> users = new Gson().fromJson(response.readEntity(String.class), listType);
			return users;
		} else {
    		Exception e =  generateError(response);
    		throw e;
    	}
	}
	
	/**
	 * 
	 * @author Swetha Chandrasekar
	 *
	 */
	@Override
	public List<Retweet> getMyReTweets() throws Exception {

		WebClient client = getWebClient(RETWEET_URI, bus);
		client.header("Authorization", getOauthToken(RETWEET_URI, "GET"));
		Response response = client.invoke("GET", null);
		if (response.getStatus() == 200) {
			Type RetweetListType = new TypeToken<ArrayList<Retweet>>() {}.getType();
			List<Retweet> Retweets = new Gson().fromJson(response.readEntity(String.class), RetweetListType);
			return Retweets;
		} else {
    		Exception e =  generateError(response);
    		throw e;
    	}
	}

	/**
	 * 
	 * @author Yamini Muralidharen
	 *
	 */
	@Override
	public List<Favourites> getFavourites() throws Exception {
		WebClient client = getWebClient(FAVOURITES_URL, bus);
		client.header("Authorization", getOauthToken(FAVOURITES_URL, "GET"));
		Response response = client.invoke("GET", null);
		if (response.getStatus() == 200) {
			Type listType = new TypeToken<ArrayList<Favourites>>(){}.getType();
			List<Favourites> favourites = new Gson().fromJson(response.readEntity(String.class), listType);
			client.close();
			return favourites;	
		}else {
    		Exception e =  generateError(response);
    		throw e;
    	}
	}
	
	/**
	 * 
	 * @author Yamini Muralidharen
	 *
	 */
	@Override
	public List<AvailableTrends> getAvailableTrends() throws Exception {
    	WebClient client = getWebClient(AVAILABLE_TRENDS_URL, bus);
    	client.header("Authorization", getOauthToken(AVAILABLE_TRENDS_URL, "GET"));
    	Response response = client.invoke("GET", null);
    	if (response.getStatus() == 200) {
    		Type listType = new TypeToken<ArrayList<AvailableTrends>>(){}.getType();
        	List<AvailableTrends> trends = new Gson().fromJson(response.readEntity(String.class), listType);
            client.close();
            return trends;	
    	} else {
    		Exception e =  generateError(response);
    		throw e;
    	}
	}
	
	
	/**
	 * 
	 * @author Vijay Samuel
	 *
	 */
	private Exception generateError(Response resp) {
		if (resp.getStatus() == 401 || resp.getStatus() == 403) {
			return new NotAuthorizedException("Invalid Oauth Token");
		} else if (resp.getStatus() == 404) {
			return new NotFoundException();
		} else {
			return new InternalServerErrorException("Unable to process request");
		}
	}
	
	public void setupTwitterService() {
       this.bus = BusFactory.getThreadDefaultBus();
    }
    
    private String getOauthToken(String url, String method) {
        OAuthClientUtils.Consumer consumer = new OAuthClientUtils.Consumer(config.getConsumerKey(), config.getConsumerSecret());
        OAuthClientUtils.Token token = new OAuthClientUtils.Token(config.getAccessToken(), config.getAccessTokenSecret());
        return OAuthClientUtils.createAuthorizationHeader(consumer, token, method, url);        
    }
    
    private static WebClient getWebClient(String baseAddress, Bus bus) {
        JAXRSClientFactoryBean bean = new JAXRSClientFactoryBean();
        bean.setBus(bus);
        bean.setAddress(baseAddress);
        return bean.createWebClient();
    }
}
