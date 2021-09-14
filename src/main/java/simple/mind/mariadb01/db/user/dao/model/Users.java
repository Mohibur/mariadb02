package simple.mind.mariadb01.db.user.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer id;
	public String name;
	@Column(unique = true, nullable = false)
	public String email;
	public Integer age;
}
