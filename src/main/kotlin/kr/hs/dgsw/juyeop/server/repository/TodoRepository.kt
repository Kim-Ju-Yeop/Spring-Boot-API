package kr.hs.dgsw.juyeop.server.repository

import kr.hs.dgsw.juyeop.server.model.db.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository: JpaRepository<Todo, Long>