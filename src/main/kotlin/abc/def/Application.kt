package abc.def

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java)
}

@RestController
class FooController {

    @PostMapping("/api/foo")
    fun post() {
        throw RuntimeException("Hello Foo")
    }

}

@RestControllerAdvice
class ErrorHandlers {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception::class)
    fun handle(e: Exception): String {
        return """{ "message": "${e.message}" }"""
    }

}
