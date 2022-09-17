package com.capg.ProfileService.Service;

import com.capg.ProfileService.Model.User;
import com.capg.ProfileService.Repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    ProfileRepository repository;

    @Override
    public User registerNewCustomerProfile(User user) {
        user.setProfileId(sequenceGeneratorService.getSequenceNumber(User.SEQUENCE_NAME));
        return repository.save(user);
    }

    @Override
    public List<User> getAllProfiles() {
        return repository.findAll();
    }

    @Override
    public Optional<User> getByProfileId(int uId) {
        Optional<User> user = repository.findById(uId);
        return user;
    }

    @Override
    public User updateProfile(User user, int uId) {
        User pro= repository.findById(uId).get();
        pro.setFullName(user.getFullName());
        pro.setGender(user.getGender());
        pro.setEmailId(user.getEmailId());
        pro.setMobileNumber(user.getMobileNumber());
        return repository.save(pro);

    }

    @Override
    public void deleteProfileById(int uId) {
        repository.deleteById(uId);
    }

   /* @Override
    public void authenticate(UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) {

    }*/
}
