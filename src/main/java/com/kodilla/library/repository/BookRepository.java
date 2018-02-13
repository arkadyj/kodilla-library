package com.kodilla.library.repository;

import com.kodilla.library.domain.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    Book findById(Long id);

    @Override
    Book save (Book book);

    /*
    @Query(value = "SELECT * from Books WHERE title_id=:PARAM1",nativeQuery = true )
    List<Book> getBooksByStatus(@Param("PARAM1") Long id);
    */
    long countByTitle_IdAndStatus(Long titleId, String status);
}
