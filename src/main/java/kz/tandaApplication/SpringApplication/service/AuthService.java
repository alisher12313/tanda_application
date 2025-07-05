package kz.tandaApplication.SpringApplication.service;

import jakarta.transaction.Transactional;
import kz.tandaApplication.SpringApplication.dto.AuthDto;
import kz.tandaApplication.SpringApplication.entity.TestPersona;
import kz.tandaApplication.SpringApplication.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {

    private final TestRepository repository;
    private final BCryptPasswordEncoder encoder;
    private final AuthenticationManager manager;

    public AuthDto register(AuthDto dto) {
        TestPersona persona = mapToEntity(dto);
        persona.setPassword(encoder.encode(dto.getPassword()));
        repository.save(persona);
        return dto;
    }

    private TestPersona mapToEntity(AuthDto dto) {
        TestPersona persona = new TestPersona();
        persona.setUsername(dto.getUsername());
        persona.setPassword(dto.getPassword());
        persona.setRole(dto.getRole());
        return persona;
    }
}