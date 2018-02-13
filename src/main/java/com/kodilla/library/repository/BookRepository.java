package com.kodilla.library.repository;

import com.kodilla.library.domain.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    Book findById(Long id);

    @Override
    Book save (Book book);

    @Query(value = "UPDATE book set status=:PARAM2 where id :PARAM1)",nativeQuery = true )
    Book updateBook(@Param("PARAM1") Long id, @Param("PARAM2") String status);
}
