package dev.cey.v1.api;

import dev.cey.v1.business.abstracts.IAuthorService;
import dev.cey.v1.core.config.modelMapper.IModelMapperService;
import dev.cey.v1.core.result.ResultData;
import dev.cey.v1.core.utilies.ResultHelper;
import dev.cey.v1.dto.request.author.AuthorSaveRequest;
import dev.cey.v1.dto.response.author.AuthorResponse;
import dev.cey.v1.entities.Author;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/authors")
public class AuthorController {
    private final IAuthorService authorService;
    private final IModelMapperService modelMapper;

    public AuthorController(IAuthorService authorService, IModelMapperService modelMapper) {
        this.authorService = authorService;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AuthorResponse> save(@Valid @RequestBody AuthorSaveRequest authorSaveRequest) {

        Author saveAuthor =this.modelMapper.forRequest().map(authorSaveRequest, Author.class);
        this.authorService.save(saveAuthor);
        return ResultHelper.created(this.modelMapper.forResponse().map(saveAuthor, AuthorResponse.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AuthorResponse> get(@PathVariable Long id) {
            Author author =this.authorService.get(id);
            return ResultHelper.success(this.modelMapper.forResponse().map(author, AuthorResponse.class));
    }
}
