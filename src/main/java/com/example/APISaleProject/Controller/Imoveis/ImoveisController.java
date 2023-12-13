package com.example.APISaleProject.Controller.Imoveis;

import com.example.APISaleProject.Dto.Imoveis.DadosImoveisDto;
import com.example.APISaleProject.Dto.Imoveis.RegisterImoveisDto;

import com.example.APISaleProject.Exception.user.UserException;

import com.example.APISaleProject.Repository.ImoveisRepository.ImoveisRepository;
import com.example.APISaleProject.Service.Imoveis.ImoveisService;
import com.example.APISaleProject.Service.Token.JWTService;
import com.example.APISaleProject.Service.Users.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/API")
@RestController
public class ImoveisController {
    @Autowired
    private ImoveisService imoveisService;
    @Autowired
    private JWTService jwtService;
    @Autowired
    private ListService listService;
    @Autowired
    private ImoveisRepository imoveisRepository;
    public ImoveisController(ImoveisService cliservice,JWTService jwt) {

        this.imoveisService = cliservice;
        this.jwtService = jwt;
    }
    @PostMapping(value = "/imoveis" ,produces = "application/json", consumes = "application/json")
    public ResponseEntity cadastroUsuario(@RequestHeader("Authorization") String header, @RequestBody @Valid RegisterImoveisDto Dto)throws UserException{
        System.out.println(header);
        jwtService.userExists(header);
        String email = jwtService.getUserDoToken(header);
        System.out.println(email);
        imoveisService.savaImovel(Dto,email);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/listimoveis")
    public ResponseEntity<Page<DadosImoveisDto>> getUsuario(@PageableDefault(size = 10,sort = {"id"}) Pageable pagina){
        return ResponseEntity.ok(listService.List(pagina));
    }
    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {

        imoveisRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
