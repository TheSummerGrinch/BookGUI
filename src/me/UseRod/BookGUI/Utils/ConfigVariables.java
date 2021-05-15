package me.UseRod.BookGUI.Utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import me.UseRod.BookGUI.MainClass;

public class ConfigVariables {
	
	static Plugin instance = MainClass.getPlugin(MainClass.class);
	static FileConfiguration config = instance.getConfig();

	
	public static ConfigurationSection Books = get("Books");
	public static List<String> BookSections = getSubSection(Books);
	
	
	
	
	public static ConfigurationSection get(String sectionName) {
		ConfigurationSection gottenString;
		gottenString = config.getConfigurationSection(sectionName);
		return gottenString;
	}
	
	public static List<String> getSubSection(ConfigurationSection sec) {
		List<String> SubSections = new ArrayList<String>();
		for(String childSec : sec.getKeys(true)) {
			SubSections.add(childSec);
		}
		return SubSections;
	}
	

}
