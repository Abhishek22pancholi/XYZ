package Board;

import org.testng.annotations.Test;

import apiTest.SetVariable;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetBoard {
	
	@Test
	public void get() {
		
		//Base URL
		RestAssured.baseURI="https://api.trello.com/1/boards/";
		
		//// Creating a Request
        RequestSpecification req=RestAssured.given().queryParam("key",SetVariable.getKey())
    			.queryParam("token",SetVariable.getToken());
        
        //Defining Parameters
        Response res1 = req.header("Content-Type","application/json")
        		.when()
        			.get(RestAssured.baseURI+SetVariable.getIdBoard()+"/lists")	//Creating get request
        		.then()
        			.assertThat().statusCode(200).extract().response();
        
        // OutPut
        res1.prettyPeek();
	}
	
}
