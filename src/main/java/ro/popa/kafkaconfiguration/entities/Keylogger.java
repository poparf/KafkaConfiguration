package ro.popa.kafkaconfiguration.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection="keylogger")
public class Keylogger {
    @Id
    private String id;
    @DBRef
    private UserSystem userSystem;

    private Date startTime;
    private String keys;
    private Date endTime;
}
