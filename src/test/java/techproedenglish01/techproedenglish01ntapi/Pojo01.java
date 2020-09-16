package techproedenglish01.techproedenglish01ntapi;

import org.junit.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import techproedenglish01.techproedenglish01api.Booking;
import techproedenglish01.techproedenglish01api.Bookingdates;
import techproedenglish01.techproedenglish01api.TestBase;


public class Pojo01 extends TestBase {
	
	//By using Pojo class we will send Post Request to https://restful-booker.herokuapp.com/booking
	
	@Test
	public void post01() {
		//Created Request Body by using Pojo Classes
		Bookingdates bookingdates = new Bookingdates("2020-09-15", "2020-09-17");
		Booking booking = new Booking("Ali", "Can", 888, true, bookingdates, "Newspaper");
		
		Response response = given().
				               spec(spec02).
				               body(booking).
				            when().
				                post();
		response.prettyPrint();
		
		//Status Code Assertion
		response.then().assertThat().statusCode(200);
		
					//Soft Assert the response body
		
		//1)You can use JsonPath. Create JsonPath Object by using response.
		//  JsonPath json = response.jsonPath();
		//2)You can use De-Serialization to create a Java Object from response body
		//  Map<String, Object> map = response.as(HashMap.class);
		
		//Then do 3 steps for soft assertion

	}

}
