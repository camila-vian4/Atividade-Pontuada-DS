package com.example.atividade_pontuada.service;

import com.example.atividade_pontuada.model.EntregadorModel;
import com.example.atividade_pontuada.repository.EntregadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregadorService {

    @Autowired
    private EntregadorRepository repository;

    public List<EntregadorModel> listarEntregadores(){
        return repository.findAll();
    }

    public EntregadorModel addEntregador(EntregadorModel entregador){
        // Verifica se o lote já existe no banco.
        if (repository.findByEmail(entregador.getEmail()).isPresent()){
            throw new RuntimeException(("Entregadores já cadastrado com esse e-mail! ❌"));
        }
        return repository.save(entregador);
    }

    public EntregadorModel atualizarEntregador(Long id, EntregadorModel entregador){
        if (!repository.existsById(id)){
            throw new IllegalArgumentException("Entregador não encontrado! 🔍");
        }

        entregador.setId(id);
        return repository.save(entregador);
    }

    public void excluir (Long id){
        if (!repository.existsById(id)){
            throw new IllegalArgumentException("Entregador não encontrado! 🗑️");
        }
        repository.deleteById(id);
    }
}
