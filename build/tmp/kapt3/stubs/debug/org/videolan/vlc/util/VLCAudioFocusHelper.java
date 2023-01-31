package org.videolan.vlc.util;

import java.lang.System;

@kotlin.Suppress(names = {"DEPRECATION"})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0003J\u0015\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0000\u00a2\u0006\u0002\b\u0017J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0003R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\fX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lorg/videolan/vlc/util/VLCAudioFocusHelper;", "", "service", "Lorg/videolan/vlc/PlaybackService;", "(Lorg/videolan/vlc/PlaybackService;)V", "audioFocusListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "audioFocusRequest", "Landroid/media/AudioFocusRequest;", "audioManager", "Landroid/media/AudioManager;", "hasAudioFocus", "", "lossTransient", "getLossTransient$vlc_android_debug", "()Z", "setLossTransient$vlc_android_debug", "(Z)V", "abandonAudioFocus", "", "changeAudioFocus", "", "acquire", "changeAudioFocus$vlc_android_debug", "createOnAudioFocusChangeListener", "requestAudioFocus", "vlc-android_debug"})
public final class VLCAudioFocusHelper {
    private final org.videolan.vlc.PlaybackService service = null;
    private android.media.AudioManager audioManager;
    private android.media.AudioFocusRequest audioFocusRequest;
    private boolean hasAudioFocus = false;
    @kotlin.jvm.Volatile()
    private volatile boolean lossTransient = false;
    private final android.media.AudioManager.OnAudioFocusChangeListener audioFocusListener = null;
    
    public VLCAudioFocusHelper(@org.jetbrains.annotations.NotNull()
    org.videolan.vlc.PlaybackService service) {
        super();
    }
    
    public final boolean getLossTransient$vlc_android_debug() {
        return false;
    }
    
    public final void setLossTransient$vlc_android_debug(boolean p0) {
    }
    
    public final void changeAudioFocus$vlc_android_debug(boolean acquire) {
    }
    
    @android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.O)
    private final int abandonAudioFocus() {
        return 0;
    }
    
    @android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.O)
    private final int requestAudioFocus() {
        return 0;
    }
    
    private final android.media.AudioManager.OnAudioFocusChangeListener createOnAudioFocusChangeListener() {
        return null;
    }
}