package me.userod.bookgui; // Package-names use lowercase

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.userod.bookgui.commands.MainCommand;
import me.userod.bookgui.utils.ConfigVariables;


public class BookGUI extends JavaPlugin {
	
	private FileConfiguration config;
	private Logger logger;
	private PluginManager pluginManager; // Names of fields and variables use camelCase.
	private List<Listener> listeners;
	private HashMap<String, CommandExecutor> commands;
	
	public void onEnable() {
		
		this.saveDefaultConfig();
		this.config = this.getConfig();
		this.logger = this.getLogger();
		this.pluginManager = Bukkit.getPluginManager();
		this.listeners = new ArrayList<Listener>();
		this.commands = new HashMap<String, CommandExecutor>(); // Probably a bit much. But I assume you plan on extending this.
		this.prepareCommands();
		
		this.logInfo("Loading Books..."); // Not everything needs to be logged.
		
		this.commands.forEach((name, commandExecutor) -> {
			getCommand(name).setExecutor(commandExecutor);
		});
		
		if(this.isEnabled()) {
			this.logInfo("Loaded " + ConfigVariables.bookSections.size() / 3 + " Books..."); // What is this? Some kind of black magic? Why the static abuse?
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
