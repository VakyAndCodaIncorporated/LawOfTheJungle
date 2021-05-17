package coda.lawofthejungle.client.model;

import coda.lawofthejungle.entities.RingTailedLemurEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Collections;

@OnlyIn(Dist.CLIENT)
public class RingTailedLemurModel<T extends Entity> extends AgeableModel<RingTailedLemurEntity> {
    public ModelRenderer tail;
    public ModelRenderer body;
    public ModelRenderer tail_tip;
    public ModelRenderer left_leg;
    public ModelRenderer right_leg;
    public ModelRenderer left_arm;
    public ModelRenderer right_arm;
    public ModelRenderer head;
    public ModelRenderer snout;
    public ModelRenderer left_ear;
    public ModelRenderer ear_right;

    public RingTailedLemurModel() {
        this.textureWidth = 48;
        this.textureHeight = 32;
        this.tail_tip = new ModelRenderer(this, 8, 0);
        this.tail_tip.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.tail_tip.addBox(-1.0F, 1.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.left_ear = new ModelRenderer(this, 41, 21);
        this.left_ear.setRotationPoint(1.5F, 0.0F, -0.5F);
        this.left_ear.addBox(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.tail = new ModelRenderer(this, 0, 0);
        this.tail.setRotationPoint(0.0F, 14.5F, 4.5F);
        this.tail.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(tail, 1.0471975511965976F, 0.0F, 0.0F);
        this.left_leg = new ModelRenderer(this, 27, 0);
        this.left_leg.setRotationPoint(1.5F, 0.5F, 3.0F);
        this.left_leg.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(left_leg, -0.17453292519943295F, 0.0F, 0.0F);
        this.snout = new ModelRenderer(this, 32, 19);
        this.snout.setRotationPoint(0.0F, 1.0F, -3.0F);
        this.snout.addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.right_leg = new ModelRenderer(this, 27, 0);
        this.right_leg.mirror = true;
        this.right_leg.setRotationPoint(-1.5F, 0.5F, 3.0F);
        this.right_leg.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(right_leg, -0.17453292519943295F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 8, 0);
        this.body.setRotationPoint(0.0F, 17.0F, 0.0F);
        this.body.addBox(-2.0F, -2.5F, -5.5F, 4.0F, 5.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(body, 0.17453292519943295F, 0.0F, 0.0F);
        this.left_arm = new ModelRenderer(this, 37, 0);
        this.left_arm.setRotationPoint(1.3F, 0.6F, -3.0F);
        this.left_arm.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(left_arm, -0.17453292519943295F, 0.0F, 0.0F);
        this.ear_right = new ModelRenderer(this, 41, 21);
        this.ear_right.mirror = true;
        this.ear_right.setRotationPoint(1.5F, 0.0F, -0.5F);
        this.ear_right.addBox(-4.0F, -3.0F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 27, 24);
        this.head.setRotationPoint(0.0F, -2.0F, -5.1F);
        this.head.addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 4.0F, 0.01F, 0.0F, 0.0F);
        this.setRotateAngle(head, -0.17453292519943295F, 0.0F, 0.0F);
        this.right_arm = new ModelRenderer(this, 37, 0);
        this.right_arm.mirror = true;
        this.right_arm.setRotationPoint(-1.3F, 0.6F, -3.0F);
        this.right_arm.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(right_arm, -0.17453292519943295F, 0.0F, 0.0F);
        this.tail.addChild(this.tail_tip);
        this.head.addChild(this.left_ear);
        this.body.addChild(this.left_leg);
        this.head.addChild(this.snout);
        this.body.addChild(this.right_leg);
        this.body.addChild(this.left_arm);
        this.head.addChild(this.ear_right);
        this.body.addChild(this.head);
        this.body.addChild(this.right_arm);
    }

    @Override
    protected Iterable<ModelRenderer> getHeadParts() {
        return Collections.EMPTY_LIST;
    }

    @Override
    protected Iterable<ModelRenderer> getBodyParts() {
        return ImmutableList.of(body, tail);
    }

    @Override
    public void setRotationAngles(RingTailedLemurEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float speed = 1.0f;
        float degree = 1.0f;
        this.left_arm.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F) * degree * 1.0F * limbSwingAmount - 0.1F;
        this.head.rotateAngleZ = MathHelper.cos(limbSwing * speed * 0.2F) * degree * -0.2F * limbSwingAmount;
        this.right_arm.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F) * degree * -1.0F * limbSwingAmount - 0.1F;
        this.left_leg.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F) * degree * -1.0F * limbSwingAmount - 0.1F;
        this.right_leg.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F) * degree * 1.0F * limbSwingAmount - 0.1F;
        this.tail.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.4F) * degree * 0.4F * limbSwingAmount + 2.8F;
        this.tail_tip.rotateAngleX = limbSwingAmount - 1.5708F;
        this.head.rotationPointY = MathHelper.cos(limbSwing * speed * 0.4F) * degree * 0.05F * limbSwingAmount - 2.0F;
        this.body.rotateAngleZ = MathHelper.cos(limbSwing * speed * 0.2F) * degree * -0.2F * limbSwingAmount;
        this.left_leg.rotateAngleZ = MathHelper.cos(limbSwing * speed * 0.2F) * degree * 0.2F * limbSwingAmount;
        this.right_leg.rotateAngleZ = MathHelper.cos(limbSwing * speed * 0.2F) * degree * 0.2F * limbSwingAmount;
        this.left_arm.rotateAngleZ = MathHelper.cos(limbSwing * speed * 0.2F) * degree * 0.2F * limbSwingAmount;
        this.right_arm.rotateAngleZ = MathHelper.cos(limbSwing * speed * 0.2F) * degree * 0.2F * limbSwingAmount;
        this.body.rotationPointY = MathHelper.cos(limbSwing * speed * 0.4F) * degree * 0.05F * limbSwingAmount + 17.0F;
        this.left_arm.rotationPointY = MathHelper.cos(limbSwing * speed * 0.4F) * degree * -0.05F * limbSwingAmount + 0.6F;
        this.right_arm.rotationPointY = MathHelper.cos(limbSwing * speed * 0.4F) * degree * -0.05F * limbSwingAmount + 0.6F;
        this.left_leg.rotationPointY = MathHelper.cos(limbSwing * speed * 0.4F) * degree * -0.05F * limbSwingAmount + 0.5F;
        this.right_leg.rotationPointY = MathHelper.cos(limbSwing * speed * 0.4F) * degree * -0.05F * limbSwingAmount + 0.5F;
        this.tail.rotateAngleZ = MathHelper.cos(-1.0F + limbSwing * speed * 0.2F) * degree * 0.8F * limbSwingAmount;
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
