package com.kodilla.library.service;


import com.kodilla.library.domain.Dto.BookDto;
import com.kodilla.library.domain.Dto.ReaderDto;
import com.kodilla.library.domain.Dto.RentDto;
import com.kodilla.library.domain.Dto.TitleDto;
import com.kodilla.library.domain.Mail;
import com.kodilla.library.domain.Reader;
import com.kodilla.library.mapper.BookMapper;
import com.kodilla.library.mapper.ReaderMapper;
import com.kodilla.library.mapper.RentMapper;
import com.kodilla.library.mapper.TitleMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LibraryService {

    private final MailService mailService;
    private final DbService dbService;
    private final RentMapper rentMapper;
    private final ReaderMapper readerMapper;
    private final TitleMapper titleMapper;
    private final BookMapper bookMapper;

    public List<ReaderDto> getReaders() {
        return readerMapper.mapToListReaderDto(dbService.getAllReaders());
    }

    public List<RentDto> getRents() {
        return rentMapper.mapToListRentDto(dbService.getRents());
    }

    public List<RentDto> getRentsByReader(Long readerId) {
        return rentMapper.mapToListRentDto(dbService.getRentsByReader(readerId));
    }

    public ResponseEntity<List<RentDto>> getRentsByBook(Long bookId) {
        List<RentDto> rentDtoList;
        try {
            rentDtoList = rentMapper.mapToListRentDto(dbService.getRentsByBook(bookId));

        } catch (Exception e) {
            log.error("ERROR in retrieving rent list for bookId: " + bookId);
            return new ResponseEntity<List<RentDto>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<RentDto>>(rentDtoList, HttpStatus.OK);
    }

    public ResponseEntity<List<RentDto>> getRentsNotReturn() {
        List<RentDto> rentDtoList;
        try {
            rentDtoList = rentMapper.mapToListRentDto(dbService.getRentsNotReturn());
        } catch (Exception e) {
            log.error("ERROR in retrieving rent list where return date is null");
            return new ResponseEntity<List<RentDto>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<RentDto>>(rentDtoList, HttpStatus.OK);
    }

    public long getCountBooksByStatus(Long titleId, String status) {
        return dbService.getCountBooksWithStatusByTitle(titleId, status);
    }

    public List<BookDto> getBooksByStatus(Long titleId, String status) {
        return bookMapper.mapToListBookDto(dbService.getBooksByStatus(titleId, status));
    }

    public List<TitleDto> getTitlesByStatus(String status) {
        return titleMapper.mapToListTitleDto(dbService.getTitlesByStatus(status));
    }

    public ReaderDto createReader(ReaderDto readerDto) {
        return readerMapper.mapToReaderDto(dbService.createReader(readerMapper.mapToReader(readerDto)));
    }

    public TitleDto createTitle(TitleDto titleDto) {
        return titleMapper.mapToTitleDto(dbService.createTitle(titleMapper.mapToTitle(titleDto)));
    }

    public ResponseEntity<BookDto> createBook(Long titleId) {
        BookDto bookDto1;
        try {
            bookDto1 = bookMapper.mapToBookDtoWithTitleName(dbService.createBook(titleId));
        } catch (Exception e) {
            log.error("ERROR during creating new book. Titleid: " + titleId);
            return new ResponseEntity<BookDto>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BookDto>(bookDto1, HttpStatus.OK);
    }

    public ResponseEntity<TitleDto> createBookWithTitle(TitleDto titleDto) {
        TitleDto titleDto1;
        try {
            titleDto1 = titleMapper.mapToTitleDto(
                    dbService.createBookWithTitle(titleMapper.mapToTitle(titleDto)));
        } catch (Exception e) {
            log.error("ERROR during creating book and title. Data: " + titleDto);
            return new ResponseEntity<TitleDto>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<TitleDto>(titleDto1, HttpStatus.OK);
    }

    public ResponseEntity<RentDto> rentBook(Long bookId, Long readerId) {
        RentDto rentDto;
        try {
            rentDto = rentMapper.mapToRentDto(dbService.rentBook(bookId, readerId));
        } catch (Exception e) {
            log.error("ERROR during rent process - bookId: " + bookId + " readerId: " + readerId);
            return new ResponseEntity<RentDto>(HttpStatus.NOT_FOUND);
        }
        Reader reader = dbService.getReader(readerId);
        String title = dbService.getBook(bookId).getTitle().getTitle();

        mailService.send(new Mail(
                reader.getEmail(),
                "Renting a book from library",
                "You has rent a book " + title));

        return new ResponseEntity<RentDto>(rentDto, HttpStatus.OK);
    }

    public ResponseEntity<RentDto> returnBook(Long rentId) {
        RentDto rentDto;
        try {
            rentDto = rentMapper.mapToRentDto(dbService.returnBook(rentId));
        } catch (Exception e) {
            log.error("ERROR during returning book - rentId: " + rentId);
            return new ResponseEntity<RentDto>(HttpStatus.NOT_FOUND);
        }
        Reader reader = dbService.getRent(rentId).getReader();
        String title = dbService.getRent(rentId).getBook().getTitle().getTitle();

        mailService.send(new Mail(
                reader.getEmail(),
                "Retuning book to the library",
                "You has returned a book " + title));

        return new ResponseEntity<RentDto>(rentDto, HttpStatus.OK);
    }

    public ResponseEntity<BookDto> updateBook(Long bookId, String status) {
        BookDto bookDto;
        try {
            bookDto = bookMapper.mapToBookDtoWithTask(dbService.updateBook(bookId, status));
        } catch (Exception e) {
            log.error("ERROR during updating book status. bookId: " + bookId + " status: " + status);
            return new ResponseEntity<BookDto>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BookDto>(bookDto, HttpStatus.OK);
    }


}
