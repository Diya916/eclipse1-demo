package in.main;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;

public class Validation {
public static void main(String[] args) {
	
	String res= "{\n" +
			"  \"dashboard\": {\n" +
			"    \"purchaseAmount\": 910,\n" +
			"    \"website\": \"rahulshettyacademy.com\"\n" +
			"  },\n" +
			"  \"courses\": [\n" +
			"    {\n" +
			"      \"title\": \"Selenium Python\",\n" +
			"      \"price\": 50,\n" +
			"      \"copies\": 6\n" +
			"    },\n" +
			"    {\n" +
			"      \"title\": \"Cypress\",\n" +
			"      \"price\": 40,\n" +
			"      \"copies\": 4\n" +
			"    },\n" +
			"    {\n" +
			"      \"title\": \"RPA\",\n" +
			"      \"price\": 45,\n" +
			"      \"copies\": 10\n" +
			"    }\n" +
			"  ]\n" +
			"}";
	
	//1.Print no of courses returned by API
	JsonPath j=new JsonPath(res);
	int n=j.getInt("courses.size()");
	System.out.println("Number of courses "+n);
	
	//2. print the purchase
	int ps=j.getInt("dashboard.purchaseAmount");
	System.out.println("Purchase amount "+ps);
	
	//3.print the Title of the First course
	String title =j.getString("courses[0].title");
	System.out.println("Title:  " +title);
	//4. print all courses title and their respective prices
	for(int i=0;i<n;i++)
	{
		String title1=j.getString("courses["+i+"].title");
		int price=j.getInt("courses["+i+"].price");
		System.out.println("Title:  "+title1);
		System.out.println("Price: "+price);
				
	}
	//Print the no of copies sold by RPA
	for(int i=0;i<n;i++)
	{
		String title2=j.getString("courses["+i+"].title");
		if(title.equalsIgnoreCase("RPA"))
		{
			int copies=j.getInt("courses["+i+"].title");
			System.out.println("Copies: "+copies);
			break;
		}
	}
	//5.Verify if sum of all courseprices match with the purchase amount
	int totalamt=0;
	for(int i=0;i<n;i++)
	{
		int price=j.getInt("courses["+i+"].price");
		int copies=j.getInt("courses["+i+"].copies");
		int cost=price*copies;
		totalamt=cost+totalamt;
				
	}
	System.out.println("Total amt "+totalamt);
	Assert.assertEquals(totalamt, ps);
	System.out.println("Sum of prices equals purchase amount");
}
}
