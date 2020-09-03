package kr.hs.dgsw.juyeop.server.controller

import kr.hs.dgsw.juyeop.server.model.db.Todo
import kr.hs.dgsw.juyeop.server.repository.TodoRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/todo")
class TodoController(val todoRepository: TodoRepository) {

    @GetMapping
    fun getAllTodo(): List<Todo> {
        return todoRepository.findAll()
    }

    @RequestMapping(path = ["/{todoIdx}"], method = [RequestMethod.GET])
    fun getTodo(@PathVariable("todoIdx") todoIdx: Long): Optional<Todo> {
        return todoRepository.findById(todoIdx)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun createTodo(@RequestBody todo: Todo): String{
        todoRepository.save(todo)
        return "Todo 항목을 정상적으로 추가했습니다."
    }

    @RequestMapping(path = ["/{todoIdx}"], method = [RequestMethod.PUT])
    @ResponseStatus(HttpStatus.OK)
    fun updateTodo(@RequestBody todo: Todo, @PathVariable("todoIdx") todoIdx: Long): String {
        val target = todoRepository.findById(todoIdx).get()
        target.title = todo.title
        target.description = todo.description
        target.finished = todo.finished

        todoRepository.save(target)
        return "Todo 항목을 정상적으로 수정했습니다."
    }

    @RequestMapping(path = ["/{todoIdx}"], method = [RequestMethod.DELETE])
    @ResponseStatus(HttpStatus.OK)
    fun deleteTodo(@PathVariable("todoIdx") todoIdx: Long): String {
        todoRepository.deleteById(todoIdx)
        return "Todo 항목을 정상적으로 삭제하였습니다."
    }
}