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
@Document(collection="window_activity")
public class WindowActivity {
    @Id
    private String id;
    @DBRef
    private UserSystem userSystem;

    private String title;
    private Long duration;
    private Date timestamp;
}
