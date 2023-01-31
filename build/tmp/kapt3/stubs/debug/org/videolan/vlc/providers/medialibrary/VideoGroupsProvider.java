package org.videolan.vlc.providers.medialibrary;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016\u00a2\u0006\u0002\u0010\u0010J#\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016\u00a2\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0013H\u0016\u00a8\u0006\u0017"}, d2 = {"Lorg/videolan/vlc/providers/medialibrary/VideoGroupsProvider;", "Lorg/videolan/vlc/providers/medialibrary/MedialibraryProvider;", "Lorg/videolan/medialibrary/media/MediaLibraryItem;", "context", "Landroid/content/Context;", "model", "Lorg/videolan/vlc/viewmodels/SortableModel;", "(Landroid/content/Context;Lorg/videolan/vlc/viewmodels/SortableModel;)V", "canSortByDuration", "", "canSortByInsertionDate", "canSortByLastModified", "canSortByMediaNumber", "getAll", "", "Lorg/videolan/medialibrary/interfaces/media/VideoGroup;", "()[Lorg/videolan/medialibrary/interfaces/media/VideoGroup;", "getPage", "loadSize", "", "startposition", "(II)[Lorg/videolan/medialibrary/media/MediaLibraryItem;", "getTotalCount", "vlc-android_debug"})
public final class VideoGroupsProvider extends org.videolan.vlc.providers.medialibrary.MedialibraryProvider<org.videolan.medialibrary.media.MediaLibraryItem> {
    
    public VideoGroupsProvider(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    org.videolan.vlc.viewmodels.SortableModel model) {
        super(null, null);
    }
    
    @java.lang.Override()
    public boolean canSortByDuration() {
        return false;
    }
    
    @java.lang.Override()
    public boolean canSortByInsertionDate() {
        return false;
    }
    
    @java.lang.Override()
    public boolean canSortByLastModified() {
        return false;
    }
    
    @java.lang.Override()
    public boolean canSortByMediaNumber() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public org.videolan.medialibrary.interfaces.media.VideoGroup[] getAll() {
        return null;
    }
    
    @java.lang.Override()
    public int getTotalCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public org.videolan.medialibrary.media.MediaLibraryItem[] getPage(int loadSize, int startposition) {
        return null;
    }
}