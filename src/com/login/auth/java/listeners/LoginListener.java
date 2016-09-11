package com.login.auth.java.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.CauldronLevelChangeEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.entity.PlayerLeashEntityEvent;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupArrowEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerShearEntityEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.event.player.PlayerUnleashEntityEvent;
import org.bukkit.event.player.PlayerVelocityEvent;
import org.bukkit.plugin.Plugin;

import com.login.auth.java.Clearance;
import com.login.auth.java.util.chat.Util;

public class LoginListener implements Listener{
	Plugin plugin = Bukkit.getPluginManager().getPlugin("LoginClearance");
	public LoginListener(Clearance plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void blockBreak(BlockBreakEvent e) {
		Player p = (Player) e.getPlayer();
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			if (!Util.isLogged(p)) {
				e.setCancelled(true);
				return;
			}
		}	
	}
	@EventHandler
	public void blockDamage(BlockDamageEvent e) {
		Player p = (Player) e.getPlayer();
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			if (!Util.isLogged(p)) {
				e.setCancelled(true);
				return;
			}
		}	
	}
	@EventHandler 
	public void blockIgnite(BlockIgniteEvent e) {
		Player p = (Player) e.getPlayer();
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			if (!Util.isLogged(p)) {
				e.setCancelled(true);
				return;
			}
		}	
	}
	@EventHandler
	public void blockPlace(BlockPlaceEvent e) {
		Player p = (Player) e.getPlayer();
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			if (!Util.isLogged(p)) {
				e.setCancelled(true);
				return;
			}
		}	
	}
	@EventHandler
	public void cauldronLevel(CauldronLevelChangeEvent e) {
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			if (e instanceof Player) {
				Player p = (Player) e.getEntity();
				if (!Util.isLogged(p)) {
					e.setCancelled(true);
					return;
				}
			}
		}
	}
	@EventHandler
	public void onEnchant(EnchantItemEvent e) {
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			if (e instanceof Player) {
				Player p = (Player) e.getEnchanter();
				if (!Util.isLogged(p)) {
					e.setCancelled(true);
					return;
				}
			}
		}
	}
	@EventHandler
	public void onAchievement(PlayerAchievementAwardedEvent e) {
		Player p = (Player) e.getPlayer();
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			if (!Util.isLogged(p)) {
				e.setCancelled(true);
				return;
			}
		}	
	}
	@EventHandler
	public void onAnim(PlayerAnimationEvent e) {
		Player p = (Player) e.getPlayer();
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			if (!Util.isLogged(p)) {
				e.setCancelled(true);
				return;
			}
		}	
	}
	@EventHandler
	public void armorStandManip(PlayerArmorStandManipulateEvent e) {
		Player p = (Player) e.getPlayer();
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			if (!Util.isLogged(p)) {
				e.setCancelled(true);
				return;
			}
		}	
	}
	@EventHandler
	public void enterBed(PlayerBedEnterEvent e) {
		Player p = (Player) e.getPlayer();
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			if (!Util.isLogged(p)) {
				e.setCancelled(true);
				return;
			}
		}	
	}
	@EventHandler
	public void BucketEmpty(PlayerBucketEmptyEvent e) {
		Player p = (Player) e.getPlayer();
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			if (!Util.isLogged(p)) {
				e.setCancelled(true);
				return;
			}
		}	
	}
	@EventHandler
	public void BucketFill(PlayerBucketFillEvent e) {
		Player p = (Player) e.getPlayer();
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			if (!Util.isLogged(p)) {
				e.setCancelled(true);
				return;
			}
		}	
	}
	/*
	@EventHandler
	public void PlayerCommand(PlayerCommandPreprocessEvent e) {
		Player p = (Player) e.getPlayer();
		if (!Util.isLogged(p)) {
			if (!e.getMessage().startsWith("password") || !e.getMessage().startsWith("login") || !e.getMessage().startsWith("auth")) {
				e.setCancelled(true);
			}
		}
		
	}
	*/
	@EventHandler
	public void dropItem(PlayerDropItemEvent e) {
		Player p = (Player) e.getPlayer();
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			if (!Util.isLogged(p)) {
				e.setCancelled(true);
				return;
			}
		}	
	}
	@EventHandler
	public void EditBook(PlayerEditBookEvent e) {
		Player p = (Player) e.getPlayer();
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			if (!Util.isLogged(p)) {
				e.setCancelled(true);
				return;
			}
		}	
	}
	@EventHandler
	public void EggThrow(PlayerEggThrowEvent e) {
		Player p = (Player) e.getPlayer();
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			if (!Util.isLogged(p)) {
				e.getEgg().remove();
				return;
			}
		}	
	}
	@EventHandler
	public void playerExpChange(PlayerExpChangeEvent e) {
		Player p = (Player) e.getPlayer();
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			if (!Util.isLogged(p)) {
				int preAm = e.getAmount();
				float xp = p.getExp();
				p.setExp(xp - preAm);
				return;
			}
		}
	}
	@EventHandler
	public void fishEvent(PlayerFishEvent e) {
		Player p = (Player) e.getPlayer();
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			if (!Util.isLogged(p)) {
				e.setCancelled(true);
				return;
			}
		}	
	}
	@EventHandler
	public void InteractEntity(PlayerInteractEntityEvent e) {
		Player p = (Player) e.getPlayer();
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			if (!Util.isLogged(p)) {
				e.setCancelled(true);
				return;
			}
		}	
	}
	@EventHandler
	public void itemConsume(PlayerItemConsumeEvent e) {
		Player p = (Player) e.getPlayer();
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			if (!Util.isLogged(p)) {
				e.setCancelled(true);
				return;
			}
		}	
	}
	@EventHandler
	public void itemDamage(PlayerItemDamageEvent e) {
		Player p = (Player) e.getPlayer();
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			if (!Util.isLogged(p)) {
				e.setCancelled(true);
				return;
			}
		}	
	}
	@EventHandler
	public void itemHeld(PlayerItemHeldEvent e) {
		Player p = (Player) e.getPlayer();
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			if (!Util.isLogged(p)) {
				e.setCancelled(true);
				return;
			}
		}	
	}
	@EventHandler
	public void levelChange(PlayerLevelChangeEvent e) {
		Player p = (Player) e.getPlayer();
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			if (!Util.isLogged(p)) {
				int old = e.getOldLevel();
				int nw = e.getNewLevel();
				p.setLevel(nw - old);
				return;
			}
		}
	}
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = (Player) e.getPlayer();
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			if (!Util.isLogged(p)) {
				e.setCancelled(true);
				return;
			}
		}	
	}
	@EventHandler
	public void pickupArrow(PlayerPickupArrowEvent e) {
		Player p = (Player) e.getPlayer();
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			if (!Util.isLogged(p)) {
				e.setCancelled(true);
				return;
			}
		}	
	}
	@EventHandler
	public void pickupItem(PlayerPickupItemEvent e) {
		Player p = (Player) e.getPlayer();
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			if (!Util.isLogged(p)) {
				e.setCancelled(true);
				return;
			}
		}	
	}
	@EventHandler
	public void Playerportal(PlayerPortalEvent e) {
		Player p = (Player) e.getPlayer();
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			if (!Util.isLogged(p)) {
				e.setCancelled(true);
				return;
			}
		}	
	}
	@EventHandler
	public void shearEntity(PlayerShearEntityEvent e) {
		Player p = (Player) e.getPlayer();
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			if (!Util.isLogged(p)) {
				e.setCancelled(true);
				return;
			}
		}	
	}
	@EventHandler
	public void swapHands(PlayerSwapHandItemsEvent e) {
		Player p = (Player) e.getPlayer();
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			if (!Util.isLogged(p)) {
				e.setCancelled(true);
				return;
			}
		}	
	}
	@EventHandler
	public void toggleFlight(PlayerToggleFlightEvent e) {
		Player p = (Player) e.getPlayer();
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			if (!Util.isLogged(p)) {
				e.setCancelled(true);
				return;
			}
		}	
	}
	@EventHandler
	public void toggleSneak(PlayerToggleSneakEvent e) {
		Player p = (Player) e.getPlayer();
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			if (!Util.isLogged(p)) {
				e.setCancelled(true);
				return;
			}
		}	
	}
	@EventHandler
	public void toggleSprint(PlayerToggleSprintEvent e) {
		Player p = (Player) e.getPlayer();
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			if (!Util.isLogged(p)) {
				e.setCancelled(true);
				return;
			}
		}	
	}
	@EventHandler
	public void playerLeash(PlayerLeashEntityEvent e) {
		Player p = (Player) e.getPlayer();
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			if (!Util.isLogged(p)) {
				e.setCancelled(true);
				return;
			}
		}	
	}
	@EventHandler
	public void unleashEntity(PlayerUnleashEntityEvent e) {
		Player p = (Player) e.getPlayer();
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			if (!Util.isLogged(p)) {
				e.setCancelled(true);
				return;
			}
		}	
	}
	@EventHandler
	public void velocityChange(PlayerVelocityEvent e) {
		Player p = (Player) e.getPlayer();
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			if (!Util.isLogged(p)) {
				e.setCancelled(true);
				return;
			}
		}	
	}
	@EventHandler
	public void signChange(SignChangeEvent e) {
		Player p = (Player) e.getPlayer();
		if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
			if (!Util.isLogged(p)) {
				e.setCancelled(true);
				return;
			}
		}	
	}
}
