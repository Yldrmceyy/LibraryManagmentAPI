package dev.cey.v1.business.concretes;

import dev.cey.v1.business.abstracts.ICategoryService;
import dev.cey.v1.core.exception.NotFoundException;
import dev.cey.v1.core.utilies.Msg;
import dev.cey.v1.dao.BookRepository;
import dev.cey.v1.dao.CategoryRepository;
import dev.cey.v1.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryManager implements ICategoryService {

    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;

    public CategoryManager(CategoryRepository categoryRepo, BookRepository bookRepo) {
        this.categoryRepository = categoryRepo;
        this.bookRepository = bookRepo;
    }

    @Override
    public Category save(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category get(Long id) {
        return this.categoryRepository.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Page<Category> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.categoryRepository.findAll(pageable);
    }

    @Override
    public Category update(Category category) {
        this.get(category.getId());
        return this.categoryRepository.save(category);
    }


    @Override
    public String delete(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            if (category.getBookList().isEmpty()) {
                categoryRepository.delete(category);
                return "Category deleted successfully";
            } else {
                return "Category has books";
            }
        }
        return "Category not found";
    }
}
