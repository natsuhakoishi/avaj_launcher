package srcs.Flyable;

import srcs.Coordinates.*;

public class JetPlane extends Aircraft
{
	public JetPlane(long p_id, String p_name, Coordinates p_coordinates)
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
				lat += 10;
				height += 2;
				break ;
			case ("RAIN"):
				lat += 5;
				break ;
			case ("FOG"):
				lat += 1;
				break ;
			case ("SNOW"):
				height -= 7;
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
