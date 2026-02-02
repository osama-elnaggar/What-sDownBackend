package group.el.de7k.WhatsDown.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import group.el.de7k.WhatsDown.models.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
}
