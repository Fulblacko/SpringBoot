package fr.polytech.config;

/**
 * Polytech Marseille
 * Case 925 - 163, avenue de Luminy
 * 13288 Marseille CEDEX 9
 * <p>
 * Ce fichier est l'oeuvre d'eleves de Polytech Marseille. Il ne peut etre
 * reproduit, utilise ou modifie sans l'avis express de ses auteurs.
 */

/**
 * @author Sudreau
 */

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:/applications.properties")
public class InfrastructureConfig {

    @Value("${datasource.driverName}")
    private String driverName;

    @Value("${datasource.url}")
    private String url;

    @Value("${datasource.username}")
    private String username;

    @Value("${datasource.password}")
    private String password;

    @Value("${datasource.options}")
    private String options;

    @Bean
    @Profile("PROD")
    public DataSource dataSourcePROD() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUsername(this.username);
        dataSource.setPassword(this.password);
        dataSource.setUrl(this.url + (this.options != null ? ("?" + this.options) : ""));
        dataSource.setDriverClassName(this.driverName);

        return dataSource;
    }

    @Bean
    @Profile("DEV")
    public DataSource dataSourceDEV() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder
                .setType(EmbeddedDatabaseType.H2)
                .addScript("database/create-schema.sql")
                .addScript("database/create-defaults.sql")
                .build();
    }
}
