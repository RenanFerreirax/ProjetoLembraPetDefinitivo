package com.senac.projectlembrapet.controller;

import com.senac.projectlembrapet.entity.Notificacao;
import com.senac.projectlembrapet.service.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/notificacoes")
public class NotificacaoController {

    @Autowired
    private NotificacaoService notificacaoService;


    @GetMapping
    public List<Notificacao> getAll() {
        return notificacaoService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Notificacao> getById(@PathVariable Long id) {
        return notificacaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/lembrete/{lembreteId}")
    public List<Notificacao> getByLembrete(@PathVariable Long lembreteId) {
        return notificacaoService.findByLembreteId(lembreteId);
    }


    @PostMapping
    public Notificacao create(@Valid @RequestBody Notificacao notificacao) {
        return notificacaoService.save(notificacao);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Notificacao> update(@PathVariable Long id, @Valid @RequestBody Notificacao notificacao) {
        if (!notificacaoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        notificacao.setId(id);
        return ResponseEntity.ok(notificacaoService.save(notificacao));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!notificacaoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        notificacaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
