package ua.lviv.lgs.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.ScoresRepository;
import ua.lviv.lgs.domain.Scores;

@Service
public class ScoresService {

	private Logger logger = LoggerFactory.getLogger(BucketService.class);
	@Autowired
	private ScoresRepository scoresRepository;
	
	public Scores save(Scores scores) {
		logger.info("Create scores item : { " + scores + " }");
		return scoresRepository.save(scores);
	}
	public List<Scores> getAllScores(){
		logger.info("Get all scores items");
		return scoresRepository.findAll();
	}
	public Scores findById(Integer id) {
		logger.info("Get scores item by id: " + id);
		return scoresRepository.findById(id).get();
	}
}
