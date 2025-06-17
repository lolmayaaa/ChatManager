package lol.mayaaa.divinechat.listeners;

import lol.mayaaa.divinechat.commands.LockchatCommand;
import lol.mayaaa.divinechat.core.Cooldown;
import lol.mayaaa.divinechat.utils.Config;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {
    private Cooldown cooldown;
    private Config config;

    public ChatListener(Cooldown cooldown, Config config) {
        this.cooldown = cooldown;
        this.config = config;
    }

    @EventHandler
    public void onchat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        if (LockchatCommand.ischatlocked() && !player.hasPermission("divinechat.bypass.lockchat")) {
            event.setCancelled(true);
            player.sendMessage("§cSorry, you can't type right now as the chat was locked by a staff member.");
            return;
        }

        if (player.hasPermission("divinechat.bypass")) {
            return;
        }

        if (config.getconfig().getBoolean("cooldown")) {
            int time = config.getconfig().getInt("cooldown-time");
            if (cooldown.isoncooldown(player.getUniqueId())) {
                long remaining = cooldown.getremainingtime(player.getUniqueId());
                event.setCancelled(true);
                player.sendMessage("§cYou must wait " + remaining + " seconds before sending another message.");
            } else {
                cooldown.setcooldown(player.getUniqueId(), time);
            }
        }
    }
}