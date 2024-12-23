package ro.popa.kafkaconfiguration.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic window_topic() {
        return TopicBuilder.name("ro.popa.active-window.new")
                .partitions(10)
                .build();
    }

    @Bean
    public NewTopic keyboard_topic() {
        return TopicBuilder.name("ro.popa.keylogger.new")
                .partitions(10)
                .build();
    }

    @Bean
    public NewTopic system_topic() {
        return TopicBuilder.name("ro.popa.system-info.new")
                .partitions(10)
                .build();
    }
    @Bean
    public NewTopic screenshot_topic() {
        return TopicBuilder.name("ro.popa.screenshot.new")
                .partitions(10)
                .build();
    }
}
