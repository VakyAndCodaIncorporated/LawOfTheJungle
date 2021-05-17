package coda.lawofthejungle.client.renderer;

import coda.lawofthejungle.LawOfTheJungle;
import coda.lawofthejungle.entities.SiamangGibbonEntity;
import coda.lawofthejungle.client.model.SiamangGibbonModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SiamangGibbonRenderer extends MobRenderer<SiamangGibbonEntity, SiamangGibbonModel<SiamangGibbonEntity>> {
   private static final ResourceLocation NORMAL = new ResourceLocation(LawOfTheJungle.MOD_ID, "textures/entity/siamang_gibbon/normal.png");
   private static final ResourceLocation BOOMING = new ResourceLocation(LawOfTheJungle.MOD_ID, "textures/entity/siamang_gibbon/booming.png");

   public SiamangGibbonRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new SiamangGibbonModel<>(), 0.4F);
   }

   public ResourceLocation getEntityTexture(SiamangGibbonEntity entity) {
      return entity.isBooming() ? BOOMING : NORMAL;
   }
}
