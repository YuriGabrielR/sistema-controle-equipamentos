package tech.yuri.sistema_equipamentos_back_end.repository; 

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.yuri.sistema_equipamentos_back_end.entity.User;


@Repository
public interface UserRepository extends  JpaRepository<User, UUID>{

    Optional<User>findByEmail(String email);
    
}