import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class jdbcconnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		String host = "localhost";
		String port ="3306";
		Connection con= DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/loginid", "root", "Ramana@0905");
		
		
		Statement s= con.createStatement();
		ResultSet rs= s.executeQuery("select * from credentials where scenario ='validlogin'");
		while(rs.next()) {
			
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys(rs.getString("username"));
		driver.findElement(By.id("password")).sendKeys(rs.getString("password"));
		System.out.println(rs.getString("username"));
		System.out.println(rs.getString("password"));
		}
		
	}

}
