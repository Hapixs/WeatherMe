package fr.hapixs.weatherme.core;

import org.bukkit.craftbukkit.v1_20_R3.inventory.CraftInventoryCustom;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.plugin.Plugin;

import java.util.Objects;
import java.util.logging.Logger;

public abstract class DynamicInventory extends CraftInventoryCustom implements Listener {

    private final Plugin plugin;
    private final Logger log = Logger.getLogger("WeatherMe Inventory");

    public DynamicInventory(InventoryHolder owner, InventoryType type, Plugin plugin) {
        super(owner, type);
        this.plugin=plugin;
        DynamicListener.loadListener(this, plugin);
    }

    public DynamicInventory(InventoryHolder owner, InventoryType type, String title, Plugin plugin) {
        super(owner, type, title);
        this.plugin=plugin;
        DynamicListener.loadListener(this, plugin);
    }

    public DynamicInventory(InventoryHolder owner, int size, Plugin plugin) {
        super(owner, size);
        this.plugin=plugin;
        DynamicListener.loadListener(this, plugin);
    }

    public DynamicInventory(InventoryHolder owner, int size, String title, Plugin plugin) {
        super(owner, size, title);
        this.plugin=plugin;
        DynamicListener.loadListener(this, plugin);
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {
        if(e.getInventory().equals(this)) DynamicListener.unloadListener(this);
    }

    @EventHandler
    public void onPlayerDisconnect(PlayerQuitEvent e) {
        if(e.getPlayer().getOpenInventory().getTopInventory().equals(this)) DynamicListener.unloadListener(this);
    }

    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent e) {
        if(!Objects.equals(e.getClickedInventory(), this)) return;
        if(Objects.isNull(e.getCurrentItem())) playerClickNothing(e);
        else {
            switch (e.getClick()) {
                case LEFT: playerClickLeft(e);
                case RIGHT: playerClickRight(e);
                case SHIFT_LEFT: playerShiftLeftClick(e);
                case SHIFT_RIGHT: playerShiftRightClick(e);
                case MIDDLE: playerMiddleClick(e);
                case NUMBER_KEY: playerNumberClick(e);
            }
        }
    }


    public abstract void playerClickNothing(InventoryClickEvent e);
    public abstract void playerClickLeft(InventoryClickEvent e);
    public abstract void playerClickRight(InventoryClickEvent e);
    public abstract void playerShiftLeftClick(InventoryClickEvent e);
    public abstract void playerShiftRightClick(InventoryClickEvent e);
    public abstract void playerMiddleClick(InventoryClickEvent e);
    public abstract void playerNumberClick(InventoryClickEvent e);

}
