import io.restassured.http.ContentType;
import java.util.ArrayList;
import static io.restassured.RestAssured.*;


public class UsersApi {

    public void userApiStatus200(){
        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/users")
                .then()
                .statusCode(200);
    }

    public Integer searchUserByValidName(String userName) {

        ArrayList<Integer> userID = given()
                .queryParam("username", userName)
                .when()
                .get("https://jsonplaceholder.typicode.com/users")
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .extract().path("id");

        return userID.get(0);
    }


    public Integer searchUserByInvalidName(String userName) {

        ArrayList<Integer> userID = given()
                .queryParam("username", userName)
                .when()
                .get("https://jsonplaceholder.typicode.com/users")
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .extract().path("id");

        Integer arraySize = userID.size();

        return arraySize;
    }
}

