package com.example.atividade_pontuada.repository;

import com.example.atividade_pontuada.model.ClienteModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
    // Utiliza o email como verificação
    Optional<ClienteModel> findByEmail(String email);
}
