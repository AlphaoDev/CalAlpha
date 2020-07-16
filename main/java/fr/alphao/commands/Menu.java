package fr.alphao.commands;

import fr.calacraft.calAPI.compatibility.enums.EnumParticle;
import fr.calacraft.calAPI.core.MessagesManager;
import fr.calacraft.calAPI.core.command.enums.CommandAttribute;
import fr.calacraft.calAPI.core.command.objects.CalaCommand;
import fr.calacraft.calAPI.core.objects.Enchant;
import fr.calacraft.calAPI.core.objects.Particles;
import fr.calacraft.calAPI.core.ui.CalaMenu;
import fr.calacraft.calAPI.core.ui.elements.UiButton;
import fr.calacraft.calAPI.core.ui.elements.UiCloser;
import fr.calacraft.calAPI.core.ui.elements.UiElement;
import fr.calacraft.calAPI.core.ui.elements.UiItem;
import fr.calacraft.calAPI.user.User;
import fr.calacraft.calAPI.utils.ItemBuilder;
import fr.calacraft.calAPI.utils.NumberUtils;
import net.minecraft.server.v1_12_R1.Items;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Menu extends CalaCommand {

    public Menu(){
        super(
                "rp",
                CommandAttribute.PLAYER_ONLY
        );
    }

    @Override
    public void command(CommandSender sender, Command cmd, String label, String[] args) {

            User user = (User) sender;
            String bold = ChatColor.BOLD + "";
            Inventory inv = Bukkit.createInventory(null, 54, ChatColor.GRAY + bold + "Menu des armes RP");

            ItemStack typewand = ItemBuilder.titleAndLore(
                    new ItemStack(Material.STICK),
                    ChatColor.DARK_GRAY + "Type : " + ChatColor.BLUE + bold + "Wand"
            );
            typewand.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1);

            ItemStack wand1 = ItemBuilder.titleAndLore(
                    new ItemStack(Material.STICK),
                    ChatColor.GOLD + "Stick of Healing",
                    ChatColor.GRAY + "=======================",
                    ChatColor.DARK_GRAY + "Type : " + ChatColor.BLUE + "Wand",
                    ChatColor.DARK_GRAY + "Coût : " + ChatColor.GREEN + "1 émeraude",
                    ChatColor.DARK_GRAY + "Cooldown : " + ChatColor.GOLD + "1 min",
                    ChatColor.DARK_GRAY + "Durée : " + ChatColor.AQUA + "3 sec",
                    ChatColor.BLUE + "",
                    ChatColor.GOLD + "Habilité " + ChatColor.YELLOW + bold + "CLIC DROIT",
                    ChatColor.GRAY + "Ce bâton vous regénère",
                    ChatColor.GRAY + "1.5x plus rapidement",
                    ChatColor.GRAY + "======================="
            );
            ItemMeta metawand1 = wand1.getItemMeta();
            metawand1.spigot().setUnbreakable(true);

            ItemStack wand2 = ItemBuilder.titleAndLore(
                    new ItemStack(Material.STICK),
                    ChatColor.GOLD + "Wand of Healing",
                    ChatColor.GRAY + "=======================",
                    ChatColor.DARK_GRAY + "Type : " + ChatColor.BLUE + "Wand",
                    ChatColor.DARK_GRAY + "Coût : " + ChatColor.GREEN + "2 émeraudes",
                    ChatColor.DARK_GRAY + "Cooldown : " + ChatColor.GOLD + "45 sec",
                    ChatColor.DARK_GRAY + "Durée : " + ChatColor.AQUA + "5 sec",
                    ChatColor.BLUE + "",
                    ChatColor.GOLD + "Habilité " + ChatColor.YELLOW + bold + "CLIC DROIT",
                    ChatColor.GRAY + "Ce bâton vous regénère",
                    ChatColor.GRAY + "2x plus rapidement",
                    ChatColor.GRAY + "======================="
            );
            ItemMeta metawand2 = wand2.getItemMeta();
            metawand2.spigot().setUnbreakable(true);

            ItemStack wand3 = ItemBuilder.titleAndLore(
                    new ItemStack(Material.STICK),
                    ChatColor.GOLD + "Rod of Healing",
                    ChatColor.GRAY + "=======================",
                    ChatColor.DARK_GRAY + "Type : " + ChatColor.BLUE + "Wand",
                    ChatColor.DARK_GRAY + "Coût : " + ChatColor.GREEN + "5 émeraudes",
                    ChatColor.DARK_GRAY + "Cooldown : " + ChatColor.GOLD + "30 sec",
                    ChatColor.DARK_GRAY + "Durée : " + ChatColor.AQUA + "10 sec",
                    ChatColor.BLUE + "",
                    ChatColor.GOLD + "Habilité " + ChatColor.YELLOW + bold + "CLIC DROIT",
                    ChatColor.GRAY + "Ce bâton vous regénère",
                    ChatColor.GRAY + "3x plus rapidement",
                    ChatColor.GRAY + "======================="
            );
            ItemMeta metawand3 = wand3.getItemMeta();
            metawand3.spigot().setUnbreakable(true);

            ItemStack typebow = ItemBuilder.titleAndLore(
                    new ItemStack(Material.BOW),
                    ChatColor.DARK_GRAY + "Type : " + ChatColor.AQUA + bold + "Bow"
            );
            typebow.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1);

            ItemStack bow1 = ItemBuilder.titleAndLore(
                    new ItemStack(Material.BOW),
                    ChatColor.GOLD + "Multi Bow",
                    ChatColor.GRAY + "=======================",
                    ChatColor.DARK_GRAY + "Type : " + ChatColor.AQUA + "Bow",
                    ChatColor.DARK_GRAY + "Coût : " + ChatColor.GREEN + "1 émeraude",
                    ChatColor.BLUE + "",
                    ChatColor.GOLD + "Habilité " + ChatColor.YELLOW + bold + "TIRER",
                    ChatColor.GRAY + "Cet arc tire 3 flèches",
                    ChatColor.GRAY + "à la place d'une seule",
                    ChatColor.GRAY + "à la suite",
                    ChatColor.GRAY + "======================="
            );
            ItemMeta metabow1 = bow1.getItemMeta();
            metabow1.spigot().setUnbreakable(true);

            ItemStack bow2 = ItemBuilder.titleAndLore(
                    new ItemStack(Material.BOW),
                    ChatColor.GOLD + "Titan Bow",
                    ChatColor.GRAY + "=======================",
                    ChatColor.DARK_GRAY + "Type : " + ChatColor.AQUA + "Bow",
                    ChatColor.DARK_GRAY + "Coût : " + ChatColor.GREEN + "2 émeraudes",
                    ChatColor.BLUE + "",
                    ChatColor.GOLD + "Habilité " + ChatColor.YELLOW + bold + "TIRER",
                    ChatColor.GRAY + "Cet arc tire 4 flèches",
                    ChatColor.GRAY + "à la place d'une seule",
                    ChatColor.GRAY + "en même temps",
                    ChatColor.GRAY + "======================="
            );
            ItemMeta metabow2 = bow2.getItemMeta();
            metabow2.spigot().setUnbreakable(true);

            ItemStack bow3 = ItemBuilder.titleAndLore(
                    new ItemStack(Material.BOW),
                    ChatColor.GOLD + "Explosive Bow",
                    ChatColor.GRAY + "=======================",
                    ChatColor.DARK_GRAY + "Type : " + ChatColor.AQUA + "Bow",
                    ChatColor.DARK_GRAY + "Coût : " + ChatColor.GREEN + "2 poudres à canon",
                    ChatColor.BLUE + "",
                    ChatColor.GOLD + "Habilité " + ChatColor.YELLOW + bold + "TIRER",
                    ChatColor.GRAY + "Cet arc tire crée",
                    ChatColor.GRAY + "une explosion au",
                    ChatColor.GRAY + "moment de l'impact",
                    ChatColor.GRAY + "======================="
            );
            ItemMeta metabow3 = bow3.getItemMeta();
            metabow3.spigot().setUnbreakable(true);

            ItemStack bow4 = ItemBuilder.titleAndLore(
                    new ItemStack(Material.BOW),
                    ChatColor.GOLD + "Speed Bow",
                    ChatColor.GRAY + "=======================",
                    ChatColor.DARK_GRAY + "Type : " + ChatColor.AQUA + "Bow",
                    ChatColor.DARK_GRAY + "Coût : " + ChatColor.GREEN + "1 canne à sucre",
                    ChatColor.BLUE + "",
                    ChatColor.GOLD + "Habilité " + ChatColor.YELLOW + bold + "TIRER",
                    ChatColor.GRAY + "Cet arc tire 2x",
                    ChatColor.GRAY + "plus rapidement",
                    ChatColor.GRAY + "une la flèche",
                    ChatColor.GRAY + "======================="
            );
            ItemMeta metabow4 = bow4.getItemMeta();
            metabow4.spigot().setUnbreakable(true);

            ItemStack typespecial = ItemBuilder.titleAndLore(
                    new ItemStack(Material.DIAMOND_HOE),
                    ChatColor.DARK_GRAY + "Type : " + ChatColor.DARK_GREEN + bold + "Special"
            );
            typespecial.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1);

            ItemStack snowcanon = ItemBuilder.titleAndLore(
                    new ItemStack(Material.STICK),
                    ChatColor.GOLD + "Snow Canon",
                    ChatColor.GRAY + "=======================",
                    ChatColor.DARK_GRAY + "Type : " + ChatColor.DARK_GREEN + "Special",
                    ChatColor.BLUE + "",
                    ChatColor.GOLD + "Habilité " + ChatColor.YELLOW + bold + "CLIC DROIT",
                    ChatColor.GRAY + "Ce canon tire",
                    ChatColor.GRAY + "simplement des",
                    ChatColor.GRAY + "boules de neige",
                    ChatColor.GRAY + "======================="
            );
            ItemMeta metasnowcanon = snowcanon.getItemMeta();
            metasnowcanon.spigot().setUnbreakable(true);

            ItemStack blazegun = ItemBuilder.titleAndLore(
                    new ItemStack(Material.BLAZE_ROD),
                    ChatColor.GOLD + "Blaze Gun",
                    ChatColor.GRAY + "=======================",
                    ChatColor.DARK_GRAY + "Type : " + ChatColor.DARK_GREEN + "Special",
                    ChatColor.DARK_GRAY + "Coût : " + ChatColor.GREEN + "2 poudres à canon",
                    ChatColor.DARK_GRAY + "Cooldown : " + ChatColor.GOLD + "10 sec",
                    ChatColor.BLUE + "",
                    ChatColor.GOLD + "Habilité " + ChatColor.YELLOW + bold + "CLIC DROIT",
                    ChatColor.GRAY + "Cet item lance",
                    ChatColor.GRAY + "des boules de feu",
                    ChatColor.GRAY + "comme les Blazes",
                    ChatColor.GRAY + "======================="
            );
            ItemMeta metablazegun = blazegun.getItemMeta();
            metablazegun.spigot().setUnbreakable(true);

            ItemStack magnet = ItemBuilder.titleAndLore(
                    new ItemStack(Material.STICK),
                    ChatColor.GOLD + "Magnet",
                    ChatColor.GRAY + "=======================",
                    ChatColor.DARK_GRAY + "Type : " + ChatColor.DARK_GREEN + "Special",
                    ChatColor.DARK_GRAY + "Coût : " + ChatColor.GREEN + "3 fruits de chorus",
                    ChatColor.DARK_GRAY + "Cooldown : " + ChatColor.GOLD + "20 sec",
                    ChatColor.BLUE + "",
                    ChatColor.GOLD + "Habilité " + ChatColor.YELLOW + bold + "CLIC DROIT",
                    ChatColor.GRAY + "Cet item téléporte",
                    ChatColor.GRAY + "les mobs dans un",
                    ChatColor.GRAY + "rayon de 8 blocs",
                    ChatColor.GRAY + "======================="
            );
            ItemMeta metamagnet = magnet.getItemMeta();
            metamagnet.spigot().setUnbreakable(true);

            ItemStack drill = ItemBuilder.titleAndLore(
                    new ItemStack(Material.FLINT),
                    ChatColor.GOLD + "Drill",
                    ChatColor.GREEN + "Prix : 10 000$",
                    ChatColor.GRAY + "=======================",
                    ChatColor.DARK_GRAY + "Type : " + ChatColor.DARK_GREEN + "Special",
                    ChatColor.DARK_GRAY + "Coût : " + ChatColor.GREEN + "1 pioche en fer",
                    ChatColor.DARK_GRAY + "Cooldown : " + ChatColor.GOLD + "5 min",
                    ChatColor.BLUE + "",
                    ChatColor.GOLD + "Habilité " + ChatColor.YELLOW + bold + "CLIC DROIT",
                    ChatColor.GRAY + "Cet item creuse",
                    ChatColor.GRAY + "en dessous du bloc miné",
                    ChatColor.GRAY + "jusqu’à la bedrock",
                    ChatColor.GRAY + "======================="
            );
            ItemMeta metadrill = drill.getItemMeta();
            metadrill.spigot().setUnbreakable(true);


            ItemStack delimiter = ItemBuilder.titleAndLore(
                    new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 7),
                    " "
            );

            ItemStack leave = ItemBuilder.titleAndLore(
                    new ItemStack(Material.BARRIER),
                    ChatColor.RED + "Quitter le menu"
            );

            CalaMenu menu = new CalaMenu(ChatColor.GRAY + bold + "Menu des armes RP",6);
            menu.setElement(43, new UiCloser(leave));
            menu.setElement(10, new UiElement(typewand));
            menu.setElement(19, new UiElement(typebow));
            menu.setElement(28, new UiElement(typespecial));
            menu.setElement(11, new UiElement(delimiter));
            menu.setElement(20, new UiElement(delimiter));
            menu.setElement(29, new UiElement(delimiter));
            menu.setElement(38, new UiElement(delimiter));
            menu.setElement(12, new UiButton(wand1,(target)->{
                target.giveItems(wand1.clone());
                target.playSound(user.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 1);
            }));
            menu.setElement(13, new UiButton(wand2,(target)->{
                    target.giveItems(wand2.clone());
                    target.playSound(user.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 1);
            }));
            menu.setElement(14, new UiButton(wand3,(target)->{
                    target.giveItems(wand3.clone());
                    target.playSound(user.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 1);
            }));
            menu.setElement(21, new UiButton(bow1,(target)->{
                    target.giveItems(bow1.clone());
                    target.playSound(user.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 1);
            }));
            menu.setElement(22, new UiButton(bow2,(target)->{
                    target.giveItems(bow2.clone());
                    target.playSound(user.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 1);
            }));
            menu.setElement(23, new UiButton(bow3,(target)->{
                    target.giveItems(bow3.clone());
                    target.playSound(user.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 1);
            }));
            menu.setElement(24, new UiButton(bow4,(target)->{
                    target.giveItems(bow4.clone());
                    target.playSound(user.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 1);
            }));
            menu.setElement(30, new UiButton(snowcanon,(target)->{
                    target.giveItems(snowcanon.clone());
                    target.playSound(user.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 1);
            }));
            menu.setElement(31, new UiButton(blazegun,(target)->{
                    target.giveItems(blazegun.clone());
                    target.playSound(user.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 1);
            }));
            menu.setElement(32, new UiButton(magnet,(target)->{
                    target.giveItems(magnet.clone());
                    target.playSound(user.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 1);
            }));
            menu.setElement(33, new UiButton(drill,(target)->{
                    if (target.hasMoney(10000)) {
                            target.giveItems(drill.clone());
                            target.playSound(user.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 1);
                            target.removeMoney(10000);
                    } else {
                            user.sendMessage(MessagesManager.createPrefix("Money") + "Vous n'avez pas assez d'argent !");
                            user.sendMessage(MessagesManager.createPrefix("Items") + "Il vous manque §a" + NumberUtils.format(10000 - user.getDoubleMoney()) + "$ §7pour acheter §aDrill" + "§7.");
                    }
            }));
            menu.withBorders();
            user.openInventory(menu.getInventory());
    }
}