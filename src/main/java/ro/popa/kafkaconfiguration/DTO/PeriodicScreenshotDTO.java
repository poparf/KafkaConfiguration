package ro.popa.kafkaconfiguration.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PeriodicScreenshotDTO {

    @JsonProperty("screenshot")
    private String screenshotB64Encoded;
    private Long timestamp;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PeriodicScreenshotDTO{");
        sb.append("image='").append(screenshotB64Encoded).append('\'');
        sb.append(", timestamp=").append(timestamp);
        sb.append('}');
        return sb.toString();
    }
}
