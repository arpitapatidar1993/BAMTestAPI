package RestAssuredTest.RestAssuredTest;

import org.testng.annotations.Test;

import io.restassured.internal.http.Status;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;


public class Test_fahrplan_location_GET extends ResourceLoad {
	
	@Test
	public void positiveTestCaseOne() throws IOException
	{
		resources();
		given().
		      get(prop.getProperty(Params.HOST_URL) + prop.getProperty(Params.LOCATION_API) +prop.getProperty(Params.SUCCESS_PARAM1))
		.then().statusCode(Params.STATUSCODE)
		.body("id[0]", notNullValue());
	}
	
	@Test
	public void negativeTestCaseOne() throws IOException {
		resources();
		
		given().
		get(prop.getProperty(Params.HOST_URL)+ prop.getProperty(Params.LOCATION_API)+prop.getProperty(Params.ERROR_PARAM1))
		.then().statusCode(Params.STATUSCODE_500).
		body("error.code", equalTo(Params.STATUSCODE_500)).body("error.message", equalTo("Internal Server Error"));
		
	}
}
