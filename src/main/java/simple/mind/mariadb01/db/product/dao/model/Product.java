package simple.mind.mariadb01.db.product.dao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public  int id;
	public String name;
	public Long price;
}
