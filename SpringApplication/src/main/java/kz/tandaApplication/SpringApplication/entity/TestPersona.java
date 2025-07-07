package kz.tandaApplication.SpringApplication.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import kz.tandaApplication.SpringApplication.dto.Role;

@Entity
@NoArgsConstructor
@Data
public class TestPersona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "test_username")
    private String username;

    @Column(name = "test_password")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
}
