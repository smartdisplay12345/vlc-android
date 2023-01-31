package org.videolan.vlc.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lorg/videolan/vlc/util/IDialogManager;", "", "dialogCanceled", "", "dialog", "Lorg/videolan/libvlc/Dialog;", "fireDialog", "vlc-android_debug"})
public abstract interface IDialogManager {
    
    public abstract void fireDialog(@org.jetbrains.annotations.NotNull()
    org.videolan.libvlc.Dialog dialog);
    
    public abstract void dialogCanceled(@org.jetbrains.annotations.Nullable()
    org.videolan.libvlc.Dialog dialog);
}