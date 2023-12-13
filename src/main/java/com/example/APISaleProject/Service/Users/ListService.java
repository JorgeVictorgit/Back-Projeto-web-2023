package com.example.APISaleProject.Service.Users;


import com.example.APISaleProject.Dto.User.DadosUsuariosDto;
import com.example.APISaleProject.Repository.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListService {
    @Autowired
    private UserRepository funcionariosRepository;

    public Page<DadosUsuariosDto> List(Pageable pagina){
        return funcionariosRepository.findAll(pagina).map(DadosUsuariosDto::new);
    }

}
