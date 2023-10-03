package Board;

import org.testng.annotations.Test;

import apiTest.SetVariable;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateListonBoard {
	
	@Test
	public void Post() {

//		Base URL
		RestAssured.baseURI="https://api.trello.com/1/boards/";
		
		//Input Data
				String data="{\"name\" : \"List\"}";
				
//		Creating Parameters
				RequestSpecification req= RestAssured.given().queryParam("key",SetVariable.getKey())
		    			.queryParam("token",SetVariable.getToken());
				 
				 Response res1 = req.header("Content-Type","application/json")
						 		.body(data)
						 		.when().post(RestAssured.baseURI+SetVariable.getIdBoard()+"/lists");	//Creating post request
				 
//		Storing Data in String
			 	String temp =res1.asString();
			    JsonPath jp= new JsonPath(temp);
			    String IdList=jp.get("id");
			    
			    SetVariable.setIdList(IdList);
			    
			    
			    System.out.println(SetVariable.getIdList());
			    
//		Output		 
				res1.prettyPeek();
	}
	
	
}
