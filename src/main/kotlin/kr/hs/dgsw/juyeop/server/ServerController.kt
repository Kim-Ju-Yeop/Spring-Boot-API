package kr.hs.dgsw.juyeop.server

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class ServerController {
    @RequestMapping(method = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE])
    fun index(): String = "Welcome to visit Juyeop Spring Boot Server!"
}