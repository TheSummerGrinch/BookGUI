package me.UseRod.BookGUI.Utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;

public class Color {
	
	public static List<String> translate(List<String> text) {
		List<String> ResultSet = new ArrayList<String>();
		for(String TextInMethod : text) {
			ResultSet.add(ChatColor.translateAlternateColorCodes('&', TextInMethod));
		}
		return ResultSet;
	}

}
