package dev.bitsnthings.mc.cess;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.ChatColor;

public final class Config {
  private static FileConfiguration config;
  private static final String MOTD_KEY = "motd";
  private static final String MSG_CMD_FORMAT_KEY = "msgCmdFormat";

  public String msgCmdFormat;

  public static String messageOfTheDay;
	public Config() {
    config = CustomEssentials.getInstance().getConfig();
		setDefaults();
		loadConfig();
	}

  public void loadConfig(){
    messageOfTheDay = config.getString(MOTD_KEY);
    msgCmdFormat = config.getString(MSG_CMD_FORMAT_KEY);
  }
  /*
	public void reloadConfig(){
		loadConfig();
  }
  */
	public void setDefaults() {
    config.addDefault(MOTD_KEY, String.format("%s%sWelcome to this absolutely fantastic server!", ChatColor.BOLD, ChatColor.AQUA));
    config.addDefault(MSG_CMD_FORMAT_KEY, "/tellraw %s \"%s%s tells you: %s\"");
    config.options().copyDefaults(true);
    CustomEssentials.getInstance().saveConfig();
  }
	public void saveConfig(){
    config.set(MOTD_KEY, messageOfTheDay);
    CustomEssentials.getInstance().saveConfig();
	}

	public void setMOTD(String message) {
		messageOfTheDay = message;
	}
}
