package myshop.page;

import br.com.dbccompany.myshop.factory.selenium.Interactions;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.cssSelector;

public class LoginPage extends Interactions {

	private static final By btnSignIn = cssSelector("nav .header_user_info a");
	private static final By fieldEmail = cssSelector("#email");
	private static final By fielPassword = cssSelector("#passwd");
	private static final By btnSignInConfirmation = cssSelector("#SubmitLogin");
	private static final By validLoginMsg = cssSelector(".alert-danger p");
	private static final By btnSignOut = By.cssSelector(".header_user_info:nth-child(2) a ");

	public void validLogin(String email, String passwrd){
		click(btnSignIn);
		sendKeys(fieldEmail, email);
		sendKeys(fielPassword, passwrd);
		click(btnSignInConfirmation);
	}

	public String validateTextConfirmSubscribe(){
		return readText(validLoginMsg);
	}

	public String validateLogoutBtn() {
		return readText(btnSignOut);
	}

}
