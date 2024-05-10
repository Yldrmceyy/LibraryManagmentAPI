package dev.cey.v1.business.abstracts;

import dev.cey.v1.entities.Author;

public interface IAuthorService {
    Author save(Author author);
    Author get(Long id);
}
