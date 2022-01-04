package bingomap.commands;

import bingomap.models.logoRenderer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.map.MapView;

public class imageCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) return true;

        Player player = (Player) sender;

        if(args.length == 0) {
            player.sendMessage("Wrong usage, /map <link>");
            return true;
        }

        MapView view = Bukkit.createMap(player.getWorld());
        view.getRenderers().clear();

        logoRenderer renderer = new logoRenderer();
        if(!renderer.load(args[0])) {
            sender.sendMessage("image not load");
            return true;
        }
        view.addRenderer(renderer);

        ItemStack map = new ItemStack(Material.FILLED_MAP);
        MapMeta meta = (MapMeta) map.getItemMeta();

        meta.setMapView(view);
        map.setItemMeta(meta);

        player.getInventory().addItem(map);
        player.sendMessage("map give");

        return false;
    }
}
