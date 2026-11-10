package in.main;
import org.testng.annotations.Test;
import in.main.base.GoogleData;
import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import static org.hamcrest.Matchers.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matcher.*;

public class simple {

	public static void main(String[] args) {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		//postmethod
String res=given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json").body(
		(GoogleData.payLoad()))
.when().post("/maps/api/place/add/json")
.then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
.header("Server",equalTo("Apache/2.4.52 (Ubuntu)"))
.extract()
.response()
.asString();
System.out.println(res);
JsonPath j= new JsonPath(res);
String place_id=j.getString("place_id");

System.out.println(place_id);
	}

	
	}

