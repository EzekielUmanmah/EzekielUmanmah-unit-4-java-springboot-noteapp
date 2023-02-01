package com.devmountain.noteApp.Services;

import com.devmountain.noteApp.DTOs.UserDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    @Transactional
    List<String> addUser(UserDTO userDTO);

    @Transactional
    List<String> userLogin(UserDTO userDTO);
}
