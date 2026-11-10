package in.main;
import in.main.pojoclass.LoginDetails;
import in.main.pojoclass.LoginForm;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import java.io.File;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.http.ContentType;
import io.restassured.specification.RedirectSpecification;
import io.restassured.specification.RequestSpecification;


public class Ecommerce {

	public static void main(String[] args) {
		
		
		LoginForm l=new LoginForm();
		l.setUserEmail("kanmanisupm91@gmail.com");
		l.setUserPassword("KanmaniDiya@123");
		RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com"
				+ "").setContentType(ContentType.JSON).build();
		RequestSpecification body=given().log().all().spec(req).body(l);
		LoginDetails response=body.when().post("/api/ecom/auth/login").then().log().all().assertThat().statusCode(200).extract().response().as(LoginDetails.class);
		String token=response.getToken();
		String userId=response.getUserId();
		File f=new File("C:\\Users\\hp\\Downloads\\cap.jpg");
		RequestSpecification addProduct = new RequestSpecBuilder()
			    .setBaseUri("https://rahulshettyacademy.com")
			    .addHeader("Authorization", token)
			    .setContentType(ContentType.MULTIPART)   // ✅ ADD THIS LINE
			    .build();
RequestSpecification data=given().log().all().spec(addProduct).formParam("productName","cap")
.formParam("productedAddedBy",userId).formParam("productCategory","fashion").formParam("productSubCategory","access").formParam("productPrice", "250").formParam("productDescription", "menscap")
	.formParam("productfor", "men").multiPart("productImage",f);
String asString=data.when().post("/api/ecom/product/add-product").then().log().all().assertThat().statusCode(201).extract().response().asString();
JsonPath j= new JsonPath(asString);
String message=j.getString("message");
System.out.println("Response Message:"+message);

	}
}

