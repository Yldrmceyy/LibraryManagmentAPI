package dev.cey.v1.dto.request.book;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookSaveRequest {

    @NotNull
    private String name;

    private int year;
    private int stock;


}
