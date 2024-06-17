class Library {
    private List<Book> books = []

    void addBook(Book o) {
        books.add(o)
    }

    boolean removeBook(String title) {
        books.removeIf { it.title == title }
        if (books.isEmpty()) {
            books = null
        }
        return true
    }

    Book findBook(String title) {
        Book response = books.find { it.title == title }
        if (response == null) {
            throw new BookNotFoundException("Book with title '${title}' not found in the library.")
        } else {
            return response
        }
    }

    List<Book> listAllBooks() {
        books
    }

    static void showBook(Book o) {
        println "Title: ${o.getTitle()}, " +
                "Genre: ${o.getGenre()}, " +
                "Author: ${o.getAuthor()}, " +
                "Publish Date: ${o.getPublish_date().format('dd/MM/YYYY')}, " +
                "Actual Price: ${o.getPrice()}."
    }

    void showAllBooks() {
        this.listAllBooks().each {
            book -> showBook(book)
        }
    }

    void filterGenreBooks(String genre) {
        this.listAllBooks().findAll({ it.genre == genre }).each {
            book -> showBook(book)
        }
    }

}
