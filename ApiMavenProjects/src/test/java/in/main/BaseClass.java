package in.main;
import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;
public class BaseClass {
public static String jsonResponse(String res,String ID )
{
	JsonPath j=new JsonPath(res);
		String id=j.getString(ID);
	return id;
	
}
public static String createData(String name,String isbn,String aisle,String author) {
	String postPayLoad="{\r\n"
			+ "\"name\":\""+name+"\",\r\n"
			+ "\"isbn\":\""+isbn+"\",\r\n"
			+ "\"aisle\":\""+aisle+"\",\r\n"
			+ "\"author\":\""+author+"\"\r\n"
			+ "}\r\n"
			+ "";
return postPayLoad;
}
public static String  getData(String ID) {
	String get=given().log().all().header("Content-Type","application/json")
			.when().get("Library/GetBook.php?ID="+ID+"")
			.then().log().all().assertThat().statusCode(200).extract().response().asString();
	return get;
			

}
public static  String removeData(String delete) {
	String deletePayLoad = "{\r\n" +
	        "    \"ID\":\"" + delete + "\"\r\n" +
	        "\"\r\n"+
	        
	        "}\r\n\";"
	        + "";
	return deletePayLoad;

}
}


