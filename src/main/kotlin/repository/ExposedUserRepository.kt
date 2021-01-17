package repository

import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.UUID

class ExposedUserRepository : IUserRepository {
    companion object {
        val CONNECTION_STRING: String = "jdbc:postgresql://localhost:5432/postgres"
        val DB_USER = "postgres"
        val DB_PASSWORD = "password"
    }

    override fun save(user: User) {
        Database.connect(url = CONNECTION_STRING, user = DB_USER, password = DB_PASSWORD)
        transaction { user.toDAO() }
    }

    override fun find(name: UserName): User? {
        Database.connect(url = CONNECTION_STRING, user = DB_USER, password = DB_PASSWORD)
        return transaction {
            val users = UserDao.find { Users.name eq name.value }
            users.firstOrNull()?.toEntity()
        }
    }
}

// Schema
open class StringUUIDTable(name: String = "", columnName: String = "id") : IdTable<String>(name) {
    override val id: Column<EntityID<String>> = varchar(columnName, 36)
        .clientDefault { UUID.randomUUID().toString() }
        .entityId()
    override val primaryKey by lazy { super.primaryKey ?: PrimaryKey(id) }
}

object Users : StringUUIDTable() {
    val name = varchar("name", 30)
}

// DAO
class UserDao(id: EntityID<String>) : Entity<String>(id) {
    companion object : EntityClass<String, UserDao>(Users)

    var name by Users.name

    fun toEntity(): User = User(UserId(this.id.toString()), UserName(this.name))
}

fun User.toDAO(): UserDao {
    val id = this.id.value
    val n = this.name.value
    return UserDao.new(
        id,
        init = {
            name = n
        }
    )
}
