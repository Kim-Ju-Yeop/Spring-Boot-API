package kr.hs.dgsw.juyeop.server.model.db

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "user")
class User {

    @Id
    var id: String? = null

    var pw: String? = null
    var name: String? = null
}