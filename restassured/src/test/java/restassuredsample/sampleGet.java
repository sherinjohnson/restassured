package restassuredsample;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

public class sampleGet {

    //@BeforeAll
//    public static void setup() {
//    }

    @Test
    public void getRequest() {
    	RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/posts")
                .then()
                .extract().response();
        System.out.println("Response" + response.asString());

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("qui est esse", response.jsonPath().getString("title[1]"));
        System.out.println("Response" + response.jsonPath().getString("title[1]"));
    }
}