static void main(String[] args) {

  def groovyShell = new GroovyShell()
  def books = groovyShell.evaluate(new File('books.groovy'))
  def users = groovyShell.evaluate(new File('users.groovy'))
  def customers = new HashSet<Customer>()
  def library = new Library()

  users.each { user -> customers.add(user as Customer) }
  books.each { book -> library.addBook(book as Book) }

  library.findBook("C++ for beginners").setDiscount(new BigDecimal("50"))

  def tempCustomer = customers.find {it.name == "Gustavo Vieira"}
  def tempSecondCustomer = customers.find { it.name == "Gustavo Henriques"}

  try {
    tempCustomer.addBook(library.findBook("C++ for beginners"))
    tempCustomer.addBook(library.findBook("Java for experts"))
    tempSecondCustomer.addBook(library.findBook("C++ for beginners"))
    tempSecondCustomer.removeBook(tempSecondCustomer.getLast_book_taken().getTitle())
  } catch (BookNotFoundException e) {
      println "${e.message}"
  }

  tempCustomer.getCustomerBooks().showAllBooks()
  customers.each { user -> user.showCustomer() }

}