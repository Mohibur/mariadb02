package simple.mind.mariadb01.db.user.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Subselect;
import org.springframework.data.annotation.Immutable;

import lombok.Data;

@Entity
@Immutable
@Subselect("SELECT b.id, a.name, a.email, a.age, b.address FROM users a JOIN user_address b ON (a.id = b.user_id)")
@Data
public class UserInformation {
	@Id
	private Integer id;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private Integer age;
	@Column
	private String address;
}
