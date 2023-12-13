package com.example.APISaleProject.Repository.Users;


import com.example.APISaleProject.Model.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface LoginRepository extends JpaRepository<User,Long> {
    UserDetails findByLogin(String login);
}

