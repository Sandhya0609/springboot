package com.sandhya.librarymanagement.service;

import com.sandhya.librarymanagement.model.User;
import com.sandhya.librarymanagement.repository.UserRepository;
import com.sandhya.librarymanagement.util.SendRegistrationSuccessMail;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SendRegistrationSuccessMail sendRegistrationSuccessMail;

    private PasswordEncoder passwordEncoder;

    public String registerUser(User user) {

       user.setPassword(passwordEncoder.encode(user.getPassword()));
       this.userRepository.save(user);
        System.out.println("After user Save.......");


        String info="You have successfully registered in to library management website";
        try {
            System.out.println("Before Email sending......."+user.getEmail());
            sendRegistrationSuccessMail.sendAnEmail(user.getEmail(),info);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return info;

    }

}
