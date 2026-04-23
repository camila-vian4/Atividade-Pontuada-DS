package com.example.atividade_pontuada.repository;

import com.example.atividade_pontuada.model.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long> {
    // Utiliza o email como verificação
    Optional<FuncionarioModel> findByEmail(String email);
}
