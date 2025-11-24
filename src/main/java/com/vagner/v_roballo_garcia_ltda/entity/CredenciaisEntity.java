package com.vagner.v_roballo_garcia_ltda.entity;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "credenciais")
public class CredenciaisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 60, unique = true, nullable = false)
    private String email;

    @Column(length = 200, nullable = false)
    private String senha;

    @OneToOne
    @JoinColumn(name = "usuarios_id", nullable = false, unique = true)
    private UsuariosEntity usuariosEntity;

    @ManyToOne
    @JoinColumn(name = "niveis_acessos_id", nullable = false)
    private NiveisAcessosEntity niveisAcessosEntity;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "update_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deleted_at;

    @PrePersist 
    protected void onCreate(){
        createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    
    @PrePersist
    protected void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }
}
