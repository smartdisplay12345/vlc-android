package org.videolan.vlc.gui.dialogs;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0004\u001e\u001f !B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J&\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u001a\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lorg/videolan/vlc/gui/dialogs/SelectChapterDialog;", "Lorg/videolan/vlc/gui/dialogs/VLCBottomSheetDialogFragment;", "Lorg/videolan/vlc/gui/dialogs/IOnChapterSelectedListener;", "()V", "chapterList", "Landroidx/recyclerview/widget/RecyclerView;", "nestedScrollView", "Landroidx/core/widget/NestedScrollView;", "service", "Lorg/videolan/vlc/PlaybackService;", "getDefaultState", "", "initChapterList", "", "initialFocusedView", "Landroid/view/View;", "needToManageOrientation", "", "onChapterSelected", "position", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onServiceChanged", "onViewCreated", "view", "Chapter", "ChapterAdapter", "ChapterViewHolder", "Companion", "vlc-android_debug"})
public final class SelectChapterDialog extends org.videolan.vlc.gui.dialogs.VLCBottomSheetDialogFragment implements org.videolan.vlc.gui.dialogs.IOnChapterSelectedListener {
    @org.jetbrains.annotations.NotNull()
    public static final org.videolan.vlc.gui.dialogs.SelectChapterDialog.Companion Companion = null;
    private androidx.recyclerview.widget.RecyclerView chapterList;
    private androidx.core.widget.NestedScrollView nestedScrollView;
    private org.videolan.vlc.PlaybackService service;
    
    public SelectChapterDialog() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View initialFocusedView() {
        return null;
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
    
    private final void initChapterList() {
    }
    
    @java.lang.Override()
    public void onChapterSelected(int position) {
    }
    
    private final void onServiceChanged(org.videolan.vlc.PlaybackService service) {
    }
    
    @java.lang.Override()
    public int getDefaultState() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean needToManageOrientation() {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lorg/videolan/vlc/gui/dialogs/SelectChapterDialog$Chapter;", "", "name", "", "time", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getTime", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "vlc-android_debug"})
    public static final class Chapter {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String name = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String time = null;
        
        @org.jetbrains.annotations.NotNull()
        public final org.videolan.vlc.gui.dialogs.SelectChapterDialog.Chapter copy(@org.jetbrains.annotations.NotNull()
        java.lang.String name, @org.jetbrains.annotations.NotNull()
        java.lang.String time) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        public Chapter(@org.jetbrains.annotations.NotNull()
        java.lang.String name, @org.jetbrains.annotations.NotNull()
        java.lang.String time) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTime() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u000f\u001a\u00020\bH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0013\u001a\u00020\bH\u0016J\u001c\u0010\u0014\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bH\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lorg/videolan/vlc/gui/dialogs/SelectChapterDialog$ChapterAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lorg/videolan/vlc/gui/dialogs/SelectChapterDialog$ChapterViewHolder;", "Lorg/videolan/vlc/gui/dialogs/SelectChapterDialog;", "chapters", "", "Lorg/videolan/vlc/gui/dialogs/SelectChapterDialog$Chapter;", "selectedIndex", "", "listener", "Lorg/videolan/vlc/gui/dialogs/IOnChapterSelectedListener;", "(Lorg/videolan/vlc/gui/dialogs/SelectChapterDialog;Ljava/util/List;Ljava/lang/Integer;Lorg/videolan/vlc/gui/dialogs/IOnChapterSelectedListener;)V", "binding", "Lorg/videolan/vlc/databinding/ChapterListItemBinding;", "Ljava/lang/Integer;", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "vlc-android_debug"})
    public final class ChapterAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<org.videolan.vlc.gui.dialogs.SelectChapterDialog.ChapterViewHolder> {
        private final java.util.List<org.videolan.vlc.gui.dialogs.SelectChapterDialog.Chapter> chapters = null;
        private final java.lang.Integer selectedIndex = null;
        private final org.videolan.vlc.gui.dialogs.IOnChapterSelectedListener listener = null;
        private org.videolan.vlc.databinding.ChapterListItemBinding binding;
        
        public ChapterAdapter(@org.jetbrains.annotations.NotNull()
        java.util.List<org.videolan.vlc.gui.dialogs.SelectChapterDialog.Chapter> chapters, @org.jetbrains.annotations.Nullable()
        java.lang.Integer selectedIndex, @org.jetbrains.annotations.NotNull()
        org.videolan.vlc.gui.dialogs.IOnChapterSelectedListener listener) {
            super();
        }
        
        @java.lang.Override()
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
        org.videolan.vlc.gui.dialogs.SelectChapterDialog.ChapterViewHolder holder, int position) {
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public org.videolan.vlc.gui.dialogs.SelectChapterDialog.ChapterViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.ViewGroup parent, int viewType) {
            return null;
        }
        
        @java.lang.Override()
        public int getItemCount() {
            return 0;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lorg/videolan/vlc/gui/dialogs/SelectChapterDialog$ChapterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lorg/videolan/vlc/databinding/ChapterListItemBinding;", "listener", "Lorg/videolan/vlc/gui/dialogs/IOnChapterSelectedListener;", "(Lorg/videolan/vlc/gui/dialogs/SelectChapterDialog;Lorg/videolan/vlc/databinding/ChapterListItemBinding;Lorg/videolan/vlc/gui/dialogs/IOnChapterSelectedListener;)V", "getBinding", "()Lorg/videolan/vlc/databinding/ChapterListItemBinding;", "setBinding", "(Lorg/videolan/vlc/databinding/ChapterListItemBinding;)V", "onClick", "", "v", "Landroid/view/View;", "vlc-android_debug"})
    public final class ChapterViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private org.videolan.vlc.databinding.ChapterListItemBinding binding;
        private final org.videolan.vlc.gui.dialogs.IOnChapterSelectedListener listener = null;
        
        public ChapterViewHolder(@org.jetbrains.annotations.NotNull()
        org.videolan.vlc.databinding.ChapterListItemBinding binding, @org.jetbrains.annotations.NotNull()
        org.videolan.vlc.gui.dialogs.IOnChapterSelectedListener listener) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.videolan.vlc.databinding.ChapterListItemBinding getBinding() {
            return null;
        }
        
        public final void setBinding(@org.jetbrains.annotations.NotNull()
        org.videolan.vlc.databinding.ChapterListItemBinding p0) {
        }
        
        public final void onClick(@org.jetbrains.annotations.NotNull()
        @kotlin.Suppress(names = {"UNUSED_PARAMETER"})
        android.view.View v) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lorg/videolan/vlc/gui/dialogs/SelectChapterDialog$Companion;", "", "()V", "newInstance", "Lorg/videolan/vlc/gui/dialogs/SelectChapterDialog;", "vlc-android_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.videolan.vlc.gui.dialogs.SelectChapterDialog newInstance() {
            return null;
        }
    }
}