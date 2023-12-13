package com.example.APISaleProject.Controller.Login;


import com.example.APISaleProject.Dto.Authenticate.DadosAutenticacaoDto;
import com.example.APISaleProject.Dto.Authenticate.DadosTokenDto;
import com.example.APISaleProject.Exception.user.UserNotFoundException;
import com.example.APISaleProject.Model.Users.User;
import com.example.APISaleProject.Service.Login.LoginResponse;
import com.example.APISaleProject.Service.Login.TokenService;
import com.example.APISaleProject.Service.Users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/Api")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;
    @Autowired
    public UserService userService;

    @PostMapping(value = "/login")
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacaoDto dados) throws UserNotFoundException {
        var authenticationtoken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authenticaon = manager.authenticate(authenticationtoken);
        var tokenjwt = tokenService.generateToken((User) authenticaon.getPrincipal());
        String emal = dados.login();
        User searchedUser = userService.searchByEmail(emal);
        return new ResponseEntity<LoginResponse>(tokenService.generateToken(searchedUser), HttpStatus.OK);
    }
}
