package com.github.natsuhakoishi.avajlauncher.Main;

import java.io.*;

import com.github.natsuhakoishi.avajlauncher.Exception.InvalidFileContentException;
import com.github.natsuhakoishi.avajlauncher.Simulator.*;
import com.github.natsuhakoishi.avajlauncher.Tower.WeatherTower;

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
