package me.userod.bookgui.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;

public class Color {
	
	public static List<String> translate(List<String> text) {
		List<String> resultSet = new ArrayList<String>();
		for(String textInMethod : text) {
			resultSet.add(ChatColor.translateAlternateColorCodes('&', textInMethod));
		}
		return resultSet;
	}

}