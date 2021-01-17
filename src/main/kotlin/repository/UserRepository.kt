package repository

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet

class UserRepository : IUserRepository {
    companion object {
        val CONNECTION_STRING: String = "jdbc:postgresql://localhost:5432/postgres"
        val DB_USER = "postgres"
        val DB_PASSWORD = "password"
    }

    override fun save(user: User) {
        var conn: Connection? = null
        var statement: PreparedStatement? = null

        try {
            conn = DriverManager.getConnection(CONNECTION_STRING, DB_USER, DB_PASSWORD)
            // language=PostgreSQL
            val sql = """
                INSERT INTO users(id, name) VALUES (?, ?)
                ON CONFLICT(id) DO UPDATE SET name = ?
            """.trimIndent()
            statement = conn.prepareStatement(sql)
            statement?.setString(1, user.id.value)
            statement?.setString(2, user.name.value)
            statement?.setString(3, user.name.value)
            statement.executeUpdate()
        } finally {
            statement?.close()
            conn?.close()
        }
    }

    override fun delete(user: User) {
        var conn: Connection? = null
        var statement: PreparedStatement? = null

        try {
            conn = DriverManager.getConnection(CONNECTION_STRING, DB_USER, DB_PASSWORD)
            // language=PostgreSQL
            val sql = """
                DELETE FROM users WHERE id = ?
            """.trimIndent()
            statement = conn.prepareStatement(sql)
            statement?.setString(1, user.id.value)
            statement.executeUpdate()
        } finally {
            statement?.close()
            conn?.close()
        }
    }

    override fun find(id: UserId): User? {
        var conn: Connection? = null
        var statement: PreparedStatement? = null
        var resultSet: ResultSet? = null

        try {
            conn = DriverManager.getConnection(CONNECTION_STRING, DB_USER, DB_PASSWORD)
            // language=PostgreSQL
            val sql = "SELECT * FROM users WHERE id = ?"
            statement = conn.prepareStatement(sql)
            statement?.setString(1, id.value)
            resultSet = statement.executeQuery()
            while (resultSet.next()) {
                val id = resultSet.getString("id")
                val userName = resultSet.getString("name")
                val mailAddress = resultSet.getString("mail_address")
                return User(UserId(id), UserName(userName), MailAddress(mailAddress))
            }
        } finally {
            resultSet?.close()
            statement?.close()
            conn?.close()
        }
        return null
    }

    override fun find(name: UserName): User? {
        var conn: Connection? = null
        var statement: PreparedStatement? = null
        var resultSet: ResultSet? = null

        try {
            conn = DriverManager.getConnection(CONNECTION_STRING, DB_USER, DB_PASSWORD)
            // language=PostgreSQL
            val sql = "SELECT * FROM users WHERE name = ?"
            statement = conn.prepareStatement(sql)
            statement?.setString(1, name.value)
            resultSet = statement.executeQuery()
            while (resultSet.next()) {
                val id = resultSet.getString("id")
                val userName = resultSet.getString("name")
                val mailAddress = resultSet.getString("mail_address")
                return User(UserId(id), UserName(userName), MailAddress(mailAddress))
            }
        } finally {
            resultSet?.close()
            statement?.close()
            conn?.close()
        }
        return null
    }
}
