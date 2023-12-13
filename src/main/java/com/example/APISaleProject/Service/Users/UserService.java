package com.example.APISaleProject.Service.Users;

import com.example.APISaleProject.Exception.user.UserAlreadyExist;
import com.example.APISaleProject.Exception.user.UserNotFoundException;
import com.example.APISaleProject.Model.Users.User;
import com.example.APISaleProject.Repository.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Transactional
    public void savaFuncionario(User user) throws UserAlreadyExist{
        Optional<User> studentExist = userRepository.findById(user.getLogin());
        if(!studentExist.isPresent()){
            user.setPassword(encoder.encode(user.getPassword()));
            userRepository.save(user);
        }
        else
            throw new UserAlreadyExist("Email already present in database: " + user.getLogin());

    }

    public User searchByEmail(String email) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(email);

        if(!user.isPresent()) {
            throw new UserNotFoundException("Email not found in database.");
        }

        return user.get();
    }
}
