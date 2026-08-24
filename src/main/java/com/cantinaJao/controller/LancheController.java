package com.cantinaJao.controller;

import com.cantinaJao.DTO.LancheRequestDTO;
import com.cantinaJao.DTO.LancheResponseDTO;
import com.cantinaJao.model.Lanche;
import com.cantinaJao.service.LancheService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Controle de Lanches")
@RestController
public class LancheController {

    @Autowired
    private LancheService lancheService;

    @GetMapping("/listar-todos")
    @Operation(summary = "Listar todos os lanches", description = "Retorna uma lista completa de lanches cadastrados")
    public List<LancheResponseDTO> listarTodos() {
        return lancheService.listar();
    }

    @PostMapping("/cadastrar-lanche")
    @Operation(summary = "Cadastrar novos lanches", description = "Cadastra um aluno lanche na CantinaJao")
    public ResponseEntity<LancheResponseDTO> cadastrar(@Valid @RequestBody LancheRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(lancheService.cadastrar(dto));
    }

    @GetMapping("/Buscar-por-id/{id}")
    @Operation(summary = "Buscar lanches por id", description = "Retorna um lanche especifico da CantinaJao")
    public LancheResponseDTO buscarPorId(@PathVariable Long id) {
        return lancheService.buscarPorId(id);
    }

    @PutMapping("Atualizar/{id}")
    @Operation(summary = "Atualiza lanche por id", description = "Atualiza todos o lanche de um lanche existente")
    public ResponseEntity<LancheResponseDTO> atualizar(@Valid @PathVariable Long id,@Valid @RequestBody Lanche lanche){
        return ResponseEntity.status(HttpStatus.CREATED).body(lancheService.atualizar(id, lanche));
    }

    @DeleteMapping("Excluir/{id}")
    @Operation(summary = "Excluir lanche por id", description = "Exclui um lanche especifico da CantinaJao")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        lancheService.remover(id);
        return ResponseEntity.noContent().build();
    }
}
