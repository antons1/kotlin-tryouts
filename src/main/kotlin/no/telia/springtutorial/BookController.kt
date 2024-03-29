package no.telia.springtutorial

import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller

@Controller
class BookController(val authorRepository: AuthorRepository, val bookRepository: BookRepository) {
    @QueryMapping
    fun books(): List<Book> {
        return bookRepository.getBooks()
    }

    @QueryMapping
    fun bookById(@Argument id: String): Book? {
        return bookRepository.getBookById(id)
    }

    @QueryMapping
    fun booksBetweenYears(@Argument lower: String, @Argument upper: String): List<Book> {
        return bookRepository.getBooks().filter { it.publishYear.toInt() >= lower.toInt() && it.publishYear.toInt() <= upper.toInt() }
    }

    @QueryMapping
    fun authors(): List<Author> {
        return authorRepository.findAuthors()
    }

    @QueryMapping
    fun authorById(@Argument id: String): Author? {
        return authorRepository.findAuthorById(id)
    }

    @QueryMapping
    fun authorByName(@Argument firstName: String, @Argument lastName: String): List<Author> {
        return authorRepository.findAuthorByName(firstName, lastName)
    }

    @SchemaMapping
    fun author(book: Book): Author? {
        return authorRepository.findAuthorById(book.authorId)
    }

    @SchemaMapping
    fun books(author: Author): List<Book> {
        return bookRepository.getBooksByAuthorId(author.id)
    }
}