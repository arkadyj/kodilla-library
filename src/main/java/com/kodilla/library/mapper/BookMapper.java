package com.kodilla.library.mapper;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.Dto.BookDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public BookDto mapToBookDtoWithTitle(Book book) {
        return new BookDto(
                book.getId(),
                book.getStatus(),
                book.getTitle().getId()
                //book.getTitle()
        );
    }

    public List<BookDto> mapToListBookDto(List<Book> bookList) {
        return bookList.stream()
                .map(book -> new BookDto(book.getId(),book.getStatus(),book.getTitle()))
                .collect(Collectors.toList());

    }

    public BookDto mapToBookDtoWithTask(Book book) {
        return new BookDto(
                book.getId(),
                book.getStatus(),
                book.getTitle().getId()
                //book.getTitle()
        );
    }
}
