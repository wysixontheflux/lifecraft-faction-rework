package fr.martyr.listeners;

import java.util.HashMap;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class PearlListener
  implements Listener
{
  public HashMap<String, Long> cooldown = new HashMap<String, Long>();
  
  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent e) {
    Player p = e.getPlayer();
    this.cooldown.put(p.getName(), Long.valueOf(0L));
  }
  
  @EventHandler
  public void onPlayerDeath(PlayerDeathEvent e) {
    Player p = e.getEntity().getPlayer();
    this.cooldown.put(p.getName(), Long.valueOf(0L));
  }
  
  @EventHandler
  public void onInteract(PlayerInteractEvent e) {
    Player player = e.getPlayer();
    ItemStack it = player.getItemInHand();
    if (it != null && it.getType().equals(Material.ENDER_PEARL) && (
      e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK))) {
      int cooldownTime = 10;
      if (this.cooldown.containsKey(player.getName())) {
        long secondsLeft = ((Long)this.cooldown.get(player.getName())).longValue() / 1000L + cooldownTime - System.currentTimeMillis() / 1000L;
        if (secondsLeft > 0L) {
          e.setCancelled(true);
          player.sendMessage("§cVous devez patienter encore " + secondsLeft + " secondes avant d'utiliser une enderpearl.");
        } else {
          this.cooldown.put(player.getName(), Long.valueOf(System.currentTimeMillis()));
        } 
      } 
    } 
  }
}
