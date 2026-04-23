package com.example.atividade_pontuada.service;

import com.example.atividade_pontuada.model.ProdutoModel;
import com.example.atividade_pontuada.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<ProdutoModel> listarProdutos(){
        return repository.findAll();
    }

    public ProdutoModel addProduto(ProdutoModel produto){
        // Verifica se o lote já existe no banco.
        if (repository.findByLote(produto.getLote()).isPresent()){
            throw new RuntimeException("Produto já cadastrado com esse lote! ❌");
        }
        return repository.save(produto);
    }

    public ProdutoModel atualizarProduto(Long id, ProdutoModel produto){
        if(!repository.existsById(id)){
            throw new IllegalArgumentException("Produtos não encontrado! 🔍");
        }
        produto.setId(id);
        return repository.save(produto);
    }
    public void excluir(Long id){
        if(!repository.existsById(id)){
            throw new IllegalArgumentException("Produto não encontrado! 🗑️");
        }
        repository.deleteById(id);
    }
}