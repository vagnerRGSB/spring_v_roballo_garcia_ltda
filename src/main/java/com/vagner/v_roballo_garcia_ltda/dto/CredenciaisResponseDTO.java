package com.vagner.v_roballo_garcia_ltda.dto;

import com.vagner.v_roballo_garcia_ltda.entity.CredenciaisEntity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CredenciaisResponseDTO {

    private Integer id;

    @NotBlank(message = "Nome completo é obrigatório.")
    @Size(min = 3, max = 60, message = "Nome completo deve conter entre 3 até 60 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9À-ÿ\\s\\-]+$", message = "Nome completo contém caracteres inválidos.")
    private String nomeCompleto;

    @NotBlank(message = "E-mail é obrigatório.")
    @Email(message = "E-mail inválido.")
    private String email;

    @NotBlank(message = "Nível de acesso é obrigatório.")
    @Size(max=60, message = "Nível de acesso deve conter até 60 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9À-ÿ\\s\\-]+$", message = "Nível de Acesso contém caracteres inválidos.")
    private String nivelAcesso;

    public CredenciaisResponseDTO(){}
    public CredenciaisResponseDTO(CredenciaisEntity credenciaisEntity){
        this.id = credenciaisEntity.getId();
        this.email = credenciaisEntity.getEmail();

        if(credenciaisEntity.getUsuariosEntity() != null){
            String nome = credenciaisEntity.getUsuariosEntity().getNome();
            String sobreNome = credenciaisEntity.getUsuariosEntity().getSobreNome();

            this.nomeCompleto = nome + (sobreNome != null ? " "  + sobreNome : "");
        }

        if(credenciaisEntity.getNiveisAcessosEntity() != null){
            this.nivelAcesso = credenciaisEntity.getNiveisAcessosEntity().getNome();
        }
    }
}
