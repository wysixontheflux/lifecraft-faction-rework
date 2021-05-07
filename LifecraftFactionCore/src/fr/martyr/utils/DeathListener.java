package fr.martyr.utils;


import fr.martyr.LifecraftFactionCore;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener
  implements Listener
{
  private LifecraftFactionCore grabugesDeath;
  
  public DeathListener(LifecraftFactionCore grabugesDeath) { this.grabugesDeath = grabugesDeath; }


  
  @EventHandler
  public void onDeath(PlayerDeathEvent event) {
    Player victim = event.getEntity();
    
    if (victim.getKiller() == null || victim.getKiller().getType() != EntityType.PLAYER) {
      event.setDeathMessage(this.grabugesDeath.getConfig().getString("death-messages.nobody").replace("{victim}", victim.getName()).replace("&", "§"));
      
      return;
    } 
    Player attacker = event.getEntity().getKiller();
    
    event.setDeathMessage(this.grabugesDeath.getConfig().getString("death-messages.by-player").replace("{victim}", victim.getName()).replace("&", "§").replace("{attacker}", attacker.getName()).replace("&", "§"));
  }
}

