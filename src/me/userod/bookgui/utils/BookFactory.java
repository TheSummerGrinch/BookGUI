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
        ItemStack itemStack = new ItemStack(Material.WRITTEN_BOOK, 1);
        net.minecraft.server.v1_8_R3.ItemStack nmsItemStack = CraftItemStack.asNMSCopy(itemStack);

        NBTTagCompound bookMetaData = new NBTTagCompound();
        bookMetaData.setString("title", title);
        bookMetaData.setString("author", author);

        NBTTagList bookPageData = new NBTTagList();
        for(String text : pages) {
            bookPageData.add(new NBTTagString(text));
        }

        bookMetaData.set("pages", bookPageData);
        nmsItemStack.setTag(bookMetaData);

        itemStack = CraftItemStack.asBukkitCopy(nmsItemStack);
        return itemStack;
    }

}