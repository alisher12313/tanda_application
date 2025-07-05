package kz.tandaApplication.SpringApplication.service;

import kz.tandaApplication.SpringApplication.entity.TestPersona;
import kz.tandaApplication.SpringApplication.repository.TestRepository;
import kz.tandaApplication.SpringApplication.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {

    private final TestRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TestPersona persona = repository.findByUsername(username).
                orElseThrow(() -> new UsernameNotFoundException("No such username"));

        return new UserPrincipal(persona);
    }
}
