package com.github.natsuhakoishi.avaj_launcher.Coordinates;

public class Coordinates
{
	private int longitude, latitute, height;

	Coordinates(int p_longitude, int p_latitude, int height)
	{
		this.longitude = p_longitude;
		this.latitute = p_latitude;
		this.height = height;
	}

	public static Coordinates setCoordinates(int lon, int lat, int height)
	{
		return new Coordinates(lon, lat, height);
	}

	public int getLongitude()
	{
		return (this.longitude);
	}

	public int getLatitute()
	{
		return (this.latitute);
	}

	public int getHeight()
	{
		return (this.height);
	}

	public void setLongitude(int lon)
	{
		this.longitude = lon;
	}

	public void setLatitute(int lat)
	{
		this.latitute = lat;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}
}
