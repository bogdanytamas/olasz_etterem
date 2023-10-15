package com.project.etterem.registration.service;

import com.project.etterem.registration.dto.RegistrationRequestDTO;
import com.project.etterem.registration.exception.EmailAlreadyExistsException;
import com.project.etterem.user.entity.User;
import com.project.etterem.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerNewUser(RegistrationRequestDTO request) {
        if (userRepository.findByEmail(request.getEmail()) != null) {
            throw new EmailAlreadyExistsException("Az email cím már regisztrálva van!");
        }

        User newUser = new User();
        newUser.setEmail(request.getEmail());
        newUser.setPassword(encodePassword(request.getPassword()));

        return userRepository.save(newUser);
    }

    private String encodePassword(String password) {
        String encodedPassword = passwordEncoder.encode(password);
        return encodedPassword;
    }

}
