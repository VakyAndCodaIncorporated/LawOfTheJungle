package coda.lawofthejungle.client.renderer;

import coda.lawofthejungle.LawOfTheJungle;
import coda.lawofthejungle.client.model.RingTailedLemurModel;
import coda.lawofthejungle.entities.RingTailedLemurEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RingTailedLemurRenderer extends MobRenderer<RingTailedLemurEntity, RingTailedLemurModel<RingTailedLemurEntity>> {
   private static final ResourceLocation TEXTURE = new ResourceLocation(LawOfTheJungle.MOD_ID, "textures/entity/ring_tailed_lemur.png");

   public RingTailedLemurRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new RingTailedLemurModel<>(), 0.4F);
   }

   public ResourceLocation getEntityTexture(RingTailedLemurEntity entity) {
      return TEXTURE;
   }
}
