package my.kkc.kkafka

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
//@EnableBinding(Source::class)
//@EnableKafka
class App

fun main(args: Array<String>): Unit {
    SpringApplication.run(App::class.java)
}

