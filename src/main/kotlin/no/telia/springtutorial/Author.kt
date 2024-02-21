package no.telia.springtutorial;

data class Author(val id: String, val firstName: String, val lastName: String);

object AuthorRepository {
    private val authors = listOf(
        Author("author-1", "Joshua", "Bloch"),
        Author("author-2", "Douglas", "Adams"),
        Author("author-3", "Bill", "Bryson")
    )

    fun getById(id: String): Author? {
        return authors.find { it.id == id}
    }
}