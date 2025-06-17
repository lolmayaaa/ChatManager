package lol.mayaaa.divinechat;

import lol.mayaaa.divinechat.commands.ClearchatCommand;
import lol.mayaaa.divinechat.commands.LockchatCommand;
import lol.mayaaa.divinechat.core.Cooldown;
import lol.mayaaa.divinechat.listeners.ChatListener;
import lol.mayaaa.divinechat.utils.Config;
import org.bukkit.plugin.java.JavaPlugin;

public final class DivineChat extends JavaPlugin {
    private Cooldown cooldown;
    private Config config;

    @Override
    public void onEnable() {
        cooldown = new Cooldown();
        config = new Config(this);

        getServer().getPluginManager().registerEvents(new ChatListener(cooldown, config), this);
        getCommand("lockchat").setExecutor(new LockchatCommand());
        getCommand("clearchat").setExecutor(new ClearchatCommand());
    }

    @Override
    public void onDisable() {
    }
}