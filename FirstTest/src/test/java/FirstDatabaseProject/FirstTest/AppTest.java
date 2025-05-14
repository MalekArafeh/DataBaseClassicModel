package FirstDatabaseProject.FirstTest;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.utility.JavaConstant.Dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




 
public class AppTest {
  
 
Connection con;
 
Statement stmt;
 
ResultSet rs;
String custamerName;
String custamerLName;
String EmailAddress;
String city;
String postalcode;


WebDriver driver=new ChromeDriver();
 
 String url="https://smartbuy-me.com/ar/account/register";
@BeforeTest
public void Setup() throws SQLException {
	con = DriverManager.getConnection("jdbc:mysql://localhost:3307/classicmodels", "root", "1234");
	driver.get(url);
	
	driver.manage().window().maximize();

}
 
 
 
@Test
public void readdata() throws SQLException {
	
	String query="SELECT * FROM customers WHERE customerNumber = 363";
	stmt=con.createStatement();
	rs=stmt.executeQuery(query);
	while(rs.next()) {
		custamerName=rs.getNString("contactFirstName");
		custamerLName=rs.getNString("contactLastName");
		city=rs.getNString("city");
		postalcode=rs.getNString("postalCode");

System.out.println(custamerName);	
	}		
				
driver.findElement(By.id("customer[first_name]")).sendKeys(custamerName);
driver.findElement(By.id("customer[last_name]")).sendKeys(custamerLName);
EmailAddress=custamerName+custamerLName+"@gmail.com";
driver.findElement(By.id("customer[email]")).sendKeys(EmailAddress);
driver.findElement(By.id("customer[password]")).sendKeys(city+postalcode);
	
	}
 
 
}
 