package com.kodilla.library.domain.Dto;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.Reader;
import lombok.AllArgsConstructor;
import lombok.Getter;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@AllArgsConstructor
public class RentDto {

    private Long id;
    private LocalDate rentDate;
    private LocalDate returnDate;
    private String bookTitle;
    private String readerFirstName;
    private String readerSecondName;


    public RentDto(Long id, LocalDate rentDate, LocalDate returnDate, String bookTitle, String readerFirstName, String readerSecondName) {
        this.id = id;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.bookTitle = bookTitle;
        this.readerFirstName = readerFirstName;
        this.readerSecondName = readerSecondName;
    }

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public String toString() {
        return "RentDto{" +
                "id11=" + id +
                ", rentDate=" + rentDate +
                ", returnDate=" + returnDate.format(formatter) +
                ", bookTitle='" + bookTitle + '\'' +
                ", readerFirstName='" + readerFirstName + '\'' +
                ", readerSecondName='" + readerSecondName + '\'' +
                '}' + "\n";
    }
}
