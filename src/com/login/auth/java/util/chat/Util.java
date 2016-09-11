package com.login.auth.java.util.chat;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class Util implements Listener{
	public static boolean isLogged(Player p) {
		String sep = File.separator;
		File file = new File("plugins"+sep+"LoginClearance"+sep+"users"+sep+p.getUniqueId()+".yml");
		YamlConfiguration c = YamlConfiguration.loadConfiguration(file);
		return c.getBoolean("LoggedIn");
	}
	public static void setLogged(Player p, boolean loggedin) {
		String sep = File.separator;
		File file = new File("plugins"+sep+"LoginClearance"+sep+"users"+sep+p.getUniqueId()+".yml");
		YamlConfiguration c = YamlConfiguration.loadConfiguration(file);
		c.set("LoggedIn", loggedin);
		try {
			c.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}
	public static YamlConfiguration getPConfig(Player p) {
		String sep = File.separator;
		File file = new File("plugins"+sep+"LoginClearance"+sep+"users"+sep+p.getUniqueId()+".yml");
		YamlConfiguration c = YamlConfiguration.loadConfiguration(file);
		return c;
	}
	public static FileConfiguration getConfig() {
		Plugin plugin = Bukkit.getPluginManager().getPlugin("LoginClearance");
		return plugin.getConfig();
	}
	public static void counter(Player p) {
		String sep = File.separator;
		File file = new File("plugins"+sep+"LoginClearance"+sep+"users"+sep+p.getUniqueId()+".yml");
		YamlConfiguration c = YamlConfiguration.loadConfiguration(file);
		int att = c.getInt("Attempts");
		int finalattempt = att + 1;
		p.sendMessage("" + finalattempt);
		c.set("Attempts", finalattempt);
		try {
			c.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void resetAtt(Player p) {
		String sep = File.separator;
		File file = new File("plugins"+sep+"LoginClearance"+sep+"users"+sep+p.getUniqueId()+".yml");
		YamlConfiguration c = YamlConfiguration.loadConfiguration(file);
		c.set("Attempts", 0);
		try {
			c.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}
}
