package edu.calstatela.cs202.gala.RancherGame;

import java.util.ArrayList;

public class Player {

	private String playerName;
	private static ArrayList<Player> players = new ArrayList<Player>();
	private int sheepAmount;
	
	public Player()
	{
		playerName = "No name";
		sheepAmount = 0;
	}
	
	public Player(String playerName)
	{
		this.playerName = playerName;
		int sheepAmount = 10;
	}
	
	public String getPlayerName()
	{
		return playerName;
	}
	
	public void setPlayers(Player player)
	{
		
	}
}
