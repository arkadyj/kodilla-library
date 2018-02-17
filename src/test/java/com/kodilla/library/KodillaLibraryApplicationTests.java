package com.kodilla.library;

import com.kodilla.library.domain.Reader;
import com.kodilla.library.domain.Title;
import com.kodilla.library.repository.BookRepository;
import com.kodilla.library.repository.ReaderRepository;
import com.kodilla.library.repository.RentRepository;
import com.kodilla.library.repository.TitleRepository;
import com.kodilla.library.service.DbService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KodillaLibraryApplicationTests {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private RentRepository rentRepository;
	@Autowired
	private ReaderRepository readerRepository;
	@Autowired
	private TitleRepository titleRepository;
	@Autowired
	private DbService dbService;
	DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	@After
	public void afterTest() {
		//dbService.deleteRentsAll();
		//Rent rent = dbService.getRent(1L);
		//rentRespository.deleteById(1L);
		//rentRespository.delete(rent);
		//rentRepository.deleteAll();

	}

	@Test
	public void testReaderSave() {
		//Given

		Reader reader = new Reader("Darek", "Kozłowski", LocalDate.now().format(dateFormat));
		Title title = new Title("Bajki Robotów", "Stanisław Lem", "1955");
		Title title1 = new Title("Problem trzech ciał", "Cixin Liu", "2017");

		//When
		dbService.createReader(reader);

		dbService.createBookWithTitle(title);
		dbService.createBookWithTitle(title1);
		dbService.createBook(title1.getId());
		dbService.rentBook(1L, 1L);
		dbService.rentBook(3L, 1L);
		dbService.returnBook(1L);

		long bookCount = dbService.getCountBooksWithStatusByTitle(2L,"FREE");
		String searchTitle = dbService.getTitle(1L).getTitle();
		String searchReader = dbService.getReader(1L).getSname();



		//Then
		Assert.assertEquals(2,bookCount);
		Assert.assertEquals("Bajki Robotów",searchTitle);
		Assert.assertEquals("Kozłowski",searchReader);


		//rentRespository.delete(2L);
		//rentRespository.delete(3L);
		/*
		readerRepository.save(reader);
		book.setTitle(title);
		title.getBooks().add(book);
		titleRepository.save(title);
		reader.getRents().add(rent);
		book.getRents().add(rent);
		rent.setReader(reader);
		rent.setBook(book);
		rentRespository.save(rent); */








		/* WYPOZYCZENIE KSIAZKI
		Book book1 = dbService.getBook(5L);
		Reader reader1 = dbService.getReader(1L);
		book1.setStatus("ZAJETA");
		reader1.getRents().add(rent);
		book1.getRents().add(rent);
		rent.setReader(reader1);
		rent.setBook(book1);
		rentRespository.save(rent);
		*/




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
