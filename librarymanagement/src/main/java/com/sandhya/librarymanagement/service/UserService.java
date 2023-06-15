package com.sandhya.librarymanagement.service;

import com.sandhya.librarymanagement.model.User;
import com.sandhya.librarymanagement.repository.UserRepository;
import com.sandhya.librarymanagement.util.SendRegistrationSuccessful;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String registerUser(User user){

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.userRepository.save(user);
        SendRegistrationSuccessful sendRegistrationSuccessful=new SendRegistrationSuccessful();
        String info="You have successfully registered in to library management website";
        sendRegistrationSuccessful.sendAnEmail(user.getEmail(),info);

        return info;

    }

}
