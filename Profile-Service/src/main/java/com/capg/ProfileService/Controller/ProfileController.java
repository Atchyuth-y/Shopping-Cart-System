package com.capg.ProfileService.Controller;

import com.capg.ProfileService.Model.AutenticationRequest;
import com.capg.ProfileService.Model.User;
import com.capg.ProfileService.Service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    ProfileService service;

    /*@RequestMapping(value="/authenticate",method = RequestMethod.POST)
    public AutenticationRequest createAuthenticationToker (@RequestBody AutenticationRequest authenticationRequest) throws Exception {
        try {
            service.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect Username Or Password", e);
        }
        return authenticationRequest;
    }*/

    @PostMapping("/register")
    public User registerNewCustomerProfile(@RequestBody User user) {
        return service.registerNewCustomerProfile(user);
    }

    @GetMapping("/show")
    public List<User> getAllProfiles() {
        return service.getAllProfiles();
    }

    @PutMapping("update/{id}")
    public User updateProfile(@RequestBody User user, @PathVariable("id") int uId) {
        return service.updateProfile(user, uId);
    }



    @DeleteMapping("/delete/{id}")
    public void deleteProfileById(@PathVariable("id") int uId) {
        service.deleteProfileById(uId);
    }

}
