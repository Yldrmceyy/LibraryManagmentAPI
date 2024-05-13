package dev.cey.v1.business.abstracts;

import dev.cey.v1.entities.Book;
import org.springframework.data.domain.Page;

public interface IBookService {
    Book save(Book Book);

    Book get(Long id);

    Page<Book> cursor(int page, int pageSize);

    Book update(Book Book);

    boolean delete(Long id);

}
