package com.example.APISaleProject.Dto.Imoveis;

import com.example.APISaleProject.Model.Users.User;

public record DadosImoveisDto(String nome, String data, String login, String senha, String identifier) {

    public DadosImoveisDto(User usuario) {
        this( usuario.getName(), usuario.getBirthdate(), usuario.getLogin(), usuario.getPassword(), usuario.getIdentifier());
    }

}
