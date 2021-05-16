package me.userod.bookgui.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import me.UseRod.BookGUI.MainClass;

public class ConfigVariables {
	
	static Plugin bgPlugin = BookGUI.getPlugin(BookGUI.class);
	static FileConfiguration config = bgPlugin.getConfig();

	public static ConfigurationSection books = get("Books");
	public static List<String> bookSections = getSubSection(books);
	
	public static ConfigurationSection get(String sectionName) {
		ConfigurationSection gottenString;
		gottenString = config.getConfigurationSection(sectionName);
		return gottenString;
	}
	
	public static List<String> getSubSection(ConfigurationSection section) {
		List<String> subSections = new ArrayList<String>();
		for(String childSection : section.getKeys(true)) {
			subSections.add(childSection);
		}
		return subSections;
	}
}
