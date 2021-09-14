package simple.mind.mariadb01.db.persistance;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

@Service
public class PersistenceCommonService {
	public static final String DB_PROPERY = "classpath:db.properties";
	public static final String KEY_USER_BASE_PACKAGE = "simple.mind.mariadb01.db.user.dao";
	public static final String KEY_PROD_BASE_PACKAGE = "simple.mind.mariadb01.db.product.dao";

	private static final String KEY_H_DIALECT = "hibernate.dialect";
	private static final String KEY_H_DDL_AUTO = "hibernate.hbm2ddl.auto";
	private static final String KEY_H_NAMING_STRATEGY = "hibernate.physical_naming_strategy";
	
	private static final String KEY_JDBC_DRIVER_CLASSNAME = "jdbc.driverClassName";
	

	@Autowired
	Environment env;

	public DataSource getDataSource(String prefix) {
		prefix = prefix.trim().isEmpty() ? prefix : prefix + ".";
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty(KEY_JDBC_DRIVER_CLASSNAME));
		dataSource.setUrl(env.getProperty(prefix + "jdbc.url"));
		dataSource.setUsername(env.getProperty(prefix + "jdbc.user"));
		dataSource.setPassword(env.getProperty(prefix + "jdbc.pass"));
		return dataSource;
	}

	public Map<String, Object> getConnectionProperty() {
		HashMap<String, Object> properties = new HashMap<>();
		properties.put(KEY_H_DDL_AUTO, env.getProperty(KEY_H_DDL_AUTO));
		properties.put(KEY_H_DIALECT, env.getProperty(KEY_H_DIALECT));
		properties.put(KEY_H_NAMING_STRATEGY, env.getProperty(KEY_H_NAMING_STRATEGY));
		return properties;
	}
}
