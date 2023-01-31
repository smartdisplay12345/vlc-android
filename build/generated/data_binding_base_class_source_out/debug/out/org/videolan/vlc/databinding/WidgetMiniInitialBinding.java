// Generated by data binding compiler. Do not edit!
package org.videolan.vlc.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;
import org.videolan.vlc.R;

public abstract class WidgetMiniInitialBinding extends ViewDataBinding {
  @NonNull
  public final TextView appName;

  @NonNull
  public final ImageButton playPause;

  @NonNull
  public final RelativeLayout widgetContainer;

  protected WidgetMiniInitialBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView appName, ImageButton playPause, RelativeLayout widgetContainer) {
    super(_bindingComponent, _root, _localFieldCount);
    this.appName = appName;
    this.playPause = playPause;
    this.widgetContainer = widgetContainer;
  }

  @NonNull
  public static WidgetMiniInitialBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.widget_mini_initial, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static WidgetMiniInitialBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<WidgetMiniInitialBinding>inflateInternal(inflater, R.layout.widget_mini_initial, root, attachToRoot, component);
  }

  @NonNull
  public static WidgetMiniInitialBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.widget_mini_initial, null, false, component)
   */
  @NonNull
  @Deprecated
  public static WidgetMiniInitialBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<WidgetMiniInitialBinding>inflateInternal(inflater, R.layout.widget_mini_initial, null, false, component);
  }

  public static WidgetMiniInitialBinding bind(@NonNull View view) {
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
  public static WidgetMiniInitialBinding bind(@NonNull View view, @Nullable Object component) {
    return (WidgetMiniInitialBinding)bind(component, view, R.layout.widget_mini_initial);
  }
}