package kz.tandaApplication.SpringApplication.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "twilio")
public class TwilioConfiguration {
    private String accountSid;
    private String auth_token;
    private String trialNumber;
}
