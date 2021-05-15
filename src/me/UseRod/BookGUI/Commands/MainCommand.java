package me.UseRod.BookGUI.Commands;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.UseRod.BookGUI.MainClass;
import me.UseRod.BookGUI.Utils.BookFactory;
import me.UseRod.BookGUI.Utils.Color;
import me.UseRod.BookGUI.Utils.ConfigVariables;

public class MainCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		if(!(arg0 instanceof Player));
		else {
			if(arg3.length == 0) arg0.sendMessage(ChatColor.RED + "Please Type The GUI Name!");
			else {
				if(!(ConfigVariables.BookSections.contains(arg3[0])));
				else {
					for(String BookName : ConfigVariables.BookSections) {
						if(arg3[0].equalsIgnoreCase(BookName)) {
							String title = "Books." + BookName + ".title";
							List<String> Pages = Color.translate(getStringList("Books." + BookName + ".pages"));
							ItemStack Book = BookFactory.book(title, arg0.getName(), Pages);
							me.UseRod.BookGUI.Utils.Book.Open(Book, (Player) arg0);
						}
					}
				}
			}
		}
 		return false;
	}
	
	public String getString(String Section) {
		FileConfiguration config = MainClass.getPlugin(MainClass.class).getConfig();
		return config.getString(Section);
	}
	
	public List<String> getStringList(String Section) {
		FileConfiguration config = MainClass.getPlugin(MainClass.class).getConfig();
		return config.getStringList(Section);
	}
}
