package com.github.natsuhakoishi.avaj_launcher.Exception;

public class InvalidFileContentException extends Exception
{
	public InvalidFileContentException(String msg)
	{
		super("InvalidFileContentException: "+msg);
	}
}
