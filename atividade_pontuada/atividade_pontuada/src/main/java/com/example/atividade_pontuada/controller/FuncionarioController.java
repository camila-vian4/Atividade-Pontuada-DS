package com.example.atividade_pontuada.controller;

import com.example.atividade_pontuada.model.FuncionarioModel;
import com.example.atividade_pontuada.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping
    public List<FuncionarioModel> listarFuncionarios(){
        return service.listarFuncionarios();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> addFuncionario(@PathVariable Long id,
                                                              @RequestBody FuncionarioModel funcionario){
        service.addFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem", "Funcionário cadastrado com sucesso! 😁"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> excluirFuncionario(@PathVariable Long id){
        service.excluir(id);

        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem", "Funcionário excluído com sucesso! ✅🗑️"));
    }
}
