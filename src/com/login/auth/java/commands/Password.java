package com.login.auth.java.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import com.google.common.collect.Lists;
import com.login.auth.java.commands.consolesubcmd.ConDecode;
import com.login.auth.java.commands.consolesubcmd.ConOverride;
import com.login.auth.java.commands.consolesubcmd.ConReset;
import com.login.auth.java.commands.subcommands.Create;
import com.login.auth.java.commands.subcommands.Decode;
import com.login.auth.java.commands.subcommands.Options;
import com.login.auth.java.commands.subcommands.Override;
import com.login.auth.java.commands.subcommands.Reset;
import com.login.auth.java.util.chat.CUtil;
import com.login.auth.java.util.permissions.Perm;

public class Password implements CommandExecutor, TabCompleter{
	public boolean onCommand(CommandSender sndr, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("password") && sndr instanceof Player) {
			if (sndr.hasPermission(Perm.create) || sndr.isOp() || sndr.hasPermission(Perm.decode) || sndr.hasPermission(Perm.options) || sndr.hasPermission(Perm.override) || sndr.hasPermission(Perm.reset) || sndr.hasPermission(Perm.all)) {
				if (args.length >= 1) {
	////////NEW COMMAND////////
					/*
					 * TODO
					 * Fix decode others command (console side and sndr side), fix override (same reasons), and fix reset command for same reasons..
					 * im assuming all of them have the same type of issue. 
					 */
					if (args[0].equalsIgnoreCase("create")) {
						Create.create(sndr, args);
						return true;
					}
	////////NEW COMMAND////////
					else if (args[0].equalsIgnoreCase("decode")) {
						Decode.decode(sndr, args);
						return true;
					}
	////////NEW COMMAND////////
					else if (args[0].equalsIgnoreCase("options")) {
						Options.options(sndr, args);
						return true;
					}
	////////NEW COMMAND////////				
					else if (args[0].equalsIgnoreCase("override")) {
						Override.override(sndr, args);
						return true;
					}
	////////NEW COMMAND////////
					else if (args[0].equalsIgnoreCase("reset")) {
						Reset.reset(sndr, args);
						return true;
					}
					else CUtil.unknown(sndr);
					return true;
				}
				else CUtil.NEA(sndr);
				return true;
			}
			else CUtil.noPerms(sndr);
			return true;
		}
		else if (cmd.getName().equalsIgnoreCase("password") && !(sndr instanceof Player)) {
			if (args.length > 1) {
				if (args[0].equalsIgnoreCase("decode")) {
					ConDecode.decode(sndr, args);
					return true;
				}
				else if (args[0].equalsIgnoreCase("override")) {
					ConOverride.override(sndr, args);
					return true;
				}
				else if (args[0].equalsIgnoreCase("reset")) {
					ConReset.reset(sndr, args);
					return true;
				}
				else CUtil.unknown(sndr);
				return true;
			}
			else CUtil.NEA(sndr);
			return true;
		}
		return false;
	}
	public List<String> onTabComplete(CommandSender sndr, Command cmd, String label, String[] args) {
		List<String> subCommands = Arrays.asList("create", "decode", "options", "override", "reset");
		List<String> consoleSubs = Arrays.asList("decode", "override", "reset");
		List<String> options = Arrays.asList("server", "always");
		List<String> sub = Lists.newArrayList();
		if (cmd.getName().equalsIgnoreCase("password") && sndr instanceof Player) {
			if (args.length == 1) {
				for (String a : subCommands) {
					if (a.toLowerCase().startsWith(args[0])) sub.add(a);
				}
				return sub;
			}
			if ((args.length > 1) && args[0].equalsIgnoreCase("options")) {
				for (String a : options) {
					if (a.toLowerCase().startsWith(args[1])) sub.add(a);
				}
				return sub;
			}
			return null;
		}
		else if (cmd.getName().equalsIgnoreCase("password") && !(sndr instanceof Player)) {
			if (args.length == 1) {
				for (String a : consoleSubs) {
					if (a.toLowerCase().startsWith(args[0])) sub.add(a);
				}
				return sub;
			}
			return null;
		}
		return null;
	}
}
