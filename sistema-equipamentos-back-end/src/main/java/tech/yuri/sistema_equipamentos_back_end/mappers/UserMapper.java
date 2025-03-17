package tech.yuri.sistema_equipamentos_back_end.mappers; 

import org.springframework.stereotype.Component;

import tech.yuri.sistema_equipamentos_back_end.dtos.response.UserResponseDTO;
import tech.yuri.sistema_equipamentos_back_end.entity.User;


@Component
public class UserMapper {

    public UserResponseDTO toDTO(User user){

        if(user == null){
            return null;
        }

        UserResponseDTO userDTO = new UserResponseDTO(); 
        userDTO.setId(user.getId());
        userDTO.setNome(user.getNome());
        userDTO.setEmail(user.getEmail());
        userDTO.setRole(user.getRole());

        return userDTO;
    }


    public User toEntity(UserResponseDTO userDTO, String password){

        if(userDTO == null){
            return null;
        }

        User user = new User(); 
        user.setId(userDTO.getId());
        user.setNome(userDTO.getNome()); 
        user.setEmail(userDTO.getEmail()); 
        user.setPassword(password);
        user.setRole(userDTO.getRole());

        return user;
    }





}