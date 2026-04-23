package com.example.atividade_pontuada.repository;

import com.example.atividade_pontuada.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
    // Utiliza o lote como verificação
    Optional<ProdutoModel> findByLote(String lote);
}
