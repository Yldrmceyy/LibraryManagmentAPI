package dev.cey.v1.business.concretes;

import dev.cey.v1.business.abstracts.IAuthorService;
import dev.cey.v1.core.excepiton.NotFoundException;
import dev.cey.v1.core.utilies.Msg;
import dev.cey.v1.dao.AuthorRepository;
import dev.cey.v1.entities.Author;
import org.springframework.stereotype.Service;

@Service
public class AuthorManager implements IAuthorService {
    private  final AuthorRepository authorRepository;

    public AuthorManager(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author save(Author author) {
        return this.authorRepository.save(author);
    }

    @Override
    public Author get(Long id) {
        return this.authorRepository.findById(id).orElseThrow(() ->  new NotFoundException(Msg.NOT_FOUND));
    }
}
