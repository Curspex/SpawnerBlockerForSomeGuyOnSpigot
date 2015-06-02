package sx.cur.omnivion.spawnerblocker;

import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import sx.cur.omnivion.spawnerblocker.listener.BlockPlaceListener;
import sx.cur.omnivion.spawnerblocker.listener.CreatureSpawnListener;

public class SpawnerBlocker extends JavaPlugin {

	static SpawnerBlocker i;
	
	@Override
	public void onEnable()
	{
		i = this;
		final PluginManager manager = i.getServer().getPluginManager();
		
		BlockPlaceListener blockplacelistener = new BlockPlaceListener();
		manager.registerEvent(BlockPlaceEvent.class, blockplacelistener, EventPriority.HIGH, blockplacelistener, i, true);
		
		CreatureSpawnListener entityspawnlistener = new CreatureSpawnListener();
		manager.registerEvent(CreatureSpawnEvent.class, entityspawnlistener, EventPriority.HIGH, entityspawnlistener, i, true);
	}
	
}