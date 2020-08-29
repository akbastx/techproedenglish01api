package techproedenglish01.techproedenglish01api;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    @Test
	public void getMethod01() {
		
		Response response = given().
				            when().
				               get("https://restful-booker.herokuapp.com/booking");	
		response.prettyPrint();
		System.out.println(response.getStatusCode());
		response.
		     then().
		     assertThat().
		     statusCode(200).
		     contentType(ContentType.JSON);
	
	}
	
	@Test
	public void getMethod02() {
		
		Response response = given().when().get("https://restful-booker.herokuapp.com/booking/3");		
		System.out.println(response.statusCode());		
		response.prettyPrint();
		response.
			then().
			assertThat().
			statusCode(200).
			contentType(ContentType.JSON);
		
	}
	
	@Test
	public void getMethod03() {
		
		Response response = given().
				               accept(ContentType.JSON).
				            when().
				               get("https://restful-booker.herokuapp.com/booking");		
		response.
		    then().
		    assertThat().
		    statusCode(200).
		    contentType(ContentType.JSON);
	}
	
	@Test
	public void getMethod04() {
		
		Response response = given().
							when().
								get("https://restful-booker.herokuapp.com/booking/5");
		response.
			then().
			assertThat().
			statusCode(200).
			contentType(ContentType.JSON);	
	}
	
	@Test
	public void getMethod05() {
		Response response = given().
				            when().
				            get("https://restful-booker.herokuapp.com/booking/1001");		
		response.prettyPrint();		
		response.then().assertThat().statusCode(404);		
		assertFalse(response.asString().contains("Suleyman"));		
		assertTrue(response.asString().contains("Not FoundXXXX"));	
	}

}
