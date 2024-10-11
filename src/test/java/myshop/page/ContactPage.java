package myshop.page;

import br.com.dbccompany.myshop.factory.selenium.Interactions;
import org.openqa.selenium.By;

import java.nio.file.Paths;
import java.util.Random;

import static org.openqa.selenium.By.cssSelector;

public class ContactPage extends Interactions {

	private static final Random random = new Random();
	private static final By comboBoxSubject;
	String file = Paths.get("src/main/resources/utils/file.txt").toAbsolutePath().toString();

	static {
		comboBoxSubject = cssSelector("#id_contact > option[value='" + (random.nextInt(2) + 1) + "']");
	}

	private static final By btnContactUs = cssSelector("#contact-link > a");
	private static final By fieldEmail = cssSelector("#email");
	private static final By fieldOrderReference = cssSelector("#id_order");
	private static final By fieldFile = cssSelector("#fileUpload");
	private static final By fieldMessage = cssSelector("#message");
	private static final By btnSend = cssSelector("#submitMessage > span");
	private static final By msgSuccessfully = cssSelector("#center_column > p");
	private static final By msgSubjectError = cssSelector("#center_column > div > ol > li");

	public String contactUs(String email, String orderReference, String message) {
		click(btnContactUs);
		click(comboBoxSubject);
		sendKeys(fieldEmail, email);
		sendKeys(fieldOrderReference, orderReference);
		sendKeys(fieldFile, file);
		sendKeys(fieldMessage, message);
		click(btnSend);

		return  readText(msgSuccessfully);
	}

	public String contactUsError(String email, String orderReference, String message) {
		click(btnContactUs);
		click(comboBoxSubject);
		sendKeys(fieldEmail, email);
		sendKeys(fieldOrderReference, orderReference);
		sendKeys(fieldFile, file);
		sendKeys(fieldMessage, message);
		click(btnSend);

		return  readText(msgSubjectError);
	}

	public String contactUsNoSubject(String email, String orderReference, String message) {
		click(btnContactUs);
		sendKeys(fieldEmail, email);
		sendKeys(fieldOrderReference, orderReference);
		sendKeys(fieldFile, file);
		sendKeys(fieldMessage, message);
		click(btnSend);

		return  readText(msgSubjectError);
	}

	public String contactUsNoMessage(String email, String orderReference, String message) {
		click(btnContactUs);
		click(comboBoxSubject);
		sendKeys(fieldEmail, email);
		sendKeys(fieldOrderReference, orderReference);
		sendKeys(fieldFile, file);
		sendKeys(fieldMessage, message);
		click(btnSend);

		return  readText(msgSubjectError);
	}

}
