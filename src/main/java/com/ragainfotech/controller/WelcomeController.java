package com.ragainfotech.controller;

import com.ragainfotech.entity.AuthenticationRequest;
import com.ragainfotech.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String welcome(){
        return "Welcome Sudesh";
    }

    @PostMapping("/generateToken")
    public String generateToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword())
            );
        }catch (Exception e){
            throw new Exception("Invalid username or password has been provided, please re-check!!!!");
        }

        return jwtUtil.generateToken(authenticationRequest.getUsername());
    }
}
