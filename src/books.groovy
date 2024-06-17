import java.time.LocalDate

def books = [
        new Book(
                "C++ for beginners",
                "Programming",
                "Gustavo Vieira",
                LocalDate.of(2024, 6, 30),
                new BigDecimal("39.99")
        ),
        new Book(
                "Java for experts",
                "Programming",
                "Gustavo Henriques",
                LocalDate.of(1999, 12, 31),
                new BigDecimal("129.99")
        ),
        new Book(
                "Effective Java",
                "Programming",
                "Joshua Bloch",
                LocalDate.of(2018, 1, 6),
                new BigDecimal("39.99")
        ),
        new Book(
                "Animal's Revolution",
                "Fiction",
                "George Orwell",
                LocalDate.of(1945, 8, 17),
                new BigDecimal("29.99")
        )
]
