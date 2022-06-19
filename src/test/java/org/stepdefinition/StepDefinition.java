package org.stepdefinition;

import java.awt.Desktop.Action;

import org.base.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.page.ZalandoRegistrationPage;

import io.cucumber.java.en.*;

public class StepDefinition extends BaseClass{
	WebDriver driver;
	ZalandoRegistrationPage r;
	@Given("the user should be in zalando application page and handle with alerts")
	public void the_user_should_be_in_zalando_application_page_and_handle_with_alerts() {
	   browserLaunch("chrome");
	   urlLaunch("https://www.zalando.co.uk/collections/smYHsQgTS3u/");
	   maximize();
	   implicitlyWait(10);
	   Alert b=driver.switchTo().alert();
		WebElement alerts = driver.findElement(By.xpath("//button[@id='uc-btn-accept-banner']"));
		alerts.click();
	}

	@Given("The User Has To click registernow button")
	public void the_User_Has_To_click_registernow_button() {
		Actions a=new Actions(driver);
		driver=new ChromeDriver();
		WebElement moveto = driver.findElement(By.xpath("//a[@title='Login']"));
		a.moveToElement(moveto);
		WebElement clickbtn = driver.findElement(By.xpath("//span[text()='Register now']"));
		clickbtn.click();
		
	}

	@When("The User Has To Fill Firstname and Last name")
	public void the_User_Has_To_Fill_Firstname_and_Last_name() {
		r=new ZalandoRegistrationPage();
		 sendKeys(r.getTxtusername(),"prem");
		 sendKeys(r.getTxtlastname(), "kumar");  
	}

	@When("The User Has To Fill EmailAddress and Password")
	public void the_User_Has_To_Fill_EmailAddress_and_Password() {
		sendKeys(r.getTxtemail(), "premkannan@gmail.com");
		sendKeys(r.getTxtpass(), "8778");    
	}

	@When("The User Has To Select Radio button")
	public void the_User_Has_To_Select_Radio_button() {
	   click(r.getClickradiobtn());
	}

	@When("The User Has To Click Box buttton")
	public void the_User_Has_To_Click_Box_buttton() {
		click(r.getClickbtn());
	   
	}

	@Then("The user has to click register button")
	public void the_user_has_to_click_register_button() {
		click(r.getClickregisterbtn());
	   
	}



}
