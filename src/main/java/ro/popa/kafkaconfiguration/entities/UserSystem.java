package ro.popa.kafkaconfiguration.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="user_system")
@CompoundIndexes({
        @CompoundIndex(
                name = "username_computerName_idx",
                def = "{'username' : 1, 'computerName' : 1}",
                unique = true
        )
})
public class UserSystem {
    @Id
    private String id;
    private String username;
    private String computerName;
    private String os;
    private String ip;
}
