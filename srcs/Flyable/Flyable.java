package srcs.Flyable;

import srcs.Tower.*;

public abstract class Flyable
{
	protected WeatherTower weatherTower;

	public abstract void updateConditions();

	public void registerTower(WeatherTower p_tower)
	{
		this.weatherTower = p_tower;
		this.weatherTower.register(this);
	}
}
