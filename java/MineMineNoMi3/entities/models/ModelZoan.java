package MineMineNoMi3.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumHandSide;
import MineMineNoMi3.Values;

public class ModelZoan extends ModelBase
{
    public ModelRenderer bipedLeftArmwear;
    public ModelRenderer bipedRightArmwear;
    public ModelRenderer bipedLeftLegwear;
    public ModelRenderer bipedRightLegwear;
    public ModelRenderer bipedBodyWear;
    private ModelRenderer bipedCape;
    private ModelRenderer bipedDeadmau5Head;
    public ModelRenderer bipedHead;
    public ModelRenderer bipedHeadwear;
    public ModelRenderer bipedBody;
    public ModelRenderer bipedRightArm;
    public ModelRenderer bipedLeftArm;
    public ModelRenderer bipedRightLeg;
    public ModelRenderer bipedLeftLeg;
 
    public ModelZoan()
    {
        super();
        this.bipedDeadmau5Head = new ModelRenderer(this, 24, 0);
        this.bipedDeadmau5Head.addBox(-3.0F, -6.0F, -1.0F, 6, 6, 1);
        this.bipedCape = new ModelRenderer(this, 0, 0);
        this.bipedCape.setTextureSize(64, 32);
        this.bipedCape.addBox(-5.0F, 0.0F, -1.0F, 10, 16, 1);

        this.bipedLeftArm = new ModelRenderer(this, 32, 48);
        this.bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4);
        this.bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.bipedLeftArmwear = new ModelRenderer(this, 48, 48);
        this.bipedLeftArmwear.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4);
        this.bipedLeftArmwear.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.bipedRightArmwear = new ModelRenderer(this, 40, 32);
        this.bipedRightArmwear.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4);
        this.bipedRightArmwear.setRotationPoint(-5.0F, 2.0F, 10.0F);

        this.bipedLeftLeg = new ModelRenderer(this, 16, 48);
        this.bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
        this.bipedLeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
        this.bipedLeftLegwear = new ModelRenderer(this, 0, 48);
        this.bipedLeftLegwear.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
        this.bipedLeftLegwear.setRotationPoint(1.9F, 12.0F, 0.0F);
        this.bipedRightLegwear = new ModelRenderer(this, 0, 32);
        this.bipedRightLegwear.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
        this.bipedRightLegwear.setRotationPoint(-1.9F, 12.0F, 0.0F);
        this.bipedBodyWear = new ModelRenderer(this, 16, 32);
        this.bipedBodyWear.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4);
        this.bipedBodyWear.setRotationPoint(0.0F, 0.0F, 0.0F);
     
    }

    public void render(Entity entity, float p_78088_2_, float limbSwing, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        super.render(entity, p_78088_2_, limbSwing, ageInTicks, netHeadYaw, headPitch, scale);
        GlStateManager.pushMatrix();
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        /*if(entity.getDataManager().get(Values.MODEL) == 0)
        {
            if (entity.isSneaking())
                GlStateManager.translate(0.0F, 0.2F, 0.0F);

            this.bipedLeftLegwear.render(scale);
            this.bipedRightLegwear.render(scale);
            this.bipedLeftArmwear.render(scale);
            this.bipedRightArmwear.render(scale);
            this.bipedBodyWear.render(scale);
        }*/

        GlStateManager.popMatrix();
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        copyModelAngles(this.bipedLeftLeg, this.bipedLeftLegwear);
        copyModelAngles(this.bipedRightLeg, this.bipedRightLegwear);
        copyModelAngles(this.bipedLeftArm, this.bipedLeftArmwear);
        copyModelAngles(this.bipedRightArm, this.bipedRightArmwear);
        copyModelAngles(this.bipedBody, this.bipedBodyWear);

        if (entityIn.isSneaking())
        {
            this.bipedCape.rotationPointY = 2.0F;
        }
        else
        {
            this.bipedCape.rotationPointY = 0.0F;
        }
    }
}