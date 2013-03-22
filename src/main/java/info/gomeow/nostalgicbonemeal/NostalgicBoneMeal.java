package info.gomeow.nostalgicbonemeal;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;


public class NostalgicBoneMeal extends JavaPlugin implements Listener {
	
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler//(priority=EventPriority.LOWEST)
	public void onGrow(PlayerInteractEvent event) {
		if(!event.isCancelled()) {
			if(event.getAction() == Action.RIGHT_CLICK_BLOCK) {
				Block b = event.getClickedBlock();
				Player p = event.getPlayer();
				ItemStack item = p.getItemInHand();
				if(item.getType() == Material.INK_SACK && item.getDurability() == 15) {
					if(b.getType() == Material.CROPS || b.getType() == Material.CARROT || b.getType() == Material.POTATO) {
						if(b.getData() != (byte)7) {
							if(p.getGameMode() == GameMode.SURVIVAL) {
								ItemStack i = new ItemStack(Material.INK_SACK,1);
								i.setDurability((short)15);
								p.getInventory().removeItem(i);
								p.updateInventory();
							}
							b.setData((byte)7);
						}
					}
				}
			}
		}
	}

}
