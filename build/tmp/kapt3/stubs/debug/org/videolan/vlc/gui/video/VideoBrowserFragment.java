package org.videolan.vlc.gui.video;

import java.lang.System;

/**
 * Fragment containing the video viewpager
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001SB\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u001e\u001a\u00020\u0007H\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000bH\u0016J\n\u0010#\u001a\u0004\u0018\u00010$H\u0002J\n\u0010%\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010&\u001a\u00020\u000bH\u0016J\b\u0010\'\u001a\u00020\u0007H\u0014J\u001c\u0010(\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u001c\u0010-\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J&\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0012\u00108\u001a\u00020!2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u00109\u001a\u00020!2\u0006\u0010:\u001a\u00020;H\u0016J \u0010<\u001a\u00020!2\u0006\u0010=\u001a\u00020;2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020;H\u0016J\u0010\u0010A\u001a\u00020!2\u0006\u0010=\u001a\u00020;H\u0016J\u0010\u0010B\u001a\u00020!2\u0006\u0010.\u001a\u00020/H\u0016J\b\u0010C\u001a\u00020!H\u0016J\b\u0010D\u001a\u00020!H\u0016J\u0010\u0010E\u001a\u00020!2\u0006\u0010F\u001a\u00020GH\u0016J\u0010\u0010H\u001a\u00020!2\u0006\u0010F\u001a\u00020GH\u0016J\u0010\u0010I\u001a\u00020!2\u0006\u0010F\u001a\u00020GH\u0016J\u001a\u0010J\u001a\u00020!2\u0006\u0010K\u001a\u0002012\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u0010L\u001a\u00020!H\u0002J\b\u0010M\u001a\u00020!H\u0016J\u0010\u0010N\u001a\u00020!2\u0006\u0010O\u001a\u00020\u0007H\u0016J\b\u0010P\u001a\u00020!H\u0002J\b\u0010Q\u001a\u00020!H\u0002J\b\u0010R\u001a\u00020!H\u0002R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\t\"\u0004\b\u0019\u0010\u0013R\u0012\u0010\u001a\u001a\u00060\u001bR\u00020\u0000X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006T"}, d2 = {"Lorg/videolan/vlc/gui/video/VideoBrowserFragment;", "Lorg/videolan/vlc/gui/BaseFragment;", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "Lorg/videolan/vlc/interfaces/Filterable;", "()V", "hasTabs", "", "getHasTabs", "()Z", "lastQuery", "", "layoutOnPageChangeListener", "Lcom/google/android/material/tabs/TabLayout$TabLayoutOnPageChangeListener;", "needToReopenSearch", "value", "playlistOnlyFavorites", "getPlaylistOnlyFavorites", "setPlaylistOnlyFavorites", "(Z)V", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "tcl", "videoGridOnlyFavorites", "getVideoGridOnlyFavorites", "setVideoGridOnlyFavorites", "videoPagerAdapter", "Lorg/videolan/vlc/gui/video/VideoBrowserFragment$VideoPagerAdapter;", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "allowedToExpand", "enableSearchOption", "filter", "", "query", "getCurrentFragment", "Landroidx/fragment/app/Fragment;", "getFilterQuery", "getTitle", "hasFAB", "onActionItemClicked", "mode", "Landroidx/appcompat/view/ActionMode;", "item", "Landroid/view/MenuItem;", "onCreateActionMode", "menu", "Landroid/view/Menu;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyActionMode", "onPageScrollStateChanged", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "onPrepareOptionsMenu", "onStart", "onStop", "onTabReselected", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabSelected", "onTabUnselected", "onViewCreated", "view", "reopenSearchIfNeeded", "restoreList", "setSearchVisibility", "visible", "setupTabLayout", "unSetTabLayout", "updateTabs", "VideoPagerAdapter", "vlc-android_debug"})
public final class VideoBrowserFragment extends org.videolan.vlc.gui.BaseFragment implements com.google.android.material.tabs.TabLayout.OnTabSelectedListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener, org.videolan.vlc.interfaces.Filterable {
    private org.videolan.vlc.gui.video.VideoBrowserFragment.VideoPagerAdapter videoPagerAdapter;
    private com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener layoutOnPageChangeListener;
    private final boolean hasTabs = true;
    private com.google.android.material.tabs.TabLayout tabLayout;
    private androidx.viewpager.widget.ViewPager viewPager;
    private boolean needToReopenSearch = false;
    private java.lang.String lastQuery = "";
    private final com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener tcl = null;
    private boolean videoGridOnlyFavorites = false;
    private boolean playlistOnlyFavorites = false;
    
    public VideoBrowserFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getTitle() {
        return null;
    }
    
    @java.lang.Override()
    public boolean getHasTabs() {
        return false;
    }
    
    public final boolean getVideoGridOnlyFavorites() {
        return false;
    }
    
    public final void setVideoGridOnlyFavorites(boolean value) {
    }
    
    public final boolean getPlaylistOnlyFavorites() {
        return false;
    }
    
    public final void setPlaylistOnlyFavorites(boolean value) {
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
    public void onStart() {
    }
    
    @java.lang.Override()
    public void onStop() {
    }
    
    @java.lang.Override()
    public boolean onCreateActionMode(@org.jetbrains.annotations.Nullable()
    androidx.appcompat.view.ActionMode mode, @org.jetbrains.annotations.Nullable()
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onActionItemClicked(@org.jetbrains.annotations.Nullable()
    androidx.appcompat.view.ActionMode mode, @org.jetbrains.annotations.Nullable()
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override()
    public void onDestroyActionMode(@org.jetbrains.annotations.Nullable()
    androidx.appcompat.view.ActionMode mode) {
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
    public void onPrepareOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu) {
    }
    
    /**
     * Reopens the search if the tab is changed
     */
    private final void reopenSearchIfNeeded() {
    }
    
    @java.lang.Override()
    public void onTabReselected(@org.jetbrains.annotations.NotNull()
    com.google.android.material.tabs.TabLayout.Tab tab) {
    }
    
    @java.lang.Override()
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }
    
    @java.lang.Override()
    public void onPageScrollStateChanged(int state) {
    }
    
    @java.lang.Override()
    public void onPageSelected(int position) {
    }
    
    private final void setupTabLayout() {
    }
    
    @java.lang.Override()
    protected boolean hasFAB() {
        return false;
    }
    
    private final void unSetTabLayout() {
    }
    
    /**
     * Finds current resumed fragment
     *
     * @return the current shown fragment
     */
    private final androidx.fragment.app.Fragment getCurrentFragment() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getFilterQuery() {
        return null;
    }
    
    @java.lang.Override()
    public boolean enableSearchOption() {
        return false;
    }
    
    @java.lang.Override()
    public void filter(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    @java.lang.Override()
    public void restoreList() {
    }
    
    @java.lang.Override()
    public void setSearchVisibility(boolean visible) {
    }
    
    @java.lang.Override()
    public boolean allowedToExpand() {
        return false;
    }
    
    private final void updateTabs() {
    }
    
    /**
     * View pager adapter hosting the video an playlist fragments
     *
     * @property fragmentManager the [FragmentManager] to be used
     */
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000e"}, d2 = {"Lorg/videolan/vlc/gui/video/VideoBrowserFragment$VideoPagerAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "(Lorg/videolan/vlc/gui/video/VideoBrowserFragment;Landroidx/fragment/app/FragmentManager;)V", "getFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", "position", "getPageTitle", "", "vlc-android_debug"})
    public final class VideoPagerAdapter extends androidx.fragment.app.FragmentPagerAdapter {
        @org.jetbrains.annotations.NotNull()
        private final androidx.fragment.app.FragmentManager fragmentManager = null;
        
        public VideoPagerAdapter(@org.jetbrains.annotations.NotNull()
        androidx.fragment.app.FragmentManager fragmentManager) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.fragment.app.FragmentManager getFragmentManager() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public androidx.fragment.app.Fragment getItem(int position) {
            return null;
        }
        
        @java.lang.Override()
        public int getCount() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.CharSequence getPageTitle(int position) {
            return null;
        }
    }
}