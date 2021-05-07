package fr.martyr.listeners;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

public class XPBoostListener  implements Listener {



	  
	  

	  
	  @EventHandler
	  public void death(EntityDeathEvent event) {
	    Player killer = event.getEntity().getKiller();
	    int xp = event.getDroppedExp();
	    
	    if (killer instanceof Player && killer.hasPermission("xpboost.lieutenant")) {
	          PacketPlayOutChat packet = new PacketPlayOutChat(ChatSerializer.a("{\"text\":\"" + "&eGrade Lieutenant: +25% d'XP" + "\"}"), (byte) 2);
	          ((CraftPlayer)killer).getHandle().playerConnection.sendPacket(packet);
	      event.setDroppedExp(addXP(25, xp));
	    } else if (killer instanceof Player && killer.hasPermission("xpboost.capitaine")) {
	    	PacketPlayOutChat packet = new PacketPlayOutChat(ChatSerializer.a("{\"text\":\"" + "&6Grade Capitaine: +60% d'XP" + "\"}"), (byte) 2);
	        ((CraftPlayer)killer).getHandle().playerConnection.sendPacket(packet);
	      event.setDroppedExp(addXP(60, xp));
	    } else if (killer instanceof Player && killer.hasPermission("xpboost.colonel")) {
	    	PacketPlayOutChat packet = new PacketPlayOutChat(ChatSerializer.a("{\"text\":\"" + "&aGrade Colonel: +90% d'XP" + "\"}"), (byte) 2);
	        ((CraftPlayer)killer).getHandle().playerConnection.sendPacket(packet);
	      event.setDroppedExp(addXP(90, xp));
	    } else if (killer instanceof Player && killer.hasPermission("xpboost.gardien")) {
	    	PacketPlayOutChat packet = new PacketPlayOutChat(ChatSerializer.a("{\"text\":\"" + "&3Grade Gardien: +130% d'XP" + "\"}"), (byte) 2);
	        ((CraftPlayer)killer).getHandle().playerConnection.sendPacket(packet);
	      event.setDroppedExp(addXP(130, xp));
	    } else if (killer instanceof Player && killer.hasPermission("xpboost.heros")) {
	    	PacketPlayOutChat packet = new PacketPlayOutChat(ChatSerializer.a("{\"text\":\"" + "&bGrade Héros: +175% d'XP" + "\"}"), (byte) 2);
	        ((CraftPlayer)killer).getHandle().playerConnection.sendPacket(packet);
	      event.setDroppedExp(addXP(175, xp));
	    } else if (killer instanceof Player && killer.hasPermission("xpboost.legende")) {
	    	PacketPlayOutChat packet = new PacketPlayOutChat(ChatSerializer.a("{\"text\":\"" + "&9Grade Légende: +250% d'XP" + "\"}"), (byte) 2);
	        ((CraftPlayer)killer).getHandle().playerConnection.sendPacket(packet);
	      event.setDroppedExp(addXP(250, xp));
	    } 
	  }

	  
	  
	  public int addXP(int pourcent, int xp) { return xp + xp * pourcent / 100; }
	}

	

	
	
	
	

