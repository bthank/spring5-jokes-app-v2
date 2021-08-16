package com.binu.springframework.spring5jokesappv2.service;

import java.util.List;

import com.binu.springframework.spring5jokesappv2.model.Joke;

public interface JokesService {

	Joke getRandomJoke();
	List<Joke> getRandomJokes(int numJokes);	
}
