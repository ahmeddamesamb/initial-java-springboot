package com.example.projecttext.model;

import com.example.projecttext.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DefaultUserInitializer implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DefaultUserInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        User defaultUser = new User();
        defaultUser.setNom("SAMB");
        defaultUser.setPrenom("Ahmed Dame");
        defaultUser.setEmail("pdg@ugb.edu.sn");
        defaultUser.setPassword(passwordEncoder.encode("12345"));
        defaultUser.setTelephone("776894999");
        defaultUser.setERole(ERole.ADMIN);

        userRepository.save(defaultUser);

    }
}
