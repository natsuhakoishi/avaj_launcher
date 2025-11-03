package srcs.Flyable;

import srcs.Coordinates.*;

public class Baloon extends Aircraft
{
	public Baloon(long p_id, String p_name, Coordinates p_coordinates)
	{
		super(p_id, p_name, p_coordinates);
	}

	public void updateConditions()
	{
		int lon = this.coordinates.getLongitude();
		int lat = this.coordinates.getLatitute();
		int height = this.coordinates.getHeight();

		String weather = weatherTower.getWeather(this.coordinates);
		switch (weather)
		{
			case ("SUN"):
				lon += 2;
				height += 4;
				break ;
			case ("RAIN"):
				height -= 5;
				break ;
			case ("FOG"):
				height -= 3;
				break ;
			case ("SNOW"):
				height -= 15;
				break ;
		}
		if (height > 100)
			height = 100;
		if (height < 0)
		{
			//landing msg
			weatherTower.unregister(this);
			return ;
		}
		coordinates.setLongitude(lon);
		coordinates.setLatitute(lat);
		coordinates.setHeight(height);
	}
}
