// Generated by data binding compiler. Do not edit!
package org.videolan.vlc.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentContainerView;
import java.lang.Deprecated;
import java.lang.Object;
import org.videolan.vlc.R;

public abstract class DialogAudioControlsSettingsBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout container;

  @NonNull
  public final FragmentContainerView fragmentContainerView;

  @NonNull
  public final TextView videoControlsTitle;

  protected DialogAudioControlsSettingsBinding(Object _bindingComponent, View _root,
      int _localFieldCount, ConstraintLayout container, FragmentContainerView fragmentContainerView,
      TextView videoControlsTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.container = container;
    this.fragmentContainerView = fragmentContainerView;
    this.videoControlsTitle = videoControlsTitle;
  }

  @NonNull
  public static DialogAudioControlsSettingsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dialog_audio_controls_settings, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static DialogAudioControlsSettingsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<DialogAudioControlsSettingsBinding>inflateInternal(inflater, R.layout.dialog_audio_controls_settings, root, attachToRoot, component);
  }

  @NonNull
  public static DialogAudioControlsSettingsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dialog_audio_controls_settings, null, false, component)
   */
  @NonNull
  @Deprecated
  public static DialogAudioControlsSettingsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<DialogAudioControlsSettingsBinding>inflateInternal(inflater, R.layout.dialog_audio_controls_settings, null, false, component);
  }

  public static DialogAudioControlsSettingsBinding bind(@NonNull View view) {
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
  public static DialogAudioControlsSettingsBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (DialogAudioControlsSettingsBinding)bind(component, view, R.layout.dialog_audio_controls_settings);
  }
}