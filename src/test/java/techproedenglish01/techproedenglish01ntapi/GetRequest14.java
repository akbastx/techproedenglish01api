package techproedenglish01.techproedenglish01ntapi;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import techproedenglish01.techproedenglish01api.TestBase;

public class GetRequest14 extends TestBase {
	
	/*
		 When
		 	I send request to https://restful-booker.herokuapp.com/booking/3
		 Then
		        Status code is 200
		    And Content type is "application/json"
		    And Status line is "HTTP/1.1 200 OK"
		    And First name is Mark
		    And Total price is 198
		    And Deposit paid is true
		    And checkin date is 2019-06-27
		    
		 Do the assertion 1)By using Hard Assertion 2)By using Soft Assertion   	
	*/
	
	@Test
	public void get01() {
		
		spec02.pathParam("bookingid", 3);
		
		Response response = given().spec(spec02).when().get("/{bookingid}");
		response.prettyPrint();
		
		Map<String, Object> map = new HashMap<>();
		map.put("firstname", "Mary");
		map.put("totalprice", 288);
		map.put("depositpaid", false);
		map.put("checkin", "2019-07-10");
		
		response.
		    then().
		    assertThat().
		    statusCode(200).
		    contentType(ContentType.JSON).
		    statusLine("HTTP/1.1 200 OK").
		    body("firstname", Matchers.equalTo(map.get("firstname")),
		    	 "totalprice",Matchers.equalTo(map.get("totalprice")),
		    	 "depositpaid", Matchers.equalTo(map.get("depositpaid")),
		    	 "bookingdates.checkin", Matchers.equalTo(map.get("checkin")));

	}

}
