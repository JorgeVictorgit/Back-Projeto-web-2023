package com.example.APISaleProject.Dto.Imoveis;

import com.example.APISaleProject.Dto.User.DadosUsuariosDto;
import com.example.APISaleProject.Dto.User.RegisterUserDto;
import com.example.APISaleProject.Model.Imoveis.Imoveis;
import com.example.APISaleProject.Model.Users.User;


public record DadosImoveisDto(Long id, String nome, String valor, User vendedor, String telefone, String cep, String img) {

    public DadosImoveisDto(Imoveis imoveis) {
        this(imoveis.getId(), imoveis.getNome(), imoveis.getValor(), imoveis.getVendendor(), imoveis.getTelefone(),  imoveis.getCep(), imoveis.getImg());
    }


}
