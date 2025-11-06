package srcs.Flyable;

import srcs.Coordinates.*;
import srcs.utils.FileTool;

public class Helicopter extends Aircraft
{
	public Helicopter(long p_id, String p_name, Coordinates p_coordinates)
	{
		super(p_id, p_name, p_coordinates);
	}

	@Override
	public void updateConditions()
	{
		int lon = this.coordinates.getLongitude();
		int lat = this.coordinates.getLatitute();
		int height = this.coordinates.getHeight();

		String info = "Helicopter#" + this.name + "(" + this.id + "): ";
		String weather = this.weatherTower.getWeather(this.coordinates);
		switch (weather)
		{
			case ("SUN"):
				lon += 10;
				height += 2;
				FileTool.writeIn(info+"Sunlight visibility confirmed. Stabilizing altitude.\n");
				break ;

			case ("RAIN"):
				lon += 5;
				FileTool.writeIn(info+"Precipitation encountered. Descending cautiously.\n");
				break ;

			case ("FOG"):
				lon += 1;
				FileTool.writeIn(info+"Visibility limited by fog. Maintaining hover safety.\n");
				break ;

			case ("SNOW"):
				height -= 12;
				FileTool.writeIn(info+"Heavy snow encountered. Reducing altitude immediately.\n");
				break ;
		}
		if (height > 100)
			height = 100;
		if (height < 0)
		{
			String info2 = "Helicopter#" + this.name + "(" + this.id + ") ";
			FileTool.writeIn(info2+"landing.\n");
			this.weatherTower.unregister(this);
			return ;
		}
		this.coordinates.setLongitude(lon);
		this.coordinates.setLatitute(lat);
		this.coordinates.setHeight(height);
	}
}
