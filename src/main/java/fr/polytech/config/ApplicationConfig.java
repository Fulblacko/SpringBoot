package fr.polytech.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({InfrastructureConfig.class})
@ComponentScan(basePackages = "fr.polytech")
public class ApplicationConfig {

    /*
    @Bean
    public PostRepository postRepository(DataSource source) {
        return new JDBCPostRepository(source);
    }

    @Bean
    public PublicationService publicationService(PostRepository repository) {
        return new PublicationServiceImpl(repository);
    }
    */
}
