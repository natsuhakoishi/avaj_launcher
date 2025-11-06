package srcs.Flyable;

import srcs.Coordinates.*;
import srcs.utils.FileTool;

public class Baloon extends Aircraft
{
	public Baloon(long p_id, String p_name, Coordinates p_coordinates)
	{
		super(p_id, p_name, p_coordinates);
	}

	@Override
	public void updateConditions()
	{
		int lon = this.coordinates.getLongitude();
		int lat = this.coordinates.getLatitute();
		int height = this.coordinates.getHeight();

		String info = "Baloon#" + this.name + "(" + this.id + "): ";
		String weather = this.weatherTower.getWeather(this.coordinates);
		switch (weather)
		{
			case ("SUN"):
				lon += 2;
				height += 4;
				FileTool.writeIn(info+"Clear skies ahead. Gaining altitude.\n");
				break ;

			case ("RAIN"):
				height -= 5;
				FileTool.writeIn(info+"Rain detected. Adjusting altitude to maintain stability.\n");
				break ;

			case ("FOG"):
				height -= 3;
				FileTool.writeIn(info+"Fog reducing visibility. Ascend cautiously.\n");
				break ;

			case ("SNOW"):
				height -= 15;
				FileTool.writeIn(info+"Snowfall reducing lift. Descending for safety.\n");
				break ;
		}
		if (height > 100)
			height = 100;
		if (height < 0)
		{
			String info2 = "Baloon#" + this.name + "(" + this.id + ") ";
			FileTool.writeIn(info2+"landing.\n");
			this.weatherTower.unregister(this);
			return ;
		}
		this.coordinates.setLongitude(lon);
		this.coordinates.setLatitute(lat);
		this.coordinates.setHeight(height);
	}
}
