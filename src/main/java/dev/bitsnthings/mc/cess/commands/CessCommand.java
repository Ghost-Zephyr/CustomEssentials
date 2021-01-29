package dev.bitsnthings.mc.cess.commands;

import org.bukkit.command.*;
import org.bukkit.ChatColor;

public class CessCommand implements CommandExecutor {
  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    // TODO: implement /cess set motd
    sender.sendMessage(ChatColor.RED+"This here command ain't implemented yet!");
    return true;
  }
}
