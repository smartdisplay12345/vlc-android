// Generated by data binding compiler. Do not edit!
package org.videolan.vlc.databinding;

import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;
import org.videolan.medialibrary.interfaces.media.MediaWrapper;
import org.videolan.vlc.R;
import org.videolan.vlc.gui.audio.AudioAlbumTracksAdapter;

public abstract class AudioAlbumTrackItemBinding extends ViewDataBinding {
  @NonNull
  public final ImageView itemMore;

  @NonNull
  public final ImageView mediaAbsent;

  @NonNull
  public final ImageView mediaFavorite;

  @NonNull
  public final ImageView mediaNetwork;

  @NonNull
  public final ImageView mediaSd;

  @NonNull
  public final ImageView otgMedia;

  @NonNull
  public final ImageView selectedCheck;

  @NonNull
  public final TextView subtitle;

  @NonNull
  public final TextView title;

  @NonNull
  public final TextView trackNumber;

  @Bindable
  protected MediaWrapper mItem;

  @Bindable
  protected BitmapDrawable mCover;

  @Bindable
  protected int mImageWidth;

  @Bindable
  protected AudioAlbumTracksAdapter.TrackItemViewHolder mHolder;

  @Bindable
  protected boolean mIsNetwork;

  @Bindable
  protected boolean mIsOTG;

  @Bindable
  protected boolean mIsSD;

  @Bindable
  protected boolean mIsPresent;

  @Bindable
  protected boolean mIsFavorite;

  @Bindable
  protected boolean mInSelection;

  @Bindable
  protected boolean mSelected;

  protected AudioAlbumTrackItemBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView itemMore, ImageView mediaAbsent, ImageView mediaFavorite, ImageView mediaNetwork,
      ImageView mediaSd, ImageView otgMedia, ImageView selectedCheck, TextView subtitle,
      TextView title, TextView trackNumber) {
    super(_bindingComponent, _root, _localFieldCount);
    this.itemMore = itemMore;
    this.mediaAbsent = mediaAbsent;
    this.mediaFavorite = mediaFavorite;
    this.mediaNetwork = mediaNetwork;
    this.mediaSd = mediaSd;
    this.otgMedia = otgMedia;
    this.selectedCheck = selectedCheck;
    this.subtitle = subtitle;
    this.title = title;
    this.trackNumber = trackNumber;
  }

  public abstract void setItem(@Nullable MediaWrapper item);

  @Nullable
  public MediaWrapper getItem() {
    return mItem;
  }

  public abstract void setCover(@Nullable BitmapDrawable cover);

  @Nullable
  public BitmapDrawable getCover() {
    return mCover;
  }

  public abstract void setImageWidth(int imageWidth);

  public int getImageWidth() {
    return mImageWidth;
  }

  public abstract void setHolder(@Nullable AudioAlbumTracksAdapter.TrackItemViewHolder holder);

  @Nullable
  public AudioAlbumTracksAdapter.TrackItemViewHolder getHolder() {
    return mHolder;
  }

  public abstract void setIsNetwork(boolean isNetwork);

  public boolean getIsNetwork() {
    return mIsNetwork;
  }

  public abstract void setIsOTG(boolean isOTG);

  public boolean getIsOTG() {
    return mIsOTG;
  }

  public abstract void setIsSD(boolean isSD);

  public boolean getIsSD() {
    return mIsSD;
  }

  public abstract void setIsPresent(boolean isPresent);

  public boolean getIsPresent() {
    return mIsPresent;
  }

  public abstract void setIsFavorite(boolean isFavorite);

  public boolean getIsFavorite() {
    return mIsFavorite;
  }

  public abstract void setInSelection(boolean inSelection);

  public boolean getInSelection() {
    return mInSelection;
  }

  public abstract void setSelected(boolean selected);

  public boolean getSelected() {
    return mSelected;
  }

  @NonNull
  public static AudioAlbumTrackItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.audio_album_track_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static AudioAlbumTrackItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<AudioAlbumTrackItemBinding>inflateInternal(inflater, R.layout.audio_album_track_item, root, attachToRoot, component);
  }

  @NonNull
  public static AudioAlbumTrackItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.audio_album_track_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static AudioAlbumTrackItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<AudioAlbumTrackItemBinding>inflateInternal(inflater, R.layout.audio_album_track_item, null, false, component);
  }

  public static AudioAlbumTrackItemBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static AudioAlbumTrackItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (AudioAlbumTrackItemBinding)bind(component, view, R.layout.audio_album_track_item);
  }
}
