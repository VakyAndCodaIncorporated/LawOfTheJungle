package coda.lawofthejungle.client.model;

import coda.lawofthejungle.entities.SiamangGibbonEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Collections;

@OnlyIn(Dist.CLIENT)
public class SiamangGibbonModel<T extends Entity> extends AgeableModel<SiamangGibbonEntity> {
    public ModelRenderer body;
    public ModelRenderer right_leg;
    public ModelRenderer left_leg;
    public ModelRenderer right_arm;
    public ModelRenderer left_arm;
    public ModelRenderer head;
    public ModelRenderer throat_pouch;
    public ModelRenderer snout;

    public SiamangGibbonModel() {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.right_arm = new ModelRenderer(this, 24, 16);
        this.right_arm.setRotationPoint(-3.5F, -2.5F, 0.0F);
        this.right_arm.addBox(-1.0F, -1.5F, -1.0F, 2.0F, 14.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.0F, 13.0F, 0.0F);
        this.body.addBox(-2.5F, -4.5F, -1.5F, 5.0F, 9.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.throat_pouch = new ModelRenderer(this, 16, 9);
        this.throat_pouch.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.throat_pouch.addBox(-2.0F, 0.0F, -3.0F, 4.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.left_arm = new ModelRenderer(this, 24, 16);
        this.left_arm.mirror = true;
        this.left_arm.setRotationPoint(3.5F, -2.5F, 0.0F);
        this.left_arm.addBox(-1.0F, -1.5F, -1.0F, 2.0F, 14.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.right_leg = new ModelRenderer(this, 0, 13);
        this.right_leg.setRotationPoint(-1.5F, 4.0F, 0.0F);
        this.right_leg.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.snout = new ModelRenderer(this, 8, 19);
        this.snout.setRotationPoint(0.0F, -1.5F, -2.5F);
        this.snout.addBox(-1.5F, -0.5F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.left_leg = new ModelRenderer(this, 0, 13);
        this.left_leg.mirror = true;
        this.left_leg.setRotationPoint(1.5F, 4.0F, 0.0F);
        this.left_leg.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 0, 22);
        this.head.setRotationPoint(0.0F, -4.5F, 0.0F);
        this.head.addBox(-3.0F, -5.0F, -2.5F, 6.0F, 5.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.body.addChild(this.right_arm);
        this.body.addChild(this.throat_pouch);
        this.body.addChild(this.left_arm);
        this.body.addChild(this.right_leg);
        this.head.addChild(this.snout);
        this.body.addChild(this.left_leg);
        this.body.addChild(this.head);
    }


    @Override
    public void setRotationAngles(SiamangGibbonEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float speed = 1.0f;
        float degree = 1.0f;
        if (entityIn.getMotion().x != 0 && entityIn.getMotion().y != 0) {
            this.body.rotateAngleZ = MathHelper.cos(limbSwing * speed * 0.4F) * degree * 0.2F * limbSwingAmount;
            this.right_leg.rotateAngleZ = MathHelper.cos(limbSwing * speed * 0.4F) * degree * -0.2F * limbSwingAmount;
            this.left_leg.rotateAngleZ = MathHelper.cos(limbSwing * speed * 0.4F) * degree * -0.2F * limbSwingAmount;
            this.left_leg.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F) * degree * 1.0F * limbSwingAmount;
            this.right_leg.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F) * degree * -1.0F * limbSwingAmount;
            this.head.rotationPointY = MathHelper.cos(-1.0F + limbSwing * speed * 0.4F) * degree * 0.05F * limbSwingAmount - 4.45F;
            this.head.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F) * degree * 0.2F * limbSwingAmount - 0.05F;
            this.right_arm.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.4F) * degree * 0.2F * limbSwingAmount - 0.25F;
            this.right_arm.rotateAngleZ = MathHelper.cos(1.0F + limbSwing * speed * 0.4F) * degree * 0.1F * limbSwingAmount + 0.35F;
            this.left_arm.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.4F) * degree * -0.2F * limbSwingAmount - 0.25F;
            this.left_arm.rotateAngleZ = MathHelper.cos(1.0F + limbSwing * speed * 0.4F) * degree * -0.1F * limbSwingAmount - 0.35F;
            this.right_arm.rotationPointY = limbSwingAmount - 2.45F;
            this.left_arm.rotationPointY = limbSwingAmount - 2.45F;
            this.throat_pouch.rotationPointY = MathHelper.cos(-2.0F + limbSwing * speed * 0.4F) * degree * 0.05F * limbSwingAmount - 3.98F;
            this.throat_pouch.rotateAngleZ = MathHelper.cos(-1.0F + limbSwing * speed * 0.4F) * degree * 0.2F * limbSwingAmount;
        }
        else {
            this.right_arm.rotateAngleX = 0;
            this.right_arm.rotateAngleZ = 0;
            this.left_arm.rotateAngleX = 0;
            this.left_arm.rotateAngleZ = 0;
            this.body.rotateAngleZ = 0F;
            this.right_leg.rotateAngleZ = 0F;
            this.left_leg.rotateAngleZ = 0F;
            this.left_leg.rotateAngleX = 0F;
            this.right_leg.rotateAngleX = 0F;
            this.head.rotationPointY = - 4.5F;
            this.head.rotateAngleX = 0F;
            this.right_arm.rotationPointY = - 2.5F;
            this.left_arm.rotationPointY = - 2.5F;
            this.throat_pouch.rotationPointY = - 4F;
            this.throat_pouch.rotateAngleZ = 0F;
        }
    }

    @Override
    protected Iterable<ModelRenderer> getHeadParts() {
        return Collections.EMPTY_LIST;
    }

    @Override
    protected Iterable<ModelRenderer> getBodyParts() {
        return ImmutableList.of(body);
    }
}