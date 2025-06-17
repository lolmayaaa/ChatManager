package lol.mayaaa.divinechat.core;

import java.util.HashMap;
import java.util.UUID;

public class Cooldown {
    private HashMap<UUID, Long> cooldowns = new HashMap<>();

    public void setcooldown(UUID player, long time) {
        cooldowns.put(player, System.currentTimeMillis() + (time * 1000));
    }

    public long getremainingtime(UUID player) {
        return (cooldowns.getOrDefault(player, 0L) - System.currentTimeMillis()) / 1000;
    }

    public boolean isoncooldown(UUID player) {
        return cooldowns.containsKey(player) && System.currentTimeMillis() < cooldowns.get(player);
    }
}