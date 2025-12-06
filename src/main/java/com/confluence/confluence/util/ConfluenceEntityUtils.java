package com.confluence.confluence.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.Optional;

public class ConfluenceEntityUtils {

    public static LivingEntity getLookedAtEntity(LivingEntity user, double distance) {
        Vec3 eyePos = user.getEyePosition();
        Vec3 lookVec = user.getLookAngle();
        Vec3 endPos = eyePos.add(lookVec.scale(distance));

        AABB box = user.getBoundingBox().expandTowards(lookVec.scale(distance)).inflate(1.0D);
        LivingEntity nearest = null;
        double nearestDist = distance * distance;

        for (LivingEntity target : user.level().getEntitiesOfClass(LivingEntity.class, box, e -> e != user && e.isAlive())) {
            AABB targetBox = target.getBoundingBox().inflate(0.3D);
            Optional<Vec3> hit = targetBox.clip(eyePos, endPos);
            if (hit.isPresent()) {
                double dist = eyePos.distanceToSqr(hit.get());
                if (dist < nearestDist) {
                    nearest = target;
                    nearestDist = dist;
                }
            }
        }
        return nearest;

    }

    public static BlockPos getLookedAtBlock(LivingEntity user, double distance) {
        Vec3 eyePos = user.getEyePosition();
        Vec3 lookVec = user.getLookAngle();
        Vec3 endPos = eyePos.add(lookVec.scale(distance));

        BlockHitResult result = user.level().clip(new ClipContext(eyePos, endPos, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, user));

        if (result.getType() == HitResult.Type.BLOCK) {return result.getBlockPos();}

        return null;
    }


}
