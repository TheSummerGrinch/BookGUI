package me.UseRod.BookGUI;

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

import me.UseRod.BookGUI.Commands.MainCommand;
import me.UseRod.BookGUI.Utils.ConfigVariables;


public class MainClass extends JavaPlugin{
	Plugin instance = this;
	FileConfiguration config = instance.getConfig();
	Logger logger = instance.getLogger();
	PluginManager PluginManager = Bukkit.getPluginManager();
	List<Listener> Listeners = new ArrayList<Listener>();
	HashMap<String, CommandExecutor> Commands = new HashMap<String, CommandExecutor>();
	
	public void onEnable() {
		log("Loading Books...");
		for(String CommandName : Commands().keySet()) {
			getCommand(CommandName).setExecutor(Commands().get(CommandName));
		}
		if(instance.isEnabled()) {
			log("Loaded " + ConfigVariables.BookSections.size() / 3 + " Books...");
		}else log("Plugin Has Been Disabled Due To Some Issues Acquired It While Loading!");
		createConfig();
	}
	
	public void log(String Message) {
		logger.info(Message);
	}
	
	public void addListener(Listener listenerClass) {
		Listeners.add(listenerClass);
	}
	
	public HashMap<String, CommandExecutor> Commands() {
		
		registerCommand("BookGUI", new MainCommand());
		
		return Commands;
	}
	
	public void registerCommand(String commandName, CommandExecutor Executor) {
		if(!Commands.containsKey(commandName)) {
			Commands.put(commandName, Executor);
		}
	}
	private void createConfig() {
        try {
            if (!getDataFolder().exists()) {
                getDataFolder().mkdirs();
            }
            File file = new File(getDataFolder(), "config.yml");
            if (!file.exists()) {
                saveDefaultConfig();
    		}
        } catch (Exception e) {
            log("PROBLEM:");
            e.printStackTrace();

        }

    }
}
