package info.gomeow.nostalgicbonemeal;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class NostalgicBoneMeal extends JavaPlugin implements Listener {
	
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}

}
