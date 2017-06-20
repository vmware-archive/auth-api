package org.memoro.auth

@org.springframework.boot.autoconfigure.SpringBootApplication
open class Application {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            org.springframework.boot.SpringApplication.run(org.memoro.auth.Application::class.java, *args)
        }
    }
}