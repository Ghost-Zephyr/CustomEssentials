package dev.bitsnthings.mc.cess.events;

import dev.bitsnthings.mc.cess.CustomEssentials;

import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandPreprocessEvent implements Listener {
	@EventHandler(priority=EventPriority.NORMAL)
	public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
    /* Get objects and string nedded for later. */
    Player sender = event.getPlayer();
    String message = event.getMessage();
    String command = message.split(" ")[0];
    /* Make sure players don't have access to tellraw. */
    if (command.equals("/tellraw")) {
      event.setCancelled(true);
      sender.sendMessage(String.format("%sYou're not allowed to use this command!", ChatColor.RED));
      return;
    }
    /* While still using tellraw to format /msg as we want. */
    if (Arrays.asList(new String[]{"/w","/msg","/tell"}).contains(command)) {
      List<String> args = new ArrayList<String>();
      String recipient = "";
      int iterations = 0;
      for (String arg: message.split(" ")) {
        switch (iterations) {
          case 0:
            break;
          case 1:
            recipient = arg;
            break;
          default:
          args.add(arg);
            break;
        }
        iterations = iterations + 1;
      }
      message = String.join(" ", args);
      sender.sendMessage(String.format("%sYou told %s: %s", ChatColor.LIGHT_PURPLE, recipient, message));
      event.setMessage(String.format(CustomEssentials.config.msgCmdFormat, recipient, ChatColor.LIGHT_PURPLE, event.getPlayer().getName(), message));
    }
  }
}
