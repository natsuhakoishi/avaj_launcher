package com.github.natsuhakoishi.avaj_launcher.Flyable;

import com.github.natsuhakoishi.avaj_launcher.Coordinates.*;

public class Aircraft extends Flyable
{
	protected long id;
	protected String name;
	protected Coordinates coordinates;

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinate)
	{
		this.id = p_id;
		this.name = p_name;
		this.coordinates = p_coordinate;
	}

	@Override
	public void updateConditions()
	{
		throw new UnsupportedOperationException("Exception: updateConditions() only can be use by derived class.");
	}
}
