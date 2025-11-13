package com.senac.projectlembrapet.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long id;

    @NotBlank(message = "Nome do usuário é obrigatório")
    @Size(max = 100, message = "Nome do usuário deve ter no máximo 100 caracteres")
    @Column(name = "usuario_nome")
    private String nome;

    @NotBlank(message = "Email do usuário é obrigatório")
    @Email(message = "Email deve ser válido")
    @Size(max = 30, message = "Email deve ter no máximo 30 caracteres")
    @Column(name = "usuario_email", unique = true)
    private String email;

    @NotBlank(message = "Senha do usuário é obrigatória")
    @Size(max = 45, message = "Senha deve ter no máximo 45 caracteres")
    @Column(name = "usuario_senha")
    private String senha;

    @Column(name = "usuario_data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "usuario_status")
    private Integer status;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Lembrete> lembretes;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "usuario_role",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    // Construtores
    public Usuario() {}

    public Usuario(String nome, String email, String senha, LocalDateTime dataCriacao, Integer status) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataCriacao = dataCriacao;
        this.status = status;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Lembrete> getLembretes() {
        return lembretes;
    }

    public void setLembretes(List<Lembrete> lembretes) {
        this.lembretes = lembretes;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
