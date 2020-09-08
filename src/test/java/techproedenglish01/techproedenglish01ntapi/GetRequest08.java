package techproedenglish01.techproedenglish01ntapi;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import techproedenglish01.techproedenglish01api.TestBase;

import static io.restassured.RestAssured.*;

public class GetRequest08 extends TestBase {
	
	/*
	 1)We will print all employee names on the console
	 2)We will print the name of 3rd employee on the console
	 3)We will print first 5 employee names on the console
	 4)We will print the name of last employee on the console
	 */
	
	@Test
	public void get01() {
		
		Response response = given().
				               accept(ContentType.JSON).
				               spec(spec03).
				            when().
				               get();
		response.prettyPrint();
		
		JsonPath json = response.jsonPath();
		
		//Print all employee names on the console
		System.out.println(json.getString("data.employee_name"));
		//Assert that there are 24 employees 
		response.then().assertThat().body("data.employee_name", Matchers.hasSize(24));
		
		/*
		 1)Hard Assertion: When the test fails, it stops execution and create error message
		 2)Soft Assertion: When the test fails, it runs the next tests as well, at the end it creates
		                   report for every assertions. (Verification)
		*/
		
		/*
		 To use Soft Assertion there are 3 steps:
		 1)Create an object from SoftAssert class ==> SoftAssert softAssert = new SoftAssert();
		 2)By using softAssert object use assertion methods
		 3)At the end you HAVE TO use softAssert.assertAll()
		 */

		//Print the name of 3rd employee on the console
		System.out.println(json.getString("data[2].employee_name"));
		System.out.println(json.getString("data.employee_name[2]"));
		
		//Assert the name of the 3rd employee if it is Ashton Cox
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(json.getString("data[2].employee_name"), "Ashton Cox");
		
		//Print the first 5 employee names on the console
		System.out.println(json.getString("data[0,1,2,3,4].employee_name"));
		
		//Next class I will teach how to assert multiple assertions, please remind me!!!!!
		
		//Print the name of last employee on the console
		System.out.println(json.getString("data[-1].employee_name"));
		
		//Assert the name of last employee is Doris Wilder
		softAssert.assertEquals(json.getString("data[-1].employee_name"), "Doris Wilder");
		softAssert.assertAll();
	
	}

}
