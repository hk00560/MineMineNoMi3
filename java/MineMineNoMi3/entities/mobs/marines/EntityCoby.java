package MineMineNoMi3.entities.mobs.marines;

import WyPI.modules.WyHelper;
import WyPI.modules.WyHelper.Direction;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class EntityCoby extends MarineData
{
	private int ticksBeforeSoru = 60, ticksBeforeGeppo = 100;
	
	public EntityCoby(World world)
	{
		super(world);
	}
	
	public void applyEntityAttributes()
	{ 
		super.applyEntityAttributes(); 
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513D);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.63D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(60.0D);
	}

	public void onUpdate() 
	{
		Direction dir = WyHelper.instance().get4Directions(this);
		
		if(this.getAttackTarget() != null)
		{
			
			if(this.getHealth() < this.getMaxHealth()/2)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10);
			
			if(ticksBeforeSoru <= 0 && this.getDistanceSqToEntity(this.getAttackTarget()) < 180 && this.onGround)
			{
				if(this.getHealth() < this.getMaxHealth()/2)
				{
					if (dir == Direction.NORTH) this.motionZ -= 2.8;
					if (dir == Direction.SOUTH) this.motionZ += 2.8;
					if (dir == Direction.EAST) this.motionX += 2.8;
					if (dir == Direction.WEST) this.motionX -= 2.8;
					this.rotationPitch += 180;
				}
				else
				{
					if (dir == Direction.NORTH) this.motionZ -= 3.3;
					if (dir == Direction.SOUTH) this.motionZ += 3.3;
					if (dir == Direction.EAST) this.motionX += 3.3;
					if (dir == Direction.WEST) this.motionX -= 3.3;
					this.rotationPitch += 180;
				}
				this.ticksBeforeSoru = 60;
			}
			else
				this.ticksBeforeSoru--;
		}
		
		super.onUpdate();
	}
	
}
