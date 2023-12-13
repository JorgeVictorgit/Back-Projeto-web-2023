package com.example.APISaleProject.Dto.User;

import com.example.APISaleProject.Model.Users.User;

public record DadosUsuariosDto(String nome, String data, String login, String senha, String identifier) {

    public DadosUsuariosDto(User usuario) {
        this( usuario.getName(), usuario.getBirthdate(), usuario.getLogin(), usuario.getPassword(), usuario.getIdentifier());
    }

}