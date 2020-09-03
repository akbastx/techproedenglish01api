package techproedenglish01api.techproedenglish01dtapi;

import org.junit.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import techproedenglish01.techproedenglish01api.TestBaseDt;
import static io.restassured.RestAssured.*;

public class GetRequest10 extends TestBaseDt {
	
	/*
	 When 
		 I send a GET request to REST API URL
		 https://restful-booker.herokuapp.com/booking/5 
	 Then 
		 HTTP Status Code should be 200
		 And response content type is “application/JSON” 
		 And response body should be like; 
		 {
		  "firstname": "Sally", 
		  "lastname": "Ericsson", 
		  "totalprice": 111,
		  "depositpaid": false, 
		  "bookingdates": { "checkin": "2017-05-23", 
		                    "checkout":"2019-07-02" }
	     }
	*/
	
	/*
	 JSONPATH: JsonPath is used to navigate in Json Data
	*/
	
	@Test
	public void get01() {
		
		spec02.pathParam("bookingid", 5);
		Response response = given().spec(spec02).when().get("/{bookingid}");
		response.prettyPrint();
		
		JsonPath json = response.jsonPath();
		
		//Print the firstname on the console
		System.out.println(json.getString("firstname"));
		
		
		//Print the lastname on the console
		System.out.println(json.getString("lastname"));
		
		
		//Print the totalprice on the console
		System.out.println(json.getInt("totalprice"));
		
		
		//Print the depositpaid on the console
		System.out.println(json.getBoolean("depositpaid"));
		
		
		//Print the checkin on the console
		System.out.println(json.getString("bookingdates.checkin"));
		
		
		//Print the checkout on the console
		System.out.println(json.getString("bookingdates.checkout"));
		
		//Print the additionalneeds on the console
		System.out.println(json.getString( "additionalneeds"));
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
