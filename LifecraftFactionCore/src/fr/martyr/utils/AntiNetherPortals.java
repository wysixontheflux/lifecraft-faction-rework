package fr.martyr.utils;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class AntiNetherPortals implements Listener {
	  
	  @EventHandler
	  public static void onPortalTravel(PlayerPortalEvent event) {
	    if (event.getCause() == PlayerTeleportEvent.TeleportCause.NETHER_PORTAL) {
	      event.setCancelled(true);
	    	}
	    
	  }
	  
}