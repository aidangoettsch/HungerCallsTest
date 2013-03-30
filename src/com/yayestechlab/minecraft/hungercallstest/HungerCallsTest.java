package com.yayestechlab.minecraft.hungercallstest;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class HungerCallsTest extends JavaPlugin implements Listener{
	public void onEnable(){
		this.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onPlayerClick(PlayerInteractEvent event1) {
		Player p = event1.getPlayer();
		Action a = event1.getAction();

		if(a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK) {
			ItemStack item = p.getItemInHand();
			Material material = item.getType();
			int nutrition = material.getNutrition();
			double saturation = material.getSaturation();
			p.sendMessage("That item will restore " + nutrition + "hunger and has" + saturation + "saturation");
		}
	}
}
