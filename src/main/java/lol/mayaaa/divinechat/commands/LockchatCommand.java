package lol.mayaaa.divinechat.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class LockchatCommand implements CommandExecutor {

    private static boolean islocked = false;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("divinechat.lockchat")) {
            sender.sendMessage("§8▶ §cYou don't have permission for this.");
            return true;
        }

        islocked = !islocked;

        if (islocked) {
            Bukkit.broadcastMessage("§8▶ §cThe chat was locked by a staff member!");
        } else {
            Bukkit.broadcastMessage("§8▶ §aThe chat has been unlocked!");
        }
        return true;
    }

    public static boolean ischatlocked() {
        return islocked;
    }
}