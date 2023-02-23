package me.rootdeibis.mirandalib.utils.guifactory;


import java.util.Collection;
import java.util.function.Predicate;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;


import me.rootdeibis.mirandalib.utils.Cache;


public class GUIMenu implements InventoryHolder {


    private final Inventory inventory;
    private final Cache<GUIButton> buttons = new Cache<>();

    public GUIMenu(String title, int rowSize) {
        this.inventory = Bukkit.createInventory(this, rowSize * 8, title);
    }

    @Override
    public Inventory getInventory() {
        return this.inventory;
    }

    public void addButton(GUIButton button) {
        this.buttons.add(button);
    }


    public void addButtons(Collection<GUIButton> buttons) {
       this.buttons.addAll(buttons);
    }

    public void removeButton(Predicate<GUIButton> predication) {
        this.buttons.remove(predication);
    }


    public Cache<GUIButton> getButtons() {
        return buttons;
    }
    
    public void open(Player player) {
        this.build();

        player.openInventory(this.inventory);
    }


    public void build() {

        this.buttons.all().forEach(btn -> {
            this.inventory.setItem(btn.getSlot(), btn.getItemStack());
        });

        
    }


    

}