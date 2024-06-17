import java.time.LocalDateTime

class Customer  {
    private final String firstName
    private final String lastName
    private Library customerBooks
    private Book last_book_taken
    private LocalDateTime create_at
    private LocalDateTime update_at

    Customer(String firstName, String lastName) {
        this.firstName = firstName
        this.lastName = lastName
        this.customerBooks = null
        this.create_at = LocalDateTime.now()
        this.update_at = LocalDateTime.now()
    }

    String getName() {
        return firstName + " " + lastName
    }

    Library getCustomerBooks() {
        return customerBooks
    }

    Book getLast_book_taken() {
        return last_book_taken
    }

    LocalDateTime getCreate_at() {
        return create_at
    }

    LocalDateTime getUpdate_at() {
        return update_at
    }

    void setLast_book_taken(Book o) {
        this.last_book_taken = o
    }

    void setUpdate_at() {
        this.update_at = LocalDateTime.now()
    }

    void addBook(Book o) {
        if (!customerBooks) {
            this.customerBooks = new Library()
        }
        customerBooks.addBook(o)
        setLast_book_taken(o)
        setUpdate_at()
    }

    void removeBook(String title) {
        customerBooks.removeBook(title)
        setUpdate_at()
    }

    void showCustomer() {
        println "Name: ${getName()}, " +
                "Create at: ${getCreate_at().format('dd/MM/YYYY HH:mm:ss')}, " +
                "Last update at: ${getUpdate_at().format('dd/MM/YYYY HH:mm:ss')}, " +
                "Has books: ${(getCustomerBooks() != null && getCustomerBooks().listAllBooks() != null)}, " +
                "Last book: ${getLast_book_taken() != null ? getLast_book_taken().getTitle() : "No books takes"}."
    }

}
