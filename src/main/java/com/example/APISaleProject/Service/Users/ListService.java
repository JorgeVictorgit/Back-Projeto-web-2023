package com.example.APISaleProject.Service.Users;


import com.example.APISaleProject.Dto.Imoveis.DadosImoveisDto;
import com.example.APISaleProject.Dto.User.DadosUsuariosDto;
import com.example.APISaleProject.Repository.ImoveisRepository.ImoveisRepository;
import com.example.APISaleProject.Repository.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ImoveisRepository imoveisRepository;

    public Page<DadosUsuariosDto> ListUsuarios(Pageable pagina){
        return userRepository.findAll(pagina).map(DadosUsuariosDto::new);
    }

    public Page<DadosImoveisDto> List(Pageable pagina){
        return imoveisRepository.findAll(pagina).map(DadosImoveisDto::new);
    }

}
