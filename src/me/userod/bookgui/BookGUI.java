package me.userod.bookgui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.userod.bookgui.commands.MainCommand;
import me.userod.bookgui.utils.ConfigVariables;


public class BookGUI extends JavaPlugin {
	
	Logger logger;
	PluginManager pluginManager;
	private List<Listener> listeners;
	private HashMap<String, CommandExecutor> commands;
	
	public void onEnable() {
		
		this.saveDefaultConfig();
		logger = this.getLogger();
		pluginManager = Bukkit.getPluginManager();
		listeners = new ArrayList<Listener>();
		commands = new HashMap<String, CommandExecutor>();
		prepareCommands();
		
		this.logInfo("Loading Books...");
		
		this.commands.forEach((name, commandExecutor) -> {
			getCommand(name).setExecutor(commandExecutor);
		}); // i don't know what's the difference.
		
		if(this.isEnabled()) {
			this.logInfo("Loaded " + ConfigVariables.bookSections.size() / 3 + " Books...");
		}
	}
	
	public void logInfo(String Message) {
		this.logger.info(Message); // Logging everything as INFO is sloppy.
	}
	
	public void addListener(Listener listenerClass) {
		this.listeners.add(listenerClass);
	}
	
	public void prepareCommands() {
		this.commands.put("BookGUI", new MainCommand());
	}
}