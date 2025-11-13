package com.senac.projectlembrapet.service;

import com.senac.projectlembrapet.entity.Notificacao;
import com.senac.projectlembrapet.repository.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;


    public List<Notificacao> findAll() {
        return notificacaoRepository.findAll();
    }


    public Optional<Notificacao> findById(Long id) {
        return notificacaoRepository.findById(id);
    }


    public List<Notificacao> findByLembreteId(Long lembreteId) {
        return notificacaoRepository.findByLembreteId(lembreteId);
    }


    public Notificacao save(Notificacao notificacao) {
        return notificacaoRepository.save(notificacao);
    }


    public void deleteById(Long id) {
        notificacaoRepository.deleteById(id);
    }
}
