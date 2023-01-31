package org.videolan.vlc;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0003J,\u0010\r\u001a\u00020\b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0006H\u0002J\u001c\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\bH\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016J\u001a\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001c\u0010!\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001c\u0010#\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010&\u001a\u00020\bH\u0016J\u0010\u0010\'\u001a\u00020\b2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u0012H\u0016J\u0010\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u0012H\u0016J\b\u0010.\u001a\u00020\bH\u0016J\b\u0010/\u001a\u00020\bH\u0016J\u0010\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020)H\u0016J\b\u00102\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00063"}, d2 = {"Lorg/videolan/vlc/MediaSessionCallback;", "Landroid/support/v4/media/session/MediaSessionCompat$Callback;", "playbackService", "Lorg/videolan/vlc/PlaybackService;", "(Lorg/videolan/vlc/PlaybackService;)V", "prevActionSeek", "", "checkForSeekFailure", "", "forward", "isAndroidAutoHardKey", "keyEvent", "Landroid/view/KeyEvent;", "loadMedia", "mediaList", "", "Lorg/videolan/medialibrary/interfaces/media/MediaWrapper;", "position", "", "allowRandom", "onCustomAction", "actionId", "", "extras", "Landroid/os/Bundle;", "onFastForward", "onMediaButtonEvent", "mediaButtonEvent", "Landroid/content/Intent;", "onPause", "onPlay", "onPlayFromMediaId", "mediaId", "onPlayFromSearch", "query", "onPlayFromUri", "uri", "Landroid/net/Uri;", "onRewind", "onSeekTo", "pos", "", "onSetRepeatMode", "repeatMode", "onSetShuffleMode", "shuffleMode", "onSkipToNext", "onSkipToPrevious", "onSkipToQueueItem", "id", "onStop", "vlc-android_debug"})
public final class MediaSessionCallback extends android.support.v4.media.session.MediaSessionCompat.Callback {
    private final org.videolan.vlc.PlaybackService playbackService = null;
    private boolean prevActionSeek = false;
    
    public MediaSessionCallback(@org.jetbrains.annotations.NotNull()
    org.videolan.vlc.PlaybackService playbackService) {
        super();
    }
    
    @java.lang.Override()
    public void onPlay() {
    }
    
    @java.lang.Override()
    public boolean onMediaButtonEvent(@org.jetbrains.annotations.NotNull()
    android.content.Intent mediaButtonEvent) {
        return false;
    }
    
    /**
     * This function is based on the following KeyEvent captures. This may need to be updated if the behavior changes in the future.
     *
     * KeyEvent from Media Control UI:
     * {action=ACTION_DOWN, keyCode=KEYCODE_MEDIA_NEXT, scanCode=0, metaState=0, flags=0x0, repeatCount=0, eventTime=0, downTime=0, deviceId=-1, source=0x0, displayId=0}
     *
     * KeyEvent from Android Auto Steering Wheel Control:
     * {action=ACTION_DOWN, keyCode=KEYCODE_MEDIA_NEXT, scanCode=0, metaState=0, flags=0x4, repeatCount=0, eventTime=0, downTime=0, deviceId=0, source=0x0, displayId=0}
     *
     * KeyEvent from Android Auto Steering Wheel Control, Holding Switch (Long Press):
     * {action=ACTION_DOWN, keyCode=KEYCODE_MEDIA_NEXT, scanCode=0, metaState=0, flags=0x84, repeatCount=1, eventTime=0, downTime=0, deviceId=0, source=0x0, displayId=0}
     */
    @android.annotation.SuppressLint(value = {"LongLogTag"})
    private final boolean isAndroidAutoHardKey(android.view.KeyEvent keyEvent) {
        return false;
    }
    
    @java.lang.Override()
    public void onCustomAction(@org.jetbrains.annotations.Nullable()
    java.lang.String actionId, @org.jetbrains.annotations.Nullable()
    android.os.Bundle extras) {
    }
    
    @java.lang.Override()
    public void onPlayFromMediaId(@org.jetbrains.annotations.NotNull()
    java.lang.String mediaId, @org.jetbrains.annotations.Nullable()
    android.os.Bundle extras) {
    }
    
    private final void loadMedia(java.util.List<? extends org.videolan.medialibrary.interfaces.media.MediaWrapper> mediaList, int position, boolean allowRandom) {
    }
    
    private final void checkForSeekFailure(boolean forward) {
    }
    
    @java.lang.Override()
    public void onPlayFromUri(@org.jetbrains.annotations.Nullable()
    android.net.Uri uri, @org.jetbrains.annotations.Nullable()
    android.os.Bundle extras) {
    }
    
    @java.lang.Override()
    public void onPlayFromSearch(@org.jetbrains.annotations.Nullable()
    java.lang.String query, @org.jetbrains.annotations.Nullable()
    android.os.Bundle extras) {
    }
    
    @java.lang.Override()
    public void onSetShuffleMode(int shuffleMode) {
    }
    
    @java.lang.Override()
    public void onSetRepeatMode(int repeatMode) {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    @java.lang.Override()
    public void onStop() {
    }
    
    @java.lang.Override()
    public void onSkipToNext() {
    }
    
    @java.lang.Override()
    public void onSkipToPrevious() {
    }
    
    @java.lang.Override()
    public void onSeekTo(long pos) {
    }
    
    @java.lang.Override()
    public void onFastForward() {
    }
    
    @java.lang.Override()
    public void onRewind() {
    }
    
    @java.lang.Override()
    public void onSkipToQueueItem(long id) {
    }
}