package my.kkc.kkafka.model

import my.kkc.kommon.model.KkcMessage
import java.time.Instant
import java.util.*

object Generator {
    fun apply(count: Int): List<KkcMessage> {
        return (0 until count).map {
            val kkc: KkcMessage = KkcMessage(UUID.randomUUID(), Instant.now(), UUID.randomUUID().toString(), UUID.randomUUID().toString())
            println("Generator: generated $kkc")
            kkc
        }
    }
}