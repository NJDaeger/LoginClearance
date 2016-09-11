package com.login.auth.java;

import java.io.File;
import java.io.IOException;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.spigotmc.Metrics;

import com.login.auth.java.commands.Auth;
import com.login.auth.java.commands.Help;
import com.login.auth.java.commands.Login;
import com.login.auth.java.commands.Password;
import com.login.auth.java.listeners.EventListener;
import com.login.auth.java.listeners.LoginListener;
import com.login.auth.java.util.permissions.Perm;

public class Clearance extends JavaPlugin{
	
	private FileConfiguration c = this.getConfig();
	
	public void registerPermissions() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.addPermission(Perm.clearance);
		pm.addPermission(Perm.create);
		pm.addPermission(Perm.decode);
		pm.addPermission(Perm.disable);
		pm.addPermission(Perm.enable);
		pm.addPermission(Perm.help);
		pm.addPermission(Perm.login);
		pm.addPermission(Perm.options);
		pm.addPermission(Perm.override);
		pm.addPermission(Perm.protect);
		pm.addPermission(Perm.reset );
	}
	public void registerCommands() {
		this.getCommand("password").setExecutor(new Password());
		this.getCommand("login").setExecutor(new Login());
		this.getCommand("lchelp").setExecutor(new Help());
		this.getCommand("auth").setExecutor(new Auth());
	}
	public void metrics() {
		try {
			Metrics metrics = new Metrics();
			metrics.start();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void playerConfig() {
		ConsoleCommandSender msg = Bukkit.getServer().getConsoleSender();
		try {
			for (Player p : Bukkit.getOnlinePlayers()) {
				File file = new File("plugins"+File.separator+"LoginClearance"+File.separator+"users"+File.separator+p.getUniqueId()+".yml");
				File dir = new File("plugins"+File.separator+"LoginClearance"+File.separator+"users");
				YamlConfiguration c = YamlConfiguration.loadConfiguration(file);	
				if (!file.exists()) {
					dir.mkdirs();
					file.createNewFile();
					p.sendMessage(ChatColor.GRAY + "It seems you dont have a password yet! Do \"./password create <passowrd>\" to create a password!");
					msg.sendMessage("[LoginClearance] Config file for " + p.getName() + " was not found! Creating one...");
					c.set("PlayerName", p.getName());
					c.set("IPAddress", p.getAddress().getHostString());
					c.set("Attempts", 0);
					c.set("LoggedIn", false);
					c.set("Type", null);
					c.set("Password", null);
					c.set("Options", "server");
					c.set("CanCreateNew", true);
					c.save(file);
				}
				else {
					if (c.getString("Password") == null) {
						msg.sendMessage("Config file for " + p.getName() + " found!");
						p.sendMessage(ChatColor.GRAY + "It seems you dont have a password yet! Do \"./password create <passowrd>\" to create a password!");
						Bukkit.getServer().getLogger().warning(p.getName() + " does not have a password yet.");
						c.load(file);
						c.set("LoggedIn", false);
						c.set("PlayerName", p.getName());
						c.set("IPAddress", p.getAddress().getHostString());
						c.set("CanCreateNew", true);
						c.save(file);
					}
					else {
						msg.sendMessage("Config file for " + p.getName() + " found!");
						c.load(file);
						c.set("LoggedIn", false);
						c.set("PlayerName", p.getName());
						c.set("IPAddress", p.getAddress().getHostString());
						c.set("CanCreateNew", false);
						c.save(file);
					}
				}
			}
		}
		catch (IOException ee) {
			ee.printStackTrace();
		}
		catch (InvalidConfigurationException ex) {
			ex.printStackTrace();
		}
		return;
	}
	public void createConfig() {
		try {
			if (!getDataFolder().exists()) {
				getDataFolder().mkdirs();
			}
			File file = new File(getDataFolder(), "config.yml");
			if (!file.exists()) {
				getLogger().info("Config.yml not found, creating!");
				c.addDefault("password.AllowDecode", true);
				c.addDefault("password.AllowReset", true);
				c.addDefault("password.AllowOptions", false);
				c.addDefault("password.OppedPlayerLogin", true);
				c.addDefault("login.OnIpChanges", true);
				c.addDefault("login.OnPlayernameChanges", true);
				c.addDefault("login.AlwaysLogin", false);
				c.addDefault("login.DisableLogin", false);
				c.addDefault("loginAttempts.LoginAttemptCounter", true);
				c.addDefault("loginAttempts.KickAfter", 3);
				c.addDefault("loginAttempts.BanAfter", 10);
				saveDefaultConfig();
			}
			else {
				getLogger().info("Config.yml found, loading!");
				c.options().copyDefaults(true);
				saveConfig();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void onEnable() {
		new EventListener(this);
		new LoginListener(this);
		registerPermissions();
		playerConfig();
		registerCommands();
		createConfig();
		metrics();
	}
	public void onDisable() {
		
	}
}
