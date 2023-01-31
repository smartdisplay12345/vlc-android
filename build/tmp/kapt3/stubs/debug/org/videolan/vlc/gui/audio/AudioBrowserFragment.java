package org.videolan.vlc.gui.audio;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00bc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 Z2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001ZB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u001d\u001a\u00020\u000fH\u0016J\b\u0010\u001e\u001a\u00020\u000fH\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020\u0014H\u0014J\b\u0010!\u001a\u00020\"H\u0016J \u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020,H\u0016J\u0012\u0010-\u001a\u00020$2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J&\u00100\u001a\u0004\u0018\u00010&2\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0018\u00105\u001a\u00020$2\u0006\u0010\'\u001a\u00020\u00182\u0006\u00106\u001a\u000207H\u0016J\u0018\u00108\u001a\u00020$2\u0006\u00109\u001a\u00020\"2\u0006\u0010:\u001a\u00020;H\u0016J\u0010\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020&H\u0016J\u0010\u0010>\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020?H\u0016J\u0010\u0010@\u001a\u00020$2\u0006\u0010\'\u001a\u00020\u0018H\u0016J\u0010\u0010A\u001a\u00020$2\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u00020$2\u0006\u0010E\u001a\u00020/H\u0016J\b\u0010F\u001a\u00020$H\u0016J\u0010\u0010G\u001a\u00020$2\u0006\u0010H\u001a\u00020IH\u0016J\u0010\u0010J\u001a\u00020$2\u0006\u0010H\u001a\u00020IH\u0016J\u0010\u0010K\u001a\u00020$2\u0006\u0010H\u001a\u00020IH\u0016J\u0014\u0010L\u001a\u00020$2\n\u0010M\u001a\u0006\u0012\u0002\b\u00030NH\u0016J\u001a\u0010O\u001a\u00020$2\u0006\u0010=\u001a\u00020&2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0012\u0010P\u001a\u00020$2\b\b\u0002\u0010Q\u001a\u00020\u000fH\u0002J\b\u0010R\u001a\u00020$H\u0002J\u0012\u0010S\u001a\u00020$2\b\b\u0002\u0010T\u001a\u00020\u0018H\u0002J\b\u0010U\u001a\u00020$H\u0016J\u0010\u0010V\u001a\u00020$2\u0006\u0010W\u001a\u00020\u0018H\u0016J\b\u0010X\u001a\u00020$H\u0002J\b\u0010Y\u001a\u00020$H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006["}, d2 = {"Lorg/videolan/vlc/gui/audio/AudioBrowserFragment;", "Lorg/videolan/vlc/gui/audio/BaseAudioBrowser;", "Lorg/videolan/vlc/viewmodels/mobile/AudioBrowserViewModel;", "()V", "albumsAdapter", "Lorg/videolan/vlc/gui/audio/AudioBrowserAdapter;", "artistsAdapter", "audioPagerAdapter", "Lorg/videolan/vlc/gui/audio/AudioPagerAdapter;", "emptyView", "Lorg/videolan/vlc/gui/view/EmptyLoadingStateView;", "fastScroller", "Lorg/videolan/vlc/gui/view/FastScroller;", "genresAdapter", "hasTabs", "", "getHasTabs", "()Z", "lists", "", "Landroidx/recyclerview/widget/RecyclerView;", "playlistAdapter", "restorePositions", "Landroid/util/SparseArray;", "", "settings", "Landroid/content/SharedPreferences;", "songsAdapter", "spacing", "allowedToExpand", "enableSearchOption", "getCurrentAdapter", "getCurrentRV", "getTitle", "", "onClick", "", "v", "Landroid/view/View;", "position", "item", "Lorg/videolan/medialibrary/media/MediaLibraryItem;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onCtxAction", "option", "", "onDisplaySettingChanged", "key", "value", "", "onFabPlayClick", "view", "onOptionsItemSelected", "Landroid/view/MenuItem;", "onPageSelected", "onPrepareOptionsMenu", "menu", "Landroid/view/Menu;", "onSaveInstanceState", "outState", "onStart", "onTabReselected", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabSelected", "onTabUnselected", "onUpdateFinished", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "onViewCreated", "setFabPlayShuffleAllVisibility", "force", "setupModels", "setupProvider", "index", "setupTabLayout", "sortBy", "sort", "updateEmptyView", "updateTabs", "Companion", "vlc-android_debug"})
public final class AudioBrowserFragment extends org.videolan.vlc.gui.audio.BaseAudioBrowser<org.videolan.vlc.viewmodels.mobile.AudioBrowserViewModel> {
    private org.videolan.vlc.gui.audio.AudioPagerAdapter audioPagerAdapter;
    private org.videolan.vlc.gui.audio.AudioBrowserAdapter songsAdapter;
    private org.videolan.vlc.gui.audio.AudioBrowserAdapter artistsAdapter;
    private org.videolan.vlc.gui.audio.AudioBrowserAdapter albumsAdapter;
    private org.videolan.vlc.gui.audio.AudioBrowserAdapter genresAdapter;
    private org.videolan.vlc.gui.audio.AudioBrowserAdapter playlistAdapter;
    private org.videolan.vlc.gui.view.EmptyLoadingStateView emptyView;
    private org.videolan.vlc.gui.view.FastScroller fastScroller;
    private final java.util.List<androidx.recyclerview.widget.RecyclerView> lists = null;
    private android.content.SharedPreferences settings;
    private final boolean hasTabs = true;
    private int spacing = 0;
    private android.util.SparseArray<java.lang.Integer> restorePositions;
    @org.jetbrains.annotations.NotNull()
    public static final org.videolan.vlc.gui.audio.AudioBrowserFragment.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "VLC/AudioBrowserFragment";
    private static final java.lang.String KEY_LISTS_POSITIONS = "key_lists_position";
    private static final int MODE_TOTAL = 5;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG_ITEM = "ML_ITEM";
    
    public AudioBrowserFragment() {
        super();
    }
    
    @java.lang.Override()
    public boolean getHasTabs() {
        return false;
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onDisplaySettingChanged(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    java.lang.Object value) {
    }
    
    @java.lang.Override()
    public void onConfigurationChanged(@org.jetbrains.annotations.NotNull()
    android.content.res.Configuration newConfig) {
    }
    
    @java.lang.Override()
    public void onSaveInstanceState(@org.jetbrains.annotations.NotNull()
    android.os.Bundle outState) {
    }
    
    private final void setupModels() {
    }
    
    private final void setupProvider(int index) {
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    @java.lang.Override()
    public void onPrepareOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu) {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override()
    public void sortBy(int sort) {
    }
    
    @java.lang.Override()
    public void onFabPlayClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    private final void setFabPlayShuffleAllVisibility(boolean force) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getTitle() {
        return null;
    }
    
    @java.lang.Override()
    public boolean enableSearchOption() {
        return false;
    }
    
    private final void updateEmptyView() {
    }
    
    @java.lang.Override()
    public void setupTabLayout() {
    }
    
    /**
     * Setup the tabs custom views
     */
    private final void updateTabs() {
    }
    
    @java.lang.Override()
    public void onPageSelected(int position) {
    }
    
    @java.lang.Override()
    public void onTabSelected(@org.jetbrains.annotations.NotNull()
    com.google.android.material.tabs.TabLayout.Tab tab) {
    }
    
    @java.lang.Override()
    public void onTabUnselected(@org.jetbrains.annotations.NotNull()
    com.google.android.material.tabs.TabLayout.Tab tab) {
    }
    
    @java.lang.Override()
    public void onTabReselected(@org.jetbrains.annotations.NotNull()
    com.google.android.material.tabs.TabLayout.Tab tab) {
    }
    
    @java.lang.Override()
    public void onCtxAction(int position, long option) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View v, int position, @org.jetbrains.annotations.NotNull()
    org.videolan.medialibrary.media.MediaLibraryItem item) {
    }
    
    @java.lang.Override()
    public void onUpdateFinished(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.Adapter<?> adapter) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected androidx.recyclerview.widget.RecyclerView getCurrentRV() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public org.videolan.vlc.gui.audio.AudioBrowserAdapter getCurrentAdapter() {
        return null;
    }
    
    @java.lang.Override()
    public boolean allowedToExpand() {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lorg/videolan/vlc/gui/audio/AudioBrowserFragment$Companion;", "", "()V", "KEY_LISTS_POSITIONS", "", "MODE_TOTAL", "", "TAG", "TAG_ITEM", "vlc-android_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}