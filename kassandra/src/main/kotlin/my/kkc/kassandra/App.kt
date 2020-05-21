package my.kkc.kassandra

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
//@EnableBinding(Sink::class)
//@EnableKafka
class App

fun main(args: Array<String>): Unit {
    SpringApplication.run(App::class.java)
}

