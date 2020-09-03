package kr.hs.dgsw.juyeop.server.controller

import kr.hs.dgsw.juyeop.server.model.db.User
import kr.hs.dgsw.juyeop.server.repository.RegisterRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/register")
class RegisterController(val registerRepository: RegisterRepository) {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun registerUser(@RequestBody register: User): String {
        registerRepository.save(register)
        return "회원가입을 정상적으로 수행하였습니다."
    }
}