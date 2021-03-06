package TechProEd.Spring2020;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;

public class GetRequest13 {

	//How to read/assert data from local Json File
	@Test
	public void getTestLocal() {
		
		JsonPath jsonLocal = new JsonPath(new File("/Users/apple/Desktop/Employee.json"));
		SoftAssert softAssert = new SoftAssert();
		
		//Get all employee salaries from the Employee file. Print them on the console.
		List<String> salaryList = jsonLocal.getList("data.employee_salary");
		System.out.println(salaryList);
		//Assert that maximum salary is 725,000
		List<Integer> salaryListInt = new ArrayList<>();
		
		for(int i=0; i<salaryList.size(); i++) {
			salaryListInt.add(Integer.valueOf(salaryList.get(i)));
		}
		
		Collections.sort(salaryListInt);
		System.out.println(salaryListInt);
		softAssert.assertTrue(salaryListInt.get(salaryListInt.size()-1)==725000);

	}
}
