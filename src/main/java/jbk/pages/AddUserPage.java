package jbk.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUserPage 
{
	WebDriver driver;
	public AddUserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
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
	
	@FindBy(xpath="//a[text()='JBK']")
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
	
	
	@FindBy(tagName="h1")
		WebElement addUser;
	public String verifyAddUserText()
	{
		return addUser.getText();
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
	
	@FindBy(tagName="h3")
		WebElement h3;
	public String verifyh3Text() 
	{
		return	h3.getText();
	}
	
	@FindBy(xpath="//table//tr[\"+TestAddUserPage.i+\"]//td[\"+TestAddUserPage.j+\"]")
		WebElement tableXpath;
	public String tableXpath() 
	{
		String t1=null;
		for(int i=2;i<6;i++)
		{
			for(int j=1;j<8;j++)
			{
				t1=tableXpath.getText();
			}
		}
		return t1;
	}
	
		@FindBy(id="username")
		WebElement username;
	public void setUserName(String text)
	{
		username.clear();
		username.sendKeys(text);
	}
	
	@FindBy(id="mobile")
		WebElement mobile;
	public void setMobileNo(String text)
	{
		mobile.clear();
		mobile.sendKeys(text);
	}
	
	@FindBy(id="email")
		WebElement email;
	public void setEmail(String text)
	{
		email.clear();
		email.sendKeys(text);
	}
	
	@FindBy(id="course")
		WebElement course;
	public void setCourse(String text)
	{
		course.clear();
		course.sendKeys(text);
	}
	
	@FindBy(id="password")
		WebElement password;
	public void setPassword(String text)
	{
		password.clear();
		password.sendKeys(text);
	}
	
	@FindBy(id="Male")
		WebElement Male;
	public void setMale()
	{
		Male.click();
	}

	@FindBy(id="Female")
		WebElement Female;
	public void setFemale()
	{
		Female.click();
	}
	
	@FindBy(tagName="select")
		WebElement select;
	public WebElement setSelect()
	{
		return select;
	}
	
	@FindBy(xpath="//span[text()='Cancel']")
		WebElement cancle;
	public void cancleBtn()
	{
		cancle.click();
	}
	
	@FindBy(tagName="img")
		WebElement logoImage;
	public WebElement getIMG() 
	{
		return logoImage;
	}
}