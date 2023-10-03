package Board;

import org.testng.annotations.Test;

import apiTest.SetVariable;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteBoard {
	
	@Test
	public void del()
	{
		
		RestAssured.baseURI="https://api.trello.com/1/boards/"+SetVariable.getIdBoard()+"?key="+SetVariable.getKey()+"&token="+SetVariable.getToken();
		
		RequestSpecification req= RestAssured.given();
		 
		 Response res1 = req.when().delete(RestAssured.baseURI);
		 
		 res1.prettyPeek();
	}

}
