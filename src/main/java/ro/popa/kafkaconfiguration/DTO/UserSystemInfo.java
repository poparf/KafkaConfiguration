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
public class UserSystemInfo {
    private String username;
    @JsonProperty("computer_name")
    private String computerName;
    private String os;
    private String ip;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SystemInfo{");
        sb.append("username='").append(username).append('\'');
        sb.append(", computerName='").append(computerName).append('\'');
        sb.append(", os='").append(os).append('\'');
        sb.append(", ip='").append(ip).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
