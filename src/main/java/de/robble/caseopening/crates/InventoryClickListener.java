package de.robble.caseopening.crates;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import de.robble.caseopening.utils.DorfkistenGewinneUtil;
import de.robble.caseopening.utils.EnderkistenGewinneUtil;
import de.robble.caseopening.utils.VillagerkisteGewinneUtil;
import de.robble.caseopening.utils.openKistenGUI1;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.UUID;

public class InventoryClickListener implements Listener {

    int NeededCoins;
    String whichChestToGui;

    public static ItemStack getCustomHead(String url) {
        ItemStack is = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) is.getItemMeta();

        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures", url));
        Field field;
        try {
            field = meta.getClass().getDeclaredField("profile");
            field.setAccessible(true);
            field.set(meta, profile);
        }catch (NoSuchFieldException |IllegalAccessException e) {
            e.printStackTrace();
        }

        is.setItemMeta(meta);


        return is;
    }


    @EventHandler
    public void onClick(InventoryClickEvent event){

        Player clicker = (Player) event.getWhoClicked();
        if(event.getView().getTitle().equals("§aKisten")){
            if(event.getCurrentItem() != null) {
                if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§aDorfkiste (")) {
                    if(event.getClick().isRightClick()){
                        DorfkistenGewinneUtil.DKGU(clicker);
                    }
                } else if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§b§lEnderkiste §7(§b ")) {
                    if(event.getClick().isRightClick()){
                        EnderkistenGewinneUtil.EKGU(clicker);
                    }
                } else if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§d§lVillagerkiste §7(§d")) {
                    if(event.getClick().isRightClick()){
                        VillagerkisteGewinneUtil.VKGU(clicker);
                    }
                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§eKisten kaufen")) {
                    Inventory KistenKaufenInv = Bukkit.createInventory(null, 9 * 5, "§bKisten kaufen");
                    ItemStack BackGroundItem = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
                    ItemMeta BackGroundMeta = BackGroundItem.getItemMeta();
                    BackGroundMeta.setDisplayName(" ");
                    BackGroundItem.setItemMeta(BackGroundMeta);

                    KistenKaufenInv.setItem(0, BackGroundItem);
                    KistenKaufenInv.setItem(1, BackGroundItem);
                    KistenKaufenInv.setItem(2, BackGroundItem);
                    KistenKaufenInv.setItem(3, BackGroundItem);
                    KistenKaufenInv.setItem(5, BackGroundItem);
                    KistenKaufenInv.setItem(6, BackGroundItem);
                    KistenKaufenInv.setItem(7, BackGroundItem);
                    KistenKaufenInv.setItem(8, BackGroundItem);
                    KistenKaufenInv.setItem(9, BackGroundItem);
                    KistenKaufenInv.setItem(17, BackGroundItem);
                    KistenKaufenInv.setItem(18, BackGroundItem);
                    KistenKaufenInv.setItem(26, BackGroundItem);
                    KistenKaufenInv.setItem(27, BackGroundItem);
                    KistenKaufenInv.setItem(35, BackGroundItem);
                    KistenKaufenInv.setItem(36, BackGroundItem);
                    KistenKaufenInv.setItem(37, BackGroundItem);
                    KistenKaufenInv.setItem(38, BackGroundItem);
                    KistenKaufenInv.setItem(39, BackGroundItem);
                    KistenKaufenInv.setItem(40, BackGroundItem);
                    KistenKaufenInv.setItem(41, BackGroundItem);
                    KistenKaufenInv.setItem(42, BackGroundItem);
                    KistenKaufenInv.setItem(43, BackGroundItem);
                    KistenKaufenInv.setItem(44, BackGroundItem);

                    ItemStack CoinsAnzahl = new ItemStack(Material.SUNFLOWER, 1);
                    ItemMeta CoinsAnzahlMeta = CoinsAnzahl.getItemMeta();
                    CoinsAnzahlMeta.setDisplayName("§7Du hast aktuell §6" + null + "§7 Coins");
                    CoinsAnzahl.setItemMeta(CoinsAnzahlMeta);
                    KistenKaufenInv.setItem(4, CoinsAnzahl);

                    ItemStack back = InventoryClickListener.getCustomHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjUzNDc0MjNlZTU1ZGFhNzkyMzY2OGZjYTg1ODE5ODVmZjUzODlhNDU0MzUzMjFlZmFkNTM3YWYyM2QifX19");
                    ItemMeta backMeta = back.getItemMeta();
                    backMeta.setDisplayName("§aZurück");
                    back.setItemMeta(backMeta);
                    KistenKaufenInv.setItem(36, back);

                    ItemStack DorfKiste1 = new ItemStack(Material.CHEST, 1);
                    ItemMeta DorfKiste1Meta = DorfKiste1.getItemMeta();
                    DorfKiste1Meta.setDisplayName("§aDorfkiste §7(§61000 Coins&7)");
                    DorfKiste1Meta.setLore(Arrays.asList(""));
                    DorfKiste1Meta.setLore(Arrays.asList("§7Rechtsklicke um “§a1§7” zukaufen"));
                    DorfKiste1.setItemMeta(DorfKiste1Meta);
                    KistenKaufenInv.setItem(11, DorfKiste1);

                    ItemStack DorfKiste5 = new ItemStack(Material.CHEST, 5);
                    ItemMeta DorfKiste5Meta = DorfKiste5.getItemMeta();
                    DorfKiste5Meta.setDisplayName("§aDorfkiste §7(§65000 Coins&7)");
                    DorfKiste5Meta.setLore(Arrays.asList(""));
                    DorfKiste5Meta.setLore(Arrays.asList("§7Rechtsklicke um “§a5§7” zukaufen"));
                    DorfKiste5.setItemMeta(DorfKiste5Meta);
                    KistenKaufenInv.setItem(12, DorfKiste5);

                    ItemStack DorfKiste10 = new ItemStack(Material.CHEST, 10);
                    ItemMeta DorfKiste10Meta = DorfKiste10.getItemMeta();
                    DorfKiste10Meta.setDisplayName("§aDorfkiste §7(§610000 Coins&7)");
                    DorfKiste10Meta.setLore(Arrays.asList(""));
                    DorfKiste10Meta.setLore(Arrays.asList("§7Rechtsklicke um “§a10§7” zukaufen"));
                    DorfKiste10.setItemMeta(DorfKiste10Meta);
                    KistenKaufenInv.setItem(13, DorfKiste10);

                    ItemStack DorfKiste15 = new ItemStack(Material.CHEST, 15);
                    ItemMeta DorfKiste15Meta = DorfKiste15.getItemMeta();
                    DorfKiste15Meta.setDisplayName("§aDorfkiste §7(§615000 Coins&7)");
                    DorfKiste15Meta.setLore(Arrays.asList(""));
                    DorfKiste15Meta.setLore(Arrays.asList("§7Rechtsklicke um “§a15§7” zukaufen"));
                    DorfKiste15.setItemMeta(DorfKiste15Meta);
                    KistenKaufenInv.setItem(14, DorfKiste15);

                    ItemStack DorfKiste25 = new ItemStack(Material.CHEST, 25);
                    ItemMeta DorfKiste25Meta = DorfKiste25.getItemMeta();
                    DorfKiste25Meta.setDisplayName("§aDorfkiste §7(§620000 Coins&7) §c20% Rabatt");
                    DorfKiste25Meta.setLore(Arrays.asList(""));
                    DorfKiste25Meta.setLore(Arrays.asList("§7Rechtsklicke um “§a25§7” zukaufen"));
                    DorfKiste25.setItemMeta(DorfKiste25Meta);
                    KistenKaufenInv.setItem(15, DorfKiste25);

                    ItemStack EnderKiste1 = new ItemStack(Material.ENDER_CHEST, 1);
                    ItemMeta EnderKiste1Meta = EnderKiste1.getItemMeta();
                    EnderKiste1Meta.setDisplayName("§b§lEnderkiste §7(§65000 Coins&7)");
                    EnderKiste1Meta.setLore(Arrays.asList(""));
                    EnderKiste1Meta.setLore(Arrays.asList("§7Rechtsklicke um “§b1§7” zukaufen"));
                    EnderKiste1.setItemMeta(EnderKiste1Meta);
                    KistenKaufenInv.setItem(20, EnderKiste1);

                    ItemStack EnderKiste5 = new ItemStack(Material.ENDER_CHEST, 5);
                    ItemMeta EnderKiste5Meta = EnderKiste5.getItemMeta();
                    EnderKiste5Meta.setDisplayName("§b§lEnderkiste §7(§625000 Coins&7)");
                    EnderKiste5Meta.setLore(Arrays.asList(""));
                    EnderKiste5Meta.setLore(Arrays.asList("§7Rechtsklicke um “§b5§7” zukaufen"));
                    EnderKiste5.setItemMeta(EnderKiste5Meta);
                    KistenKaufenInv.setItem(21, EnderKiste5);

                    ItemStack EnderKiste10 = new ItemStack(Material.ENDER_CHEST, 10);
                    ItemMeta EnderKiste10Meta = EnderKiste10.getItemMeta();
                    EnderKiste10Meta.setDisplayName("§b§lEnderkiste §7(§650000 Coins&7)");
                    EnderKiste10Meta.setLore(Arrays.asList(""));
                    EnderKiste10Meta.setLore(Arrays.asList("§7Rechtsklicke um “§b10§7” zukaufen"));
                    EnderKiste10.setItemMeta(EnderKiste10Meta);
                    KistenKaufenInv.setItem(22, EnderKiste10);

                    ItemStack EnderKiste15 = new ItemStack(Material.ENDER_CHEST, 15);
                    ItemMeta EnderKiste15Meta = EnderKiste15.getItemMeta();
                    EnderKiste15Meta.setDisplayName("§b§lEnderkiste §7(§675000 Coins&7)");
                    EnderKiste15Meta.setLore(Arrays.asList(""));
                    EnderKiste15Meta.setLore(Arrays.asList("§7Rechtsklicke um “§b15§7” zukaufen"));
                    EnderKiste15.setItemMeta(EnderKiste15Meta);
                    KistenKaufenInv.setItem(23, EnderKiste15);

                    ItemStack EnderKiste25 = new ItemStack(Material.ENDER_CHEST, 25);
                    ItemMeta EnderKiste25Meta = EnderKiste15.getItemMeta();
                    EnderKiste25Meta.setDisplayName("§b§lEnderkiste §7(§6100000 Coins§7) §c20% Rabatt");
                    EnderKiste25Meta.setLore(Arrays.asList(""));
                    EnderKiste25Meta.setLore(Arrays.asList("§7Rechtsklicke um “§b25§7” zukaufen"));
                    EnderKiste25.setItemMeta(EnderKiste25Meta);
                    KistenKaufenInv.setItem(24, EnderKiste25);

                    ItemStack Villagerkiste1 = new ItemStack(Material.END_PORTAL_FRAME, 1);
                    ItemMeta Villagerkiste1Meta = Villagerkiste1.getItemMeta();
                    Villagerkiste1Meta.setDisplayName("§d§lVillagerkiste §7(§610000 Coins§7)");
                    Villagerkiste1Meta.setLore(Arrays.asList(""));
                    Villagerkiste1Meta.setLore(Arrays.asList("§7Rechtsklicke um “§b1§7” zukaufen"));
                    Villagerkiste1.setItemMeta(Villagerkiste1Meta);
                    KistenKaufenInv.setItem(29, Villagerkiste1);

                    ItemStack Villagerkiste5 = new ItemStack(Material.END_PORTAL_FRAME, 5);
                    ItemMeta Villagerkiste5Meta = Villagerkiste5.getItemMeta();
                    Villagerkiste5Meta.setDisplayName("§d§lVillagerkiste §7(§650000 Coins§7)");
                    Villagerkiste5Meta.setLore(Arrays.asList(""));
                    Villagerkiste5Meta.setLore(Arrays.asList("§7Rechtsklicke um “§b5§7” zukaufen"));
                    Villagerkiste5.setItemMeta(Villagerkiste5Meta);
                    KistenKaufenInv.setItem(30, Villagerkiste5);

                    ItemStack Villagerkiste10 = new ItemStack(Material.END_PORTAL_FRAME, 10);
                    ItemMeta Villagerkiste10Meta = Villagerkiste10.getItemMeta();
                    Villagerkiste10Meta.setDisplayName("§d§lVillagerkiste §7(§6100000 Coins§7)");
                    Villagerkiste10Meta.setLore(Arrays.asList(""));
                    Villagerkiste10Meta.setLore(Arrays.asList("§7Rechtsklicke um “§b10§7” zukaufen"));
                    Villagerkiste10.setItemMeta(Villagerkiste10Meta);
                    KistenKaufenInv.setItem(31, Villagerkiste10);

                    ItemStack Villagerkiste15 = new ItemStack(Material.END_PORTAL_FRAME, 15);
                    ItemMeta Villagerkiste15Meta = Villagerkiste15.getItemMeta();
                    Villagerkiste15Meta.setDisplayName("§d§lVillagerkiste §7(§6150000 Coins§7)");
                    Villagerkiste15Meta.setLore(Arrays.asList(""));
                    Villagerkiste15Meta.setLore(Arrays.asList("§7Rechtsklicke um “§b15§7” zukaufen"));
                    Villagerkiste15.setItemMeta(Villagerkiste15Meta);
                    KistenKaufenInv.setItem(32, Villagerkiste15);

                    ItemStack Villagerkiste25 = new ItemStack(Material.END_PORTAL_FRAME, 25);
                    ItemMeta Villagerkiste25Meta = Villagerkiste15.getItemMeta();
                    Villagerkiste25Meta.setDisplayName("§d§lVillagerkiste §7(§6200000 Coins§7) §c20% Rabatt");
                    Villagerkiste25Meta.setLore(Arrays.asList(""));
                    Villagerkiste25Meta.setLore(Arrays.asList("§7Rechtsklicke um “§b25§7” zukaufen"));
                    Villagerkiste25.setItemMeta(Villagerkiste25Meta);
                    KistenKaufenInv.setItem(33, Villagerkiste25);

                    clicker.openInventory(KistenKaufenInv);
                }
                event.setCancelled(true);
            }
        }
        else if(event.getView().getTitle().equals("§bKisten kaufen")){
            if(event.getCurrentItem() != null) {
                if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§aZurück")) {
                    event.setCancelled(true);
                    openKistenGUI1.OKG1((Player) event.getWhoClicked());
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().contains("kiste §7")) {
                    String whichchestTemp = event.getCurrentItem().getItemMeta().getDisplayName();
                    event.setCancelled(true);
                    if (whichchestTemp.equals("§aDorfkiste §7(§61000 Coins&7)")) {
                        whichChestToGui = "DK1";
                        NeededCoins = 1000;
                    } else if (whichchestTemp.equals("§aDorfkiste §7(§65000 Coins&7)")) {
                        whichChestToGui = "DK5";
                        NeededCoins = 5000;
                    } else if (whichchestTemp.equals("§aDorfkiste §7(§610000 Coins&7)")) {
                        whichChestToGui = "DK10";
                        NeededCoins = 10000;
                    } else if (whichchestTemp.equals("§aDorfkiste §7(§615000 Coins&7)")) {
                        whichChestToGui = "DK15";
                        NeededCoins = 15000;
                    } else if (whichchestTemp.equals("§aDorfkiste §7(§620000 Coins&7) §c20% Rabatt")) {
                        whichChestToGui = "DK25";
                        NeededCoins = 20000;
                    } else if (whichchestTemp.equals("§b§lEnderkiste §7(§65000 Coins&7)")) {
                        whichChestToGui = "EK1";
                        NeededCoins = 5000;
                    } else if (whichchestTemp.equals("§b§lEnderkiste §7(§625000 Coins&7)")) {
                        whichChestToGui = "EK5";
                        NeededCoins = 25000;
                    } else if (whichchestTemp.equals("§b§lEnderkiste §7(§650000 Coins&7)")) {
                        whichChestToGui = "EK10";
                        NeededCoins = 50000;
                    } else if (whichchestTemp.equals("§b§lEnderkiste §7(§675000 Coins&7)")) {
                        whichChestToGui = "EK15";
                        NeededCoins = 75000;
                    } else if (whichchestTemp.equals("§b§lEnderkiste §7(§6100000 Coins§7) §c20% Rabatt")) {
                        whichChestToGui = "EK25";
                        NeededCoins = 100000;
                    } else if (whichchestTemp.equals("§d§lVillagerkiste §7(§610000 Coins§7)")) {
                        whichChestToGui = "VK1";
                        NeededCoins = 10000;
                    } else if (whichchestTemp.equals("§d§lVillagerkiste §7(§650000 Coins§7)")) {
                        whichChestToGui = "VK5";
                        NeededCoins = 50000;
                    } else if (whichchestTemp.equals("§d§lVillagerkiste §7(§6100000 Coins§7)")) {
                        whichChestToGui = "VK10";
                        NeededCoins = 100000;
                    } else if (whichchestTemp.equals("§d§lVillagerkiste §7(§6150000 Coins§7)")) {
                        whichChestToGui = "VK15";
                        NeededCoins = 150000;
                    } else if (whichchestTemp.equals("§d§lVillagerkiste §7(§6200000 Coins§7) §c20% Rabatt")) {
                        whichChestToGui = "VK25";
                        NeededCoins = 200000;
                    } else {
                        //Fehlermeldung senden wenn whichchestTemp null ist
                        Bukkit.broadcastMessage(clicker.getDisplayName().toUpperCase() + "'S CASE IS INVALID");
                        return;
                    }
                    Inventory buyMenu = Bukkit.createInventory(null, 9 * 5, "§bKauf bestätigen");
                    ItemStack backGroundItem = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
                    ItemMeta backGroundMeta = backGroundItem.getItemMeta();
                    backGroundMeta.setDisplayName(" ");
                    backGroundItem.setItemMeta(backGroundMeta);
                    buyMenu.setItem(0, backGroundItem);
                    buyMenu.setItem(1, backGroundItem);
                    buyMenu.setItem(2, backGroundItem);
                    buyMenu.setItem(3, backGroundItem);
                    buyMenu.setItem(4, backGroundItem);
                    buyMenu.setItem(5, backGroundItem);
                    buyMenu.setItem(6, backGroundItem);
                    buyMenu.setItem(7, backGroundItem);
                    buyMenu.setItem(8, backGroundItem);
                    buyMenu.setItem(9, backGroundItem);
                    buyMenu.setItem(17, backGroundItem);
                    buyMenu.setItem(18, backGroundItem);
                    buyMenu.setItem(26, backGroundItem);
                    buyMenu.setItem(27, backGroundItem);
                    buyMenu.setItem(35, backGroundItem);
                    buyMenu.setItem(36, backGroundItem);
                    buyMenu.setItem(37, backGroundItem);
                    buyMenu.setItem(38, backGroundItem);
                    buyMenu.setItem(39, backGroundItem);
                    buyMenu.setItem(40, backGroundItem);
                    buyMenu.setItem(41, backGroundItem);
                    buyMenu.setItem(42, backGroundItem);
                    buyMenu.setItem(43, backGroundItem);
                    buyMenu.setItem(44, backGroundItem);

                    ItemStack acceptBuy = new ItemStack(Material.LIME_DYE);
                    ItemMeta acceptBuyMeta = acceptBuy.getItemMeta();
                    acceptBuyMeta.setDisplayName("Kauf bestätigen");
                    acceptBuy.setItemMeta(acceptBuyMeta);
                    buyMenu.setItem(22, acceptBuy);

                    clicker.openInventory(buyMenu);
                }
            }
            event.setCancelled(true);
        }
        else if (event.getView().getTitle().equals("§bKauf bestätigen")){
            if(event.getCurrentItem().getItemMeta().getDisplayName().equals("Kauf bestätigen")){
                if(1 < NeededCoins){
                    if(whichChestToGui == "DK1"){}
                    else if(whichChestToGui == "DK5"){}
                    else if(whichChestToGui == "DK10"){}
                    else if(whichChestToGui == "DK15"){}
                    else if(whichChestToGui == "DK25"){}
                    else if(whichChestToGui == "EK1"){}
                    else if(whichChestToGui == "EK5"){}
                    else if(whichChestToGui == "EK10"){}
                    else if(whichChestToGui == "EK15"){}
                    else if(whichChestToGui == "EK25"){}
                    else if(whichChestToGui == "VK1"){}
                    else if(whichChestToGui == "VK5"){}
                    else if(whichChestToGui == "VK10"){}
                    else if(whichChestToGui == "VK15"){}
                    else if(whichChestToGui == "VK25"){}
                    clicker.closeInventory();
                }else {
                    clicker.sendMessage("§4Du hast nicht genug Coins!");
                }
            }
            event.setCancelled(true);
        }
        else if(event.getView().getTitle().equals("§aDorfkisten Gewinne")){
            if(event.getCurrentItem().getItemMeta().getDisplayName().equals("§aZurück")) {
                openKistenGUI1.OKG1(clicker);
            }
            event.setCancelled(true);
        }
        else if(event.getView().getTitle().equals("§b§lEnderkisten Gewinne")){
            if(event.getCurrentItem().getItemMeta().getDisplayName().equals("§aZurück")) {
                openKistenGUI1.OKG1(clicker);
            }
            event.setCancelled(true);
        }
        else if(event.getView().getTitle().equals("§5§lVillagierkiste Gewinne")){
            if(event.getCurrentItem().getItemMeta().getDisplayName().equals("§aZurück")) {
                openKistenGUI1.OKG1(clicker);
            }
            event.setCancelled(true);
        }
    }
}
