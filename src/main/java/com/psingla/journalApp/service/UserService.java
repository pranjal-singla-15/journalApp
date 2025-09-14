package com.psingla.journalApp.service;

import com.psingla.journalApp.entity.User;
import com.psingla.journalApp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean saveNewUser(User user){
        try{
            log.info("Saving new user");
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            user.setJournalEntries(new ArrayList<>());//Added later
            userRepository.save(user);
            return true;
        }
        catch(Exception e){
            log.error("Error occured in saving {}", user.getUserName(),e);
            return false;
        }
    }

    public void saveAdmin(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER", "ADMIN"));
        userRepository.save(user);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<User> getAll(){

        return userRepository.findAll();
    }

    public User findById(ObjectId id){
        Optional<User> entry = userRepository.findById(id);
        return entry.orElse(null);
    }

    public void deleteById(ObjectId id){

        userRepository.deleteById(id);
    }

    public User findByUserName(String userName){

        return userRepository.findByUserName(userName);
    }

}
