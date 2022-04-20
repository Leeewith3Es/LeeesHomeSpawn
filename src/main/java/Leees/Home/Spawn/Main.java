package Leees.Home.Spawn;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, (Plugin)this);
    }

    public void onDisable() {}


    @EventHandler(priority = EventPriority.HIGHEST)
    public void oncommand(PlayerCommandPreprocessEvent event) {
        int blocksfromspawn = this.getConfig().getInt("blocksfromspawn");
        String tpamessage = this.getConfig().getString("tpamessage");
        String homemessage= this.getConfig().getString("homemessage");
        if (event.getMessage().startsWith("/home")) {
            if (event.getPlayer().getLocation().getBlockX() < blocksfromspawn && event.getPlayer().getLocation().getBlockX() > -blocksfromspawn && event.getPlayer().getLocation().getBlockZ() < blocksfromspawn && event.getPlayer().getLocation().getBlockZ() > -blocksfromspawn) {
                event.setCancelled(true);
                event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', homemessage));
            }
        } else if (event.getMessage().startsWith("/tpa") &&
                event.getPlayer().getLocation().getBlockX() < blocksfromspawn && event.getPlayer().getLocation().getBlockX() > -blocksfromspawn && event.getPlayer().getLocation().getBlockZ() < blocksfromspawn && event.getPlayer().getLocation().getBlockZ() > -blocksfromspawn) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', tpamessage));
        }
    }
}
