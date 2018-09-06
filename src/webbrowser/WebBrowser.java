package webbrowser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class WebBrowser {
	public static void main(String [] args) {
		 File file = new File("C:\\Users\\ctr20\\Desktop\\geckodriver.exe");

		System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());


		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://seanet.uncw.edu/TEAL/twbkwbis.P_GenMenu?name=homepage");
		
		WebElement link;
		
		link = driver.findElement(By.linkText("Search for Courses"));
		link.click();
		
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		WebElement mySelectElement = driver.findElement(By.id("term_input_id"));
		Select dropdown = new Select(mySelectElement);
		dropdown.selectByVisibleText("Fall 2018");
		
		WebElement clickNextButton = driver.findElement(By.tagName("form"));
		clickNextButton.submit();
		
		try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		

		
		WebElement secondSelect;		
		secondSelect = driver.findElement(By.id("subj_id"));
		
		Select secondDropDown = new Select(secondSelect);
		
		List<WebElement> options = secondDropDown.getOptions();
		
		for(WebElement we : options) {
			String str = we.getText();
			secondDropDown.selectByVisibleText(str);
		}
		
		clickNextButton = driver.findElement(By.tagName("form"));
		clickNextButton.submit();
		
		while (!(driver.getCurrentUrl().equals("https://seanet.uncw.edu/TEAL/swkfccl.P_GetCrse"))){
			
		}
		
		
		try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
				
		
		String str = driver.getPageSource();
		BufferedReader bufread = new BufferedReader(new StringReader(str));
		
		try {
			BufferedWriter write = new BufferedWriter(new FileWriter("Resource/Classes"));
			String line = null;
			while((line = bufread.readLine()) != null) {
				write.write(line);
				write.newLine();
				write.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		String a = "Ass";
		System.out.println(a);
		
	}
}
