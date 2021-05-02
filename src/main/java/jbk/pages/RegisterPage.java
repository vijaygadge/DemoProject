package jbk.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage 
{
	WebDriver rpdriver;
	
	public RegisterPage(WebDriver driver)
	{
		rpdriver=driver;
		PageFactory.initElements(rpdriver,this);
	}
	
	@FindBy(xpath="//b")
		WebElement boldText;
	
	@FindBy(tagName="p")
		WebElement text3;
	
	@FindBy(id="name")
		WebElement name;
	
	@FindBy(id="mobile")
		WebElement mobileNo;
	
	@FindBy(id="email")
		WebElement email;
	
	@FindBy(id="password")
		WebElement password;
	
	@FindBy(partialLinkText="membership")
		WebElement alreadyReg;
	
	@FindBy(xpath="//button")
		WebElement signIn;
	
	@FindBy(xpath="//div[@id='name_error']")
		WebElement nameError;

	@FindBy(id="mobile_error")
		WebElement mobileNoError;
	
	@FindBy(id="email_error")
		WebElement emailError;
	
	@FindBy(id="password_error")
		WebElement passwordError;

	public String boldText()
	{
		return boldText.getText();
	}
	public String headingText()
	{
		return text3.getText();
	}
	public void enterName(String text)
	{
		name.clear();
		 name.sendKeys(text);
	}
	public void enterMobileNo(String text)
	{
		mobileNo.clear();
		 mobileNo.sendKeys(text);
	}
	public void enterEmail(String text)
	{
		email.clear();
		 email.sendKeys(text);
	}
	public void enterPassword(String text)
	{
		password.clear();
		 password.sendKeys(text);
	}
	public void clickToSignIn()
	{
		 signIn.click();
	}
	public String alreadyRegText()
	{
		return alreadyReg.getText();
	}
	public void clickAlreadyReg()
	{
		alreadyReg.click();
	}
	
	public String nameError()
	{
		 return nameError.getText();
	}
	public String mobileNoError()
	{
		return mobileNoError.getText();
	}
	public String emailError()
	{
		return emailError.getText();
	}
	public String passwordError()
	{
		return passwordError.getText();
	}
	public void clearFields()
	{
		name.clear();
		mobileNo.clear();
		email.clear();
		password.clear();
	}
	
	@FindBy(tagName="img")
		WebElement logoImage;
	public WebElement getIMG() 
	{
		return logoImage;
	}
}
