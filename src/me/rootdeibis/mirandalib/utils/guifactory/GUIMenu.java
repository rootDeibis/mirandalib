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

    private boolean editable = false;

    public GUIMenu(String title, int rowSize) {
        this.inventory = Bukkit.createInventory(this, rowSize * 9, title);
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
        GUIButton btn = this.buttons.find(predication);
        

        this.inventory.remove(btn.getItemStack());

        this.buttons.remove(predication);
    }


    public Cache<GUIButton> getButtons() {
        return buttons;
    }


    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public boolean isEditable() {
        return editable;
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