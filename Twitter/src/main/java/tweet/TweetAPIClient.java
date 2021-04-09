package tweet;

import base.RestAPI;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class TweetAPIClient extends RestAPI {

    private final String CREATE_TWEET_ENDPOINT="/statuses/update.json";
    private final String DELETE_TWEET_ENDPOINT="/statuses/destroy.json";
    private final String GET_USER_TWEET_ENDPOINT="/statuses/home_timeline.json";
    private final String GET_TIMELINE_TWEET_ENDPOINT="/statuses/user_timeline.json";
    private final String CREATE_FAVORITES_TWEET_ENDPOINT="/favorites/create.json";
    private final String GET_RETWEETS_ENDPOINT="/statuses/retweets.json";
    private final String GET_HOME_TIMELINE_ENDPOINT="/statuses/home_timeline.json";
    private final String CREATE_RETWEETS_ENDPOINT="/statuses/retweet.json";
    private final String DELETE_FAVORITES_ENDPOINT="/favorites/destroy.json";
    private final String GET_MENTIONS_TIMELINE_ENDPOINT="/statuses/mentions_timeline.json";
    private final String GET_COLLECTIONS_ENTRY_TWEET_ENDPOINT="/collections/entries.json";
    private final String GET_COLLECTIONS_SHOW_TWEET_ENDPOINT="/collections/show.json";
    private final String CREATE_COLLECTIONS_TWEET_ENDPOINT="/collections/create.json";
    private final String UPDATE_TWEET_ENDPOINT="/statuses/update.json";
    private final String SHOW_FRIENDSHIP_TWEET_ENDPOINT="/friendships/show.json";
    private final String SEARCH_USER_TWEET_ENDPOINT="/users/search.json";
    private final String CREATE_FRIENDSHIP_TWEET_ENDPOINT="/friendships/create.json";
    private final String UPDATE_FRIENDSHIP_TWEET_ENDPOINT="/friendships/update.json";
    private final String OUTGOING_FRIENDSHIP_TWEET_ENDPOINT="/friendships/outgoing";
    private final String GET_FRIENDSHIP_LOOKUP_TWEET="/friendships/lookup.json";
    private final String POST_MEDIA_UPLOAD_TWEET="/media/upload.json";
    private final String GET_DIRECT_MESSAGES_ENDPOINT="/direct_messages/welcome_messages/list.json";
    private final String SHOW_DIRECT_MESSAGES_ENDPOINT="/direct_messages/welcome_messages/show.json";
    private final String SHOW_RULES_DIRECT_MESSAGES_ENDPOINT="/direct_messages/welcome_messages/rules/show.json";
    private final String GET_USERS_PROFILE_BANNER_ENDPOINT="/users/profile_banner.json";
    private final String UPDATE_PROFILE_ENDPOINT="/account/update_profile.json";
    private final String UPDATE_PROFILE_BANNER="/account/update_profile_banner.json";
    private final String UPDATE_PROFILE_IMAGE="/account/update_profile_image.json";
    private final String GET_FRIEND_ID="/friends/ids.json";
    private final String GET_FRIENDSHIP_INCOMING="/friendships/incoming.json";
    private final String GET_BLOCK_ID_ENDPOINT="/blocks/ids.json";
    private final String POST_REPORT_SPAM_ENDPOINT="/users/report_spam.json";
    private final String GET_USER_TIMELINE_ENDPOINT1="/statuses/user_timeline.json";
    private final String POST_FAVORITE_ENDPOINT_TWEET="/favorites/create.json";





    // GET all Tweet Information
    public ValidatableResponse getUserTimeTweet(){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.GET_USER_TWEET_ENDPOINT).then().statusCode(200);
    }

    // Create a Tweet from user twitter
    public ValidatableResponse createTweet(String tweet){
        return given().auth().oauth(this.apiKey,this.apiSecretKey, this.accessToken,this.accessTokenSecret)
                .param("status",tweet)
                .when().post(this.baseUrl+this.CREATE_TWEET_ENDPOINT)
                .then();
    }

    // Delete a tweet from user twitter
    public ValidatableResponse deleteTweet(Long tweetId){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .queryParam("id",tweetId)
                .when().post(this.baseUrl+this.DELETE_TWEET_ENDPOINT).then().statusCode(200);
    }


    // Response Time check
    public ValidatableResponse responseTime(){
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey, this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.GET_USER_TWEET_ENDPOINT)
                .timeIn(TimeUnit.MILLISECONDS));
        return given().auth().oauth(this.apiKey,this.apiSecretKey, this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.GET_USER_TWEET_ENDPOINT)
                .then();

    }

    // Header Value
    public void headerValue(){
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey, this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.GET_USER_TWEET_ENDPOINT)
                .then().extract().headers());

    }

    public  void checkProperty(){
        Response response= given().auth().oauth(this.apiKey,this.apiSecretKey, this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.GET_USER_TWEET_ENDPOINT);
        JsonPath pathEvaluator= response.jsonPath();
        String createdAt=pathEvaluator.get("id");
        System.out.println(createdAt);
    }


    // GET time line Tweet Information
    public ValidatableResponse getUserTimeLineTweet(){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.GET_TIMELINE_TWEET_ENDPOINT).then().statusCode(200);
    }

    // Create a Favorite Tweet from user twitter
    public ValidatableResponse createFavoriteTweet(String tweet){
        return given().auth().oauth(this.apiKey,this.apiSecretKey, this.accessToken,this.accessTokenSecret)
                .param("status",tweet)
                .when().post(this.baseUrl+this.CREATE_FAVORITES_TWEET_ENDPOINT)
                .then();
    }

    // GET all ReTweet Information
    public ValidatableResponse GetReTweet(Long tweetId){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .queryParam("id",tweetId)
                .when().get(this.baseUrl+this.GET_RETWEETS_ENDPOINT).then();
    }
    public ValidatableResponse CreateReTweets(long tweetId){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .queryParam("id",tweetId)
                .when().post(this.baseUrl+this.GET_RETWEETS_ENDPOINT).then();
    }

    // GET home time line Tweet Information
    public ValidatableResponse getUserHomeTimeLineTweet(){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.CREATE_RETWEETS_ENDPOINT).then().statusCode(200);
    }

    // Delete a tweet from user twitter
    public ValidatableResponse deleteFavoritesTweet(Long tweetId){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .queryParam("id",tweetId)
                .when().post(this.baseUrl+this.DELETE_FAVORITES_ENDPOINT).then().statusCode(200);
    }

    // GET HomeTimeLine Tweet Information
    public ValidatableResponse getHomeTimeLineTweet(){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.GET_HOME_TIMELINE_ENDPOINT).then().statusCode(200);
    }
    // GET Mentions Time Line Tweet Information
    public ValidatableResponse getMentionsTimeLineTweet(){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.GET_MENTIONS_TIMELINE_ENDPOINT).then();
    }
    // GET Collection Entry Tweet Information
    public ValidatableResponse getCollectionEntryTweet(){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.GET_COLLECTIONS_ENTRY_TWEET_ENDPOINT).then();
    }

    // GET Collection Show Tweet Information
    public ValidatableResponse getCollectionShowTweet(){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.GET_COLLECTIONS_SHOW_TWEET_ENDPOINT).then();
    }

    // Create a Create a Collections Tweet from user twitter
    public ValidatableResponse createCollectionsTweet(long tweetId){
        return given().auth().oauth(this.apiKey,this.apiSecretKey, this.accessToken,this.accessTokenSecret)
                .param("status",tweetId)
                .when().post(this.baseUrl+this.CREATE_COLLECTIONS_TWEET_ENDPOINT)
                .then();
    }

    // Update Tweet from user twitter
    public ValidatableResponse updateTweet(long tweetId){
        return given().auth().oauth(this.apiKey,this.apiSecretKey, this.accessToken,this.accessTokenSecret)
                .param("status",tweetId)
                .when().post(this.baseUrl+this.UPDATE_TWEET_ENDPOINT)
                .then();
    }

    // Show Friendship Tweet Information
    public ValidatableResponse getShowFriendship(String tweet){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.SHOW_FRIENDSHIP_TWEET_ENDPOINT).then();
    }

    // Search User Tweet Information
    public ValidatableResponse getSearchUser(String tweet){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .queryParam(tweet)
                .when().get(this.baseUrl+this.SEARCH_USER_TWEET_ENDPOINT).then();
    }

    // Create Friendship Tweet from user twitter
    public ValidatableResponse createFriendshipTweet(long tweetId){
        return given().auth().oauth(this.apiKey,this.apiSecretKey, this.accessToken,this.accessTokenSecret)
                .param("status",tweetId)
                .when().post(this.baseUrl+this.CREATE_FRIENDSHIP_TWEET_ENDPOINT)
                .then();
    }
    // Update Friendship Tweet from user twitter
    public ValidatableResponse updateFriendshipTweet(long tweetId){
        return given().auth().oauth(this.apiKey,this.apiSecretKey, this.accessToken,this.accessTokenSecret)
                .param("status",tweetId)
                .when().post(this.baseUrl+this.UPDATE_FRIENDSHIP_TWEET_ENDPOINT)
                .then();
    }
    // Outgoing Friendship Tweet Information
    public ValidatableResponse getOutgoingFriendshipTweet(){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.OUTGOING_FRIENDSHIP_TWEET_ENDPOINT).then();
    }

    // Get Friendship Lookup Tweet Information
    public ValidatableResponse getFriendshipLookupTweet(){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.GET_FRIENDSHIP_LOOKUP_TWEET).then();
    }

    // Media Upload from user twitter
    public ValidatableResponse postMediaUpload(long tweetId){
        return given().auth().oauth(this.apiKey,this.apiSecretKey, this.accessToken,this.accessTokenSecret)
                .param("status",tweetId)
                .when().post(this.baseUrl+this.POST_MEDIA_UPLOAD_TWEET)
                .then();
    }

    // Get Direct Messages Information
    public ValidatableResponse getDirectMessages(){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.GET_DIRECT_MESSAGES_ENDPOINT).then();
    }

    public ValidatableResponse postDirectMessages(String message){
        return given().auth().oauth(this.apiKey,this.apiSecretKey, this.accessToken,this.accessTokenSecret)
                .param("status",message)
                .when().post(this.baseUrl+this.GET_DIRECT_MESSAGES_ENDPOINT)
                .then();
    }

    // show Direct Message Tweet Information
    public ValidatableResponse showDirectMessage(){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.SHOW_DIRECT_MESSAGES_ENDPOINT).then();
    }

    //post show Direct Message Tweet Information
    public ValidatableResponse postShowDirectMessages(String message){
        return given().auth().oauth(this.apiKey,this.apiSecretKey, this.accessToken,this.accessTokenSecret)
                .param("status",message)
                .when().post(this.baseUrl+this.SHOW_DIRECT_MESSAGES_ENDPOINT)
                .then();
    }

    // show Rules Direct Message Tweet Information
    public ValidatableResponse getShowRulesDirectMessage(){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.SHOW_RULES_DIRECT_MESSAGES_ENDPOINT).then();
    }
    // show Rules Direct Message Tweet Information
    public ValidatableResponse showRulesDirectMessage(){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.SHOW_RULES_DIRECT_MESSAGES_ENDPOINT).then();
    }
    // get User Profile Information
    public ValidatableResponse getUserProfile(){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.GET_USERS_PROFILE_BANNER_ENDPOINT).then();
    }
    // post User Profile Information Information
    public ValidatableResponse postGetUserProfile(String message){
        return given().auth().oauth(this.apiKey,this.apiSecretKey, this.accessToken,this.accessTokenSecret)
                .param("status",message)
                .when().post(this.baseUrl+this.GET_USERS_PROFILE_BANNER_ENDPOINT)
                .then();
    }

    // Update Profile Information Information
    public ValidatableResponse updateProfile(String message){
        return given().auth().oauth(this.apiKey,this.apiSecretKey, this.accessToken,this.accessTokenSecret)
                .param("status",message)
                .when().post(this.baseUrl+this.UPDATE_PROFILE_ENDPOINT)
                .then();
    }
    // Update Profile Banner Information Information
    public ValidatableResponse updateProfileBanner(String message){
        return given().auth().oauth(this.apiKey,this.apiSecretKey, this.accessToken,this.accessTokenSecret)
                .param("status",message)
                .when().post(this.baseUrl+this.UPDATE_PROFILE_BANNER)
                .then();
    }
    // Update Profile Image Information Information
    public ValidatableResponse updateProfileImage(String message){
        return given().auth().oauth(this.apiKey,this.apiSecretKey, this.accessToken,this.accessTokenSecret)
                .param("status",message)
                .when().post(this.baseUrl+this.UPDATE_PROFILE_IMAGE)
                .then();
    }
    // get Friend id Information
    public ValidatableResponse getFriendId(){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.GET_FRIEND_ID).then();
    }
    // get Friendship incoming Information
    public ValidatableResponse getFriendshipIncoming(){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.GET_FRIENDSHIP_INCOMING).then();
    }
    // Block ID Information
    public ValidatableResponse getBlockId(){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.GET_BLOCK_ID_ENDPOINT).then();
    }

    // post Report Spam  Information
    public ValidatableResponse postReportSpam(String message){
        return given().auth().oauth(this.apiKey,this.apiSecretKey, this.accessToken,this.accessTokenSecret)
                .param("status",message)
                .when().post(this.baseUrl+this.POST_REPORT_SPAM_ENDPOINT)
                .then();
    }

    // GET user timeline Information
    public ValidatableResponse getUserTimeLine1Tweet(){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.GET_USER_TIMELINE_ENDPOINT1).then().statusCode(200);
    }

    // postFavoriteTweet Information
    public ValidatableResponse postFavoriteTweet(long TweetId){
        return given().auth().oauth(this.apiKey,this.apiSecretKey, this.accessToken,this.accessTokenSecret)
                .param("status",TweetId)
                .when().post(this.baseUrl+this.POST_FAVORITE_ENDPOINT_TWEET)
                .then();
    }



}
