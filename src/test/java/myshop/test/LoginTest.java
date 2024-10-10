package myshop.test;

import br.com.dbccompany.myshop.dto.RegisterDto;
import br.com.dbccompany.myshop.factory.data.RegisterData;
import br.com.dbccompany.myshop.factory.selenium.Validation;
import myshop.page.LoginPage;
import myshop.page.LogoutPage;
import myshop.page.RegisterPage;
import org.testng.annotations.Test;

import static br.com.dbccompany.myshop.storys.LoginStory.*;

public class LoginTest extends BaseTest {

	LoginPage loginPage = new LoginPage();
	LogoutPage logoutPage = new LogoutPage();
	RegisterPage registerPage = new RegisterPage();
	RegisterData registerData = new RegisterData();
	Validation validation = new Validation();


	@Test(description = CE_LOGIN_01)
	public void login(){

		RegisterDto user = registerData.validRegister();

		registerPage.register(user.getEmail(), user.getFirstName(), user.getLastName(), user.getPassword());
		logoutPage.logout();
		loginPage.validLogin(user.getEmail(), user.getPassword());

		String message = loginPage.validateLogoutBtn();
		validation.textValidation(message, "Sign out");

	}

	@Test(description = CE_LOGIN_02)
	public  void invalidEmailLogin(){
		loginPage.validLogin("invalido@qa.com", "senhaInvalida");

		String message = loginPage.validateTextConfirmSubscribe();
		validation.textValidation(message, "There is 1 error");
	}

	@Test(description = CE_LOGIN_03)
	public  void emptyFieldsLogin(){
		loginPage.validLogin(" ", "");

		String message = loginPage.validateTextConfirmSubscribe();
		validation.textValidation(message, "There is 1 error");
	}

	@Test(description = CE_LOGIN_04)
	public  void emptyEmailLogin(){
		RegisterDto user = registerData.validRegister();

		registerPage.register(user.getEmail(), user.getFirstName(), user.getLastName(), user.getPassword());
		logoutPage.logout();
		loginPage.validLogin("", user.getPassword());

		String message = loginPage.validateTextConfirmSubscribe();
		validation.textValidation(message, "There is 1 error");
	}

	@Test(description = CE_LOGIN_05)
	public  void emptyPasswordLogin(){
		RegisterDto user = registerData.validRegister();

		registerPage.register(user.getEmail(), user.getFirstName(), user.getLastName(), user.getPassword());
		logoutPage.logout();
		loginPage.validLogin(user.getEmail(), "");

		String message = loginPage.validateTextConfirmSubscribe();
		validation.textValidation(message, "There is 1 error");
	}

}
