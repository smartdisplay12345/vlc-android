package org.videolan.vlc.databinding;
import org.videolan.vlc.R;
import org.videolan.vlc.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class VideoGridCardBindingImpl extends VideoGridCardBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.ml_item_overlay, 15);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mHolderOnClickAndroidViewViewOnClickListener;
    private OnLongClickListenerImpl mHolderOnLongClickAndroidViewViewOnLongClickListener;
    private OnClickListenerImpl1 mHolderOnMoreClickAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public VideoGridCardBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }
    private VideoGridCardBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[8]
            , (com.google.android.material.card.MaterialCardView) bindings[1]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.ImageView) bindings[15]
            , (android.widget.ProgressBar) bindings[12]
            , (android.widget.TextView) bindings[4]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[13]
            , (android.widget.ImageView) bindings[5]
            , (android.view.View) bindings[3]
            , (android.widget.ImageView) bindings[6]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.ImageView) bindings[11]
            );
        this.absentMedia.setTag(null);
        this.container.setTag(null);
        this.itemMore.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mlItemProgress.setTag(null);
        this.mlItemResolution.setTag(null);
        this.mlItemSeen.setTag(null);
        this.mlItemThumbnail.setTag(null);
        this.mlItemTime.setTag(null);
        this.mlItemTitle.setTag(null);
        this.networkMedia.setTag(null);
        this.networkOffOverlay.setTag(null);
        this.otgMedia.setTag(null);
        this.sdMedia.setTag(null);
        this.selectedCheck.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10000L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.isNetwork == variableId) {
            setIsNetwork((boolean) variable);
        }
        else if (BR.bgColor == variableId) {
            setBgColor((int) variable);
        }
        else if (BR.isPresent == variableId) {
            setIsPresent((boolean) variable);
        }
        else if (BR.media == variableId) {
            setMedia((org.videolan.medialibrary.media.MediaLibraryItem) variable);
        }
        else if (BR.selected == variableId) {
            setSelected((boolean) variable);
        }
        else if (BR.resolution == variableId) {
            setResolution((java.lang.String) variable);
        }
        else if (BR.max == variableId) {
            setMax((int) variable);
        }
        else if (BR.progress == variableId) {
            setProgress((int) variable);
        }
        else if (BR.inSelection == variableId) {
            setInSelection((boolean) variable);
        }
        else if (BR.cover == variableId) {
            setCover((android.graphics.drawable.BitmapDrawable) variable);
        }
        else if (BR.holder == variableId) {
            setHolder((org.videolan.vlc.gui.video.VideoListAdapter.ViewHolder) variable);
        }
        else if (BR.seen == variableId) {
            setSeen((long) variable);
        }
        else if (BR.scaleType == variableId) {
            setScaleType((android.widget.ImageView.ScaleType) variable);
        }
        else if (BR.isSD == variableId) {
            setIsSD((boolean) variable);
        }
        else if (BR.time == variableId) {
            setTime((java.lang.String) variable);
        }
        else if (BR.isOTG == variableId) {
            setIsOTG((boolean) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setIsNetwork(boolean IsNetwork) {
        this.mIsNetwork = IsNetwork;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.isNetwork);
        super.requestRebind();
    }
    public void setBgColor(int BgColor) {
        this.mBgColor = BgColor;
    }
    public void setIsPresent(boolean IsPresent) {
        this.mIsPresent = IsPresent;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.isPresent);
        super.requestRebind();
    }
    public void setMedia(@Nullable org.videolan.medialibrary.media.MediaLibraryItem Media) {
        this.mMedia = Media;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.media);
        super.requestRebind();
    }
    public void setSelected(boolean Selected) {
        this.mSelected = Selected;
        synchronized(this) {
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.selected);
        super.requestRebind();
    }
    public void setResolution(@Nullable java.lang.String Resolution) {
        this.mResolution = Resolution;
        synchronized(this) {
            mDirtyFlags |= 0x20L;
        }
        notifyPropertyChanged(BR.resolution);
        super.requestRebind();
    }
    public void setMax(int Max) {
        this.mMax = Max;
        synchronized(this) {
            mDirtyFlags |= 0x40L;
        }
        notifyPropertyChanged(BR.max);
        super.requestRebind();
    }
    public void setProgress(int Progress) {
        this.mProgress = Progress;
        synchronized(this) {
            mDirtyFlags |= 0x80L;
        }
        notifyPropertyChanged(BR.progress);
        super.requestRebind();
    }
    public void setInSelection(boolean InSelection) {
        this.mInSelection = InSelection;
        synchronized(this) {
            mDirtyFlags |= 0x100L;
        }
        notifyPropertyChanged(BR.inSelection);
        super.requestRebind();
    }
    public void setCover(@Nullable android.graphics.drawable.BitmapDrawable Cover) {
        this.mCover = Cover;
        synchronized(this) {
            mDirtyFlags |= 0x200L;
        }
        notifyPropertyChanged(BR.cover);
        super.requestRebind();
    }
    public void setHolder(@Nullable org.videolan.vlc.gui.video.VideoListAdapter.ViewHolder Holder) {
        this.mHolder = Holder;
        synchronized(this) {
            mDirtyFlags |= 0x400L;
        }
        notifyPropertyChanged(BR.holder);
        super.requestRebind();
    }
    public void setSeen(long Seen) {
        this.mSeen = Seen;
        synchronized(this) {
            mDirtyFlags |= 0x800L;
        }
        notifyPropertyChanged(BR.seen);
        super.requestRebind();
    }
    public void setScaleType(@Nullable android.widget.ImageView.ScaleType ScaleType) {
        this.mScaleType = ScaleType;
    }
    public void setIsSD(boolean IsSD) {
        this.mIsSD = IsSD;
        synchronized(this) {
            mDirtyFlags |= 0x2000L;
        }
        notifyPropertyChanged(BR.isSD);
        super.requestRebind();
    }
    public void setTime(@Nullable java.lang.String Time) {
        this.mTime = Time;
        synchronized(this) {
            mDirtyFlags |= 0x4000L;
        }
        notifyPropertyChanged(BR.time);
        super.requestRebind();
    }
    public void setIsOTG(boolean IsOTG) {
        this.mIsOTG = IsOTG;
        synchronized(this) {
            mDirtyFlags |= 0x8000L;
        }
        notifyPropertyChanged(BR.isOTG);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        boolean isNetworkIsPresentBooleanFalse = false;
        android.view.View.OnClickListener holderOnClickAndroidViewViewOnClickListener = null;
        boolean isNetwork = mIsNetwork;
        boolean textUtilsIsEmptyTime = false;
        boolean inSelection = false;
        int textUtilsIsEmptyResolutionViewGONEViewVISIBLE = 0;
        boolean isPresent = mIsPresent;
        boolean isSDIsPresentBooleanFalse = false;
        int isNetworkIsPresentBooleanFalseViewVISIBLEViewGONE = 0;
        int isPresentInSelectionBooleanFalseViewVISIBLEViewGONE = 0;
        java.lang.String mediaTitle = null;
        org.videolan.medialibrary.media.MediaLibraryItem media = mMedia;
        boolean selectedIsPresentBooleanFalse = false;
        int isOTGIsPresentBooleanFalseViewVISIBLEViewGONE = 0;
        boolean selected = mSelected;
        boolean textUtilsIsEmptyResolution = false;
        java.lang.String resolution = mResolution;
        int isPresentViewVISIBLEViewGONE = 0;
        boolean Selected1 = false;
        int progressInt0ViewGONEViewVISIBLE = 0;
        int textUtilsIsEmptyTimeViewGONEViewVISIBLE = 0;
        int max = mMax;
        int progress = mProgress;
        android.view.View.OnLongClickListener holderOnLongClickAndroidViewViewOnLongClickListener = null;
        boolean InSelection1 = mInSelection;
        int selectedIsPresentBooleanFalseViewVISIBLEViewGONE = 0;
        android.graphics.drawable.BitmapDrawable cover = mCover;
        boolean progressInt0 = false;
        int isSDIsPresentBooleanFalseViewVISIBLEViewGONE = 0;
        boolean isOTGIsPresentBooleanFalse = false;
        org.videolan.vlc.gui.video.VideoListAdapter.ViewHolder holder = mHolder;
        android.view.View.OnClickListener holderOnMoreClickAndroidViewViewOnClickListener = null;
        int selectedViewVISIBLEViewGONE = 0;
        long seen = mSeen;
        int seenLong0LViewGONEViewVISIBLE = 0;
        boolean seenLong0L = false;
        boolean isSD = mIsSD;
        java.lang.String time = mTime;
        boolean IsPresent1 = false;
        boolean isPresentInSelectionBooleanFalse = false;
        boolean isOTG = mIsOTG;

        if ((dirtyFlags & 0x10005L) != 0) {

            if((dirtyFlags & 0x10005L) != 0) {
                if(isNetwork) {
                        dirtyFlags |= 0x40000L;
                }
                else {
                        dirtyFlags |= 0x20000L;
                }
            }
        }
        if ((dirtyFlags & 0x10104L) != 0) {

            if((dirtyFlags & 0x10104L) != 0) {
                if(isPresent) {
                        dirtyFlags |= 0x1000000000000L;
                }
                else {
                        dirtyFlags |= 0x800000000000L;
                }
            }

            if ((dirtyFlags & 0x10004L) != 0) {

                    // read !isPresent
                    IsPresent1 = !isPresent;
                if((dirtyFlags & 0x10004L) != 0) {
                    if(IsPresent1) {
                            dirtyFlags |= 0x100000000L;
                    }
                    else {
                            dirtyFlags |= 0x80000000L;
                    }
                }


                    // read !isPresent ? View.VISIBLE : View.GONE
                    isPresentViewVISIBLEViewGONE = ((IsPresent1) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
            }
        }
        if ((dirtyFlags & 0x10008L) != 0) {



                if (media != null) {
                    // read media.title
                    mediaTitle = media.getTitle();
                }
        }
        if ((dirtyFlags & 0x10014L) != 0) {

            if((dirtyFlags & 0x10010L) != 0) {
                if(selected) {
                        dirtyFlags |= 0x100000000000L;
                }
                else {
                        dirtyFlags |= 0x80000000000L;
                }
            }


                // read !selected
                Selected1 = !selected;
            if((dirtyFlags & 0x10014L) != 0) {
                if(Selected1) {
                        dirtyFlags |= 0x10000000L;
                }
                else {
                        dirtyFlags |= 0x8000000L;
                }
            }
            if ((dirtyFlags & 0x10010L) != 0) {

                    // read selected ? View.VISIBLE : View.GONE
                    selectedViewVISIBLEViewGONE = ((selected) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
            }
        }
        if ((dirtyFlags & 0x10020L) != 0) {



                // read TextUtils.isEmpty(resolution)
                textUtilsIsEmptyResolution = android.text.TextUtils.isEmpty(resolution);
            if((dirtyFlags & 0x10020L) != 0) {
                if(textUtilsIsEmptyResolution) {
                        dirtyFlags |= 0x100000L;
                }
                else {
                        dirtyFlags |= 0x80000L;
                }
            }


                // read TextUtils.isEmpty(resolution) ? View.GONE : View.VISIBLE
                textUtilsIsEmptyResolutionViewGONEViewVISIBLE = ((textUtilsIsEmptyResolution) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
        }
        if ((dirtyFlags & 0x10040L) != 0) {
        }
        if ((dirtyFlags & 0x10080L) != 0) {



                // read progress == 0
                progressInt0 = (progress) == (0);
            if((dirtyFlags & 0x10080L) != 0) {
                if(progressInt0) {
                        dirtyFlags |= 0x400000000L;
                }
                else {
                        dirtyFlags |= 0x200000000L;
                }
            }


                // read progress == 0 ? View.GONE : View.VISIBLE
                progressInt0ViewGONEViewVISIBLE = ((progressInt0) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
        }
        if ((dirtyFlags & 0x10200L) != 0) {
        }
        if ((dirtyFlags & 0x10400L) != 0) {



                if (holder != null) {
                    // read holder::onClick
                    holderOnClickAndroidViewViewOnClickListener = (((mHolderOnClickAndroidViewViewOnClickListener == null) ? (mHolderOnClickAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mHolderOnClickAndroidViewViewOnClickListener).setValue(holder));
                    // read holder::onLongClick
                    holderOnLongClickAndroidViewViewOnLongClickListener = (((mHolderOnLongClickAndroidViewViewOnLongClickListener == null) ? (mHolderOnLongClickAndroidViewViewOnLongClickListener = new OnLongClickListenerImpl()) : mHolderOnLongClickAndroidViewViewOnLongClickListener).setValue(holder));
                    // read holder::onMoreClick
                    holderOnMoreClickAndroidViewViewOnClickListener = (((mHolderOnMoreClickAndroidViewViewOnClickListener == null) ? (mHolderOnMoreClickAndroidViewViewOnClickListener = new OnClickListenerImpl1()) : mHolderOnMoreClickAndroidViewViewOnClickListener).setValue(holder));
                }
        }
        if ((dirtyFlags & 0x10800L) != 0) {



                // read seen == 0L
                seenLong0L = (seen) == (0L);
            if((dirtyFlags & 0x10800L) != 0) {
                if(seenLong0L) {
                        dirtyFlags |= 0x400000000000L;
                }
                else {
                        dirtyFlags |= 0x200000000000L;
                }
            }


                // read seen == 0L ? View.GONE : View.VISIBLE
                seenLong0LViewGONEViewVISIBLE = ((seenLong0L) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
        }
        if ((dirtyFlags & 0x12004L) != 0) {

            if((dirtyFlags & 0x12004L) != 0) {
                if(isSD) {
                        dirtyFlags |= 0x400000L;
                }
                else {
                        dirtyFlags |= 0x200000L;
                }
            }
        }
        if ((dirtyFlags & 0x14000L) != 0) {



                // read TextUtils.isEmpty(time)
                textUtilsIsEmptyTime = android.text.TextUtils.isEmpty(time);
            if((dirtyFlags & 0x14000L) != 0) {
                if(textUtilsIsEmptyTime) {
                        dirtyFlags |= 0x1000000000L;
                }
                else {
                        dirtyFlags |= 0x800000000L;
                }
            }


                // read TextUtils.isEmpty(time) ? View.GONE : View.VISIBLE
                textUtilsIsEmptyTimeViewGONEViewVISIBLE = ((textUtilsIsEmptyTime) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
        }
        if ((dirtyFlags & 0x18004L) != 0) {

            if((dirtyFlags & 0x18004L) != 0) {
                if(isOTG) {
                        dirtyFlags |= 0x40000000000L;
                }
                else {
                        dirtyFlags |= 0x20000000000L;
                }
            }
        }
        // batch finished

        if ((dirtyFlags & 0x40010440000L) != 0) {

            if((dirtyFlags & 0x10104L) != 0) {
                if(isPresent) {
                        dirtyFlags |= 0x1000000000000L;
                }
                else {
                        dirtyFlags |= 0x800000000000L;
                }
            }

            if ((dirtyFlags & 0x10000000L) != 0) {

                    // read !isPresent
                    IsPresent1 = !isPresent;
                if((dirtyFlags & 0x10004L) != 0) {
                    if(IsPresent1) {
                            dirtyFlags |= 0x100000000L;
                    }
                    else {
                            dirtyFlags |= 0x80000000L;
                    }
                }
            }
        }

        if ((dirtyFlags & 0x10005L) != 0) {

                // read isNetwork ? isPresent : false
                isNetworkIsPresentBooleanFalse = ((isNetwork) ? (isPresent) : (false));
            if((dirtyFlags & 0x10005L) != 0) {
                if(isNetworkIsPresentBooleanFalse) {
                        dirtyFlags |= 0x1000000L;
                }
                else {
                        dirtyFlags |= 0x800000L;
                }
            }


                // read isNetwork ? isPresent : false ? View.VISIBLE : View.GONE
                isNetworkIsPresentBooleanFalseViewVISIBLEViewGONE = ((isNetworkIsPresentBooleanFalse) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
        }
        if ((dirtyFlags & 0x12004L) != 0) {

                // read isSD ? isPresent : false
                isSDIsPresentBooleanFalse = ((isSD) ? (isPresent) : (false));
            if((dirtyFlags & 0x12004L) != 0) {
                if(isSDIsPresentBooleanFalse) {
                        dirtyFlags |= 0x10000000000L;
                }
                else {
                        dirtyFlags |= 0x8000000000L;
                }
            }


                // read isSD ? isPresent : false ? View.VISIBLE : View.GONE
                isSDIsPresentBooleanFalseViewVISIBLEViewGONE = ((isSDIsPresentBooleanFalse) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
        }
        if ((dirtyFlags & 0x10014L) != 0) {

                // read !selected ? !isPresent : false
                selectedIsPresentBooleanFalse = ((Selected1) ? (IsPresent1) : (false));
            if((dirtyFlags & 0x10014L) != 0) {
                if(selectedIsPresentBooleanFalse) {
                        dirtyFlags |= 0x4000000000L;
                }
                else {
                        dirtyFlags |= 0x2000000000L;
                }
            }


                // read !selected ? !isPresent : false ? View.VISIBLE : View.GONE
                selectedIsPresentBooleanFalseViewVISIBLEViewGONE = ((selectedIsPresentBooleanFalse) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
        }
        if ((dirtyFlags & 0x18004L) != 0) {

                // read isOTG ? isPresent : false
                isOTGIsPresentBooleanFalse = ((isOTG) ? (isPresent) : (false));
            if((dirtyFlags & 0x18004L) != 0) {
                if(isOTGIsPresentBooleanFalse) {
                        dirtyFlags |= 0x40000000L;
                }
                else {
                        dirtyFlags |= 0x20000000L;
                }
            }


                // read isOTG ? isPresent : false ? View.VISIBLE : View.GONE
                isOTGIsPresentBooleanFalseViewVISIBLEViewGONE = ((isOTGIsPresentBooleanFalse) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
        }
        // batch finished

        if ((dirtyFlags & 0x1000000000000L) != 0) {



                // read !inSelection
                inSelection = !InSelection1;
        }

        if ((dirtyFlags & 0x10104L) != 0) {

                // read isPresent ? !inSelection : false
                isPresentInSelectionBooleanFalse = ((isPresent) ? (inSelection) : (false));
            if((dirtyFlags & 0x10104L) != 0) {
                if(isPresentInSelectionBooleanFalse) {
                        dirtyFlags |= 0x4000000L;
                }
                else {
                        dirtyFlags |= 0x2000000L;
                }
            }


                // read isPresent ? !inSelection : false ? View.VISIBLE : View.GONE
                isPresentInSelectionBooleanFalseViewVISIBLEViewGONE = ((isPresentInSelectionBooleanFalse) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
        }
        // batch finished
        if ((dirtyFlags & 0x10004L) != 0) {
            // api target 1

            this.absentMedia.setVisibility(isPresentViewVISIBLEViewGONE);
            this.mlItemTime.setEnabled(isPresent);
            this.mlItemTitle.setEnabled(isPresent);
        }
        if ((dirtyFlags & 0x10400L) != 0) {
            // api target 1

            this.container.setOnClickListener(holderOnClickAndroidViewViewOnClickListener);
            this.container.setOnLongClickListener(holderOnLongClickAndroidViewViewOnLongClickListener);
            this.itemMore.setOnClickListener(holderOnMoreClickAndroidViewViewOnClickListener);
            this.mboundView0.setOnClickListener(holderOnClickAndroidViewViewOnClickListener);
            this.mboundView0.setOnLongClickListener(holderOnLongClickAndroidViewViewOnLongClickListener);
        }
        if ((dirtyFlags & 0x10104L) != 0) {
            // api target 1

            this.itemMore.setVisibility(isPresentInSelectionBooleanFalseViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 0x10010L) != 0) {
            // api target 1

            this.mboundView0.setSelected(selected);
            this.selectedCheck.setVisibility(selectedViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 0x10008L) != 0) {
            // api target 1

            org.videolan.vlc.util.AccessibilityHelperKt.mediaDescription(this.mboundView0, media);
            org.videolan.vlc.gui.helpers.ImageLoaderKt.loadImage(this.mlItemThumbnail, media, (int)0, (boolean)false, (boolean)false);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mlItemTitle, mediaTitle);
        }
        if ((dirtyFlags & 0x10040L) != 0) {
            // api target 1

            this.mlItemProgress.setMax(max);
        }
        if ((dirtyFlags & 0x10080L) != 0) {
            // api target 1

            this.mlItemProgress.setProgress(progress);
            this.mlItemProgress.setVisibility(progressInt0ViewGONEViewVISIBLE);
        }
        if ((dirtyFlags & 0x10020L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mlItemResolution, resolution);
            this.mlItemResolution.setVisibility(textUtilsIsEmptyResolutionViewGONEViewVISIBLE);
        }
        if ((dirtyFlags & 0x10800L) != 0) {
            // api target 1

            this.mlItemSeen.setVisibility(seenLong0LViewGONEViewVISIBLE);
        }
        if ((dirtyFlags & 0x10200L) != 0) {
            // api target 1

            androidx.databinding.adapters.ImageViewBindingAdapter.setImageDrawable(this.mlItemThumbnail, cover);
        }
        if ((dirtyFlags & 0x14000L) != 0) {
            // api target 1

            org.videolan.vlc.util.KextensionsKt.presenceDescription(this.mlItemTime, time);
            this.mlItemTime.setVisibility(textUtilsIsEmptyTimeViewGONEViewVISIBLE);
        }
        if ((dirtyFlags & 0x10005L) != 0) {
            // api target 1

            this.networkMedia.setVisibility(isNetworkIsPresentBooleanFalseViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 0x10014L) != 0) {
            // api target 1

            this.networkOffOverlay.setVisibility(selectedIsPresentBooleanFalseViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 0x18004L) != 0) {
            // api target 1

            this.otgMedia.setVisibility(isOTGIsPresentBooleanFalseViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 0x12004L) != 0) {
            // api target 1

            this.sdMedia.setVisibility(isSDIsPresentBooleanFalseViewVISIBLEViewGONE);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private org.videolan.vlc.gui.video.VideoListAdapter.ViewHolder value;
        public OnClickListenerImpl setValue(org.videolan.vlc.gui.video.VideoListAdapter.ViewHolder value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.onClick(arg0); 
        }
    }
    public static class OnLongClickListenerImpl implements android.view.View.OnLongClickListener{
        private org.videolan.vlc.gui.video.VideoListAdapter.ViewHolder value;
        public OnLongClickListenerImpl setValue(org.videolan.vlc.gui.video.VideoListAdapter.ViewHolder value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public boolean onLongClick(android.view.View arg0) {
            return this.value.onLongClick(arg0); 
        }
    }
    public static class OnClickListenerImpl1 implements android.view.View.OnClickListener{
        private org.videolan.vlc.gui.video.VideoListAdapter.ViewHolder value;
        public OnClickListenerImpl1 setValue(org.videolan.vlc.gui.video.VideoListAdapter.ViewHolder value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.onMoreClick(arg0); 
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): isNetwork
        flag 1 (0x2L): bgColor
        flag 2 (0x3L): isPresent
        flag 3 (0x4L): media
        flag 4 (0x5L): selected
        flag 5 (0x6L): resolution
        flag 6 (0x7L): max
        flag 7 (0x8L): progress
        flag 8 (0x9L): inSelection
        flag 9 (0xaL): cover
        flag 10 (0xbL): holder
        flag 11 (0xcL): seen
        flag 12 (0xdL): scaleType
        flag 13 (0xeL): isSD
        flag 14 (0xfL): time
        flag 15 (0x10L): isOTG
        flag 16 (0x11L): null
        flag 17 (0x12L): isNetwork ? isPresent : false
        flag 18 (0x13L): isNetwork ? isPresent : false
        flag 19 (0x14L): TextUtils.isEmpty(resolution) ? View.GONE : View.VISIBLE
        flag 20 (0x15L): TextUtils.isEmpty(resolution) ? View.GONE : View.VISIBLE
        flag 21 (0x16L): isSD ? isPresent : false
        flag 22 (0x17L): isSD ? isPresent : false
        flag 23 (0x18L): isNetwork ? isPresent : false ? View.VISIBLE : View.GONE
        flag 24 (0x19L): isNetwork ? isPresent : false ? View.VISIBLE : View.GONE
        flag 25 (0x1aL): isPresent ? !inSelection : false ? View.VISIBLE : View.GONE
        flag 26 (0x1bL): isPresent ? !inSelection : false ? View.VISIBLE : View.GONE
        flag 27 (0x1cL): !selected ? !isPresent : false
        flag 28 (0x1dL): !selected ? !isPresent : false
        flag 29 (0x1eL): isOTG ? isPresent : false ? View.VISIBLE : View.GONE
        flag 30 (0x1fL): isOTG ? isPresent : false ? View.VISIBLE : View.GONE
        flag 31 (0x20L): !isPresent ? View.VISIBLE : View.GONE
        flag 32 (0x21L): !isPresent ? View.VISIBLE : View.GONE
        flag 33 (0x22L): progress == 0 ? View.GONE : View.VISIBLE
        flag 34 (0x23L): progress == 0 ? View.GONE : View.VISIBLE
        flag 35 (0x24L): TextUtils.isEmpty(time) ? View.GONE : View.VISIBLE
        flag 36 (0x25L): TextUtils.isEmpty(time) ? View.GONE : View.VISIBLE
        flag 37 (0x26L): !selected ? !isPresent : false ? View.VISIBLE : View.GONE
        flag 38 (0x27L): !selected ? !isPresent : false ? View.VISIBLE : View.GONE
        flag 39 (0x28L): isSD ? isPresent : false ? View.VISIBLE : View.GONE
        flag 40 (0x29L): isSD ? isPresent : false ? View.VISIBLE : View.GONE
        flag 41 (0x2aL): isOTG ? isPresent : false
        flag 42 (0x2bL): isOTG ? isPresent : false
        flag 43 (0x2cL): selected ? View.VISIBLE : View.GONE
        flag 44 (0x2dL): selected ? View.VISIBLE : View.GONE
        flag 45 (0x2eL): seen == 0L ? View.GONE : View.VISIBLE
        flag 46 (0x2fL): seen == 0L ? View.GONE : View.VISIBLE
        flag 47 (0x30L): isPresent ? !inSelection : false
        flag 48 (0x31L): isPresent ? !inSelection : false
    flag mapping end*/
    //end
}