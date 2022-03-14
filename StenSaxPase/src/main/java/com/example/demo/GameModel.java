package com.example.demo;

import java.util.Random;

public class GameModel {

	private String playerMove;
	private String computerMove;
	private int playerWins;
	private int computerWins;
	private int playerLosses;
	private int computerLosses;
	private int playerTies;
	private int computerTies;
	private int gamesPlayed;

	public GameModel() {
	}

	public String getPlayerMove() {
		return playerMove;
	}

	public void setPlayerMove(String playerMove) {
		this.playerMove = playerMove;
	}

	public String getComputerMove() {
		return computerMove;
	}

	public void setComputerMove(String computerMove) {
		this.computerMove = computerMove;
	}

	public int getPlayerWins() {
		return playerWins;
	}

	public void addPlayerWins() {
		this.playerWins += 1;
	}

	public void addComputerWins() {
		this.computerWins += 1;
	}

	public void addPlayerLosses() {
		this.playerLosses += 1;
	}

	public void addComputerLosses() {
		this.computerLosses += 1;
	}

	public void addPlayerTies() {
		this.playerTies += 1;
	}

	public void addComputerTies() {
		this.computerTies += 1;
	}

	public int getComputerWins() {
		return computerWins;
	}

	public int getPlayerLosses() {
		return playerLosses;
	}

	public int getComputerLosses() {
		return computerLosses;
	}

	public int getPlayerTies() {
		return playerTies;
	}

	public int getComputerTies() {
		return computerTies;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public String Random() {
		String[] computerChoices = new String[] { "rock", "paper", "scissors" };
		int RandomNumber = new Random().nextInt(3);

		String computerMove = computerChoices[RandomNumber];
		return computerMove;
	}

	public String compareResults() {
		setComputerMove(Random());
		String Computer = getComputerMove();
		String Player = getPlayerMove();
		String Winner = "";

		switch (Player) {
		case "rock": // player

			switch (Computer) {
			case "rock":
				addPlayerTies();
				addComputerTies();
				gamesPlayed += 1;
				Winner = "tie";
				break;
			case "scissors":
				addPlayerWins();
				addComputerLosses();
				gamesPlayed += 1;
				Winner = "Player";
				break;
			case "paper":
				addComputerWins();
				addPlayerLosses();
				gamesPlayed += 1;
				Winner = "Computer";
				break;
			}

			break;

		case "scissors": // player

			switch (Computer) {
			case "rock":
				addComputerWins();
				addPlayerLosses();
				gamesPlayed += 1;
				Winner = "Computer";
				break;
			case "scissors":
				addPlayerTies();
				addComputerTies();
				gamesPlayed += 1;
				Winner = "tie";
				break;
			case "paper":
				addPlayerWins();
				addComputerLosses();
				gamesPlayed += 1;
				Winner = "Player";
				break;
			}
			break;
		case "paper": // player
			switch (Computer) {
			case "rock":
				addPlayerWins();
				addComputerLosses();
				gamesPlayed += 1;
				Winner = "Player";
				break;
			case "scissors":
				addComputerWins();
				addPlayerLosses();
				gamesPlayed += 1;
				Winner = "Computer";
				break;
			case "paper":
				addPlayerTies();
				addComputerTies();
				gamesPlayed += 1;
				Winner = "tie";
				break;
			}
			break;

		}

		return Winner;
	}

}
