package org.videolan.vlc.gui.browser;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00b2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 L2\u00020\u00012\u00020\u0002:\u0001LB\u0005\u00a2\u0006\u0002\u0010\u0003JA\u0010\u0014\u001a\u00020\u001526\u0010\u0016\u001a2\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u001b\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00150\u0017H\u0096\u0001J\t\u0010\u001d\u001a\u00020\u0015H\u0096\u0001J\u0019\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0010H\u0096\u0001J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010%\u001a\u00020\u001bH\u0002J\b\u0010&\u001a\u00020\u0010H\u0016J\b\u0010\'\u001a\u00020\u001bH\u0014J\u001c\u0010(\u001a\u00020\u001b2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0012\u0010-\u001a\u00020\u00152\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u001c\u00100\u001a\u00020\u001b2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u00101\u001a\u0004\u0018\u000102H\u0016J&\u00103\u001a\u0004\u0018\u00010 2\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u0001072\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0012\u00108\u001a\u00020\u00152\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u00109\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010:\u001a\u00020\u00152\u0006\u00101\u001a\u000202H\u0016J\b\u0010;\u001a\u00020\u0015H\u0016J\b\u0010<\u001a\u00020\u0015H\u0016J\u001a\u0010=\u001a\u00020\u00152\u0006\u0010>\u001a\u00020 2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\t\u0010?\u001a\u00020\u0015H\u0096\u0001J\b\u0010@\u001a\u00020\u0015H\u0002J\u0010\u0010A\u001a\u00020\u00152\u0006\u0010B\u001a\u00020CH\u0002J\u001c\u0010D\u001a\u00020\u00152\f\u0010E\u001a\b\u0012\u0004\u0012\u00020G0FH\u0096\u0001\u00a2\u0006\u0002\u0010HJ\u0011\u0010I\u001a\u00020\u00152\u0006\u0010J\u001a\u00020KH\u0096\u0001R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006M"}, d2 = {"Lorg/videolan/vlc/gui/browser/MLStorageBrowserFragment;", "Lorg/videolan/vlc/gui/BaseFragment;", "Lorg/videolan/vlc/gui/browser/IStorageFragmentDelegate;", "()V", "alertDialog", "Landroidx/appcompat/app/AlertDialog;", "localEntry", "Lorg/videolan/vlc/gui/view/TitleListView;", "localViewModel", "Lorg/videolan/vlc/viewmodels/browser/BrowserModel;", "networkEntry", "networkMonitor", "Lorg/videolan/tools/NetworkMonitor;", "networkViewModel", "processingFolders", "Landroidx/collection/SimpleArrayMap;", "", "Landroid/widget/CheckBox;", "getProcessingFolders", "()Landroidx/collection/SimpleArrayMap;", "addBannedFoldersCallback", "", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "folder", "", "banned", "addEntryPointsCallback", "checkBoxAction", "v", "Landroid/view/View;", "mrl", "getBrowserContainer", "Lorg/videolan/vlc/gui/browser/BrowserContainer;", "Lorg/videolan/medialibrary/media/MediaLibraryItem;", "isNetwork", "getTitle", "hasFAB", "onActionItemClicked", "mode", "Landroidx/appcompat/view/ActionMode;", "item", "Landroid/view/MenuItem;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateActionMode", "menu", "Landroid/view/Menu;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyActionMode", "onOptionsItemSelected", "onPrepareOptionsMenu", "onStart", "onStop", "onViewCreated", "view", "removeEntryPointsCallback", "showAddDirectoryDialog", "updateNetworkEmptyView", "emptyLoading", "Lorg/videolan/vlc/gui/view/EmptyLoadingStateView;", "withAdapters", "adapters", "", "Lorg/videolan/vlc/gui/browser/StorageBrowserAdapter;", "([Lorg/videolan/vlc/gui/browser/StorageBrowserAdapter;)V", "withContext", "context", "Landroid/content/Context;", "Companion", "vlc-android_debug"})
public final class MLStorageBrowserFragment extends org.videolan.vlc.gui.BaseFragment implements org.videolan.vlc.gui.browser.IStorageFragmentDelegate {
    private org.videolan.vlc.gui.view.TitleListView localEntry;
    private org.videolan.vlc.gui.view.TitleListView networkEntry;
    private org.videolan.tools.NetworkMonitor networkMonitor;
    private org.videolan.vlc.viewmodels.browser.BrowserModel localViewModel;
    private org.videolan.vlc.viewmodels.browser.BrowserModel networkViewModel;
    private androidx.appcompat.app.AlertDialog alertDialog;
    @org.jetbrains.annotations.NotNull()
    public static final org.videolan.vlc.gui.browser.MLStorageBrowserFragment.Companion Companion = null;
    
    public MLStorageBrowserFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getTitle() {
        return null;
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
    protected boolean hasFAB() {
        return false;
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    @java.lang.Override()
    public void onStop() {
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
    
    private final void updateNetworkEmptyView(org.videolan.vlc.gui.view.EmptyLoadingStateView emptyLoading) {
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
    
    private final void showAddDirectoryDialog() {
    }
    
    private final org.videolan.vlc.gui.browser.BrowserContainer<org.videolan.medialibrary.media.MediaLibraryItem> getBrowserContainer(boolean isNetwork) {
        return null;
    }
    
    @java.lang.Override()
    public void addBannedFoldersCallback(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Boolean, kotlin.Unit> callback) {
    }
    
    @java.lang.Override()
    public void addEntryPointsCallback() {
    }
    
    @java.lang.Override()
    public void checkBoxAction(@org.jetbrains.annotations.NotNull()
    android.view.View v, @org.jetbrains.annotations.NotNull()
    java.lang.String mrl) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.collection.SimpleArrayMap<java.lang.String, android.widget.CheckBox> getProcessingFolders() {
        return null;
    }
    
    @java.lang.Override()
    public void removeEntryPointsCallback() {
    }
    
    @java.lang.Override()
    public void withAdapters(@org.jetbrains.annotations.NotNull()
    org.videolan.vlc.gui.browser.StorageBrowserAdapter[] adapters) {
    }
    
    @java.lang.Override()
    public void withContext(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lorg/videolan/vlc/gui/browser/MLStorageBrowserFragment$Companion;", "", "()V", "newInstance", "Lorg/videolan/vlc/gui/browser/MLStorageBrowserFragment;", "onboarding", "", "vlc-android_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.videolan.vlc.gui.browser.MLStorageBrowserFragment newInstance(boolean onboarding) {
            return null;
        }
    }
}