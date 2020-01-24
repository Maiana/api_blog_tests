import io.restassured.http.ContentType;
import java.util.ArrayList;
import static io.restassured.RestAssured.*;


public class PostsApi {

    public void postApiStatus200() {

        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts")
                .then()
                .statusCode(200);
    }

    public Integer searchPostsByValidUserID(Integer userID) {

        ArrayList<Integer> userPosts = given()
                .queryParam("userId", userID)
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/")
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .extract().path("userId");

        return userPosts.get(0);
    }

    public Integer searchPostsByInvalidUserID(Integer userID) {

        ArrayList<Integer> userPosts = given()
                .queryParam("userId", userID)
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/")
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .extract().path("userId");

        Integer arraySize = userPosts.size();

        return arraySize;
    }
}
