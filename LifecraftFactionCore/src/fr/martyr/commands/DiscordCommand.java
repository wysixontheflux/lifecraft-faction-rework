package fr.martyr.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DiscordCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		      arg0.sendMessage("�eVoici notre discord: �b�lhttps://discord.gg/blabla");
		      return true;
		
		
		}	
	}
