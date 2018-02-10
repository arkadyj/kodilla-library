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

	@Test
	public void testReaderSave() {
		//Given
		Reader reader = new Reader("Arek", "Szelag", LocalDate.now());
		Title title = new Title("Nieustraszony", "Stanisław Lem", "1950");
		Book book = new Book("WOLNA");
		Rent rent = new Rent(LocalDate.now().minusDays(5),LocalDate.now());
		System.out.println(LocalDate.now());
		//When
		// Do testów bazy

		System.out.println(readerRepository.findById(1L));
		Reader reader1 = readerRepository.findById(1L);

		book.setTitle(title);

		rent.setBook(book);
		rent.setReader(reader);
		book.getRent().add(rent);


		bookRepository.save(book);
		rentRespository.save(rent);



		//Then
	}
}
