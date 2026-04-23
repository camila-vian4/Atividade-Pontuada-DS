package com.example.atividade_pontuada.controller;

import com.example.atividade_pontuada.model.EntregadorModel;
import com.example.atividade_pontuada.service.EntregadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/entregadores")
public class EntregadorController {
    @Autowired
    private EntregadorService service;

    @GetMapping
    public List<EntregadorModel> listarEntregadores(){
        return service.listarEntregadores();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> addEntregador(@RequestBody EntregadorModel entregador){
        service.addEntregador(entregador);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem", "Entregador cadastrado com sucesso! 😁"));
    }

    @DeleteMapping("/{id}")
    // Exclui o entregador pelo ID
    public ResponseEntity<Map<String, Object>> excluirEntregador(@PathVariable Long id) {
        service.excluir(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("mensagem", "Entregador excluído com sucesso! 🗑️"));
    }

    @PutMapping("/{id}")
    // Atualiza o entregador pelo ID
    public ResponseEntity<Map<String, Object>> atualizarEntregador(@PathVariable Long id,
                                                                   @RequestBody EntregadorModel entregador){

        service.atualizarEntregador(id, entregador);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Funcionário atualizado com sucesso! ✏️"));
    }
}