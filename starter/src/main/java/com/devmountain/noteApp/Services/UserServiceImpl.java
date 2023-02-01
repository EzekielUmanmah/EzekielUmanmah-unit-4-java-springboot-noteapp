package com.devmountain.noteApp.Services;

import com.devmountain.noteApp.DTOs.UserDTO;
import com.devmountain.noteApp.Entities.User;
import com.devmountain.noteApp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public List<String> addUser(UserDTO userDTO){
        List<String> response = new ArrayList<>();
        User user = new User(userDTO);
        userRepository.saveAndFlush(user);
        response.add("User successfully added.");
        return response;
    }

    @Override
    @Transactional
    public List<String> userLogin(UserDTO userDTO){
        List<String> response = new ArrayList<>();
        Optional<User> userOptional = userRepository.findByUsername(userDTO.getUsername());

        if (userOptional.isPresent() && passwordEncoder.matches(userDTO.getPassword(), userOptional.get().getPassword())) {
            response.add("User successfully logged in.");
            response.add(String.valueOf(userOptional.get().getId()));
        } else {
            response.add("Invalid username or password.");
        }
        return response;
    }
}
