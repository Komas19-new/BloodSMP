/*    */ package komas19.bloodsmp.plugin;
/*    */
/*    */

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/*    */
/*    */ public class CheckUpdate implements CommandExecutor
        /*    */ {
    /*    */   private Blocking main;
    /*    */   static Blocking plugin;
    /*    */
    /*    */   public CheckUpdate(Blocking main)
    /*    */   {
        /* 20 */     plugin = main;
        /*    */   }
    /*    */
    /*    */
    /*    */    public void check() throws IOException {
        String jsonS = "";
        URL url = new URL("https://komas19-new.github.io/BloodSMP/latest-builds.json");
        URLConnection conn = url.openConnection();
        conn.connect();
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;

        while((inputLine = in.readLine()) != null) {
            jsonS+=inputLine;
        }
        Gson gson = new Gson();
        JsonObject jsonObject= gson.fromJson(jsonS, JsonObject.class);
        String versionJson = jsonObject.get("version").getAsString();
        String version = plugin.getPluginMeta().getVersion();
        in.close();

        if (!versionJson.equals(version)) {
            Bukkit.broadcastMessage("New version of Blood SMP has released! Current: "+version+ " Newest: "+versionJson);
        }
    }
    /*    */   public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    /*    */   {
        /* 27 */     Player p = (Player)sender;
        /* 28 */     if (command.getName().equalsIgnoreCase("checkupdate"))
            /*    */     {
            /* 30 */       if (!sender.hasPermission("bloodsmp.checkupdate")) {
                                 p.sendMessage("§c[BLOODSMP] You do not have permission to use this command");

                /* 33 */         return true;
                /*    */       }
            /*    */
            /* 36 */       Plugin plugin = p.getServer().getPluginManager().getPlugin("BloodSMP");
                            @NotNull String ver = plugin.getPluginMeta().getVersion();
                            p.sendMessage("§b[BLOODSMP] Checking for updates... ");
            try {
                check();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            /* 40 */       return true;
            /*    */     }
        /* 42 */     return false;
        /*    */   }

    /*    */ }
