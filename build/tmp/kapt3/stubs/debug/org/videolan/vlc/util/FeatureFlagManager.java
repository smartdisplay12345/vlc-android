package org.videolan.vlc.util;

import java.lang.System;

/**
 * This manager allows the user to enable / disable experimental features
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\u000f"}, d2 = {"Lorg/videolan/vlc/util/FeatureFlagManager;", "", "()V", "enable", "", "context", "Landroid/content/Context;", "feature", "Lorg/videolan/vlc/util/FeatureFlag;", "enabled", "", "getByKey", "key", "", "isEnabled", "vlc-android_debug"})
public final class FeatureFlagManager {
    @org.jetbrains.annotations.NotNull()
    public static final org.videolan.vlc.util.FeatureFlagManager INSTANCE = null;
    
    private FeatureFlagManager() {
        super();
    }
    
    public final boolean isEnabled(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    org.videolan.vlc.util.FeatureFlag feature) {
        return false;
    }
    
    public final void enable(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    org.videolan.vlc.util.FeatureFlag feature, boolean enabled) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.videolan.vlc.util.FeatureFlag getByKey(@org.jetbrains.annotations.NotNull()
    java.lang.String key) {
        return null;
    }
}