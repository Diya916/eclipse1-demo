package in.main;
import static io.restassured.RestAssured.given;

import in.main.base.GoogleData;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GoogleApi {

	public static void main(String[] args) {
				
		RestAssured.baseURI="https://rahulshettyacademy.com";
				//postmethod
		String res=given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json").body(
				(GoogleData.payLoad()))
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(res);
		JsonPath j= new JsonPath(res);
		String place_id=j.getString("place_id");
		System.out.println(place_id);
		
		//putmethod
		//String updateRes=given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		//.body(
			//	( "{\n" +
				//	    "  \"place_id\":\"" +place_id + "\",\n" +
					//    "  \"address\": \"Basavanagar,Bangalore\",\n" +
					  //  "  \"key\": \"qaclick123\"\n" +
					    //""))
		//.when().put("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200).extract().asString();
		//System.out.println(updateRes);
		//System.out.println("done");
		
		//getmethod	
	//String getRes=given().log().all().queryParam("key", "qaclick123").queryParam("place_id", place_id)
	//.when()
	//.get("/maps/api/place/get/json")   
	
	
	//.then().log().all() .assertThat().statusCode(200).extract().asString();
	//System.out.println(getRes);
	
	//delete method
	//String deleteRes = given().log().all() .queryParam("key", "qaclick123")
		//    .body("{\n" +
		  //        "    \"place_id\": \"" + place_id + "\"\n" +
		    //      "}")
		     //.when()
		    //.delete("/maps/api/place/delete/json")
		    //.then().log().all().assertThat().statusCode(200).extract().asString();
		//System.out.println(deleteRes);
	
	}
}

