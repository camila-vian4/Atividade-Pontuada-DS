package com.example.atividade_pontuada.service;

import com.example.atividade_pontuada.model.ClienteModel;
import com.example.atividade_pontuada.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public List<ClienteModel> listarClientes(){
        return repository.findAll();
    }

    public ClienteModel addCliente(ClienteModel cliente){
        // Verifica se o lote já existe no banco.
        if (repository.findByEmail(cliente.getEmail()).isPresent()){
            throw new RuntimeException("Cliente já cadastrado com esse e-mail! ❌");
        }
        return repository.save(cliente);
    }

    public ClienteModel atualizarCliente(Long id, ClienteModel cliente){
        if (!repository.existsById(id)){
            throw new IllegalArgumentException("Cliente não encontrado! 🔍");
        }
        cliente.setId(id);
        return repository.save(cliente);
    }

    public void excluir(Long id){
        if (!repository.existsById(id)){
            throw new IllegalArgumentException("Cliente não encontrado! ❌");
        }
        repository.deleteById(id);
    }
}