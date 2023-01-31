package org.videolan.vlc.widget;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\b\u0018\u0000 <2\u00020\u0001:\u0002<=B\u0005\u00a2\u0006\u0002\u0010\u0002J*\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J0\u0010\u001b\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017H\u0003J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0002JM\u0010\"\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u00062\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\'\u001a\u0004\u0018\u00010(H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010)J \u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020.H\u0002J.\u0010/\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u00100\u001a\u0004\u0018\u0001012\u0006\u0010\u0013\u001a\u00020\u000b2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u001c\u00104\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0018\u00107\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$H\u0016J \u00108\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00100\u001a\u0002012\u0006\u00105\u001a\u000206H\u0016J4\u00109\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010:\u001a\u0004\u0018\u00010.2\b\u0010;\u001a\u0004\u0018\u00010.H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006>"}, d2 = {"Lorg/videolan/vlc/widget/MiniPlayerAppWidgetProvider;", "Landroid/appwidget/AppWidgetProvider;", "()V", "_widgetRepository", "Lorg/videolan/vlc/repository/WidgetRepository;", "enableLogs", "", "logTypeFilter", "Ljava/util/ArrayList;", "Lorg/videolan/vlc/widget/MiniPlayerAppWidgetProvider$WidgetLogType;", "logWidgetIdFilter", "", "applyUpdate", "", "context", "Landroid/content/Context;", "views", "Landroid/widget/RemoteViews;", "partial", "appWidgetId", "cutBitmapCover", "Landroid/graphics/Bitmap;", "widgetType", "Lorg/videolan/vlc/widget/utils/WidgetType;", "cover", "widgetCacheEntry", "Lorg/videolan/vlc/widget/utils/WidgetCacheEntry;", "displayCover", "playing", "getFakeMedia", "Lorg/videolan/medialibrary/interfaces/media/MediaWrapper;", "getPlayPauseImage", "isPlaying", "getWidgetRepository", "layoutWidget", "intent", "Landroid/content/Intent;", "forPreview", "previewBitmap", "previewPalette", "Landroidx/palette/graphics/Palette;", "(Landroid/content/Context;ILandroid/content/Intent;ZLandroid/graphics/Bitmap;Landroidx/palette/graphics/Palette;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "log", "widgetId", "logType", "text", "", "onAppWidgetOptionsChanged", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", "newOptions", "Landroid/os/Bundle;", "onDeleted", "appWidgetIds", "", "onReceive", "onUpdate", "setupTexts", "title", "artist", "Companion", "WidgetLogType", "vlc-android_debug"})
public final class MiniPlayerAppWidgetProvider extends android.appwidget.AppWidgetProvider {
    private org.videolan.vlc.repository.WidgetRepository _widgetRepository;
    private final boolean enableLogs = true;
    private final java.util.ArrayList<org.videolan.vlc.widget.MiniPlayerAppWidgetProvider.WidgetLogType> logTypeFilter = null;
    private final java.util.ArrayList<java.lang.Integer> logWidgetIdFilter = null;
    @org.jetbrains.annotations.NotNull()
    public static final org.videolan.vlc.widget.MiniPlayerAppWidgetProvider.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "VLC/VLCAppWidgetProvider";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ACTION_WIDGET_PREFIX = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ACTION_WIDGET_INIT = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ACTION_WIDGET_UPDATE = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ACTION_WIDGET_UPDATE_POSITION = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ACTION_WIDGET_ENABLED = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ACTION_WIDGET_DISABLED = null;
    
    public MiniPlayerAppWidgetProvider() {
        super();
    }
    
    /**
     * Retrieve the [WidgetRepository]
     *
     * @param context the context to use
     * @return the [WidgetRepository]
     */
    private final org.videolan.vlc.repository.WidgetRepository getWidgetRepository(android.content.Context context) {
        return null;
    }
    
    @java.lang.Override()
    public void onUpdate(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.appwidget.AppWidgetManager appWidgetManager, @org.jetbrains.annotations.NotNull()
    int[] appWidgetIds) {
    }
    
    @java.lang.Override()
    public void onDeleted(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    int[] appWidgetIds) {
    }
    
    @java.lang.Override()
    public void onReceive(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
    }
    
    /**
     * Generated the [RemoteViews] depending on the widget configuration and sizing
     *
     * @param context the context to use
     * @param appWidgetId the widget id
     * @param intent the intent triggering this layout pass
     * @param forPreview is this layout pass for a preview (in the configuration activity)
     * @param previewBitmap if this is for a preview, the [Bitmap] to use as a cover
     * @param previewPalette if this is for a preview, the [Palette] to use
     * @return the [RemoteViews] to send to the app widget host
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object layoutWidget(@org.jetbrains.annotations.NotNull()
    android.content.Context context, int appWidgetId, @org.jetbrains.annotations.NotNull()
    android.content.Intent intent, boolean forPreview, @org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap previewBitmap, @org.jetbrains.annotations.Nullable()
    androidx.palette.graphics.Palette previewPalette, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super android.widget.RemoteViews> continuation) {
        return null;
    }
    
    /**
     * Cuts the cover bitmap depending on the [WidgetType]
     *
     * @param widgetType the widget's [WidgetType]
     * @param cover the cover [Bitmap]
     * @param widgetCacheEntry the [WidgetCacheEntry] used for the [Bitmap] sizing
     * @return a cut [Bitmap]
     */
    private final android.graphics.Bitmap cutBitmapCover(org.videolan.vlc.widget.utils.WidgetType widgetType, android.graphics.Bitmap cover, org.videolan.vlc.widget.utils.WidgetCacheEntry widgetCacheEntry) {
        return null;
    }
    
    /**
     * Retrieve a fake media to be displayed in the widget's preview
     *
     * @return a fake [MediaWrapper]
     */
    private final org.videolan.medialibrary.interfaces.media.MediaWrapper getFakeMedia() {
        return null;
    }
    
    /**
     * Setup the title and artist texts and their views visibility
     *
     * @param context the context to use
     * @param views the [RemoteViews] to set the texts into
     * @param widgetType the widget type
     * @param title the track name
     * @param artist the artist name
     */
    private final void setupTexts(android.content.Context context, android.widget.RemoteViews views, org.videolan.vlc.widget.utils.WidgetType widgetType, java.lang.String title, java.lang.String artist) {
    }
    
    /**
     * Setup the cover for the [RemoteViews] and the visibility
     *
     * @param context the context to use
     * @param views the [RemoteViews] in which to display the cover
     * @param playing is the playback currently active
     * @param widgetType the [WidgetType] the widget uses
     * @param widgetCacheEntry the [WidgetCacheEntry] used for the colors
     */
    private final void displayCover(android.content.Context context, android.widget.RemoteViews views, boolean playing, org.videolan.vlc.widget.utils.WidgetType widgetType, org.videolan.vlc.widget.utils.WidgetCacheEntry widgetCacheEntry) {
    }
    
    @java.lang.Override()
    public void onAppWidgetOptionsChanged(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.appwidget.AppWidgetManager appWidgetManager, int appWidgetId, @org.jetbrains.annotations.Nullable()
    android.os.Bundle newOptions) {
    }
    
    /**
     * Get the play/pause drawable depending on the playing state and the [WidgetType]
     *
     * @param isPlaying is the playback currently active
     * @param widgetType the [WidgetType] to use
     * @return the drawable to use for the play/pause icon
     */
    @androidx.annotation.DrawableRes()
    private final int getPlayPauseImage(boolean isPlaying, org.videolan.vlc.widget.utils.WidgetType widgetType) {
        return 0;
    }
    
    /**
     * Applies the update to the widget
     *
     * @param context the [Context] to use
     * @param views the [RemoteViews] to display
     * @param partial is this a partial update?
     * @param appWidgetId the widget's id to update
     */
    private final void applyUpdate(android.content.Context context, android.widget.RemoteViews views, boolean partial, int appWidgetId) {
    }
    
    /**
     * Widget logger
     *
     * @param widgetId the widget id to filter / display
     * @param logType the logType to filter / display
     * @param text the log text
     */
    private final void log(int widgetId, org.videolan.vlc.widget.MiniPlayerAppWidgetProvider.WidgetLogType logType, java.lang.String text) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lorg/videolan/vlc/widget/MiniPlayerAppWidgetProvider$WidgetLogType;", "", "(Ljava/lang/String;I)V", "INFO", "BITMAP_GENERATION", "vlc-android_debug"})
    public static enum WidgetLogType {
        /*public static final*/ INFO /* = new INFO() */,
        /*public static final*/ BITMAP_GENERATION /* = new BITMAP_GENERATION() */;
        
        WidgetLogType() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lorg/videolan/vlc/widget/MiniPlayerAppWidgetProvider$Companion;", "", "()V", "ACTION_WIDGET_DISABLED", "", "getACTION_WIDGET_DISABLED", "()Ljava/lang/String;", "ACTION_WIDGET_ENABLED", "getACTION_WIDGET_ENABLED", "ACTION_WIDGET_INIT", "getACTION_WIDGET_INIT", "ACTION_WIDGET_PREFIX", "getACTION_WIDGET_PREFIX", "ACTION_WIDGET_UPDATE", "getACTION_WIDGET_UPDATE", "ACTION_WIDGET_UPDATE_POSITION", "getACTION_WIDGET_UPDATE_POSITION", "TAG", "vlc-android_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getACTION_WIDGET_PREFIX() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getACTION_WIDGET_INIT() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getACTION_WIDGET_UPDATE() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getACTION_WIDGET_UPDATE_POSITION() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getACTION_WIDGET_ENABLED() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getACTION_WIDGET_DISABLED() {
            return null;
        }
    }
}