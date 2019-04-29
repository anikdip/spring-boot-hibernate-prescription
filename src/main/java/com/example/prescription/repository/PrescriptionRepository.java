package com.example.prescription.repository;

import com.example.prescription.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    @Query("select p from Prescription p where p.date between :from and :to")
    public List<Prescription> findByDate(@Param("from") String fromDate, @Param("to") String toDate);

    @Query("select p from Prescription p where p.id=:id")
    public Prescription findOne(@Param("id") long id);
}
