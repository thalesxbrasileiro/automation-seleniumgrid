package myshop.test;

import br.com.dbccompany.myshop.dto.ContactDTO;
import br.com.dbccompany.myshop.factory.data.ContactData;
import br.com.dbccompany.myshop.factory.selenium.Validation;
import myshop.page.ContactPage;
import org.testng.annotations.Test;

import static br.com.dbccompany.myshop.storys.ContactStory.*;

public class ContactTest extends BaseTest {

	ContactData contactData = new ContactData();
	ContactPage contactPage = new ContactPage();
	Validation validation = new Validation();

	@Test(description = CE_CONTACT_01)
	public void testContactUsForm() {

		ContactDTO contact = contactData.validContact();
		String message = contactPage.contactUs(contact.getEmail(), contact.getOrderReference(), contact.getMessage());
		validation.textValidation(message, "Your message has been successfully sent to our team.");
	}

	@Test(description = CE_CONTACT_02)
	public void testContactUsInvalidEmail() {

		ContactDTO contact = contactData.invalidEmail();
		String message = contactPage.contactUsError(contact.getEmail(), contact.getOrderReference(), contact.getMessage());
		validation.textValidation(message, "Invalid email address.");
	}

	@Test(description = CE_CONTACT_03)
	public void testWithoutFillingEmail() {

		ContactDTO contact = contactData.notFilledEmail();
		String message = contactPage.contactUsError(contact.getEmail(), contact.getOrderReference(), contact.getMessage());
		validation.textValidation(message, "Invalid email address.");
	}

	@Test(description = CE_CONTACT_04)
	public void testWithoutFillingInFields() {

		ContactDTO contact = contactData.notFilledFields();
		String message = contactPage.contactUsError(contact.getEmail(), contact.getOrderReference(), contact.getMessage());
		validation.textValidation(message, "Invalid email address.");
	}

	@Test(description = CE_CONTACT_05)
	public void testWithoutFillingSubject() {

		ContactDTO contact = contactData.validContact();
		String message = contactPage.contactUsNoSubject(contact.getEmail(), contact.getOrderReference(), contact.getMessage());
		validation.textValidation(message, "Please select a subject from the list provided.");
	}

	@Test(description = CE_CONTACT_06)
	public void testWithoutFillingOrderReference() {

		ContactDTO contact = contactData.notFilledOrderReference();
		String message = contactPage.contactUs(contact.getEmail(), contact.getOrderReference(), contact.getMessage());
		validation.textValidation(message, "Your message has been successfully sent to our team.");
	}

	@Test(description = CE_CONTACT_07)
	public void testWithoutFillingMessage() {

		ContactDTO contact = contactData.notFilledMessage();
		String message = contactPage.contactUsNoMessage(contact.getEmail(), contact.getOrderReference(), contact.getMessage());
		validation.textValidation(message, "The message cannot be blank.");
	}

}
