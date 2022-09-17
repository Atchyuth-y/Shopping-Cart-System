package com.capg.ProfileService.Service;

import com.capg.ProfileService.Model.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ProfileService {
    User registerNewCustomerProfile(User user);
    List<User> getAllProfiles();
    Optional<User> getByProfileId(int uId);
    User updateProfile(User user, int profileId);

    void deleteProfileById(int profileId);

   // void authenticate(UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken);
}
