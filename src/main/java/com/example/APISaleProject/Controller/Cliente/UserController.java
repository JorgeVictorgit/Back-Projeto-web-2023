package com.example.APISaleProject.Controller.Cliente;

import com.example.APISaleProject.Dto.User.DadosUsuariosDto;
import com.example.APISaleProject.Dto.User.RegisterUserDto;
import com.example.APISaleProject.Exception.user.UserAlreadyExist;
import com.example.APISaleProject.Model.Users.User;

import com.example.APISaleProject.Service.Users.ListService;
import com.example.APISaleProject.Service.Users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api")
@RestController
public class UserController {
    @Autowired
    public UserService userService;

    @Autowired
    public ListService listService;


    public UserController(UserService cliservice) {

        this.userService = cliservice;
    }
    @PostMapping(value = "/cliente")
    public ResponseEntity cadastroUsuario(@RequestBody @Valid RegisterUserDto registerUserDto) throws UserAlreadyExist {
        var user = new User(registerUserDto);
        userService.savaUsuario(user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/list")
    public ResponseEntity<Page<DadosUsuariosDto>> getUsuario(@PageableDefault(size = 10,sort = {"name"}) Pageable pagina){
        return ResponseEntity.ok(listService.ListUsuarios(pagina));
    }
}
