package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"config","controller","dao", "model"})
public class ApplicationContextConfig {
    // No need ViewSolver



    // Other declarations if needed ...

}
