package com.api.security.controller.users;


import com.api.security.service.auth.AuthService;
import com.api.security.service.token.TokenProviderService;
import com.api.users.DTO.RegisterDTO;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthService authService;

    @Autowired
    private TokenProviderService tokenService;

    @PostMapping
    public ResponseEntity<?>register(@RequestBody @Validated RegisterDTO data) throws InvalidJwtException {

        authService.register(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

}
