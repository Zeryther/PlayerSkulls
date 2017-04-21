package com.zeryther.playerskulls;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by zeryt on 21.04.2017.
 */
public class PlayerSkulls extends JavaPlugin implements CommandExecutor {
    public void onEnable(){
        getCommand("skull").setExecutor(this);
    }

    public void onDisable(){

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("skull")){
            if(sender instanceof Player){
                Player p = (Player)sender;

                if(args.length == 1){
                    String name = args[0];

                    ItemStack i = new ItemStack(Material.SKULL_ITEM);
                    i.setDurability((short)3);
                    SkullMeta iM = (SkullMeta)i.getItemMeta();
                    iM.setOwner(name);
                    i.setItemMeta(iM);

                    p.getInventory().addItem(i);
                    sender.sendMessage(ChatColor.GREEN + "There you go!");
                } else {
                    sender.sendMessage(ChatColor.RED + "/" + label + " <name>");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "You must be a player in order to execute this command!");
            }
        }

        //return super.onCommand(sender, command, label, args);
        return true;
    }
}
