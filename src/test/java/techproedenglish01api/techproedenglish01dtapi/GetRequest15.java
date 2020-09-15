package techproedenglish01api.techproedenglish01dtapi;

import org.junit.Test;
import io.restassured.response.Response;
import techproedenglish01.techproedenglish01api.TestBaseDt;
import static io.restassured.RestAssured.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetRequest15 extends TestBaseDt {
	
	//GSON 
	
	@Test
	public void get01() {
		
		Response response = given().spec(spec02).when().get();
		response.prettyPrint();
		
		List<Map<String, Double>> listOfMaps = response.as(ArrayList.class); 
		System.out.println(listOfMaps);
		
		response.then().assertThat().statusCode(200);
	}

}
