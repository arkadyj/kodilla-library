package com.kodilla.library.domain.Dto;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.Reader;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RentDto {

    private Long id;
    private String rentDate;
    private String returnDate;
    private String bookTitle;
    private String readerFirstName;
    private String readerSecondName;

    @Override
    public String toString() {
        return "RentDto{" +
                "id11=" + id +
                ", rentDate=" + rentDate +
                ", returnDate=" + returnDate +
                ", bookTitle='" + bookTitle + '\'' +
                ", readerFirstName='" + readerFirstName + '\'' +
                ", readerSecondName='" + readerSecondName + '\'' +
                '}' + "\n";
    }
}
