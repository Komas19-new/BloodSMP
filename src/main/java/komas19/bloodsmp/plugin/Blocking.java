package komas19.bloodsmp.plugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.player.PlayerPickupItemEvent;


public class Blocking extends JavaPlugin implements Listener {
    FileConfiguration config = this.getConfig();
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getCommand("bloodreload").setExecutor(new Reload(this));
        System.out.println("Hello World from Blood SMP Plugin");
        config.options().header("BLOOD SMP PLUGIN CONFIG");
        config.addDefault("netherite", true);
        config.addDefault("tipped_arrows", true);
        config.addDefault("end_crystals", true);
        config.addDefault("respawn_anchor", true);
        config.addDefault("reset_config", false);
        config.addDefault("config_version", 5);
        config.options().copyDefaults(true);
        saveDefaultConfig();
        if (config.getBoolean("netherite")) {
            // True
        } else {
            // False
        }
        if (config.getBoolean("tipped_arrows")) {
            // True
        } else {
            // False
        }
        if (config.getBoolean("reset_config")) {
            // True
            System.out.println("Resetting config.yml as reset_config is set to true");
            config.options().header("BLOOD SMP PLUGIN CONFIG");
            config.set("netherite", true);
            config.set("tipped_arrows", true);
            config.set("end_crystals", true);
            config.set("respawn_anchor", true);
            config.set("reset_config", false);
            config.set("config_version", 5);
            config.options().copyDefaults(true);
            saveDefaultConfig();
            this.reloadConfig();
            System.out.println("Finished resetting config.yml");
        }
    }
    public void onDisable() {
        config.options().copyDefaults(true);
        saveDefaultConfig();
        System.out.println("Finished saving config.yml!");
        System.out.println("Goodbye!");
    }

    @EventHandler
    public void onItemHeld(PlayerItemHeldEvent event) {
        ItemStack item = event.getPlayer().getItemInHand();
        if (config.getBoolean("netherite")) {
            // True
            if (item != null && item.getType() == Material.ANCIENT_DEBRIS) {
                System.out.println("found ancient debris");
                event.setCancelled(true);
                event.getPlayer().getInventory().removeItem(item);
                Bukkit.broadcastMessage("§bAn stupid guy tried getting ancient debris.. Oops.. Its gone!");
                Bukkit.broadcastMessage(event.getPlayer().getName());
            }
        }
        if (config.getBoolean("tipped_arrows")) {
            // True
            if (item != null && item.getType() == Material.TIPPED_ARROW) {
                System.out.println("found tipped arrow");
                event.setCancelled(true);
                event.getPlayer().getInventory().removeItem(item);
                Bukkit.broadcastMessage("§bAn stupid guy tried getting tipped arrows.. Oops.. Its gone!");
                Bukkit.broadcastMessage(event.getPlayer().getName());
            }
        }
        if (config.getBoolean("end_crystals")) {
            // True
            if (item != null && item.getType() == Material.END_CRYSTAL) {
                System.out.println("found end crystal");
                event.setCancelled(true);
                event.getPlayer().getInventory().removeItem(item);
                Bukkit.broadcastMessage("§bAn stupid guy tried getting end crystals.. Oops.. Its gone!");
                Bukkit.broadcastMessage(event.getPlayer().getName());
            }
        }
        if (config.getBoolean("respawn_anchor")) {
            // True
            if (item != null && item.getType() == Material.RESPAWN_ANCHOR) {
                System.out.println("found RESPAWN ANCHOR");
                event.setCancelled(true);
                event.getPlayer().getInventory().removeItem(item);
                Bukkit.broadcastMessage("§bAn stupid guy tried getting respawn anchors.. Oops.. Its gone!");
                Bukkit.broadcastMessage(event.getPlayer().getName());
            }
        }
    }
    @EventHandler
    public void onBlockDestroyed(BlockBreakEvent event) {
        ItemStack item = event.getPlayer().getItemOnCursor();
        if (config.getBoolean("tipped_arrows")) {
            // True
            if (item != null && item.getType() ==Material.TIPPED_ARROW) {
                System.out.println("found tipped arrow");
                event.setCancelled(true);
                event.getPlayer().getInventory().removeItem(item);
                Bukkit.broadcastMessage("§bAn stupid guy tried getting tipped arrows.. Oops.. Its gone!");
                Bukkit.broadcastMessage(event.getPlayer().getName());
            }
        }
        if (config.getBoolean("netherite")) {
            // True
            if (item != null && item.getType() ==Material.ANCIENT_DEBRIS) {
                System.out.println("found ancient debris");
                event.setCancelled(true);
                event.getPlayer().getInventory().removeItem(item);
                Bukkit.broadcastMessage("§bAn stupid guy tried getting ancient debris.. Oops.. Its gone!");
                Bukkit.broadcastMessage(event.getPlayer().getName());
            }
        }
        if (config.getBoolean("end_crystals")) {
            // True
            if (item != null && item.getType() == Material.END_CRYSTAL) {
                System.out.println("found end crystal");
                event.setCancelled(true);
                event.getPlayer().getInventory().removeItem(item);
                Bukkit.broadcastMessage("§bAn stupid guy tried getting end crystals.. Oops.. Its gone!");
                Bukkit.broadcastMessage(event.getPlayer().getName());
            }
        }
        if (config.getBoolean("respawn_anchor")) {
            // True
            if (item != null && item.getType() == Material.RESPAWN_ANCHOR) {
                System.out.println("found RESPAWN ANCHOR");
                event.setCancelled(true);
                event.getPlayer().getInventory().removeItem(item);
                Bukkit.broadcastMessage("§bAn stupid guy tried getting respawn anchors.. Oops.. Its gone!");
                Bukkit.broadcastMessage(event.getPlayer().getName());
            }
        }
    }
    @EventHandler
    public void onItemPickup(PlayerPickupItemEvent event) {
        ItemStack item = event.getPlayer().getItemOnCursor();
        if (config.getBoolean("tipped_arrows")) {
            // True
            if (item != null && item.getType() ==Material.TIPPED_ARROW) {
                System.out.println("found tipped arrow");
                event.setCancelled(true);
                event.getPlayer().getInventory().removeItem(item);
                Bukkit.broadcastMessage("§bAn stupid guy tried getting tipped arrows.. Oops.. Its gone!");
                Bukkit.broadcastMessage(event.getPlayer().getName());
            }
        }
        if (config.getBoolean("netherite")) {
            // True
            if (item != null && item.getType() ==Material.ANCIENT_DEBRIS) {
                System.out.println("found ancient debris");
                event.setCancelled(true);
                event.getPlayer().getInventory().removeItem(item);
                Bukkit.broadcastMessage("§bAn stupid guy tried getting ancient debris.. Oops.. Its gone!");
                Bukkit.broadcastMessage(event.getPlayer().getName());
            }
        }
        if (config.getBoolean("end_crystals")) {
            // True
            if (item != null && item.getType() == Material.END_CRYSTAL) {
                System.out.println("found end crystal");
                event.setCancelled(true);
                event.getPlayer().getInventory().removeItem(item);
                Bukkit.broadcastMessage("§bAn stupid guy tried getting end crystals.. Oops.. Its gone!");
                Bukkit.broadcastMessage(event.getPlayer().getName());
            }
        }
        if (config.getBoolean("respawn_anchor")) {
            // True
            if (item != null && item.getType() == Material.RESPAWN_ANCHOR) {
                System.out.println("found RESPAWN ANCHOR");
                event.setCancelled(true);
                event.getPlayer().getInventory().removeItem(item);
                Bukkit.broadcastMessage("§bAn stupid guy tried getting respawn anchors.. Oops.. Its gone!");
                Bukkit.broadcastMessage(event.getPlayer().getName());
            }
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        ItemStack item = event.getCurrentItem();
        if (config.getBoolean("tipped_arrows")) {
            // True
            if (item != null && item.getType() ==Material.TIPPED_ARROW) {
                System.out.println("found tipped arrow");
                event.setCancelled(true);
                event.getWhoClicked().getInventory().removeItem(item);
                Bukkit.broadcastMessage("§bAn stupid guy tried getting tipped arrows.. Oops.. Its gone!");
                Bukkit.broadcastMessage(event.getWhoClicked().getName());
            }
        }
        if (config.getBoolean("netherite")) {
            // True
            if (item != null && item.getType() ==Material.ANCIENT_DEBRIS) {
                System.out.println("found ancient debris");
                event.setCancelled(true);
                event.getWhoClicked().getInventory().removeItem(item);
                Bukkit.broadcastMessage("§bAn stupid guy tried getting ancient debris.. Oops.. Its gone!");
                Bukkit.broadcastMessage(event.getWhoClicked().getName());
            }
        }
        if (config.getBoolean("end_crystals")) {
            // True
            if (item != null && item.getType() == Material.END_CRYSTAL) {
                System.out.println("found end crystal");
                event.setCancelled(true);
                event.getWhoClicked().getInventory().removeItem(item);
                Bukkit.broadcastMessage("§bAn stupid guy tried getting end crystals.. Oops.. Its gone!");
                Bukkit.broadcastMessage(event.getWhoClicked().getName());
            }
        }
        if (config.getBoolean("respawn_anchor")) {
            // True
            if (item != null && item.getType() == Material.RESPAWN_ANCHOR) {
                System.out.println("found RESPAWN ANCHOR");
                event.setCancelled(true);
                event.getWhoClicked().getInventory().removeItem(item);
                Bukkit.broadcastMessage("§bAn stupid guy tried getting respawn anchors.. Oops.. Its gone!");
                Bukkit.broadcastMessage(event.getWhoClicked().getName());
            }
        }
    }
}
