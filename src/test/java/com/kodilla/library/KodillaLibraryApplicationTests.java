package com.kodilla.library;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.Reader;
import com.kodilla.library.domain.Rent;
import com.kodilla.library.domain.Title;
import com.kodilla.library.repository.BookRepository;
import com.kodilla.library.repository.ReaderRepository;
import com.kodilla.library.repository.RentRespository;
import com.kodilla.library.repository.TitleRepository;
import com.kodilla.library.service.DbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KodillaLibraryApplicationTests {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private RentRespository rentRespository;
	@Autowired
	private ReaderRepository readerRepository;
	@Autowired
	private TitleRepository titleRepository;
	@Autowired
	private DbService dbService;

	@Test
	public void testReaderSave() {
		//Given
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		Reader reader = new Reader("Dare", "Kozłowski", LocalDate.now().format(dateFormat));
		Title title = new Title("Bajki Robotów", "Stanisław Lem", "1955");
		Book book = new Book("WOLNA");
		Rent rent = new Rent(LocalDate.now().minusDays(5).format(dateFormat),LocalDate.now().format(dateFormat));
		//System.out.println(LocalDate.now());
		//When
		// Do testów bazy

		//titleRepository.save(title);

		/* ZMIANA STATUSU BOOK
		Book book1 = dbService.getBook(5L);
		Title title1 = dbService.getTitle(3L);

		book1.setStatus("ZAJETA");

		book1.setTitle(title1);
		title1.getBooks().add(book1);
		bookRepository.save(book1);
		*/

		/*

		//System.out.println(dbService.getTitle(1L));
		//Title title1 = dbService.getTitle(1L);
		//System.out.println(title1);

		title.getBooks().add(book);
		book.setTitle(title);
		//bookRepository.save(book);
		titleRepository.save(title);

		readerRepository.save(reader);

		Book book1 = dbService.getBook(1L);
		Reader reader1 = dbService.getReader(1L);

		reader1.getRents().add(rent);
		book1.getRents().add(rent);
		rent.setReader(reader1);
		rent.setBook(book1);
		rentRespository.save(rent);

		System.out.println(reader1.getRents());
		*/


		//Book book1 = bookRepository.findById(1L);

		//
		//


		//bookRepository.save(book1);


		/*
		System.out.println(readerRepository.findById(1L));
		Reader reader1 = readerRepository.findById(1L);

		book.setTitle(title);

		rent.setBook(book);
		rent.setReader(reader);
		book.getRent().add(rent);


		bookRepository.save(book);
		rentRespository.save(rent);
*/


		//Then
	}
}
