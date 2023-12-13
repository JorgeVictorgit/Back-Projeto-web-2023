package com.example.APISaleProject.Dto.Authenticate;

import lombok.Data;

@Data
public class DadosTokenDto {

    public String token;
    public DadosTokenDto(String tokenjwt) {
        this.token= tokenjwt;
    }
}