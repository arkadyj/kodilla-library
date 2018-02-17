package com.kodilla.library.controller;


import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.Dto.*;
import com.kodilla.library.domain.Reader;
import com.kodilla.library.domain.Rent;
import com.kodilla.library.domain.Title;
import com.kodilla.library.mapper.*;
import com.kodilla.library.repository.TitleRepository;
import com.kodilla.library.service.DbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(LibraryController.class);

    @RequestMapping(method = RequestMethod.GET, value = "getReaders")
    public List<ReaderDto> getReaders() {
        return readerMapper.mapToListReaderDto(dbService.getAllReaders());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getRents")
    public List<RentDto> getRents() {
        return rentMapper.mapToListRentDto(dbService.getRents());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getRentsByReader")
    public List<RentDto> getRentsByReader(@RequestParam Long readerId) {
        return rentMapper.mapToListRentDto(dbService.getRentsByReader(readerId));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getRentsByBook")
    public ResponseEntity<List<RentDto>> getRentsByBook(@RequestParam Long bookId) {
        List<RentDto> rentDtoList;
        //return rentMapper.mapToListRentDto(dbService.getRentsByBook(bookId));

        try {
            rentDtoList = rentMapper.mapToListRentDto(dbService.getRentsByBook(bookId));
        } catch (Exception e) {
            LOGGER.error("ERROR in retrieving rent list for bookId: " + bookId);
            return new ResponseEntity<List<RentDto>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<RentDto>>(rentDtoList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getRentsNotReturn")
    public ResponseEntity<List<RentDto>> getRentsNotReturn() {
        List<RentDto> rentDtoList;
        try {
            rentDtoList = rentMapper.mapToListRentDto(dbService.getRentsNotReturn());
        } catch (Exception e) {
            LOGGER.error("ERROR in retrieving rent list where return date is null");
            return new ResponseEntity<List<RentDto>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<RentDto>>(rentDtoList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "rentBook")
    public ResponseEntity<RentDto> rentBook(@RequestParam Long bookId, @RequestParam Long readerId) {
       RentDto rentDto;
       try {
           rentDto = rentMapper.mapToRentDto(dbService.rentBook(bookId, readerId));
       } catch (Exception e) {
           LOGGER.error("ERROR during rent process - bookId: " + bookId + " readerId: " + readerId);
           return new ResponseEntity<RentDto>(HttpStatus.NOT_FOUND);
       }
        return new ResponseEntity<RentDto>(rentDto,HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.PUT, value = "returnBook")
    public ResponseEntity<RentDto> returnBook(@RequestParam Long rentId) {
        RentDto rentDto;
        try {
            rentDto = rentMapper.mapToRentDto(dbService.returnBook(rentId));
        } catch (Exception e) {
            LOGGER.error("ERROR during returning book - rentId: " + rentId);
            return new ResponseEntity<RentDto>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<RentDto>(rentDto,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createReader", consumes = APPLICATION_JSON_VALUE)
    public ReaderDto createReader(@RequestBody ReaderDto readerDto) {
        return readerMapper.mapToReaderDto(dbService.createReader(readerMapper.mapToRader(readerDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTitle", consumes = APPLICATION_JSON_VALUE)
    public TitleDto createTitle(@RequestBody TitleDto titleDto) {
        return titleMapper.mapToTitleDto(dbService.createTitle(titleMapper.mapToTitle(titleDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBook", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDto> createBook(@RequestParam Long titleId) {
        BookDto bookDto1;
        try {
            bookDto1 = bookMapper.mapToBookDtoWithTitleName(dbService.createBook(titleId));
        } catch (Exception e) {
            LOGGER.error("ERROR during creating new book. Titleid: " + titleId);
            return new ResponseEntity<BookDto>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BookDto>(bookDto1,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCountBooksByStatus")
    public long getCountBooksByStatus(@RequestParam Long titleId, @RequestParam String status) {
        return dbService.getCountBooksWithStatusByTitle(titleId, status);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBooksByStatus")
    public List<BookDto> getBooksByStatus(@RequestParam Long titleId, @RequestParam String status) {
        return bookMapper.mapToListBookDto(dbService.getBooksByStatus(titleId, status));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateBook")
    public ResponseEntity<BookDto> updateBook(@RequestParam Long bookId, @RequestParam String status) {
        BookDto bookDto;
        try {
            bookDto = bookMapper.mapToBookDtoWithTask(dbService.updateBook(bookId, status));
        } catch (Exception e) {
            LOGGER.error("ERROR during updating book status. bookId: " + bookId + " status: " + status);
            return new ResponseEntity<BookDto>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BookDto>(bookDto, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBookWithTitle", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<TitleDto> createBookWithTitle(@RequestBody TitleDto titleDto) {
        TitleDto titleDto1;
        try {
            titleDto1 = titleMapper.mapToTitleDto(
                    dbService.createBookWithTitle(titleMapper.mapToTitle(titleDto)));
        } catch (Exception e) {
            LOGGER.error("ERROR during creating book and title. Data: " + titleDto);
            return new ResponseEntity<TitleDto>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<TitleDto>(titleDto1,HttpStatus.OK);
    }


/*
    @RequestMapping(method = RequestMethod.POST, value = "createBookWithTitle", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<TitleDto> createBookWithTitle(@RequestBody BookWithTitleDto bookWithTitleDto) {
        TitleDto titleDto;
        try {
            titleDto = titleMapper.mapToTitleDto(
                    dbService.createBookWithTitle(bookWithTitleMapper.mapToBookFromDto(bookWithTitleDto), bookWithTitleMapper.mapToTitleFromDto(bookWithTitleDto)));
        } catch (Exception e) {
            LOGGER.error("ERROR during creating book and title. Data: " + bookWithTitleDto);
            return new ResponseEntity<TitleDto>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<TitleDto>(titleDto,HttpStatus.OK);
    } */
}
