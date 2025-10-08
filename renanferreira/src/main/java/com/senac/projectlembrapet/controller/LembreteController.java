package com.senac.projectlembrapet.controller;

import com.senac.projectlembrapet.entity.Lembrete;
import com.senac.projectlembrapet.service.LembreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/lembretes")
public class LembreteController {

    @Autowired
    private LembreteService lembreteService;


    @GetMapping
    public List<Lembrete> getAll() {
        return lembreteService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Lembrete> getById(@PathVariable Long id) {
        return lembreteService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/usuario/{usuarioId}")
    public List<Lembrete> getByUsuario(@PathVariable Long usuarioId) {
        return lembreteService.findByUsuarioId(usuarioId);
    }


    @GetMapping("/categoria/{categoriaId}")
    public List<Lembrete> getByCategoria(@PathVariable Long categoriaId) {
        return lembreteService.findByCategoriaId(categoriaId);
    }


    @PostMapping
    public Lembrete create(@Valid @RequestBody Lembrete lembrete) {
        return lembreteService.save(lembrete);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Lembrete> update(@PathVariable Long id, @Valid @RequestBody Lembrete lembrete) {
        if (!lembreteService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        lembrete.setId(id);
        return ResponseEntity.ok(lembreteService.save(lembrete));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!lembreteService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        lembreteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
