package jbk.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage 
{
	WebDriver driver;
	
	public IndexPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//b")
		WebElement boldText;
	
	@FindBy(xpath="//a/h4")
		WebElement text2;
	
	@FindBy(tagName="p")
		WebElement text3;
	
	@FindBy(partialLinkText="Register")
		WebElement register;
	
	@FindBy(id="email")
		WebElement uname;
	
	@FindBy(id="password")
		WebElement pass;
	
	@FindBy(xpath="//button")
		WebElement button;
	
	@FindBy(linkText="LOGOUT")
		WebElement logoutButton;
	
	@FindBy(id="email_error")
		WebElement emailError;
	
	@FindBy(id="password_error")
		WebElement passwordError;
	
	public String boldText()
	{
		return boldText.getText();
	}
	public void clickBoldText()
	{
		boldText.click();
	}
	public void clickCoursesText()
	{
		text2.click();
	}
	public String coursesText()
	{
		return text2.getText();
	}
	public String headingText()
	{
		return text3.getText();
	}
	public String registerText()
	{
		return register.getText();
	}
	public RegisterPage clickToRegister()
	{
		register.click();
		return new RegisterPage(driver);
	}
	public void enterUserName(String text)
	{
		uname.clear();
		uname.sendKeys(text);
	}
	public void enterPassword(String text)
	{
		pass.clear();
		pass.sendKeys(text);
	}
	public DashboardPage clickLoginButton()
	{
		button.click();
		return new DashboardPage(driver);
	}
	public void clickLogoutButton()
	{
		logoutButton.click();
	}
	public String emailErrorText()
	{
		return emailError.getText();
	}
	public String passwordErrorText()
	{
		return passwordError.getText();
	}
	
	@FindBy(tagName="img")
		WebElement logo;
	public WebElement getLogo()
	{
		return logo;
	}
}
