package edu.sjsu.twitter.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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

@Path("/api/v1/tweets")
@Consumes(value = "application/json")
@Produces(value = "application/json")
public interface RestTwitterService {

    /**
     * The GET order by id operation
     */
    @GET
    @Path("/home_timeline")
    List<Tweet> getHomeTimeline();
    
    @GET
    @Path("/trends")
    List<Trends> getTrends();
    
    @GET
    @Path("/mentions_timeline")
    List<Tweet> getMentions();
    
    @GET
    @Path("/user_suggests")
    List<Suggest> userSuggestions();

    @GET
    @Path("/lookup_users")
    List<LookUpUser> getTwitterUsers();
    
    @GET
    @Path("/retweetsofme")
    List<Retweet> getMyReTweets();
    
    @GET
    @Path("/getmyFavorites")
    List<Retweet> getFavourites();
    
    @GET
    @Path("/availableTrends")
    List<AvailableTrends> getAvailableTrends();

}
