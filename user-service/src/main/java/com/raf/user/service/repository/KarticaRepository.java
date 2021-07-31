package com.raf.user.service.repository;

import com.raf.user.service.domain.Kartica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KarticaRepository  extends JpaRepository<Kartica, Long> {

    Optional<Kartica> findKarticaByBrojKartice(Integer brojKartice);
}
