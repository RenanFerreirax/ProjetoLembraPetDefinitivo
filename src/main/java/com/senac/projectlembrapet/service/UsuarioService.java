package com.senac.projectlembrapet.service;

import com.senac.projectlembrapet.entity.Role;
import com.senac.projectlembrapet.entity.Usuario;
import com.senac.projectlembrapet.repository.RoleRepository;
import com.senac.projectlembrapet.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }


    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }


    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }


    public Usuario register(Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuario.setDataCriacao(LocalDateTime.now());
        // Atribuir role padrão, ex: USER
        Optional<Role> userRole = roleRepository.findByName("USER");
        if (userRole.isPresent()) {
            usuario.setRoles(List.of(userRole.get()));
        }
        return usuarioRepository.save(usuario);
    }


    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }


    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }
}
