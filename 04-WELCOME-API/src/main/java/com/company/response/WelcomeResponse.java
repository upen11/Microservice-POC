package com.company.response;

import com.company.api.external.Jokes;

public class WelcomeResponse {

	private String greet;
	private String welcome;
	private Jokes jokes;

	public String getGreet() {
		return greet;
	}

	public void setGreet(String greet) {
		this.greet = greet;
	}

	public String getWelcome() {
		return welcome;
	}

	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}

	public Jokes getJokes() {
		return jokes;
	}

	public void setJokes(Jokes jokes) {
		this.jokes = jokes;
	}

}
