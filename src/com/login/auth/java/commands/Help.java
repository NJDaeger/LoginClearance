package com.login.auth.java.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import com.google.common.collect.Lists;
import com.login.auth.java.commands.consolesubcmd.ConHelp;
import com.login.auth.java.commands.subcommands.SubHelp;
import com.login.auth.java.util.chat.CUtil;
import com.login.auth.java.util.permissions.Perm;

public class Help implements CommandExecutor, TabCompleter{
	
	public boolean onCommand(CommandSender sndr, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("lchelp") && sndr instanceof Player) {
			if (sndr.hasPermission(Perm.help) || sndr.hasPermission(Perm.clearance) || sndr.hasPermission(Perm.all) || sndr.isOp()) {
				if (args.length == 0) {
					SubHelp.noArgs(sndr);
					return true;
				}
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("password")) {
						SubHelp.password(sndr);
						return true;
					}
					else if (args[0].equalsIgnoreCase("login")) {
						SubHelp.login(sndr);
						return true;
					}
					else if (args[0].equalsIgnoreCase("auth")) {
						SubHelp.auth(sndr);
						return true;
					}
					else CUtil.unknown(sndr);
					return true;
				}
				if (args.length == 2) {
					if (args[0].equalsIgnoreCase("password") && args[1].equalsIgnoreCase("create")) {
						SubHelp.create(sndr);
						return true;
					}
					else if (args[0].equalsIgnoreCase("password") && args[1].equalsIgnoreCase("decode")) {
						SubHelp.decode(sndr);
						return true;
					}
					else if (args[0].equalsIgnoreCase("password") && args[1].equalsIgnoreCase("options")) {
						SubHelp.options(sndr);
						return true;
					}
					else if (args[0].equalsIgnoreCase("password") && args[1].equalsIgnoreCase("override")) {
						SubHelp.override(sndr);
						return true;
					}
					else if (args[0].equalsIgnoreCase("password") && args[1].equalsIgnoreCase("reset")) {
						SubHelp.reset(sndr);
						return true;
					}
					else CUtil.unknown(sndr);
					return true;
				}
				else if (args.length > 2) {
				CUtil.TMA(sndr);
				return true;
				}
			}
			else CUtil.noPerms(sndr);
			return true;
		}
		else if (cmd.getName().equalsIgnoreCase("lchelp") && !(sndr instanceof Player)) {
			if (args.length == 0) {
				ConHelp.noArgs(sndr);
				return true;
			}
			else if (args.length == 1) {
				if (args[0].equalsIgnoreCase("password")) {
					ConHelp.password1(sndr);
					return true;
				}
				else if (args[0].equalsIgnoreCase("login")) {
					ConHelp.login1(sndr);
					return true;
				}
				else if (args[0].equalsIgnoreCase("auth")) {
					ConHelp.auth1(sndr);
					return true;
				}
				else CUtil.unknown(sndr);
				return true;
			}
			else if (args.length == 2) {
				if (args[0].equalsIgnoreCase("password") && args[1].equalsIgnoreCase("create")) {
					ConHelp.create(sndr);
					return true;
				}
				else if (args[0].equalsIgnoreCase("password") && args[1].equalsIgnoreCase("decode")) {
					ConHelp.decode(sndr);
					return true;
				}
				else if (args[0].equalsIgnoreCase("password") && args[1].equalsIgnoreCase("options")) {
					ConHelp.options(sndr);
					return true;
				}
				else if (args[0].equalsIgnoreCase("password") && args[1].equalsIgnoreCase("override")) {
					ConHelp.override(sndr);
					return true;
				}
				else if (args[0].equalsIgnoreCase("password") && args[1].equalsIgnoreCase("reset")) {
					ConHelp.reset(sndr);
					return true;
				}
				else CUtil.unknown(sndr);
				return true;
			}
			else if (args.length > 2) {
				CUtil.TMA(sndr);
				return true;
			}
		}
		return true;
	}

	public List<String> onTabComplete(CommandSender sndr, Command cmd, String label, String[] args) {
		List<String> subCommands = Arrays.asList("password", "login", "auth");
		List<String> passCommands = Arrays.asList("create", "decode", "options", "override", "reset");
		List<String> sub = Lists.newArrayList();
		if (cmd.getName().equalsIgnoreCase("lchelp")) {
			if (args.length == 1) {
				for (String a : subCommands) {
					if (a.toLowerCase().startsWith(args[0])) sub.add(a);
				}
				return sub;
			}
			if ((args.length == 2) && args[0].equalsIgnoreCase("password")) {
				for (String a : passCommands) {
					if (a.toLowerCase().startsWith(args[1])) sub.add(a);
				}
				return sub;
			}
			return null;
		}
		return null;
	}
}
