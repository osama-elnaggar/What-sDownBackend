package group.el.de7k.WhatsDown.models;

import java.util.Set;
import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "chats")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chat {

    @Id
    private String id = UUID.randomUUID().toString();

    private Set<String> participantIds;
    private String lastMessage;

    //private java.util.Map<String, Integer> unreadMessageCounts;
}
