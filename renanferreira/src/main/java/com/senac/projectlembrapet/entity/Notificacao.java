package com.senac.projectlembrapet.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Entity
@Table(name = "notificacao")
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notificacao_id")
    private Long id;

    @Column(name = "notificacao_status_enviado_em")
    private LocalDateTime statusEnviadoEm;

    @Enumerated(EnumType.STRING)
    @Column(name = "notificacao_status_envio")
    private StatusEnvio statusEnvio;

    @NotNull(message = "Lembrete é obrigatório")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lembrete_id")
    private Lembrete lembrete;

    public enum StatusEnvio {
        AGENDADA, ENVIADA, FALHOU
    }


    public Notificacao() {}

    public Notificacao(LocalDateTime statusEnviadoEm, StatusEnvio statusEnvio, Lembrete lembrete) {
        this.statusEnviadoEm = statusEnviadoEm;
        this.statusEnvio = statusEnvio;
        this.lembrete = lembrete;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStatusEnviadoEm() {
        return statusEnviadoEm;
    }

    public void setStatusEnviadoEm(LocalDateTime statusEnviadoEm) {
        this.statusEnviadoEm = statusEnviadoEm;
    }

    public StatusEnvio getStatusEnvio() {
        return statusEnvio;
    }

    public void setStatusEnvio(StatusEnvio statusEnvio) {
        this.statusEnvio = statusEnvio;
    }

    public Lembrete getLembrete() {
        return lembrete;
    }

    public void setLembrete(Lembrete lembrete) {
        this.lembrete = lembrete;
    }
}
