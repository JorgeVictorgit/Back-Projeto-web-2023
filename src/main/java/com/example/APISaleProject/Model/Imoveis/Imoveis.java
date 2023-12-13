package com.example.APISaleProject.Model.Imoveis;

import com.example.APISaleProject.Dto.Imoveis.RegisterImoveisDto;
import com.example.APISaleProject.Model.Users.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Imoveis")
public class Imoveis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;


    @Column(name = "valor", nullable = false, length = 50)
    private String valor;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "email")
    @JsonIgnore
    private User vendendor;


    @Column(name = "telefone", nullable = false, length = 2000)
    private String telefone;

    @Column(name = "cpf", nullable = false, length = 2000)
    private String cep;
    @Column(name = "img", nullable = false, length = 2000)
    private String img;


    public Imoveis(RegisterImoveisDto register, User u) {
        this.nome = register.getNome();
        this.valor = register.getValor();
        this.vendendor = u;
        this.telefone = register.getTelefone();
        this.cep = register.getCep();
        this.img = register.getImg();
    }
}
