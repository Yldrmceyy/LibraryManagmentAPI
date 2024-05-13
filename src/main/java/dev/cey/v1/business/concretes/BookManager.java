package dev.cey.v1.business.concretes;

import dev.cey.v1.business.abstracts.IBookService;
import dev.cey.v1.core.excepiton.NotFoundException;
import dev.cey.v1.core.utilies.Msg;
import dev.cey.v1.dao.BookRepository;
import dev.cey.v1.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookManager implements IBookService {

    private  final BookRepository bookRepository;

    public BookManager(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(Book Book) {
        return this.bookRepository.save(Book);
    }

    @Override
    public Book get(Long id) {
        return this.bookRepository.findById(id).orElseThrow(()-> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Page<Book> cursor(int page, int pageSize) {
        Pageable pageable= PageRequest.of(page, pageSize);
        return this.bookRepository.findAll(pageable);
    }

    @Override
    public Book update(Book book) {
        this.get(book.getId());
        return this.bookRepository.save(book);
    }


    @Override
    public boolean delete(Long id) {
        Book book = this.get(id);
        this.bookRepository.delete(book);
        return true;
    }
}
