package techproedenglish01api.techproedenglish01dtapi;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import techproedenglish01.techproedenglish01api.TestBaseDt;

public class PutRequest01 extends TestBaseDt {
	
	/*
	 When 
	   I send PUT Request to http://dummy.restapiexample.com/api/v1/update/2
	 Then 
	   Status code is 200
	   Content Type is "application/json"
	   "status" key has value "success"
	   "message" key has value "Successfully! Record has been updated."
	   
	 Note: Create Request Body in 3 different ways  
	 */
	
	@Test
	public void put01() {
		
		spec04.pathParams("update","update",
				          "id", 3);
		
		//1.Way: To create Request Body use String variable
		//String reqBody = "{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}";
		
		//2.Way: To create Request Body use JSONObject Class
		//JSONObject reqBody = new JSONObject();
		//reqBody.put("name", "Suleyman");
		//reqBody.put("salary", "111");
		//reqBody.put("age", "33");
		
		//3.Way: To create Request Body use HashMap
		Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("name", "Suleyman");
		reqBody.put("salary", "111");
		reqBody.put("age", "33");
		
		Response response = given().spec(spec04).body(reqBody.toString()).when().put("/{update}/{id}");
		response.prettyPrint();
		
		response.
		     then().
		     assertThat().
		     statusCode(200).
		     contentType(ContentType.JSON).
		     body("status", Matchers.equalTo("success"),
		    	  "message", Matchers.equalTo("Successfully! Record has been updated."));
	}


}
