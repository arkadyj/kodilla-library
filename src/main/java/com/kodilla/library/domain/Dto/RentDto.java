package com.kodilla.library.domain.Dto;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.Reader;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RentDto {

    private Long id;
    private Long bookId;
    private String rentDate;
    private String returnDate;
    private String bookTitle;
    private String readerFirstName;
    private String readerSecondName;
}
