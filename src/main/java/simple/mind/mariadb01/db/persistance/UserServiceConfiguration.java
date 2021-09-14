package simple.mind.mariadb01.db.persistance;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource({ PersistenceCommonService.DB_PROPERY })
@EnableJpaRepositories( //
		basePackages = PersistenceCommonService.KEY_USER_BASE_PACKAGE, //
		entityManagerFactoryRef = "userEntityManager", //
		transactionManagerRef = "userTransactionManager" //
)
public class UserServiceConfiguration {
	@Autowired
	private PersistenceCommonService persistence;

	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean userEntityManager() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(userDataSource());
		em.setPackagesToScan(new String[] { PersistenceCommonService.KEY_USER_BASE_PACKAGE });

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaPropertyMap(persistence.getConnectionProperty());

		return em;
	}

	@Primary
	@Bean
	public DataSource userDataSource() {
		return persistence.getDataSource("user");
	}

	@Primary
	@Bean
	public PlatformTransactionManager userTransactionManager() {

		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(userEntityManager().getObject());
		return transactionManager;
	}
}
