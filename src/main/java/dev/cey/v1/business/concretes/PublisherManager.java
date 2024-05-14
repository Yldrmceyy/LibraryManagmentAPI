package dev.cey.v1.business.concretes;

import dev.cey.v1.business.abstracts.IPublisherService;
import dev.cey.v1.core.exception.NotFoundException;
import dev.cey.v1.core.utilies.Msg;
import dev.cey.v1.dao.PublisherRepository;
import dev.cey.v1.entities.Publisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PublisherManager implements IPublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherManager(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher save(Publisher publisher) {
        return this.publisherRepository.save(publisher);
    }

    @Override
    public Publisher get(Long id) {
        return this.publisherRepository.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Page<Publisher> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.publisherRepository.findAll(pageable);
    }

    @Override
    public Publisher update(Publisher publisher) {
        this.get(publisher.getId());
        return this.publisherRepository.save(publisher);
    }

    @Override
    public boolean delete(Long id) {
        Optional<Publisher> optionalPublisher = publisherRepository.findById(id);
        if (optionalPublisher.isPresent()) {
            Publisher publisher = optionalPublisher.get();
            if (publisher.getBookList().isEmpty()) {
                publisherRepository.delete(publisher);
                return true;
            } else {
                return false; // Yayınevinin kitapları var, silinemez
            }
        }
        return false; // Yayınevi bulunamadı
    }
}
