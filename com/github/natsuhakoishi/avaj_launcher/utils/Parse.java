package com.github.natsuhakoishi.avaj_launcher.utils;

import java.io.*;

import com.github.natsuhakoishi.avaj_launcher.Coordinates.Coordinates;
import com.github.natsuhakoishi.avaj_launcher.Exception.InvalidFileContentException;
import com.github.natsuhakoishi.avaj_launcher.Flyable.AircraftFactory;
import com.github.natsuhakoishi.avaj_launcher.Tower.WeatherTower;

public class Parse
{
	public static void parseAircraft(String line, WeatherTower wTower) throws IOException, InvalidFileContentException
	{
		String[] info = line.split(" ");

		if (info.length != 5)
			throw new InvalidFileContentException("Invalid Aircraft Info: "+line);

		int lon = Integer.parseInt(info[2]);
		int lat = Integer.parseInt(info[3]);
		int height = Integer.parseInt(info[4]);

		if (lon < 0)
			throw new InvalidFileContentException("Invalid Aircraft Info: longitude cannot less than 0");
		if (lat < 0)
			throw new InvalidFileContentException("Invalid Aircraft Info: latitude cannot less than 0");
		if (height < 0 || height > 100)
			throw new InvalidFileContentException("Invalid Aircraft Info: height need between 0 to 100");

		Coordinates c = Coordinates.setCoordinates(lon, lat, height);
		AircraftFactory.getInstance().newAircraft(info[0], info[1], c).registerTower(wTower);
	}

	public static int parseFile(String filename, WeatherTower wTower) throws IOException, InvalidFileContentException
	{
		FileReader freader = new FileReader(filename);
		BufferedReader breader = new BufferedReader(freader);
		String line;

		int runtime = Integer.parseInt(breader.readLine());
		if (runtime < 0)
		{
			breader.close();
			throw new InvalidFileContentException("Invalid simulation runtime");
		}

		while ((line = breader.readLine()) != null)
			parseAircraft(line, wTower);

		breader.close();
		return (runtime);
	}
}
