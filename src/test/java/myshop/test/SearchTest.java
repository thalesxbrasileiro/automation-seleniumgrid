package myshop.test;

import br.com.dbccompany.myshop.dto.SearchDto;
import br.com.dbccompany.myshop.factory.data.SearchData;
import br.com.dbccompany.myshop.factory.selenium.Validation;
import myshop.page.SearchPage;
import org.testng.annotations.Test;

import static br.com.dbccompany.myshop.storys.SearchStory.*;

public class SearchTest extends BaseTest{

    Validation validation = new Validation();
    SearchData searchData = new SearchData();
    SearchPage searchPage = new SearchPage();

    @Test(description = CE_SEARCH_01)
    public void testSearchProductValid(){

        searchPage.search("Blouse");

        String product = searchPage.validateProduct();
        validation.textValidation(product, "Blouse");
    }

    @Test(description = CE_SEARCH_02)
    public void testSearchProductInvalid(){

        SearchDto searchProduct = searchData.searchProd();
        searchPage.search(searchProduct.getSearchFaker());

        String message = searchPage.msgUnsuccessfulSearch();
        validation.textValidation(message, "No results were found for your search " + "\"" + searchProduct.getSearchFaker() + "\"");
    }

    @Test(description = CE_SEARCH_03)
    public void testSearchProductWhitoutFilling(){

        searchPage.search("");

        String message = searchPage.msgUnsuccessfulSearch();
        validation.textValidation(message, "Please enter a search keyword");
    }

}
