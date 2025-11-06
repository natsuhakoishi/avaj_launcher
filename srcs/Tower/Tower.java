package srcs.Tower;

import srcs.Flyable.*;
import java.util.*;

public class Tower
{
	private List<Flyable> observers = new ArrayList<>();

	public void register(Flyable p_flyable)
	{
		this.observers.add(p_flyable);
	}

	public void unregister(Flyable p_flybale)
	{
		this.observers.remove(p_flybale);
	}

	public int getObserversSize()
	{
		return (this.observers.size());
	}

	protected void conditionChanged()
	{
		List<Flyable> clone = new ArrayList<>(observers);

		for (Flyable f : clone)
			f.updateConditions();
	}
}
