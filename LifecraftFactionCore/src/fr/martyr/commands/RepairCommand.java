package fr.martyr.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Repairable;

public class RepairCommand implements CommandExecutor {
	

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		Player p = (Player) arg0;
		if(!p.hasPermission("core.repair")) return true;
	ItemStack stack = p.getInventory().getItemInHand();
    if(stack instanceof Repairable) {
        stack.setDurability((short)0);
    }
	
	return true;
	}
}
