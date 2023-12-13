package com.example.APISaleProject.Repository.ImoveisRepository;

import com.example.APISaleProject.Model.Imoveis.Imoveis;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ImoveisRepository extends JpaRepository<Imoveis,Long> {
}
