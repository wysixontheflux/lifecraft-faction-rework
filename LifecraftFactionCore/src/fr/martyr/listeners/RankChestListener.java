package fr.martyr.listeners;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.google.common.io.Files;
import com.google.gson.Gson;

import fr.martyr.LifecraftFactionCore;

public class RankChestListener implements Listener { 
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		final Player player = event.getPlayer();
		
		if (event.getAction()==Action.LEFT_CLICK_BLOCK) {
			final Block block = event.getClickedBlock();
			if (block.getLocation().getBlockX() == 42 && block.getLocation().getBlockY() == 42 && block.getLocation().getBlockZ() == 42 && player.hasPermission("chest.lieutenant")) {
				event.setCancelled(true);
				final Inventory inventory = Bukkit.createInventory(null, 27);
				final File file = new File(LifecraftFactionCore.instance.getDataFolder(),player.getName()+".chestbank");
				if (file.exists()) {
					try {
						final String fileContent = Files.readFirstLine(file, Charset.defaultCharset());
						final ItemStack[]items=new Gson().fromJson(fileContent, ItemStack[].class);
						inventory.addItem(items);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				player.openInventory(inventory);
				
			}
				
		
		
		}

	}

	
	@EventHandler
	public void onPlayerCloseInventory(InventoryCloseEvent event) {
		final Player player = (Player) event.getPlayer();
		final File file = new File(LifecraftFactionCore.instance.getDataFolder(),player.getName()+".chestbank");
		final Inventory inventory = event.getInventory();
		
		final ItemStack[]items = inventory.getContents();
		try {
			final FileWriter fw = new FileWriter(file);
			fw.write(new Gson().toJson(items));
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	
	}
}
