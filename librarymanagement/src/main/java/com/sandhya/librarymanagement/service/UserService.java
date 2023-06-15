package com.sandhya.librarymanagement.service;

import com.sandhya.librarymanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    private UserRepository userRepository;

}
