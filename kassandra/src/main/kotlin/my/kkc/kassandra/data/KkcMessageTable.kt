package my.kkc.kassandra.data

import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table
import java.time.Instant
import java.util.*

@Table("message")
data class KkcMessageTable (
        @PrimaryKey
        val id: Long,
        val messageId: UUID,
        val timestamp: Instant,
        val subject: String,
        val message: String
)