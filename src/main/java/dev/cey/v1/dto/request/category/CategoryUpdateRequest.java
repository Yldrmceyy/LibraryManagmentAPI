package dev.cey.v1.dto.request.category;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryUpdateRequest {

    @Positive(message = "Category ID number must be positive!")
    private Long id;
    @NotNull(message = "Category Name can't be null!")
    private String name;
    private String description;
}