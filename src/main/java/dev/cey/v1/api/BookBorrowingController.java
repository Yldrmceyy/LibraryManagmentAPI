package dev.cey.v1.api;

import dev.cey.v1.business.abstracts.IAuthorService;
import dev.cey.v1.business.abstracts.IBookBorrowingService;
import dev.cey.v1.business.abstracts.IBookService;
import dev.cey.v1.core.config.modelMapper.IModelMapperService;
import dev.cey.v1.core.result.ResultData;
import dev.cey.v1.core.utilies.ResultHelper;
import dev.cey.v1.dao.BookBorrowingRepository;
import dev.cey.v1.dto.request.author.AuthorSaveRequest;
import dev.cey.v1.dto.request.bookBorrowing.BookBorrowingSaveRequest;
import dev.cey.v1.dto.response.author.AuthorResponse;
import dev.cey.v1.dto.response.bookBorrowing.BookBorrowingResponse;
import dev.cey.v1.entities.Author;
import dev.cey.v1.entities.Book;
import dev.cey.v1.entities.BookBorrowing;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/book-borrowings")
public class BookBorrowingController {
    private final IBookBorrowingService bookBorrowingService;
    private final IModelMapperService modelMapper;
    private final IBookService bookService;

    public BookBorrowingController(IBookBorrowingService bookBorrowingService,
                                   IModelMapperService modelMapperService,
                                   IModelMapperService modelMapper,
                                   IBookService bookService
    ) {
        this.bookBorrowingService = bookBorrowingService;
        this.modelMapper = modelMapper;
        this.bookService = bookService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<BookBorrowingResponse> save(@Valid @RequestBody BookBorrowingSaveRequest bookBorrowingSaveRequest) {

        BookBorrowing saveBookBorrowing = this.modelMapper.forRequest().map(bookBorrowingSaveRequest, BookBorrowing.class);

        Book book = this.bookService.get(bookBorrowingSaveRequest.getId());
        saveBookBorrowing.setBook(book);
        this.bookBorrowingService.save(saveBookBorrowing);
        return ResultHelper.created(this.modelMapper.forResponse().map(saveBookBorrowing, BookBorrowingResponse.class));
    }

}
