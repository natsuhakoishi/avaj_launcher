package com.github.natsuhakoishi.avajlauncher.Flyable;

import com.github.natsuhakoishi.avajlauncher.Tower.*;

public abstract class Flyable
{
	protected WeatherTower weatherTower;

	public abstract void updateConditions();

	public void registerTower(WeatherTower p_tower)
	{
		this.weatherTower = p_tower;
		this.weatherTower.register(this);
	}
}
