package my.kkc.kassandra.service

import com.fasterxml.jackson.databind.ObjectMapper
import my.kkc.kommon.model.KkcMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class KkcServiceImpl : KkcService {
    @Autowired lateinit var om: ObjectMapper

    override fun get(count: Int?): List<KkcMessage> {
        TODO()
    }

    override fun insert(str: String) {
        val msg = om.readValue(str, KkcMessage::class.java)
        println("parsed message $msg")
    }

}