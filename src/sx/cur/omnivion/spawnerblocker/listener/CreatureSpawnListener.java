package sx.cur.omnivion.spawnerblocker.listener;

import org.bukkit.event.Event;
import org.bukkit.event.EventException;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.EventExecutor;

public class CreatureSpawnListener implements Listener, EventExecutor {

	@Override
	public void execute(final Listener listener, final Event mevent) throws EventException
	{

		if (!(mevent instanceof CreatureSpawnEvent)) return;

		final CreatureSpawnEvent event = (CreatureSpawnEvent) mevent;

		switch (event.getSpawnReason())
		{
			case SPAWNER:
			case SPAWNER_EGG:
			case CUSTOM:
			case SLIME_SPLIT:
				break;

			default:
				event.setCancelled(true);
				break;
		}

	}


}