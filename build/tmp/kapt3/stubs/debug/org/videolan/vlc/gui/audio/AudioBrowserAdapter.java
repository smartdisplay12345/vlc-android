package org.videolan.vlc.gui.audio;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0016\u0018\u0000 c2\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003R\u00020\u00000\u00012\u00020\u00052\b\u0012\u0004\u0012\u00020\u00020\u00062\u00020\u0007:\u0004bcdeB=\b\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u00a2\u0006\u0002\u0010\u0011J\u0006\u0010<\u001a\u00020=J\b\u0010>\u001a\u00020\u000fH\u0002J\u0012\u0010?\u001a\u0004\u0018\u00010\u00022\u0006\u0010@\u001a\u00020\tH\u0016J\u0010\u0010A\u001a\u00020B2\u0006\u0010@\u001a\u00020\tH\u0016J\u0010\u0010C\u001a\u00020\t2\u0006\u0010@\u001a\u00020\tH\u0016J\b\u0010D\u001a\u00020\u000fH\u0016J\b\u0010E\u001a\u00020\u000fH\u0004J\u0010\u0010F\u001a\u00020\u000f2\u0006\u0010@\u001a\u00020\tH\u0002J\u0010\u0010G\u001a\u00020=2\u0006\u0010H\u001a\u00020IH\u0016J\"\u0010J\u001a\u00020=2\u0010\u0010K\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003R\u00020\u00002\u0006\u0010@\u001a\u00020\tH\u0016J0\u0010J\u001a\u00020=2\u0010\u0010K\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003R\u00020\u00002\u0006\u0010@\u001a\u00020\t2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020N0MH\u0016J\"\u0010O\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003R\u00020\u00002\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\tH\u0016J(\u0010S\u001a\u00020=2\u000e\u0010T\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010U2\u000e\u0010V\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010UH\u0016J\u0010\u0010W\u001a\u00020=2\u0006\u0010H\u001a\u00020IH\u0016J\u0010\u0010X\u001a\u00020=2\u0006\u0010@\u001a\u00020\tH\u0016J\u0018\u0010Y\u001a\u00020=2\u0006\u0010Z\u001a\u00020\t2\u0006\u0010[\u001a\u00020\tH\u0016J\u0018\u0010\\\u001a\u00020=2\u0006\u0010]\u001a\u00020\t2\u0006\u0010^\u001a\u00020\tH\u0016J\u001a\u0010_\u001a\u00020=2\u0010\u0010`\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003R\u00020\u0000H\u0016J\u0010\u0010a\u001a\u00020=2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eR\u001a\u0010\u0010\u001a\u00020\tX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u001a\u0010&\u001a\u00020\'X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0011\u0010,\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b,\u0010-R\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001a\u00100\u001a\u00020\tX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0013\"\u0004\b2\u0010\u0015R\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020\u000204\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0014\u0010\u000e\u001a\u00020\u000fX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010-R\u001a\u00108\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010-\"\u0004\b:\u0010;\u00a8\u0006f"}, d2 = {"Lorg/videolan/vlc/gui/audio/AudioBrowserAdapter;", "Landroidx/paging/PagedListAdapter;", "Lorg/videolan/medialibrary/media/MediaLibraryItem;", "Lorg/videolan/vlc/gui/audio/AudioBrowserAdapter$AbstractMediaItemViewHolder;", "Landroidx/databinding/ViewDataBinding;", "Lorg/videolan/vlc/gui/view/FastScroller$SeparatedAdapter;", "Lorg/videolan/tools/MultiSelectAdapter;", "Lorg/videolan/vlc/interfaces/SwipeDragHelperAdapter;", "type", "", "eventsHandler", "Lorg/videolan/vlc/interfaces/IEventsHandler;", "listEventsHandler", "Lorg/videolan/vlc/interfaces/IListEventsHandler;", "reorderable", "", "cardSize", "(ILorg/videolan/vlc/interfaces/IEventsHandler;Lorg/videolan/vlc/interfaces/IListEventsHandler;ZI)V", "getCardSize$vlc_android_debug", "()I", "setCardSize$vlc_android_debug", "(I)V", "defaultCover", "Landroid/graphics/drawable/BitmapDrawable;", "getDefaultCover", "()Landroid/graphics/drawable/BitmapDrawable;", "defaultCoverCard", "getEventsHandler", "()Lorg/videolan/vlc/interfaces/IEventsHandler;", "focusListener", "Lorg/videolan/resources/interfaces/FocusListener;", "focusNext", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "inflater", "Landroid/view/LayoutInflater;", "getInflater", "()Landroid/view/LayoutInflater;", "setInflater", "(Landroid/view/LayoutInflater;)V", "isEmpty", "()Z", "getListEventsHandler", "()Lorg/videolan/vlc/interfaces/IListEventsHandler;", "listImageWidth", "getListImageWidth", "setListImageWidth", "multiSelectHelper", "Lorg/videolan/tools/MultiSelectHelper;", "getMultiSelectHelper", "()Lorg/videolan/tools/MultiSelectHelper;", "getReorderable", "stopReorder", "getStopReorder", "setStopReorder", "(Z)V", "clear", "", "displayInCard", "getItem", "position", "getItemId", "", "getItemViewType", "hasSections", "inflaterInitialized", "isPositionValid", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onBindViewHolder", "holder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onCurrentListChanged", "previousList", "Landroidx/paging/PagedList;", "currentList", "onDetachedFromRecyclerView", "onItemDismiss", "onItemMove", "fromPosition", "toPosition", "onItemMoved", "dragFrom", "dragTo", "onViewRecycled", "h", "setOnFocusChangeListener", "AbstractMediaItemViewHolder", "Companion", "MediaItemCardViewHolder", "MediaItemViewHolder", "vlc-android_debug"})
public class AudioBrowserAdapter extends androidx.paging.PagedListAdapter<org.videolan.medialibrary.media.MediaLibraryItem, org.videolan.vlc.gui.audio.AudioBrowserAdapter.AbstractMediaItemViewHolder<androidx.databinding.ViewDataBinding>> implements org.videolan.vlc.gui.view.FastScroller.SeparatedAdapter, org.videolan.tools.MultiSelectAdapter<org.videolan.medialibrary.media.MediaLibraryItem>, org.videolan.vlc.interfaces.SwipeDragHelperAdapter {
    @org.jetbrains.annotations.NotNull()
    private final org.videolan.vlc.interfaces.IEventsHandler<org.videolan.medialibrary.media.MediaLibraryItem> eventsHandler = null;
    @org.jetbrains.annotations.Nullable()
    private final org.videolan.vlc.interfaces.IListEventsHandler listEventsHandler = null;
    private final boolean reorderable = false;
    private int cardSize;
    private int listImageWidth;
    @org.jetbrains.annotations.NotNull()
    private final org.videolan.tools.MultiSelectHelper<org.videolan.medialibrary.media.MediaLibraryItem> multiSelectHelper = null;
    @org.jetbrains.annotations.Nullable()
    private final android.graphics.drawable.BitmapDrawable defaultCover = null;
    private final android.graphics.drawable.BitmapDrawable defaultCoverCard = null;
    private int focusNext = -1;
    private org.videolan.resources.interfaces.FocusListener focusListener;
    public android.view.LayoutInflater inflater;
    private final kotlin.Lazy handler$delegate = null;
    private boolean stopReorder = false;
    @org.jetbrains.annotations.NotNull()
    public static final org.videolan.vlc.gui.audio.AudioBrowserAdapter.Companion Companion = null;
    private static final java.lang.String TAG = "VLC/AudioBrowserAdapter";
    private static final int UPDATE_PAYLOAD = 1;
    private static final int UPDATE_FAVORITE_STATE = 2;
    
    /**
     * Awful hack to workaround the [PagedListAdapter] not keeping track of notifyItemMoved operations
     */
    private static boolean preventNextAnim = false;
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<org.videolan.medialibrary.media.MediaLibraryItem> DIFF_CALLBACK = null;
    
    @kotlin.jvm.JvmOverloads()
    public AudioBrowserAdapter(int type, @org.jetbrains.annotations.NotNull()
    org.videolan.vlc.interfaces.IEventsHandler<org.videolan.medialibrary.media.MediaLibraryItem> eventsHandler) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads()
    public AudioBrowserAdapter(int type, @org.jetbrains.annotations.NotNull()
    org.videolan.vlc.interfaces.IEventsHandler<org.videolan.medialibrary.media.MediaLibraryItem> eventsHandler, @org.jetbrains.annotations.Nullable()
    org.videolan.vlc.interfaces.IListEventsHandler listEventsHandler) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads()
    public AudioBrowserAdapter(int type, @org.jetbrains.annotations.NotNull()
    org.videolan.vlc.interfaces.IEventsHandler<org.videolan.medialibrary.media.MediaLibraryItem> eventsHandler, @org.jetbrains.annotations.Nullable()
    org.videolan.vlc.interfaces.IListEventsHandler listEventsHandler, boolean reorderable) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads()
    public AudioBrowserAdapter(int type, @org.jetbrains.annotations.NotNull()
    org.videolan.vlc.interfaces.IEventsHandler<org.videolan.medialibrary.media.MediaLibraryItem> eventsHandler, @org.jetbrains.annotations.Nullable()
    org.videolan.vlc.interfaces.IListEventsHandler listEventsHandler, boolean reorderable, int cardSize) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final org.videolan.vlc.interfaces.IEventsHandler<org.videolan.medialibrary.media.MediaLibraryItem> getEventsHandler() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final org.videolan.vlc.interfaces.IListEventsHandler getListEventsHandler() {
        return null;
    }
    
    protected final boolean getReorderable() {
        return false;
    }
    
    public final int getCardSize$vlc_android_debug() {
        return 0;
    }
    
    public final void setCardSize$vlc_android_debug(int p0) {
    }
    
    protected final int getListImageWidth() {
        return 0;
    }
    
    protected final void setListImageWidth(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.videolan.tools.MultiSelectHelper<org.videolan.medialibrary.media.MediaLibraryItem> getMultiSelectHelper() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final android.graphics.drawable.BitmapDrawable getDefaultCover() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.LayoutInflater getInflater() {
        return null;
    }
    
    public final void setInflater(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater p0) {
    }
    
    private final android.os.Handler getHandler() {
        return null;
    }
    
    public final boolean getStopReorder() {
        return false;
    }
    
    public final void setStopReorder(boolean p0) {
    }
    
    protected final boolean inflaterInitialized() {
        return false;
    }
    
    public final boolean isEmpty() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    @java.lang.Override()
    public org.videolan.vlc.gui.audio.AudioBrowserAdapter.AbstractMediaItemViewHolder<androidx.databinding.ViewDataBinding> onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    private final boolean displayInCard() {
        return false;
    }
    
    @java.lang.Override()
    public void onAttachedToRecyclerView(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView recyclerView) {
    }
    
    @java.lang.Override()
    public void onDetachedFromRecyclerView(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView recyclerView) {
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    org.videolan.vlc.gui.audio.AudioBrowserAdapter.AbstractMediaItemViewHolder<androidx.databinding.ViewDataBinding> holder, int position) {
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    org.videolan.vlc.gui.audio.AudioBrowserAdapter.AbstractMediaItemViewHolder<androidx.databinding.ViewDataBinding> holder, int position, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.lang.Object> payloads) {
    }
    
    @java.lang.Override()
    public void onViewRecycled(@org.jetbrains.annotations.NotNull()
    org.videolan.vlc.gui.audio.AudioBrowserAdapter.AbstractMediaItemViewHolder<androidx.databinding.ViewDataBinding> h) {
    }
    
    private final boolean isPositionValid(int position) {
        return false;
    }
    
    @java.lang.Override()
    public long getItemId(int position) {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public org.videolan.medialibrary.media.MediaLibraryItem getItem(int position) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    public final void clear() {
    }
    
    @java.lang.Override()
    public void onCurrentListChanged(@org.jetbrains.annotations.Nullable()
    androidx.paging.PagedList<org.videolan.medialibrary.media.MediaLibraryItem> previousList, @org.jetbrains.annotations.Nullable()
    androidx.paging.PagedList<org.videolan.medialibrary.media.MediaLibraryItem> currentList) {
    }
    
    @java.lang.Override()
    public boolean hasSections() {
        return false;
    }
    
    @java.lang.Override()
    public void onItemMove(int fromPosition, int toPosition) {
    }
    
    @java.lang.Override()
    public void onItemMoved(int dragFrom, int dragTo) {
    }
    
    @java.lang.Override()
    public void onItemDismiss(int position) {
    }
    
    public final void setOnFocusChangeListener(@org.jetbrains.annotations.Nullable()
    org.videolan.resources.interfaces.FocusListener focusListener) {
    }
    
    @android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.M)
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0004\u0018\u00002\f\u0012\u0004\u0012\u00020\u00020\u0001R\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0018"}, d2 = {"Lorg/videolan/vlc/gui/audio/AudioBrowserAdapter$MediaItemViewHolder;", "Lorg/videolan/vlc/gui/audio/AudioBrowserAdapter$AbstractMediaItemViewHolder;", "Lorg/videolan/vlc/databinding/AudioBrowserItemBinding;", "Lorg/videolan/vlc/gui/audio/AudioBrowserAdapter;", "binding", "(Lorg/videolan/vlc/gui/audio/AudioBrowserAdapter;Lorg/videolan/vlc/databinding/AudioBrowserItemBinding;)V", "onTouchListener", "Landroid/view/View$OnTouchListener;", "getOnTouchListener", "()Landroid/view/View$OnTouchListener;", "setOnTouchListener", "(Landroid/view/View$OnTouchListener;)V", "titleView", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "recycle", "", "selectView", "selected", "", "setItem", "item", "Lorg/videolan/medialibrary/media/MediaLibraryItem;", "vlc-android_debug"})
    public final class MediaItemViewHolder extends org.videolan.vlc.gui.audio.AudioBrowserAdapter.AbstractMediaItemViewHolder<org.videolan.vlc.databinding.AudioBrowserItemBinding> {
        @org.jetbrains.annotations.NotNull()
        private android.view.View.OnTouchListener onTouchListener;
        @org.jetbrains.annotations.Nullable()
        private final android.widget.TextView titleView = null;
        
        public MediaItemViewHolder(@org.jetbrains.annotations.NotNull()
        org.videolan.vlc.databinding.AudioBrowserItemBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.view.View.OnTouchListener getOnTouchListener() {
            return null;
        }
        
        public final void setOnTouchListener(@org.jetbrains.annotations.NotNull()
        android.view.View.OnTouchListener p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        @java.lang.Override()
        public android.widget.TextView getTitleView() {
            return null;
        }
        
        @java.lang.Override()
        public void selectView(boolean selected) {
        }
        
        @java.lang.Override()
        public void setItem(@org.jetbrains.annotations.Nullable()
        org.videolan.medialibrary.media.MediaLibraryItem item) {
        }
        
        @java.lang.Override()
        public void recycle() {
        }
    }
    
    @android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.M)
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0004\u0018\u00002\f\u0012\u0004\u0012\u00020\u00020\u0001R\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0012"}, d2 = {"Lorg/videolan/vlc/gui/audio/AudioBrowserAdapter$MediaItemCardViewHolder;", "Lorg/videolan/vlc/gui/audio/AudioBrowserAdapter$AbstractMediaItemViewHolder;", "Lorg/videolan/vlc/databinding/AudioBrowserCardItemBinding;", "Lorg/videolan/vlc/gui/audio/AudioBrowserAdapter;", "binding", "(Lorg/videolan/vlc/gui/audio/AudioBrowserAdapter;Lorg/videolan/vlc/databinding/AudioBrowserCardItemBinding;)V", "titleView", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "recycle", "", "selectView", "selected", "", "setItem", "item", "Lorg/videolan/medialibrary/media/MediaLibraryItem;", "vlc-android_debug"})
    public final class MediaItemCardViewHolder extends org.videolan.vlc.gui.audio.AudioBrowserAdapter.AbstractMediaItemViewHolder<org.videolan.vlc.databinding.AudioBrowserCardItemBinding> {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView titleView = null;
        
        public MediaItemCardViewHolder(@org.jetbrains.annotations.NotNull()
        org.videolan.vlc.databinding.AudioBrowserCardItemBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public android.widget.TextView getTitleView() {
            return null;
        }
        
        @java.lang.Override()
        public void selectView(boolean selected) {
        }
        
        @java.lang.Override()
        public void setItem(@org.jetbrains.annotations.Nullable()
        org.videolan.medialibrary.media.MediaLibraryItem item) {
        }
        
        @java.lang.Override()
        public void recycle() {
        }
    }
    
    @android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.M)
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u00a7\u0004\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\bH\u0014J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0014\u001a\u00020\rH&J\u0012\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&R\u0011\u0010\u0007\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0018"}, d2 = {"Lorg/videolan/vlc/gui/audio/AudioBrowserAdapter$AbstractMediaItemViewHolder;", "T", "Landroidx/databinding/ViewDataBinding;", "Lorg/videolan/vlc/gui/helpers/SelectorViewHolder;", "Lorg/videolan/vlc/gui/helpers/MarqueeViewHolder;", "binding", "(Lorg/videolan/vlc/gui/audio/AudioBrowserAdapter;Landroidx/databinding/ViewDataBinding;)V", "canBeReordered", "", "getCanBeReordered", "()Z", "isSelected", "onClick", "", "v", "Landroid/view/View;", "onImageClick", "onLongClick", "onMainActionClick", "onMoreClick", "recycle", "setItem", "item", "Lorg/videolan/medialibrary/media/MediaLibraryItem;", "vlc-android_debug"})
    public abstract class AbstractMediaItemViewHolder<T extends androidx.databinding.ViewDataBinding> extends org.videolan.vlc.gui.helpers.SelectorViewHolder<T> implements org.videolan.vlc.gui.helpers.MarqueeViewHolder {
        
        public AbstractMediaItemViewHolder(@org.jetbrains.annotations.NotNull()
        T binding) {
            super(null);
        }
        
        public final boolean getCanBeReordered() {
            return false;
        }
        
        public final void onClick(@org.jetbrains.annotations.NotNull()
        android.view.View v) {
        }
        
        public final void onMoreClick(@org.jetbrains.annotations.NotNull()
        android.view.View v) {
        }
        
        public final boolean onLongClick(@org.jetbrains.annotations.NotNull()
        android.view.View v) {
            return false;
        }
        
        public final void onImageClick(@org.jetbrains.annotations.NotNull()
        android.view.View v) {
        }
        
        public final void onMainActionClick(@org.jetbrains.annotations.NotNull()
        android.view.View v) {
        }
        
        @java.lang.Override()
        protected boolean isSelected() {
            return false;
        }
        
        public abstract void setItem(@org.jetbrains.annotations.Nullable()
        org.videolan.medialibrary.media.MediaLibraryItem item);
        
        public abstract void recycle();
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lorg/videolan/vlc/gui/audio/AudioBrowserAdapter$Companion;", "", "()V", "DIFF_CALLBACK", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lorg/videolan/medialibrary/media/MediaLibraryItem;", "TAG", "", "UPDATE_FAVORITE_STATE", "", "UPDATE_PAYLOAD", "preventNextAnim", "", "vlc-android_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}