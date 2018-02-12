package com.kodilla.library.service;

import com.kodilla.library.domain.*;
import com.kodilla.library.domain.Dto.BookWithTitleDto;
import com.kodilla.library.mapper.BookWithTitleMapper;
import com.kodilla.library.repository.BookRepository;
import com.kodilla.library.repository.ReaderRepository;
import com.kodilla.library.repository.RentRespository;
import com.kodilla.library.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbService {

    @Autowired
    private ReaderRepository readerRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private TitleRepository titleRepository;
    @Autowired
    private RentRespository rentRespository;

    public Title getTitle(Long id) {
        return titleRepository.findById(id);
    }

    public Title createTitle(Title title) { return titleRepository.save(title);}

    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

    public Reader getReader(Long id) {
        return readerRepository.findById(id);
    }

    public Reader createReader (Reader reader) { return readerRepository.save(reader); }

    public Book getBook(Long id) {
        return bookRepository.findById(id);
    }

    public Book createBook(Book book, Long titleId) {
        Title title = getTitle(titleId);
        title.getBooks().add(book);
        book.setTitle(title);
        return bookRepository.save(book);
    }

    public Book updateBook(Long titleId, Long bookId, String status) {
        Book book = bookRepository.findById(bookId);
        Title title = titleRepository.findById(titleId);
        book.setStatus(status);
        book.setTitle(title);
        title.getBooks().add(book);
        return bookRepository.save(book);

    }

    public Title createBookWithTitle(Book book, Title title) {

        title.getBooks().add(book);
        book.setTitle(title);
        return titleRepository.save(title);}

    public List<Rent> getRents() {
        return rentRespository.findAll();
    }


}
