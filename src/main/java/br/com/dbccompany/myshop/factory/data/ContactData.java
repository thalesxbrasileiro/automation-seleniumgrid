package br.com.dbccompany.myshop.factory.data;

import br.com.dbccompany.myshop.dto.ContactDTO;
import br.com.dbccompany.myshop.utils.DataFakerGenerator;

public class ContactData {

	DataFakerGenerator dataFakerGenerator = new DataFakerGenerator();

	public ContactDTO validContact() {

		ContactDTO contactDTO = new ContactDTO();

		contactDTO.setEmail(dataFakerGenerator.emailFaker());
		contactDTO.setOrderReference(dataFakerGenerator.orderReference());
		contactDTO.setMessage(dataFakerGenerator.message());

		return contactDTO;
	}

	public ContactDTO invalidEmail() {

		ContactDTO contactDTO = new ContactDTO();

		contactDTO.setEmail(dataFakerGenerator.firstName());
		contactDTO.setOrderReference(dataFakerGenerator.orderReference());
		contactDTO.setMessage(dataFakerGenerator.message());

		return contactDTO;
	}

	public ContactDTO notFilledFields() {

		ContactDTO contactDTO = new ContactDTO();

		contactDTO.setEmail(dataFakerGenerator.blankField());
		contactDTO.setOrderReference(dataFakerGenerator.blankField());
		contactDTO.setMessage(dataFakerGenerator.blankField());

		return contactDTO;
	}

	public ContactDTO notFilledOrderReference() {

		ContactDTO contactDTO = new ContactDTO();

		contactDTO.setEmail(dataFakerGenerator.emailFaker());
		contactDTO.setOrderReference(dataFakerGenerator.blankField());
		contactDTO.setMessage(dataFakerGenerator.message());

		return contactDTO;
	}

	public ContactDTO notFilledMessage() {

		ContactDTO contactDTO = new ContactDTO();

		contactDTO.setEmail(dataFakerGenerator.emailFaker());
		contactDTO.setOrderReference(dataFakerGenerator.orderReference());
		contactDTO.setMessage(dataFakerGenerator.blankField());

		return contactDTO;
	}

	public ContactDTO notFilledEmail() {

		ContactDTO contactDTO = new ContactDTO();

		contactDTO.setEmail(dataFakerGenerator.blankField());
		contactDTO.setOrderReference(dataFakerGenerator.orderReference());
		contactDTO.setMessage(dataFakerGenerator.message());

		return contactDTO;
	}

}
