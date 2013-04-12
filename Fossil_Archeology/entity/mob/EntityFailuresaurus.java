package mods.Fossil_Archeology.entity.mob;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.Fossil_Archeology.Fossil;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.world.World;

public class EntityFailuresaurus extends EntityZombie
{
    public EntityFailuresaurus(World var1)
    {
        super(var1);
        this.texture = "/mods/Fossil_Archeology/textures/Failuresaurus.png";
        this.experienceValue=4;
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    protected int getDropItemId()
    {
        return Fossil.biofossil.itemID;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns the texture's file path as a String.
     */
    /*public String getTexture()
    {
        return "/mods/Fossil_Archeology/textures/Failuresaurus.png";
    }*/
    
    /**
     * Causes this entity to do an upwards motion (jumping).
     */
    protected void jump() {}
}
