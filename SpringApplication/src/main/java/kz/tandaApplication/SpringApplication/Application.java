package kz.tandaApplication.SpringApplication;

import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import kz.tandaApplication.SpringApplication.configuration.TwilioConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	@Autowired
	private TwilioConfiguration configuration;

	@PostConstruct
	public void initTwilio(){
		Twilio.init(configuration.getAccountSid(), configuration.getAuth_token());
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
