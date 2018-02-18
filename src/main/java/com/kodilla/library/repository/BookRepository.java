package com.kodilla.library.repository;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.Dto.BookDto;
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

    @Query(value = "SELECT * from Books WHERE title_id=:PARAM1 AND status=:PARAM2",nativeQuery = true )
    List<Book> getBooksByStatus(@Param("PARAM1") Long id, @Param("PARAM2") String status);

    long countByTitle_IdAndStatus(Long titleId, String status);

    List<Book> findByTitle_IdAndStatus(Long titleId, String status);

    @Query(value = "SELECT min(id) FROM Books",nativeQuery = true )
    Long getBookFirstId();
}
