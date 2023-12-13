package com.example.APISaleProject.Service.Login;


import com.example.APISaleProject.Repository.Users.LoginRepository;
import com.example.APISaleProject.Repository.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {
    @Autowired
    private LoginRepository loginRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("LOGIN A SER CONSULTADO: " +username);
        return loginRepository.findByLogin(username);
    }

}
