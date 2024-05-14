package dev.cey.v1.business.abstracts;

import dev.cey.v1.entities.Publisher;
import org.springframework.data.domain.Page;

public interface IPublisherService {


    Publisher save(Publisher publisher);

    Publisher update(Publisher publisher);

    boolean delete(Long id);

    Publisher get(Long id);

    Page<Publisher> cursor(int page, int pageSize);


}
