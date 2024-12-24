package ro.popa.kafkaconfiguration.kafka.consumers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ro.popa.kafkaconfiguration.DTO.ActiveWindow;
import ro.popa.kafkaconfiguration.DTO.UserSystemInfo;
import ro.popa.kafkaconfiguration.entities.UserSystem;
import ro.popa.kafkaconfiguration.services.UserSystemService;

@Service
public class ActiveWindowConsumer {

    private final Logger logger = LoggerFactory.getLogger(ActiveWindowConsumer.class);
    @Autowired
    private UserSystemService userSystemService;

    @KafkaListener(topics="ro.popa.active-window.new", groupId="mainConsumerGroup")
    public void consume(String message) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(message);
            JsonNode userJsonNode = rootNode.get("user");
            UserSystemInfo user = objectMapper.treeToValue(userJsonNode, UserSystemInfo.class);

            JsonNode activeWindowJsonNode = rootNode.get("data");
            ActiveWindow activeWindow = objectMapper.treeToValue(activeWindowJsonNode, ActiveWindow.class);
            logger.info(String.format("Consumed message 1/2 -> %s", user));
            logger.info(String.format("Consumed message 2/2 -> %s", activeWindow));

            UserSystem userSystem = new UserSystem();
            userSystem.setUsername(user.getUsername());
            userSystem.setOs(user.getOs());
            userSystem.setComputer_name(user.getComputerName());
            userSystem.setIp(user.getIp());
            UserSystem userSystemSaved = userSystemService.save(userSystem);
            logger.info(String.format("UserSystem saved -> %s", userSystemSaved));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
