package com.ashkiano.fly;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Fly extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        this.getCommand("fly").setExecutor(this);
        Metrics metrics = new Metrics(this, 21926);
        this.getLogger().info("Thank you for using the Fly plugin! If you enjoy using this plugin, please consider making a donation to support the development. You can donate at: https://donate.ashkiano.com");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be used by players.");
            return true;
        }

        Player player = (Player) sender;
        if (!player.hasPermission("fly.use")) {
            player.sendMessage("You do not have permission to use this command.");
            return true;
        }

        boolean flying = player.isFlying();
        player.setFlying(!flying);
        player.setAllowFlight(!flying);
        player.sendMessage("Flying " + (!flying ? "enabled" : "disabled"));
        return true;
    }
}