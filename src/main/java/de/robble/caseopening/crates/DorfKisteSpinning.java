package de.robble.caseopening.crates;

import de.robble.caseopening.Main;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DorfKisteSpinning implements CommandExecutor, Listener {
    private List<Inventory> DKSS = new ArrayList<>();
    public static ItemStack[] DKC = new ItemStack[]{
            new ItemStack(Material.END_PORTAL_FRAME),
            new ItemStack(Material.ENDER_CHEST),
            new ItemStack(Material.COMMAND_BLOCK),
            new ItemStack(Material.LEATHER_CHESTPLATE),
            new ItemStack(Material.LEATHER_CHESTPLATE),
            new ItemStack(Material.LEATHER_CHESTPLATE),
            new ItemStack(Material.LEATHER_CHESTPLATE),
            new ItemStack(Material.GOLD_INGOT),
            new ItemStack(Material.CREEPER_SPAWN_EGG),
            new ItemStack(Material.PIG_SPAWN_EGG),
            new ItemStack(Material.GOLD_NUGGET)
    };
    public static int itemIndex = 0;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        if(
                //---BITTE DIE API EINBINDEN!---
                "API" == "API"
        ) {
            Inventory DKspinInv = Bukkit.createInventory(null, 9 * 5, "§6Dorfkiste (Dreht)");
            openDK(DKspinInv);
            this.DKSS.add(DKspinInv);
            player.openInventory(DKspinInv);
            Random r = new Random();
            final double secs = 15D * r.nextDouble();

            new BukkitRunnable() {
                boolean finished = false;
                double delay = 0.0D;
                int ticks = 0;

                @Override
                public void run() {
                    if (finished) {
                        return;
                    }
                    this.ticks++;
                    this.delay += 1.0D / (20D * secs);
                    if (this.ticks > this.delay * 10) {
                        this.ticks = 0;
                        for (int is = 19; is < 26; is++) {
                            DKspinInv.setItem(is, DorfKisteSpinning.DKC[((is + DorfKisteSpinning.this.itemIndex) % DorfKisteSpinning.DKC.length)]);
                        }
                        DorfKisteSpinning.this.itemIndex += 1;
                        if (this.delay >= 0.5D) {
                            finished = true;
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    try {
                                        ItemStack win = DKspinInv.getItem(20);
                                        if (win.getType() != Material.LEATHER_CHESTPLATE) {
                                            if (win.getType() == Material.END_PORTAL_FRAME) {
                                                //Gebe User ne' Dorfkiste
                                            } else if (win.getType() == Material.ENDER_CHEST) {
                                                //Gebe User eine Enderkiste
                                            } else if (win.getType() == Material.COMMAND_BLOCK) {
                                                //Gebe User 5 Private Server Tokens
                                            } else if (win.getType() == Material.GOLD_INGOT) {
                                                //Gebe User $2.500
                                            } else if (win.getType() == Material.CREEPER_SPAWN_EGG) {
                                                //Gebe User Creeper Pet
                                            } else if (win.getType() == Material.PIG_SPAWN_EGG) {
                                                //Gebe User Pig Pet
                                            }else if (win.getType() == Material.GOLD_NUGGET) {
                                                //Gebe User $500
                                            }
                                        } else {
                                            LeatherArmorMeta winMeta = (LeatherArmorMeta) win.getItemMeta();
                                            if(winMeta.getColor() == Color.PURPLE){

                                            }
                                            if(winMeta.getColor() == Color.ORANGE){

                                            }
                                            if(winMeta.getColor() == Color.LIME){

                                            }
                                            if(winMeta.getColor() == Color.fromRGB(132, 93, 0)){

                                            }
                                        }
                                        player.closeInventory();
                                        cancel();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        cancel();
                                    }
                                }
                            }.runTaskLater(Main.getInstance(), 300);
                            cancel();
                        }
                    }
                }
            }.runTaskTimer(Main.getInstance(), 0L, 1L);
        }
        return false;
    }

    private void openDK(Inventory createDKI) {
        ItemStack BackGroundItem = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta BackgroundMeta = BackGroundItem.getItemMeta();
        BackgroundMeta.setDisplayName(" ");
        BackGroundItem.setItemMeta(BackgroundMeta);
        createDKI.setItem(0, BackGroundItem);
        createDKI.setItem(1, BackGroundItem);
        createDKI.setItem(2, BackGroundItem);
        createDKI.setItem(3, BackGroundItem);
        createDKI.setItem(4, BackGroundItem);
        createDKI.setItem(5, BackGroundItem);
        createDKI.setItem(6, BackGroundItem);
        createDKI.setItem(7, BackGroundItem);
        createDKI.setItem(8, BackGroundItem);
        createDKI.setItem(9, BackGroundItem);
        createDKI.setItem(17, BackGroundItem);
        createDKI.setItem(18, BackGroundItem);
        createDKI.setItem(26, BackGroundItem);
        createDKI.setItem(27, BackGroundItem);
        createDKI.setItem(35, BackGroundItem);
        createDKI.setItem(36, BackGroundItem);
        createDKI.setItem(37, BackGroundItem);
        createDKI.setItem(38, BackGroundItem);
        createDKI.setItem(39, BackGroundItem);
        createDKI.setItem(40, BackGroundItem);
        createDKI.setItem(41, BackGroundItem);
        createDKI.setItem(42, BackGroundItem);
        createDKI.setItem(43, BackGroundItem);
        createDKI.setItem(44, BackGroundItem);

        ItemMeta G0 = DKC[0].getItemMeta();
        G0.setDisplayName("§d1x §d§lVilligerkiste");
        DKC[0].setItemMeta(G0);

        ItemMeta G1 = DKC[1].getItemMeta();
        G1.setDisplayName("§d2x §b§lEnderkisten");
        DKC[1].setItemMeta(G1);

        ItemMeta G2 = DKC[2].getItemMeta();
        G2.setDisplayName("§d5x §bPrivate Server Token");
        DKC[2].setItemMeta(G2);

        LeatherArmorMeta G3 = (LeatherArmorMeta) DKC[3].getItemMeta();
        G3.setDisplayName("§dLila Outfit");
        G3.setColor(Color.PURPLE);
        G3.setLore(Arrays.asList(" "));
        G3.setLore(Arrays.asList("§dLila Chestplate"));
        G3.setLore(Arrays.asList("§dLila Leggings"));
        G3.setLore(Arrays.asList("§dLila Boots"));
        G3.setLore(Arrays.asList(" "));
        DKC[3].setItemMeta(G3);

        LeatherArmorMeta G4 = (LeatherArmorMeta) DKC[4].getItemMeta();
        G4.setDisplayName("§6Oranges Outfit");
        G4.setLore(Arrays.asList(" "));
        G4.setLore(Arrays.asList("§6Orange Chestplate"));
        G4.setLore(Arrays.asList("§6Orange Leggings"));
        G4.setLore(Arrays.asList("§6Orange Boots"));
        G4.setLore(Arrays.asList(" "));
        G4.setColor(Color.ORANGE);
        DKC[4].setItemMeta(G4);

        LeatherArmorMeta G5 = (LeatherArmorMeta) DKC[5].getItemMeta();
        G5.setDisplayName("§aHellgrünes Outfit");
        G5.setLore(Arrays.asList(" "));
        G5.setLore(Arrays.asList("§aHellgrüne Chestplate"));
        G5.setLore(Arrays.asList("§aHellgrüne Leggings"));
        G5.setLore(Arrays.asList("§aHellgrüne Boots"));
        G5.setLore(Arrays.asList(" "));
        G5.setColor(Color.LIME);
        DKC[5].setItemMeta(G5);

        LeatherArmorMeta G6 = (LeatherArmorMeta) DKC[6].getItemMeta();
        G6.setDisplayName("Braunes Outfit");
        G6.setLore(Arrays.asList(" "));
        G6.setLore(Arrays.asList("Braune Chestplate"));
        G6.setLore(Arrays.asList("Braune Leggings"));
        G6.setLore(Arrays.asList("Braune Boots"));
        G6.setLore(Arrays.asList(" "));
        G6.setColor(Color.fromRGB(132, 93, 0));
        DKC[6].setItemMeta(G6);

        ItemMeta G7 = DKC[7].getItemMeta();
        G7.setDisplayName("§62.500 Coins");
        DKC[7].setItemMeta(G7);

        ItemMeta G8 = DKC[8].getItemMeta();
        G8.setDisplayName("§aC§2r§ae§2e§ap§2e§ar §2P§ae§2t");
        DKC[8].setItemMeta(G8);

        ItemMeta G9 = DKC[9].getItemMeta();
        G9.setDisplayName("§dP§5i§dg §5P§de§5t");
        DKC[9].setItemMeta(G9);

        ItemMeta G10 = DKC[10].getItemMeta();
        G10.setDisplayName("§6500 Coins");
        DKC[10].setItemMeta(G10);

        ItemStack GewinnHopper = new ItemStack(Material.HOPPER);
        ItemMeta GewinnHopperMeta = GewinnHopper.getItemMeta();
        GewinnHopperMeta.setDisplayName("§3§lGewinn");
        GewinnHopper.setItemMeta(GewinnHopperMeta);
        createDKI.setItem(13, GewinnHopper);

        int StartIndex = new Random().nextInt(DKC.length);
        for(int index = 0; index < StartIndex; index++){
            for (int is = 19; is < 25; is++){
                createDKI.setItem(is, DKC[((is+itemIndex) % DKC.length)]);
            }
        }
    }
    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getView().getTitle().equals("§6Dorfkiste (Dreht)")){
            event.setCancelled(true);
        }
    }
}
