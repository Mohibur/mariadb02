package simple.mind.mariadb01.db.user.dao.repositories;

import simple.mind.mariadb01.db.user.dao.model.UserInformation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInformationRepository extends JpaRepository<UserInformation, Long> {

	UserInformation findByAddress(String address);
}
