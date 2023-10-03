package Card;

import org.testng.annotations.Test;

import apiTest.SetVariable;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteCard {

	@Test
	public void del()
	{
		
//		Base URL
		RestAssured.baseURI="https://api.trello.com/1/cards/";
		
		//Input Data
		RequestSpecification req= RestAssured.given().queryParam("key",SetVariable.getKey())
	 			.queryParam("token",SetVariable.getToken());
		 
		 Response res1 = req.when().delete(RestAssured.baseURI+SetVariable.getIdCard());
		 
		 
//			Output
		 res1.prettyPeek();
	}
}
