package sx.cur.omnivion.spawnerblocker.listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World.Environment;
import org.bukkit.event.Event;
import org.bukkit.event.EventException;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.EventExecutor;

public class BlockPlaceListener implements Listener, EventExecutor {

	@Override
	public void execute(Listener listener, Event mevent) throws EventException
	{

		if (!(mevent instanceof BlockPlaceEvent)) return;
		
		BlockPlaceEvent event = (BlockPlaceEvent) mevent;
		
		if (!event.getBlock().getType().equals(Material.MOB_SPAWNER)) return;
		
		if (!event.getBlock().getWorld().getEnvironment().equals(Environment.NETHER)) return;
		
		if (event.getPlayer().hasPermission("spawnerblocker.allow")) return;
		
		event.setCancelled(true);
		event.getPlayer().sendMessage(ChatColor.RED + "You don't have permission to place that here!");

	}

}