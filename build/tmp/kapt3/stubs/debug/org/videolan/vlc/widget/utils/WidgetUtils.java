package org.videolan.vlc.widget.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004J\u0016\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004\u00a8\u0006\u000e"}, d2 = {"Lorg/videolan/vlc/widget/utils/WidgetUtils;", "", "()V", "getWidgetTypeFromSize", "Lorg/videolan/vlc/widget/utils/WidgetType;", "width", "", "height", "hasEnoughSpaceForSeek", "", "widget", "Lorg/videolan/vlc/mediadb/models/Widget;", "widgetType", "shouldShowSeek", "vlc-android_debug"})
public final class WidgetUtils {
    @org.jetbrains.annotations.NotNull()
    public static final org.videolan.vlc.widget.utils.WidgetUtils INSTANCE = null;
    
    private WidgetUtils() {
        super();
    }
    
    /**
     * Calculate the [WidgetType] depending on the size
     *
     * @param width the widget width
     * @param height the widget height
     * @return the [WidgetType] for this size
     */
    @org.jetbrains.annotations.NotNull()
    public final org.videolan.vlc.widget.utils.WidgetType getWidgetTypeFromSize(int width, int height) {
        return null;
    }
    
    /**
     * Check if the widget has enough space to display the seek icons
     *
     * @param widget the widget to check the size on
     * @param widgetType the current [WidgetType]
     * @return true if the widget has enough space
     */
    public final boolean hasEnoughSpaceForSeek(@org.jetbrains.annotations.NotNull()
    org.videolan.vlc.mediadb.models.Widget widget, @org.jetbrains.annotations.NotNull()
    org.videolan.vlc.widget.utils.WidgetType widgetType) {
        return false;
    }
    
    /**
     * Check if the widget should show the seek buttons
     *
     * @param widget the widget to check the size on
     * @param widgetType the current [WidgetType]
     * @return true if the widget has enough space and the setting is set to on
     */
    public final boolean shouldShowSeek(@org.jetbrains.annotations.NotNull()
    org.videolan.vlc.mediadb.models.Widget widget, @org.jetbrains.annotations.NotNull()
    org.videolan.vlc.widget.utils.WidgetType widgetType) {
        return false;
    }
}