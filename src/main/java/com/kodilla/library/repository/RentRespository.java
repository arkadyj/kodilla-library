package com.kodilla.library.repository;

import com.kodilla.library.domain.Rent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface RentRespository extends CrudRepository<Rent, Long> {
}