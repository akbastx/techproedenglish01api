package techproedenglish01.techproedenglish01ntapi;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;

public class GetRequest13 {
	
	//How to work with Json Data in our local computer
	
	@Test
	public void get01() {
		
		JsonPath json = new JsonPath(new File("/Users/apple/Desktop/Employee.json"));
		SoftAssert softAssert = new SoftAssert();
		
		//Assert that maximum salary is 725,000
		List<String> salaryList = json.getList("data.employee_salary");
		System.out.println(salaryList);
		
		List<Integer> salaryListInt = new ArrayList<>();
		for(String w : salaryList) {
			salaryListInt.add(Integer.valueOf(w));
		}
		System.out.println(salaryListInt);
		
		Collections.sort(salaryListInt);
		System.out.println(salaryListInt);
		
		softAssert.assertTrue(salaryListInt.get(salaryListInt.size()-1)==725000);
		
		System.out.println("===================================");
		
		//Assert that minimum age is 19
		List<String> ageList = json.getList("data.employee_age");
		System.out.println(ageList);
		
		List<Integer> ageListInt = new ArrayList<>();
		
		for(String w : ageList) {
			ageListInt.add(Integer.valueOf(w));
		}
		System.out.println(ageListInt);
		
		Collections.sort(ageListInt);
		System.out.println(ageListInt);
		
		softAssert.assertTrue(ageListInt.get(0)==19);

		softAssert.assertAll();
	}
}
