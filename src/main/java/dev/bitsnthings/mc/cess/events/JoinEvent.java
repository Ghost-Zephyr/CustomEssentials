package dev.bitsnthings.mc.cess.events;

import dev.bitsnthings.mc.cess.Config;

import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

public class JoinEvent implements Listener {
	@EventHandler(priority=EventPriority.NORMAL)
	public void onPlayerJoin(PlayerJoinEvent event) {
    Player player = event.getPlayer();
    event.setJoinMessage​(String.format("%s%s joined.", ChatColor.GRAY, player.getName()));
    player.sendMessage(Config.messageOfTheDay);
  }
}
