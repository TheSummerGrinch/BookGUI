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

        NBTTagCompound nbtTagCompound = new NBTTagCompound(); // Use descriptive variable and field names.
        nbtTagCompound.setString("title", title);
        nbtTagCompound.setString("author", author);

        NBTTagList nbtTagList = new NBTTagList();

        for(String text : pages) {
            nbtTagList.add(new NBTTagString(text));
        }

        nbtTagCompound.set("pages", nbtTagList);
        nmsItemStack.setTag(nbtTagCompound);

        itemStack = CraftItemStack.asBukkitCopy(nmsItemStack);
        return itemStack;
    }

}
