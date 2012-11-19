package com.example.mafia;

public class Player {
	
	private int type;
	private String name;
	private int ID;
	
	public void setID(int id)
	{
		ID=id;
	}
	
	public int getID()
	{	
		return ID;
	}
	
	public void setName(String n)
	{
		name=n;
	}
	
	public String getName()
	{	
		return name;
	}
	
	public void setType(int t)
	{
		type=t;
	}
	
	public int getType()
	{
		
		return type;
	}
}
