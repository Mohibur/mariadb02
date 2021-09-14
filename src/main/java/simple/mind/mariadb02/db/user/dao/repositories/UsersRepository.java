package simple.mind.mariadb02.db.user.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import simple.mind.mariadb02.db.user.dao.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}
