package com.api.security.service.auth;

import com.api.notifications.service.SesEmailSender;
import com.api.security.infra.constants.BodyConstants;
import com.api.security.infra.constants.SubjectConstants;
import com.api.users.DTO.RegisterDTO;
import com.api.users.domain.User;
import com.api.users.repositories.UserRepository;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SesEmailSender sesEmailSender;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByEmail(username);
        return user;

    }

    public UserDetails register(RegisterDTO data) throws InvalidJwtException{

        if(userRepository.findByEmail(data.email())!= null){

            throw new InvalidJwtException("user already exist !",null , null);

        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        String encryptedConfirmPassword =  new BCryptPasswordEncoder().encode(data.confirmPassword());
        User newUser = new User(data.firstName() , data.lastName(), data.email() , encryptedPassword , encryptedConfirmPassword);
        return userRepository.save(newUser);



    }
}
