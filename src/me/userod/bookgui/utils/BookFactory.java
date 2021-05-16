package me.userod.bookgui.utils;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.NBTTagList;
import net.minecraft.server.v1_8_R3.NBTTagString;

public class BookFactory {
	
	public static ItemStack create(String title, String author, List<String> pages) {
        ItemStack is = new ItemStack(Material.WRITTEN_BOOK, 1);
        net.minecraft.server.v1_8_R3.ItemStack nmsis = CraftItemStack.asNMSCopy(is);
        NBTTagCompound bd = new NBTTagCompound();
        bd.setString("title", title);
        bd.setString("author", author);
        NBTTagList bp = new NBTTagList();
        for(String text : pages) {
            bp.add(new NBTTagString(text));
        }
        bd.set("pages", bp);
        nmsis.setTag(bd);
        
        is = CraftItemStack.asBukkitCopy(nmsis);
        return is;
    }

}