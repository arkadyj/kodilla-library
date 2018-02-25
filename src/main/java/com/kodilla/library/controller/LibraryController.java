package com.kodilla.library.controller;

import com.kodilla.library.domain.Dto.*;
import com.kodilla.library.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/library")
public class LibraryController {

    private final LibraryService libraryService;

    @RequestMapping(method = RequestMethod.GET, value = "getReaders")
    public List<ReaderDto> getReaders() {
        return libraryService.getReaders();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getRents")
    public List<RentDto> getRents() {
        return libraryService.getRents();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getRentsByReader")
    public List<RentDto> getRentsByReader(@RequestParam Long readerId) {
        return libraryService.getRentsByReader(readerId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getRentsByBook")
    public ResponseEntity<List<RentDto>> getRentsByBook(@RequestParam Long bookId) {
        return libraryService.getRentsByBook(bookId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getRentsNotReturn")
    public ResponseEntity<List<RentDto>> getRentsNotReturn() {
        return libraryService.getRentsNotReturn();
    }

    @RequestMapping(method = RequestMethod.POST, value = "rentBook")
    public ResponseEntity<RentDto> rentBook(@RequestParam Long bookId, @RequestParam Long readerId) {
        return libraryService.rentBook(bookId, readerId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "returnBook")
    public ResponseEntity<RentDto> returnBook(@RequestParam Long rentId) {
        return libraryService.returnBook(rentId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createReader", consumes = APPLICATION_JSON_VALUE)
    public ReaderDto createReader(@RequestBody ReaderDto readerDto) {
        return libraryService.createReader(readerDto);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTitle", consumes = APPLICATION_JSON_VALUE)
    public TitleDto createTitle(@RequestBody TitleDto titleDto) {
        return libraryService.createTitle(titleDto);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBook", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDto> createBook(@RequestParam Long titleId) {
        return libraryService.createBook(titleId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCountBooksByStatus")
    public long getCountBooksByStatus(@RequestParam Long titleId, @RequestParam String status) {
        return libraryService.getCountBooksByStatus(titleId, status);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBooksByStatus")
    public List<BookDto> getBooksByStatus(@RequestParam Long titleId, @RequestParam String status) {
        return libraryService.getBooksByStatus(titleId, status);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTitlesByStatus")
    public List<TitleDto> getTitlesByStatus(@RequestParam String status) {
        return libraryService.getTitlesByStatus(status);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateBook")
    public ResponseEntity<BookDto> updateBook(@RequestParam Long bookId, @RequestParam String status) {
        return libraryService.updateBook(bookId, status);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBookWithTitle", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<TitleDto> createBookWithTitle(@RequestBody TitleDto titleDto) {
        return libraryService.createBookWithTitle(titleDto);
    }
}
