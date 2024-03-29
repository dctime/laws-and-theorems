package net.dctime.lawsandtheorems.event.eulers_number_item.client;

import net.dctime.lawsandtheorems.LawsAndTheorems;
import net.dctime.lawsandtheorems.register.ModItems;
import net.dctime.lawsandtheorems.register.ModParticleTypes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = LawsAndTheorems.MODID,value=Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EulerFlameForgeClientEvents
{

    @SubscribeEvent
    public static void EulersNumberItemThrown(EntityEvent event)
    {
        if (event.getEntity() instanceof ItemEntity && event.getEntity().level.isClientSide())
        {
            ItemEntity itemEntity = (ItemEntity) event.getEntity();

            if ((((ItemEntity) event.getEntity()).getItem().is(ModItems.THE_NUMBER_E.get())))
            {
                if (itemEntity.getAge() > 50)
                {
                    // velocity
                    event.getEntity().level.addAlwaysVisibleParticle(
                            ModParticleTypes.IMAGINARY_NUMBER_SIMPLE_PARTICLE_TYPE,
                            itemEntity.getX()+Math.sin(itemEntity.getAge() * (2 * Math.PI / 360)*10)*0.7,
                            itemEntity.getY()+0.5,
                            itemEntity.getZ()+Math.cos(itemEntity.getAge() * (2 * Math.PI / 360)*10)*0.7,
                            0.3*Math.sin((itemEntity.getAge() * (2 * Math.PI / 360)*10 + (Math.PI / 2))),
                            -0.08,
                            0.3*Math.cos((itemEntity.getAge() * (2 * Math.PI / 360)*10 + (Math.PI / 2)))
                    );

                    // position
                    event.getEntity().level.addAlwaysVisibleParticle(
                            ModParticleTypes.EULARS_FLAME_SIMPLE_PARTICLE_TYPE,
                            itemEntity.getX()+Math.sin(itemEntity.getAge() * (2 * Math.PI / 360)*10)*0.7,
                            itemEntity.getY()+0.2,
                            itemEntity.getZ()+Math.cos(itemEntity.getAge() * (2 * Math.PI / 360)*10)*0.7,
                            0*Math.sin(itemEntity.getAge() * (2 * Math.PI / 360) * 10),
                            0.1,
                            0*Math.cos(itemEntity.getAge() * (2 * Math.PI / 360) * 10)
                    );
                }
            }
        }
    }
}
