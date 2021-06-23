package net.matees.mateesapi.models.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends CrudRepository<User, Long> {

    @Query("SELECT s FROM User s WHERE s.email = ?1")
    Optional<User> getUserByEmail(String email);

    @Query("SELECT s FROM User s WHere s.id = ?2")
    User getUserById(Long id);
}
