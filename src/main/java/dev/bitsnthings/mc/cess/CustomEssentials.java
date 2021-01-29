package dev.bitsnthings.mc.cess;

import dev.bitsnthings.mc.cess.events.*;
import dev.bitsnthings.mc.cess.commands.*;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;

import java.util.logging.Logger;

public class CustomEssentials extends JavaPlugin {
  private final Logger logger = Logger.getLogger("cEssentials");
  private static CustomEssentials plugin;
  private static Config config;
  @Override
  public void onEnable() {
    plugin = this;
    config = new Config();
    Bukkit.getPluginManager().registerEvents(new CommandPreprocessEvent(), this);
    Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
    this.getCommand("cess").setExecutor(new CessCommand());
    this.getCommand("mute").setExecutor(new MuteCommand());
  }
  @Override
  public void onDisable() {

  }

  public Logger getLogger() {
		return logger;
	}
	public static CustomEssentials getInstance() {
		return plugin;
	}
}
