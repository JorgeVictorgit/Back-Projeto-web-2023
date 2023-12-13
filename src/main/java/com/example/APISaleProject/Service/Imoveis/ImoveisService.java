package com.example.APISaleProject.Service.Imoveis;

import com.example.APISaleProject.Dto.Imoveis.RegisterImoveisDto;
import com.example.APISaleProject.Exception.user.UserAlreadyExist;
import com.example.APISaleProject.Exception.user.UserException;
import com.example.APISaleProject.Exception.user.UserUnauthorizedException;
import com.example.APISaleProject.Model.Imoveis.Imoveis;
import com.example.APISaleProject.Model.Users.User;
import com.example.APISaleProject.Repository.ImoveisRepository.ImoveisRepository;
import com.example.APISaleProject.Repository.Users.UserRepository;
import com.example.APISaleProject.Service.Token.JWTService;
import com.example.APISaleProject.Service.Users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImoveisService {
    @Autowired
    private ImoveisRepository imoveisRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTService jwtService;

    public void savaImovel(RegisterImoveisDto dto, String email) throws UserAlreadyExist, UserException {
        Optional<User> ClientExist = userRepository.findById(email);
        if (!jwtService.isVendedor(email)) {
            throw new UserUnauthorizedException("Only a teacher can create a classroom.");
        }

        if (!ClientExist.isPresent()) {
            throw new UserAlreadyExist("Email already present in database: " + email);
        }
        User user = (User) ClientExist.get();
        var imoveis = new Imoveis(dto,user);
        imoveisRepository.save(imoveis);
    }


}
