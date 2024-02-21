package no.telia.springtutorial;

data class Book (val id: String, val name: String, val pageCount: Int, val authorId: String)

object BookRepository {
    private val books = listOf(
        Book("book-1", "Effective Java", 416, "author-1"),
        Book("book-2", "Hitchhikers Guide to the Galaxy", 208, "author-2"),
        Book("book-3", "Down Under", 436, "author-3")
    )

    fun getById(id: String): Book? {
        return books.find { it.id == id }
    }
}