package fr.martyr.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BoutiqueCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		      arg0.sendMessage("§eVoici notre boutique: §b§lsiteblabla");
		      return true;
		
		
		}	
	}
