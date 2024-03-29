package no.telia.springtutorial;

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.query
import org.springframework.stereotype.Repository

data class Book (val id: String, val name: String, val authorId: String, val publishYear: String)

@Repository
class BookRepository(val db: JdbcTemplate) {
    fun getBooks(): List<Book> = db.query("SELECT * FROM books ORDER BY publishyear DESC") { result, _ ->
        Book(result.getString("id"), result.getString("name"), result.getString("authorid"), result.getString("publishyear"))
    }

    fun getBookById(id: String): Book? = db.query("SELECT * FROM books WHERE id::text = ? ORDER BY publishyear DESC", id) { result, _ ->
        Book(result.getString("id"), result.getString("name"), result.getString("authorid"), result.getString("publishyear"))
    }.firstOrNull()

    fun getBooksByAuthorId(authorId: String): List<Book> = db.query("SELECT * FROM books WHERE authorid::text = ? ORDER BY publishyear DESC", authorId) { result, _ ->
        Book(result.getString("id"), result.getString("name"), result.getString("authorid"), result.getString("publishyear"))
    }
}