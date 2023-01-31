package org.videolan.vlc.gui.video;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00ce\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 _2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001_B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0011H\u0016J\b\u0010%\u001a\u00020&H\u0016J\u0018\u0010\'\u001a\u00020\r2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016J\u0018\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020#2\u0006\u0010*\u001a\u00020\u0012H\u0002J\u0012\u0010.\u001a\u00020\u001b2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0018\u00101\u001a\u00020\r2\u0006\u0010(\u001a\u00020)2\u0006\u00102\u001a\u000203H\u0016J$\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u0001092\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0018\u0010:\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020#2\u0006\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u00020\u001bH\u0016J\u0010\u0010>\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020)H\u0016J\u0018\u0010?\u001a\u00020\u001b2\u0006\u0010@\u001a\u00020&2\u0006\u0010A\u001a\u00020BH\u0016J\u0010\u0010C\u001a\u00020\u001b2\u0006\u0010D\u001a\u000205H\u0016J\u0010\u0010E\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020#H\u0002J\u0010\u0010F\u001a\u00020\r2\u0006\u0010*\u001a\u00020+H\u0016J\u0018\u0010G\u001a\u00020\r2\u0006\u0010(\u001a\u00020)2\u0006\u00102\u001a\u000203H\u0016J\u0010\u0010H\u001a\u00020\u001b2\u0006\u00102\u001a\u000203H\u0016J\b\u0010I\u001a\u00020\u001bH\u0016J\b\u0010J\u001a\u00020\u001bH\u0016J\u0010\u0010K\u001a\u00020\u001b2\u0006\u0010L\u001a\u000200H\u0016J\b\u0010M\u001a\u00020\u001bH\u0016J\b\u0010N\u001a\u00020\u001bH\u0016J\u001a\u0010O\u001a\u00020\u001b2\u0006\u0010D\u001a\u0002052\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0010\u0010P\u001a\u00020\u001b2\u0006\u0010Q\u001a\u00020RH\u0002J\b\u0010S\u001a\u00020\u001bH\u0002J\u0010\u0010T\u001a\u00020\u001b2\u0006\u0010U\u001a\u00020\rH\u0016J\u0010\u0010V\u001a\u00020\u001b2\u0006\u0010W\u001a\u00020#H\u0016J\b\u0010X\u001a\u00020\u001bH\u0002J\u0006\u0010Y\u001a\u00020\u001bJ\b\u0010Z\u001a\u00020\u001bH\u0002J\u0014\u0010[\u001a\u00020\u001b*\u00020\\2\u0006\u0010*\u001a\u00020\u0012H\u0002J\f\u0010]\u001a\u00020\u001b*\u00020^H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\rX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006`"}, d2 = {"Lorg/videolan/vlc/gui/video/VideoGridFragment;", "Lorg/videolan/vlc/gui/browser/MediaBrowserFragment;", "Lorg/videolan/vlc/viewmodels/mobile/VideosViewModel;", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "Lorg/videolan/vlc/gui/dialogs/CtxActionReceiver;", "()V", "binding", "Lorg/videolan/vlc/databinding/VideoGridBinding;", "dataObserver", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "gridItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "isChild", "", "()Z", "isMainNavigationPoint", "multiSelectHelper", "Lorg/videolan/tools/MultiSelectHelper;", "Lorg/videolan/medialibrary/media/MediaLibraryItem;", "settings", "Landroid/content/SharedPreferences;", "thumbObs", "Landroidx/lifecycle/Observer;", "Lorg/videolan/medialibrary/interfaces/media/MediaWrapper;", "videoListAdapter", "Lorg/videolan/vlc/gui/video/VideoListAdapter;", "addToGroup", "", "selection", "", "changeGroupingType", "type", "Lorg/videolan/vlc/viewmodels/mobile/VideoGroupingType;", "checkFolderToParent", "count", "", "getMultiHelper", "getTitle", "", "onActionItemClicked", "mode", "Landroidx/appcompat/view/ActionMode;", "item", "Landroid/view/MenuItem;", "onClick", "position", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateActionMode", "menu", "Landroid/view/Menu;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onCtxAction", "option", "", "onDestroy", "onDestroyActionMode", "onDisplaySettingChanged", "key", "value", "", "onFabPlayClick", "view", "onLongClick", "onOptionsItemSelected", "onPrepareActionMode", "onPrepareOptionsMenu", "onRefresh", "onResume", "onSaveInstanceState", "outState", "onStart", "onStop", "onViewCreated", "renameGroup", "media", "Lorg/videolan/medialibrary/interfaces/media/VideoGroup;", "setDataObservers", "setFabPlayVisibility", "enable", "sortBy", "sort", "updateEmptyView", "updateSeenMediaMarker", "updateViewMode", "open", "Landroidx/fragment/app/FragmentActivity;", "process", "Lorg/videolan/vlc/gui/video/VideoAction;", "Companion", "vlc-android_debug"})
public final class VideoGridFragment extends org.videolan.vlc.gui.browser.MediaBrowserFragment<org.videolan.vlc.viewmodels.mobile.VideosViewModel> implements androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener, org.videolan.vlc.gui.dialogs.CtxActionReceiver {
    private androidx.recyclerview.widget.RecyclerView.AdapterDataObserver dataObserver;
    private org.videolan.vlc.gui.video.VideoListAdapter videoListAdapter;
    private org.videolan.tools.MultiSelectHelper<org.videolan.medialibrary.media.MediaLibraryItem> multiSelectHelper;
    private org.videolan.vlc.databinding.VideoGridBinding binding;
    private androidx.recyclerview.widget.RecyclerView.ItemDecoration gridItemDecoration;
    private android.content.SharedPreferences settings;
    private final boolean isChild = true;
    private final boolean isMainNavigationPoint = false;
    private final androidx.lifecycle.Observer<org.videolan.medialibrary.interfaces.media.MediaWrapper> thumbObs = null;
    @org.jetbrains.annotations.NotNull()
    public static final org.videolan.vlc.gui.video.VideoGridFragment.Companion Companion = null;
    
    public VideoGridFragment() {
        super();
    }
    
    @java.lang.Override()
    public boolean isChild() {
        return false;
    }
    
    @java.lang.Override()
    public boolean isMainNavigationPoint() {
        return false;
    }
    
    private final void open(androidx.fragment.app.FragmentActivity $this$open, org.videolan.medialibrary.media.MediaLibraryItem item) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setDataObservers() {
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
    
    private final void changeGroupingType(org.videolan.vlc.viewmodels.mobile.VideoGroupingType type) {
    }
    
    @org.jetbrains.annotations.NotNull()
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
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    @java.lang.Override()
    public void onStop() {
    }
    
    @java.lang.Override()
    public void onSaveInstanceState(@org.jetbrains.annotations.NotNull()
    android.os.Bundle outState) {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    @java.lang.Override()
    public org.videolan.tools.MultiSelectHelper<org.videolan.vlc.viewmodels.mobile.VideosViewModel> getMultiHelper() {
        return null;
    }
    
    private final void updateViewMode() {
    }
    
    @java.lang.Override()
    public void onFabPlayClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    private final void updateEmptyView() {
    }
    
    @java.lang.Override()
    public void onRefresh() {
    }
    
    @java.lang.Override()
    public void setFabPlayVisibility(boolean enable) {
    }
    
    @java.lang.Override()
    public boolean onCreateActionMode(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.view.ActionMode mode, @org.jetbrains.annotations.NotNull()
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onPrepareActionMode(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.view.ActionMode mode, @org.jetbrains.annotations.NotNull()
    android.view.Menu menu) {
        return false;
    }
    
    private final boolean checkFolderToParent(int count) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onActionItemClicked(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.view.ActionMode mode, @org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    private final void addToGroup(java.util.List<? extends org.videolan.medialibrary.media.MediaLibraryItem> selection) {
    }
    
    @java.lang.Override()
    public void onDestroyActionMode(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.view.ActionMode mode) {
    }
    
    public final void updateSeenMediaMarker() {
    }
    
    @java.lang.Override()
    public void onCtxAction(int position, long option) {
    }
    
    private final void renameGroup(org.videolan.medialibrary.interfaces.media.VideoGroup media) {
    }
    
    private final void process(org.videolan.vlc.gui.video.VideoAction $this$process) {
    }
    
    private final void onLongClick(int position) {
    }
    
    private final void onClick(int position, org.videolan.medialibrary.media.MediaLibraryItem item) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lorg/videolan/vlc/gui/video/VideoGridFragment$Companion;", "", "()V", "newInstance", "Lorg/videolan/vlc/gui/video/VideoGridFragment;", "vlc-android_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.videolan.vlc.gui.video.VideoGridFragment newInstance() {
            return null;
        }
    }
}