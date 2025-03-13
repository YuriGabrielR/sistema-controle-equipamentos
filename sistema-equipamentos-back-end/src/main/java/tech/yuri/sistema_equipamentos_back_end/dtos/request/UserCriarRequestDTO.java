package  tech.yuri.sistema_equipamentos_back_end.dtos.request;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import tech.yuri.sistema_equipamentos_back_end.enums.Role;


public class UserCriarRequestDTO {

    @NotNull(message="O campo nome não pode ser vazio")
    private String nome; 

    @NotNull(message="O campo email não pode ser vazio.")
    @Pattern(regexp="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Informe um e-mail válido")
    private String email; 

    @NotNull(message="A senha não pode ser vazia")
    @NotBlank(message="A senha não pode conter espaços vazios")
    @Length(min=6, message="A senha precisa ter no mínimo 6 caracteres")
    private String password; 

    @NotNull(message="Informe sua função!")
    @JsonProperty("funcao")
    private Role role; 

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


}