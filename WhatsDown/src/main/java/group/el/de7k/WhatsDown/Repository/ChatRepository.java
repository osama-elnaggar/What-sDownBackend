package group.el.de7k.WhatsDown.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import group.el.de7k.WhatsDown.models.Chat;

public interface ChatRepository extends MongoRepository<Chat, String> {

    //List<Chat> findByParticipantsContaining(String userId);
}
