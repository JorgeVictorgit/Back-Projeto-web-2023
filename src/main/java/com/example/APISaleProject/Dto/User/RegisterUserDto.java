package com.example.APISaleProject.Dto.User;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RegisterUserDto {



    public String nome;


    public String email;

    public String data;

    public String senha;

    public String identifier;

}
