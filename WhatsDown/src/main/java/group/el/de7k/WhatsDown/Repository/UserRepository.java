package group.el.de7k.WhatsDown.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import group.el.de7k.WhatsDown.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
