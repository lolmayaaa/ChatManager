package lol.mayaaa.divinechat.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearchatCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("divinechat.clearchat")) {
            sender.sendMessage("§8▶ §cYou don't have permission for this.");
            return true;
        }

        for (Player player : Bukkit.getOnlinePlayers()) {
            for (int i = 0; i < 100; i++) {
                player.sendMessage("");
            }
        }

        Bukkit.broadcastMessage("§8▶ §fThe chat has been cleared by a §cstaff member§f.");
        return true;
    }
}