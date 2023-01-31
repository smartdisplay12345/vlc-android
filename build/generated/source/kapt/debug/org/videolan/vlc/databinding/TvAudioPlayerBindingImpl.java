package org.videolan.vlc.databinding;
import org.videolan.vlc.R;
import org.videolan.vlc.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class TvAudioPlayerBindingImpl extends TvAudioPlayerBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.background, 4);
        sViewsWithIds.put(R.id.album_cover, 5);
        sViewsWithIds.put(R.id.media_title, 6);
        sViewsWithIds.put(R.id.media_artist, 7);
        sViewsWithIds.put(R.id.button_repeat, 8);
        sViewsWithIds.put(R.id.button_previous, 9);
        sViewsWithIds.put(R.id.button_play, 10);
        sViewsWithIds.put(R.id.button_next, 11);
        sViewsWithIds.put(R.id.button_shuffle, 12);
        sViewsWithIds.put(R.id.playlist, 13);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public TvAudioPlayerBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private TvAudioPlayerBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.ImageView) bindings[5]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.ImageView) bindings[11]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[3]
            , (android.widget.ProgressBar) bindings[2]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[6]
            , (androidx.recyclerview.widget.RecyclerView) bindings[13]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mediaLength.setTag(null);
        this.mediaProgress.setTag(null);
        this.mediaTime.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
        if (BR.progress == variableId) {
            setProgress((androidx.lifecycle.LiveData<org.videolan.vlc.viewmodels.PlaybackProgress>) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setProgress(@Nullable androidx.lifecycle.LiveData<org.videolan.vlc.viewmodels.PlaybackProgress> Progress) {
        updateLiveDataRegistration(0, Progress);
        this.mProgress = Progress;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.progress);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeProgress((androidx.lifecycle.LiveData<org.videolan.vlc.viewmodels.PlaybackProgress>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeProgress(androidx.lifecycle.LiveData<org.videolan.vlc.viewmodels.PlaybackProgress> Progress, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
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
        org.videolan.vlc.viewmodels.PlaybackProgress progressGetValue = null;
        long progressLength = 0;
        androidx.lifecycle.LiveData<org.videolan.vlc.viewmodels.PlaybackProgress> progress = mProgress;
        int intProgressTime = 0;
        java.lang.String progressLengthText = null;
        int intProgressLength = 0;
        long progressTime = 0;
        java.lang.String progressTimeText = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (progress != null) {
                    // read progress.getValue()
                    progressGetValue = progress.getValue();
                }


                if (progressGetValue != null) {
                    // read progress.getValue().length
                    progressLength = progressGetValue.getLength();
                    // read progress.getValue().lengthText
                    progressLengthText = progressGetValue.getLengthText();
                    // read progress.getValue().time
                    progressTime = progressGetValue.getTime();
                    // read progress.getValue().timeText
                    progressTimeText = progressGetValue.getTimeText();
                }


                // read (int) progress.getValue().length
                intProgressLength = ((int) (progressLength));
                // read (int) progress.getValue().time
                intProgressTime = ((int) (progressTime));
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mediaLength, progressLengthText);
            this.mediaProgress.setProgress(intProgressTime);
            this.mediaProgress.setMax(intProgressLength);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mediaTime, progressTimeText);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): progress
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}