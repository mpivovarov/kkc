package my.kkc.kkafka.kafka

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaProducer {

    @Autowired
    lateinit var kafkaTemplate: KafkaTemplate<String, String>

    fun sendMessage(message: String) {
        kafkaTemplate.send(topic, message)
        println("Produced message $message")
    }

    companion object {
        @Value("\${kafka.topic:kkc_message}")
        private const val topic: String = "kkc_message"
    }
}