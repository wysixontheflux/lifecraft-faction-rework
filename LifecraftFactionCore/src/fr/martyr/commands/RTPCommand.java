package fr.martyr.commands;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class RTPCommand implements CommandExecutor{
	public static final long heure1 = 3600000;
	public static HashMap<UUID, Long> mem = new HashMap<UUID, Long>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
            Player player = (Player) sender;
            boolean goldBoolean = mem.containsKey(player.getUniqueId());
			
			if(!goldBoolean) {
				mem.put(player.getUniqueId(), (heure1 + System.currentTimeMillis()));
				run(player);
			}else if(goldBoolean){
				Long goldValue = mem.get(player.getUniqueId());
				if(goldValue != null) {
					if(goldValue < System.currentTimeMillis()) {
						mem.put(player.getUniqueId(), (heure1 + System.currentTimeMillis()));
						run(player);
					}else {
						player.sendMessage(ChatColor.GOLD + "Il te reste à attendre " + (System.currentTimeMillis() - goldValue) + " mls (milliseconde) !");
					}
				}
			}	
        }
		return true;
	}
	
	public void run(Player player) {
		player.sendMessage(ChatColor.GREEN + "RandomTP en cours...");
		player.teleport(getRandomLocation());
	}
	public static Location getRandomLocation() {
	    World world = Bukkit.getWorld("world");
	    Random rand = new Random();

	    int rangeMax = 9999;
	    int rangeMin = -9999;

	    int X = rand.nextInt((rangeMax - rangeMin) + 1) + rangeMin;
	    int Z = rand.nextInt((rangeMax - rangeMin) + 1) + rangeMin;
	    int Y = world.getHighestBlockYAt(X, Z);

	    return new Location(world, X, Y, Z).add(0.5, 0, 0.5);
	    }
	  }


