package ua.lviv.lgs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.lviv.lgs.domain.Scores;

public interface ScoresRepository extends JpaRepository<Scores, Integer>{

}
