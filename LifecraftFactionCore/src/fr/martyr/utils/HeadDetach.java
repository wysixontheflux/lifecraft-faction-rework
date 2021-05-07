package fr.martyr.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class HeadDetach
  extends JavaPlugin
  implements Listener
{
  public void onEnable() {
    PluginManager manager = Bukkit.getPluginManager();
    manager.registerEvents(this, this);
  }


  
  public void onDisable() {}

  
  @EventHandler
  public void death(PlayerDeathEvent event) {
    Player killer = event.getEntity().getKiller();
    Player player = event.getEntity();
    
    if (killer instanceof Player && killer.hasPermission("oldfaction.head")) {
      ItemStack item = new ItemStack(Material.SKULL);
      SkullMeta sm = (SkullMeta)item.getItemMeta();
      sm.setOwner(player.getName());
      item.setItemMeta(sm);
      
      event.getDrops().add(item);
    } 
  }
}
