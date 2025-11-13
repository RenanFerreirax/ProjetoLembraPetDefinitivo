package com.senac.projectlembrapet.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "lembrete")
public class Lembrete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lembrete_id")
    private Long id;

    @NotBlank(message = "Título do lembrete é obrigatório")
    @Size(max = 100, message = "Título deve ter no máximo 100 caracteres")
    @Column(name = "lembrete_titulo")
    private String titulo;

    @Column(name = "lembrete_descricao", columnDefinition = "TEXT")
    private String descricao;

    @NotNull(message = "Data e hora do lembrete são obrigatórias")
    @Column(name = "lembrete_data_hora")
    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    @Column(name = "lembrete_status")
    private StatusLembrete status;

    @Column(name = "lembrete_criado_em")
    private LocalDateTime criadoEm;

    @Column(name = "lembrete_atualizado_em")
    private LocalDateTime atualizadoEm;

    @NotNull(message = "Usuário é obrigatório")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @NotNull(message = "Categoria é obrigatória")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToMany(mappedBy = "lembrete", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Notificacao> notificacoes;

    public enum StatusLembrete {
        PENDENTE, CONCLUIDO
    }

    // Construtores
    public Lembrete() {}

    public Lembrete(String titulo, String descricao, LocalDateTime dataHora, StatusLembrete status, Usuario usuario, Categoria categoria) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.status = status;
        this.usuario = usuario;
        this.categoria = categoria;
        this.criadoEm = LocalDateTime.now();
        this.atualizadoEm = LocalDateTime.now();
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public StatusLembrete getStatus() {
        return status;
    }

    public void setStatus(StatusLembrete status) {
        this.status = status;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(LocalDateTime atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Notificacao> getNotificacoes() {
        return notificacoes;
    }

    public void setNotificacoes(List<Notificacao> notificacoes) {
        this.notificacoes = notificacoes;
    }
}
