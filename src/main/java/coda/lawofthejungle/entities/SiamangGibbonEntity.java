package coda.lawofthejungle.entities;

import coda.lawofthejungle.init.LOTJEntities;
import coda.lawofthejungle.init.LOTJItems;
import coda.lawofthejungle.init.LOTJSounds;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IDayTimeReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;

public class SiamangGibbonEntity extends AnimalEntity {
    private static final DataParameter<Boolean> IS_BOOMING = EntityDataManager.createKey(SiamangGibbonEntity.class, DataSerializers.BOOLEAN);
    private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.CARROT, Items.APPLE);
    private static final int BOOM_TIMER = 500;
    private int boomTimer = BOOM_TIMER;

    public SiamangGibbonEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.15D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.0D, false, TEMPTATION_ITEMS));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
    }

    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 16.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25F);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return TEMPTATION_ITEMS.test(stack);
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENTITY_PIG_STEP, 0.15F, 1.0F);
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return LOTJSounds.SIAMANG_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return LOTJSounds.SIAMANG_DEATH.get();
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return LOTJSounds.SIAMANG_AMBIENT.get();
    }

    @Override
    public boolean onLivingFall(float distance, float damageMultiplier) {
        return false;
    }

    @Nullable
    @Override
    public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return LOTJEntities.SIAMANG_GIBBON.get().create(p_241840_1_);
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(IS_BOOMING, false);
    }

    @Override
    public void livingTick() {
        super.livingTick();
        long dayTime = world.getWorldInfo().getDayTime();

        if (dayTime == 23500) {
            playSound(LOTJSounds.SIAMANG_BOOMING.get(), 0.6F,  1.0F);
        }

        setBooming(dayTime >= 23500 && dayTime <= 23625);
    }

    public void setBooming(boolean isBooming) {
        this.getDataManager().set(IS_BOOMING, isBooming);
    }

    public boolean isBooming() {
        return this.getDataManager().get(IS_BOOMING);
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(LOTJItems.SIAMANG_GIBBON_SPAWN_EGG.get());
    }
}
