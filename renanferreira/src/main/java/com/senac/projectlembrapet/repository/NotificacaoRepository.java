package com.senac.projectlembrapet.repository;

import com.senac.projectlembrapet.entity.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {


    List<Notificacao> findByLembreteId(Long lembreteId);
}
