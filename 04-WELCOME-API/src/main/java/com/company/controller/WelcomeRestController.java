package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.company.api.GreetClient;
import com.company.api.external.Jokes;
import com.company.response.WelcomeResponse;

@RestController
public class WelcomeRestController {

	@Autowired
	GreetClient greetClient;

	@GetMapping("/welcome")
	public WelcomeResponse getWelcomeMsg() {
		String welcomeMsg = "Hi, Welcome ";

		// Inter-service communication
		String greetMsg = greetClient.invokeGreetApi();
		
		//External-service communication
		RestTemplate rt = new RestTemplate();
		
		String endpointUrl = "https://official-joke-api.appspot.com/random_joke";
		
		ResponseEntity<Jokes> entity = rt.getForEntity(endpointUrl, Jokes.class);
		
		Jokes jokes = entity.getBody();
		
		WelcomeResponse finalResponse = new WelcomeResponse();
		finalResponse.setGreet(greetMsg);
		finalResponse.setWelcome(welcomeMsg);
		finalResponse.setJokes(jokes);
		
		return finalResponse;
	}
}
