package com.kodilla.library.service;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.Reader;
import com.kodilla.library.domain.Rent;
import com.kodilla.library.domain.Title;
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

    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

    public Reader getReader(Long id) {
        return readerRepository.findById(id);
    }

    public Book getBook(Long id) {
        return bookRepository.findById(id);
    }

    public List<Rent> getRents() {
        return rentRespository.findAll();
    }


}
