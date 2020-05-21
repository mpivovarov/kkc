package my.kkc.kkafka.configuration

import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory


@Configuration
class KafkaProducerConfiguration {
    @Value("\${kafka.host:localhost}")
    private val host: String = "localhost"

    @Value("\${kafka.port:9092}")
    private val port: Int = 9092

    @Bean
    fun producerFactory(): ProducerFactory<String, String> {
        val configProps = HashMap<String, Any>()
        configProps[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = "$host:$port"
        configProps[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        configProps[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        return DefaultKafkaProducerFactory(configProps)
    }

    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, String> {
        return KafkaTemplate(producerFactory())
    }

    companion object {
        const val TOPIC = "kkc_message"
    }
}

//interface KafkaStreams {
//    @Input("greetings-in")
//    fun inboundGreetings(): SubscribableChannel
//    @Output("greetings-out")
//    fun outboundGreetings(): MessageChannel
//}
//
//@EnableBinding(KafkaStreams::class)
//class StreamsConfig

