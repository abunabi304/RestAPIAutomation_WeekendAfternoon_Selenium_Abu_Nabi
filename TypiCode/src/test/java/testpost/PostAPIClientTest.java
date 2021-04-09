package testpost;

import io.restassured.response.ValidatableResponse;
import jdk.internal.net.http.frame.Http2Frame;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import typicode.PostPojo;
import typicode.PostsAPIClient;

import static io.restassured.RestAssured.sessionId;
import static io.restassured.RestAssured.when;


public class PostAPIClientTest {
    private PostsAPIClient postsAPIClient;

    @BeforeClass
    public void setUpPostsAPI() {
        this.postsAPIClient = new PostsAPIClient();
    }

    @Test(enabled = false)
    public void testGetAllPosts() {
        ValidatableResponse response = this.postsAPIClient.getAllPosts();
        response.statusCode(HttpStatus.SC_OK);
    }

    // write a test that creates a post
    @Test(enabled = false)
    public void testUserCanCreateAPostUsingPojoSuccessfully() {
        PostPojo obj = new PostPojo(11, 101, "test title", "test body");
        ValidatableResponse response = this.postsAPIClient.createPost(obj);
        response.statusCode(HttpStatus.SC_CREATED);
    }

    @Test(enabled = false)
    public void testUserCanCreateAPostSuccessfully() {
        int userId = 11;
        String title = "test title";
        String body = "test body";

        JSONObject json = new JSONObject();
        json.put("userId", userId);
        json.put("id", 101);
        json.put("title", title);
        json.put("body", body);
        ValidatableResponse response = this.postsAPIClient.createPost(json);
        response.statusCode(HttpStatus.SC_CREATED);


        int actualUserId = response.extract().body().path("userId");
        String actualTitle = response.extract().body().path("title");
        String actualBody = response.extract().body().path("body");
        Assert.assertEquals(actualUserId, userId);
        Assert.assertEquals(actualTitle, title);
        Assert.assertEquals(actualBody, body);
    }

    @Test(enabled = false)
    public void testGetGetAllPosts() {
        ValidatableResponse response = this.postsAPIClient.getGetAllPosts();
        response.statusCode(HttpStatus.SC_OK);
    }

    @Test(enabled = false)
    public void testUserCanCreateAPostUsingPojoSuccessfully1() {
        PostPojo obj = new PostPojo(1, 2, "qui est esse", "st rerum tempore vitae nsequi sint nihil reprehenderit dolor beatae ea dolores neque nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis nqui aperiam non debitis possimus qui neque nisi nulla");
        ValidatableResponse response = this.postsAPIClient.createGetPost(obj);
        response.statusCode(HttpStatus.SC_CREATED);
    }

    @Test(enabled = false)
    public void testGetDataFromPosts() {
        ValidatableResponse response = this.postsAPIClient.getDataFromPosts();
        response.statusCode(HttpStatus.SC_OK);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test(enabled = false)
    public void testUserCanCreateAPostSuccessfully1() {
        int userId = 1;
        String title = "qui est esse";
        String body = "est rerum tempore vitae nsequi sint nihil reprehenderit dolor beatae ea dolores neque nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis nqui aperiam non debitis possimus qui neque nisi nulla";

        JSONObject json = new JSONObject();
        json.put("userId", userId);
        json.put("id", 2);
        json.put("title", title);
        json.put("body", body);
        ValidatableResponse response = this.postsAPIClient.createGetPost(json);
        response.statusCode(HttpStatus.SC_CREATED);


        int actualUserId = response.extract().body().path("userId");
        String actualTitle = response.extract().body().path("title");
        String actualBody = response.extract().body().path("body");
        Assert.assertEquals(actualUserId, userId);
        Assert.assertEquals(actualTitle, title);
        Assert.assertEquals(actualBody, body);
    }

    @Test
    public void testDataFetch() {
        ValidatableResponse response = this.postsAPIClient.dataFetch();
        response.statusCode(HttpStatus.SC_OK);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test
    @Ignore
    public void testUserCanCreateDataUsingPojoSuccessfully() {
        PostPojo obj = new PostPojo(1, 6, "abc", "abcdefghijklmnopqwxyz");
        ValidatableResponse response = this.postsAPIClient.dataCreate(obj);
        response.statusCode(HttpStatus.SC_CREATED);
    }

    @Test
    public void testUserCanCreateDataSuccessfully() {
        int postId = 1;
        String name = "abc";
        String email = "abc@gmail.com";
        String body = "abcdefghijklmnopqwxyz";
        JSONObject json = new JSONObject();
        json.put("postId", postId);
        json.put("id", 6);
        json.put("name", name);
        json.put("email", email);
        json.put("body", body);
        ValidatableResponse response = this.postsAPIClient.dataCreate(json);
        response.statusCode(HttpStatus.SC_CREATED);

//
//        int actualUserId = response.extract().body().path("postId");
//        String actualTitle = response.extract().body().path("name");
//        String actualBody = response.extract().body().path("body");
//        Assert.assertEquals(actualUserId, postId);
//        Assert.assertEquals(actualTitle, name);
//        Assert.assertEquals(actualBody, body);
    }

    @Test
    public void testGetPostedData() {
        ValidatableResponse response = this.postsAPIClient.getPostedData();
        response.statusCode(HttpStatus.SC_OK);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test
    public void testUserCangetCreatePostSuccessfully() {
        int postId = 1;
        String name = "abc";
        String email = "abc@gmail.com";
        String body = "abcdefghijklmnopqwxyz";
        JSONObject json = new JSONObject();
        json.put("postId", postId);
        json.put("id", 6);
        json.put("name", name);
        json.put("email", email);
        json.put("body", body);
        ValidatableResponse response = this.postsAPIClient.getCreatePost(json);
        response.statusCode(HttpStatus.SC_CREATED);

    }
    @Test(enabled = false)
    public void testGetCreatePostDelete() {
        ValidatableResponse response = this.postsAPIClient.getCreatePostDelete(toString());
        response.statusCode(HttpStatus.SC_NOT_FOUND);
        //System.out.println(response.extract().body().asPrettyString());
    }

    @Test
    public void testGetCreatePost1() {
        ValidatableResponse response = this.postsAPIClient.getCreatePost1();
        response.statusCode(HttpStatus.SC_OK);
        System.out.println(response.extract().body().asPrettyString());
    }

    @Test
    public void testUserCanGetCreatePost1UsingPojoSuccessfully() {
        PostPojo obj = new PostPojo(1, 6, "xyz", "abcdefghijklmnopqwxyz");
        ValidatableResponse response = this.postsAPIClient.getCreatePost1(obj);
        response.statusCode(HttpStatus.SC_CREATED);
    }

    }




