package br.com.dbccompany.myshop.factory.data;

import br.com.dbccompany.myshop.dto.NewsletterDto;
import br.com.dbccompany.myshop.utils.DataFakerGenerator;

public class NewsletterData {

    DataFakerGenerator dataFakerGenerator = new DataFakerGenerator();

    public NewsletterDto validNewsletter() {

        NewsletterDto newsletterDto = new NewsletterDto();

        newsletterDto.setEmailFaker(dataFakerGenerator.emailFaker());

        return newsletterDto;
    }
}
