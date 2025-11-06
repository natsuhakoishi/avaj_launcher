package srcs.Main;

import java.io.*;

import srcs.Exception.InvalidFileContentException;
import srcs.Tower.WeatherTower;
import srcs.Simulator.*;

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
