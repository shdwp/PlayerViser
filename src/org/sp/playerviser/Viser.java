package org.sp.playerviser;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;

/**
 * Author: ShadowPrince
 * Date: 24.02.12
 * Time: 18:55
 * at IntelliJ IDEA.
 */
public class Viser {
    public static void onPlayerDropItem(Player player, Item i){
        String template = playerTemplate("Player $player drop $item ($amount) at $xyz", player)
                .replace("$item", i.getItemStack().getType().name())
                .replace("$amount", "" + i.getItemStack().getAmount());
        
        Log.log(template);
    }
    public static void onPlayerCommandPreprocess(Player player, String command) {
        String template = playerTemplate("Player $player command $command at $xyz", player)
                .replace("$command", command);

        Log.log(template);
    }
    public static void onPlayerPickupItem(Player player, Item i){
        String template = playerTemplate("Player $player pickup $item ($amount) at $xyz", player)
                .replace("$item", i.getItemStack().getType().name())
                .replace("$amount", "" + i.getItemStack().getAmount());

        Log.log(template);
    }
    public static void onPlayerInteractEntity(Player player, Entity entity) {
        String template = playerTemplate("Player $player interact $entity at $xyz", player)
                .replace("$entity", "" + entity.getEntityId())
                ;
        Log.log(template);
    }
    public static void onPlayerInteract(Player player, Material block){
        String template = playerTemplate("Player $player interact $block at $xyz", player)
                .replace("$block", block.name());

        Log.log(template);
    }
    public static void onPlayerDeath(Player player){
        String template = playerTemplate("Player $player death at $xyz", player);
        
        Log.log(template);
    }
    public static void onPlayerTeleport(Player player, Location location) {
        String template = playerTemplate("Player $player teleported from $xyz to $nxyz", player)
                .replace("$nxyz", (int) location.getX()+","+ (int) location.getY()+","+ (int) location.getZ());

        Log.log(template);
    }
    public static String playerTemplate(String template, Player player){
        Location location = player.getLocation();
        return template
                .replace("$player", player.getName())
                .replace("$xyz", (int) location.getX()+","+ (int) location.getY()+","+ (int) location.getZ());
    }
}
                                    