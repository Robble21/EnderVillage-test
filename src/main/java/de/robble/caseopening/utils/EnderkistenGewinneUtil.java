package de.robble.caseopening.utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.UUID;

public class EnderkistenGewinneUtil {
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

    public static void EKGU(Player player){
        Inventory EKGI = Bukkit.createInventory(null, 9*5, "§b§lEnderkisten Gewinne");
        ItemStack BackGroundItem = new ItemStack(Material.BLACK_STAINED_GLASS_PANE,1);
        ItemMeta BackGroundMeta = BackGroundItem.getItemMeta();
        BackGroundMeta.setDisplayName(" ");
        BackGroundItem.setItemMeta(BackGroundMeta);

        EKGI.setItem(0, BackGroundItem);
        EKGI.setItem(1, BackGroundItem);
        EKGI.setItem(2, BackGroundItem);
        EKGI.setItem(3, BackGroundItem);
        EKGI.setItem(4, BackGroundItem);
        EKGI.setItem(5, BackGroundItem);
        EKGI.setItem(6, BackGroundItem);
        EKGI.setItem(7, BackGroundItem);
        EKGI.setItem(8, BackGroundItem);
        EKGI.setItem(9, BackGroundItem);
        EKGI.setItem(17, BackGroundItem);
        EKGI.setItem(18, BackGroundItem);
        EKGI.setItem(26, BackGroundItem);
        EKGI.setItem(27, BackGroundItem);
        EKGI.setItem(35, BackGroundItem);
        EKGI.setItem(37, BackGroundItem);
        EKGI.setItem(38, BackGroundItem);
        EKGI.setItem(39, BackGroundItem);
        EKGI.setItem(40, BackGroundItem);
        EKGI.setItem(41, BackGroundItem);
        EKGI.setItem(42, BackGroundItem);
        EKGI.setItem(43, BackGroundItem);
        EKGI.setItem(44, BackGroundItem);

        ItemStack back = getCustomHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjUzNDc0MjNlZTU1ZGFhNzkyMzY2OGZjYTg1ODE5ODVmZjUzODlhNDU0MzUzMjFlZmFkNTM3YWYyM2QifX19");
        ItemMeta backMeta = back.getItemMeta();
        backMeta.setDisplayName("§aZurück");
        back.setItemMeta(backMeta);
        EKGI.setItem(36, back);

        ItemStack EnderPlusGewinn = new ItemStack(Material.GOLDEN_CHESTPLATE,1);
        ItemMeta EnderPlusGMeta = EnderPlusGewinn.getItemMeta();
        EnderPlusGMeta.setDisplayName("§6Ender§a+ §6Rang");
        EnderPlusGewinn.setItemMeta(EnderPlusGMeta);
        EKGI.setItem(10, EnderPlusGewinn);

        ItemStack EnderRankGewinn = new ItemStack(Material.DIAMOND_CHESTPLATE,1);
        ItemMeta EnderRankGMeta = EnderRankGewinn.getItemMeta();
        EnderRankGMeta.setDisplayName("§bEnder Rang §7(30 Tage§7)");
        EnderRankGewinn.setItemMeta(EnderRankGMeta);
        EKGI.setItem(11, EnderRankGewinn);

        ItemStack DoppelsprungGewinn = new ItemStack(Material.FEATHER,1);
        ItemMeta DoppelsprungGMeta = DoppelsprungGewinn.getItemMeta();
        DoppelsprungGMeta.setDisplayName("Doppelsprung");
        DoppelsprungGMeta.setLore(Arrays.asList());
        DoppelsprungGMeta.setLore(Arrays.asList("Mit diesem Feature kannst du Doppelsprung in der Lobby benutzen "));
        DoppelsprungGMeta.setLore(Arrays.asList());
        DoppelsprungGewinn.setItemMeta(DoppelsprungGMeta);
        EKGI.setItem(12, DoppelsprungGewinn);

        ItemStack Villagerkiste2Gewinn = new ItemStack(Material.END_PORTAL_FRAME,2);
        ItemMeta Villagerkiste2GMeta = Villagerkiste2Gewinn.getItemMeta();
        Villagerkiste2GMeta.setDisplayName("§d2x §d§lVillagerkiste");
        Villagerkiste2Gewinn.setItemMeta(Villagerkiste2GMeta);
        EKGI.setItem(13, Villagerkiste2Gewinn);

        ItemStack Coins10000Gewinn = new ItemStack(Material.GOLD_INGOT,1);
        ItemMeta Coins10000 = Coins10000Gewinn.getItemMeta();
        Coins10000.setDisplayName("§610.000 Coins");
        Coins10000Gewinn.setItemMeta(Coins10000);
        EKGI.setItem(14, Coins10000Gewinn);

        ItemStack Enderkisten2Gewinn = new ItemStack(Material.ENDER_CHEST,2);
        ItemMeta Enderkisten2GMeta = Enderkisten2Gewinn.getItemMeta();
        Enderkisten2GMeta.setDisplayName("§d2x §b§lEnderkisten");
        Enderkisten2Gewinn.setItemMeta(Enderkisten2GMeta);
        EKGI.setItem(15, Enderkisten2Gewinn);

        ItemStack PrivateS20Gewinn = new ItemStack(Material.COMMAND_BLOCK,20);
        ItemMeta PrivateS20GMeta = PrivateS20Gewinn.getItemMeta();
        PrivateS20GMeta.setDisplayName("§d20x §bPrivate Server Token");
        PrivateS20Gewinn.setItemMeta(PrivateS20GMeta);
        EKGI.setItem(16, PrivateS20Gewinn);

        ItemStack Coins5000Gewinn = new ItemStack(Material.GOLD_NUGGET,1);
        ItemMeta Coins5000GMeta = Coins5000Gewinn.getItemMeta();
        Coins5000GMeta.setDisplayName("§65.000 Coins");
        Coins5000Gewinn.setItemMeta(Coins5000GMeta);
        EKGI.setItem(19, Coins5000Gewinn);

        ItemStack LilaOutfitGewinn = new ItemStack(Material.LEATHER_CHESTPLATE,1);
        LeatherArmorMeta LilaOutfitGMeta = (LeatherArmorMeta) LilaOutfitGewinn.getItemMeta();
        LilaOutfitGMeta.setDisplayName("§dLila Outfit");
        LilaOutfitGMeta.setLore(Arrays.asList(" "));
        LilaOutfitGMeta.setLore(Arrays.asList("§dLila Chestplate"));
        LilaOutfitGMeta.setLore(Arrays.asList("§dLila Leggings"));
        LilaOutfitGMeta.setLore(Arrays.asList("§dLila Boots"));
        LilaOutfitGMeta.setLore(Arrays.asList(" "));
        LilaOutfitGMeta.setColor(Color.PURPLE);
        LilaOutfitGewinn.setItemMeta(LilaOutfitGMeta);
        EKGI.setItem(20, LilaOutfitGewinn);

        ItemStack OrangesOutfitGewinn = new ItemStack(Material.LEATHER_CHESTPLATE,1);
        LeatherArmorMeta OrangesOutfitGMeta = (LeatherArmorMeta) OrangesOutfitGewinn.getItemMeta();
        OrangesOutfitGMeta.setDisplayName("Oranges Outfit");
        OrangesOutfitGMeta.setLore(Arrays.asList(" "));
        OrangesOutfitGMeta.setLore(Arrays.asList("§6Orange Chestplate"));
        OrangesOutfitGMeta.setLore(Arrays.asList("§6Orange Leggings"));
        OrangesOutfitGMeta.setLore(Arrays.asList("§6Orange Boots"));
        OrangesOutfitGMeta.setLore(Arrays.asList(" "));
        OrangesOutfitGMeta.setColor(Color.ORANGE);
        OrangesOutfitGewinn.setItemMeta(OrangesOutfitGMeta);
        EKGI.setItem(21, OrangesOutfitGewinn);

        ItemStack HellgrunesOutfitGewinn = new ItemStack(Material.LEATHER_CHESTPLATE,1);
        LeatherArmorMeta HellgrunesOutfitGMeta = (LeatherArmorMeta) HellgrunesOutfitGewinn.getItemMeta();
        HellgrunesOutfitGMeta.setDisplayName("Hellgrünes Outfit");
        HellgrunesOutfitGMeta.setLore(Arrays.asList(" "));
        HellgrunesOutfitGMeta.setLore(Arrays.asList("§aHellgrüne Chestplate"));
        HellgrunesOutfitGMeta.setLore(Arrays.asList("§aHellgrüne Leggings"));
        HellgrunesOutfitGMeta.setLore(Arrays.asList("§aHellgrüne Boots"));
        HellgrunesOutfitGMeta.setLore(Arrays.asList(" "));
        HellgrunesOutfitGMeta.setColor(Color.LIME);
        HellgrunesOutfitGewinn.setItemMeta(HellgrunesOutfitGMeta);
        EKGI.setItem(22, HellgrunesOutfitGewinn);

        ItemStack BraunesOutfitGewinn = new ItemStack(Material.LEATHER_CHESTPLATE,1);
        LeatherArmorMeta BraunesOutfitGMeta = (LeatherArmorMeta) BraunesOutfitGewinn.getItemMeta();
        BraunesOutfitGMeta.setDisplayName("Braunes Outfit");
        BraunesOutfitGMeta.setLore(Arrays.asList(" "));
        BraunesOutfitGMeta.setLore(Arrays.asList("Braune Chestplate"));
        BraunesOutfitGMeta.setLore(Arrays.asList("Braune Leggings"));
        BraunesOutfitGMeta.setLore(Arrays.asList("Braune Boots"));
        BraunesOutfitGMeta.setLore(Arrays.asList(" "));
        BraunesOutfitGMeta.setColor(Color.fromRGB(132, 93, 0));
        BraunesOutfitGewinn.setItemMeta(BraunesOutfitGMeta);
        EKGI.setItem(23, BraunesOutfitGewinn);

        ItemStack AxolotelPetGewinn = new ItemStack(Material.AXOLOTL_SPAWN_EGG,1);
        ItemMeta AxolotelPetGMeta = AxolotelPetGewinn.getItemMeta();
        AxolotelPetGMeta.setDisplayName("§d§lAxolotel Pet");
        AxolotelPetGewinn.setItemMeta(AxolotelPetGMeta);
        EKGI.setItem(24, AxolotelPetGewinn);

        ItemStack PilzkuhPetGewinn = new ItemStack(Material.MOOSHROOM_SPAWN_EGG,1);
        ItemMeta PilzkuhPetGMeta = PilzkuhPetGewinn.getItemMeta();
        PilzkuhPetGMeta.setDisplayName("§cP§4i§cl§4z§ck§4u§ch §4P§ce§4p");
        PilzkuhPetGewinn.setItemMeta(PilzkuhPetGMeta);
        EKGI.setItem(25, PilzkuhPetGewinn);

        player.openInventory(EKGI);
    }
}
