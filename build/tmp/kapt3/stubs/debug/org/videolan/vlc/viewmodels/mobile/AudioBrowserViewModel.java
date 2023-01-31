package org.videolan.vlc.viewmodels.mobile;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u00015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u00103\u001a\u000204H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u00a2\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0019\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u001f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020!0 0\u0014X\u0096\u0004\u00a2\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0019\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0014\u00a2\u0006\n\n\u0002\u0010)\u001a\u0004\b\'\u0010(R\u001a\u0010*\u001a\u00020&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0011\u0010/\u001a\u000200\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u00102\u00a8\u00066"}, d2 = {"Lorg/videolan/vlc/viewmodels/mobile/AudioBrowserViewModel;", "Lorg/videolan/vlc/viewmodels/MedialibraryViewModel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "albumsProvider", "Lorg/videolan/vlc/providers/medialibrary/AlbumsProvider;", "getAlbumsProvider", "()Lorg/videolan/vlc/providers/medialibrary/AlbumsProvider;", "artistsProvider", "Lorg/videolan/vlc/providers/medialibrary/ArtistsProvider;", "getArtistsProvider", "()Lorg/videolan/vlc/providers/medialibrary/ArtistsProvider;", "currentTab", "", "getCurrentTab", "()I", "setCurrentTab", "(I)V", "displayModeKeys", "", "", "getDisplayModeKeys", "()[Ljava/lang/String;", "[Ljava/lang/String;", "genresProvider", "Lorg/videolan/vlc/providers/medialibrary/GenresProvider;", "getGenresProvider", "()Lorg/videolan/vlc/providers/medialibrary/GenresProvider;", "playlistsProvider", "Lorg/videolan/vlc/providers/medialibrary/PlaylistsProvider;", "providers", "Lorg/videolan/vlc/providers/medialibrary/MedialibraryProvider;", "Lorg/videolan/medialibrary/media/MediaLibraryItem;", "getProviders", "()[Lorg/videolan/vlc/providers/medialibrary/MedialibraryProvider;", "[Lorg/videolan/vlc/providers/medialibrary/MedialibraryProvider;", "providersInCard", "", "getProvidersInCard", "()[Ljava/lang/Boolean;", "[Ljava/lang/Boolean;", "showResumeCard", "getShowResumeCard", "()Z", "setShowResumeCard", "(Z)V", "tracksProvider", "Lorg/videolan/vlc/providers/medialibrary/TracksProvider;", "getTracksProvider", "()Lorg/videolan/vlc/providers/medialibrary/TracksProvider;", "refresh", "", "Factory", "vlc-android_debug"})
public final class AudioBrowserViewModel extends org.videolan.vlc.viewmodels.MedialibraryViewModel {
    private int currentTab;
    @org.jetbrains.annotations.NotNull()
    private final org.videolan.vlc.providers.medialibrary.ArtistsProvider artistsProvider = null;
    @org.jetbrains.annotations.NotNull()
    private final org.videolan.vlc.providers.medialibrary.AlbumsProvider albumsProvider = null;
    @org.jetbrains.annotations.NotNull()
    private final org.videolan.vlc.providers.medialibrary.TracksProvider tracksProvider = null;
    @org.jetbrains.annotations.NotNull()
    private final org.videolan.vlc.providers.medialibrary.GenresProvider genresProvider = null;
    private final org.videolan.vlc.providers.medialibrary.PlaylistsProvider playlistsProvider = null;
    @org.jetbrains.annotations.NotNull()
    private final org.videolan.vlc.providers.medialibrary.MedialibraryProvider<? extends org.videolan.medialibrary.media.MediaLibraryItem>[] providers = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Boolean[] providersInCard = {true, true, false, false, true};
    private boolean showResumeCard;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String[] displayModeKeys = {"display_mode_audio_browser_artists", "display_mode_audio_browser_albums", "display_mode_audio_browser_track", "display_mode_audio_browser_genres", "display_mode_playlists_AudioOnly"};
    
    public AudioBrowserViewModel(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    public final int getCurrentTab() {
        return 0;
    }
    
    public final void setCurrentTab(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.videolan.vlc.providers.medialibrary.ArtistsProvider getArtistsProvider() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.videolan.vlc.providers.medialibrary.AlbumsProvider getAlbumsProvider() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.videolan.vlc.providers.medialibrary.TracksProvider getTracksProvider() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.videolan.vlc.providers.medialibrary.GenresProvider getGenresProvider() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public org.videolan.vlc.providers.medialibrary.MedialibraryProvider<? extends org.videolan.medialibrary.media.MediaLibraryItem>[] getProviders() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Boolean[] getProvidersInCard() {
        return null;
    }
    
    public final boolean getShowResumeCard() {
        return false;
    }
    
    public final void setShowResumeCard(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String[] getDisplayModeKeys() {
        return null;
    }
    
    @java.lang.Override()
    public void refresh() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J%\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0016\u00a2\u0006\u0002\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lorg/videolan/vlc/viewmodels/mobile/AudioBrowserViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "vlc-android_debug"})
    public static final class Factory extends androidx.lifecycle.ViewModelProvider.NewInstanceFactory {
        @org.jetbrains.annotations.NotNull()
        private final android.content.Context context = null;
        
        public Factory(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.Context getContext() {
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