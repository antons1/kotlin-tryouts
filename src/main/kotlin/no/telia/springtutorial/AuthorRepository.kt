package no.telia.springtutorial

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.query
import org.springframework.stereotype.Repository

data class Author(val id: String, val firstName: String, val lastName: String);

@Repository
class AuthorRepository(val db: JdbcTemplate) {
    fun findAuthors(): List<Author> = db.query("SELECT * FROM authors") { response, _ ->
        Author(response.getString("id"), response.getString("firstname"), response.getString("lastname"))
    }

    fun findAuthorById(id: String): Author? = db.query("SELECT * FROM authors WHERE id::text = ?", id) { response, _ ->
        Author(response.getString("id"), response.getString("firstname"), response.getString("lastname"))
    }.firstOrNull()

    fun findAuthorByName(firstName: String, lastName: String): List<Author> = db.query("SELECT * FROM authors WHERE firstname = ? AND lastname = ?", firstName, lastName) { response, _ ->
        Author(response.getString("id"), response.getString("firstname"), response.getString("lastname"))
    }
}