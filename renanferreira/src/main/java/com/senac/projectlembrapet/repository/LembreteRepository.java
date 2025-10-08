package com.senac.projectlembrapet.repository;

import com.senac.projectlembrapet.entity.Lembrete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface LembreteRepository extends JpaRepository<Lembrete, Long> {


    List<Lembrete> findByUsuarioId(Long usuarioId);


    List<Lembrete> findByCategoriaId(Long categoriaId);
}
