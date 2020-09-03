package techproedenglish01.techproedenglish01ntapi;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import io.restassured.response.Response;
import techproedenglish01.techproedenglish01api.TestBase;

import static io.restassured.RestAssured.*;

public class GetRequest06 extends TestBase {
	
	/*
	 Among the data there should be someone whose first name is Jim
	 URL: https://restful-booker.herokuapp.com/booking 
	*/
	
	@Test
	public void get01() {
		
		spec02.queryParam("firstname", "Jim");
		spec02.queryParam("lastname", "Jackson");
		
		Response response = given().spec(spec02).when().get();
		response.prettyPrint();
		
		response.
		    then().
		    assertThat().
		    statusCode(200);
		
		assertTrue(response.asString().contains("bookingid"));
		
	}

}
