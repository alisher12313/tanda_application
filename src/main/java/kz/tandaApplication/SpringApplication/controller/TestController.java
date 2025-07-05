package kz.tandaApplication.SpringApplication.controller;

import jakarta.servlet.http.HttpServletRequest;
import kz.tandaApplication.SpringApplication.dto.AuthDto;
import kz.tandaApplication.SpringApplication.dto.TestDtoForRequestTwilio;
import kz.tandaApplication.SpringApplication.service.AuthService;
import kz.tandaApplication.SpringApplication.service.TwilioOTPService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/tanda")
@RequiredArgsConstructor
public class TestController {

    private final AuthService authService;

    private final TwilioOTPService otpService;

    @GetMapping(path = "/auth/hello")
    public String greetWithDefault(HttpServletRequest servlet){
        return "Hello, " + servlet.getSession().getId();
    }

    @GetMapping(path = "")
    public String greetRequestPassword(HttpServletRequest servlet){
        return "Hello, " + servlet.getSession().getId();
    }

    @GetMapping(path = "/testGetPersona")
    public String testPersonCheckOnDb(){
        return "Success";
    }

    @PostMapping(path = "/auth/register")
    public ResponseEntity<?> register(@RequestBody AuthDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(authService.register(dto));
    }

    @GetMapping(path = "/auth/sendOTP")
    public ResponseEntity<?> sendOTP(@RequestBody TestDtoForRequestTwilio twilio){
        return ResponseEntity.
                status(HttpStatus.OK).
                body(otpService.sendOTPForAuthorizationVerification(twilio));
    }

    @PostMapping(path = "/auth/verifyOTP")
    public ResponseEntity<?> verifyOTP(@RequestParam String otp, @RequestParam String username){
        return ResponseEntity.status(HttpStatus.OK).body(otpService.verifyOTP(otp, username));
    }
}
