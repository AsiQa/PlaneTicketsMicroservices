package com.raf.karte.service.repository;

import com.raf.karte.service.domain.Karta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Optional;

public interface KartaRepository extends JpaRepository<Karta, Long> {

    Optional<Karta> findByUserIdAndLetId(Long userId, Long letId);
    Optional<Karta> findByUserId(Long userId);

}
