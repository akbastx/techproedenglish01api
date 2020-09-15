package techproedenglish01api.techproedenglish01dtapi;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import techproedenglish01.techproedenglish01api.TestBaseDt;

public class DeleteRequest01 extends TestBaseDt {
	/*
	 When 
	   I send DELETE Request to http://dummy.restapiexample.com/api/v1/update/2
	 Then 
	   Status code is 429
	   "status" key has value "success"
	   "message" key has value "Successfully! deleted Records."  
	*/
	
	@Test
	public void delete01() {
		
		spec04.pathParams("delete","delete",
		                   "id", 3);
		
		Response response = given().spec(spec04).when().delete("/{delete}/{id}");
		response.prettyPrint();
		
		response.
		     then().
		     assertThat().
		     statusCode(200).
		     body("status", Matchers.equalTo("success"),
		    	  "message", Matchers.equalTo("Successfully! Record has been deleted"));
	}
}
