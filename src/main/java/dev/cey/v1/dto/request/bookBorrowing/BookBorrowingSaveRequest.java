package dev.cey.v1.dto.request.bookBorrowing;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowingSaveRequest {


    private String name;
    private LocalDate date;
    @Email
    private String mail;
    private LocalDate reDate;
    private Long bookId;


}
