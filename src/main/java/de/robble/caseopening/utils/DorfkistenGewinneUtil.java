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

public class DorfkistenGewinneUtil {
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

    public static void DKGU(Player player){
        Inventory DKGI = Bukkit.createInventory(null, 9*5, "§aDorfkisten Gewinne");
        ItemStack BackGroundItem = new ItemStack(Material.BLACK_STAINED_GLASS_PANE,1);
        ItemMeta BackGroundMeta = BackGroundItem.getItemMeta();
        BackGroundMeta.setDisplayName(" ");
        BackGroundItem.setItemMeta(BackGroundMeta);

        DKGI.setItem(0, BackGroundItem);
        DKGI.setItem(1, BackGroundItem);
        DKGI.setItem(2, BackGroundItem);
        DKGI.setItem(3, BackGroundItem);
        DKGI.setItem(4, BackGroundItem);
        DKGI.setItem(5, BackGroundItem);
        DKGI.setItem(6, BackGroundItem);
        DKGI.setItem(7, BackGroundItem);
        DKGI.setItem(8, BackGroundItem);
        DKGI.setItem(9, BackGroundItem);
        DKGI.setItem(17, BackGroundItem);
        DKGI.setItem(18, BackGroundItem);
        DKGI.setItem(26, BackGroundItem);
        DKGI.setItem(27, BackGroundItem);
        DKGI.setItem(35, BackGroundItem);
        DKGI.setItem(37, BackGroundItem);
        DKGI.setItem(38, BackGroundItem);
        DKGI.setItem(39, BackGroundItem);
        DKGI.setItem(40, BackGroundItem);
        DKGI.setItem(41, BackGroundItem);
        DKGI.setItem(42, BackGroundItem);
        DKGI.setItem(43, BackGroundItem);
        DKGI.setItem(44, BackGroundItem);

        ItemStack back = getCustomHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjUzNDc0MjNlZTU1ZGFhNzkyMzY2OGZjYTg1ODE5ODVmZjUzODlhNDU0MzUzMjFlZmFkNTM3YWYyM2QifX19");
        ItemMeta backMeta = back.getItemMeta();
        backMeta.setDisplayName("§aZurück");
        back.setItemMeta(backMeta);
        DKGI.setItem(36, back);

        ItemStack VillagerKisteGewinn = new ItemStack(Material.END_PORTAL_FRAME,1);
        ItemMeta VillagerKisteGMeta = VillagerKisteGewinn.getItemMeta();
        VillagerKisteGMeta.setDisplayName("§d1x §d§lVilligerkiste");
        VillagerKisteGewinn.setItemMeta(VillagerKisteGMeta);
        DKGI.setItem(10, VillagerKisteGewinn);

        ItemStack EnderKisteGewinn = new ItemStack(Material.ENDER_CHEST,2);
        ItemMeta EnderKisteGMeta = VillagerKisteGewinn.getItemMeta();
        EnderKisteGMeta.setDisplayName("§d2x §d§Enderkisten");
        EnderKisteGewinn.setItemMeta(EnderKisteGMeta);
        DKGI.setItem(11, EnderKisteGewinn);

        ItemStack PrivateServerGewinn = new ItemStack(Material.COMMAND_BLOCK,5);
        ItemMeta PrivateSGMeta = PrivateServerGewinn.getItemMeta();
        PrivateSGMeta.setDisplayName("§d5x §bPrivate Server Token");
        PrivateServerGewinn.setItemMeta(PrivateSGMeta);
        DKGI.setItem(12, PrivateServerGewinn);

        ItemStack LilaOutfitGewinn = new ItemStack(Material.LEATHER_CHESTPLATE,1);
        LeatherArmorMeta LilaOutfitGMeta = (LeatherArmorMeta) LilaOutfitGewinn.getItemMeta();
        LilaOutfitGMeta.setDisplayName("§dLila Outfit §");
        LilaOutfitGMeta.setLore(Arrays.asList(" "));
        LilaOutfitGMeta.setLore(Arrays.asList("§dLila Chestplate"));
        LilaOutfitGMeta.setLore(Arrays.asList("§dLila Leggings"));
        LilaOutfitGMeta.setLore(Arrays.asList("§dLila Boots"));
        LilaOutfitGMeta.setLore(Arrays.asList(" "));
        LilaOutfitGMeta.setColor(Color.PURPLE);
        LilaOutfitGewinn.setItemMeta(LilaOutfitGMeta);
        DKGI.setItem(13, LilaOutfitGewinn);

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
        DKGI.setItem(14, OrangesOutfitGewinn);

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
        DKGI.setItem(15, HellgrunesOutfitGewinn);

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
        DKGI.setItem(16, BraunesOutfitGewinn);

        ItemStack Coins2500Gewinn = new ItemStack(Material.GOLD_INGOT,1);
        ItemMeta Coins2500GMeta = Coins2500Gewinn.getItemMeta();
        Coins2500GMeta.setDisplayName("§62.500 Coins");
        Coins2500Gewinn.setItemMeta(Coins2500GMeta);
        DKGI.setItem(19, Coins2500Gewinn);

        ItemStack CreeperPetGewinn = new ItemStack(Material.CREEPER_SPAWN_EGG,1);
        ItemMeta CreeperPetGMeta = CreeperPetGewinn.getItemMeta();
        CreeperPetGMeta.setDisplayName("§aC§2r§ae§2e§ap§2e§ar §2P§ae§2t");
        CreeperPetGewinn.setItemMeta(CreeperPetGMeta);
        DKGI.setItem(20, CreeperPetGewinn);

        ItemStack PigPetGewinn = new ItemStack(Material.PIG_SPAWN_EGG,1);
        ItemMeta PigPetGMeta = PigPetGewinn.getItemMeta();
        PigPetGMeta.setDisplayName("§dP§5i§dg §5P§de§5t");
        PigPetGewinn.setItemMeta(PigPetGMeta);
        DKGI.setItem(21, PigPetGewinn);

        ItemStack Coins500Gewinn = new ItemStack(Material.GOLD_NUGGET,1);
        ItemMeta Coins500GMeta = Coins500Gewinn.getItemMeta();
        Coins500GMeta.setDisplayName("§6500 Coins");
        Coins500Gewinn.setItemMeta(Coins500GMeta);
        DKGI.setItem(22, Coins500Gewinn);

        player.openInventory(DKGI);
    }
}
