package com.kodilla.library.mapper;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.Dto.BookDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public BookMapper() {
        modelMapper.addMappings(bookMap);
    }

    PropertyMap<Book, BookDto> bookMap = new PropertyMap<Book, BookDto>() {
        @Override
        protected void configure() {
            map().setId(source.getId());
            map().setStatus(source.getStatus());
            map().setTitleName(source.getTitle().getTitle());
            map().setTitle_id(source.getTitle().getId());
        }
    };

    public Book mapToBook(BookDto bookDto) {
        return new Book(
                bookDto.getId(),
                bookDto.getStatus()
        );
    }

    public BookDto mapToBookDto(Book book) {
        return new BookDto(
                book.getId(),
                book.getStatus()
        );
    }

    public BookDto mapToBookDtoWithTitleName(Book book) {
        return modelMapper.map(book, BookDto.class);
    }

    public List<BookDto> mapToListBookDto(List<Book> bookList) {
        return bookList.stream()
                .map(book -> modelMapper.map(book, BookDto.class))
                .collect(Collectors.toList());
    }

    public BookDto mapToBookDtoWithTask(Book book) {
        return modelMapper.map(book, BookDto.class);
    }
}
