package dev.cey.v1.api;

import dev.cey.v1.business.abstracts.IBookService;
import dev.cey.v1.core.config.modelMapper.IModelMapperService;
import dev.cey.v1.core.result.Result;
import dev.cey.v1.core.result.ResultData;
import dev.cey.v1.core.utilies.ResultHelper;
import dev.cey.v1.dto.request.book.BookSaveRequest;
import dev.cey.v1.dto.request.book.BookUpdateRequest;
import dev.cey.v1.dto.response.CursorResponse;
import dev.cey.v1.dto.response.author.AuthorResponse;
import dev.cey.v1.dto.response.book.BookResponse;
import dev.cey.v1.entities.Author;
import dev.cey.v1.entities.Book;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/books")
public class BookController {
    private final IBookService bookService;
    private final IModelMapperService modelMapper;

    public BookController(IBookService bookService, IModelMapperService modelMapper) {
        this.bookService = bookService;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<BookResponse> save(@Valid @RequestBody BookSaveRequest bookSaveRequest) {

        Book saveBook = this.modelMapper.forRequest().map(bookSaveRequest, Book.class);
        this.bookService.save(saveBook);
        return ResultHelper.created(this.modelMapper.forResponse().map(saveBook, BookResponse.class));
    }


    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookResponse> update(@Valid @RequestBody BookUpdateRequest bookUpdateRequest) {

        Book updateBook = this.modelMapper.forRequest().map(bookUpdateRequest, Book.class);
        this.bookService.update(updateBook);
        return ResultHelper.success(this.modelMapper.forResponse().map(updateBook, BookResponse.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookResponse> get(@PathVariable Long id) {
        Book book =this.bookService.get(id);
        return ResultHelper.success(this.modelMapper.forResponse().map(book, BookResponse.class));
    }


    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<BookResponse>> cursor(

            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        Page<Book> bookPage = this.bookService.cursor(page, pageSize);
        Page<BookResponse> bookResponsePage = bookPage.map(book -> this.modelMapper.forResponse().map(book, BookResponse.class));
        return ResultHelper.cursor(bookResponsePage);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") long id){
        this.bookService.delete(id);
        return ResultHelper.ok();
    }
}
