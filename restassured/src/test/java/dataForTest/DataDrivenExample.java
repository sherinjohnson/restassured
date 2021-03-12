package dataForTest;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import top.jfunc.json.impl.JSONObject;

public class DataDrivenExample extends DataForTest {



	@Test(dataProvider = "datafortest")
	public void test2(String name,String job) {

		JSONObject request = new JSONObject();
		request.put("name", name);
		request.put("job", job);

		//System.out.println(request);
		System.out.println(request.toString());

		given().
		body(request.toString()).
		when().
		post("https://reqres.in/api/users").
		then().statusCode(201 );

	}



	@Test(dataProvider = "datafordelete")
	public void test_delete(int userId) {

		baseURI = "https://reqres.in/api/";

		when().
		delete("users/"+userId).
		then().
		statusCode(204);

	}

	@Parameters({"userId"})
    @Test
	public void test_delete1(int userId) {

		System.out.println(userId);
		baseURI = "https://reqres.in/api/";

		when().
		delete("users/"+userId).
		then().
		statusCode(204);

	}


}
