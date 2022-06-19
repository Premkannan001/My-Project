package org.page;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZalandoRegistrationPage extends BaseClass {
	
    public ZalandoRegistrationPage() {
    	PageFactory.initElements(driver,this);
    }
	@FindBy(xpath="(//input[@id='register.firstname']")
	private WebElement txtusername;
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement txtlastname;
	
	@FindBy(name="register.email")
	private WebElement txtemail;
	
	@FindBy(id=("register.password"))
	private WebElement txtpass;
	
	@FindBy(xpath="//span[text()='No preference']")
	private WebElement clickradiobtn;
	
	@FindBy(xpath="//span[contains(text(),'new products')]")
	private WebElement clickbtn;
	
	@FindBy(xpath="(//button[@type='button'])[3]")
	private WebElement clickregisterbtn;
	
	public WebElement getTxtusername() {
		return txtusername;
	}

	public WebElement getTxtlastname() {
		return txtlastname;
	}

	public WebElement getTxtemail() {
		return txtemail;
	}

	public WebElement getTxtpass() {
		return txtpass;
	}

	public WebElement getClickradiobtn() {
		return clickradiobtn;
	}

	public WebElement getClickbtn() {
		return clickbtn;
	}

	public WebElement getClickregisterbtn() {
		return clickregisterbtn;
	}

}
