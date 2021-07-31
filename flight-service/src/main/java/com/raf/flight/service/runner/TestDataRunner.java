package com.raf.flight.service.runner;

import com.raf.flight.service.domain.Avion;
import com.raf.flight.service.domain.Let;
import com.raf.flight.service.repository.AvionRepository;
import com.raf.flight.service.repository.LetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Profile({"default"})
@Component
public class TestDataRunner implements CommandLineRunner {

    private LetRepository letRepository;
    private AvionRepository avionRepository;

    public TestDataRunner(LetRepository letRepository, AvionRepository avionRepository) {
        this.letRepository = letRepository;
        this.avionRepository = avionRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        //Insert avione

        Avion avion1 = new Avion("Bobi1", 30);
        Avion avion2 = new Avion("Bob2", 30);

        avionRepository.save(avion1);
        avionRepository.save(avion2);

        //Insert letove

        BigDecimal bD = new BigDecimal("200e");

        Let let1 = new Let( new Long(1), "P", "A",  100 , bD);
        Let let2 = new Let(new Long(2), "S", "A",  200 , bD);

        letRepository.save(let1);
        letRepository.save(let2);
    }
}
