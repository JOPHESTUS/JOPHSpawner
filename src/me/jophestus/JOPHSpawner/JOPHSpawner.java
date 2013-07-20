package me.jophestus.JOPHSpawner;

// Hi @tom

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import org.bukkit.material.MaterialData;
import org.bukkit.plugin.java.JavaPlugin;

public class JOPHSpawner extends JavaPlugin implements Listener {
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}

	public void onDisable() {
	}

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onBlockBreak(BlockBreakEvent event) {
		if (event.getBlock().getType() == Material.MOB_SPAWNER) {
			Block block = event.getBlock();
			Player player = event.getPlayer();
			

			if (player.hasPermission("JOPHSpawner.use")) {
				block.setType(Material.AIR);

				block.getWorld().dropItemNaturally(block.getLocation(),
						new ItemStack(Material.MOB_SPAWNER, 1));
				player.sendMessage(ChatColor.GREEN + "[JOPHSpawner] "
						+ ChatColor.YELLOW + "Spawner Dropped :)");
				event.setCancelled(true);
			} else {
				player.sendMessage(ChatColor.GREEN + "[JOPHSpawner]"
						+ ChatColor.YELLOW
						+ " You can't break and pick up spawners :(");

			}
		}
		
	
	}
	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onClick(PlayerInteractEvent event){
		if (event.getClickedBlock().getType() == Material.DRAGON_EGG) {
			Block block = event.getClickedBlock();
			Player player = event.getPlayer();
			

			if (player.hasPermission("JOPHSpawner.dragonegg")) {
				block.setType(Material.AIR);

				block.getWorld().dropItemNaturally(block.getLocation(),
						new ItemStack(Material.DRAGON_EGG, 1));
				player.sendMessage(ChatColor.GREEN + "[JOPHSpawner] "
						+ ChatColor.YELLOW + "Dragon Egg Dropped :)");
				event.setCancelled(true);
			} else {
				player.sendMessage(ChatColor.GREEN + "[JOPHSpawner]"
						+ ChatColor.YELLOW
						+ " You can't break and pick up Dragon Eggs :(");
				Bukkit bukkit;
				

			}
		}
	}
}
