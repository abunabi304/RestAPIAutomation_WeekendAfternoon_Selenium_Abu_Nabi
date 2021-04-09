package tweettest;

import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import tweet.TweetAPIClient;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class TweetAPIClientTest {

    private TweetAPIClient tweetAPIClient;

    @BeforeClass
    public void setUpTweetAPI() {
        this.tweetAPIClient = new TweetAPIClient();
    }

    @Test @Ignore
    public void testUserCanTweetSuccessfully() {
        // User sent a tweet
        String tweet = "I am learning Rest API using Rest Assured and our First Tweet" + UUID.randomUUID().toString();
        ValidatableResponse response = this.tweetAPIClient.createTweet(tweet);
        // System.out.println(response.extract().body().asPrettyString());
        // Verify that the tweet is successful
        response.statusCode(200);
        //response.statusCode(401);
        // Verity tweet value
        String actualTweet = response.extract().body().path("text");
        // Long id= response.extract().body().path("id");
        //System.out.println(id);
        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
    }

    @Test @Ignore
    public void testUserCanNotTweetTheSameTweetTwiceInARow() {
        // User sent a tweet
        String tweet = "I am learning Rest API using Rest Assured and our First Tweet Same Tweet";
        ValidatableResponse response = this.tweetAPIClient.createTweet(tweet);
        // Verify that the tweet is successful
        response.statusCode(403);
        //response.statusCode(401);
        // Verity Retweet
        System.out.println(response.extract().body().asPrettyString());
        String expectedMessage = "Status is a duplicate.";
        String actualTweet = response.extract().body().path("errors[0].message");
        Assert.assertEquals(actualTweet, expectedMessage, "Tweet is match");
        Assert.assertNotEquals("403", 200);
    }


    @Test @Ignore
    public void testDeleteTweet() {
        String tweet = "I am learning Rest API using Rest Assured and our First Tweetb20b5f35-999c-4984-964c-f53b71836ae0";
        ValidatableResponse deleteResponse = this.tweetAPIClient.deleteTweet(1379294589534674945L);
        deleteResponse.statusCode(200);
        String actualTweet = deleteResponse.extract().body().path("text");
        Assert.assertEquals(tweet, actualTweet);

    }


    @Test @Ignore
    public void testResponseTime() {
        ValidatableResponse response = this.tweetAPIClient.responseTime();
    }

    @Test @Ignore
    public void testHeaderValue() {
        this.tweetAPIClient.headerValue();
    }

    @Test @Ignore
    public void testPropertyFromResponse() {
        //1. User send a tweet
        String tweet = "I am learning Rest API Automation with WeekdaysEvening_Selenium_Automation" + UUID.randomUUID().toString();
        ValidatableResponse response = this.tweetAPIClient.createTweet(tweet);
        //2. Verify that the tweet was successful
        // response.statusCode(200);

        //this.tweetAPIClient.checkProperty();
        //JsonPath pathEvaluator=response.;
        System.out.println(response.extract().body().asPrettyString());
        System.out.println(response.extract().body().asPrettyString().contains("id"));

        //String actualTweet = response.extract().body().path("text");
        //Assert.assertEquals(actualTweet, tweet, "Tweet is not match");
    }

    @Test(enabled = false)
    public void testGetUserTimeLineTweet() {
        ValidatableResponse response = this.tweetAPIClient.getUserTimeLineTweet();
        System.out.println(response.extract().body().asPrettyString());
        String expectedTweet = "Wed Apr 07 05:29:41 +0000 2021";
        String actualTweet = response.extract().body().path("[0].created_at");
        Assert.assertEquals(expectedTweet, actualTweet);
    }
    @Test(enabled = false)
    public void  testCreateFavoriteTweet(){
        //String tweet = "I am learning Favorite Tweet" + UUID.randomUUID().toString();
        String tweet = "I am learning Rest API using Rest Assured and our First Tweet" + UUID.randomUUID().toString();
        ValidatableResponse response = this.tweetAPIClient.createFavoriteTweet(tweet);

        System.out.println(response.extract().body().asPrettyString());
        //System.out.println(response.extract().body().asPrettyString().contains("id"));
        System.out.println(response.extract().body().asPrettyString());
//        response.statusCode(200);
//        String actualTweet = response.extract().body().path("errors");
//        Assert.assertEquals(actualTweet, tweet, "Tweet is not match");

    }
    @Test(enabled = false)
    public void testGetReTweet(){
        String expectedTweet = "Forbidden.";
        ValidatableResponse response = this.tweetAPIClient.GetReTweet(1379298896342523906l);
        //response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("errors[0].message");
        //Assert.assertEquals(expectedTweet, actualTweet);
        Assert.assertEquals(actualTweet, expectedTweet, "Tweet is not match");

    }
    @Test @Ignore
    public void  testGetUserHomeTimeLineTweet(){
        ValidatableResponse response = this.tweetAPIClient.getUserHomeTimeLineTweet();
        System.out.println(response.extract().body().asPrettyString());
//        String expectedTweet = "Tue Apr 06 05:04:17 +0000 2021";
//        String actualTweet = response.extract().body().path("[0].created_at");
//        Assert.assertEquals(expectedTweet, actualTweet);
//
    }
    @Test @Ignore
    public void createReTweets(){
        String expectedTweet = "This method requires a GET or HEAD.";
        ValidatableResponse response = this.tweetAPIClient.CreateReTweets(1379298684249116678l);
        //response.statusCode(200);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("errors[0].message");
        Assert.assertEquals(expectedTweet, actualTweet);
        //Assert.assertEquals(actualTweet, expectedTweet, "Tweet is not match");

    }
    @Test @Ignore
    public void testDeleteFavoritesTweet() {
        String tweet = "I am learning Rest API Automation with WeekdaysEvening_Selenium_Automationefd98e4b-12d3-4bda-b8db-3cc2c3f5a88b";
        ValidatableResponse deleteResponse = this.tweetAPIClient.deleteFavoritesTweet(1379298896342523906l);
        deleteResponse.statusCode(200);
        String actualTweet = deleteResponse.extract().body().path("text");
        Assert.assertEquals(tweet, actualTweet);

    }
    @Test(enabled = false)
    public void testGetHomeTimeLineTweet() {
        ValidatableResponse response = this.tweetAPIClient.getHomeTimeLineTweet();
        System.out.println(response.extract().body().asPrettyString());
        String expectedTweet = "Tue Apr 06 05:04:17 +0000 2021";
        String actualTweet = response.extract().body().path("[0].created_at");
        Assert.assertEquals(expectedTweet, actualTweet);
    }

    @Test(enabled = false)
    public void testGetMentionsTimeLineTweet() {
        ValidatableResponse response = this.tweetAPIClient.getMentionsTimeLineTweet();
        System.out.println(response.extract().body().asPrettyString());
//        String expectedTweet = "3pm";
//        String actualTweet = response.extract().body().path("text");
//        Assert.assertEquals(expectedTweet, actualTweet);
    }

    @Test(enabled = false)
    public void testGetCollectionEntryTweet(){
        ValidatableResponse response = this.tweetAPIClient.getCollectionEntryTweet();
        System.out.println(response.extract().body().asPrettyString());
        String expectedTweet = "Invalid required parameter 'id'.";
        String actualTweet = response.extract().body().path("error");
        Assert.assertEquals(expectedTweet, actualTweet);
    }
    @Test(enabled = true)
    public void testGetCollectionShowTweet(){
        ValidatableResponse response = this.tweetAPIClient.getCollectionShowTweet();
        System.out.println(response.extract().body().asPrettyString());
        String expectedTweet = "Bad request.";
        String actualTweet = response.extract().body().path("errors[0].message");
        Assert.assertEquals(expectedTweet, actualTweet);
    }

    @Test(enabled = false)
    public void testCreateCollectionsTweet(){
        String expectedTweet = "Bad request.";
        ValidatableResponse response = this.tweetAPIClient.createCollectionsTweet(1379298684249116678l);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("errors[0].message");
        Assert.assertEquals(expectedTweet, actualTweet);
    }
    @Test(enabled = false)
    public void testUpdateTweet(){
        String expectedTweet = "Status is a duplicate.";
        ValidatableResponse response = this.tweetAPIClient.updateTweet(1379298684249116678l);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("errors[0].message");
        Assert.assertEquals(expectedTweet, actualTweet);
    }

    @Test(enabled = false)
    public void testGetShowFriendship(){
        ValidatableResponse response = this.tweetAPIClient.getShowFriendship("timothysheahan");
        System.out.println(response.extract().body().asPrettyString());
        String expectedTweet = "Target user not specified.";
        String actualTweet = response.extract().body().path("errors[0].message");
        Assert.assertEquals(expectedTweet, actualTweet);
    }
    @Test(enabled = false)
    public void testGetSearchUser(){
        ValidatableResponse response = this.tweetAPIClient.getSearchUser("elonmusk");
        System.out.println(response.extract().body().asPrettyString());
        String expectedTweet = "Query parameters are missing.";
        String actualTweet = response.extract().body().path("errors[0].message");
        Assert.assertEquals(expectedTweet, actualTweet);
    }

    @Test(enabled = false)
    public void testCreateFriendshipTweet(){
        String expectedTweet = "Cannot find specified user.";
        ValidatableResponse response = this.tweetAPIClient.createFriendshipTweet(1379298684249116678l);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("errors[0].message");
        Assert.assertEquals(expectedTweet, actualTweet);
    }
    @Test(enabled = false)
    public void testUpdateFriendshipTweet(){
        String expectedTweet = "Sorry, that page does not exist.";
        ValidatableResponse response = this.tweetAPIClient.updateFriendshipTweet(1379298684249116678l);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("errors[0].message");
        Assert.assertEquals(expectedTweet, actualTweet);
    }

    @Test(enabled = false)
    public void testGetOutgoingFriendship(){
        ValidatableResponse response = this.tweetAPIClient.getOutgoingFriendshipTweet();
        System.out.println(response.extract().body().asPrettyString());
//        String expectedTweet = "Query parameters are missing.";
//        String actualTweet = response.extract().body().path("errors[0].message");
//        Assert.assertEquals(expectedTweet, actualTweet);
    }

    @Test(enabled = false)
    public void testGetFriendshipLookup(){
        ValidatableResponse response = this.tweetAPIClient.getFriendshipLookupTweet();
        System.out.println(response.extract().body().asPrettyString());
        String expectedTweet = "Query parameters are missing.";
        String actualTweet = response.extract().body().path("errors[0].message");
        Assert.assertEquals(expectedTweet, actualTweet);
    }
    @Test(enabled = false)
    public void testPostMediaUpload(){
        String expectedTweet = "Sorry, that page does not exist";
        ValidatableResponse response = this.tweetAPIClient.postMediaUpload(1379298684249116678l);
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("errors[0].message");
        Assert.assertEquals(expectedTweet, actualTweet);
    }
    @Test(enabled = false)
    public void testGetDirectMessages(){
        ValidatableResponse response = this.tweetAPIClient.getDirectMessages();
        System.out.println(response.extract().body().asPrettyString());
//        String expectedTweet = "Query parameters are missing.";
//        String actualTweet = response.extract().body().path("errors[0].message");
//        Assert.assertEquals(expectedTweet, actualTweet);
    }
    @Test @Ignore
    public void testPostDirectMessages(){
        String expectedTweet = "This method requires a GET or HEAD.";
        ValidatableResponse response = this.tweetAPIClient.postDirectMessages("Welcome How are you");
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("errors[0].message");
        Assert.assertEquals(expectedTweet, actualTweet);
    }

    @Test @Ignore
    public void testShowDirectMessage(){
        String expectedTweet = "id parameter is missing.";
        ValidatableResponse response = this.tweetAPIClient.showDirectMessage();
        System.out.println(response.extract().body().asPrettyString());
        String actualTweet = response.extract().body().path("errors[0].message");
        Assert.assertEquals(expectedTweet, actualTweet);
    }

    @Test(enabled = false)
    public void testPostShowDirectMessages(){
        ValidatableResponse response = this.tweetAPIClient.postShowDirectMessages("Welcome How are you");
        System.out.println(response.extract().body().asPrettyString());
        String expectedTweet = "This method requires a GET or HEAD.";
        String actualTweet = response.extract().body().path("errors[0].message");
        Assert.assertEquals(expectedTweet, actualTweet);
    }
    @Test(enabled = false)
    public void testGetShowRulesDirectMessage(){
        ValidatableResponse response = this.tweetAPIClient.getShowRulesDirectMessage();
        System.out.println(response.extract().body().asPrettyString());
        String expectedTweet = "id parameter is missing.";
        String actualTweet = response.extract().body().path("errors[0].message");
        Assert.assertEquals(expectedTweet, actualTweet);
    }

    @Test(enabled = false)
    public void testShowRulesDirectMessage(){
        ValidatableResponse response = this.tweetAPIClient.showRulesDirectMessage();
        System.out.println(response.extract().body().asPrettyString());
        String expectedTweet = "id parameter is missing.";
        String actualTweet = response.extract().body().path("errors[0].message");
        Assert.assertEquals(expectedTweet, actualTweet);
    }
    @Test(enabled = false)
    public void testGetUserProfile(){
        ValidatableResponse response = this.tweetAPIClient.getUserProfile();
        System.out.println(response.extract().body().asPrettyString());
        String expectedTweet = "Sorry, that page does not exist.";
        String actualTweet = response.extract().body().path("errors[0].message");
        Assert.assertEquals(expectedTweet, actualTweet);
    }
    @Test(enabled = false)
    public void testPostGetUserProfile(){
        ValidatableResponse response = this.tweetAPIClient.postGetUserProfile("Good Profile");
        System.out.println(response.extract().body().asPrettyString());
//        String expectedTweet = "This method requires a GET or HEAD.";
//        String actualTweet = response.extract().body().path("errors[0].message");
//        Assert.assertEquals(expectedTweet, actualTweet);
    }

    @Test(enabled = false)
    public void testUpdateProfile(){
        ValidatableResponse response = this.tweetAPIClient.updateProfile("Abu M Nabi");
        System.out.println(response.extract().body().asPrettyString());
//        String expectedTweet = "Abu M Nabi";
//        String actualTweet = response.extract().body().path("text");
//        Assert.assertEquals(expectedTweet, actualTweet);
    }
    @Test(enabled = false)
    public void testUpdateProfileBanner(){
        ValidatableResponse response = this.tweetAPIClient.updateProfileBanner("ok");
        System.out.println(response.extract().body().asPrettyString());
        String expectedTweet = "banner parameter is missing.";
        String actualTweet = response.extract().body().path("errors[0].message");
        Assert.assertEquals(expectedTweet, actualTweet);
    }
    @Test(enabled = false)
    public void testUpdateProfileImage(){
        ValidatableResponse response = this.tweetAPIClient.updateProfileImage("ok");
        System.out.println(response.extract().body().asPrettyString());
        String expectedTweet = "image parameter is missing.";
        String actualTweet = response.extract().body().path("errors[0].message");
        Assert.assertEquals(expectedTweet, actualTweet);
    }
    @Test(enabled = true)
    public void testGetFriendId(){
        ValidatableResponse response = this.tweetAPIClient.getFriendId();
        System.out.println(response.extract().body().asPrettyString());
//        String expectedTweet = "0";
//        String actualTweet = response.extract().body().path("errors[0].message");
//        Assert.assertEquals(expectedTweet, actualTweet);
    }
    @Test(enabled = false)
    public void testGetFriendshipIncoming(){
        ValidatableResponse response = this.tweetAPIClient.getFriendshipIncoming();
        System.out.println(response.extract().body().asPrettyString());
//        String expectedTweet = "0";
//        String actualTweet = response.extract().body().path("errors[0].message");
//        Assert.assertEquals(expectedTweet, actualTweet);
    }

    @Test(enabled = false)
    public void testGetBlockId(){
        ValidatableResponse response = this.tweetAPIClient.getBlockId();
        System.out.println(response.extract().body().asPrettyString());
//        String expectedTweet = "0";
//        String actualTweet = response.extract().body().path("errors[0].message");
//        Assert.assertEquals(expectedTweet, actualTweet);
    }
    @Test(enabled = false)
    public void testPostReportSpam(){
        ValidatableResponse response = this.tweetAPIClient.postReportSpam("spam");
        System.out.println(response.extract().body().asPrettyString());
        String expectedTweet = "Sorry, that page does not exist.";
        String actualTweet = response.extract().body().path("errors[0].message");
        Assert.assertEquals(expectedTweet, actualTweet);
    }
    @Test @Ignore
    public void testGetUserTimeLine1Tweet(){
        ValidatableResponse response = this.tweetAPIClient.getUserTimeLine1Tweet();
        System.out.println(response.extract().body().asPrettyString());
//        String expectedTweet = "Wed Apr 07 05:29:41 +0000 2021";
//        String actualTweet = response.extract().body().path("text");
//        Assert.assertEquals(expectedTweet, actualTweet);
    }

    @Test(enabled = true)
    public void testPostFavoriteTweet(){
        ValidatableResponse response = this.tweetAPIClient.postFavoriteTweet(1379667674372861956L);
        System.out.println(response.extract().body().asPrettyString());
        String expectedTweet = "id parameter is missing.";
        String actualTweet = response.extract().body().path("errors[0].message");
        Assert.assertEquals(expectedTweet, actualTweet);
    }

}