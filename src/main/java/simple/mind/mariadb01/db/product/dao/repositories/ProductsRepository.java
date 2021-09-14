package simple.mind.mariadb01.db.product.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import simple.mind.mariadb01.db.product.dao.model.Product;

public interface ProductsRepository extends JpaRepository<Product, Integer> {

}
