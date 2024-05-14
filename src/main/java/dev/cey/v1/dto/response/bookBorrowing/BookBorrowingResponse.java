package dev.cey.v1.dto.response.bookBorrowing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowingResponse {
    private Long id;
    private String name;
    private String mail;
    private LocalDate date;
    private LocalDate reDate;
}
