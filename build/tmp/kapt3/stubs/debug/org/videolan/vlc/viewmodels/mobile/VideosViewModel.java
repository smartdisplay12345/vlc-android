package org.videolan.vlc.viewmodels.mobile;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001NB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ\u001d\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0000\u00a2\u0006\u0002\b#J\u0015\u0010$\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"H\u0000\u00a2\u0006\u0002\b%J\u001b\u0010&\u001a\u00020\u001e2\f\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u00070(H\u0000\u00a2\u0006\u0002\b)J\u0015\u0010*\u001a\u00020+2\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u00a2\u0006\u0002\b,J!\u0010-\u001a\u0004\u0018\u00010\t2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020/0(H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00100J\u0019\u00101\u001a\u0002022\u0006\u00103\u001a\u00020/H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00104J\u0010\u00105\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013H\u0002J\u0019\u00106\u001a\u00020+2\u0006\u00103\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00107J\u0019\u00108\u001a\u0002092\u0006\u00103\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00107J\u0015\u0010:\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"H\u0000\u00a2\u0006\u0002\b;J!\u0010<\u001a\u00020+2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\"H\u0000\u00a2\u0006\u0002\b=J\u001f\u0010>\u001a\u00020+2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u00103\u001a\u00020/H\u0000\u00a2\u0006\u0002\b?J\u001b\u0010@\u001a\u00020\u001e2\f\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u00070(H\u0000\u00a2\u0006\u0002\bAJ;\u0010B\u001a\u00020+2\b\u0010\u0002\u001a\u0004\u0018\u00010 2\u0006\u0010C\u001a\u00020/2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010D\u001a\u0002022\b\b\u0002\u0010E\u001a\u000202H\u0000\u00a2\u0006\u0002\bFJ\u0014\u0010G\u001a\u00020\u001e2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020/0(J\u000e\u0010G\u001a\u00020\u001e2\u0006\u00103\u001a\u00020/J\u0016\u0010H\u001a\u00020\u001e2\u0006\u0010I\u001a\u00020\t2\u0006\u0010J\u001a\u00020KJ\u0014\u0010L\u001a\u00020\u001e2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00140(J\u000e\u0010L\u001a\u00020\u001e2\u0006\u0010\b\u001a\u00020\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R.\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u00132\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u00130\u0019X\u0096\u0004\u00a2\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006O"}, d2 = {"Lorg/videolan/vlc/viewmodels/mobile/VideosViewModel;", "Lorg/videolan/vlc/viewmodels/MedialibraryViewModel;", "context", "Landroid/content/Context;", "type", "Lorg/videolan/vlc/viewmodels/mobile/VideoGroupingType;", "folder", "Lorg/videolan/medialibrary/interfaces/media/Folder;", "group", "Lorg/videolan/medialibrary/interfaces/media/VideoGroup;", "(Landroid/content/Context;Lorg/videolan/vlc/viewmodels/mobile/VideoGroupingType;Lorg/videolan/medialibrary/interfaces/media/Folder;Lorg/videolan/medialibrary/interfaces/media/VideoGroup;)V", "getFolder", "()Lorg/videolan/medialibrary/interfaces/media/Folder;", "getGroup", "()Lorg/videolan/medialibrary/interfaces/media/VideoGroup;", "<set-?>", "groupingType", "getGroupingType", "()Lorg/videolan/vlc/viewmodels/mobile/VideoGroupingType;", "Lorg/videolan/vlc/providers/medialibrary/MedialibraryProvider;", "Lorg/videolan/medialibrary/media/MediaLibraryItem;", "provider", "getProvider", "()Lorg/videolan/vlc/providers/medialibrary/MedialibraryProvider;", "providers", "", "getProviders", "()[Lorg/videolan/vlc/providers/medialibrary/MedialibraryProvider;", "[Lorg/videolan/vlc/providers/medialibrary/MedialibraryProvider;", "addItemToPlaylist", "Lkotlinx/coroutines/Job;", "activity", "Landroidx/fragment/app/FragmentActivity;", "position", "", "addItemToPlaylist$vlc_android_debug", "append", "append$vlc_android_debug", "appendFoldersSelection", "selection", "", "appendFoldersSelection$vlc_android_debug", "changeGroupingType", "", "changeGroupingType$vlc_android_debug", "createGroup", "medias", "Lorg/videolan/medialibrary/interfaces/media/MediaWrapper;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "groupSimilar", "", "media", "(Lorg/videolan/medialibrary/interfaces/media/MediaWrapper;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadProvider", "markAsPlayed", "(Lorg/videolan/medialibrary/media/MediaLibraryItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markAsUnplayed", "", "play", "play$vlc_android_debug", "playAll", "playAll$vlc_android_debug", "playAudio", "playAudio$vlc_android_debug", "playFoldersSelection", "playFoldersSelection$vlc_android_debug", "playVideo", "mw", "fromStart", "forceAll", "playVideo$vlc_android_debug", "removeFromGroup", "renameGroup", "videoGroup", "newName", "", "ungroup", "groups", "Factory", "vlc-android_debug"})
public final class VideosViewModel extends org.videolan.vlc.viewmodels.MedialibraryViewModel {
    @org.jetbrains.annotations.Nullable()
    private final org.videolan.medialibrary.interfaces.media.Folder folder = null;
    @org.jetbrains.annotations.Nullable()
    private final org.videolan.medialibrary.interfaces.media.VideoGroup group = null;
    @org.jetbrains.annotations.NotNull()
    private org.videolan.vlc.viewmodels.mobile.VideoGroupingType groupingType;
    @org.jetbrains.annotations.NotNull()
    private org.videolan.vlc.providers.medialibrary.MedialibraryProvider<? extends org.videolan.medialibrary.media.MediaLibraryItem> provider;
    @org.jetbrains.annotations.NotNull()
    private final org.videolan.vlc.providers.medialibrary.MedialibraryProvider<? extends org.videolan.medialibrary.media.MediaLibraryItem>[] providers = null;
    
    public VideosViewModel(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    org.videolan.vlc.viewmodels.mobile.VideoGroupingType type, @org.jetbrains.annotations.Nullable()
    org.videolan.medialibrary.interfaces.media.Folder folder, @org.jetbrains.annotations.Nullable()
    org.videolan.medialibrary.interfaces.media.VideoGroup group) {
        super(null);
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.videolan.medialibrary.interfaces.media.Folder getFolder() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.videolan.medialibrary.interfaces.media.VideoGroup getGroup() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.videolan.vlc.viewmodels.mobile.VideoGroupingType getGroupingType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.videolan.vlc.providers.medialibrary.MedialibraryProvider<? extends org.videolan.medialibrary.media.MediaLibraryItem> getProvider() {
        return null;
    }
    
    private final org.videolan.vlc.providers.medialibrary.MedialibraryProvider<? extends org.videolan.medialibrary.media.MediaLibraryItem> loadProvider() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public org.videolan.vlc.providers.medialibrary.MedialibraryProvider<? extends org.videolan.medialibrary.media.MediaLibraryItem>[] getProviders() {
        return null;
    }
    
    public final void changeGroupingType$vlc_android_debug(@org.jetbrains.annotations.NotNull()
    org.videolan.vlc.viewmodels.mobile.VideoGroupingType type) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job play$vlc_android_debug(int position) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job append$vlc_android_debug(int position) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job playFoldersSelection$vlc_android_debug(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends org.videolan.medialibrary.interfaces.media.Folder> selection) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job addItemToPlaylist$vlc_android_debug(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentActivity activity, int position) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job appendFoldersSelection$vlc_android_debug(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends org.videolan.medialibrary.interfaces.media.Folder> selection) {
        return null;
    }
    
    public final void playVideo$vlc_android_debug(@org.jetbrains.annotations.Nullable()
    androidx.fragment.app.FragmentActivity context, @org.jetbrains.annotations.NotNull()
    org.videolan.medialibrary.interfaces.media.MediaWrapper mw, int position, boolean fromStart, boolean forceAll) {
    }
    
    public final void playAll$vlc_android_debug(@org.jetbrains.annotations.Nullable()
    androidx.fragment.app.FragmentActivity activity, int position) {
    }
    
    public final void playAudio$vlc_android_debug(@org.jetbrains.annotations.Nullable()
    androidx.fragment.app.FragmentActivity activity, @org.jetbrains.annotations.NotNull()
    org.videolan.medialibrary.interfaces.media.MediaWrapper media) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job renameGroup(@org.jetbrains.annotations.NotNull()
    org.videolan.medialibrary.interfaces.media.VideoGroup videoGroup, @org.jetbrains.annotations.NotNull()
    java.lang.String newName) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job removeFromGroup(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends org.videolan.medialibrary.interfaces.media.MediaWrapper> medias) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job removeFromGroup(@org.jetbrains.annotations.NotNull()
    org.videolan.medialibrary.interfaces.media.MediaWrapper media) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job ungroup(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends org.videolan.medialibrary.media.MediaLibraryItem> groups) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job ungroup(@org.jetbrains.annotations.NotNull()
    org.videolan.medialibrary.interfaces.media.VideoGroup group) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object createGroup(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends org.videolan.medialibrary.interfaces.media.MediaWrapper> medias, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super org.videolan.medialibrary.interfaces.media.VideoGroup> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object groupSimilar(@org.jetbrains.annotations.NotNull()
    org.videolan.medialibrary.interfaces.media.MediaWrapper media, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object markAsPlayed(@org.jetbrains.annotations.NotNull()
    org.videolan.medialibrary.media.MediaLibraryItem media, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object markAsUnplayed(@org.jetbrains.annotations.NotNull()
    org.videolan.medialibrary.media.MediaLibraryItem media, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<java.lang.Object> continuation) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ%\u0010\u0011\u001a\u0002H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0015H\u0016\u00a2\u0006\u0002\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lorg/videolan/vlc/viewmodels/mobile/VideosViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "context", "Landroid/content/Context;", "groupingType", "Lorg/videolan/vlc/viewmodels/mobile/VideoGroupingType;", "folder", "Lorg/videolan/medialibrary/interfaces/media/Folder;", "group", "Lorg/videolan/medialibrary/interfaces/media/VideoGroup;", "(Landroid/content/Context;Lorg/videolan/vlc/viewmodels/mobile/VideoGroupingType;Lorg/videolan/medialibrary/interfaces/media/Folder;Lorg/videolan/medialibrary/interfaces/media/VideoGroup;)V", "getContext", "()Landroid/content/Context;", "getFolder", "()Lorg/videolan/medialibrary/interfaces/media/Folder;", "getGroup", "()Lorg/videolan/medialibrary/interfaces/media/VideoGroup;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "vlc-android_debug"})
    public static final class Factory extends androidx.lifecycle.ViewModelProvider.NewInstanceFactory {
        @org.jetbrains.annotations.NotNull()
        private final android.content.Context context = null;
        private final org.videolan.vlc.viewmodels.mobile.VideoGroupingType groupingType = null;
        @org.jetbrains.annotations.Nullable()
        private final org.videolan.medialibrary.interfaces.media.Folder folder = null;
        @org.jetbrains.annotations.Nullable()
        private final org.videolan.medialibrary.interfaces.media.VideoGroup group = null;
        
        public Factory(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        org.videolan.vlc.viewmodels.mobile.VideoGroupingType groupingType, @org.jetbrains.annotations.Nullable()
        org.videolan.medialibrary.interfaces.media.Folder folder, @org.jetbrains.annotations.Nullable()
        org.videolan.medialibrary.interfaces.media.VideoGroup group) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.Context getContext() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final org.videolan.medialibrary.interfaces.media.Folder getFolder() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final org.videolan.medialibrary.interfaces.media.VideoGroup getGroup() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public <T extends androidx.lifecycle.ViewModel>T create(@org.jetbrains.annotations.NotNull()
        java.lang.Class<T> modelClass) {
            return null;
        }
    }
}