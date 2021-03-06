package micdoodle8.mods.galacticraft.core.client.render.item;

import micdoodle8.mods.galacticraft.core.client.model.GCCoreModelFlag;
import micdoodle8.mods.galacticraft.core.entities.GCCoreEntityFlag;
import micdoodle8.mods.galacticraft.core.items.GCCoreItemFlag;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

/**
 * Copyright 2012-2013, micdoodle8
 * 
 *  All rights reserved.
 *
 */
public class GCCoreItemRendererFlag implements IItemRenderer
{
	GCCoreEntityFlag spaceship = new GCCoreEntityFlag(FMLClientHandler.instance().getClient().theWorld);
	GCCoreModelFlag modelSpaceship = new GCCoreModelFlag();
    
	private void renderPipeItem(ItemRenderType type, RenderBlocks render, ItemStack item, float translateX, float translateY, float translateZ)
	{
        GL11.glPushMatrix();
        long var10 = this.spaceship.entityId * 493286711L;
        var10 = var10 * var10 * 4392167121L + var10 * 98761L;
        final float var12 = (((var10 >> 16 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
        final float var13 = (((var10 >> 20 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
        final float var14 = (((var10 >> 24 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
        
        this.spaceship.setType(item.getItemDamage());
        this.spaceship.setOwner(FMLClientHandler.instance().getClient().thePlayer.username);
        
        if (type == ItemRenderType.EQUIPPED)
        {
            GL11.glScalef(7F, 7F, 7F);
            GL11.glTranslatef(0.0F, 0.7F, 0.1F);

            if (FMLClientHandler.instance().getClient().thePlayer.getItemInUseCount() > 0)
            {
                float var13b;
                float var14b;
                final float var15;
                
//                GL11.glRotatef(-18.0F, 0.0F, 0.0F, 1.0F);
//                GL11.glRotatef(-12.0F, 0.0F, 1.0F, 0.0F);
//                GL11.glRotatef(-8.0F, 1.0F, 0.0F, 0.0F);
//                GL11.glTranslatef(-0.9F, 0.2F, 0.0F);
                var13b = item.getMaxItemUseDuration() - (FMLClientHandler.instance().getClient().thePlayer.getItemInUseCount() + 1.0F);
                var14b = var13b / 20.0F;
                var14b = (var14b * var14b + var14b * 2.0F) / 3.0F;

                if (var14b > 1.0F)
                {
                    var14b = 1.0F;
                }

//                if (var14b > 0.1F)
                {
                    GL11.glRotatef(MathHelper.sin((var13b - 0.1F) * 0.3F) * 0.01F * (var14b - 0.1F) * 60, 1F, 0F, 0F);
                }

                GL11.glRotatef(var14b * 30F, 1F, 0F, 1F);
                GL11.glTranslatef(0F, -(var14b * 0.2F), 0F);
//                GL11.glRotatef(-335.0F, 0.0F, 0.0F, 1.0F);
//                GL11.glRotatef(-50.0F, 0.0F, 1.0F, 0.0F);
//                GL11.glTranslatef(0.0F, 0.5F, 0.0F);
//                var15 = 1.0F + var14b * 0.2F;
//                GL11.glScalef(1.0F, 1.0F, var15);
//                GL11.glTranslatef(0.0F, -0.5F, 0.0F);
//                GL11.glRotatef(50.0F, 0.0F, 1.0F, 0.0F);
//                GL11.glRotatef(335.0F, 0.0F, 0.0F, 1.0F);
            }
        }
        
        GL11.glTranslatef(var12, var13 - 0.1F, var14);
        GL11.glScalef(-0.4F, -0.4F, 0.4F);
        if (type == ItemRenderType.INVENTORY || type == ItemRenderType.ENTITY)
        {
        	if (type == ItemRenderType.INVENTORY)
        	{
                GL11.glScalef(1.1F, 1.137F, 1.1F);
            	GL11.glRotatef(30F, 1F, 0F, 1F);
            	GL11.glRotatef(110F, 0F, 1F, 0F);
            	GL11.glTranslatef(-0.5F, 0.3F, 0);
//            	GL11.glRotatef(10F, 1F, 0F, 0F);
//            	GL11.glRotatef(30F, 0F, 0F, 1F);
        	}
        	else
        	{
            	GL11.glTranslatef(0, -0.9F, 0);
            	GL11.glScalef(0.5F, 0.5F, 0.5F);
        	}
        	
        	GL11.glScalef(1.3F, 1.3F, 1.3F);
        	GL11.glTranslatef(0, -0.6F, 0);
        }
        
    	switch (item.getItemDamage())
    	{
    	default:
    		FMLClientHandler.instance().getClient().renderEngine.bindTexture(FMLClientHandler.instance().getClient().renderEngine.getTexture("/micdoodle8/mods/galacticraft/core/client/entities/flag/" + GCCoreItemFlag.names[item.getItemDamage()] + ".png"));
    		break;
    	}
    	
        this.modelSpaceship.render(this.spaceship, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
	}

	
	/** IItemRenderer implementation **/
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		switch (type) {
		case ENTITY:
			return true;
		case EQUIPPED:
			return true;
		case INVENTORY:
			return true;
		default:
			return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		switch (type)
		{
		case EQUIPPED:
			this.renderPipeItem(type, (RenderBlocks) data[0], item, -0.5f, -0.5f, -0.5f);
			break;
		case INVENTORY:
			this.renderPipeItem(type, (RenderBlocks) data[0], item, -0.5f, -0.5f, -0.5f);
			break;
		case ENTITY:
			this.renderPipeItem(type, (RenderBlocks) data[0], item, -0.5f, -0.5f, -0.5f);
			break;
		default:
		}
	}

}
