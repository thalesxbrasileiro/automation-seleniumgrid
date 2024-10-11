package myshop.test;

import br.com.dbccompany.myshop.dto.NewsletterDto;
import br.com.dbccompany.myshop.factory.data.NewsletterData;
import br.com.dbccompany.myshop.factory.selenium.Validation;
import myshop.page.NewsletterPage;
import org.testng.annotations.Test;

import static br.com.dbccompany.myshop.storys.NewsletterStory.*;

public class NewsletterTest extends BaseTest{

    Validation validation = new Validation();
    NewsletterData newsletterData = new NewsletterData();
    NewsletterPage newsletterPage = new NewsletterPage();

    @Test(description = CE_NEWSLETTER_01)
    public void testNewsletterValid() {

        NewsletterDto news = newsletterData.validNewsletter();
        newsletterPage.subscribe(news.getEmailFaker());

        String message = newsletterPage.validateTextConfirmSubscribe();
        validation.textValidation(message, "Newsletter : You have successfully subscribed to this newsletter.");
    }

    @Test(description = CE_NEWSLETTER_02)
    public void testNewsletterInvalid() {

        newsletterPage.subscribe("invalidEmail.com");

        String message = newsletterPage.validateTextConfirmSubscribe();
        validation.textValidation(message, "Newsletter : Invalid email address.");
    }

    @Test(description = CE_NEWSLETTER_03)
    public void testWithoutFillingNewsletter() {

        newsletterPage.subscribe("");

        String message = newsletterPage.validateTextConfirmSubscribe();
        validation.textValidation(message, "Newsletter : Invalid email address.");
    }

}
