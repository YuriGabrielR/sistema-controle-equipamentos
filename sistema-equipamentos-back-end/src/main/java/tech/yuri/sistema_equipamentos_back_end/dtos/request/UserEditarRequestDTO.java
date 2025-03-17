package  tech.yuri.sistema_equipamentos_back_end.dtos.request;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;



public class UserEditarRequestDTO {

    @NotNull(message="O campo nome não pode ser vazio")
    private String nome; 

    @NotNull(message="O campo email não pode ser vazio.")
    @Pattern(regexp="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Informe um e-mail válido")
    private String email; 

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

}