package micdoodle8.mods.galacticraft.moon.wgen;

import micdoodle8.mods.galacticraft.moon.client.GCMoonColorizerGrass;
import net.minecraft.util.MathHelper;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Copyright 2012-2013, micdoodle8
 * 
 *  All rights reserved.
 *
 */
public class GCMoonBiomeGenBase extends BiomeGenBase
{
    public static final BiomeGenBase moonFlat = new GCMoonBiomeGenFlat(102).setBiomeName("moon");

    public GCMoonBiomeGenBase(int var1)
    {
        super(var1);
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCreatureList.clear();
        this.rainfall = 0F;
    }
    
    @Override
	public GCMoonBiomeGenBase setColor(int var1)
    {
        return (GCMoonBiomeGenBase)super.setColor(var1);
    }

    @Override
	public float getSpawningChance()
    {
        return 0.1F;
    }

    @Override
	@SideOnly(Side.CLIENT)
    public int getBiomeGrassColor()
    {
        final double var3 = MathHelper.clamp_float(this.maxHeight, 0.0F, 1.0F);
        return GCMoonColorizerGrass.getGrassColor(var3, var3);
    }
}
