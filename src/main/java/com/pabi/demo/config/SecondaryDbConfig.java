package com.pabi.demo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
@EnableJpaRepositories(basePackages = "com.pabi.demo.dpm", // repositories for primary DB
		entityManagerFactoryRef = "secondaryEntityManagerFactory", transactionManagerRef = "secondaryTransactionManager")
public class SecondaryDbConfig {

	@Value("${dpm.secondary.datasource.url}")
	private String dpmDBConnURL;

	@Value("${dpm.secondary.datasource.username}")
	private String dpmDBConnUser;

	@Value("${dpm.secondary.datasource.password}")
	private String dpmDBConnPass;

	@Value("${dpm.secondary.datasource.driver-class-name}")
	private String dbDriverName;

	@Bean(name = "secondaryDataSource")
	@ConfigurationProperties(prefix = "dpm.secondary.datasource")
	public DataSource secondaryDataSource() {
		log.info("Creating DPM dataSource...");
		return DataSourceBuilder.create().driverClassName(dbDriverName).url(dpmDBConnURL).username(dpmDBConnUser)
				.password(dpmDBConnPass).build();
	}

	@Bean(name = "secondaryEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("secondaryDataSource") DataSource dataSource) {
		log.info("Creating DPM entityManager...");
		return builder.dataSource(dataSource).packages("com.pabi.demo.dpm.entity") // entities for secondary DB
				.persistenceUnit("secondaryPU").build();
	}
	
	@Bean(name = "secondaryTransactionManager")
	public PlatformTransactionManager secondaryTransactionManager(
			@Qualifier("secondaryEntityManagerFactory") EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
