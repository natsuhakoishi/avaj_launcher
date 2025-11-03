package srcs.Flyable;

import srcs.Coordinates.*;

public class AircraftFactory
{
	private static final AircraftFactory af = new AircraftFactory();
	private static int id_counter;

	private AircraftFactory() {}

	public static AircraftFactory getInstance()
	{
		return (af);
	}

	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates)
	{
		switch (p_type)
		{
			case ("Helicopter"):
				return new Helicopter(id_counter++, p_name, p_coordinates);
			case ("JetPlane"):
				return new JetPlane(id_counter++, p_name, p_coordinates);
			case ("Baloon"):
				return new Baloon(id_counter++, p_name, p_coordinates);
			default:
				//throw error
		}
	}
}
