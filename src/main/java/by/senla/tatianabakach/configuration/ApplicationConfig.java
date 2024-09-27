package by.senla.tatianabakach.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.util.DefaultUriBuilderFactory;

import javax.sql.DataSource;
import java.util.Properties;

//xml
//Java Config (вот это оно и есть)
//Annotation Config = @Component
//groovy
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("by.senla.tatianabakach")
@EnableTransactionManagement
@EnableWebMvc
@EnableJpaRepositories(basePackages = "by.senla.tatianabakach.repository")
public class ApplicationConfig {

    @Value("${spring.datasource.driver-class-name}")
    private String dataBaseDriver;
    @Value("${spring.datasource.url}")
    private String dataBaseURL;
    @Value("${spring.datasource.username}")
    private String dataBaseUserName;
    @Value("${spring.datasource.password}")
    private String dataBasePassword;
    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String hibernateDialect;
    @Value("${spring.jpa.show-sql}")
    private String hibernateShowSQL;
    @Value("${spring.jpa.properties.hibernate.format_sql}")
    private String hibernateFormatSQL;
    @Value("${spring.liquibase.change-log}")
    private String liquibaseChangeLog;
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String hibernateDDLAuto;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dataBaseDriver);
        dataSource.setUrl(dataBaseURL);
        dataSource.setUsername(dataBaseUserName);
        dataSource.setPassword(dataBasePassword);
        return dataSource;
    }

    @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog(liquibaseChangeLog);
        liquibase.setDataSource(dataSource());
        return liquibase;
    }

    @Bean
    @DependsOn("liquibase")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("by.senla.tatianabakach.entity");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());
        return em;
    }

    private Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", hibernateDialect);
        properties.setProperty("hibernate.show_sql", hibernateShowSQL);
        properties.setProperty("hibernate.format_sql", hibernateFormatSQL);
        properties.setProperty("hibernate.hbm2ddl.auto", hibernateDDLAuto);
        return properties;
    }

    @Bean
    public PlatformTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(localContainerEntityManagerFactoryBean.getObject());
        return jpaTransactionManager;
    }

    @Bean
    RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(new ObjectMapper());
        restTemplate.getMessageConverters().add(converter);
        restTemplate.setUriTemplateHandler(
                new DefaultUriBuilderFactory("http://localhost:8081/api/v1/payments"));
        return restTemplate;
    }
}
