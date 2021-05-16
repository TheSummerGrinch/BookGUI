package me.userod.bookgui;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.userod.bookgui.commands.MainCommand;
import me.userod.bookgui.utils.ConfigVariables;


public class BookGUI extends JavaPlugin {
	
	private FileConfiguration config;
	private Logger logger;
	private PluginManager pluginManager;
	private List<Listener> listeners;
	private HashMap<String, CommandExecutor> commands;
	
	public void onEnable() {
		
		this.saveDefaultConfig();
		this.config = this.getConfig();
		this.logger = this.getLogger();
		this.pluginManager = Bukkit.getPluginManager();
		this.listeners = new ArrayList<Listener>();
		this.commands = new HashMap<String, CommandExecutor>();
		this.prepareCommands();
		
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
