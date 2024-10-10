package myshop.page;

import br.com.dbccompany.myshop.factory.selenium.Interactions;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.cssSelector;

public class LogoutPage extends Interactions {

    private static final By btnSignOut = By.cssSelector(".header_user_info:nth-child(2) a ");
    private static final By btnSignIn = cssSelector("nav .header_user_info a");

    public void logout(){
        click(btnSignOut);
    };

    public String validateLoginBtn() {
		return readText(btnSignIn);
	}

}
