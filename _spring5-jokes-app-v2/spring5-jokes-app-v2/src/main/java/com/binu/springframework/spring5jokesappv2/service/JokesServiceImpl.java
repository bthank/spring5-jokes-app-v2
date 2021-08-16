package com.binu.springframework.spring5jokesappv2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binu.springframework.spring5jokesappv2.model.Joke;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;

@Service
public class JokesServiceImpl implements JokesService {

	private final ChuckNorrisQuotes quotes;
	
	@Autowired
	public JokesServiceImpl() {
		this.quotes = new ChuckNorrisQuotes();
	}

	@Override
	public Joke getRandomJoke() {
			
		String randomJoke = quotes.getRandomQuote();
		
		Joke joke = new Joke();
		joke.setId(1);
		joke.setText(randomJoke);
				
		return joke;
	}
	
	@Override
	public List<Joke> getRandomJokes(int numJokes) {
			
		
		List<Joke> randomJokes = new ArrayList<>();
		
		for (int i=0; i < numJokes; i++) {
			randomJokes.add(new Joke(i+1,quotes.getRandomQuote()));
		}
		
		return randomJokes;
	}

}
