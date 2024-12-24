package ro.popa.kafkaconfiguration.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="user_system")
public class UserSystem {
    private String id;
    private String username;
    private String computer_name;
    private String os;
    private String ip;
}
