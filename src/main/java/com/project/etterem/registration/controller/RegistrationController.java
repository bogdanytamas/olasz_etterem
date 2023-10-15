package com.project.etterem.registration.controller;

import com.project.etterem.registration.dto.RegistrationRequestDTO;
import com.project.etterem.registration.service.RegistrationService;
import com.project.etterem.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value = "/api", method = {RequestMethod.GET, RequestMethod.POST})
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegistrationRequestDTO requestDTO) {
        registrationService.registerNewUser(requestDTO);
        return new ResponseEntity<>("Sikeres regisztráció!", HttpStatus.CREATED);
    }

}
