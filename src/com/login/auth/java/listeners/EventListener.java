package com.login.auth.java.listeners;

import java.io.File;
import java.io.IOException;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import com.login.auth.java.Clearance;
import com.login.auth.java.util.chat.Util;

public class EventListener implements Listener{
	Plugin plugin = Bukkit.getPluginManager().getPlugin("LoginClearance");
	public EventListener(Clearance plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		ConsoleCommandSender msg = Bukkit.getServer().getConsoleSender();
		File file = new File("plugins"+File.separator+"LoginClearance"+File.separator+"users"+File.separator+e.getPlayer().getUniqueId()+".yml");
		File dir = new File("plugins"+File.separator+"LoginClearance"+File.separator+"users");
		YamlConfiguration c = YamlConfiguration.loadConfiguration(file);
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			try {
				
				if (!file.exists()) {
					dir.mkdir();
					file.createNewFile();
					msg.sendMessage("[LoginClearance] Config file for " + e.getPlayer().getName() + " was not found! Creating one...");
					c.set("PlayerName", e.getPlayer().getName());
					c.set("IPAddress", e.getPlayer().getAddress().getHostString());
					c.set("Attempts", 0);
					c.set("LoggedIn", false);
					c.set("Type", null);
					c.set("Password", null);
					c.set("Options", "server");
					c.set("CanCreateNew", true);
					c.save(file);
					e.getPlayer().sendMessage(ChatColor.GRAY + "It seems you dont have a password yet! Do \"./password create <passowrd>\" to create a password!");
				}
				else {
					if (c.getString("Password") == null) {
						msg.sendMessage("Config file for " + e.getPlayer().getName() + " found!");
						Bukkit.getServer().getLogger().warning(e.getPlayer().getName() + " does not have a password yet.");
						c.load(file);
						c.set("LoggedIn", false);
						c.set("PlayerName", e.getPlayer().getName());
						c.set("IPAddress", e.getPlayer().getAddress().getHostString());
						c.set("CanCreateNew", true);
						c.save(file);
						if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
							e.getPlayer().sendMessage(ChatColor.GRAY + "It seems you dont have a password yet! Do \"./password create <passowrd>\" to create a password!");
						}
					}
					else {
						msg.sendMessage("Config file for " + e.getPlayer().getName() + " found!");
						c.load(file);
						c.set("LoggedIn", false);
						c.set("PlayerName", e.getPlayer().getName());
						c.set("IPAddress", e.getPlayer().getAddress().getHostString());
						c.set("CanCreateNew", false);
						c.save(file);
					}
				}
			} 
			catch (IOException ex) {
			ex.printStackTrace();
			}
			catch (InvalidConfigurationException e1) {
			e1.printStackTrace();
			}
		}
		if (Util.getConfig().getBoolean("login.DisableLogin") == true) {
			c.set("LoggedIn", true);
			e.getPlayer().sendMessage(ChatColor.GRAY + "Player logging is disabled.");
		}
		
	}
	@EventHandler
	public void loginCheck(PlayerJoinEvent e) {
		File file = new File("plugins"+File.separator+"LoginClearance"+File.separator+"users"+File.separator+e.getPlayer().getUniqueId()+".yml");
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			String newAddress = e.getPlayer().getAddress().getHostName();
			String oldAddress = Util.getPConfig(e.getPlayer()).getString("IPAddress");
			String newName = e.getPlayer().getName();
			String oldName = Util.getPConfig(e.getPlayer()).getString("PlayerName");
			if (Util.getConfig().getBoolean("login.AlwaysLogin") != true) {
				if (Util.getPConfig(e.getPlayer()).getString("Options").equalsIgnoreCase("server")) {
					if (newAddress != oldAddress) {
						Util.setLogged(e.getPlayer(), false);
						try {
							Util.getPConfig(e.getPlayer()).save(file);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						e.getPlayer().sendMessage(ChatColor.GRAY + "Your IP address changed. Please login to continue.");
					}
					if (newName != oldName) {
						Util.getPConfig(e.getPlayer()).set("LoggedIn", "false");
						try {
							Util.getPConfig(e.getPlayer()).save(file);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						e.getPlayer().sendMessage(ChatColor.GRAY + "Your name changed. Please login to continue.");
					}
					else {
						Util.getPConfig(e.getPlayer()).set("LoggedIn", "true");
						try {
							Util.getPConfig(e.getPlayer()).save(file);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
				else if (Util.getPConfig(e.getPlayer()).getString("Options").equalsIgnoreCase("always")) {
					Util.getPConfig(e.getPlayer()).set("LoggedIn", "false");
					try {
						Util.getPConfig(e.getPlayer()).save(file);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					e.getPlayer().sendMessage(ChatColor.GRAY + "Please login to continue.");
				}
			}
			else {
				Util.getPConfig(e.getPlayer()).set("LoggedIn", "false");
				try {
					Util.getPConfig(e.getPlayer()).save(file);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				e.getPlayer().sendMessage(ChatColor.GRAY + "Please login to continue.");
			}
		}
		else {
			Bukkit.getConsoleSender().sendMessage("Login feature is disabled.");
		}
	}
}
