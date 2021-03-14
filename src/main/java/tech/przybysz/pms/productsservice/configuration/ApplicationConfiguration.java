package tech.przybysz.pms.productsservice.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "tech.przybysz.pms.productsservice")
@EnableTransactionManagement
public class ApplicationConfiguration {
}
