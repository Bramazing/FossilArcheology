package mods.fossil.entity.mob;

import com.google.common.collect.Maps;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.texture.LayeredTexture;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderPachycephalosaurus extends RenderLiving
{
    private static final ResourceLocation loc = new ResourceLocation("fossil:textures/mob/Pachycephalosaurus.png");

    public RenderPachycephalosaurus(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
    }

    /**
     * Applies the scale to the transform matrix
     * 
     * Use this to grow the dinonsaur with age.
     */
    protected void preRenderScale(EntityPachycephalosaurus entitydinosaur, float par2)
    {
        GL11.glScalef(entitydinosaur.getDinoWidth(), entitydinosaur.getDinoHeight(), entitydinosaur.getDinoLength());
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.preRenderScale((EntityPachycephalosaurus)par1EntityLivingBase, par2);
    }
    
    protected ResourceLocation func_110919_a(EntityPachycephalosaurus par1Entity)
    {
        return loc;
    }
    
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.func_110919_a((EntityPachycephalosaurus)par1Entity);
    }
}
