package dev.cey.v1.business.concretes;

import dev.cey.v1.business.abstracts.IAuthorService;
import dev.cey.v1.core.excepiton.NotFoundException;
import dev.cey.v1.core.utilies.Msg;
import dev.cey.v1.dao.AuthorRepository;
import dev.cey.v1.entities.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<Author> cursor(int page, int pageSize) {
        Pageable pageable= PageRequest.of(page, pageSize);
        return this.authorRepository.findAll(pageable);
    }

    @Override
    public Author update(Author author) {
        this.get(author.getId());
        return this.authorRepository.save(author);
    }

    @Override
    public boolean delete(Long id) {
        Author author=this.get(id);
        this.authorRepository.delete(author);
        return true;
    }


}
