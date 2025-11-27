package com.github.natsuhakoishi.avaj_launcher.Main;

import java.io.*;

import com.github.natsuhakoishi.avaj_launcher.Exception.InvalidFileContentException;
import com.github.natsuhakoishi.avaj_launcher.Simulator.*;
import com.github.natsuhakoishi.avaj_launcher.Tower.WeatherTower;

public class Main
{
	public static void main(String[] args)
	{
		try
		{
			WeatherTower wTower = new WeatherTower();
			Simulator simulator = new Simulator();

			if (args.length != 2)
				throw new IllegalArgumentException("Invalid number of arguments");

			simulator.start(args[1], wTower);
		}
		catch (IOException | IllegalArgumentException | InvalidFileContentException error)
		{
			error.printStackTrace();
		}
	}
}
