package tech.yuri.sistema_equipamentos_back_end.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import tech.yuri.sistema_equipamentos_back_end.dtos.request.UserCriarRequestDTO;
import tech.yuri.sistema_equipamentos_back_end.dtos.response.UserResponseDTO;
import tech.yuri.sistema_equipamentos_back_end.entity.User;
import tech.yuri.sistema_equipamentos_back_end.exceptions.EmailExistenteException;
import tech.yuri.sistema_equipamentos_back_end.exceptions.UsuarioNaoEncontradoException;
import tech.yuri.sistema_equipamentos_back_end.mappers.UserMapper;
import tech.yuri.sistema_equipamentos_back_end.repository.UserRepository;


@Service
public class UserService {

    private final UserRepository userRepository; 
    private final UserMapper userMapper; 

    public UserService(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
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


    public List<UserResponseDTO> listar(){

       var result =  userRepository.findAll();
       var resultToDTO = result.stream()
                               .map(usuario -> new UserResponseDTO
                               (usuario.getId(), 
                               usuario.getNome(), 
                               usuario.getEmail(), 
                               usuario.getRole())).collect(Collectors.toList()
        ); 

       return resultToDTO;
    }
    
    public UserResponseDTO listarPorId(String id){

        var user = userRepository.findById(Long.valueOf(id)).orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário com ID " + id + " não encontrado."));
        return userMapper.toDTO(user);    

    }


    public void deletar(String id){
        var idLong = Long.valueOf(id); 

        var usuarioExiste = userRepository.findById(idLong).orElseThrow(()-> new UsuarioNaoEncontradoException("Usuário com ID" + id + " não encontrado."));

        userRepository.deleteById(usuarioExiste.getId());
    }

}