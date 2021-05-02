package jbk.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DownloadsPage 
{
	WebDriver driver;
	public DownloadsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//h1[normalize-space(text()) ='Downloads']")
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
	
		
	@FindBy(tagName="tr")
		List<WebElement> rows;
	@FindBy(xpath="//tr/td/a")
		List<WebElement> Links;
	public void textInTable() 
	{
		rows.forEach(row->{
			System.out.println(row.getText());
		});
		Links.forEach(Link->{
			Link.click();
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			driver.navigate().to("file:///C:/Offline%20Website/Offline%20Website/pages/examples/downloads.html");//back();
			});
	}
	
	@FindBy(tagName="img")
		WebElement logoImage;
	public WebElement getIMG() 
	{
		return logoImage;
	}

	@FindBy(xpath="//td/img")
	List<WebElement> Images;
	public void getImages()
	{
		String parentId=driver.getWindowHandle();
		System.out.println("Parent URL :"+driver.getCurrentUrl());
		Actions act=new Actions(driver);
		Images.forEach(
				img->{
						System.out.println(img.getAttribute("src"));
						act.contextClick(img).perform();
						Robot robot = null;
						try {
							robot = new Robot();
						} catch (AWTException e1) {
							e1.printStackTrace();
						}
						robot.keyPress(KeyEvent.VK_DOWN);
						robot.keyPress(KeyEvent.VK_ENTER);
						
						Set<String> set=driver.getWindowHandles();
						for(String next : set)
						{
							if(!next.equals(parentId))
							{
								driver.switchTo().window(next);
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								System.out.println("Child URL :"+driver.getCurrentUrl());
								driver.close();
							}driver.switchTo().window(parentId);
						}
					}
		);
	}
	
	@FindBy(xpath="//p[contains(text(),'Logout')]")
		WebElement logoutText;
	public String logoutText() 
	{
		return logoutText.getText();
	}
}
