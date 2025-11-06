package srcs.Exception;

public class InvalidFileContentException extends Exception
{
	public InvalidFileContentException(String msg)
	{
		super("InvalidFileContentException: "+msg);
	}
}
