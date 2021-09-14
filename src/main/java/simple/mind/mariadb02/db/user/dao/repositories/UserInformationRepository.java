package simple.mind.mariadb02.db.user.dao.repositories;

import java.util.List;

import simple.mind.mariadb02.db.user.dao.model.UserInformation;

public interface UserInformationRepository {
	List<UserInformation> findAll();
	UserInformation findByAddress(String address);
}
