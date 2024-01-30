package br.com.dianome.entregadores.controller;

import br.com.dianome.entregadores.dto.EntregadorDto;
import br.com.dianome.entregadores.service.EntregadorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/entregadores")
public class EntregadorController {

    @Autowired
    private EntregadorService service;

    @PostMapping
    public ResponseEntity<EntregadorDto> cadastrar(@RequestBody @Valid EntregadorDto dto, UriComponentsBuilder uriBuilder) {
        EntregadorDto entregador = service.criarEntregador(dto);
        URI endereco = uriBuilder.path("/entregadores/{id}").buildAndExpand(entregador.getId()).toUri();
        return ResponseEntity.created(endereco).body(entregador);
    }

    @GetMapping
    public Page<EntregadorDto> listarTodos(@PageableDefault(size = 10)Pageable paginacao) {
        return service.obterTodos(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntregadorDto> obeterInfo(@PathVariable @NotNull Long id) {
        EntregadorDto dto = service.obterPorId(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<EntregadorDto> atualizar(@PathVariable @NotNull Long id, @RequestBody @Valid EntregadorDto dto) {
        EntregadorDto atualizado = service.atualizarEntregador(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EntregadorDto> deletar(@PathVariable @NotNull Long id) {
        service.excluirEntregador(id);
        return ResponseEntity.noContent().build();
    }
}
