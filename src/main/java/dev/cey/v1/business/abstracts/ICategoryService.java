package dev.cey.v1.business.abstracts;

import dev.cey.v1.entities.Book;
import dev.cey.v1.entities.Category;
import org.springframework.data.domain.Page;

public interface ICategoryService {
    Category save(Category category);

    Category get(Long id);

    Page<Category> cursor(int page, int pageSize);

    Category update(Category category);

    String delete(Long id);

}
