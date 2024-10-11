package br.com.dbccompany.myshop.factory.data;

import br.com.dbccompany.myshop.dto.FriendDTO;
import br.com.dbccompany.myshop.utils.DataFakerGenerator;

public class FriendData {

	DataFakerGenerator dataFakerGenerator = new DataFakerGenerator();

	public FriendDTO validFriend() {

		FriendDTO friendDTO = new FriendDTO();

		friendDTO.setName(dataFakerGenerator.firstName());
		friendDTO.setEmail(dataFakerGenerator.emailFaker());

		return friendDTO;
	}

}
