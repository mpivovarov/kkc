package my.kkc.kassandra.kafka

import my.kkc.kassandra.service.KkcService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service


@Service
class KafkaConsumer {

    @Autowired
    lateinit var kkcService: KkcService

    @KafkaListener(topics = [topic], groupId = "group_id")
    fun consume(message: String) {
        println("Consumed message $message")
        try {
            kkcService.insert(message)
        } catch (ex: Throwable) {
            // no action
            println(ex)
        }
    }

    companion object {
        @Value("\${kafka.topic:kkc_message}")
        private const val topic: String = "kkc_message"
    }
}