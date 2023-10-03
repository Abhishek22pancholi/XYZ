package Card;

import org.testng.annotations.Test;

import apiTest.SetVariable;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateCard {

	@Test
	public static void Put()
	{

//		Base URL
		RestAssured.baseURI="https://api.trello.com/1/cards/";
		
		//Input Data
		String data="{\"name\" : \"RestAssured\"}";
		
		
//		Creating Parameters
			 RequestSpecification req= RestAssured.given().queryParam("key",SetVariable.getKey())
		 			.queryParam("token",SetVariable.getToken());
					 
			 Response res1 = req.header("Content-Type","application/json")
					 			.body(data)
					 			.when().put(RestAssured.baseURI+SetVariable.getIdCard());
     
			 
//				Output
			 res1.prettyPeek();
	}
}
