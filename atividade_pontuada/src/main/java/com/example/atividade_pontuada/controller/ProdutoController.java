package com.example.atividade_pontuada.controller;

import com.example.atividade_pontuada.model.ProdutoModel;
import com.example.atividade_pontuada.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<ProdutoModel> listarProdutos(){
        return service.listarProdutos();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> addProduto(@RequestBody ProdutoModel produto){
        service.addProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem", "Produto cadastrado com sucesso! 😁"));
    }

    @DeleteMapping("/{id}")
    // Exclui o entregador pelo ID
    public ResponseEntity<Map<String, Object>> excluirProduto(@PathVariable Long id){
        service.excluir(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Produto excluído com sucesso! ✅🗑️"));
    }

    @PutMapping("/{id}")
    // Atualiza o produto pelo ID
    public ResponseEntity<Map<String, Object>> atualizarProduto(@PathVariable Long id,
                                                                @RequestBody ProdutoModel produto){
        service.atualizarProduto(id, produto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Produto atualizado com sucesso! ✏️"));
    }
}