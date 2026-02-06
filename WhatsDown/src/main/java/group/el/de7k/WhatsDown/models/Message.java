package group.el.de7k.WhatsDown.models;

import java.time.Instant;
import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "messages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    @Id
    private String id = UUID.randomUUID().toString();

    private String chatId;
    private String senderId;
    private String receiverId;

    private String content;
    private Instant timestamp;
    private MessageType messageType;

}
