package fr.alphao;

import fr.alphao.commands.Issou;
import fr.alphao.commands.Menu;
import fr.alphao.listeners.ItemsListener;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("CalAlpha s'allume.");
        CommandExecutor menu = (CommandExecutor) new Menu();
        getCommand("rp").setExecutor(menu);
        CommandExecutor issou = (CommandExecutor) new Issou();
        getCommand("issou").setExecutor(issou);

        getServer().getPluginManager().registerEvents(new ItemsListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("CalAlpha s'éteint.");
    }
}