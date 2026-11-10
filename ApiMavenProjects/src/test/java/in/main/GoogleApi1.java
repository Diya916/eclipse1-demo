package in.main;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import in.main.base.GoogleData;
public class GoogleApi1 {
	public static void main(String[] args) {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().queryParam("key","qaclick123").header("Content-Type","application/json").
		body(GoogleData.payLoad())
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200);
		

       
				
	}
	

}
