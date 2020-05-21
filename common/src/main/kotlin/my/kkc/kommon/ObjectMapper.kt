package my.kkc.kommon

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.context.annotation.Bean

@Bean
fun om(): ObjectMapper {
    return ObjectMapper().apply {
        registerModule(JavaTimeModule())
        registerModule(KotlinModule())
        disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
    }
}