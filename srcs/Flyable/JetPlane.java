package srcs.Flyable;

import srcs.Coordinates.*;
import srcs.utils.FileTool;

public class JetPlane extends Aircraft
{
	public JetPlane(long p_id, String p_name, Coordinates p_coordinates)
	{
		super(p_id, p_name, p_coordinates);
	}

	@Override
	public void updateConditions()
	{
		int lon = this.coordinates.getLongitude();
		int lat = this.coordinates.getLatitute();
		int height = this.coordinates.getHeight();

		String info = "JetPlane#" + this.name + "(" + this.id + "): ";
		String weather = this.weatherTower.getWeather(this.coordinates);
		switch (weather)
		{
			case ("SUN"):
				lat += 10;
				height += 2;
				FileTool.writeIn(info+"Sunny conditions optimal. Maintaining cruise speed.\n");
				break ;

			case ("RAIN"):
				lat += 5;
				FileTool.writeIn(info+"Rainfall reported. Activating anti-skid and reducing speed.\n");
				break ;

			case ("FOG"):
				lat += 1;
				FileTool.writeIn(info+"Fog detected. Relying on instruments for navigation.\n");
				break ;

			case ("SNOW"):
				height -= 7;
				FileTool.writeIn(info+"Snow detected. Activating de-icing protocols.\n");
				break ;
		}
		if (height > 100)
			height = 100;
		if (height < 0)
		{
			String info2 = "JetPlane#" + this.name + "(" + this.id + ") ";
			FileTool.writeIn(info2+"landing.\n");
			this.weatherTower.unregister(this);
			return ;
		}
		this.coordinates.setLongitude(lon);
		this.coordinates.setLatitute(lat);
		this.coordinates.setHeight(height);
	}
}
