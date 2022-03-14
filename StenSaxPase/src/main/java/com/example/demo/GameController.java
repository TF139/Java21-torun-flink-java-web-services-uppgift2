package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/Game")
public class GameController {

	GameModel GM = new GameModel();
	@RequestMapping(method = RequestMethod.POST)
	public String game (String playerMove) {
		
		GM.setPlayerMove(playerMove);
		return "Player: " + GM.getPlayerMove() + "<br>" + "Computer: " + GM.getComputerMove() + "<br>" + "Winner: " + GM.compareResults();
		
		
	}

	@RequestMapping (method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public String Result () {
		return ObjectJson();
			
		}
	private String ObjectJson () {
		
		return "{"+ 
				"\"Total_Games\": \"" + GM.getGamesPlayed() + 
				"\"," +
				
				"\"Player\":" + 
					"[{"+
						"\"TotalWins\":" + "\"" + GM.getPlayerWins() + "\""+ 
						"," +
						"\"TotalLoss\":" + "\"" + GM.getPlayerLosses() + "\""+ 
						"," +
						"\"TotalTie\":" + "\"" + GM.getPlayerTies() + "\""+
					"}]"+
				"," +
				
				"\"Computer\":" + 
					"[{"+
						"\"TotalWins\":" + "\"" + GM.getComputerWins() + "\""+ 
						"," +
						"\"TotalLoss\":" + "\"" + GM.getComputerLosses() + "\""+ 
						"," +
						"\"TotalTie\":" + "\"" + GM.getComputerTies() + "\""+
					"}]"+
				"}";
	}
}
