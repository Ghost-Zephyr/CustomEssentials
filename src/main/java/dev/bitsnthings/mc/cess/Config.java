package dev.bitsnthings.mc.cess;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.ChatColor;

public final class Config {
  private static FileConfiguration config;
	private static final String MOTD_KEY = "motd";

  public static String messageOfTheDay;
	public Config() {
    config = CustomEssentials.getInstance().getConfig();
		setDefaults();
		loadConfig();
	}

  public void loadConfig(){
		messageOfTheDay = config.getString(MOTD_KEY);
  }
  /*
	public void reloadConfig(){
		loadConfig();
  }
  */
	public void setDefaults() {
    config.addDefault(MOTD_KEY, String.format("%s%sWelcome to this absolutely fantastic server!\nbruh", ChatColor.BOLD, ChatColor.AQUA));
    config.options().copyDefaults(true);
    CustomEssentials.getInstance().saveConfig();
  }
	public void saveConfig(){
    config.set(MOTD_KEY, messageOfTheDay);
    CustomEssentials.getInstance().saveConfig();
	}

	public void setMOTD(String message) {
		this.messageOfTheDay = message;
	}
}
