package org.videolan.vlc.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u0000\u00f0\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\u001a\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007\u001a\u001a\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007\u001a\u001a\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0007\u001a\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017\u001a\u001a\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0007\u001a \u0010\u001a\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002\u001a\u0015\u0010\u001d\u001a\u00020\u001e*\u00020\u001fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 \u001a\f\u0010!\u001a\u00020\u001e*\u0004\u0018\u00010\"\u001a\u0010\u0010#\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020\u00120$\u001a\u0012\u0010%\u001a\u00020&*\u00020\u001f2\u0006\u0010\'\u001a\u00020\u0001\u001a\u0012\u0010(\u001a\u00020)*\u00020\u000f2\u0006\u0010*\u001a\u00020\u001f\u001a\f\u0010+\u001a\u00020\u0017*\u0004\u0018\u00010\u000f\u001a\f\u0010,\u001a\u00020\u0017*\u0004\u0018\u00010\u000f\u001a\u001e\u0010-\u001a\u0002H.\"\n\b\u0000\u0010.\u0018\u0001*\u00020/*\u000200H\u0086\b\u00a2\u0006\u0002\u00101\u001a\u001e\u0010-\u001a\u0002H.\"\n\b\u0000\u0010.\u0018\u0001*\u00020/*\u000202H\u0086\b\u00a2\u0006\u0002\u00103\u001a\u001e\u00104\u001a\u0002H.\"\n\b\u0000\u0010.\u0018\u0001*\u00020/*\u000200H\u0086\b\u00a2\u0006\u0002\u00101\u001a\u0014\u00105\u001a\u000206*\u00020\u001f2\u0006\u00107\u001a\u000208H\u0007\u001a\n\u00109\u001a\u00020\u0001*\u00020\u0012\u001a\u0012\u0010:\u001a\u00020)*\u00020\u000f2\u0006\u0010*\u001a\u00020\u001f\u001a\n\u0010;\u001a\u00020\u0017*\u00020<\u001a\n\u0010=\u001a\u00020\u0017*\u00020<\u001a\u0011\u0010>\u001a\u0004\u0018\u00010\u0017*\u00020\u0001\u00a2\u0006\u0002\u0010?\u001a\n\u0010@\u001a\u00020\u001e*\u00020<\u001a\f\u0010A\u001a\u00020\u001e*\u0004\u0018\u00010B\u001a\f\u0010C\u001a\u00020\u001e*\u0004\u0018\u00010B\u001a\u001e\u0010D\u001a\u00020E\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0F2\u0006\u0010\u0005\u001a\u00020G\u001ag\u0010H\u001a\b\u0012\u0004\u0012\u0002HJ0I\"\u0004\b\u0000\u0010K\"\u0004\b\u0001\u0010J*\u00020\u00062\f\u0010L\u001a\b\u0012\u0004\u0012\u0002HK0I23\u0010M\u001a/\b\u0001\u0012\u0015\u0012\u0013\u0018\u0001HK\u00a2\u0006\f\bO\u0012\b\b\'\u0012\u0004\b\b(P\u0012\n\u0012\b\u0012\u0004\u0012\u0002HJ0Q\u0012\u0006\u0012\u0004\u0018\u00010&0N\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010R\u001a\n\u0010S\u001a\u00020\u0017*\u00020\u0017\u001a\u001c\u0010T\u001a\u00020U*\u0006\u0012\u0002\b\u00030V2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u000b0X\u001a\n\u0010Y\u001a\u00020Z*\u00020Z\u001a\u0016\u0010[\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00012\u0006\u0010\\\u001a\u00020\u0017\u001a\u0015\u0010]\u001a\u00020\u001e*\u00020\u0001H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010^\u001a\u001d\u0010_\u001a\u00020\u000b*\u00020`2\u0006\u0010a\u001a\u00020BH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010b\u001a\u0012\u0010_\u001a\u00020\u000b*\u0002022\u0006\u0010c\u001a\u00020d\u001a\u0018\u0010_\u001a\u00020E*\u0002022\f\u0010e\u001a\b\u0012\u0004\u0012\u00020B0$\u001a\u0012\u0010f\u001a\u00020\u000b*\u0002002\u0006\u0010a\u001a\u00020B\u001a\n\u0010g\u001a\u00020\u0017*\u00020\u0017\u001a\u0018\u0010h\u001a\b\u0012\u0004\u0012\u00020B0i*\b\u0012\u0004\u0012\u00020B0$H\u0007\u001a\n\u0010j\u001a\u00020\u001e*\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006k"}, d2 = {"fileReplacementMarker", "", "folderReplacementMarker", "missingReplacementMarker", "presentReplacementMarker", "scope", "Lkotlinx/coroutines/CoroutineScope;", "Landroid/view/View;", "getScope", "(Landroid/view/View;)Lkotlinx/coroutines/CoroutineScope;", "asyncText", "", "view", "Landroid/widget/TextView;", "text", "", "asyncTextItem", "item", "Lorg/videolan/medialibrary/media/MediaLibraryItem;", "browserDescription", "description", "generateResolutionClass", "width", "", "height", "presenceDescription", "setTextAsync", "params", "Landroidx/core/text/PrecomputedTextCompat$Params;", "awaitMedialibraryStarted", "", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "canExpand", "Lorg/videolan/libvlc/Media;", "determineMaxNbOfDigits", "", "getAppSystemService", "", "name", "getDescriptionSpan", "Landroid/text/SpannableString;", "context", "getFilesNumber", "getFolderNumber", "getModel", "T", "Landroidx/lifecycle/ViewModel;", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)Landroidx/lifecycle/ViewModel;", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)Landroidx/lifecycle/ViewModel;", "getModelWithActivity", "getPendingIntent", "Landroid/app/PendingIntent;", "iPlay", "Landroid/content/Intent;", "getPresenceDescription", "getPresenceDescriptionSpan", "getScreenHeight", "Landroid/app/Activity;", "getScreenWidth", "getStartingNumber", "(Ljava/lang/String;)Ljava/lang/Integer;", "hasNotch", "isBrowserMedia", "Lorg/videolan/medialibrary/interfaces/media/MediaWrapper;", "isMedia", "launchWhenStarted", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/lifecycle/LifecycleCoroutineScope;", "map", "Landroidx/lifecycle/LiveData;", "Y", "X", "source", "f", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "value", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/lifecycle/LiveData;Lkotlin/jvm/functions/Function2;)Landroidx/lifecycle/LiveData;", "numberOfDigits", "onAnyChange", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "listener", "Lkotlin/Function0;", "random", "", "sanitizeStringForAlphaCompare", "nbOfDigits", "scanAllowed", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "share", "Landroidx/appcompat/app/AppCompatActivity;", "media", "(Landroidx/appcompat/app/AppCompatActivity;Lorg/videolan/medialibrary/interfaces/media/MediaWrapper;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "file", "Ljava/io/File;", "medias", "showParentFolder", "toPixel", "updateWithMLMeta", "", "validateLocation", "vlc-android_debug"})
public final class KextensionsKt {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String folderReplacementMarker = "\u00a7*\u00a7";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String fileReplacementMarker = "*\u00a7*";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String presentReplacementMarker = "\u00a7*\u00a7";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String missingReplacementMarker = "*\u00a7*";
    
    public static final boolean validateLocation(@org.jetbrains.annotations.NotNull()
    java.lang.String $this$validateLocation) {
        return false;
    }
    
    public static final boolean canExpand(@org.jetbrains.annotations.Nullable()
    org.videolan.libvlc.Media $this$canExpand) {
        return false;
    }
    
    public static final void share(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentActivity $this$share, @org.jetbrains.annotations.NotNull()
    java.io.File file) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.Object share(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.app.AppCompatActivity $this$share, @org.jetbrains.annotations.NotNull()
    org.videolan.medialibrary.interfaces.media.MediaWrapper media, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p2) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final kotlinx.coroutines.Job share(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentActivity $this$share, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends org.videolan.medialibrary.interfaces.media.MediaWrapper> medias) {
        return null;
    }
    
    public static final boolean isMedia(@org.jetbrains.annotations.Nullable()
    org.videolan.medialibrary.interfaces.media.MediaWrapper $this$isMedia) {
        return false;
    }
    
    public static final boolean isBrowserMedia(@org.jetbrains.annotations.Nullable()
    org.videolan.medialibrary.interfaces.media.MediaWrapper $this$isBrowserMedia) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.Object getAppSystemService(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$getAppSystemService, @org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
    
    public static final long random(long $this$random) {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.Object awaitMedialibraryStarted(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$awaitMedialibraryStarted, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.WorkerThread()
    public static final java.util.List<org.videolan.medialibrary.interfaces.media.MediaWrapper> updateWithMLMeta(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends org.videolan.medialibrary.interfaces.media.MediaWrapper> $this$updateWithMLMeta) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.Object scanAllowed(@org.jetbrains.annotations.NotNull()
    java.lang.String $this$scanAllowed, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final <X extends java.lang.Object, Y extends java.lang.Object>androidx.lifecycle.LiveData<Y> map(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope $this$map, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LiveData<X> source, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super X, ? super kotlin.coroutines.Continuation<? super Y>, ? extends java.lang.Object> f) {
        return null;
    }
    
    @androidx.databinding.BindingAdapter(value = {"app:asyncText"}, requireAll = false)
    public static final void asyncText(@org.jetbrains.annotations.NotNull()
    android.widget.TextView view, @org.jetbrains.annotations.Nullable()
    java.lang.CharSequence text) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"app:asyncText"}, requireAll = false)
    public static final void asyncTextItem(@org.jetbrains.annotations.NotNull()
    android.widget.TextView view, @org.jetbrains.annotations.Nullable()
    org.videolan.medialibrary.media.MediaLibraryItem item) {
    }
    
    private static final void setTextAsync(android.widget.TextView view, java.lang.CharSequence text, androidx.core.text.PrecomputedTextCompat.Params params) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"app:browserDescription"}, requireAll = false)
    public static final void browserDescription(@org.jetbrains.annotations.NotNull()
    android.widget.TextView view, @org.jetbrains.annotations.Nullable()
    java.lang.String description) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final android.text.SpannableString getDescriptionSpan(@org.jetbrains.annotations.NotNull()
    java.lang.CharSequence $this$getDescriptionSpan, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    /**
     * Get the folder number from the formatted string
     *
     * @return the folder number
     */
    public static final int getFolderNumber(@org.jetbrains.annotations.Nullable()
    java.lang.CharSequence $this$getFolderNumber) {
        return 0;
    }
    
    /**
     * Get the file number from the formatted string
     *
     * @return the file number
     */
    public static final int getFilesNumber(@org.jetbrains.annotations.Nullable()
    java.lang.CharSequence $this$getFilesNumber) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getPresenceDescription(@org.jetbrains.annotations.NotNull()
    org.videolan.medialibrary.media.MediaLibraryItem $this$getPresenceDescription) {
        return null;
    }
    
    @androidx.databinding.BindingAdapter(value = {"app:presenceDescription"}, requireAll = false)
    public static final void presenceDescription(@org.jetbrains.annotations.NotNull()
    android.widget.TextView view, @org.jetbrains.annotations.Nullable()
    java.lang.String description) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final android.text.SpannableString getPresenceDescriptionSpan(@org.jetbrains.annotations.NotNull()
    java.lang.CharSequence $this$getPresenceDescriptionSpan, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    public static final int toPixel(int $this$toPixel) {
        return 0;
    }
    
    public static final int getScreenWidth(@org.jetbrains.annotations.NotNull()
    android.app.Activity $this$getScreenWidth) {
        return 0;
    }
    
    public static final int getScreenHeight(@org.jetbrains.annotations.NotNull()
    android.app.Activity $this$getScreenHeight) {
        return 0;
    }
    
    /**
     * Detect if the device has a notch.
     * @return true if the device has a notch
     * @throws NullPointerException if the window is not attached yet
     */
    public static final boolean hasNotch(@org.jetbrains.annotations.NotNull()
    android.app.Activity $this$hasNotch) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.O)
    public static final android.app.PendingIntent getPendingIntent(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$getPendingIntent, @org.jetbrains.annotations.NotNull()
    android.content.Intent iPlay) {
        return null;
    }
    
    /**
     * Register an [RecyclerView.AdapterDataObserver] for the adapter.
     *
     * [listener] is called each time a change occurs in the adapter
     *
     * return the registered [RecyclerView.AdapterDataObserver]
     *
     * /!\ Make sure to unregister [RecyclerView.AdapterDataObserver]
     */
    @org.jetbrains.annotations.NotNull()
    public static final androidx.recyclerview.widget.RecyclerView.AdapterDataObserver onAnyChange(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.Adapter<?> $this$onAnyChange, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> listener) {
        return null;
    }
    
    /**
     * Generate a string containing the commercial denomination of the video resolution
     *
     * @param width the video width
     * @param height the video height
     * @return the commercial resolution (SD, HD, 4K, ...)
     */
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String generateResolutionClass(int width, int height) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final kotlinx.coroutines.CoroutineScope getScope(@org.jetbrains.annotations.NotNull()
    android.view.View $this$scope) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object>kotlinx.coroutines.Job launchWhenStarted(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.Flow<? extends T> $this$launchWhenStarted, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleCoroutineScope scope) {
        return null;
    }
    
    /**
     * Sanitize a string by adding enough "0" at the start
     * to make a "natural" alphanumeric comparison (1, 2, 10, 11, 20) instead of a strict one (1, 10, 11, 21, 20)
     *
     * @param nbOfDigits the number of digits to reach
     * @return a string having exactly [nbOfDigits] digits at the start
     */
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String sanitizeStringForAlphaCompare(@org.jetbrains.annotations.Nullable()
    java.lang.String $this$sanitizeStringForAlphaCompare, int nbOfDigits) {
        return null;
    }
    
    /**
     * Calculate the number of digits of an Int
     *
     * @return the number of digits of this Int
     */
    public static final int numberOfDigits(int $this$numberOfDigits) {
        return 0;
    }
    
    /**
     * Get the number described at the start of this String if any
     *
     * @return the starting number of this String, null if no number found
     */
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.Integer getStartingNumber(@org.jetbrains.annotations.NotNull()
    java.lang.String $this$getStartingNumber) {
        return null;
    }
    
    /**
     * Determine the max number of digits iat the start of
     * this lit items' filename
     *
     * @return a max number of digits
     */
    public static final int determineMaxNbOfDigits(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends org.videolan.medialibrary.media.MediaLibraryItem> $this$determineMaxNbOfDigits) {
        return 0;
    }
    
    public static final void showParentFolder(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$showParentFolder, @org.jetbrains.annotations.NotNull()
    org.videolan.medialibrary.interfaces.media.MediaWrapper media) {
    }
}