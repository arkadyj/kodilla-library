package com.kodilla.library;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.Reader;
import com.kodilla.library.domain.Rent;
import com.kodilla.library.domain.Title;
import com.kodilla.library.repository.BookRepository;
import com.kodilla.library.repository.ReaderRepository;
import com.kodilla.library.repository.RentRespository;
import com.kodilla.library.repository.TitleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KodillaLibraryApplicationTests {

	@Autowired
	private ReaderRepository readerRepository;
	@Autowired
	private TitleRepository titleRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private RentRespository rentRespository;



	@Test
	public void testReaderSave() {
		//Given

		Reader reader = new Reader("Arek", "Szelag", LocalDateTime.now());
		Title title = new Title("Nieustraszony", "Stanisław Lem", "1950");
		Book book = new Book("WOLNA");
		Rent rent = new Rent(LocalDate.now().minusDays(5),LocalDate.now());

		//When
		//readerRepository.save(reader);
		book.setTitle(title);
		//bookRepository.save(book);
		rent.setReader(reader);
		rent.setBook(book);
		book.getRent().add(rent);
		//rent.getBooks().add(book);

		//rent.setBook(book);
		//rent.getBooks().add(book);
		//rent.setBook(book);
		bookRepository.save(book);
		//titleRepository.save(title);
		rentRespository.save(rent);

		//Then
	}

	@Test
	public void contextLoads() {
	}

}
