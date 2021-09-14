package simple.mind.mariadb02.db.user.dao.repositories.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import simple.mind.mariadb02.db.user.dao.model.UserInformation;
import simple.mind.mariadb02.db.user.dao.repositories.UserInformationRepository;

@Service
public class UserInformationRepoImpl implements UserInformationRepository {
	private static final String BASE_QUERY = "SELECT b.id, a.name, a.email, a.age, b.address FROM users a JOIN user_address b ON (a.id = b.user_id)";
	@PersistenceContext(name = "userEntityManager")
	EntityManager entityManager;

	@Override
	public List<UserInformation> findAll() {
		return entityManager.createQuery(BASE_QUERY, UserInformation.class).getResultList();
	}

	@Override
	public UserInformation findByAddress(String address) {
		String sql = BASE_QUERY + " WHERE address = :address";
		TypedQuery<UserInformation> query = entityManager.createQuery(sql, UserInformation.class);
		query.setParameter("address", address);
		return query.getSingleResult();
	}
}
