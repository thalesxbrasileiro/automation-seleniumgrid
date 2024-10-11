package myshop.page;

import br.com.dbccompany.myshop.factory.selenium.Interactions;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.cssSelector;

@NoArgsConstructor
public class NewsletterPage extends Interactions {

    private static final By newsletter = cssSelector("#newsletter-input");
    private static final By btnNewsletter = cssSelector("#newsletter_block_left > div > form > div > button");
    private static final By validateMsg = cssSelector("#columns > p");

    public void subscribe(String email){
        sendKeys(newsletter, email);
        click(btnNewsletter);
    }

    public String validateTextConfirmSubscribe(){
        return readText(validateMsg);
    }
}
