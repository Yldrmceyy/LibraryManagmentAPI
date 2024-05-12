package dev.cey.v1.dto.request.author;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorUpdateRequest {
    @Positive(message = "id değeri pozitif olmak zorunda")
    private long id;

    @NotNull(message = "Kategori ismi boş veya null olamaz ")
    private String name;
}
