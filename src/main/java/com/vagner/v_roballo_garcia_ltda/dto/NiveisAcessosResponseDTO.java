package com.vagner.v_roballo_garcia_ltda.dto;

import com.vagner.v_roballo_garcia_ltda.entity.NiveisAcessosEntity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class NiveisAcessosResponseDTO {

    private Integer id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 60, message = "O nome deve conter entre 3 até 60 caracteres!")
    @Pattern(regexp = "^[a-zA-Z0-9À-ÿ\\s\\-]+$", message = "O nome contém caracteres inválidos!")
    private String nome;

    public NiveisAcessosResponseDTO(){}
    public NiveisAcessosResponseDTO(NiveisAcessosEntity niveisAcessosEntity){
        this.id = niveisAcessosEntity.getId();
        this.nome = niveisAcessosEntity.getNome();
    }
    
}
