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
public interface ReaderRepository extends CrudRepository<Reader, Long> {

    @Override
    List<Reader> findAll();

    Reader findById(Long id);

    Reader save (Reader reader);



}
