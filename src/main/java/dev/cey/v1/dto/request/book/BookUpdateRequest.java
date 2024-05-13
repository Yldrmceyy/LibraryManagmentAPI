package dev.cey.v1.dto.request.book;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookUpdateRequest {
    @Positive
    private long id;
    @NotNull
    private String name;
    private int year;
    private int stock;
}

