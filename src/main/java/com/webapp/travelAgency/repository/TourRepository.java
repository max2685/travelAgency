package com.webapp.travelAgency.repository;

import com.webapp.travelAgency.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {

    @Query("from Tour t left join fetch t.comments where t.id = :id")
    Tour getByIdWithComments(@Param("id") Long id);

    List<Tour> findByDateBetween(Date startDate, Date endDate);
}
