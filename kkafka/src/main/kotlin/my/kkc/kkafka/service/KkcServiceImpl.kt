package my.kkc.kkafka.service

import com.fasterxml.jackson.databind.ObjectMapper
import my.kkc.kkafka.kafka.KafkaProducer
import my.kkc.kkafka.model.Generator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class KkcServiceImpl : KkcService {

    @Autowired lateinit var kprod: KafkaProducer
    @Autowired lateinit var om: ObjectMapper

    override fun gen(count: Int) {
        require(count > 0)
        Generator.apply(count).map {
            val msg = om.writeValueAsString(it)
            println("send $msg")
            kprod.sendMessage(msg)
        }
    }

}


