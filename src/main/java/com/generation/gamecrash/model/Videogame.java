package com.generation.gamecrash.model;

import java.util.StringJoiner;

public class Videogame
{
	private int id;
	private String title,genre,platforms;
	private double price;
	private int copies_sold;

	public Videogame(){}

	public Videogame(String title, String genre, String platforms, double price, int copies_sold)
	{
		this.title = title;
		this.genre = genre;
		this.platforms = platforms;
		this.price = price;
		this.copies_sold = copies_sold;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getGenre()
	{
		return genre;
	}

	public void setGenre(String genre)
	{
		this.genre = genre;
	}

	public String getPlatforms()
	{
		return platforms;
	}

	public void setPlatforms(String platforms)
	{
		this.platforms = platforms;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public int getCopies_sold()
	{
		return copies_sold;
	}

	public void setCopies_sold(int copies_sold)
	{
		this.copies_sold = copies_sold;
	}

	@Override
	public String toString()
	{
		return new StringJoiner(", ", Videogame.class.getSimpleName() + "[", "]")
				.add("id=" + id)
				.add("title='" + title + "'")
				.add("genre='" + genre + "'")
				.add("platforms='" + platforms + "'")
				.add("price=" + price)
				.add("copies_sold=" + copies_sold)
				.toString();
	}
}
