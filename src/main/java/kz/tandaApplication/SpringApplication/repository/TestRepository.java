package kz.tandaApplication.SpringApplication.repository;

import kz.tandaApplication.SpringApplication.entity.TestPersona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestRepository extends JpaRepository<TestPersona, Long> {
    Optional<TestPersona> findByUsername(String username);
}
