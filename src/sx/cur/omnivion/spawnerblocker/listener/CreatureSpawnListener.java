package sx.cur.omnivion.spawnerblocker.listener;

import org.bukkit.event.Event;
import org.bukkit.event.EventException;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.plugin.EventExecutor;

public class CreatureSpawnListener  implements Listener, EventExecutor {

	@Override
	public void execute(Listener listener, Event mevent) throws EventException
	{
		if (!(mevent instanceof CreatureSpawnEvent)) return;
		
		CreatureSpawnEvent event = (CreatureSpawnEvent) mevent;
		
		if (!event.getSpawnReason().equals(SpawnReason.SPAWNER)) event.setCancelled(true);
	}


}