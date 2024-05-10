package dev.cey.v1.api;

import dev.cey.v1.business.abstracts.IAuthorService;
import dev.cey.v1.entities.Author;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/authors")
public class AuthorController {
    private final IAuthorService authorService;

    public AuthorController(IAuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Author save(@Valid @RequestBody Author author) {
       return this.authorService.save(author);
    }
}
