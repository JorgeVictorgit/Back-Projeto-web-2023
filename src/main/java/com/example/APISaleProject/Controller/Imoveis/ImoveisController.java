package com.example.APISaleProject.Controller.Imoveis;

import com.example.APISaleProject.Dto.Imoveis.RegisterImoveisDto;

import com.example.APISaleProject.Exception.user.UserException;

import com.example.APISaleProject.Service.Imoveis.ImoveisService;
import com.example.APISaleProject.Service.Token.JWTService;
import com.example.APISaleProject.Service.Users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/API")
@RestController
public class ImoveisController {
    @Autowired
    private ImoveisService userService;
    @Autowired
    private JWTService jwtService;
    public ImoveisController(ImoveisService cliservice,JWTService jwt) {

        this.userService = cliservice;
        this.jwtService = jwt;
    }
    @PostMapping(value = "/imoveis" ,produces = "application/json", consumes = "application/json")
    public ResponseEntity cadastroFuncionario(@RequestHeader("Authorization") String header, @RequestBody @Valid RegisterImoveisDto Dto)throws UserException{
        System.out.println(header);
        jwtService.userExists(header);
        String email = jwtService.getUserDoToken(header);
        System.out.println(email);
        userService.savaImovel(Dto,email);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
        return ResponseEntity.ok(page);
    }
}
