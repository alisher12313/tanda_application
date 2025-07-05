package kz.tandaApplication.SpringApplication.dto;

import lombok.Data;

@Data
public class TestDtoForRequestTwilio {
    private String phoneNumber;
    private String username;
    private String otp;
}
