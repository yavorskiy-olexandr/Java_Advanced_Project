package ua.lviv.lgs.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.domain.Scores;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.BucketService;
import ua.lviv.lgs.service.ScoresService;
import ua.lviv.lgs.service.UserService;

@Controller
public class BucketController {
	@Autowired
	private BucketService bucketService;

	@Autowired
	private UserService userService;

	@Autowired
	private ScoresService scoresService;
	
	@RequestMapping(value ="/buckets", method = RequestMethod.GET)
    public ModelAndView getAllItems() {
    	return getBucketItems();
    }
	@RequestMapping(value ="/bucket", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam String scoresId) {
		
		Scores scores = scoresService.findById(Integer.parseInt(scoresId));
		
		Bucket bucket = new Bucket();
		bucket.setScores(scores);
		bucket.setPurchaseDate(new Date());
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userEmail = auth.getName();
		User user = userService.findByEmail(userEmail);
		bucket.setUser(user);
		bucketService.add(bucket);
    	return getBucketItems();
    }
	@RequestMapping(value ="/bucket", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam String id) {
		bucketService.delete(new Bucket(Integer.parseInt(id.replaceAll("\\s",""))));
    	return getBucketItems();
    }
	private ModelAndView getBucketItems() {
		ModelAndView map = new ModelAndView("bucket");
		map.addObject("bucketItems", bucketService.getAll());
		return map;
	}
}
