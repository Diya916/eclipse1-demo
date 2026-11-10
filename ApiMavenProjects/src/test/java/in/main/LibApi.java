package in.main;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import in.main.base.GoogleData;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
public class LibApi {
	@Test(dataProvider="datas")
	
public void addBookds(String Bookname,String isbn,String aisle,String author) {
	// TODO Auto-generated method stub
RestAssured.baseURI="http://216.10.245.166";
String res=given().log().all().header("Content-Type","application/json")
.body(GoogleData.addData("Bookname","isbn","aisle","author"
		+ ""))
.when().post("Library/Addbook.php")
.then().log().all().assertThat().statusCode(200).extract().response().asString();
JsonPath j=new JsonPath(res);
String id=j.get("ID");
System.out.println(id);
		
}
	@DataProvider(name="datas")
	public Object  addBooksData() {
		return new Object[][]
				{
	
		{"Java","bca","345","kanmani"},
		{"selenium","mca","123","Raj"}

				};
}}
