package com.senac.projectlembrapet.service;

import com.senac.projectlembrapet.entity.Lembrete;
import com.senac.projectlembrapet.repository.LembreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class LembreteService {

    @Autowired
    private LembreteRepository lembreteRepository;


    public List<Lembrete> findAll() {
        return lembreteRepository.findAll();
    }


    public Optional<Lembrete> findById(Long id) {
        return lembreteRepository.findById(id);
    }


    public List<Lembrete> findByUsuarioId(Long usuarioId) {
        return lembreteRepository.findByUsuarioId(usuarioId);
    }


    public List<Lembrete> findByCategoriaId(Long categoriaId) {
        return lembreteRepository.findByCategoriaId(categoriaId);
    }


    public Lembrete save(Lembrete lembrete) {
        lembrete.setAtualizadoEm(LocalDateTime.now());
        if (lembrete.getId() == null) {
            lembrete.setCriadoEm(LocalDateTime.now());
        }
        return lembreteRepository.save(lembrete);
    }


    public void deleteById(Long id) {
        lembreteRepository.deleteById(id);
    }
}
