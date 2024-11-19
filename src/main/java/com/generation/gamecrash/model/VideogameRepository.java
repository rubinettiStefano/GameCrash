package com.generation.gamecrash.model;

import com.generation.gamecrash.helpers.DbHelper;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VideogameRepository
{
	private static VideogameRepository instance;
	public static VideogameRepository getInstance()
	{
		if(instance == null)
			instance = new VideogameRepository();

		return instance;
	}

	private VideogameRepository(){}

	private DbHelper dbHelper = DbHelper.getInstance();

	public List<Videogame> findAllVideogames() throws SQLException
	{
		ResultSet rs = dbHelper.executeSelect("SELECT * FROM videogame");
		List<Videogame> videogames = new ArrayList<>();

		while (rs.next())
		{
			videogames.add(convertFromRowToObject(rs));
		}

		return videogames;
	}

	private Videogame convertFromRowToObject(ResultSet rs) throws SQLException
	{
		Videogame videogame = new Videogame();
		videogame.setId(rs.getInt("id"));
		videogame.setTitle(rs.getString("title"));
		videogame.setGenre(rs.getString("genre"));
		videogame.setPlatforms(rs.getString("platforms"));
		videogame.setPrice(rs.getDouble("price"));
		videogame.setCopies_sold(rs.getInt("copies_sold"));
		return videogame;
	}

	public Videogame findVideogameBydId(int id) throws SQLException
	{
		ResultSet rs = dbHelper.executeSelect("SELECT * FROM videogame WHERE id = " + id);
		if(rs.next())
			return convertFromRowToObject(rs);

		return null;
	}

	public void acquista(Videogame v)
	{
		String query = "UPDATE videogame SET copies_sold = " + v.getCopies_sold() + " WHERE id = " + v.getId();
		dbHelper.executeDML(query);
	}

	public void insert(Videogame v)
	{
		String query = String.format(
				"INSERT INTO videogame (title, genre, platforms, price, copies_sold) VALUES ('%s', '%s', '%s', %.2f, %d);",
				v.getTitle(),
				v.getGenre(),
				v.getPlatforms(),
				v.getPrice(),
				v.getCopies_sold()
		);

		dbHelper.executeDML(query);
	}
}
