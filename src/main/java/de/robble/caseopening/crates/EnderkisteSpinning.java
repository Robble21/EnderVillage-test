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

public class EnderkisteSpinning implements CommandExecutor, Listener{
    private List<Inventory> EKSS = new ArrayList<>();
    public static ItemStack[] EKC = new ItemStack[]{
            new ItemStack(Material.GOLDEN_CHESTPLATE),
            new ItemStack(Material.DIAMOND_CHESTPLATE),
            new ItemStack(Material.FEATHER),
            new ItemStack(Material.END_PORTAL_FRAME),
            new ItemStack(Material.GOLD_INGOT),
            new ItemStack(Material.ENDER_CHEST),
            new ItemStack(Material.COMMAND_BLOCK),
            new ItemStack(Material.GOLD_NUGGET),
            new ItemStack(Material.LEATHER_CHESTPLATE),
            new ItemStack(Material.LEATHER_CHESTPLATE),
            new ItemStack(Material.LEATHER_CHESTPLATE),
            new ItemStack(Material.LEATHER_CHESTPLATE),
            new ItemStack(Material.AXOLOTL_SPAWN_EGG),
            new ItemStack(Material.MOOSHROOM_SPAWN_EGG),
    };
    public static int itemIndex = 0;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        if(
            //---BITTE DIE API EINBINDEN!---
                "API" == "API"
        ) {
            Inventory EKspinInv = Bukkit.createInventory(null, 9 * 5, "§b§lEnderkiste (Dreht)");
            openEK(EKspinInv);
            this.EKSS.add(EKspinInv);
            player.openInventory(EKspinInv);
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
                            EKspinInv.setItem(is, DorfKisteSpinning.DKC[((is + EnderkisteSpinning.this.itemIndex) % DorfKisteSpinning.DKC.length)]);
                        }
                        EnderkisteSpinning.this.itemIndex += 1;
                        if (this.delay >= 0.5D) {
                            finished = true;
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    try {
                                        ItemStack win = EKspinInv.getItem(20);
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

    private void openEK(Inventory createEKI) {
        ItemStack BackGroundItem = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta BackgroundMeta = BackGroundItem.getItemMeta();
        BackgroundMeta.setDisplayName(" ");
        BackGroundItem.setItemMeta(BackgroundMeta);
        createEKI.setItem(0, BackGroundItem);
        createEKI.setItem(1, BackGroundItem);
        createEKI.setItem(2, BackGroundItem);
        createEKI.setItem(3, BackGroundItem);
        createEKI.setItem(4, BackGroundItem);
        createEKI.setItem(5, BackGroundItem);
        createEKI.setItem(6, BackGroundItem);
        createEKI.setItem(7, BackGroundItem);
        createEKI.setItem(8, BackGroundItem);
        createEKI.setItem(9, BackGroundItem);
        createEKI.setItem(17, BackGroundItem);
        createEKI.setItem(18, BackGroundItem);
        createEKI.setItem(26, BackGroundItem);
        createEKI.setItem(27, BackGroundItem);
        createEKI.setItem(35, BackGroundItem);
        createEKI.setItem(36, BackGroundItem);
        createEKI.setItem(37, BackGroundItem);
        createEKI.setItem(38, BackGroundItem);
        createEKI.setItem(39, BackGroundItem);
        createEKI.setItem(40, BackGroundItem);
        createEKI.setItem(41, BackGroundItem);
        createEKI.setItem(42, BackGroundItem);
        createEKI.setItem(43, BackGroundItem);
        createEKI.setItem(44, BackGroundItem);

        ItemMeta G0 = EKC[0].getItemMeta();
        G0.setDisplayName("§6Ender§a+ §6Rang");
        EKC[0].setItemMeta(G0);

        ItemMeta G1 = EKC[1].getItemMeta();
        G1.setDisplayName("§bEnder Rang §7(30 Tage§7)");
        EKC[1].setItemMeta(G1);

        ItemMeta G2 = EKC[2].getItemMeta();
        G2.setDisplayName("Doppelsprung");
        EKC[2].setItemMeta(G2);

        ItemMeta G3 = EKC[3].getItemMeta();
        G3.setDisplayName("§d2x §d§lVillagerkiste");
        EKC[3].setItemMeta(G3);

        ItemMeta G4 = EKC[4].getItemMeta();
        G4.setDisplayName("§610.000 Coins");
        EKC[4].setItemMeta(G4);

        ItemMeta G5 = EKC[5].getItemMeta();
        G5.setDisplayName("§d2x §b§lEnderkisten");
        EKC[5].setItemMeta(G5);

        ItemMeta G6 = EKC[6].getItemMeta();
        G6.setDisplayName("§d20x §bPrivate Server Token");
        EKC[6].setItemMeta(G6);

        ItemMeta G7 = EKC[7].getItemMeta();
        G7.setDisplayName("§65.000 Coins");
        EKC[7].setItemMeta(G7);

        LeatherArmorMeta G8 = (LeatherArmorMeta) EKC[8].getItemMeta();
        G8.setDisplayName("§6Oranges Outfit");
        G8.setLore(Arrays.asList(" "));
        G8.setLore(Arrays.asList("§6Orange Chestplate"));
        G8.setLore(Arrays.asList("§6Orange Leggings"));
        G8.setLore(Arrays.asList("§6Orange Boots"));
        G8.setLore(Arrays.asList(" "));
        G8.setColor(Color.ORANGE);
        EKC[8].setItemMeta(G8);

        LeatherArmorMeta G9 = (LeatherArmorMeta) EKC[9].getItemMeta();
        G9.setDisplayName("§dP§5i§dg §5P§de§5t");
        G9.setLore(Arrays.asList(" "));
        G9.setLore(Arrays.asList("§dLila Chestplate"));
        G9.setLore(Arrays.asList("§dLila Leggings"));
        G9.setLore(Arrays.asList("§dLila Boots"));
        G9.setLore(Arrays.asList(" "));
        G9.setColor(Color.PURPLE);
        EKC[9].setItemMeta(G9);

        LeatherArmorMeta G10 = (LeatherArmorMeta) EKC[10].getItemMeta();
        G10.setDisplayName("§aHellgrünes Outfit");
        G10.setLore(Arrays.asList(" "));
        G10.setLore(Arrays.asList("§aHellgrüne Chestplate"));
        G10.setLore(Arrays.asList("§aHellgrüne Leggings"));
        G10.setLore(Arrays.asList("§aHellgrüne Boots"));
        G10.setLore(Arrays.asList(" "));
        G10.setColor(Color.LIME);
        EKC[10].setItemMeta(G10);

        LeatherArmorMeta G11 = (LeatherArmorMeta) EKC[11].getItemMeta();
        G11.setDisplayName("Braunes Outfit");
        G11.setLore(Arrays.asList(" "));
        G11.setLore(Arrays.asList("Braune Chestplate"));
        G11.setLore(Arrays.asList("Braune Leggings"));
        G11.setLore(Arrays.asList("Braune Boots"));
        G11.setLore(Arrays.asList(" "));
        G11.setColor(Color.fromRGB(132, 93, 0));
        EKC[11].setItemMeta(G11);

        ItemMeta G12 = EKC[12].getItemMeta();
        G12.setDisplayName("§d§lAxolotel Pet");
        EKC[11].setItemMeta(G12);

        ItemMeta G13 = EKC[13].getItemMeta();
        G13.setDisplayName("§cP§4i§cl§4z§ck§4u§ch §4P§ce§4p");
        EKC[10].setItemMeta(G13);

        ItemStack GewinnHopper = new ItemStack(Material.HOPPER);
        ItemMeta GewinnHopperMeta = GewinnHopper.getItemMeta();
        GewinnHopperMeta.setDisplayName("§3§lGewinn");
        GewinnHopper.setItemMeta(GewinnHopperMeta);
        createEKI.setItem(13, GewinnHopper);

        int StartIndex = new Random().nextInt(EKC.length);
        for(int index = 0; index < StartIndex; index++){
            for (int is = 19; is < 25; is++){
                createEKI.setItem(is, EKC[((is+itemIndex) % EKC.length)]);
            }
        }
    }
    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getView().getTitle().equals("§b§lEnderkiste (Dreht)")){
            event.setCancelled(true);
        }
    }
}
