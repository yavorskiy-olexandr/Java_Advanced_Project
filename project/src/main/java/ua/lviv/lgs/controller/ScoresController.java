package ua.lviv.lgs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ua.lviv.lgs.domain.Scores;
import ua.lviv.lgs.service.ScoresService;
@Controller
public class ScoresController {
	@Autowired
	ScoresService scoresService;
	@RequestMapping(value="/addScores", method=RequestMethod.POST)
	public ModelAndView createScores(@Validated @ModelAttribute("scores") Scores scores, BindingResult bindingResult) {
		
		scoresService.save(scores);
		
		return new ModelAndView("redirect:/home");
		
	}
}
