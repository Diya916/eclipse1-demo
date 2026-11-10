package in.main.base;

public class GoogleData {
public static String payLoad() {
	String data = "{\n" +
			"  \"location\": {\n" +
			"    \"lat\": -38.383494,\n" +
			"    \"lng\": 33.427362\n" +
			"  },\n" +
			"  \"accuracy\": 50,\n" +
			"  \"name\": \"Frontline house\",\n" +
			"  \"phone_number\": \"(+91) 983 893 3937\",\n" +
			"  \"address\": \"29, side layout, cohen 09\",\n" +
			"  \"types\": [\n" +
			"    \"shoe park\",\n" +
			"    \"shop\"\n" +
			"  ],\n" +
			"  \"website\": \"http://google.com\",\n" +
			"  \"language\": \"French-IN\"\n" +
			"}";
	return data;

}


	
public static String addData(String bookname,String isbn,String aisle,String author) 
{
	String adPayLoad="{\n" +
		    "    \"name\":\""+bookname+"\",\n" +
		    "    \"isbn\":\""+isbn+"\",\n" +
		    "    \"aisle\":\""+aisle+"\",\n" +
		    "    \"author\":\""+author+"lenin\"\n" +
		    "}";

return adPayLoad;
}

}
