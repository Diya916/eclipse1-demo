package in.main;
import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import in.main.base.GoogleData;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
public class Handling {
	@Test
	private void addBooks() {
		RestAssured.baseURI="http://216.10.245.166";
		//post
		String res=given().log().all().header("Content-Type","application/json")
		.body(BaseClass.createData("javabook","isbn","JAB","kanmani"))
				
		.when().post("Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		String jsonResponse=BaseClass.jsonResponse(res, "ID");
		
		System.out.println(jsonResponse);
		Assert.assertFalse(jsonResponse.isEmpty(),"Book is Posted");
		
		//GET
		String data=BaseClass.getData(jsonResponse);
		String jsonResponse1=BaseClass.jsonResponse(data, "author[0]");
		Assert.assertEquals(jsonResponse1, "Abdul");
		
		
		//DELETE
		String del=given().log().all().header("Content-Type","application/json")
				.body(BaseClass.createData("javabook","isbn","JAB","kanmani"))
				
				.when().post("Library/Addbook.php")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
				String jsonResponse2=BaseClass.jsonResponse(del, "msg");
				
				System.out.println(jsonResponse2);
				Assert.assertEquals(jsonResponse2,"book is successfully deleted");

	}

}
