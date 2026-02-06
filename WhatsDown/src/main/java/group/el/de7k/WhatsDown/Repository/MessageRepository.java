package group.el.de7k.WhatsDown.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import group.el.de7k.WhatsDown.models.Message;

public interface MessageRepository extends MongoRepository<Message, String> {

    //List<Message> findByChatIdOrderByCreatedAtAsc(String chatId);
}
