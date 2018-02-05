package com.kodilla.library;

import com.kodilla.library.domain.Reader;
import com.kodilla.library.domain.Title;
import com.kodilla.library.repository.ReaderRepository;
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



	@Test
	public void testReaderSave() {
		//Given

		//Reader reader = new Reader("Arek", "Szelag", LocalDateTime.now());
		Title title = new Title("Nieustraszony", "Stanisław Lem", "1950");

		//When
		//readerRepository.save(reader);
		titleRepository.save(title);

		//Then
	}

	@Test
	public void contextLoads() {
	}

}
