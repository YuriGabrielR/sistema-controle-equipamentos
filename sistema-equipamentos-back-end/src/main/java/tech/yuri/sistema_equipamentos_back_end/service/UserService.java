package tech.yuri.sistema_equipamentos_back_end.service;

import org.springframework.stereotype.Service;

import tech.yuri.sistema_equipamentos_back_end.dtos.request.UserCriarRequestDTO;
import tech.yuri.sistema_equipamentos_back_end.entity.User;
import tech.yuri.sistema_equipamentos_back_end.exceptions.EmailExistenteException;
import tech.yuri.sistema_equipamentos_back_end.repository.UserRepository;


@Service
public class UserService {

 private final UserRepository userRepository; 

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void criar(UserCriarRequestDTO data){

       userRepository.findByEmail(data.getEmail()) .ifPresent(usuario -> {
            throw new EmailExistenteException("Já existe um usuário com o email: " + data.getEmail());
        });


        var dataEntity = new User(); 

        dataEntity.setId(null);
        dataEntity.setNome(data.getNome());
        dataEntity.setEmail(data.getEmail());
        dataEntity.setPassword(data.getPassword());
        dataEntity.setRole(data.getRole());
    
        userRepository.save(dataEntity); 
    }


}