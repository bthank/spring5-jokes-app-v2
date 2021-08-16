package com.binu.springframework.spring5jokesappv2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.binu.springframework.spring5jokesappv2.model.Joke;
import com.binu.springframework.spring5jokesappv2.service.JokesService;

@Controller
@RequestMapping("/api/v2")
public class JokesController {

	
	private final JokesService jokesService;

	@Autowired
	public JokesController(JokesService jokesService) {
		this.jokesService = jokesService;
	}
	
	@RequestMapping({"/",""})
	public String displayRandomJoke(Model model) {
		
		
		Joke randomJoke = jokesService.getRandomJoke();
				
		model.addAttribute("randomJoke",randomJoke);	
		model.addAttribute("randomJokeId",randomJoke.getId());
		model.addAttribute("randomJokeText",randomJoke.getText());		
		return "jokes/index";
		
	}

	
	@RequestMapping("/jokes")
	public String displayRandomJokes(Model model) {
		
		
		List<Joke> randomJokes = jokesService.getRandomJokes(5);
				
		model.addAttribute("randomJokes",randomJokes);
		
		return "jokes/list5Jokes";
		
	}
	
	
}
