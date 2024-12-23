package ro.popa.kafkaconfiguration.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActiveWindow {
    private String title;
    @JsonProperty("start_time")
    private Long startTime;
    private Long duration;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ActiveWindow{");
        sb.append("title='").append(title).append('\'');
        sb.append(", startTime=").append(startTime);
        sb.append(", duration=").append(duration);
        sb.append('}');
        return sb.toString();
    }
}
