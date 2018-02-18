package com.kodilla.library.repository;

import com.kodilla.library.domain.Title;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface TitleRepository extends CrudRepository<Title, Long> {

    Title findById (Long id);

    @Override
    Title save (Title title );

    @Query(value = "SELECT t.id, t.title, t.author, t.publish_Year from Books b, Titles t  WHERE t.id=b.title_id and  b.status=:PARAM1",nativeQuery = true )
    List<Title> getTitlesByStatus(@Param("PARAM1") String status);


}
