package com.example.atividade_pontuada.repository;

import com.example.atividade_pontuada.model.EntregadorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntregadorRepository extends JpaRepository<EntregadorModel, Long> {
    // Utiliza o email como verificação
    Optional<EntregadorModel> findByEmail(String email);
}
