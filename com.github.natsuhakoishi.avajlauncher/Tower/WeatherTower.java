package com.github.natsuhakoishi.avajlauncher.Tower;

import com.github.natsuhakoishi.avajlauncher.Coordinates.*;

public class WeatherTower extends Tower
{
	public String getWeather(Coordinates p_coordinates)
	{
		String weather = WeatherProvider.getInstance().getCurrentWeather(p_coordinates);
		return (weather);
	}

	public void changeWeather()
	{
		conditionChanged();
	}
}
