package com.caleb.armourplugin.RollBack;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.ArrayList;

public class RollBack{

    private Location centerBlock;
    private int range;
    private ArrayList<Block> blocks;
    private ArrayList<Material> materials;

    public RollBack(Location center, int range) {
        this.centerBlock = center;
        this.range = range;
        this.blocks = new ArrayList<Block>();
        this.materials = new ArrayList<Material>();
    }

    public boolean blockInLocation(Block block) {
        for (int z = -range ; z < range; z++) {
            for (int x = -range ; x < range; x++) {
                for (int y = -range ; y < range; y++) {
                    Location currentLocation = this.centerBlock;
                    currentLocation.setZ(centerBlock.getZ() + z);
                    currentLocation.setX(centerBlock.getX() + x);
                    currentLocation.setY(centerBlock.getY() + y);
                    if (block.getLocation().equals(currentLocation)) {
                        return true;
                    }
                }
            }
        } return false;
    }

    public void addBlock(Block block) {
        this.blocks.add(block);
        this.materials.add(block.getType());
    }

    public void saveState() {
        blocks.clear();
        for (int z = -range ; z < range; z++) {
            for (int x = -range ; x < range; x++) {
                for (int y = -range ; y < range; y++) {
                    Location currentLocation = this.centerBlock;
                    currentLocation.setZ(centerBlock.getZ() + z);
                    currentLocation.setX(centerBlock.getX() + x);
                    currentLocation.setY(centerBlock.getY() + y);
                    blocks.add(currentLocation.getBlock());
                }
            }
        }
    }

    public void restoreState() {
        for (int i = 0; i < blocks.size(); i++) {
            Block current = blocks.get(i);
            current.getLocation().getBlock().setType(materials.get(i));
        }
    }


}