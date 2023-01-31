package org.videolan.vlc.gui.preferences;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\fJ\r\u0010\u000f\u001a\u00020\fH\u0000\u00a2\u0006\u0002\b\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\"\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u0012\u0010\u0019\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!H\u0016J\u0006\u0010\"\u001a\u00020\fJ\u0006\u0010#\u001a\u00020\fJ\u0006\u0010$\u001a\u00020\fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lorg/videolan/vlc/gui/preferences/PreferencesActivity;", "Lorg/videolan/vlc/gui/BaseActivity;", "()V", "displayTitle", "", "getDisplayTitle", "()Z", "mAppBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "searchRequestCode", "", "detectHeadset", "", "detect", "exitAndRescan", "expandBar", "expandBar$vlc_android_debug", "getSnackAnchorView", "Landroid/view/View;", "overAudioPlayer", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "setRestart", "setRestartApp", "updateArtists", "Companion", "vlc-android_debug"})
public final class PreferencesActivity extends org.videolan.vlc.gui.BaseActivity {
    private final int searchRequestCode = 167;
    private com.google.android.material.appbar.AppBarLayout mAppBarLayout;
    private final boolean displayTitle = true;
    @org.jetbrains.annotations.NotNull()
    public static final org.videolan.vlc.gui.preferences.PreferencesActivity.Companion Companion = null;
    
    public PreferencesActivity() {
        super();
    }
    
    @java.lang.Override()
    public boolean getDisplayTitle() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View getSnackAnchorView(boolean overAudioPlayer) {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void expandBar$vlc_android_debug() {
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    public final void exitAndRescan() {
    }
    
    public final void setRestart() {
    }
    
    public final void setRestartApp() {
    }
    
    public final void updateArtists() {
    }
    
    public final void detectHeadset(boolean detect) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lorg/videolan/vlc/gui/preferences/PreferencesActivity$Companion;", "", "()V", "launchWithPref", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "prefKey", "", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "vlc-android_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * Launch the preferences and redirect to a given preference
         * @param activity The calling activity
         * @param prefKey The preference key to redirect to
         * @throws NoSuchElementException if the key is not found
         */
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object launchWithPref(@org.jetbrains.annotations.NotNull()
        androidx.fragment.app.FragmentActivity activity, @org.jetbrains.annotations.NotNull()
        java.lang.String prefKey, @org.jetbrains.annotations.NotNull()
        kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
            return null;
        }
    }
}