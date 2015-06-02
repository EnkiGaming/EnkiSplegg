package com.enkigaming.mcforge.enkisplegg;

import com.enkigaming.mc.enkisplegg.EnkiSpleggMain;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = EnkiSplegg.MODID, name = EnkiSplegg.NAME, version = EnkiSplegg.VERSION, acceptableRemoteVersions = "*")
public class EnkiSplegg
{
    public static final String NAME = "EnkiSplegg";
    public static final String MODID = "EnkiSplegg";
    public static final String VERSION = "1.0.0";
    
    @Instance(EnkiSplegg.MODID)
    protected static EnkiSplegg instance;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        instance = this;
        EnkiSpleggMain.initialise();
    }
    
    public static EnkiSplegg getInstance()
    { return instance; }
}