/*    */ package komas19.bloodsmp.plugin;
/*    */
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.plugin.Plugin;

/*    */
/*    */ public class Reload implements CommandExecutor
        /*    */ {
    /*    */   private Blocking main;
    /*    */   static Blocking plugin;
    /*    */
    /*    */   public Reload(Blocking main)
    /*    */   {
        /* 20 */     plugin = main;
        /*    */   }
    /*    */
    /*    */
    /*    */
    /*    */   public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    /*    */   {
        /* 27 */     Player p = (Player)sender;
        /* 28 */     if (command.getName().equalsIgnoreCase("bloodreload"))
            /*    */     {
            /* 30 */       if (!sender.hasPermission("bloodsmp.reload")) {
                                 p.sendMessage("§c[BLOODSMP] You do not have permission to use this command");
                                 Bukkit.broadcastMessage("§b[BLOODSMP] An stupid guy tried reloading the custom plugin. Lmfao");

                /* 33 */         return true;
                /*    */       }
            /*    */
            /* 36 */       Plugin plugin = p.getServer().getPluginManager().getPlugin("BloodSMP");
            /* 37 */       plugin.reloadConfig();
            /* 38 */       p.getServer().getPluginManager().disablePlugin(plugin);
            /* 39 */       p.getServer().getPluginManager().enablePlugin(plugin);
                           p.sendMessage("§c[BLOODSMP] Reloaded!");
                            Bukkit.broadcastMessage("§b[BLOOODSMP] Plugin has reloaded succesfully!");
            /* 40 */       return true;
            /*    */     }
        /* 42 */     return false;
        /*    */   }

    /*    */ }
