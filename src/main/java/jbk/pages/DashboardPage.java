package jbk.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage 
{
	WebDriver driver;
	public DashboardPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@href='logout.html']")
	WebElement LogOut;
	public IndexPage clickLogoutLink()
	{
		LogOut.click();
		 return new IndexPage(driver);
	}
	
	@FindBy(xpath="//a[@href='users.html']")
	WebElement usersPageLink;
	public UsersPage clickOnUserPageLink()
	{
		 usersPageLink.click();
		 return new UsersPage(driver);
	}
	
	@FindBy(xpath="//a[@href='operators.html']")
	WebElement OperatorsPageLink;
	public OperatorsPage clickOnOperatorsPageLink()
	{
		OperatorsPageLink.click();
		return new OperatorsPage(driver);
	}
	
	@FindBy(xpath="//a[@href='links.html']")
	WebElement UsefulLinksPage;
	public UsefulLinksPage clickOnUsefulLinksPage()
	{
		UsefulLinksPage.click();
		return new UsefulLinksPage(driver);
	}
	
	@FindBy(xpath="//a[@href='downloads.html']")
	WebElement DownloadsPage;
	public DownloadsPage clickOnDownloadsPage()
	{
		DownloadsPage.click();
		return new DownloadsPage(driver);
	}

	@FindBy(tagName="h1")
		WebElement heading;
	public String headingText()
	{
		return heading.getText();
	}
	
	@FindBy(xpath="//li/a[text()='LOGOUT']")
		WebElement logoutText;
	public String logoutText1()
	{
		return logoutText.getText();
	}
	public IndexPage clickLogoutButton()
	{
		logoutText.click();
		return new IndexPage(driver);
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
	public DashboardPage clickjbkText()
	{
		jbkText.click();
		return new DashboardPage(driver);
	}
	
	@FindBy(xpath="//aside[@class='main-sidebar']")
		WebElement navBar;
	public String LHSNavBar()
	{
		return navBar.getText();
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
	
	@FindBy(xpath="//div[h3[contains(text(),'Selenium')]]")
		WebElement courseSelenium;
	public String verifyCourseSelenium()
	{
		return courseSelenium.getText();
	}
	
	@FindBy(xpath="//section[@class=\"content\"]")
	WebElement allCoursesText;
	public String verifyallCoursesText()
	{
		return allCoursesText.getText();
	}
	
	@FindBy(xpath="//h3[text()='Selenium']/../..//a")
		WebElement seleMoreInfo;
	public String verifySeleMoreInfoText()
	{
		return seleMoreInfo.getText();
	}
	public void clickSeleMoreInfo()
	{
		seleMoreInfo.click();
	}
	
	@FindBy(xpath="//h3[text()='Java / J2EE']/../..//a")
		WebElement javaMoreInfo;
	public String verifyJavaMoreInfoText()
	{
		return javaMoreInfo.getText();
	}
	public void clickJavaMoreInfo()
	{
		javaMoreInfo.click();
	}

	@FindBy(xpath="//h3[text()='Python']/../..//a")
		WebElement pythonMoreInfo;
	public String verifyPythonMoreInfoText()
	{
		return pythonMoreInfo.getText();
	}
	public void clickPythonMoreInfo()
	{
		pythonMoreInfo.click();
	}

	@FindBy(xpath="//h3[text()='Php']/../../..//a")
		WebElement phpMoreInfo;
	public String verifyphpMoreInfoText()
	{
		return phpMoreInfo.getText();
	}
	public void clickphpMoreInfo()
	{
		phpMoreInfo.click();
	}
	
	@FindBy(partialLinkText="Online")
		WebElement onlineText;
	public void clickOnlineText() 
	{
		onlineText.click();
	}
	
	@FindBy(tagName="img")
		WebElement logoImage;
	public WebElement getIMG() {
		
		return logoImage;
	}
	
	@FindBy(xpath="//i[@class='ion ion-bag']")
		WebElement ele1;
	public WebElement getEle1()
	{
			return ele1;
	}
	
	@FindBy(xpath="//i[@class='ion ion-stats-bars']")
		WebElement ele2;
	public WebElement getEle2()
	{
			return ele2;
	}
	
	@FindBy(xpath="//i[@class='ion ion-person-add']")
		WebElement ele3;
	public WebElement getEle3()
	{
			return ele3;
	}
	
	@FindBy(xpath="//i[@class='ion ion-pie-graph']")
		WebElement ele4;
	public WebElement getEle4()
	{
			return ele4;
	}
	
	@FindBy(xpath="//p[contains(text(),'Logout')]")
	WebElement logoutText2;
	public String logoutText2() 
	{
		return logoutText2.getText();
	}
}
