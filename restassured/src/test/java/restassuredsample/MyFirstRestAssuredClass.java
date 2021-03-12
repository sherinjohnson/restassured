package restassuredsample;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.*;

public class MyFirstRestAssuredClass {

	@Test
	public static void getResponseBody(){
		//		 int statusCode= given().queryParam("CUSTOMER_ID","68196")
		//		           .queryParam("PASSWORD","1234!")
		//		           .queryParam("Account_No","6") .when().get("http://demo.guru99.com/V4/sinkministatement.php").getStatusCode();
		//		   System.out.println("The response status is "+statusCode);
		//
		//		   given().when().get("http://demo.guru99.com/V4/sinkministatement.php").then().assertThat().statusCode(200)
		//		   .and()
		//		   .log().body();

		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a GET request call directly by using RequestSpecification.get() method.
		// Make sure you specify the resource name.
		Response response = httpRequest.get("/Chennai");

		// Response.asString method will directly return the content of the body
		// as String.
		System.out.println("Response Body is =>  " + response.asString());
		int statusCode = response.getStatusCode();
		System.out.println("StatusCode" + statusCode);
		Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
		String statusLine = response.getStatusLine();
		System.out.println("statusLine" + statusLine);
		Assert.assertEquals(statusLine /*actual value*/, "HTTP/1.1 200 OK" /*expected value*/, "Correct status code returned");


		// Get all the headers. Return value is of type Headers.
		// Headers class implements Iterable interface, hence we
		// can apply an advance for loop to go through all Headers
		// as shown in the code below
		Headers allHeaders = response.headers();

		// Iterate over all the Headers
		for(Header header : allHeaders)
		{
			System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		}

		// Reader header of a give name. In this line we will get
		// Header named Content-Type
		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType /* actual value */, "application/json; charset=utf-8" /* expected value */);

		
		// First get the JsonPath object instance from the Response interface
		 JsonPath jsonPathEvaluator = response.jsonPath();
		 
		 // Then simply query the JsonPath object to get a String value of the node
		 // specified by JsonPath: City (Note: You should not put $. in the Java code)
		 String city = jsonPathEvaluator.get("City");
		 
		 // Let us print the city variable to see what we got
		 System.out.println("City received from Response " + city);
		 
		 // Validate the response
		 Assert.assertEquals(city, "Chennai", "Correct city name received in the Response");
		 
		}

	}
