package com.raf.flight.service.repository;

import com.raf.flight.service.domain.Avion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AvionRepository extends JpaRepository<Avion, Long> {

    Optional<Avion> findByNaziv(String naziv);
    Optional<Avion> findByKapacitet(Integer kapacitet);

}
