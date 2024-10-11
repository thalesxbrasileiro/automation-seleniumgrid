package myshop.page;

import br.com.dbccompany.myshop.factory.selenium.Interactions;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.cssSelector;

@NoArgsConstructor
public class SearchPage extends Interactions {

    private static final By inputSearch = cssSelector("#search_query_top");
    private static final By btnSearch = cssSelector("#searchbox > button");
    private static final By Product = cssSelector("#center_column > ul > li > div > div.right-block > h5 > a");
    private static final By unsuccessfulSearch = cssSelector("#center_column > p");

    public void search(String product){
        sendKeys(inputSearch, product);
        click(btnSearch);
    }

    public String msgUnsuccessfulSearch() {
        return readText(unsuccessfulSearch);
    }

    public String validateProduct() {
        return readText(Product);
    }
}
