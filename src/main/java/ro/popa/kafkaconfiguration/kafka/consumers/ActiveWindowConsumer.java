package ro.popa.kafkaconfiguration.kafka.consumers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ro.popa.kafkaconfiguration.DTO.WindowActivityDTO;
import ro.popa.kafkaconfiguration.DTO.UserSystemDTO;
import ro.popa.kafkaconfiguration.entities.UserSystem;
import ro.popa.kafkaconfiguration.entities.WindowActivity;
import ro.popa.kafkaconfiguration.services.UserSystemService;
import ro.popa.kafkaconfiguration.services.WindowActivityService;

@Service
public class ActiveWindowConsumer {

    private final Logger logger = LoggerFactory.getLogger(ActiveWindowConsumer.class);
    private WindowActivityService windowActivityService;

    public ActiveWindowConsumer (WindowActivityService windowActivityService) {
        this.windowActivityService = windowActivityService;
    }

    @KafkaListener(topics="ro.popa.active-window.new", groupId="mainConsumerGroup")
    public void consume(String message) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(message);
            JsonNode userJsonNode = rootNode.get("user");
            UserSystemDTO userDTO = objectMapper.treeToValue(userJsonNode, UserSystemDTO.class);

            JsonNode activeWindowJsonNode = rootNode.get("data");
            WindowActivityDTO windowActivityDTO = objectMapper.treeToValue(activeWindowJsonNode, WindowActivityDTO.class);
            logger.info(String.format("Consumed message 1/2 -> %s", userDTO));
            logger.info(String.format("Consumed message 2/2 -> %s", windowActivityDTO));

            WindowActivity w = windowActivityService.saveWindowActivityData(windowActivityDTO, userDTO);
            logger.info(String.format("Saved window activity -> %s", w));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
