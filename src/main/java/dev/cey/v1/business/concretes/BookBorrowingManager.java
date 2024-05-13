package dev.cey.v1.business.concretes;

import dev.cey.v1.business.abstracts.IBookBorrowingService;
import dev.cey.v1.core.excepiton.NotFoundException;
import dev.cey.v1.core.utilies.Msg;
import dev.cey.v1.dao.BookBorrowingRepository;
import dev.cey.v1.entities.Book;
import dev.cey.v1.entities.BookBorrowing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookBorrowingManager implements IBookBorrowingService {

    private final BookBorrowingRepository bookBorrowingRepository;

    public BookBorrowingManager(BookBorrowingRepository bookBorrowingRepository) {
        this.bookBorrowingRepository = bookBorrowingRepository;
    }


    @Override
    public BookBorrowing save(BookBorrowing bookBorrowing) {
        return this.bookBorrowingRepository.save(bookBorrowing);
    }

    @Override
    public BookBorrowing get(Long id) {
        return this.bookBorrowingRepository.findById(id).orElseThrow(()-> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Page<BookBorrowing> cursor(int page, int pageSize) {
        Pageable pageable= PageRequest.of(page, pageSize);
        return this.bookBorrowingRepository.findAll(pageable);
    }

    @Override
    public BookBorrowing update(BookBorrowing bookBorrowing) {
        this.get(bookBorrowing.getId());
        return this.bookBorrowingRepository.save(bookBorrowing);
    }

    @Override
    public boolean delete(Long id) {
        BookBorrowing bookBorrowing = this.get(id);
        this.bookBorrowingRepository.delete(bookBorrowing);
        return true;
    }
}
