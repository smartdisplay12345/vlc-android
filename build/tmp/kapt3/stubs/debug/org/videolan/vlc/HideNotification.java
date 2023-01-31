package org.videolan.vlc;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lorg/videolan/vlc/HideNotification;", "Lorg/videolan/vlc/CbAction;", "remove", "", "(Z)V", "getRemove", "()Z", "vlc-android_debug"})
final class HideNotification extends org.videolan.vlc.CbAction {
    private final boolean remove = false;
    
    public HideNotification(boolean remove) {
        super();
    }
    
    public final boolean getRemove() {
        return false;
    }
}