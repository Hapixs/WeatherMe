package fr.hapixs.weatherme.core;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class DynamicListener implements Listener {

    public static void unloadListener(Listener listener) {
        Bukkit.getLogger().info("Unloading listener "+listener.getClass().getName());
        Arrays.stream(listener.getClass().getMethods()).filter(method ->
                method.isAnnotationPresent(EventHandler.class)
                        && method.getParameterCount() == 1
        ).forEach(method -> {
            Class<? extends Event> eventClass = (Class<? extends Event>) method.getParameterTypes()[0];
            try {
                HandlerList handlers = (HandlerList) eventClass.getMethod("getHandlerList").invoke(null);
                handlers.unregister(listener);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        });
    }

    public static void loadListener(Listener listener, Plugin plugin) {
        Bukkit.getPluginManager().registerEvents(listener, plugin);
    }

}
