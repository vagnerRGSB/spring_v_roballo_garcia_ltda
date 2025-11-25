package com.vagner.v_roballo_garcia_ltda.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CadastroCredenciaisDTO {
    
    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 60, message = "O nome deve ter entre 3 e 60 caracteres")
    // Regex de Segurança (Allow List): Letras, Números, Espaços e Hífens apenas.
    @Pattern(regexp = "^[a-zA-Z0-9À-ÿ\\s\\-]+$", message = "O nome contém caracteres inválidos")
    private String nome;

    @Size(max = 60, message = "O sobrenome deve ter no máximo 60 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9À-ÿ\\s\\-]+$", message = "O sobrenome contém caracteres inválidos")
    private String sobreNome;

    // --- DADOS DE LOGIN (Vão para a tabela 'credenciais') ---

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Formato de email inválido")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    // Regra: Tamanho EXATO de 8 caracteres
    @Size(min = 8, max = 8, message = "A senha deve ter exatamente 8 caracteres")
    // Regra: Complexidade Obrigatória (Maiúscula + Minúscula + Número + Especial)
    @Pattern(
        regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8}$",
        message = "A senha deve conter: letra maiúscula, minúscula, número e caractere especial."
    )
    private String senha;
}
