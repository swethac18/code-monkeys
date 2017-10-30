package edu.sjsu.twitter.service;

import java.util.List;

import edu.sjsu.twitter.bean.AvailableTrends;
import edu.sjsu.twitter.bean.Favourites;
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

public interface Service {
    List<Tweet> getHomeTimeline() throws Exception;
    List<Trends> getTrends() throws Exception;
    List<Tweet> getMentions() throws Exception;
    List<Suggest> userSuggestions() throws Exception;
    List<LookUpUser> getTwitterUsers() throws Exception;
    List<Retweet> getMyReTweets() throws Exception;
    List<Favourites> getFavourites() throws Exception;
    List<AvailableTrends> getAvailableTrends() throws Exception;
}
