package Pages;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Helper.Config;

public class HomeDell {
	
	@FindBy(xpath= "/html/body/main/section[1]/header/div[2]/div[2]/nav/ul/li/button/span")
	List<WebElement> menus;
	
	@FindBy(xpath= "/html/body/main/section[1]/header/div[2]/div[2]/nav/ul/li/ul/li/button")
	List<WebElement> submenus;
	
	@FindBy(xpath = "/html/body/main/section[1]/header/div[2]/div[2]/nav/ul/li[3]/ul/li[3]/ul/li/a")
	List<WebElement> ProduitList;

	public HomeDell() {
		PageFactory.initElements(Config.driver, this);
	}

	public void mouseHoverOnMenuByName(String menuName, String subMenuName) throws InterruptedException {
		for (WebElement menu : menus) {
			Config.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			try {
				if (menu.getText().contains(menuName)) {
					System.out.println(menuName);
					System.out.println(menu.getText());
					Config.actions = new Actions(Config.driver);
					Config.actions.moveToElement(menu).perform();

					for (WebElement submenu : submenus) {
						Config.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
						try {
							if (submenu.getText().contains(subMenuName)) {
								Config.actions.moveToElement(submenu).perform();
							}
						} catch (Exception e) {
							
						}
					}
				}
			} catch (Exception e) {
				
			}
		}
	}

	public void clickProduit(String produitName) {
		for (WebElement produit : ProduitList) {
			try {
				if (produit.getText().contains(produitName)) {
					produit.click();
				}
			} catch (Exception e) {
		
			}
		}
	}
}
