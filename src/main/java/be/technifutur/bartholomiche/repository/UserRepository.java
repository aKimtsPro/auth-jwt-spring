package be.technifutur.bartholomiche.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import be.technifutur.bartholomiche.model.entities.User;


public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);
}
