package com.example.atividade_pontuada.repository;

import com.example.atividade_pontuada.model.ClienteModel;
import com.example.atividade_pontuada.model.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
    Optional<ClienteModel> findyByEmail(String email);
}
