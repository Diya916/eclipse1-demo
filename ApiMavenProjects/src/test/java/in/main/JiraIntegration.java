package in.main;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import  static io.restassured.RestAssured.*;

public class JiraIntegration {
	
	public static void main(String[] args) {
		RestAssured.baseURI = "https://mkanmanisupm-1775055532200.atlassian.net";
		String access_token="ATATT3xFfGF0xuLUThobLvOPB0Ul4z8RZs416s3O8y7cHlVTUY-S8h_o6y6RQCBURhR46aqAr7dR0Z3FMcXa44cHOcJysrySCFWbEw-hkfzgFIqNGeF3KhSCkfGJf-26kbD59j0d_mlzatMaQs8YJ4Clcz2Dz52BEKq2Y-G81mbdow_I9wvQ5vQ=8189B55E";
		String post = given().log().all().auth().preemptive().basic("m.kanmani.supm@gmail.com", access_token).header("Content-Type","application/json").
				body("{    \"fields\": {\r\n"
						+ "                \"project\": {\r\n"
						+ "                    \"key\": \"NURD2R\"\r\n"
						+ "                },\r\n"
						+ "                \"summary\": \"Login button is not working\",\r\n"
						+ "                \"description\": \"Button issue\",\r\n"
						+ "                \"issuetype\": {\r\n"
						+ "                    \"name\": \"Bug\"\r\n"
						+ "                } \r\n"
						+ "}}").when().post("/rest/api/2/issue").then().log().all().assertThat().statusCode(201).extract().response().asString();
		
	}

}
