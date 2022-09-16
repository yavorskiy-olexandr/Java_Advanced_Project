package ua.lviv.lgs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.ScoresRepository;
import ua.lviv.lgs.domain.Scores;

@Service
public class ScoresService {
	@Autowired
	private ScoresRepository scoresRepository;
	
	public Scores save(Scores scores) {
		return scoresRepository.save(scores);
	}
	public List<Scores> getAllScores(){
		return scoresRepository.findAll();
	}
}
