package com.enderio.base.common.capability;

import com.enderio.api.capability.IOwner;
import com.mojang.authlib.GameProfile;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.world.level.block.entity.SkullBlockEntity;
import org.jetbrains.annotations.Nullable;

public class Owner implements IOwner {
    private @Nullable GameProfile profile;

    @Override
    public @Nullable GameProfile getProfile() {
        return profile;
    }

    @Override
    public void setProfile(GameProfile profile, ProfileSetCallback callback) {
        synchronized (this) {
            this.profile = profile;
        }

        // Perform update.
        SkullBlockEntity.updateGameprofile(this.profile, newProfile -> {
            this.profile = newProfile;
            callback.profileSet(this.profile);
        });
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        if (profile != null) {
            CompoundTag ownerTag = new CompoundTag();
            NbtUtils.writeGameProfile(ownerTag, profile);
            tag.put("Owner", ownerTag);
        }
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        if (nbt.contains("Owner")) {
            profile = NbtUtils.readGameProfile(nbt.getCompound("Owner"));
        }
    }
}
