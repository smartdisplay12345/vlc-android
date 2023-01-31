package org.videolan.vlc.gui;

import java.lang.System;

/**
 * Activity showing the different libraries used by VLC for Android and their licenses
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lorg/videolan/vlc/gui/LibrariesActivity;", "Lorg/videolan/vlc/gui/BaseActivity;", "()V", "adapter", "Lorg/videolan/vlc/gui/LibrariesAdapter;", "binding", "Lorg/videolan/vlc/databinding/LicenseActivityBinding;", "getBinding$vlc_android_debug", "()Lorg/videolan/vlc/databinding/LicenseActivityBinding;", "setBinding$vlc_android_debug", "(Lorg/videolan/vlc/databinding/LicenseActivityBinding;)V", "displayTitle", "", "getDisplayTitle", "()Z", "model", "Lorg/videolan/vlc/gui/LicenseModel;", "getSnackAnchorView", "Landroid/view/View;", "overAudioPlayer", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "vlc-android_debug"})
public final class LibrariesActivity extends org.videolan.vlc.gui.BaseActivity {
    private org.videolan.vlc.gui.LibrariesAdapter adapter;
    private org.videolan.vlc.gui.LicenseModel model;
    public org.videolan.vlc.databinding.LicenseActivityBinding binding;
    private final boolean displayTitle = true;
    
    public LibrariesActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.videolan.vlc.databinding.LicenseActivityBinding getBinding$vlc_android_debug() {
        return null;
    }
    
    public final void setBinding$vlc_android_debug(@org.jetbrains.annotations.NotNull()
    org.videolan.vlc.databinding.LicenseActivityBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View getSnackAnchorView(boolean overAudioPlayer) {
        return null;
    }
    
    @java.lang.Override()
    public boolean getDisplayTitle() {
        return false;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
}