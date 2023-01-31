package org.videolan.vlc.gui.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J \u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H&\u00a8\u0006\u0013"}, d2 = {"Lorg/videolan/vlc/gui/network/IStreamsFragmentDelegate;", "Lorg/videolan/vlc/gui/dialogs/CtxActionReceiver;", "getlistEventActor", "Lkotlinx/coroutines/channels/SendChannel;", "Lorg/videolan/vlc/gui/network/MrlAction;", "playMedia", "", "mw", "Lorg/videolan/medialibrary/interfaces/media/MediaWrapper;", "setup", "fragment", "Landroidx/fragment/app/Fragment;", "viewModel", "Lorg/videolan/vlc/viewmodels/StreamsModel;", "keyboardListener", "Lorg/videolan/vlc/gui/network/KeyboardListener;", "showContext", "position", "", "vlc-android_debug"})
public abstract interface IStreamsFragmentDelegate extends org.videolan.vlc.gui.dialogs.CtxActionReceiver {
    
    public abstract void setup(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment fragment, @org.jetbrains.annotations.NotNull()
    org.videolan.vlc.viewmodels.StreamsModel viewModel, @org.jetbrains.annotations.NotNull()
    org.videolan.vlc.gui.network.KeyboardListener keyboardListener);
    
    public abstract void showContext(int position);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.channels.SendChannel<org.videolan.vlc.gui.network.MrlAction> getlistEventActor();
    
    public abstract void playMedia(@org.jetbrains.annotations.NotNull()
    org.videolan.medialibrary.interfaces.media.MediaWrapper mw);
}