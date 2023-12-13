package com.example.APISaleProject.Model.Users;

import com.example.APISaleProject.Dto.User.RegisterUserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Usuarios")
public class User implements UserDetails {

    @Column(name = "nome", nullable = false, length = 50)
    private String name;


    @Column(name = "dataAniversario", nullable = false, length = 50)
    private String birthdate;
    @Id
    @Column(name = "login", nullable = false, length = 50)
    private String login;


    @Column(name = "lenha", nullable = false, length = 2000)
    private String password;

    @Column(name = "tipoConta", nullable = false, length = 50)
    private String identifier;

    public User(String email, String name,  String password, String identifier) {
        this.login = email;
        this.name = name;
        this.password = password;
        this.identifier = identifier;
    }

    public User(RegisterUserDto register) {
        this.name = register.getNome();
        this.login = register.getEmail();
        this.birthdate = register.getData();
        this.password = register.getSenha();
        this.identifier = register.getIdentifier();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
