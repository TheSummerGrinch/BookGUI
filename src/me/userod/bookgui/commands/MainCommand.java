package me.userod.bookgui.commands;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.userod.bookgui.BookGUI;
import me.userod.bookgui.utils.BookFactory;
import me.userod.bookgui.utils.Color;
import me.userod.bookgui.utils.ConfigVariables;

public class MainCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (sender instanceof Player && args.length > 0) {
			if(ConfigVariables.bookSections.contains(args[0])) {
				for (String bookName : ConfigVariables.bookSections) {
                                        if(args[0].equalsIgnoreCase(BookName)) {
					        String title = "Books." + bookName + ".title";
					        List<String> pages = Color.translate(getStringList("Books." + bookName + ".pages"));
					        ItemStack book = BookFactory.create(title, sender.getName(), pages);
					        me.userod.bookgui.utils.Book.open(book, (Player) sender);
				        }
                                }
				return true;
			}
		}
		return false;
	}
	
	public String getString(String section) {
		FileConfiguration config = BookGUI.getPlugin(BookGUI.class).getConfig();
		return config.getString(section);
	}
	
	public List<String> getStringList(String section) {
		FileConfiguration config = BookGUI.getPlugin(BookGUI.class).getConfig();
		return config.getStringList(section);
	}
}
