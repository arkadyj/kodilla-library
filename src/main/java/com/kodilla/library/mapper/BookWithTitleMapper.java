package com.kodilla.library.mapper;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.BookWithTitle;
import com.kodilla.library.domain.Dto.BookWithTitleDto;
import com.kodilla.library.domain.Title;
import org.springframework.stereotype.Component;

@Component
public class BookWithTitleMapper {


    public Book mapToBookFromDto(BookWithTitleDto bookWithTitleDto) {
        return new Book(
                bookWithTitleDto.getIdBook(),
                bookWithTitleDto.getStatus()
        );
    }

    public Title mapToTitleFromDto(BookWithTitleDto bookWithTitleDto) {
        return new Title(
                bookWithTitleDto.getIdTitle(),
                bookWithTitleDto.getTitle(),
                bookWithTitleDto.getAuthor(),
                bookWithTitleDto.getPublishYear()
        );
    }

    public Title mapToTitle(BookWithTitle bookWithTitle) {
        return new Title(
                bookWithTitle.getIdTitle(),
                bookWithTitle.getTitle(),
                bookWithTitle.getAuthor(),
                bookWithTitle.getPublishYear()
        );
    }

    public Book mapToBook(BookWithTitle bookWithTitle) {
        return new Book(
                bookWithTitle.getIdBook(),
                bookWithTitle.getStatus()
        );
    }
}
