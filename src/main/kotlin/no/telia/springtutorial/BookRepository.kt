package no.telia.springtutorial;

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.query
import org.springframework.stereotype.Repository

data class Book (val id: String, val name: String, val pageCount: Int, val authorId: String)

@Repository
class BookRepository(val db: JdbcTemplate) {
    fun getBooks(): List<Book> = db.query("SELECT * FROM books") { result, _ ->
        Book(result.getString("id"), result.getString("name"), result.getInt("pagecount"), result.getString("authorid"))
    }

    fun getBookById(id: String): Book? = db.query("SELECT * FROM books WHERE id::text = ?", id) { result, _ ->
        Book(result.getString("id"), result.getString("name"), result.getInt("pagecount"), result.getString("authorid"))
    }.firstOrNull()

    fun getBooksByAuthorId(authorId: String): List<Book> = db.query("SELECT * FROM books WHERE authorid::text = ?", authorId) { result, _ ->
        Book(result.getString("id"), result.getString("name"), result.getInt("pagecount"), result.getString("authorid"))
    }
}