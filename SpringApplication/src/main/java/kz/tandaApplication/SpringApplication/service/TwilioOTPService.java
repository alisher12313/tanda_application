package kz.tandaApplication.SpringApplication.service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import kz.tandaApplication.SpringApplication.configuration.TwilioConfiguration;
import kz.tandaApplication.SpringApplication.dto.OtpStatus;
import kz.tandaApplication.SpringApplication.dto.TestDtoForRequestTwilio;

import kz.tandaApplication.SpringApplication.dto.TestDtoForResponseTwilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Random;

@Service
public class TwilioOTPService {

    @Autowired
    private TwilioConfiguration configuration;

    private HashMap<String, String> otpMap = new HashMap<>();

    public TestDtoForResponseTwilio sendOTPForAuthorizationVerification(TestDtoForRequestTwilio request){

        TestDtoForResponseTwilio response = null;

        try {

            PhoneNumber to = new PhoneNumber(request.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(configuration.getTrialNumber());

            String otp = generateOTP();
            String otpMessage = "Please verify that it's you: " + otp;

            Message message = Message.
                    creator(to, from, otpMessage).
                    create();

            otpMap.put(request.getUsername(), otp);

            return response = new TestDtoForResponseTwilio(OtpStatus.DELIVERED, otpMessage);

        }catch(Exception e){
            return response = new TestDtoForResponseTwilio(OtpStatus.FAILED, e.getMessage());
        }
    }

    //later generate JWT token or able to change password
    //also do it with redis with timer of 2 minutes I guess
    public String verifyOTP(String otp, String username){
        if(otp.equals(otpMap.get(username))){
            return "valid OTP";
        }

        return "LOX";
    }

    private String generateOTP(){
        return new DecimalFormat("0000").format(new Random().nextInt(10_000));
    }
}
