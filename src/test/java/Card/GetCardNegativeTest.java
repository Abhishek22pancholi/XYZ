package Card;

import org.testng.annotations.Test;

import apiTest.SetVariable;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetCardNegativeTest {
	
	@Test
	public void Get()
	{	
		
//		Base URL
		RestAssured.baseURI="https://api.trello.com/1/cards/";
				
//		Creating Parameters
		        RequestSpecification req=RestAssured.given().queryParam("key",SetVariable.getKey())
		    			.queryParam("token",SetVariable.getToken());
		        
		        
		        Response res1 = req.header("Content-Type","application/json")
		        		.when()
		        			.get(RestAssured.baseURI+"0028009e9ccb000016004100")	//Creating get request
		        		.then()
		        			.assertThat().statusCode(404).extract().response();
		        
		        
//				Output
		        res1.prettyPeek();
		
	}

}
