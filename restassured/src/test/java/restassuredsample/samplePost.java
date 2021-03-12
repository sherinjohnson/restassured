package restassuredsample;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import top.jfunc.json.impl.JSONObject;

import org.testng.Assert;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;


public class samplePost {
	
	@Test
	public void test2() {

		JSONObject request = new JSONObject();
		request.put("name", "chaya");
		request.put("job", "BA");

		//System.out.println(request);
		System.out.println(request.toString());

		given().
		body(request.toString()).
		when().
		//post("https://reqres.in/api/users").
		put("https://reqres.in/api/users").
		//patch("https://reqres.in/api/users").
		then().statusCode(201 );

	}

}

