package com.sandhya.librarymanagement.controller;


import com.sandhya.librarymanagement.model.User;
import com.sandhya.librarymanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public String registerAndSendAnEmail(@RequestBody User user){

        return  userService.registerUser(user);
    }
}
