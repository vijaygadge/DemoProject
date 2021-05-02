package jbk.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsefulLinksPage 
{
	WebDriver driver;
	public UsefulLinksPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//h1[normalize-space(text()) ='Useful Links']")
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
//	@FindBy(xpath="//td[3]/a")
//		List<WebElement> goLinks;
//	goLinks.forEach(goLink->{
//			goLink.click();
//			});
	public void textInTable() throws Exception
	{
		String parentId=driver.getWindowHandle();
		System.out.println("Parent Window :"+driver.getCurrentUrl());
		rows.forEach(row->{
				WebElement link=row.findElement(By.xpath("//td[3]/a"));
				link.click();
					System.out.println(row.getText());
				});
		Set<String> set=driver.getWindowHandles();
		for(String str:set)
		{
			if(!str.equals(parentId))
			{ int i=0;
				driver.switchTo().window(str);
					System.out.println("Child Window :"+(i++)+driver.getCurrentUrl());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				driver.close();
			}driver.switchTo().window(parentId);
		}
	}
	
	@FindBy(tagName="img")
		WebElement logoImage;
	public WebElement getIMG() 
	{
		return logoImage;
	}
	
	@FindBy(xpath="//p[contains(text(),'Logout')]")
	WebElement logoutText;
	public String logoutText() 
	{
		return logoutText.getText();
	}
}
