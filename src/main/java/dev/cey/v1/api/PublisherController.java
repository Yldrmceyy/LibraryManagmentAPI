package dev.cey.v1.api;

import dev.cey.v1.business.abstracts.IPublisherService;
import dev.cey.v1.core.config.modelMapper.IModelMapperService;
import dev.cey.v1.core.result.Result;
import dev.cey.v1.core.result.ResultData;
import dev.cey.v1.core.utilies.ResultHelper;
import dev.cey.v1.dto.request.publisher.PublisherSaveRequest;
import dev.cey.v1.dto.request.publisher.PublisherUpdateRequest;
import dev.cey.v1.dto.response.CursorResponse;
import dev.cey.v1.dto.response.publisher.PublisherResponse;
import dev.cey.v1.entities.Publisher;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/publishers")
public class PublisherController {

    private final IPublisherService publisherService;
    private final IModelMapperService modelMapper;

    public PublisherController(IPublisherService publisherService, IModelMapperService modelMapper) {
        this.publisherService = publisherService;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<PublisherResponse> save(@Valid @RequestBody PublisherSaveRequest publisherSaveRequest) {
        Publisher savePublisher = this.modelMapper.forRequest().map(publisherSaveRequest, Publisher.class);
        this.publisherService.save(savePublisher);
        return ResultHelper.created(this.modelMapper.forResponse().map(savePublisher, PublisherResponse.class));
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<PublisherResponse> update(@Valid @RequestBody PublisherUpdateRequest publisherUpdateRequest) {
        Publisher updatePublisher = this.modelMapper.forRequest().map(publisherUpdateRequest, Publisher.class);
        this.publisherService.update(updatePublisher);
        return ResultHelper.success(this.modelMapper.forResponse().map(updatePublisher, PublisherResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") Long id) {
        boolean isDeleted = this.publisherService.delete(id);
        if (isDeleted) {
            return ResultHelper.ok();
        } else {
            return ResultHelper.notFoundError("Publisher has books or not found");
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<PublisherResponse> get(@PathVariable("id") Long id) {
        Publisher publisher = this.publisherService.get(id);
        return ResultHelper.success(this.modelMapper.forResponse().map(publisher, PublisherResponse.class));
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<PublisherResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        Page<Publisher> publisherPage = this.publisherService.cursor(page, pageSize);
        Page<PublisherResponse> publisherResponsePage = publisherPage
                .map(publisher -> this.modelMapper.forResponse().map(publisher, PublisherResponse.class));
        return ResultHelper.cursor(publisherResponsePage);
    }
}
