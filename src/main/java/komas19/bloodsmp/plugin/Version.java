/*    */ package komas19.bloodsmp.plugin;
/*    */
/*    */

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

/*    */
/*    */ public class Version implements CommandExecutor
        /*    */ {
    /*    */   private Blocking main;
    /*    */   static Blocking plugin;
    /*    */
    /*    */   public Version(Blocking main)
    /*    */   {
        /* 20 */     plugin = main;
        /*    */   }
    /*    */
    /*    */
    /*    */
    /*    */   public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    /*    */   {
        /* 27 */     Player p = (Player)sender;
        /* 28 */     if (command.getName().equalsIgnoreCase("bloodver"))
            /*    */     {
            /* 30 */       if (!sender.hasPermission("bloodsmp.version")) {
                                 p.sendMessage("§c[BLOODSMP] You do not have permission to use this command");

                /* 33 */         return true;
                /*    */       }
            /*    */
            /* 36 */       Plugin plugin = p.getServer().getPluginManager().getPlugin("BloodSMP");
                            p.sendMessage("§b[BLOODSMP] The Version of the Plugin is " + plugin.getPluginMeta().getVersion());
            /* 40 */       return true;
            /*    */     }
        /* 42 */     return false;
        /*    */   }

    /*    */ }
