package Card;

import org.testng.annotations.Test;

import apiTest.SetVariable;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateCard {
	
	@Test
	public void post()
	{
		
//		Base URL
		RestAssured.baseURI="https://api.trello.com/1/cards?idList="+SetVariable.getIdList();
				
		//Input Data
		String data="{\"name\" : \"Card\"}";
				
		
//		Creating Parameters
		        RequestSpecification req=RestAssured.given().queryParam("key",SetVariable.getKey())
		    			.queryParam("token",SetVariable.getToken());
		        //3
		        Response res1 = req.header("Content-Type","application/json")
		        		.body(data)
		        		.when()
		        			.post(RestAssured.baseURI)	//Creating post request
		        		.then()
		        			.assertThat().statusCode(200).extract().response();
		        
//				Storing Data in String
			 	String temp =res1.asString();
			    JsonPath jp= new JsonPath(temp);
			    String IdCard=jp.get("id");
			    
			    SetVariable.setIdCard(IdCard);
			    
			    
			    System.out.println(SetVariable.getIdCard());
			    
		        
		        
//				Output
		        res1.prettyPeek();
		
		
		
	}
}
