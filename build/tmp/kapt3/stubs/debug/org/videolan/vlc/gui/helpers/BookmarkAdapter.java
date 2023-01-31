package org.videolan.vlc.gui.helpers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\"#B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001c\u0010\u0019\u001a\u00020\u00162\n\u0010\u001a\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J*\u0010\u0019\u001a\u00020\u00162\n\u0010\u001a\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016J\u001c\u0010\u001e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0013H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u00a8\u0006$"}, d2 = {"Lorg/videolan/vlc/gui/helpers/BookmarkAdapter;", "Lorg/videolan/vlc/gui/DiffUtilAdapter;", "Lorg/videolan/medialibrary/interfaces/media/Bookmark;", "Lorg/videolan/vlc/gui/helpers/BookmarkAdapter$ViewHolder;", "bookmarkManager", "Lorg/videolan/vlc/gui/helpers/BookmarkAdapter$IBookmarkManager;", "(Lorg/videolan/vlc/gui/helpers/BookmarkAdapter$IBookmarkManager;)V", "getBookmarkManager", "()Lorg/videolan/vlc/gui/helpers/BookmarkAdapter$IBookmarkManager;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "createCB", "Lorg/videolan/vlc/gui/DiffUtilAdapter$DiffCallback;", "getItem", "position", "", "getItemCount", "onAttachedToRecyclerView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onBindViewHolder", "holder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "IBookmarkManager", "ViewHolder", "vlc-android_debug"})
public final class BookmarkAdapter extends org.videolan.vlc.gui.DiffUtilAdapter<org.videolan.medialibrary.interfaces.media.Bookmark, org.videolan.vlc.gui.helpers.BookmarkAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final org.videolan.vlc.gui.helpers.BookmarkAdapter.IBookmarkManager bookmarkManager = null;
    private final kotlin.Lazy handler$delegate = null;
    
    public BookmarkAdapter(@org.jetbrains.annotations.NotNull()
    org.videolan.vlc.gui.helpers.BookmarkAdapter.IBookmarkManager bookmarkManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.videolan.vlc.gui.helpers.BookmarkAdapter.IBookmarkManager getBookmarkManager() {
        return null;
    }
    
    private final android.os.Handler getHandler() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public org.videolan.vlc.gui.helpers.BookmarkAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    org.videolan.vlc.gui.helpers.BookmarkAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    org.videolan.vlc.gui.helpers.BookmarkAdapter.ViewHolder holder, int position, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Object> payloads) {
    }
    
    @java.lang.Override()
    public void onAttachedToRecyclerView(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView recyclerView) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.MainThread()
    @java.lang.Override()
    public org.videolan.medialibrary.interfaces.media.Bookmark getItem(int position) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected org.videolan.vlc.gui.DiffUtilAdapter.DiffCallback<org.videolan.medialibrary.interfaces.media.Bookmark> createCB() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lorg/videolan/vlc/gui/helpers/BookmarkAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lorg/videolan/vlc/gui/helpers/MarqueeViewHolder;", "v", "Landroid/view/View;", "(Lorg/videolan/vlc/gui/helpers/BookmarkAdapter;Landroid/view/View;)V", "binding", "Lorg/videolan/vlc/databinding/BookmarkItemBinding;", "getBinding", "()Lorg/videolan/vlc/databinding/BookmarkItemBinding;", "setBinding", "(Lorg/videolan/vlc/databinding/BookmarkItemBinding;)V", "titleView", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "onClick", "", "bookmark", "Lorg/videolan/medialibrary/interfaces/media/Bookmark;", "onMoreClick", "vlc-android_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder implements org.videolan.vlc.gui.helpers.MarqueeViewHolder {
        @org.jetbrains.annotations.NotNull()
        private org.videolan.vlc.databinding.BookmarkItemBinding binding;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView titleView = null;
        
        @android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.M)
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View v) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.videolan.vlc.databinding.BookmarkItemBinding getBinding() {
            return null;
        }
        
        public final void setBinding(@org.jetbrains.annotations.NotNull()
        org.videolan.vlc.databinding.BookmarkItemBinding p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public android.widget.TextView getTitleView() {
            return null;
        }
        
        public final void onClick(@org.jetbrains.annotations.NotNull()
        @kotlin.Suppress(names = {"UNUSED_PARAMETER"})
        android.view.View v, @org.jetbrains.annotations.NotNull()
        org.videolan.medialibrary.interfaces.media.Bookmark bookmark) {
        }
        
        public final void onMoreClick(@org.jetbrains.annotations.NotNull()
        android.view.View v, @org.jetbrains.annotations.NotNull()
        org.videolan.medialibrary.interfaces.media.Bookmark bookmark) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\"\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\u000b"}, d2 = {"Lorg/videolan/vlc/gui/helpers/BookmarkAdapter$IBookmarkManager;", "", "onBookmarkClick", "", "position", "", "bookmark", "Lorg/videolan/medialibrary/interfaces/media/Bookmark;", "onPopupMenu", "view", "Landroid/view/View;", "vlc-android_debug"})
    public static abstract interface IBookmarkManager {
        
        public abstract void onPopupMenu(@org.jetbrains.annotations.NotNull()
        android.view.View view, int position, @org.jetbrains.annotations.Nullable()
        org.videolan.medialibrary.interfaces.media.Bookmark bookmark);
        
        public abstract void onBookmarkClick(int position, @org.jetbrains.annotations.NotNull()
        org.videolan.medialibrary.interfaces.media.Bookmark bookmark);
    }
}