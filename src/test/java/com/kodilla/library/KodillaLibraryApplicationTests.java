package com.kodilla.library;

import com.kodilla.library.domain.Reader;
import com.kodilla.library.domain.Title;
import com.kodilla.library.service.DbService;
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
    private DbService dbService;
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Test
    public void testReaderSave() {
        //Given

        Reader reader = new Reader("Darek", "Kozłowski", "szelaga@gmail.com", LocalDate.now().format(dateFormat));
        Title title = new Title("Bajki Robotów", "Stanisław Lem", "1955");
        Title title1 = new Title("Problem trzech ciał", "Cixin Liu", "2017");

        //When
        dbService.createReader(reader);
        dbService.createBookWithTitle(title);
        dbService.createBookWithTitle(title1);
        dbService.createBook(title1.getId());
        dbService.createBook(title1.getId());

        long bookId = title.getBooks().get(0).getId();
        long bookId1 = title1.getBooks().get(0).getId();
        long readerId = reader.getId();
        long titleId = title.getId();
        long titleId1 = title1.getId();
        long rentId = dbService.rentBook(bookId, readerId).getId();
        long rentId1 = dbService.rentBook(bookId1, readerId).getId();

        dbService.returnBook(rentId);

        long bookCountFree = dbService.getCountBooksWithStatusByTitle(titleId1, "FREE");
        long bookCountBorrowed = dbService.getCountBooksWithStatusByTitle(titleId1, "BORROWED");
        String searchTitle = dbService.getTitle(titleId).getTitle();
        String searchReader = dbService.getReader(readerId).getSname();


        //Then
        Assert.assertEquals(2, bookCountFree);
        Assert.assertEquals(1, bookCountBorrowed);
        Assert.assertEquals("Bajki Robotów", searchTitle);
        Assert.assertEquals("Kozłowski", searchReader);

        try {
            dbService.deleteRent(rentId);
            dbService.deleteRent(rentId1);
            dbService.deleteBook(bookId);
            dbService.deleteBook(bookId1);
            dbService.deleteBook(bookId1 + 1);
            dbService.deleteBook(bookId1 + 2);
            dbService.deleteTitle(titleId);
            dbService.deleteTitle(titleId1);
            dbService.deleteReader(readerId);
        } catch (Exception e) {
            System.out.println("Error during cleaning database." + e);
        }
    }
}
