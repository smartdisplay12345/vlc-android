package org.videolan.vlc.gui.browser;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003R\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00020\u0005:\u0004cdefB\'\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0016\u00108\u001a\u0002092\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u000eH\u0016J\u0006\u0010>\u001a\u000209J\b\u0010?\u001a\u00020\u001aH\u0014J\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00020AJ\u0016\u0010B\u001a\u00020\u00162\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u000bJ\u0010\u0010F\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\tH\u0016J\b\u0010H\u001a\u00020\tH\u0016J\u0010\u0010I\u001a\u00020\t2\u0006\u0010G\u001a\u00020\tH\u0016J\u0012\u0010J\u001a\u0004\u0018\u00010\u000e2\u0006\u0010C\u001a\u00020DH\u0002J \u0010K\u001a\u0002092\u0006\u0010G\u001a\u00020\t2\u0006\u0010L\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020NH\u0016J\u0010\u0010O\u001a\u0002092\u0006\u0010P\u001a\u00020QH\u0016J\u001c\u0010R\u001a\u0002092\n\u0010S\u001a\u00060TR\u00020\u00002\u0006\u0010G\u001a\u00020\tH\u0002J\"\u0010U\u001a\u0002092\u0010\u0010V\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003R\u00020\u00002\u0006\u0010G\u001a\u00020\tH\u0016J0\u0010U\u001a\u0002092\u0010\u0010V\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003R\u00020\u00002\u0006\u0010G\u001a\u00020\t2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020Y0XH\u0016J\"\u0010Z\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003R\u00020\u00002\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\tH\u0016J\u0010\u0010^\u001a\u0002092\u0006\u0010P\u001a\u00020QH\u0016J\b\u0010_\u001a\u000209H\u0014J\u001a\u0010`\u001a\u0002092\u0010\u0010V\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003R\u00020\u0000H\u0016J\u001c\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00020A2\f\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00020AH\u0014R\u0014\u0010\r\u001a\u00020\u000eX\u0084D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b \u0010!R\u001a\u0010$\u001a\u00020\tX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020*\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010&\"\u0004\b3\u0010(R\u000e\u00104\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006g"}, d2 = {"Lorg/videolan/vlc/gui/browser/BaseBrowserAdapter;", "Lorg/videolan/vlc/gui/DiffUtilAdapter;", "Lorg/videolan/medialibrary/media/MediaLibraryItem;", "Lorg/videolan/vlc/gui/browser/BaseBrowserAdapter$ViewHolder;", "Landroidx/databinding/ViewDataBinding;", "Lorg/videolan/tools/MultiSelectAdapter;", "browserContainer", "Lorg/videolan/vlc/gui/browser/BrowserContainer;", "sort", "", "asc", "", "(Lorg/videolan/vlc/gui/browser/BrowserContainer;IZ)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getAsc", "()Z", "setAsc", "(Z)V", "audioDrawable", "Landroid/graphics/drawable/BitmapDrawable;", "getBrowserContainer", "()Lorg/videolan/vlc/gui/browser/BrowserContainer;", "diffCallback", "Lorg/videolan/vlc/gui/browser/BaseBrowserAdapter$BrowserDiffCallback;", "getDiffCallback", "()Lorg/videolan/vlc/gui/browser/BaseBrowserAdapter$BrowserDiffCallback;", "folderDrawable", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "mediaCount", "getMediaCount$vlc_android_debug", "()I", "setMediaCount$vlc_android_debug", "(I)V", "multiSelectHelper", "Lorg/videolan/tools/MultiSelectHelper;", "getMultiSelectHelper", "()Lorg/videolan/tools/MultiSelectHelper;", "networkRoot", "qaDownloadDrawable", "qaMoviesDrawable", "qaMusicDrawable", "qaPodcastsDrawable", "getSort", "setSort", "specialIcons", "subtitleDrawable", "unknownDrawable", "videoDrawable", "changeSort", "", "checkBoxAction", "v", "Landroid/view/View;", "mrl", "clear", "createCB", "getAll", "", "getIcon", "media", "Lorg/videolan/medialibrary/interfaces/media/MediaWrapper;", "specialFolders", "getItem", "position", "getItemCount", "getItemViewType", "getProtocol", "itemFocusChanged", "hasFocus", "bindingContainer", "Lorg/videolan/vlc/gui/browser/BrowserItemBindingContainer;", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onBindMediaViewHolder", "vh", "Lorg/videolan/vlc/gui/browser/BaseBrowserAdapter$MediaViewHolder;", "onBindViewHolder", "holder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onDetachedFromRecyclerView", "onUpdateFinished", "onViewRecycled", "prepareList", "list", "BrowserDiffCallback", "MediaViewHolder", "SeparatorViewHolder", "ViewHolder", "vlc-android_debug"})
public class BaseBrowserAdapter extends org.videolan.vlc.gui.DiffUtilAdapter<org.videolan.medialibrary.media.MediaLibraryItem, org.videolan.vlc.gui.browser.BaseBrowserAdapter.ViewHolder<androidx.databinding.ViewDataBinding>> implements org.videolan.tools.MultiSelectAdapter<org.videolan.medialibrary.media.MediaLibraryItem> {
    @org.jetbrains.annotations.NotNull()
    private final org.videolan.vlc.gui.browser.BrowserContainer<org.videolan.medialibrary.media.MediaLibraryItem> browserContainer = null;
    private int sort;
    private boolean asc;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "VLC/BaseBrowserAdapter";
    @org.jetbrains.annotations.NotNull()
    private final org.videolan.tools.MultiSelectHelper<org.videolan.medialibrary.media.MediaLibraryItem> multiSelectHelper = null;
    private final android.graphics.drawable.BitmapDrawable folderDrawable = null;
    private final android.graphics.drawable.BitmapDrawable audioDrawable = null;
    private final android.graphics.drawable.BitmapDrawable videoDrawable = null;
    private final android.graphics.drawable.BitmapDrawable subtitleDrawable = null;
    private final android.graphics.drawable.BitmapDrawable unknownDrawable = null;
    private final android.graphics.drawable.BitmapDrawable qaMoviesDrawable = null;
    private final android.graphics.drawable.BitmapDrawable qaMusicDrawable = null;
    private final android.graphics.drawable.BitmapDrawable qaPodcastsDrawable = null;
    private final android.graphics.drawable.BitmapDrawable qaDownloadDrawable = null;
    private int mediaCount = 0;
    private boolean networkRoot = false;
    private boolean specialIcons = false;
    private final kotlin.Lazy handler$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final org.videolan.vlc.gui.browser.BaseBrowserAdapter.BrowserDiffCallback diffCallback = null;
    
    public BaseBrowserAdapter(@org.jetbrains.annotations.NotNull()
    org.videolan.vlc.gui.browser.BrowserContainer<org.videolan.medialibrary.media.MediaLibraryItem> browserContainer, int sort, boolean asc) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.videolan.vlc.gui.browser.BrowserContainer<org.videolan.medialibrary.media.MediaLibraryItem> getBrowserContainer() {
        return null;
    }
    
    public final int getSort() {
        return 0;
    }
    
    public final void setSort(int p0) {
    }
    
    public final boolean getAsc() {
        return false;
    }
    
    public final void setAsc(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final java.lang.String getTAG() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.videolan.tools.MultiSelectHelper<org.videolan.medialibrary.media.MediaLibraryItem> getMultiSelectHelper() {
        return null;
    }
    
    public final int getMediaCount$vlc_android_debug() {
        return 0;
    }
    
    public final void setMediaCount$vlc_android_debug(int p0) {
    }
    
    private final android.os.Handler getHandler() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.videolan.vlc.gui.browser.BaseBrowserAdapter.BrowserDiffCallback getDiffCallback() {
        return null;
    }
    
    public final void changeSort(int sort, boolean asc) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public org.videolan.vlc.gui.browser.BaseBrowserAdapter.ViewHolder<androidx.databinding.ViewDataBinding> onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onAttachedToRecyclerView(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView recyclerView) {
    }
    
    @java.lang.Override()
    public void onDetachedFromRecyclerView(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView recyclerView) {
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    org.videolan.vlc.gui.browser.BaseBrowserAdapter.ViewHolder<androidx.databinding.ViewDataBinding> holder, int position) {
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    org.videolan.vlc.gui.browser.BaseBrowserAdapter.ViewHolder<androidx.databinding.ViewDataBinding> holder, int position, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Object> payloads) {
    }
    
    private final void onBindMediaViewHolder(org.videolan.vlc.gui.browser.BaseBrowserAdapter.MediaViewHolder vh, int position) {
    }
    
    @java.lang.Override()
    public void onViewRecycled(@org.jetbrains.annotations.NotNull()
    org.videolan.vlc.gui.browser.BaseBrowserAdapter.ViewHolder<androidx.databinding.ViewDataBinding> holder) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    /**
     * Listener for the item focus. For now it's only used on TV to manage the ban icon visibility
     *
     * @param position the item position
     * @param hasFocus true if the item has the focus
     * @param bindingContainer the [BrowserItemBindingContainer] to be used
     */
    public void itemFocusChanged(int position, boolean hasFocus, @org.jetbrains.annotations.NotNull()
    org.videolan.vlc.gui.browser.BrowserItemBindingContainer bindingContainer) {
    }
    
    public final void clear() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<org.videolan.medialibrary.media.MediaLibraryItem> getAll() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public org.videolan.medialibrary.media.MediaLibraryItem getItem(int position) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.drawable.BitmapDrawable getIcon(@org.jetbrains.annotations.NotNull()
    org.videolan.medialibrary.interfaces.media.MediaWrapper media, boolean specialFolders) {
        return null;
    }
    
    private final java.lang.String getProtocol(org.videolan.medialibrary.interfaces.media.MediaWrapper media) {
        return null;
    }
    
    public void checkBoxAction(@org.jetbrains.annotations.NotNull()
    android.view.View v, @org.jetbrains.annotations.NotNull()
    java.lang.String mrl) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected java.util.List<org.videolan.medialibrary.media.MediaLibraryItem> prepareList(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends org.videolan.medialibrary.media.MediaLibraryItem> list) {
        return null;
    }
    
    @java.lang.Override()
    protected void onUpdateFinished() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected org.videolan.vlc.gui.browser.BaseBrowserAdapter.BrowserDiffCallback createCB() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u00a6\u0004\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016\u00a8\u0006\u0013"}, d2 = {"Lorg/videolan/vlc/gui/browser/BaseBrowserAdapter$ViewHolder;", "T", "Landroidx/databinding/ViewDataBinding;", "Lorg/videolan/vlc/gui/helpers/SelectorViewHolder;", "Lorg/videolan/vlc/gui/helpers/MarqueeViewHolder;", "binding", "(Lorg/videolan/vlc/gui/browser/BaseBrowserAdapter;Landroidx/databinding/ViewDataBinding;)V", "getType", "", "onBanClick", "", "v", "Landroid/view/View;", "onCheckBoxClick", "onClick", "onImageClick", "onLongClick", "", "onMoreClick", "vlc-android_debug"})
    public abstract class ViewHolder<T extends androidx.databinding.ViewDataBinding> extends org.videolan.vlc.gui.helpers.SelectorViewHolder<T> implements org.videolan.vlc.gui.helpers.MarqueeViewHolder {
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        T binding) {
            super(null);
        }
        
        public abstract int getType();
        
        public void onClick(@org.jetbrains.annotations.NotNull()
        android.view.View v) {
        }
        
        public void onImageClick(@org.jetbrains.annotations.NotNull()
        android.view.View v) {
        }
        
        public boolean onLongClick(@org.jetbrains.annotations.NotNull()
        android.view.View v) {
            return false;
        }
        
        public void onCheckBoxClick(@org.jetbrains.annotations.NotNull()
        android.view.View v) {
        }
        
        public void onMoreClick(@org.jetbrains.annotations.NotNull()
        android.view.View v) {
        }
        
        public void onBanClick(@org.jetbrains.annotations.NotNull()
        android.view.View v) {
        }
    }
    
    @android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.M)
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\u0004\u0018\u00002\f\u0012\u0004\u0012\u00020\u00020\u0001R\u00020\u00032\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u0017H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006#"}, d2 = {"Lorg/videolan/vlc/gui/browser/BaseBrowserAdapter$MediaViewHolder;", "Lorg/videolan/vlc/gui/browser/BaseBrowserAdapter$ViewHolder;", "Landroidx/databinding/ViewDataBinding;", "Lorg/videolan/vlc/gui/browser/BaseBrowserAdapter;", "Lorg/videolan/vlc/gui/helpers/MarqueeViewHolder;", "bindingContainer", "Lorg/videolan/vlc/gui/browser/BrowserItemBindingContainer;", "(Lorg/videolan/vlc/gui/browser/BaseBrowserAdapter;Lorg/videolan/vlc/gui/browser/BrowserItemBindingContainer;)V", "getBindingContainer", "()Lorg/videolan/vlc/gui/browser/BrowserItemBindingContainer;", "job", "Lkotlinx/coroutines/Job;", "getJob", "()Lkotlinx/coroutines/Job;", "setJob", "(Lkotlinx/coroutines/Job;)V", "titleView", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "getType", "", "isSelected", "", "onBanClick", "", "v", "Landroid/view/View;", "onCheckBoxClick", "onClick", "onImageClick", "onLongClick", "onMoreClick", "selectView", "selected", "vlc-android_debug"})
    public final class MediaViewHolder extends org.videolan.vlc.gui.browser.BaseBrowserAdapter.ViewHolder<androidx.databinding.ViewDataBinding> implements org.videolan.vlc.gui.helpers.MarqueeViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final org.videolan.vlc.gui.browser.BrowserItemBindingContainer bindingContainer = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView titleView = null;
        @org.jetbrains.annotations.Nullable()
        private kotlinx.coroutines.Job job;
        
        public MediaViewHolder(@org.jetbrains.annotations.NotNull()
        org.videolan.vlc.gui.browser.BrowserItemBindingContainer bindingContainer) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.videolan.vlc.gui.browser.BrowserItemBindingContainer getBindingContainer() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public android.widget.TextView getTitleView() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final kotlinx.coroutines.Job getJob() {
            return null;
        }
        
        public final void setJob(@org.jetbrains.annotations.Nullable()
        kotlinx.coroutines.Job p0) {
        }
        
        @java.lang.Override()
        public void selectView(boolean selected) {
        }
        
        @java.lang.Override()
        public void onCheckBoxClick(@org.jetbrains.annotations.NotNull()
        android.view.View v) {
        }
        
        @java.lang.Override()
        public int getType() {
            return 0;
        }
        
        @java.lang.Override()
        public void onClick(@org.jetbrains.annotations.NotNull()
        android.view.View v) {
        }
        
        @java.lang.Override()
        public void onImageClick(@org.jetbrains.annotations.NotNull()
        android.view.View v) {
        }
        
        @java.lang.Override()
        public void onMoreClick(@org.jetbrains.annotations.NotNull()
        android.view.View v) {
        }
        
        @java.lang.Override()
        public void onBanClick(@org.jetbrains.annotations.NotNull()
        android.view.View v) {
        }
        
        @java.lang.Override()
        public boolean onLongClick(@org.jetbrains.annotations.NotNull()
        android.view.View v) {
            return false;
        }
        
        @java.lang.Override()
        protected boolean isSelected() {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0082\u0004\u0018\u00002\f\u0012\u0004\u0012\u00020\u00020\u0001R\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lorg/videolan/vlc/gui/browser/BaseBrowserAdapter$SeparatorViewHolder;", "Lorg/videolan/vlc/gui/browser/BaseBrowserAdapter$ViewHolder;", "Lorg/videolan/vlc/databinding/BrowserItemSeparatorBinding;", "Lorg/videolan/vlc/gui/browser/BaseBrowserAdapter;", "binding", "(Lorg/videolan/vlc/gui/browser/BaseBrowserAdapter;Lorg/videolan/vlc/databinding/BrowserItemSeparatorBinding;)V", "titleView", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "getType", "", "vlc-android_debug"})
    final class SeparatorViewHolder extends org.videolan.vlc.gui.browser.BaseBrowserAdapter.ViewHolder<org.videolan.vlc.databinding.BrowserItemSeparatorBinding> {
        @org.jetbrains.annotations.Nullable()
        private final android.widget.TextView titleView = null;
        
        public SeparatorViewHolder(@org.jetbrains.annotations.NotNull()
        org.videolan.vlc.databinding.BrowserItemSeparatorBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.Nullable()
        @java.lang.Override()
        public android.widget.TextView getTitleView() {
            return null;
        }
        
        @java.lang.Override()
        public int getType() {
            return 0;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lorg/videolan/vlc/gui/browser/BaseBrowserAdapter$BrowserDiffCallback;", "Lorg/videolan/vlc/gui/DiffUtilAdapter$DiffCallback;", "Lorg/videolan/medialibrary/media/MediaLibraryItem;", "()V", "newAsc", "", "getNewAsc", "()Z", "setNewAsc", "(Z)V", "newSort", "", "getNewSort", "()I", "setNewSort", "(I)V", "oldAsc", "getOldAsc", "setOldAsc", "oldSort", "getOldSort", "setOldSort", "areContentsTheSame", "oldItemPosition", "newItemPosition", "areItemsTheSame", "vlc-android_debug"})
    public static final class BrowserDiffCallback extends org.videolan.vlc.gui.DiffUtilAdapter.DiffCallback<org.videolan.medialibrary.media.MediaLibraryItem> {
        private int oldSort = -1;
        private int newSort = -1;
        private boolean oldAsc = true;
        private boolean newAsc = true;
        
        public BrowserDiffCallback() {
            super();
        }
        
        public final int getOldSort() {
            return 0;
        }
        
        public final void setOldSort(int p0) {
        }
        
        public final int getNewSort() {
            return 0;
        }
        
        public final void setNewSort(int p0) {
        }
        
        public final boolean getOldAsc() {
            return false;
        }
        
        public final void setOldAsc(boolean p0) {
        }
        
        public final boolean getNewAsc() {
            return false;
        }
        
        public final void setNewAsc(boolean p0) {
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            return false;
        }
    }
}