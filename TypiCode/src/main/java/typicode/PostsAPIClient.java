package typicode;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;


public class PostsAPIClient extends TypiCodeAPIClient {

    private String POST_ENDPOINT = "/posts";
    private String GET_ENDPOINT = "/posts";
    private String GET_CREATE_DELETE_ENDPOINT = "/posts/1/comments";
    private String GET_CREATE_POST_ENDPOINT = "/comments?postId=1";
    private String GET_CREATE_POST1_ENDPOINT = "/posts/1";

    public ValidatableResponse getAllPosts() {
        return when().get(this.baseUrl + POST_ENDPOINT).then();
    }



    public ValidatableResponse createPost(Object json){
        return given().header("Content-type","application/json").body(json)
                .when().post(this.baseUrl+POST_ENDPOINT).then();
    }

    public ValidatableResponse getGetAllPosts() {
        return when().get(this.baseUrl + GET_ENDPOINT).then();
    }


    public ValidatableResponse createGetPost(Object json){
        return given().header("Content-type","application/json").body(json)
                .when().post(this.baseUrl+GET_ENDPOINT).then();
    }

    public ValidatableResponse getDataFromPosts() {
        return when().get(this.baseUrl + GET_ENDPOINT).then();
    }

    //Data fetch,Create and delete
    public ValidatableResponse dataFetch() {
        return when().get(this.baseUrl + GET_CREATE_DELETE_ENDPOINT).then();
    }

    public ValidatableResponse dataCreate(Object json){
        return given().header("Content-type","application/json").body(json)
                .when().post(this.baseUrl+GET_CREATE_DELETE_ENDPOINT).then();
    }

//    // Delete user from user typiCode
//    public ValidatableResponse deleteTypiCode(Long tweetId){
//        return when().post(this.baseUrl+this.GET_CREATE_DELETE_ENDPOINT).then().statusCode(200);
//
//    }

    public ValidatableResponse getPostedData() {
        return when().get(this.baseUrl + GET_CREATE_POST_ENDPOINT).then();
    }


    public ValidatableResponse getCreatePost(Object json){
        return given().header("Content-type","application/json").body(json)
                .when().post(this.baseUrl+GET_CREATE_POST_ENDPOINT).then();
    }

    public ValidatableResponse getCreatePostDelete(Object json){
        return given().header("Content-type","application/json").body(json)
                .when().delete(this.baseUrl+GET_CREATE_POST_ENDPOINT).then();
    }

    public ValidatableResponse getCreatePost1(){
        return when().get(this.baseUrl + GET_CREATE_POST1_ENDPOINT).then();
    }

    public ValidatableResponse getCreatePost1(Object json){
        return given().header("Content-type","application/json").body(json)
                .when().post(this.baseUrl+GET_CREATE_POST1_ENDPOINT).then();
    }

}
