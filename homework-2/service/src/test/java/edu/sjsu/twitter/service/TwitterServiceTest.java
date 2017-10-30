package edu.sjsu.twitter.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.camel.test.blueprint.CamelBlueprintTestSupport;
import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import edu.sjsu.twitter.bean.AvailableTrends;
import edu.sjsu.twitter.bean.LookUpUser;
import edu.sjsu.twitter.bean.Retweet;
import edu.sjsu.twitter.bean.Suggest;
import edu.sjsu.twitter.bean.Trends;
import edu.sjsu.twitter.bean.Tweet;

/**
 * 
 * @author Vijay Samuel
 *
 */
public class TwitterServiceTest extends CamelBlueprintTestSupport {

    @Override
    protected String getBlueprintDescriptor() {
        return "../test-classes/rest-order.xml";
    }
    
    @Test
    public void testGetHomeTimeline() throws Exception {
        TwitterService twitterService = context().getRegistry().lookupByNameAndType("service", TwitterService.class);

        // setup some pre-existing orders
        twitterService.setupTwitterService();
        // use restlet component to get the order
        String response = template.requestBody("restlet:http://localhost:8082/service/api/v1/tweets/home_timeline?restletMethod=GET", null, String.class);
        Type listType = new TypeToken<ArrayList<Tweet>>(){}.getType();
    	List<Tweet> tweets = new Gson().fromJson(response, listType);
    	
    	Assert.assertNotNull(response);
    	Assert.assertTrue(tweets.size() != 0);
    	Assert.assertNotNull(tweets.get(0).getText());
    }
    
    @Test
    public void testGetTrends() throws Exception {
        TwitterService twitterService = context().getRegistry().lookupByNameAndType("service", TwitterService.class);

        // setup some pre-existing orders
        twitterService.setupTwitterService();
        // use restlet component to get the order
        String response = template.requestBody("restlet:http://localhost:8082/service/api/v1/tweets/trends?restletMethod=GET", null, String.class);
        Type listType = new TypeToken<ArrayList<Trends>>(){}.getType();
    	List<Trends> trends = new Gson().fromJson(response, listType);
    	
    	Assert.assertNotNull(response);
    	Assert.assertTrue(trends.size() != 0);
    	Assert.assertNotNull(trends.get(0).getTrends());
    }
    
    @Test
    public void testGetMentions() throws Exception {
        TwitterService twitterService = context().getRegistry().lookupByNameAndType("service", TwitterService.class);

        // setup some pre-existing orders
        twitterService.setupTwitterService();
        // use restlet component to get the order
        String response = template.requestBody("restlet:http://localhost:8082/service/api/v1/tweets/mentions_timeline?restletMethod=GET", null, String.class);
        Type listType = new TypeToken<ArrayList<Tweet>>(){}.getType();
    	List<Tweet> tweets = new Gson().fromJson(response, listType);
    	
    	Assert.assertNotNull(response);
    	Assert.assertTrue(tweets.size() != 0);
    	Assert.assertNotNull(tweets.get(0).getText());
    }
    
    @Test
    public void testUserSuggests() throws Exception {
        TwitterService twitterService = context().getRegistry().lookupByNameAndType("service", TwitterService.class);

        // setup some pre-existing orders
        twitterService.setupTwitterService();
        // use restlet component to get the order
        String response = template.requestBody("restlet:http://localhost:8082/service/api/v1/tweets/user_suggests?restletMethod=GET", null, String.class);
        Type listType = new TypeToken<ArrayList<Suggest>>(){}.getType();
    	List<Suggest> suggests = new Gson().fromJson(response, listType);
    	
    	Assert.assertNotNull(response);
    	Assert.assertTrue(suggests.size() != 0);
    	Assert.assertNotNull(suggests.get(0).getName());
    }
    
    @Test
    public void testGetTwitterUsers() throws Exception {
        TwitterService twitterService = context().getRegistry().lookupByNameAndType("service", TwitterService.class);

        // setup some pre-existing orders
        twitterService.setupTwitterService();
        // use restlet component to get the order
        String response = template.requestBody("restlet:http://localhost:8082/service/api/v1/tweets/lookup_users?restletMethod=GET", null, String.class);
        Type listType = new TypeToken<ArrayList<LookUpUser>>(){}.getType();
    	List<LookUpUser> users = new Gson().fromJson(response, listType);
    	
    	Assert.assertNotNull(response);
    	Assert.assertTrue(users.size() != 0);
    	Assert.assertNotNull(users.get(0).getName());
    }
    
    @Test
    public void testGetMyReTweets() throws Exception {
        TwitterService twitterService = context().getRegistry().lookupByNameAndType("service", TwitterService.class);

        // setup some pre-existing orders
        twitterService.setupTwitterService();
        // use restlet component to get the order
        String response = template.requestBody("restlet:http://localhost:8082/service/api/v1/tweets/retweetsofme?restletMethod=GET", null, String.class);
        Type listType = new TypeToken<ArrayList<Retweet>>(){}.getType();
    	List<Retweet> retweets = new Gson().fromJson(response, listType);
    	
    	Assert.assertNotNull(response);
    	Assert.assertTrue(retweets.size() != 0);
    	Assert.assertNotNull(retweets.get(0).getText());
    }
    
    @Test
    public void testGetMyFavorites() throws Exception {
        TwitterService twitterService = context().getRegistry().lookupByNameAndType("service", TwitterService.class);

        // setup some pre-existing orders
        twitterService.setupTwitterService();
        // use restlet component to get the order
        String response = template.requestBody("restlet:http://localhost:8082/service/api/v1/tweets/getmyFavorites?restletMethod=GET", null, String.class);
        Type listType = new TypeToken<ArrayList<Retweet>>(){}.getType();
    	List<Retweet> retweets = new Gson().fromJson(response, listType);
    	
    	Assert.assertNotNull(response);
    	Assert.assertTrue(retweets.size() != 0);
    	Assert.assertNotNull(retweets.get(0).getText());
    }
    
    @Test
    public void testAvailableTrends() throws Exception {
        TwitterService twitterService = context().getRegistry().lookupByNameAndType("service", TwitterService.class);

        // setup some pre-existing orders
        twitterService.setupTwitterService();
        // use restlet component to get the order
        String response = template.requestBody("restlet:http://localhost:8082/service/api/v1/tweets/availableTrends?restletMethod=GET", null, String.class);
        Type listType = new TypeToken<ArrayList<AvailableTrends>>(){}.getType();
    	List<AvailableTrends> retweets = new Gson().fromJson(response, listType);
    	
    	Assert.assertNotNull(response);
    	Assert.assertTrue(retweets.size() != 0);
    	Assert.assertNotNull(retweets.get(0).getName());
    }
    
}
