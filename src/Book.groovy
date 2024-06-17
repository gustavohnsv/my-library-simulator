import groovy.transform.TupleConstructor
import java.time.LocalDate

@TupleConstructor(includeFields = true) // TupleConstructor is a public access constructor, "includeFields = true" make him access private fields
class Book {
    private final String title
    private final String genre
    private final String author
    private final LocalDate publish_date
    private BigDecimal price

    String getTitle() {
        return title
    }

    String getGenre() {
        return genre
    }

    String getAuthor() {
        return author
    }

    LocalDate getPublish_date() {
        return publish_date
    }

    BigDecimal getPrice() {
        return price
    }

    void setPrice(BigDecimal price) {
        this.price = price
    }

    void setDiscount (BigDecimal discount) {
        this.price = this.price.subtract(this.price * discount.divide(new BigDecimal("100")))
    }

    @Override
    String toString() {
        return "Book(title: ${getTitle()}, genre: ${getGenre()}, author: ${getAuthor()}, publishDate: ${getPublish_date()}, price: ${getPrice()})"
    }

}
