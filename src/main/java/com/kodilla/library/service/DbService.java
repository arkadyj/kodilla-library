package com.kodilla.library.service;

import com.kodilla.library.domain.*;
import com.kodilla.library.repository.BookRepository;
import com.kodilla.library.repository.ReaderRepository;
import com.kodilla.library.repository.RentRepository;
import com.kodilla.library.repository.TitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DbService {


    private final ReaderRepository readerRepository;
    private final BookRepository bookRepository;
    private final TitleRepository titleRepository;
    private final RentRepository rentRepository;
    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Title getTitle(Long id) {
        return titleRepository.findById(id);
    }

    public List<Title> getTitlesByStatus(String status) {
        return titleRepository.getTitlesByStatus(status);
    }

    public Title createTitle(Title title) {
        return titleRepository.save(title);
    }

    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

    public Reader getReader(Long id) {
        return readerRepository.findById(id);
    }

    public Reader createReader(Reader reader) {
        return readerRepository.save(reader);
    }

    public Book getBook(Long id) {
        return bookRepository.findById(id);
    }

    public Long getBookFirstId() {
        return bookRepository.getBookFirstId();
    }

    public Book createBook(Long titleId) {
        Book book = new Book(("FREE"));
        Title title = getTitle(titleId);
        title.getBooks().add(book);
        book.setTitle(title);
        return bookRepository.save(book);
    }

    public long getCountBooksWithStatusByTitle(Long titleId, String status) {
        return bookRepository.countByTitle_IdAndStatus(titleId, status);
    }

    public List<Book> getBooksByStatus(Long titleId, String status) {
        return bookRepository.findByTitle_IdAndStatus(titleId, status);
    }

    public Book updateBook(Long bookId, String status) {
        Book book = bookRepository.findById(bookId);
        Title title = titleRepository.findById(book.getTitle().getId());
        book.setStatus(status);
        book.setTitle(title);
        title.getBooks().add(book);
        return bookRepository.save(book);
    }

    public Title createBookWithTitle(Title title) {
        Book book = new Book("FREE");
        title.getBooks().add(book);
        book.setTitle(title);
        return titleRepository.save(title);
    }

    public Rent rentBook(Long bookId, Long readerId) {
        if (bookRepository.findById(bookId).getStatus().equals("FREE")) {
            Rent rent = new Rent(LocalDate.now().format(dateFormat), null);
            Book book = bookRepository.findById(bookId);
            Reader reader = readerRepository.findById(readerId);
            updateBook(bookId, "BORROWED");
            reader.getRents().add(rent);
            book.getRents().add(rent);
            rent.setBook(book);
            rent.setReader(reader);
            return rentRepository.save(rent);
        }
        return new Rent();
    }

    public Rent returnBook(Long rentId) {
        Rent rent = rentRepository.findById(rentId);
        if (rent.getReturnDate() == null) {
            Long bookId = rent.getBook().getId();
            updateBook(bookId, "FREE");
            rent.setReturnDate(LocalDate.now().format(dateFormat));
            return rentRepository.save(rent);
        }
        return rentRepository.findById(rentId);
    }

    public Rent getRent(Long rentId) {
        return rentRepository.findById(rentId);
    }

    public List<Rent> getRents() {
        return rentRepository.findAll();
    }

    public List<Rent> getRentsByReader(Long readerId) {
        Reader reader = readerRepository.findById(readerId);
        return rentRepository.findRentByReader(reader);
    }

    public List<Rent> getRentsByBook(Long bookId) {
        return rentRepository.getBookRents(bookId);
    }

    public List<Rent> getRentsNotReturn() {
        return rentRepository.getRentsNotReturn();
    }

    public void deleteRent(Long rentId) {
        Rent rent = rentRepository.findById(rentId);
        rent.getReader().getRents().remove(rent);
        rent.getBook().getRents().remove(rent);
        rent.setBook(null);
        rent.setReader(null);
        rentRepository.save(rent);
        rentRepository.delete(rentId);
    }

    public void deleteBook(Long bookId) {
        Book book = bookRepository.findById(bookId);
        book.getTitle().getBooks().remove(book);
        book.setTitle(null);
        bookRepository.save(book);
        bookRepository.delete(book);
    }

    public void deleteTitle(Long titleId) {
        titleRepository.delete(titleId);
    }

    public void deleteReader(Long readerId) {
        readerRepository.delete(readerId);
    }
}
