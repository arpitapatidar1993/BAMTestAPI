package RestAssuredTest.RestAssuredTest;

import org.testng.annotations.Test;

import io.restassured.internal.http.Status;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;


public class Test_fahrplan_arrivalBoard_GET extends ResourceLoad {
	
	@Test
	public void positiveTestCaseOne() throws IOException
	{
		resources();
		given().
		      get(prop.getProperty(Params.HOST_URL) + prop.getProperty(Params.ARRIVALBOARD_API) +prop.getProperty(Params.ARRIVALBOARDAPI_PARAM1)+"?date="+prop.getProperty(Params.ARRIVALBOARDAPI_PARAM2))
		.then().statusCode(Params.STATUSCODE)
		.body("name[0]", notNullValue());
	}
	
	@Test
	public void negativeTestCaseOne() throws IOException {
		resources();
				given().
	      get(prop.getProperty(Params.HOST_URL) + prop.getProperty(Params.ARRIVALBOARD_API) +prop.getProperty(Params.ARRIVALBOARDAPI_PARAM1)+"?"+prop.getProperty(Params.ARRIVALBOARDAPI_ERROR_PARAM1))
	.then().statusCode(Params.STATUSCODE_400).
		body("code", equalTo(Params.STATUSCODE_400)).body("message", equalTo("Invalid date/time specification"));
		
	}
	
	@Test
	public void negativeTestCaseTwo() throws IOException {
		resources();
		given().
	      get(prop.getProperty(Params.HOST_URL) + prop.getProperty(Params.ARRIVALBOARD_API) +prop.getProperty(Params.ARRIVALBOARDAPI_ERROR_PARAM2)+"?date="+prop.getProperty(Params.ARRIVALBOARDAPI_PARAM2))
	.then().statusCode(Params.STATUSCODE_500).
	body("error.code", equalTo(Params.STATUSCODE_500)).body("error.message", equalTo("Internal Server Error"));;
		
		
		
	}
}
