package org.videolan.vlc.gui.view;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007\u00a2\u0006\u0002\u0010\bJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J(\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0019H\u0002J \u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lorg/videolan/vlc/gui/view/RecyclerSectionItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "headerOffset", "", "sticky", "", "provider", "Lorg/videolan/vlc/providers/medialibrary/MedialibraryProvider;", "(IZLorg/videolan/vlc/providers/medialibrary/MedialibraryProvider;)V", "header", "Landroid/widget/TextView;", "headerView", "Landroid/view/View;", "drawHeader", "", "c", "Landroid/graphics/Canvas;", "child", "fixLayoutSize", "view", "parent", "Landroid/view/ViewGroup;", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "inflateHeaderView", "onDrawOver", "vlc-android_debug"})
public final class RecyclerSectionItemDecoration extends androidx.recyclerview.widget.RecyclerView.ItemDecoration {
    private final int headerOffset = 0;
    private final boolean sticky = false;
    private final org.videolan.vlc.providers.medialibrary.MedialibraryProvider<?> provider = null;
    private android.view.View headerView;
    private android.widget.TextView header;
    
    public RecyclerSectionItemDecoration(int headerOffset, boolean sticky, @org.jetbrains.annotations.NotNull()
    org.videolan.vlc.providers.medialibrary.MedialibraryProvider<?> provider) {
        super();
    }
    
    @java.lang.Override()
    public void getItemOffsets(@org.jetbrains.annotations.NotNull()
    android.graphics.Rect outRect, @org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView parent, @org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.State state) {
    }
    
    @java.lang.Override()
    public void onDrawOver(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas c, @org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView parent, @org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.State state) {
    }
    
    private final void drawHeader(android.graphics.Canvas c, android.view.View child, android.view.View headerView) {
    }
    
    private final android.view.View inflateHeaderView(androidx.recyclerview.widget.RecyclerView parent) {
        return null;
    }
    
    /**
     * Measures the header view to make sure its size is greater than 0 and will be drawn
     * https://yoda.entelect.co.za/view/9627/how-to-android-recyclerview-item-decorations
     */
    private final void fixLayoutSize(android.view.View view, android.view.ViewGroup parent) {
    }
}