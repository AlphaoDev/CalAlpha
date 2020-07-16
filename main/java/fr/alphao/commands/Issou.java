package fr.alphao.commands;

import fr.calacraft.calAPI.CalAPI;
import fr.calacraft.calAPI.core.command.enums.CommandAttribute;
import fr.calacraft.calAPI.core.command.objects.CalaCommand;
import fr.calacraft.calAPI.user.User;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;

public class Issou  extends CalaCommand {
    public Issou(){
        super(
                "issou",
                CommandAttribute.PLAYER_ONLY
        );
    }

    @Override
    public void command(CommandSender sender, Command cmd, String label, String[] args) {
        User user = (User) sender;
        new BukkitRunnable(){
            int count = 0;
            int colorindex = 0;
            String message = "issou";
            @Override
            public void run(){
                if(count > 100){
                    this.cancel();
                    return;
                }
                count++;
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < message.length(); i++){
                    ChatColor color = ChatColor.values()[colorindex];
                    while(!color.isColor()){
                        if (colorindex >= ChatColor.values().length){
                            colorindex = 0;
                        } else {
                            colorindex++;
                        }
                    }
                    builder.append(color).append(message.charAt(i));
                }
                user.sendTitle(builder.toString(),builder.toString());
            }
        }.runTaskTimer(CalAPI.INSTANCE,0,1);
    }
}
