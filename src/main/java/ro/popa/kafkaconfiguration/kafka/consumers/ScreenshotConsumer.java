package ro.popa.kafkaconfiguration.kafka.consumers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ro.popa.kafkaconfiguration.DTO.PeriodicScreenshotDTO;
import ro.popa.kafkaconfiguration.DTO.UserSystemDTO;
import ro.popa.kafkaconfiguration.services.PeriodicScreenshotService;


@Service
public class ScreenshotConsumer {

    private final Logger logger = LoggerFactory.getLogger(ActiveWindowConsumer.class);
    PeriodicScreenshotService periodicScreenshotService;

    public ScreenshotConsumer(PeriodicScreenshotService periodicScreenshotService) {
        this.periodicScreenshotService = periodicScreenshotService;
    }

    @KafkaListener(topics = "ro.popa.screenshot.new", groupId="mainConsumerGroup")
    public void consume(String message) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(message);

            JsonNode userJsonNode = rootNode.get("user");
            UserSystemDTO userDTO = objectMapper.treeToValue(userJsonNode, UserSystemDTO.class);

            JsonNode screenshotJsonNode = rootNode.get("data");
            PeriodicScreenshotDTO periodicScreenshotDTO = objectMapper.treeToValue(screenshotJsonNode, PeriodicScreenshotDTO.class);
            logger.info(String.format("Consumed message 1/2 -> %s", userDTO));
            logger.info(String.format("SCREENSHOT Consumed message 2/2 -> %s", periodicScreenshotDTO));

            periodicScreenshotService.saveScreenshot(periodicScreenshotDTO,  userDTO);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
