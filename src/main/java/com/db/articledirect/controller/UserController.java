package com.db.articledirect.controller;


import com.db.articledirect.Repository.UserRepository;
import com.db.articledirect.model.*;
import com.db.articledirect.service.UserService;
import com.db.articledirect.utility.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
        System.out.println("/authenticate Mapping called");
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );

        }catch(BadCredentialsException e){
                throw  new Exception("INVALID CREDENTIALS",e);
        }

        final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUsername());
        System.out.println("Loading user by name " + userDetails.getUsername());
        final String token = jwtUtility.generateToken(userDetails);
        return new JwtResponse(token);
    }





    @PostMapping("/register")
    public String userRegistration(@RequestBody User user){
        try {
            System.out.println("Email: "+user.getEmail());
            userRepo.save(user);
        }catch(Exception e){
            System.out.println("Exception:"+e.getMessage());
            return "Registration Failed:" + e.getMessage();
        }

        return "Success";
    }

    @PostMapping("/login")
    public String userLogin(@RequestBody Login login){

        if(userRepo.existsByEmail(login.getEmail()))
            return "User Exists";

        return "User Does not Exists";

    }

    @GetMapping("/{name}")
    public String getUserByName(@PathVariable String name){
        if (userRepo.existsUserByName(name))return "Exists";
        return "Doesn't Exists";
    }


}
