package restassuredsample;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

public class sampleGetwithParams {

    //@BeforeAll
//    public static void setup() {
//    }

    @Test
    public void getRequest() {
    	RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    	Response response = given()
                .contentType(ContentType.JSON)
                .param("postId", "2")
                .when()
                .get("/comments")
                .then()
                .extract().response();
    	
    	System.out.println("Response" + response.asString());

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("Meghan_Littel@rene.us", response.jsonPath().getString("email[3]"));
        System.out.println("Response" + response.jsonPath().getString("email[3]"));
    }
}