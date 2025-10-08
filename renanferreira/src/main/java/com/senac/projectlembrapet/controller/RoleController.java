package com.senac.projectlembrapet.controller;

import com.senac.projectlembrapet.entity.Role;
import com.senac.projectlembrapet.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<Role> getAll() {
        return roleService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Role> getById(@PathVariable Long id) {
        return roleService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public Role create(@Valid @RequestBody Role role) {
        return roleService.save(role);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Role> update(@PathVariable Long id, @Valid @RequestBody Role role) {
        if (!roleService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        role.setId(id);
        return ResponseEntity.ok(roleService.save(role));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!roleService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        roleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
