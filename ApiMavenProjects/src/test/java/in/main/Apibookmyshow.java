package in.main;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.concurrent.locks.AbstractQueuedSynchronizer.ConditionObject;

import in.main.pojoclass.Api;
import in.main.pojoclass.Courses;
import in.main.pojoclass.Mobile;
import in.main.pojoclass.WebAutomation;
import in.main.pojoclass.courseDetails;
public class Apibookmyshow 
{
	public static void main(String[] args)
	{
		
//		String url= "https://rahulshettyacademy.com/getCourse.php?iss=https%3A%2F%2Faccounts.google.com&code=4%2F0Aci98E8ME7gBivN6ShOWiYCuCrpTA6g5GoE7PZ3IVwbdbnIV1_q8Q-IOsSAsJzsuqUZfNg&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";
//		String[]data=url.split("code=");
//		String[]split=data[1].split("&scope");
//		String code=split[0];
//RestAssured.baseURI ="https://rahulshettyacademy.com";
//		
//		String access_response = given().log().all().formParam("code", code)
//		.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
//		.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
//		.formParam("grant_type", "client_credentials")
//	
//		.formParam("scope", "trust")
//		
//		.when().post("/oauthapi/oauth2/resourceOwner/token")
//		.then().log().all().assertThat().statusCode(200).extract().response().asString();
//		
//		
//		JsonPath j  = new JsonPath(access_response);
//		
//		String access_token = j.getString("access_token");
//		
//		System.out.println(access_token);
		
String url = "https://rahulshettyacademy.com/getCourse.php?iss=https%3A%2F%2Faccounts.google.com&code=4%2F0Aci98E8ME7gBivN6ShOWiYCuCrpTA6g5GoE7PZ3IVwbdbnIV1_q8Q-IOsSAsJzsuqUZfNg&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";
		
	String[] data = url.split("code=");
		
		String[] split = data[1].split("&scope");
		
		String code = split[0];
		
		System.out.println(code);
		
		
		RestAssured.baseURI ="https://rahulshettyacademy.com";
		
		String access_response = given().log().all().formParam("code", code)
		.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.formParam("grant_type", "client_credentials")
	
		.formParam("scope", "trust")
		
		.when().post("/oauthapi/oauth2/resourceOwner/token")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		
		JsonPath j  = new JsonPath(access_response);
		
		String access_token = j.getString("access_token");
		
		System.out.println(access_token);
		
//		
//		
//		
		
	courseDetails course = given().log().all().queryParam("access_token", access_token)
		.when().get("oauthapi/getCourseDetails")
		.then().log().all().extract().as(courseDetails.class);
//		
	
	Courses courses = course.getCourses();
	List<Api> api = courses.getApi();
	System.out.println("Course price"+api.get(0).getPrice());
	System.out.println("Course Course Title "+api.get(0).getCourseTitle());
	
	//2.print expected course title price in web Automation
	String expected ="Cypress";
	List<WebAutomation>WebAutomation=courses.getWebAutomation();
	for(WebAutomation webAutomation2:WebAutomation)
	{
		String CourseTitle=webAutomation2.getCourseTitle();
		if(CourseTitle.equals(expected))
		{
			System.out.println("expected ccourse title price "+webAutomation2.getPrice());
			break;
		}
	}
	//3. print the API course title and price present in 2 nd position
	System.out.println("Course Price :"+api.get(1).getPrice());
	System.out.println("Course Course Title "+api.get(1).getCourseTitle());
	
	
	}

 
		
	}


	}

