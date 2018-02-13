package com.kodilla.library.controller;


import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.Dto.*;
import com.kodilla.library.domain.Reader;
import com.kodilla.library.domain.Rent;
import com.kodilla.library.domain.Title;
import com.kodilla.library.mapper.*;
import com.kodilla.library.repository.TitleRepository;
import com.kodilla.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private DbService dbService;
    @Autowired
    private ReaderMapper readerMapper;
    @Autowired
    private RentMapper rentMapper;
    @Autowired
    private TitleMapper titleMapper;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookWithTitleMapper bookWithTitleMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getReaders")
    public List<ReaderDto> getReaders() {
        return readerMapper.mapToListReaderDto(dbService.getAllReaders());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getReaderRents")
    public List<RentDto> getReaderRents() {
        return rentMapper.mapToListRentDto(dbService.getRents());
    }

    @RequestMapping(method = RequestMethod.POST, value = "rentBook")
    public RentDto rentBook(@RequestParam Long bookId, @RequestParam Long readerId) {
        return rentMapper.mapToRentDto(dbService.rentBook(bookId, readerId));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "returnBook")
    public RentDto rentBook(@RequestParam Long rentId) {
        return rentMapper.mapToRentDto(dbService.returnBook(rentId));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createReader", consumes = APPLICATION_JSON_VALUE)
    public ReaderDto createReader(@RequestBody ReaderDto readerDto) {
        return readerMapper.mapToReaderDto(dbService.createReader(readerMapper.mapToRader(readerDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTitle", consumes = APPLICATION_JSON_VALUE)
    public TitleDto createReader(@RequestBody TitleDto titleDto) {
        return titleMapper.mapToTitleDto(dbService.createTitle(titleMapper.mapToTitle(titleDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBook", consumes = APPLICATION_JSON_VALUE)
    public BookDto createBook(@RequestBody BookDto bookDto, @RequestParam Long titleId) {
        return bookMapper.mapToBookDtoWithTitle(dbService.createBook(bookMapper.mapToBook(bookDto), titleId));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBooksByStatus")
    public long getBooksByStatus(@RequestParam Long titleId, @RequestParam String status) {
        return dbService.getBooksWithStatus(titleId, status);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateBook")
    public BookDto updateBook(@RequestParam Long bookId, @RequestParam String status) {
        return bookMapper.mapToBookDtoWithTask(dbService.updateBook(bookId, status));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBookWithTitle", consumes = APPLICATION_JSON_VALUE)
    public TitleDto createBookWithTitle(@RequestBody BookWithTitleDto bookWithTitleDto) {
        return titleMapper.mapToTitleDto(dbService.createBookWithTitle(bookWithTitleMapper.mapToBookFromDto(bookWithTitleDto), bookWithTitleMapper.mapToTitleFromDto(bookWithTitleDto)));
    }
}
