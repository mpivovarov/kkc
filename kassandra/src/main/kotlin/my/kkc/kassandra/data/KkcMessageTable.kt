package my.kkc.kassandra.data

import my.kkc.kommon.model.KkcMessage
import org.springframework.data.cassandra.core.cql.PrimaryKeyType
import org.springframework.data.cassandra.core.mapping.Column
import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn
import org.springframework.data.cassandra.core.mapping.Table
import java.time.Instant
import java.util.*

@Table("message")
data class KkcMessageTable (
        @PrimaryKeyColumn(name = "message_id", type = PrimaryKeyType.PARTITIONED)
        val messageId: UUID,
        val timestamp: Instant,
        val subject: String,
        val message: String
)  {
        fun unapply() = KkcMessage(
                this.messageId,
                this.timestamp,
                this.subject,
                this.message
        )

        companion object {
                fun apply(kkcm: KkcMessage) = KkcMessageTable(
                        kkcm.messageId,
                        kkcm.timestamp,
                        kkcm.subject,
                        kkcm.message
                )
        }
}