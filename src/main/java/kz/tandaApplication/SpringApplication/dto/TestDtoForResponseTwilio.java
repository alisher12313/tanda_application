package kz.tandaApplication.SpringApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestDtoForResponseTwilio {
    private OtpStatus status;
    private String message;
}
