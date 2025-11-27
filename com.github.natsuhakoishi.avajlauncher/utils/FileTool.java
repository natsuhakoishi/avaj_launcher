package com.github.natsuhakoishi.avajlauncher.utils;

import java.io.*;

public class FileTool
{
	public static void overwrite()
	{
		try
		{
			FileWriter writer = new FileWriter("simulation.txt", false);
			writer.close();
		}
		catch (IOException error)
		{
			error.printStackTrace();
		}
	}

	public static void writeIn(String msg)
	{
		try
		{
			FileWriter writer = new FileWriter("simulation.txt", true);
			writer.write(msg);
			writer.close();
		}
		catch (IOException error)
		{
			error.printStackTrace();
		}
	}
}
