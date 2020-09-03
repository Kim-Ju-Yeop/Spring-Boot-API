package kr.hs.dgsw.juyeop.server.model.db

import javax.persistence.*

@Entity
@Table(name = "todo")
class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    var idx: Long? = null

    var title: String? = null
    var description: String? = null
    var finished: Boolean = false
}