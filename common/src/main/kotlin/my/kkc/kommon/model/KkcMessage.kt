package my.kkc.kommon.model

import java.time.Instant
import java.util.*

class KkcMessage (
    val messageId: UUID,
    val timestamp: Instant,
    val subject: String,
    val message: String
) {
    override fun toString(): String {
        return "$messageId::$timestamp::$subject::$message"
    }
}

/* don't work since  https://github.com/Kotlin/kotlinx.serialization/issues/576
@Serializer(forClass = UUID::class)
object UUIDSerializer : KSerializer<UUID> {
    override val descriptor: SerialDescriptor
        get() = StringDescriptor.withName("UUID")

    override fun serialize(output: Encoder, obj: UUID) {
        output.encodeString(obj.toString())
    }

    @ImplicitReflectionSerializer
    override fun deserialize(input: Decoder): UUID {
        return UUID.fromString(input.decode())
    }
}

@Serializer(forClass = Instant::class)
object InstantSerializer : KSerializer<Instant> {
    override val descriptor: SerialDescriptor
        get() = StringDescriptor.withName("Instant")

    override fun serialize(output: Encoder, obj: Instant) {
        output.encodeString(obj.toEpochMilli().toString())
    }

    @ImplicitReflectionSerializer
    override fun deserialize(input: Decoder): Instant {
        return Instant.ofEpochMilli((input.decode<String>().toLong()))
    }
} */