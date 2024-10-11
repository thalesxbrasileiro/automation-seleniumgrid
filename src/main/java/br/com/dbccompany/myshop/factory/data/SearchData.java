package br.com.dbccompany.myshop.factory.data;

import br.com.dbccompany.myshop.dto.SearchDto;
import br.com.dbccompany.myshop.utils.DataFakerGenerator;

public class SearchData {

    DataFakerGenerator dataFakerGenerator = new DataFakerGenerator();

    public SearchDto searchProd() {

        SearchDto searchDto = new SearchDto();
        searchDto.setSearchFaker(dataFakerGenerator.searchInvalidProd());

        return searchDto;
    }
}
