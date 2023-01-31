// Generated by data binding compiler. Do not edit!
package org.videolan.vlc.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;
import org.videolan.medialibrary.interfaces.media.Bookmark;
import org.videolan.vlc.R;
import org.videolan.vlc.gui.helpers.BookmarkAdapter;

public abstract class BookmarkItemBinding extends ViewDataBinding {
  @NonNull
  public final TextView audioItemSubtitle;

  @NonNull
  public final TextView audioItemTitle;

  @NonNull
  public final AppCompatImageButton itemMore;

  @NonNull
  public final View selector;

  @Bindable
  protected BookmarkAdapter.ViewHolder mHolder;

  @Bindable
  protected Bookmark mBookmark;

  protected BookmarkItemBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView audioItemSubtitle, TextView audioItemTitle, AppCompatImageButton itemMore,
      View selector) {
    super(_bindingComponent, _root, _localFieldCount);
    this.audioItemSubtitle = audioItemSubtitle;
    this.audioItemTitle = audioItemTitle;
    this.itemMore = itemMore;
    this.selector = selector;
  }

  public abstract void setHolder(@Nullable BookmarkAdapter.ViewHolder holder);

  @Nullable
  public BookmarkAdapter.ViewHolder getHolder() {
    return mHolder;
  }

  public abstract void setBookmark(@Nullable Bookmark bookmark);

  @Nullable
  public Bookmark getBookmark() {
    return mBookmark;
  }

  @NonNull
  public static BookmarkItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.bookmark_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static BookmarkItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<BookmarkItemBinding>inflateInternal(inflater, R.layout.bookmark_item, root, attachToRoot, component);
  }

  @NonNull
  public static BookmarkItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.bookmark_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static BookmarkItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<BookmarkItemBinding>inflateInternal(inflater, R.layout.bookmark_item, null, false, component);
  }

  public static BookmarkItemBinding bind(@NonNull View view) {
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
  public static BookmarkItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (BookmarkItemBinding)bind(component, view, R.layout.bookmark_item);
  }
}
