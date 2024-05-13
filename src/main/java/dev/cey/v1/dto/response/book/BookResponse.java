package dev.cey.v1.dto.response.book;

import dev.cey.v1.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {

    private Long id;
    private String name;


}
