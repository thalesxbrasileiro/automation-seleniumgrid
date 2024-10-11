package myshop.test;

import br.com.dbccompany.myshop.dto.RegisterDto;
import br.com.dbccompany.myshop.factory.data.RegisterData;
import br.com.dbccompany.myshop.factory.selenium.Validation;
import myshop.page.LogoutPage;
import myshop.page.RegisterPage;
import org.testng.annotations.Test;

import static br.com.dbccompany.myshop.storys.LogOutStory.CE_LOGOUT_01;

public class LogoutTest extends BaseTest {

    LogoutPage logoutPage = new LogoutPage();
    Validation validation = new Validation();
    RegisterPage registerPage = new RegisterPage();
    RegisterData registerData = new RegisterData();

        @Test(description = CE_LOGOUT_01)
        public void logout(){
            RegisterDto user = registerData.validRegister();

            registerPage.register(user.getEmail(), user.getFirstName(), user.getLastName(), user.getPassword());
            logoutPage.logout();

            String message = logoutPage.validateLoginBtn();
            validation.textValidation(message, "Sign in");
        }

}
