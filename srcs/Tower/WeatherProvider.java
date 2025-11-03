package srcs.Tower;

import srcs.Coordinates.Coordinates;

public class WeatherProvider
{
	private final String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};
	private int gacha;
	private static final WeatherProvider wp = new WeatherProvider();

	private WeatherProvider()
	{
		this.gacha = (int)((Math.random() * 42)) + (int)((Math.random() * 100));
	}

	public String getCurrentWeather(Coordinates p_coordinates)
	{
		String gachaWeather = this.weather[(p_coordinates.getLongitude() + p_coordinates.getLatitute()
								+ p_coordinates.getHeight() + this.gacha) % 4];
		return (gachaWeather);
	}

	public static WeatherProvider getInstance()
	{
		return (wp);
	}
}
