package fr.martyr.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class FurnaceCommand implements CommandExecutor {

  public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
    if (cmd.getName().equals("furnace")) {
      if (sender instanceof Player) {
        Player player = (Player)sender;
        ItemStack item = player.getItemInHand();
        String bitem = item.getType().toString().toLowerCase();
        int amount = 0;
        String name = "";
        switch ($SWITCH_TABLE$org$bukkit$Material()[item.getType().ordinal()]) {
          case 16:
            item.setType(Material.IRON_INGOT);
            amount = item.getAmount();
            name = item.getType().toString();
            break;
          
          case 5:
            item.setType(Material.STONE);
            amount = item.getAmount();
            name = item.getType().toString();
            break;
          
          case 15:
            item.setType(Material.GOLD_INGOT);
            amount = item.getAmount();
            name = item.getType().toString();
            break;
        } 


        
        if (amount > 0)
        { player.sendMessage("§eTu as cuit" + amount + " " + bitem + "§e §6 +" + amount + " " + name.toLowerCase() + "§e."); }
        else { player.sendMessage("§cTu ne peux pas cuire cet objet"); }
      
      } 
      return true;
    } 
    return false;
  }
private int[] $SWITCH_TABLE$org$bukkit$Material() {
	return null;
}
}
