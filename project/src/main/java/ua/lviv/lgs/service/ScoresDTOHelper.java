package ua.lviv.lgs.service;

import java.io.IOException;
import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

import ua.lviv.lgs.domain.Scores;

public class ScoresDTOHelper {
	public static Scores createEntity(MultipartFile file, Double math, Double phisics, Double english) throws IOException {
		Scores scores = new Scores();
		scores.setMath(math);
		scores.setPhisics(phisics);
		scores.setEnglish(english);
		scores.setEncodedImage(Base64.getEncoder().encodeToString(file.getBytes()));
		return scores;
	}

}
