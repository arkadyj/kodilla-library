package com.kodilla.library.repository;

import com.kodilla.library.domain.Reader;
import com.kodilla.library.domain.Rent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface RentRepository extends CrudRepository<Rent, Long> {

    List<Rent> findAll();

    Rent findById(Long id);

    List<Rent> findRentByReader(Reader reader);

    @Query(value = "SELECT * from Rents WHERE book_id=:PARAM1",nativeQuery = true )
    List<Rent> getBookRents(@Param("PARAM1") Long id);

    //List<Rent> findAllByBook_Id(Long id);

    @Query(value = "SELECT * from Rents WHERE return_date is null",nativeQuery = true )
    List<Rent> getRentsNotReturn();

    @Query(value = "DELETE FROM RENTS",nativeQuery = true )
    void truncateRents();

    void deleteById(Long id);
}
