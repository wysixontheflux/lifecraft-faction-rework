package fr.martyr;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

import fr.martyr.commands.BoutiqueCommand;
import fr.martyr.commands.DiscordCommand;
import fr.martyr.commands.FurnaceCommand;
import fr.martyr.commands.RTPCommand;
import fr.martyr.commands.RepairCommand;
import fr.martyr.commands.VoteCommand;
import fr.martyr.listeners.RankChestListener;
import fr.martyr.listeners.XPBoostListener;
import fr.martyr.utils.DeathListener;

public class LifecraftFactionCore extends JavaPlugin {
	public static LifecraftFactionCore instance;
	
	@Override
	public void onEnable() {
		LifecraftFactionCore.instance = this;
		getDataFolder().mkdirs();
		
		final File chestsFolder = new File (getDataFolder(),"chests/");
		chestsFolder.mkdirs();
		
		getServer().getPluginManager().registerEvents(new XPBoostListener(), this);
		getServer().getPluginCommand("rtp").setExecutor(new RTPCommand());
		getServer().getPluginManager().registerEvents(new RankChestListener(), this);
		getServer().getPluginCommand("discord").setExecutor(new DiscordCommand());
		getServer().getPluginCommand("boutique").setExecutor(new BoutiqueCommand());
		getServer().getPluginCommand("vote").setExecutor(new VoteCommand());
		getServer().getPluginCommand("repair").setExecutor(new RepairCommand());
		getServer().getPluginCommand("furnace").setExecutor(new FurnaceCommand());
		getServer().getPluginManager().registerEvents(new DeathListener(this), this);
	}
	
	
}
