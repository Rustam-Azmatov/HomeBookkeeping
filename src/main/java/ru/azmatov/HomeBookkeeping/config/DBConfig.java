package ru.azmatov.HomeBookkeeping.config;


import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "bookkeepingEntityManagerFactory",
        transactionManagerRef = "bookkeepingTransactionManager",
        basePackages = {"ru.azmatov.HomeBookkeeping.repository"}
)
@PropertySource("file:jdbc.properties")
public class DBConfig {
	@Value("${database.user}")
	private String login;
	@Value("${database.password}")
	private String password;
	@Value("${database.url}")
	private String url;
	
	@Bean(name = {"dataSource"})
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl(url);
		dataSource.setUsername(login);
		dataSource.setPassword(password);
		
		return dataSource;
	}
	
	@Bean
    public JpaVendorAdapter persistenceJpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(false);
        hibernateJpaVendorAdapter.setGenerateDdl(false);
        hibernateJpaVendorAdapter.setDatabase(Database.POSTGRESQL);
        hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
        return hibernateJpaVendorAdapter;
    }
	
	@Bean(name = {"bookkeepingEntityManagerFactory"})
    public LocalContainerEntityManagerFactoryBean bookkeepingEntityManagerFactory(
            @Qualifier("dataSource") DataSource dataSource,
            @Qualifier("persistenceJpaVendorAdapter") JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
        lef.setDataSource(dataSource);
        lef.setPackagesToScan("ru.azmatov.HomeBookkeeping");
        lef.setJpaVendorAdapter(jpaVendorAdapter);
        return lef;
    }

    @Bean
    public PlatformTransactionManager bookTransactionManager(@Qualifier("bookkeepingEntityManagerFactory") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
