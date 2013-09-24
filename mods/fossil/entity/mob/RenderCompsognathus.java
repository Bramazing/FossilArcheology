package mods.fossil.entity.mob;

import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class RenderCompsognathus extends RenderLiving
{
	
	
    private static final ResourceLocation loc = new ResourceLocation("fossil:textures/mob/Compsognathus.png");

    final float SwingConst = 0.261799F;
    final int SwingStep = 15;
    public static final float SwingBackSignal = -1000.0F;
    public boolean HuntingPose = false;

    public RenderCompsognathus(ModelBase var1, float var2)
    {
        super(var1, var2);
    }

    /**
     * Applies the scale to the transform matrix
     * 
     * Use this to grow the dinonsaur with age.
     */
    protected void preRenderScale(EntityCompsognathus entitydinosaur, float par2)
    {
        GL11.glScalef(entitydinosaur.getDinoWidth(), entitydinosaur.getDinoHeight(), entitydinosaur.getDinoLength());
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.preRenderScale((EntityCompsognathus)par1EntityLivingBase, par2);
    }
    
    protected ResourceLocation func_110919_a(EntityCompsognathus par1Entity)
    {
        return loc;
    }
    
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.func_110919_a((EntityCompsognathus)par1Entity);
    }    
    
    

    protected void renderEquippedItems(EntityLiving var1, float var2)
    {
        float var3 = 1.0F + 0.0F * (float)((EntityDinosaur)var1).getDinoAge();
        ItemStack var4 = ((EntityCompsognathus)var1).ItemInMouth;

        if (var4 != null)
        {
            GL11.glPushMatrix();
            ((ModelCompsognathus)this.mainModel).Head.postRender(0.01F);
            float var5;

            if (var4.itemID < 256 && RenderBlocks.renderItemIn3d(Block.blocksList[var4.itemID].getRenderType()))
            {
                var5 = 0.5F;
                GL11.glTranslatef(0.0F, 0.4F, -0.75F);
                var5 *= 0.75F;
                GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(var5 * var3, -var5 * var3, var5 * var3);
            }
            else if (Item.itemsList[var4.itemID].isFull3D())
            {
                var5 = 0.625F;
                GL11.glTranslatef(0.0F, 0.4F, -0.75F);
                GL11.glScalef(var5 * var3, -var5 * var3, var5 * var3);
                GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            }
            else
            {
                var5 = 0.375F;
                GL11.glTranslatef(0.0F, 0.4F, -0.75F);
                GL11.glScalef(var5 * var3, var5 * var3, var5 * var3);
                GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
            }

            this.renderManager.itemRenderer.renderItem(var1, var4, 1);
            GL11.glPopMatrix();
        }
    }
}
