package FakeRestApi;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import top.jfunc.json.impl.JSONObject;


public class demoPost {
	
	//@Test
	public void demoPost() {
		
	JSONObject request = new JSONObject();
	request.put("first_name", "sundar");
	request.put("last_name", "BA");
	request.put("subid", 5);
	
	//System.out.println(request);
	System.out.println(request.toString());

	given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		header("Content-Type", "application/json").
		body(request.toString()).
	when().
		post("http://localhost:3000/users").
	//put("https://reqres.in/api/users").
	//patch("https://reqres.in/api/users").
	then()
		.statusCode(201)
		.log().all();

}
	
	//@Test
	public void demoPut() {
		
		JSONObject request = new JSONObject();
		request.put("first_name", "uiuo");
		request.put("last_name", "jkl");
		request.put("subid", 6);
		
		//System.out.println(request);
		System.out.println(request.toString());

		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(request.toString()).
		when().
			//post("http://localhost:3000/users").
			put("http://localhost:3000/users/5").
		//patch("https://reqres.in/api/users").
		then()
			.statusCode(200)
			.log().all();

	}
	
	//@Test
	public void demoPatch() {
		
		JSONObject request = new JSONObject();
		request.put("first_name", "ssss");
		request.put("last_name", "ssss");
		request.put("subid", 6);
		
		//System.out.println(request);
		System.out.println(request.toString());

		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(request.toString()).
		when().
			//post("http://localhost:3000/users").
			//put("http://localhost:3000/users/5").
			patch("http://localhost:3000/users/5").
		then()
			.statusCode(200)
			.log().all();

	}
	
	@Test
	public void delete() {
		
		given().
		when().
			delete("http://localhost:3000/users/5").
	    then().
	    	statusCode(200);
	}

}
