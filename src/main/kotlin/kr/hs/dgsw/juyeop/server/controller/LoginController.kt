package kr.hs.dgsw.juyeop.server.controller

import kr.hs.dgsw.juyeop.server.model.request.Login
import kr.hs.dgsw.juyeop.server.repository.RegisterRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/login")
class LoginController (val registerRepository: RegisterRepository) {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun loginUser(@RequestBody login: Login): String {
        try {
            val target = registerRepository.findById(login.id!!).get()

            if (target.pw.equals(login.pw)) return "로그인을 정상적으로 수행하였습니다."
            else return "일치하는 회원정보가 존재하지 않습니다."
        } catch (e: Exception) {
            return "일치하는 회원정보가 존재하지 않습니다."
        }
    }
}
