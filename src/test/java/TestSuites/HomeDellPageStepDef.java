package TestSuites;

import org.junit.Assert;

import Pages.HomeDell;
import Pages.OrdinateurPortable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeDellPageStepDef {
	
	

	@When("admin mouseHover on menu {string} and submenu {string}")
	public void admin_mouse_hover_on_menu_and_submenu(String menutitle, String submenutitle) throws InterruptedException {
		HomeDell page = new HomeDell ();
		page.mouseHoverOnMenuByName(menutitle, submenutitle);
		}
	  

	@When("admin click on Produit {string}")
	public void admin_click_on_produit(String produitname) {
		HomeDell page = new HomeDell ();
		page.clickProduit(produitname);
		
	}

	@Then("admin is directed to the page {string}")
	public void admin_is_directed_to_the_page(String expectedMessage) throws InterruptedException {
		Thread.sleep(3000);
	   OrdinateurPortable home = new OrdinateurPortable ();
	   String actualMessage = home.verifMessage();
	   Assert.assertEquals(expectedMessage, actualMessage);
	}




}
