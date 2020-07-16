package fr.alphao.listeners;

import fr.calacraft.calAPI.CalAPI;
import fr.calacraft.calAPI.compatibility.enums.EnumParticle;
import fr.calacraft.calAPI.core.objects.Particles;
import fr.calacraft.calAPI.user.User;
import fr.calacraft.calAPI.utils.TimeUtils;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ItemsListener implements Listener {
    private static final String REGEN_KEY = "custom_effect:regen";
    private static final String REGEN_KEY_2 = "custom_effect:regen2";
    private static final String REGEN_KEY_3 = "custom_effect:regen3";
    private static final String BLAZEGUN = "custom_effect:blazegun";
    private static final String MAGNET = "custom_effect:magnet";
    private static final String DRILL = "custom_effect:drill";

    public List<Entity> getNearbyEntities(Location l, int size) {
        List<Entity> entities = new ArrayList<Entity>();

        for(Entity e : l.getWorld().getEntities())
            if(l.distance(e.getLocation()) <= size)
                entities.add(e);

        return entities;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        User user = CalAPI.getUser(p);
        if (event.getItem() == null) {
            return;
        }
        if(event.getItem().getType() == Material.STICK){
            if (event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Stick of Healing")){
                if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
                    if (user.getInventory().contains(Material.EMERALD)){
                        Long time = user.getFromLocalStorage(REGEN_KEY);
                        if(time != null){
                            int seconds = 60;
                            long timeleft = (time / 1000 + seconds) - (System.currentTimeMillis() / 1000);
                            if(timeleft > 0){
                                user.sendMessage("Il te reste " + TimeUtils.format(timeleft,ChatColor.GREEN) + ChatColor.RESET + " avant de réutiliser " + user.getInventory().getItemInMainHand().getItemMeta().getDisplayName() + ChatColor.RESET + ".");
                                event.setCancelled(true);
                            }
                        } else {
                            new BukkitRunnable(){
                                int count = 0;

                                @Override
                                public void run(){
                                    if(user.getHealth()+0.5 > user.getMaxHealth()){
                                        user.setHealth(user.getMaxHealth());
                                        user.sendMessage(ChatColor.GREEN + "Vie maximale atteinte !");
                                    }else {
                                        user.setHealth(user.getHealth()+0.5);
                                    }
                                    user.sendActionBar(ChatColor.GOLD + "" + count + ChatColor.DARK_GRAY + "x " + "Soin : ["+ ChatColor.GREEN + "+" + ChatColor.WHITE + "0.5" + ChatColor.RED + "❤" + ChatColor.DARK_GRAY + "]");
                                    if(count > 4 ){
                                        this.cancel();
                                    }
                                    count++;
                                }
                            }.runTaskTimer(CalAPI.INSTANCE,0,10);
                            /*Bukkit.getScheduler().runTaskTimer(CalAPI.INSTANCE, () -> {
                            },0,20);*/
                            user.getInventory().removeItem(new ItemStack(Material.EMERALD,1));
                            user.sendMessage("Vous avez été soigné.");
                            new Particles(EnumParticle.HEART,user.getLocation(),1F, 1F, 1F,0.5F,5).sendToAll();
                            user.playSound(user.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 1);
                            user.pushToLocalStorage(REGEN_KEY, System.currentTimeMillis(),60, TimeUnit.SECONDS);
                        }
                    } else {
                        user.sendMessage("Vous n'avez pas assez d'émeraudes.");
                    }
                }
            } else if (event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Wand of Healing")) {
                if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
                    if (user.getInventory().containsAtLeast(new ItemStack(Material.EMERALD),2)){
                        Long time = user.getFromLocalStorage(REGEN_KEY_2);
                        if(time != null){
                            int seconds = 45;
                            long timeleft = (time / 1000 + seconds) - (System.currentTimeMillis() / 1000);
                            if(timeleft > 0){
                                user.sendMessage("Il te reste " + TimeUtils.format(timeleft,ChatColor.GREEN) + ChatColor.RESET + " avant de réutiliser " + user.getInventory().getItemInMainHand().getItemMeta().getDisplayName() + ChatColor.RESET + ".");
                                event.setCancelled(true);
                            }
                        } else {
                            new BukkitRunnable(){
                                int count = 0;

                                @Override
                                public void run(){
                                    if(user.getHealth()+0.75 > user.getMaxHealth()){
                                        user.setHealth(user.getMaxHealth());
                                        user.sendMessage(ChatColor.GREEN + "Vie maximale atteinte !");
                                    }else {
                                        user.setHealth(user.getHealth()+0.75);
                                    }
                                    user.sendActionBar(ChatColor.GOLD + "" + count + ChatColor.DARK_GRAY + "x " + "Soin : ["+ ChatColor.GREEN + "+" + ChatColor.WHITE + "0.75" + ChatColor.RED + "❤" + ChatColor.DARK_GRAY + "]");
                                    if(count > 6 ){
                                        this.cancel();
                                    }
                                    count++;
                                }
                            }.runTaskTimer(CalAPI.INSTANCE,0,10);
                            user.getInventory().removeItem(new ItemStack(Material.EMERALD,2));
                            user.sendMessage("Vous avez été soigné.");
                            new Particles(EnumParticle.HEART,user.getLocation(),1F, 1F, 1F,0.5F,10).sendToAll();
                            user.playSound(user.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 1);
                            user.pushToLocalStorage(REGEN_KEY_2, System.currentTimeMillis(),45, TimeUnit.SECONDS);
                        }
                    } else {
                        user.sendMessage("Vous n'avez pas assez d'émeraudes.");
                    }
                }
            } else if (event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Rod of Healing")) {
                if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
                    if (user.getInventory().containsAtLeast(new ItemStack(Material.EMERALD),5)){
                        Long time = user.getFromLocalStorage(REGEN_KEY_3);
                        if(time != null){
                            int seconds = 30;
                            long timeleft = (time / 1000 + seconds) - (System.currentTimeMillis() / 1000);
                            if(timeleft > 0){
                                user.sendMessage("Il te reste " + TimeUtils.format(timeleft,ChatColor.GREEN) + ChatColor.RESET + " avant de réutiliser " + user.getInventory().getItemInMainHand().getItemMeta().getDisplayName() + ChatColor.RESET + ".");
                                event.setCancelled(true);
                            }
                        } else {
                            new BukkitRunnable(){
                                int count = 0;

                                @Override
                                public void run(){
                                    if(user.getHealth()+1 > user.getMaxHealth()){
                                        user.setHealth(user.getMaxHealth());
                                        user.sendMessage(ChatColor.GREEN + "Vie maximale atteinte !");
                                    }else {
                                        user.setHealth(user.getHealth()+1);
                                    }
                                    user.sendActionBar(ChatColor.GOLD + "" + count + ChatColor.DARK_GRAY + "x " + "Soin : ["+ ChatColor.GREEN + "+" + ChatColor.WHITE + "1" + ChatColor.RED + "❤" + ChatColor.DARK_GRAY + "]");
                                    if(count > 11 ){
                                        this.cancel();
                                    }
                                    count++;
                                }
                            }.runTaskTimer(CalAPI.INSTANCE,0,10);
                            user.getInventory().removeItem(new ItemStack(Material.EMERALD,5));
                            user.sendMessage("Vous avez été soigné.");
                            new Particles(EnumParticle.HEART,user.getLocation(),1F, 1F, 1F,0.5F,15).sendToAll();
                            user.playSound(user.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 1);
                            user.pushToLocalStorage(REGEN_KEY_3, System.currentTimeMillis(),30, TimeUnit.SECONDS);
                        }
                    } else {
                        user.sendMessage("Vous n'avez pas assez d'émeraudes.");
                    }
                }
            } else if (event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Snow Canon")) {
                if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
                    p.launchProjectile(Snowball.class);
                }
            } else if (event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Magnet")) {
                if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
                    if (user.getInventory().containsAtLeast(new ItemStack(Material.CHORUS_FRUIT),3)){
                        Long time = user.getFromLocalStorage(MAGNET);
                        if(time != null){
                            int seconds = 20;
                            long timeleft = (time / 1000 + seconds) - (System.currentTimeMillis() / 1000);
                            if(timeleft > 0){
                                user.sendMessage("Il te reste " + TimeUtils.format(timeleft,ChatColor.GREEN) + ChatColor.RESET + " avant de réutiliser " + user.getInventory().getItemInMainHand().getItemMeta().getDisplayName() + ChatColor.RESET + ".");
                                event.setCancelled(true);
                            }
                        } else {
                            user.getInventory().removeItem(new ItemStack(Material.CHORUS_FRUIT,3));
                            for (Entity e : getNearbyEntities(user.getLocation(), 8)) {
                                if (e == user )
                                    user.sendMessage((e instanceof User ? ((User) e)
                                            .getName() : e.getType().name()));
                            }

                            user.pushToLocalStorage(MAGNET, System.currentTimeMillis(),20, TimeUnit.SECONDS);
                        }
                    } else {
                        user.sendMessage("Vous n'avez pas assez de fruits de chorus.");
                    }
                }
            }
        } else if (event.getItem().getType() == Material.BLAZE_ROD){
            if (event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Blaze Gun")) {
                if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
                    if (user.getInventory().containsAtLeast(new ItemStack(Material.SULPHUR),2)){
                        Long time = user.getFromLocalStorage(BLAZEGUN);
                        if(time != null){
                            int seconds = 10;
                            long timeleft = (time / 1000 + seconds) - (System.currentTimeMillis() / 1000);
                            if(timeleft > 0){
                                user.sendMessage("Il te reste " + TimeUtils.format(timeleft,ChatColor.GREEN) + ChatColor.RESET + " avant de réutiliser " + user.getInventory().getItemInMainHand().getItemMeta().getDisplayName() + ChatColor.RESET + ".");
                                event.setCancelled(true);
                            }
                        } else {
                            user.getInventory().removeItem(new ItemStack(Material.SULPHUR,2));
                            p.launchProjectile(Fireball.class).setVelocity(p.getLocation().getDirection().multiply(0.5));
                            user.pushToLocalStorage(BLAZEGUN, System.currentTimeMillis(),10, TimeUnit.SECONDS);
                        }
                    } else {
                        user.sendMessage("Vous n'avez pas assez de poudres à canon.");
                    }
                }
            }
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player p = event.getPlayer();
        User user = CalAPI.getUser(p);

        if (user.getItemInHand().getType() == Material.FLINT) {
            if (user.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Drill")) {
                if (user.getInventory().containsAtLeast(new ItemStack(Material.IRON_PICKAXE), 1)) {
                    Long time = user.getFromLocalStorage(DRILL);
                    if (time != null) {
                        int seconds = 300;
                        long timeleft = (time / 1000 + seconds) - (System.currentTimeMillis() / 1000);
                        if (timeleft > 0) {
                            user.sendMessage("Il te reste " + TimeUtils.format(timeleft, ChatColor.GREEN) + ChatColor.RESET + " avant de réutiliser " + user.getInventory().getItemInMainHand().getItemMeta().getDisplayName() + ChatColor.RESET + ".");
                            event.setCancelled(true);
                        }
                    } else {
                        user.getInventory().removeItem(new ItemStack(Material.IRON_PICKAXE, 1));

                        Block b = event.getBlock();

                        int x = event.getBlock().getX();
                        int y = event.getBlock().getY();
                        int z = event.getBlock().getZ();
                        World w = p.getLocation().getWorld();

                        for (y = event.getBlock().getY(); y >= 1 ; y--){
                            new Location(w, x, y, z).getBlock().setType(Material.AIR);
                        }

                        user.pushToLocalStorage(DRILL, System.currentTimeMillis(), 300, TimeUnit.SECONDS);
                    }
                } else {
                    user.sendMessage("Vous n'avez pas assez de pioche en fer.");
                }
            }
        }
    }

    @EventHandler
    public void onMultishot(EntityShootBowEvent e) {

        Player p = (Player) e.getEntity();
        User user = CalAPI.getUser(p);
        if(e.getBow().getType() == Material.BOW){
            if (e.getBow().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Multi Bow")){
                if (user.getInventory().contains(Material.EMERALD)){
                    if (e.getEntity() instanceof Player) {
                        final Player player = (Player) e.getEntity();
                        Block b = e.getProjectile().getWorld().getBlockAt(e.getProjectile().getLocation());
                        final Location ploc = player.getLocation();
                        Location bloc = b.getLocation();
                        final Vector v = bloc.toVector().subtract(ploc.toVector());

                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(CalAPI.INSTANCE, new Runnable() {
                            public void run() {
                                Arrow a = player.launchProjectile(Arrow.class);
                                a.setVelocity(player.getLocation().getDirection().multiply(3.5));
                                a.setShooter(player);
                                a.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
                            }
                        }, 10);

                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(CalAPI.INSTANCE, new Runnable() {
                            public void run() {
                                Arrow a = player.launchProjectile(Arrow.class);
                                a.setVelocity(player.getLocation().getDirection().multiply(3.5));
                                //b.getLocation().getWorld().spawnParticle(Particle.FLAME, b.getLocation(), 1, 1, 1, 1);
                                a.setShooter(player);
                                a.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
                            }
                        }, 20);
                    }
                    user.getInventory().removeItem(new ItemStack(Material.EMERALD,1));
                }
                else {
                    user.sendMessage("Vous n'avez pas assez d'émeraude.");
                }
            } else if (e.getBow().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Explosive Bow")) {
                if (user.getInventory().containsAtLeast(new ItemStack(Material.SULPHUR),2)){
                    if (e.getEntity() instanceof Player) {
                        final Player player = (Player) e.getEntity();
                        Block b = e.getProjectile().getWorld().getBlockAt(e.getProjectile().getLocation());
                        final Location ploc = player.getLocation();
                        Location bloc = b.getLocation();
                        e.getProjectile().setMetadata("Explosive", new FixedMetadataValue(CalAPI.INSTANCE,"1"));
                    }
                    user.getInventory().removeItem(new ItemStack(Material.SULPHUR,2));
                } else {
                    user.sendMessage("Vous n'avez pas assez de poudres à canon.");
                }
            }
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onHit(ProjectileHitEvent e) {
        Projectile projectile;
        Location location;

        projectile = e.getEntity();
        if (projectile instanceof Arrow) {
            if (projectile.hasMetadata("Explosive")) {
                location = projectile.getLocation();
                projectile.getWorld().createExplosion(location.getX(), location.getY(), location.getZ(), 4, false, false);
                projectile.remove();
            }
        }
    }
}