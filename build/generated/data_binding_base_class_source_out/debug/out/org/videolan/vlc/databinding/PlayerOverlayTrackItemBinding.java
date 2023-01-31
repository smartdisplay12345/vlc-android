// Generated by data binding compiler. Do not edit!
package org.videolan.vlc.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.Deprecated;
import java.lang.Object;
import org.videolan.vlc.R;
import org.videolan.vlc.gui.view.CollapsibleLinearLayout;

public abstract class PlayerOverlayTrackItemBinding extends ViewDataBinding {
  @NonNull
  public final TextView emptyView;

  @NonNull
  public final CollapsibleLinearLayout options;

  @NonNull
  public final FrameLayout optionsContainer;

  @NonNull
  public final ConstraintLayout trackContainer;

  @NonNull
  public final RecyclerView trackList;

  @NonNull
  public final ImageView trackMore;

  @NonNull
  public final TextView trackTitle;

  protected PlayerOverlayTrackItemBinding(Object _bindingComponent, View _root,
      int _localFieldCount, TextView emptyView, CollapsibleLinearLayout options,
      FrameLayout optionsContainer, ConstraintLayout trackContainer, RecyclerView trackList,
      ImageView trackMore, TextView trackTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.emptyView = emptyView;
    this.options = options;
    this.optionsContainer = optionsContainer;
    this.trackContainer = trackContainer;
    this.trackList = trackList;
    this.trackMore = trackMore;
    this.trackTitle = trackTitle;
  }

  @NonNull
  public static PlayerOverlayTrackItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.player_overlay_track_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static PlayerOverlayTrackItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<PlayerOverlayTrackItemBinding>inflateInternal(inflater, R.layout.player_overlay_track_item, root, attachToRoot, component);
  }

  @NonNull
  public static PlayerOverlayTrackItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.player_overlay_track_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static PlayerOverlayTrackItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<PlayerOverlayTrackItemBinding>inflateInternal(inflater, R.layout.player_overlay_track_item, null, false, component);
  }

  public static PlayerOverlayTrackItemBinding bind(@NonNull View view) {
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
  public static PlayerOverlayTrackItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (PlayerOverlayTrackItemBinding)bind(component, view, R.layout.player_overlay_track_item);
  }
}