package org.videolan.vlc.providers.medialibrary;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0016\u00a2\u0006\u0002\u0010\u0016J#\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0016\u00a2\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u0019H\u0016R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001d"}, d2 = {"Lorg/videolan/vlc/providers/medialibrary/VideosProvider;", "Lorg/videolan/vlc/providers/medialibrary/MedialibraryProvider;", "Lorg/videolan/medialibrary/interfaces/media/MediaWrapper;", "folder", "Lorg/videolan/medialibrary/interfaces/media/Folder;", "group", "Lorg/videolan/medialibrary/interfaces/media/VideoGroup;", "context", "Landroid/content/Context;", "model", "Lorg/videolan/vlc/viewmodels/SortableModel;", "(Lorg/videolan/medialibrary/interfaces/media/Folder;Lorg/videolan/medialibrary/interfaces/media/VideoGroup;Landroid/content/Context;Lorg/videolan/vlc/viewmodels/SortableModel;)V", "getFolder", "()Lorg/videolan/medialibrary/interfaces/media/Folder;", "getGroup", "()Lorg/videolan/medialibrary/interfaces/media/VideoGroup;", "canSortByDuration", "", "canSortByFileNameName", "canSortByLastModified", "getAll", "", "()[Lorg/videolan/medialibrary/interfaces/media/MediaWrapper;", "getPage", "loadSize", "", "startposition", "(II)[Lorg/videolan/medialibrary/interfaces/media/MediaWrapper;", "getTotalCount", "vlc-android_debug"})
public final class VideosProvider extends org.videolan.vlc.providers.medialibrary.MedialibraryProvider<org.videolan.medialibrary.interfaces.media.MediaWrapper> {
    @org.jetbrains.annotations.Nullable()
    private final org.videolan.medialibrary.interfaces.media.Folder folder = null;
    @org.jetbrains.annotations.Nullable()
    private final org.videolan.medialibrary.interfaces.media.VideoGroup group = null;
    
    public VideosProvider(@org.jetbrains.annotations.Nullable()
    org.videolan.medialibrary.interfaces.media.Folder folder, @org.jetbrains.annotations.Nullable()
    org.videolan.medialibrary.interfaces.media.VideoGroup group, @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    org.videolan.vlc.viewmodels.SortableModel model) {
        super(null, null);
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.videolan.medialibrary.interfaces.media.Folder getFolder() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.videolan.medialibrary.interfaces.media.VideoGroup getGroup() {
        return null;
    }
    
    @java.lang.Override()
    public boolean canSortByFileNameName() {
        return false;
    }
    
    @java.lang.Override()
    public boolean canSortByDuration() {
        return false;
    }
    
    @java.lang.Override()
    public boolean canSortByLastModified() {
        return false;
    }
    
    @java.lang.Override()
    public int getTotalCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public org.videolan.medialibrary.interfaces.media.MediaWrapper[] getPage(int loadSize, int startposition) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public org.videolan.medialibrary.interfaces.media.MediaWrapper[] getAll() {
        return null;
    }
}