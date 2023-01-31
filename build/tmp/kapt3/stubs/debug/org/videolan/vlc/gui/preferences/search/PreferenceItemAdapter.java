package org.videolan.vlc.gui.preferences.search;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002#$B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0016\u001a\u00020\u0010J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J&\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016J\u0018\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001bH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006%"}, d2 = {"Lorg/videolan/vlc/gui/preferences/search/PreferenceItemAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lorg/videolan/vlc/gui/preferences/search/PreferenceItem;", "Lorg/videolan/vlc/gui/preferences/search/PreferenceItemAdapter$ViewHolder;", "handler", "Lorg/videolan/vlc/gui/preferences/search/PreferenceItemAdapter$ClickHandler;", "(Lorg/videolan/vlc/gui/preferences/search/PreferenceItemAdapter$ClickHandler;)V", "getHandler", "()Lorg/videolan/vlc/gui/preferences/search/PreferenceItemAdapter$ClickHandler;", "value", "", "query", "getQuery", "()Ljava/lang/String;", "setQuery", "(Ljava/lang/String;)V", "", "showTranslation", "getShowTranslation", "()Z", "setShowTranslation", "(Z)V", "isEmpty", "onBindViewHolder", "", "holder", "position", "", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ClickHandler", "ViewHolder", "vlc-android_debug"})
public final class PreferenceItemAdapter extends androidx.recyclerview.widget.ListAdapter<org.videolan.vlc.gui.preferences.search.PreferenceItem, org.videolan.vlc.gui.preferences.search.PreferenceItemAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final org.videolan.vlc.gui.preferences.search.PreferenceItemAdapter.ClickHandler handler = null;
    private boolean showTranslation = false;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String query = "";
    
    public PreferenceItemAdapter(@org.jetbrains.annotations.NotNull()
    org.videolan.vlc.gui.preferences.search.PreferenceItemAdapter.ClickHandler handler) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.videolan.vlc.gui.preferences.search.PreferenceItemAdapter.ClickHandler getHandler() {
        return null;
    }
    
    public final boolean getShowTranslation() {
        return false;
    }
    
    public final void setShowTranslation(boolean value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getQuery() {
        return null;
    }
    
    public final void setQuery(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public org.videolan.vlc.gui.preferences.search.PreferenceItemAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    org.videolan.vlc.gui.preferences.search.PreferenceItemAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    org.videolan.vlc.gui.preferences.search.PreferenceItemAdapter.ViewHolder holder, int position, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Object> payloads) {
    }
    
    public final boolean isEmpty() {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lorg/videolan/vlc/gui/preferences/search/PreferenceItemAdapter$ClickHandler;", "", "onClick", "", "item", "Lorg/videolan/vlc/gui/preferences/search/PreferenceItem;", "vlc-android_debug"})
    public static abstract interface ClickHandler {
        
        public abstract void onClick(@org.jetbrains.annotations.NotNull()
        org.videolan.vlc.gui.preferences.search.PreferenceItem item);
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lorg/videolan/vlc/gui/preferences/search/PreferenceItemAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "handler", "Lorg/videolan/vlc/gui/preferences/search/PreferenceItemAdapter$ClickHandler;", "binding", "Lorg/videolan/vlc/databinding/PreferenceItemBinding;", "(Lorg/videolan/vlc/gui/preferences/search/PreferenceItemAdapter$ClickHandler;Lorg/videolan/vlc/databinding/PreferenceItemBinding;)V", "getBinding", "()Lorg/videolan/vlc/databinding/PreferenceItemBinding;", "vlc-android_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final org.videolan.vlc.databinding.PreferenceItemBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        org.videolan.vlc.gui.preferences.search.PreferenceItemAdapter.ClickHandler handler, @org.jetbrains.annotations.NotNull()
        org.videolan.vlc.databinding.PreferenceItemBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.videolan.vlc.databinding.PreferenceItemBinding getBinding() {
            return null;
        }
    }
}