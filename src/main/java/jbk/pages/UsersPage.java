package jbk.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage 
{
	WebDriver driver;
	public UsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@href='users.html']")
	WebElement usersPageLink;
	public void clickOnUserPageLink()
	{
		 usersPageLink.click();
	}

	@FindBy(xpath="//h1[normalize-space(text()) ='Users']")
		WebElement heading;
	public String headingText()
	{
		return heading.getText();
	}
	
	@FindBy(xpath="//ol[@class='breadcrumb']")
		WebElement olTagText;
	public String olTagText()
	{
		return olTagText.getText();
	}
	
	@FindBy(linkText="Home")
		WebElement clickHome;
	public void clickHome()
	{
		clickHome.click();
	}
	
	@FindBy(xpath="//b[text()='Java By Kiran']")
		WebElement jbkText;
	public String jbkText()
	{
		return jbkText.getText();
	}
	public void clickjbkText()
	{
		jbkText.click();
	}
	
	@FindBy(xpath="//aside[@class='main-sidebar']")
		WebElement navBar;
	public String LHSNavBar()
	{
		return navBar.getText();
	}
	
	@FindBy(partialLinkText="Online")
		WebElement onlineText;
	public void clickOnlineText() 
	{
		onlineText.click();
	}
	
	@FindBy(xpath="//footer[@class='main-footer']")
		WebElement footer;
	public String verifyFooter()
	{
		return footer.getText();
	}
	
	@FindBy(xpath="//a[text()='JavaByKiran']")
		WebElement footerLink;
	public void clickFooter()
	{
		footerLink.click();
	}
	
	@FindBy(xpath="//a[text()='LOGOUT']")
		WebElement logout;
	public String verifyLogout()
	{
		return logout.getText();
	}
	public void clickLogout()
	{
		logout.click();
	}
	
	@FindBy(xpath="//h3[@class='box-title']")
		WebElement h3;
	public String verifyUserListText()
	{
		return h3.getText();
	}
	
	@FindBy(xpath="//a[@href='add_user.html']//button")
		WebElement addUser;
	public String verifyAddUserText()
	{
		return addUser.getText();
	}
	public AddUserPage clickAddUser()
	{
		addUser.click();
		return new AddUserPage(driver);
	}
	
	@FindBy(xpath="//table//tr[2]//td[8]/a/span")
		WebElement delete;
	public String verifydeleteText()
	{
		return delete.getText();
	}
	public void clickDelete()
	{
		delete.click();
	}
	
	@FindBy(xpath="//table//tr[5]//td[8]//a//span")
	WebElement delete4thUser;
	public void clickDeleteNormalUser() 
	{
		delete4thUser.click();
	}
	
	@FindBy(tagName="tr")
		List<WebElement> rows;
	public void textInTable() 
	{
		for(WebElement row : rows){
		System.out.println(row.getText());
		}
	}
	
	@FindBy(tagName="img")
		WebElement logoImage;
	public WebElement getIMG() 
	{
		return logoImage;
	}
	
	@FindBy(xpath="//tr[2]//td[8]//span[text()='Delete']")
		WebElement toggleElement;
	public String toggleElementText()
	{
		return toggleElement.getAttribute("title");
	}
	
	@FindBy(xpath="//p[contains(text(),'Logout')]")
	WebElement logoutText;
	public String logoutText() 
	{
		return logoutText.getText();
	}
}
