package com.pabi.demo.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.pabi.demo.wfs", // repositories for primary DB
		entityManagerFactoryRef = "primaryEntityManagerFactory", transactionManagerRef = "primaryTransactionManager")
public class PrimaryDbConfig {

	@Value("${wfs.primary.datasource.url}")
	private String wfsDBConnURL;

	@Value("${wfs.primary.datasource.username}")
	private String wfsDBConnUser;

	@Value("${wfs.primary.datasource.password}")
	private String wfsDBConnPass;

	@Value("${wfs.primary.datasource.driver-class-name}")
	private String dbDriverName;
//
//	@Value("${wfs.jpa.hibernate.ddl-auto}")
//	private String ddlAuto;
//
//	@Value("${wfs.jpa.show-sql}")
//	private String showSql;
//
//	@Value("${wfs.jpa.database-platform}")
//	private String sqlDialect;
//
//	@Value("${wfs.jpa.open-in-view}")
//	private String openInView;
//
//	@Value("${wfs.jpa.hibernate.naming.physical-strategy}")
//	private String physicalStrategy;

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "wfs.primary.datasource")
	public DataSource primaryDataSource() {
		log.info("Creating WFS dataSource...");
		return DataSourceBuilder.create().driverClassName(dbDriverName).url(wfsDBConnURL).username(wfsDBConnUser)
				.password(wfsDBConnPass).build();
		//return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "primaryEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("primaryDataSource") DataSource dataSource) {

		log.info("Creating WFS entityManager...");

		Properties props = new Properties();
		props.setProperty("hibernate.physical_naming_strategy",
                "com.pabi.demo.config.UpperCaseNamingStrategy");

		Map<String, String> props1= new HashMap<String, String>();
		props1.put("hibernate.physical_naming_strategy",
                "com.pabi.demo.config.UpperCaseNamingStrategy");
//		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
//		entityManager.setDataSource(dataSource);
//		entityManager.setPackagesToScan("com.broadridge.dpm.services.scheduler.entity");
//		entityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//
//		Properties props = new Properties();
//		props.setProperty("hibernate.hbm2ddl.auto", ddlAuto);
//		props.setProperty("hibernate.show_sql", showSql);
//		props.setProperty("hibernate.dialect", sqlDialect);
//		props.setProperty("spring.jpa.open-in-view", openInView);
//		props.setProperty("hibernate.physical_naming_strategy", physicalStrategy);
//
//		entityManager.setJpaProperties(props);
//		return entityManager;
		return builder.dataSource(dataSource).packages("com.pabi.demo.wfs.entity") // entities for primary DB
				.persistenceUnit("primaryPU")
				.properties(props1) // 👈 custom JPA properties only for this EMF
				.build();
	}

	@Bean(name = "primaryTransactionManager")
	public PlatformTransactionManager primaryTransactionManager(
			@Qualifier("primaryEntityManagerFactory") EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
