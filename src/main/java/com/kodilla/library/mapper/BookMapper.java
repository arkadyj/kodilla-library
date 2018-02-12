package com.kodilla.library.mapper;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.Dto.BookDto;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book mapToBook(BookDto bookDto) {
        return new Book(
                bookDto.getId(),
                bookDto.getStatus()
                //bookDto.getTitle()
        );
    }

    public BookDto mapToBookDto(Book book) {
        return new BookDto(
                book.getId(),
                book.getStatus()
                //book.getTitle()
        );
    }
}
