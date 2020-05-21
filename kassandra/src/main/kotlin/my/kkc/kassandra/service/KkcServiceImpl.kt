package my.kkc.kassandra.service

import com.fasterxml.jackson.databind.ObjectMapper
import my.kkc.kassandra.data.KkcMessageRepo
import my.kkc.kassandra.data.KkcMessageTable
import my.kkc.kommon.model.KkcMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class KkcServiceImpl : KkcService {
    @Autowired lateinit var om: ObjectMapper
    @Autowired lateinit var repo: KkcMessageRepo

    override fun get(count: Int?): List<KkcMessage> {
        TODO()
    }

    override fun insert(str: String) {
        try {
            val msg = om.readValue(str, KkcMessage::class.java)
            println("parsed message $msg")
            repo.insert(KkcMessageTable.instance(msg))
        } catch (ex: Throwable) {
            // no action
            println(ex)
        }
    }

}