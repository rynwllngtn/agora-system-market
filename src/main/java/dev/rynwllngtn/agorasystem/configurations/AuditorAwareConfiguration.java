package dev.rynwllngtn.agorasystem.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImplementation")
public class AuditorAwareConfiguration {
}