package myshop.page;

import br.com.dbccompany.myshop.factory.selenium.Interactions;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.ArrayList;

import static org.openqa.selenium.By.cssSelector;

@NoArgsConstructor
public class ProductPage extends Interactions {


	private static final By btnWomen = cssSelector("#block_top_menu > ul > li:nth-child(1) > a");
	private static final By fieldWomen = cssSelector("#center_column > h1 > span.cat-name");
	private static final By fieldList = cssSelector("#center_column > ul");
	private static final By btnMore = cssSelector("#center_column > ul > li:nth-child(2) > div > div.right-block  > h5 > a");
	private static final By btnMore2 = cssSelector("#center_column > ul > li:nth-child(1) > div > div.right-block  > h5 > a");
	private static final By fieldTitle = cssSelector("#center_column > div > div > div.pb-center-column.col-xs-12.col-sm-4 > h1");
	private static final By fieldReference = cssSelector("#product_reference > span");
	private static final By fieldCondition = cssSelector("#product_condition > span");
	private static final By fieldDescription = cssSelector("#short_description_content > p");
	private static final By fieldPrice = cssSelector("#our_price_display");
	private static final By fieldCompositions = cssSelector("#center_column > div > section:nth-child(2) > table > tbody > tr:nth-child(1) > td:nth-child(2)");
	private static final By fieldStyles = cssSelector("#center_column > div > section:nth-child(2) > table > tbody > tr.even > td:nth-child(2)");
	private static final By fieldProperties = cssSelector("#center_column > div > section:nth-child(2) > table > tbody > tr:nth-child(3) > td:nth-child(2)");
	private static final By fieldMoreInfo = cssSelector("#center_column > div > section:nth-child(3) > div > p");
	private static final By sizeComboBox = cssSelector("#group_1");
	private static final By addToCartButton = cssSelector("#add_to_cart > button > span");
	private static final By viewLargerButton = cssSelector("#view_full_size > span");
	private static final By fieldPhoto = cssSelector("#product > div.fancybox-wrap.fancybox-desktop.fancybox-type-image.fancybox-opened > div > div.fancybox-outer > div > img");
	private static final By btnInStock = cssSelector("#availability_value");
	private static final By btnTweet = cssSelector("button[data-type=\"twitter\"]");
	private static final By btnFacebook = cssSelector("button[data-type=\"facebook\"]");
	private static final By btnGoogle = cssSelector("button[data-type=\"google-plus\"]");
	private static final By btnPinterest = cssSelector("button[data-type=\"pinterest\"]");
	private static final By btnPrint = cssSelector("#usefull_link_block > li.print > a");
	private static final By btnSendToAFriend = cssSelector("#send_friend_button");
	private static final By fieldName = cssSelector("#friend_name");
	private static final By fieldEmail = cssSelector("#friend_email");
	private static final By btnSend = cssSelector("#sendEmail > span");
	private static final By sentSuccessfully = cssSelector("#product > div.fancybox-wrap.fancybox-desktop.fancybox-type-html.fancybox-opened > div > div > div > p:nth-child(2)");

	public void productDetails() {
		click(btnWomen);
		readText(fieldWomen);
		readText(fieldList);
		click(btnMore);
		readText(fieldTitle);
		readText(fieldReference);
		readText(fieldCondition);
		readText(fieldDescription);
		readText(fieldPrice);
		readText(fieldCompositions);
		readText(fieldStyles);
		readText(fieldProperties);
		readText(fieldMoreInfo);
	}

	public void isTheImageWillEnlarge() {
		click(btnWomen);
		readText(fieldWomen);
		readText(fieldList);
		click(btnMore);
		click(viewLargerButton);
		readText(fieldPhoto);
	}

	public String inStock() throws InterruptedException {
		click(btnWomen);
		readText(fieldWomen);
		readText(fieldList);
		click(btnMore);
		sendKeys(sizeComboBox, Keys.ARROW_DOWN);
		Thread.sleep(1000);
		sendKeys(sizeComboBox, Keys.ARROW_DOWN);

		return readText(btnInStock);
	}

	public String noStock() {
		click(btnWomen);
		readText(fieldWomen);
		readText(fieldList);
		click(btnMore2);

		return readText(btnInStock);
	}

	public String noLongerInStockWithThoseAttributes() {
		click(btnWomen);
		readText(fieldWomen);
		readText(fieldList);
		click(btnMore);

		return readText(btnInStock);
	}

	public ArrayList<String> socialMideaButton() {
		click(btnWomen);
		readText(fieldWomen);
		readText(fieldList);
		click(btnMore);

		ArrayList<String> listOfSocialMidea = new ArrayList<>();

		listOfSocialMidea.add(readText(btnTweet));
		listOfSocialMidea.add(readText(btnFacebook));
		listOfSocialMidea.add(readText(btnGoogle));
		listOfSocialMidea.add(readText(btnPinterest));

		return listOfSocialMidea;
	}

	public String sendProductToAFriend(String name, String email) throws InterruptedException {
		click(btnWomen);
		readText(fieldWomen);
		readText(fieldList);
		click(btnMore);
		click(btnSendToAFriend);
		sendKeys(fieldName, name);
		sendKeys(fieldEmail, email);
		click(btnSend);

		return readText(sentSuccessfully);
	}

	public String isTheButtonPrintIsVisible() {
		click(btnWomen);
		readText(fieldWomen);
		readText(fieldList);
		click(btnMore);

		return readText(btnPrint);
	}

	public String isAddToCartButtonPresent() throws InterruptedException {
		click(btnWomen);
		readText(fieldWomen);
		readText(fieldList);
		click(btnMore);
		sendKeys(sizeComboBox, Keys.ARROW_DOWN);
		Thread.sleep(1000);
		sendKeys(sizeComboBox, Keys.ARROW_DOWN);

		return readText(addToCartButton);
	}

}
