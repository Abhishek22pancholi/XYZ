package Board;
import org.testng.annotations.Test;

import apiTest.SetVariable;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BoardGenerator{
	 
	
	@Test
    public static void Post() {
		
		// Setting Variables (Key and Token)
		
		SetVariable.setKey("983795d2919e6a36a8d81579b70683bb");
		SetVariable.setToken("b6d535e2039b04ff0b84883d1921aecc127bd9f82a8f32ed9ba45772aed505d5");
		
		
		//Base URL
		RestAssured.baseURI="https://api.trello.com";
        
		// Creating a Request
        RequestSpecification req=RestAssured.given().queryParam("name", "Assignment").queryParam("key",SetVariable.getKey())
                .queryParam("token",SetVariable.getToken()).header("Content-Type","application/json");
        
        
        
        //Defining Parameters
        Response res1 = req
        		.when()
        			.post("/1/boards/")	//Creating post request
        		.then()
        			.assertThat().statusCode(200).extract().response();
        
        
        // Saving Id to Variables
        String temp =res1.asString();
	    JsonPath jp= new JsonPath(temp);
	    String Id=jp.get("id").toString();	    
	    SetVariable.setIdBoard(Id);

	    
	    // OutPut
	    System.out.println(SetVariable.getIdBoard());
        res1.prettyPeek();
    }


}
