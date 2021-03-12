package restassuredsample;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.*;

public class createEmpdata {
	
	@Test
	public void createTest() {
		 
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/create";
		String payload ="{\r\n"
				+ "   \"name\": \"yui\",\r\n"
				+ "   \"salary\": \"878\",\r\n"
				+ "   \"age\": \"67\"\r\n"
				+ "}";
		given()
			.contentType("application/json")
			.body(payload)
			
	    .when()
	    	.post()
	    	
	    .then()
	    	.assertThat().statusCode(200)
	    	.and()
	    	.body("status", equalTo("success"))
	    	.log().all();
	}

}
