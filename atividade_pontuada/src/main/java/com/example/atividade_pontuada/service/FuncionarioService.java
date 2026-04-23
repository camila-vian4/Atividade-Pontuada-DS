package com.example.atividade_pontuada.service;

import com.example.atividade_pontuada.model.FuncionarioModel;
import com.example.atividade_pontuada.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public List<FuncionarioModel> listarFuncionarios(){
        return repository.findAll();
    }

    public FuncionarioModel addFuncionario(FuncionarioModel funcionario){
        // Verifica se o email já existe no banco.
        if (repository.findByEmail(funcionario.getEmail()).isPresent()){
            throw new RuntimeException("Funcionário já cadastrado com esse e-mail! ❌");
        }
        return repository.save(funcionario);
    }

    public FuncionarioModel atualizarFuncionario(Long id, FuncionarioModel funcionario){
        if (!repository.existsById(id)){
            throw new IllegalArgumentException("Funcionário não encontrado! 🔍");
        }

        funcionario.setId(id);
        return repository.save(funcionario);
    }

    public void excluir (Long id){
        if (!repository.existsById(id)){
            throw new IllegalArgumentException("Funcionário não encontrado! 🗑️");
        }
        repository.deleteById(id);
    }
}