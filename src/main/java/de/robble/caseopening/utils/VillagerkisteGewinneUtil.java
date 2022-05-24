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

public class VillagerkisteGewinneUtil {
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

    public static void VKGU(Player player){
        Inventory VKGI = Bukkit.createInventory(null, 9*5, "§5§lVillagierkiste Gewinne");
        ItemStack BackGroundItem = new ItemStack(Material.BLACK_STAINED_GLASS_PANE,1);
        ItemMeta BackGroundMeta = BackGroundItem.getItemMeta();
        BackGroundMeta.setDisplayName(" ");
        BackGroundItem.setItemMeta(BackGroundMeta);

        VKGI.setItem(0, BackGroundItem);
        VKGI.setItem(1, BackGroundItem);
        VKGI.setItem(2, BackGroundItem);
        VKGI.setItem(3, BackGroundItem);
        VKGI.setItem(4, BackGroundItem);
        VKGI.setItem(5, BackGroundItem);
        VKGI.setItem(6, BackGroundItem);
        VKGI.setItem(7, BackGroundItem);
        VKGI.setItem(8, BackGroundItem);
        VKGI.setItem(9, BackGroundItem);
        VKGI.setItem(17, BackGroundItem);
        VKGI.setItem(18, BackGroundItem);
        VKGI.setItem(26, BackGroundItem);
        VKGI.setItem(27, BackGroundItem);
        VKGI.setItem(35, BackGroundItem);
        VKGI.setItem(37, BackGroundItem);
        VKGI.setItem(38, BackGroundItem);
        VKGI.setItem(39, BackGroundItem);
        VKGI.setItem(40, BackGroundItem);
        VKGI.setItem(41, BackGroundItem);
        VKGI.setItem(42, BackGroundItem);
        VKGI.setItem(43, BackGroundItem);
        VKGI.setItem(44, BackGroundItem);

        ItemStack back = getCustomHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjUzNDc0MjNlZTU1ZGFhNzkyMzY2OGZjYTg1ODE5ODVmZjUzODlhNDU0MzUzMjFlZmFkNTM3YWYyM2QifX19");
        ItemMeta backMeta = back.getItemMeta();
        backMeta.setDisplayName("§aZurück");
        back.setItemMeta(backMeta);
        VKGI.setItem(36, back);

        ItemStack MCoinsGewinn = new ItemStack(Material.GOLD_BLOCK,1);
        ItemMeta MCoinsGMeta = MCoinsGewinn.getItemMeta();
        MCoinsGMeta.setDisplayName("§61.000.000 Coins");
        MCoinsGewinn.setItemMeta(MCoinsGMeta);
        VKGI.setItem(10, MCoinsGewinn);

        ItemStack EnderVilligerRankGewinn = new ItemStack(Material.DIAMOND_CHESTPLATE,1);
        ItemMeta EnderVilligerRankGMeta = EnderVilligerRankGewinn.getItemMeta();
        EnderVilligerRankGMeta.setDisplayName("§3§lEnderVilliger Rang");
        EnderVilligerRankGewinn.setItemMeta(EnderVilligerRankGMeta);
        VKGI.setItem(11, EnderVilligerRankGewinn);

        ItemStack RainbowArmorGewinn = new ItemStack(Material.NETHERITE_CHESTPLATE,1);
        LeatherArmorMeta RainbowArmorGMeta = (LeatherArmorMeta) RainbowArmorGewinn.getItemMeta();
        RainbowArmorGMeta.setDisplayName("§3EnderVillager §cRa§bin§aow §3Outfit");
        RainbowArmorGMeta.setLore(Arrays.asList(" "));
        RainbowArmorGMeta.setLore(Arrays.asList("§7In diesem Gewinn sind folgende Sachen enthalten"));
        RainbowArmorGMeta.setLore(Arrays.asList(" "));
        RainbowArmorGMeta.setLore(Arrays.asList("§cHellrote Brustplatte"));
        RainbowArmorGMeta.setLore(Arrays.asList("§bHellblaue Hose"));
        RainbowArmorGMeta.setLore(Arrays.asList("§aHellgrüne Schuhe"));
        RainbowArmorGMeta.setLore(Arrays.asList(" "));
        RainbowArmorGMeta.setColor(Color.fromRGB(58, 179, 218));
        RainbowArmorGewinn.setItemMeta(RainbowArmorGMeta);
        VKGI.setItem(12, RainbowArmorGewinn);

        ItemStack EnderPlusGewinn = new ItemStack(Material.GOLDEN_CHESTPLATE,1);
        ItemMeta EnderPlusGMeta = EnderPlusGewinn.getItemMeta();
        EnderPlusGMeta.setDisplayName("§6Ender§a+ §6Rang");
        EnderPlusGewinn.setItemMeta(EnderPlusGMeta);
        VKGI.setItem(13, EnderPlusGewinn);

        ItemStack EnderRankGewinn = new ItemStack(Material.DIAMOND_CHESTPLATE,1);
        ItemMeta EnderRankGMeta = EnderRankGewinn.getItemMeta();
        EnderRankGMeta.setDisplayName("§bEnder Rang §7(30 Tage§7)");
        EnderRankGewinn.setItemMeta(EnderRankGMeta);
        VKGI.setItem(14, EnderRankGewinn);

        ItemStack DoppelsprungGewinn = new ItemStack(Material.FEATHER,1);
        ItemMeta DoppelsprungGMeta = DoppelsprungGewinn.getItemMeta();
        DoppelsprungGMeta.setDisplayName("Doppelsprung");
        DoppelsprungGMeta.setLore(Arrays.asList());
        DoppelsprungGMeta.setLore(Arrays.asList("Mit diesem Feature kannst du Doppelsprung in der Lobby benutzen "));
        DoppelsprungGMeta.setLore(Arrays.asList());
        DoppelsprungGewinn.setItemMeta(DoppelsprungGMeta);
        VKGI.setItem(15, DoppelsprungGewinn);

        ItemStack PrivateS50Gewinn = new ItemStack(Material.COMMAND_BLOCK,50);
        ItemMeta PrivateS50GMeta = PrivateS50Gewinn.getItemMeta();
        PrivateS50GMeta.setDisplayName("§d50x §bPrivate Server Token");
        PrivateS50Gewinn.setItemMeta(PrivateS50GMeta);
        VKGI.setItem(16, PrivateS50Gewinn);

        ItemStack Villagerkiste2Gewinn = new ItemStack(Material.END_PORTAL_FRAME,2);
        ItemMeta Villagerkiste2GMeta = Villagerkiste2Gewinn.getItemMeta();
        Villagerkiste2GMeta.setDisplayName("§d2x §d§lVillagerkiste");
        Villagerkiste2Gewinn.setItemMeta(Villagerkiste2GMeta);
        VKGI.setItem(19, Villagerkiste2Gewinn);

        ItemStack Coins10000Gewinn = new ItemStack(Material.GOLD_INGOT,1);
        ItemMeta Coins10000 = Coins10000Gewinn.getItemMeta();
        Coins10000.setDisplayName("§610.000 Coins");
        Coins10000Gewinn.setItemMeta(Coins10000);
        VKGI.setItem(20, Coins10000Gewinn);

        ItemStack PrivateS20Gewinn = new ItemStack(Material.COMMAND_BLOCK,20);
        ItemMeta PrivateS20GMeta = PrivateS20Gewinn.getItemMeta();
        PrivateS20GMeta.setDisplayName("§d20x §bPrivate Server Token");
        PrivateS20Gewinn.setItemMeta(PrivateS50GMeta);
        VKGI.setItem(21, PrivateS20Gewinn);

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
        VKGI.setItem(22, LilaOutfitGewinn);

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
        VKGI.setItem(23, OrangesOutfitGewinn);

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
        VKGI.setItem(24, HellgrunesOutfitGewinn);

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
        VKGI.setItem(25, BraunesOutfitGewinn);

        ItemStack AxolotelPetGewinn = new ItemStack(Material.AXOLOTL_SPAWN_EGG,1);
        ItemMeta AxolotelPetGMeta = AxolotelPetGewinn.getItemMeta();
        AxolotelPetGMeta.setDisplayName("§d§lAxolotel Pet");
        AxolotelPetGewinn.setItemMeta(AxolotelPetGMeta);
        VKGI.setItem(28, AxolotelPetGewinn);

        ItemStack Coins5000Gewinn = new ItemStack(Material.GOLD_NUGGET,1);
        ItemMeta Coins5000 = Coins10000Gewinn.getItemMeta();
        Coins10000.setDisplayName("§65.000 Coins");
        Coins10000Gewinn.setItemMeta(Coins10000);
        VKGI.setItem(29, Coins10000Gewinn);

        player.openInventory(VKGI);
    }
}
