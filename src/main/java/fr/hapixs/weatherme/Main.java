package fr.hapixs.weatherme;

import fr.hapixs.weatherme.core.DynamicInventory;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

public class Main extends JavaPlugin {

    public Logger log;

    @Override
    public void onLoad() {
        log = Logger.getLogger("WeatherMe");
        log.setParent(Bukkit.getLogger());
        log.info("Logger initlialized !");
        log.info("Start loading WeatherMe and checking for integration stability ...");

        Optional<?> op = Arrays.stream(Package.getPackages())
                .filter(aPackage -> aPackage.getName().contains("v1_20_R3")).findAny();
        if(op.isEmpty()) {
            log.warning("Good version of craftbukkit not found.");
            log.warning("This plugin use craftbukkit v1_20_R3 packages");
            return;
        }

    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }
}
