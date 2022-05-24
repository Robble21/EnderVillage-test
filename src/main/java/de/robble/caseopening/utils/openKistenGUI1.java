package de.robble.caseopening.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class openKistenGUI1 {
    public static void OKG1(Player sender){
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("endervillageperks.create.op")) {
                Inventory create1 = Bukkit.createInventory(null, 9 * 5, "§aKisten");
                ItemStack BackGroundItem = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
                ItemMeta BackGroundMeta = BackGroundItem.getItemMeta();
                BackGroundMeta.setDisplayName(" ");
                BackGroundItem.setItemMeta(BackGroundMeta);
                create1.setItem(0, BackGroundItem);
                create1.setItem(1, BackGroundItem);
                create1.setItem(2, BackGroundItem);
                create1.setItem(3, BackGroundItem);
                create1.setItem(4, BackGroundItem);
                create1.setItem(5, BackGroundItem);
                create1.setItem(6, BackGroundItem);
                create1.setItem(7, BackGroundItem);
                create1.setItem(8, BackGroundItem);
                create1.setItem(9, BackGroundItem);
                create1.setItem(17, BackGroundItem);
                create1.setItem(18, BackGroundItem);
                create1.setItem(26, BackGroundItem);
                create1.setItem(27, BackGroundItem);
                create1.setItem(35, BackGroundItem);
                create1.setItem(36, BackGroundItem);
                create1.setItem(37, BackGroundItem);
                create1.setItem(38, BackGroundItem);
                create1.setItem(39, BackGroundItem);
                create1.setItem(41, BackGroundItem);
                create1.setItem(42, BackGroundItem);
                create1.setItem(43, BackGroundItem);
                create1.setItem(44, BackGroundItem);
                ItemStack Dorfkiste = new ItemStack(Material.CHEST, 1);
                ItemMeta DorfKisteMeta = Dorfkiste.getItemMeta();
                DorfKisteMeta.setDisplayName("§aDorfkiste (§a" + null + ")");
                DorfKisteMeta.setLore(Arrays.asList(""));
                DorfKisteMeta.setLore(Arrays.asList("§7Rechtsklicke um die Truhe zu öffnen"));
                DorfKisteMeta.setLore(Arrays.asList("§7Linksklicke um die Gewinne anzuzeigen"));
                Dorfkiste.setItemMeta(DorfKisteMeta);
                create1.setItem(20, Dorfkiste);
                ItemStack Enderkiste = new ItemStack(Material.ENDER_CHEST, 1);
                ItemMeta EnderkisteMeta = Enderkiste.getItemMeta();
                EnderkisteMeta.setDisplayName("§b§lEnderkiste §7(§b " + null + "§7)");
                EnderkisteMeta.setLore(Arrays.asList(""));
                EnderkisteMeta.setLore(Arrays.asList("§7Rechtsklicke um die Truhe zu öffnen"));
                EnderkisteMeta.setLore(Arrays.asList("§7Linksklicke um die Gewinne anzuzeigen"));
                Enderkiste.setItemMeta(EnderkisteMeta);
                create1.setItem(22, Enderkiste);
                ItemStack Villagerkiste = new ItemStack(Material.END_PORTAL_FRAME);
                ItemMeta VillagerkisteMeta = Villagerkiste.getItemMeta();
                VillagerkisteMeta.setDisplayName("§d§lVillagerkiste §7(§d " + null + "§7)");
                VillagerkisteMeta.setLore(Arrays.asList(""));
                VillagerkisteMeta.setLore(Arrays.asList("§7Rechtsklicke um die Truhe zu öffnen"));
                VillagerkisteMeta.setLore(Arrays.asList("§7Linksklicke um die Gewinne anzuzeigen"));
                Villagerkiste.setItemMeta(VillagerkisteMeta);
                create1.setItem(24, Villagerkiste);
                ItemStack kistenKaufen = new ItemStack(Material.GOLD_BLOCK);
                ItemMeta kistenKaufenMeta = kistenKaufen.getItemMeta();
                kistenKaufenMeta.setDisplayName("§eKisten kaufen");
                kistenKaufenMeta.setLore(Arrays.asList(""));
                kistenKaufenMeta.setLore(Arrays.asList("§7Rechtsklicke um Kisten zu kaufen"));
                kistenKaufen.setItemMeta(kistenKaufenMeta);
                create1.setItem(40, kistenKaufen);
                player.openInventory(create1);
            } else {
                player.sendMessage("§4Du hast leider keine rechte, bitte informiere dich bei einer der Admins (oder bei Robble, der das ganze gecodet hat xd)");
            }
        }
    }
}
