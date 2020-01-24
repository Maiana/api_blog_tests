import Helpers.ValidationHelper;
import io.restassured.http.ContentType;
import java.util.ArrayList;
import static io.restassured.RestAssured.*;


public class CommentsApi {

    public void commentApiStatus200() {
        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/comments")
                .then()
                .statusCode(200);
    }

    public Integer searchCommentsByPostId(Integer postId) {

        ArrayList<Integer> comments = given()
                .queryParam("postId", postId)
                .when()
                .get("https://jsonplaceholder.typicode.com/comments")
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .extract().path("postId");

        return comments.get(0);
    }

    public void verifyEmailFromComments(Integer PostsID) {

        ArrayList<String> Email = given()
                .queryParam("postId", PostsID)
                .when()
                .get("https://jsonplaceholder.typicode.com/comments")
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .extract().path("email");

        ValidationHelper emailAPIValidation = new ValidationHelper();
        emailAPIValidation.validateEmails(Email.get(0));
    }
}