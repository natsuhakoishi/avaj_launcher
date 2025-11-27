package com.github.natsuhakoishi.avajlauncher.Exception;

public class InvalidFileContentException extends Exception
{
	public InvalidFileContentException(String msg)
	{
		super("InvalidFileContentException: "+msg);
	}
}
