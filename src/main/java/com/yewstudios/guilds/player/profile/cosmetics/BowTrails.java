package com.yewstudios.guilds.player.profile.cosmetics;

import particleeffect.ParticleEffect;

/**
 * Created Mat
 */
public enum BowTrails {

    FLAME(ParticleEffect.FLAME, 1),
    WATER_SPLASH(ParticleEffect.WATER_SPLASH, 2),
    BUBBLES(ParticleEffect.WATER_BUBBLE, 3);

    ParticleEffect particleEffect;
    int id; //used for storage

    BowTrails(ParticleEffect effect, int id)
    {
        this.particleEffect = effect;
        this.id = id;
    }

    public ParticleEffect getParticleEffect()
    {
        return this.particleEffect;
    }

    private int getID()
    {
        return this.id;
    }

    public BowTrails fromID(int id)
    {
        for(BowTrails trail : values())
        {
            if(trail.getID() == id) return trail;
        }
        return null;
    }

}
