package com.generation.gamecrash.helpers;

import com.generation.gamecrash.model.Videogame;
import com.generation.gamecrash.model.VideogameRepository;

import javax.swing.text.View;
import java.sql.SQLException;

public class ControllerHelper
{
	private static ControllerHelper instance;
	public static ControllerHelper getInstance()
	{
		if (instance == null)
			instance = new ControllerHelper();
		return instance;
	}

	private VideogameRepository repo = VideogameRepository.getInstance();

	public String produciLista()
	{
		StringBuilder sb = new StringBuilder();
		try
		{
			for(Videogame v : repo.findAllVideogames())
			{
				sb.append(v.getId()+" ");
				sb.append(v.getTitle()+" ");
				sb.append(v.getGenre()+" ");
				sb.append(v.getPlatforms()+" ");
				sb.append(v.getPrice()+" ");
				sb.append(v.getCopies_sold()+"\n");

			}
			return sb.toString();

		} catch (SQLException e)
		{
			return "Problema lettura db";
		}
	}

	public String acquistaVideogioco(int id)
	{
		try
		{

			Videogame v = repo.findVideogameBydId(id);
			if(v == null)
				return "Videogioco non trovato";

			v.setCopies_sold(v.getCopies_sold()+1);
			repo.acquista(v);
			return produciLista();
		}
		catch (SQLException e)
		{
			return "Problema con db";
		}
	}

	public String inserisciVideogioco(String title, String genre, String platform, double price)
	{
		Videogame v = new Videogame(title, genre, platform, price, 0);
		repo.insert(v);
		return produciLista();
	}
}
