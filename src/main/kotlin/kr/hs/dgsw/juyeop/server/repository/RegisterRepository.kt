package kr.hs.dgsw.juyeop.server.repository

import kr.hs.dgsw.juyeop.server.model.db.User
import org.springframework.data.jpa.repository.JpaRepository

interface RegisterRepository: JpaRepository<User, String>