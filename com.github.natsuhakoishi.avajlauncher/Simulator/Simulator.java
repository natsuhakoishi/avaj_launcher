package com.github.natsuhakoishi.avajlauncher.Simulator;

import java.io.IOException;

import com.github.natsuhakoishi.avajlauncher.Exception.*;
import com.github.natsuhakoishi.avajlauncher.Tower.WeatherTower;
import com.github.natsuhakoishi.avajlauncher.utils.*;

public class Simulator
{
	public Simulator() {}

	public void start(String filename, WeatherTower wTower) throws IOException, InvalidFileContentException
	{
		try
		{
			FileTool.overwrite();
			int runtime = Parse.parseFile(filename, wTower);

			for (int i = 0; i < runtime; i++)
			{
				wTower.changeWeather();
			}
			if (wTower.getObserversSize() == 0)
					FileTool.writeIn("Tower: All Aircraft Landed.\n");
			FileTool.writeIn("Simulator: Max runtime reached, simulation terminated.\n");
		}
		catch (IOException | InvalidFileContentException error)
		{
			error.printStackTrace();
		}
	}
}
