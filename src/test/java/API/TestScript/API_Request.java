package API.TestScript;

import org.testng.annotations.Test;
import API.Auth.base_token;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class API_Request extends base_token {

    @Test
    public void getUsersTest() { // getting all user data from https://gorest.co.in/public/v2/users
        given()
                .spec(requestSpec())
                .when()
                .get("users")
                .then()
                .log().body()
                .assertThat().statusCode(200);
    }

   @Test
    public void getActiveUser() { // getting active user data
        given()
                .spec(requestSpec())
                .queryParam("status","active")
                .when()
                .get("users")
                .then()
                .log().body()
                .assertThat().statusCode(200)
                .assertThat().body("status", Matchers.everyItem(Matchers.equalTo("active")));
    }

    @Test
    public void getNonexistingUser(){ // Negative case || getting non existent user data
        given()
                .spec(requestSpec())
                .when()
                .get("users/232")
                .then()
                .log().all()
                .assertThat().statusCode(404);
    }

    @Test(priority = 1)
    public void createUserTest() { // Positive case | Create one user with a predefined value
        JSONObject newUser = new JSONObject();
        newUser.put("name", "DemoAPIAccount");
        newUser.put("gender", "male");
        newUser.put("email", "DemoAPIAccount@test.com");
        newUser.put("status", "inactive");

        given()
                .spec(requestSpec())
                .body(newUser.toString())
                .when()
                .post("users")
                .then()
                .log().body()
                .assertThat().statusCode(201)
                .assertThat().body("name", Matchers.equalTo("DemoAPIAccount"))
                .assertThat().body("gender", Matchers.equalTo("male"))
                .assertThat().body("email", Matchers.equalTo("DemoAPIAccount@test.com"))
                .assertThat().body("status", Matchers.equalTo("inactive"));
    }

    @Test(priority = 2)
    public void createInvalidUser() { // Negative Case | Create one user with a same key value
        JSONObject newUser = new JSONObject();
        newUser.put("name", "LoremIpsum20");
        newUser.put("gender", "Female");
        newUser.put("email", "testruin@test.com");
        newUser.put("status", "active");

        given()
                .spec(requestSpec())
                .body(newUser.toString())
                .when()
                .post("users")
                .then()
                .log().body()
                .assertThat().statusCode(422)
                .assertThat().body("[0].field", Matchers.equalTo("email"))  // Check that the error is for the email field
                .assertThat().body("[0].message", Matchers.equalTo("has already been taken"));

    }

    @Test
    public void updateUserData(){
        int userID = 7820545;
        String updateName = "Lorealae";
        //Get the data
        String name = given().spec(requestSpec()).when().get("users/"+userID)
                .getBody().jsonPath().get("data.name");
        String gender = given().spec(requestSpec()).when().get("users/"+userID)
                .getBody().jsonPath().get("data.gender");
        String status = given().spec(requestSpec()).when().get("users/"+userID)
                .getBody().jsonPath().get("data.status");
        String email = given().spec(requestSpec()).when().get("users/"+userID)
                .getBody().jsonPath().get("data.email");
        System.out.println("name before = " +name);

        //Change name to "Loreal"
        //Create body request with Hashmap and covert it to json
        HashMap<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("id", userID);
        bodyMap.put("email",email);
        bodyMap.put("name", updateName);
        bodyMap.put("gender", gender);
        bodyMap.put("status", status);
        JSONObject jsonObject = new JSONObject(bodyMap);

        given().log().all()
                .spec(requestSpec())
                .body(jsonObject.toString())
                .put("users/" +userID)
                .then().log().body()
                .assertThat().statusCode(200)
                .assertThat().body("name", Matchers.equalTo(updateName));
    }

    /*@Test
    public void deleteMultipleUsers() {
        int[] userIds = {7804371};

        for (int userId : userIds) {
            RestAssured.baseURI = BASE_URL;

            given()
                    .spec(requestSpec())
                    .when()
                    .delete("users/" + userId)
                    .then()
                    .log().all()
                    .assertThat().statusCode(204);
        }
    }*/
}
