package techproedenglish01.techproedenglish01ntapi;

import org.json.JSONObject;
import org.junit.Test;
import io.restassured.response.Response;
import techproedenglish01.techproedenglish01api.TestBase;
import static io.restassured.RestAssured.*;

public class PostRequest04 extends TestBase {
	
	@Test
	public void post01() {
		
		//If an API does not let you to create a new data you will get 404, 405 status code
		/*
		 {
            "id": "17",
            "employee_name": "Paul Byrd",
            "employee_salary": "725000",
            "employee_age": "64",
            "profile_image": ""
         }
		*/
		
		JSONObject reqBody = new JSONObject();
		reqBody.put("id", "17");
		reqBody.put("employee_name", "Paul Byrd");
		reqBody.put("employee_salary", "725000");
		reqBody.put("employee_age", "64");
		reqBody.put("profile_image", "");
		
		Response response = given().
				               spec(spec03).
				               body(reqBody).
				            when().
				               post();
		response.prettyPrint();
		
		response.
		     then().
		     assertThat().
		     statusCode(405);
		
	}

}
