package com.example.atividade_pontuada.controller;

import com.example.atividade_pontuada.model.ClienteModel;
import com.example.atividade_pontuada.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public List<ClienteModel> listarClientes() {
        return service.listarClientes();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> addCliente(@RequestBody ClienteModel cliente) {
        service.addCliente(cliente);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Cliente cadastrado com sucesso! 😁"));
    }

    @PutMapping("/{id}")
    // Atualiza o cliente pelo ID
    public ResponseEntity<Map<String, Object>> atualizarCliente(@PathVariable Long id,
                                                                @RequestBody ClienteModel cliente) {
        service.atualizarCliente(id, cliente);

        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem", "Cliente atualizado com sucesso! ✏️"));
    }

    @DeleteMapping("/{id}")
    // Exclui o cliente pelo ID
    public ResponseEntity<Map<String, Object>> excluirCliente(@PathVariable Long id){
        service.excluir(id);

        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem", "Cliente excluído com sucesso! ✅🗑️"));
    }

}