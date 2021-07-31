package com.raf.flight.service.repository;

import com.raf.flight.service.domain.Avion;
import com.raf.flight.service.domain.Let;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface LetRepository  extends JpaRepository<Let, Long> {

    Page<Let> findByAvionId(Long avionId, Pageable pageable);
    Page<Let> findAllByPocetna(String pocetna, Pageable pageable);
    Page<Let> findAllByKrajnja(String krajnja, Pageable pageable);
    Page<Let> findAllByDuzinaLeta(Long duzinaLeta, Pageable pageable);
    Page<Let> findAllByCena(BigDecimal cena, Pageable pageable);

    Optional<Let> findByAvionId(Long avionId);


}
