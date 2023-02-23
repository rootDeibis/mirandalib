package me.rootdeibis.mirandalib.utils.guifactory;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import me.rootdeibis.mirandalib.utils.Functions;

public class GUIButton {

    private Material material = Material.matchMaterial("BEDROCK");
    private final ItemStack itemStack = new ItemStack(this.getMaterial());

    private byte materialData;
    private int materialAmount = 1;

    private String displayName;
    private List<String> lore;
    private Functions.Function<InventoryClickEvent> action = (e) -> {};

    private int slot;


    public GUIButton(int slot) {
        this.slot = slot;
    }

    public Material getMaterial() {
        return material;
    }

    public byte getMaterialData() {
        return materialData;
    }

    public int getMaterialAmount() {
        return materialAmount;
    }

    public String getDisplayName() {
        return displayName;
    }

    public List<String> getLore() {
        return lore;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
    

    public void setMaterialData(Byte materialData) {
        this.materialData = materialData;
    }


    public void setMaterialAmount(int amount) {
        this.materialAmount = amount;
    }


    public void setDisplayName(String displayname) {
        this.displayName = displayname;
    }


    public void setLore(List<String> lore) {
        this.lore = lore;
    }


   
    
    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }


    public void click(InventoryClickEvent event) {
        this.action.apply(event);
    }



    public ItemStack getItemStack() {
        


        return this.itemStack;

    }

   
}
