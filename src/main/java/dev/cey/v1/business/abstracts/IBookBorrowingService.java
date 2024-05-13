package dev.cey.v1.business.abstracts;

import dev.cey.v1.entities.Author;
import dev.cey.v1.entities.BookBorrowing;
import org.springframework.data.domain.Page;

public interface IBookBorrowingService {
    BookBorrowing save(BookBorrowing bookBorrowing);

    BookBorrowing get(Long id);

    Page<BookBorrowing> cursor(int page, int pageSize);

    BookBorrowing update(BookBorrowing bookBorrowing);

    boolean delete(Long id);

}
