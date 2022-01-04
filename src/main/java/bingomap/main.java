package bingomap;

import bingomap.commands.imageCommand;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(this,this);
        getCommand("map").setExecutor(new imageCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
