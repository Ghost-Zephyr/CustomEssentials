package dev.bitsnthings.mc.cess;

import dev.bitsnthings.mc.cess.commands;

import org.bukkit.plugin.java.JavaPlugin;

public class CustomEssentials extends JavaPlugin {
  @Override
  public void onEnable() {
    this.getCommand("cess").setExecutor(new CessCommand());
    this.getCommand("mute").setExecutor(new MuteCommand());
  }
  @Override
  public void onDisable() {

  }
}

