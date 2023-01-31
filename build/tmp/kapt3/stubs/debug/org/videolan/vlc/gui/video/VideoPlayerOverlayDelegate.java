package org.videolan.vlc.gui.video;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00d2\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000e\n\u0002\b\"\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J%\u0010\u00a5\u0001\u001a\u00030\u00a6\u00012\u0007\u0010\u00a7\u0001\u001a\u0002012\u0007\u0010\u00a8\u0001\u001a\u00020o2\u0007\u0010\u00a9\u0001\u001a\u000207H\u0002J\u001c\u0010\u00aa\u0001\u001a\u00030\u00a6\u00012\u0007\u0010\u00a7\u0001\u001a\u0002012\u0007\u0010\u00a8\u0001\u001a\u00020oH\u0002J\u0013\u0010\u00ab\u0001\u001a\u00030\u00ac\u00012\u0007\u0010\u00ad\u0001\u001a\u000207H\u0007J\u0012\u0010\u00ae\u0001\u001a\u0005\u0018\u00010\u00ac\u0001H\u0002\u00a2\u0006\u0003\u0010\u00af\u0001JA\u0010\u00b0\u0001\u001a\u00030\u00ac\u00012\u0010\u0010\u00b1\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u0001010\u00b2\u00012\b\u0010\u00b3\u0001\u001a\u00030\u00b4\u00012\u0013\b\u0002\u0010\u00b5\u0001\u001a\f\u0012\u0005\u0012\u00030\u00ac\u0001\u0018\u00010\u00b6\u0001H\u0002\u00a2\u0006\u0003\u0010\u00b7\u0001J,\u0010\u00b8\u0001\u001a\u00030\u00ac\u00012\u0010\u0010\u00b1\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u0001010\u00b2\u00012\b\u0010\u00b9\u0001\u001a\u00030\u00b4\u0001H\u0002\u00a2\u0006\u0003\u0010\u00ba\u0001J\u0013\u0010\u00bb\u0001\u001a\u00030\u00ac\u00012\t\u0010\u00a7\u0001\u001a\u0004\u0018\u000101J\b\u0010\u00bc\u0001\u001a\u00030\u00ac\u0001J\t\u0010\u00bd\u0001\u001a\u0004\u0018\u00010|J\t\u0010\u00be\u0001\u001a\u0004\u0018\u00010|J\b\u0010\u00bf\u0001\u001a\u00030\u00ac\u0001J\u001c\u0010\u00c0\u0001\u001a\u00030\u00ac\u00012\u0007\u0010\u00c1\u0001\u001a\u0002072\t\b\u0002\u0010\u00c2\u0001\u001a\u000207J\b\u0010\u00c3\u0001\u001a\u00030\u00ac\u0001J\n\u0010\u00c4\u0001\u001a\u00030\u00ac\u0001H\u0003J\n\u0010\u00c5\u0001\u001a\u00030\u00ac\u0001H\u0002J\n\u0010\u00c6\u0001\u001a\u00030\u00ac\u0001H\u0003J\u0007\u0010\u00c7\u0001\u001a\u000207J\u0007\u0010\u00c8\u0001\u001a\u000207J\u0007\u0010\u00c9\u0001\u001a\u000207J\u0007\u0010\u00ca\u0001\u001a\u000207J\b\u0010\u00cb\u0001\u001a\u00030\u00ac\u0001J\b\u0010\u00cc\u0001\u001a\u00030\u00ac\u0001J\n\u0010\u00cd\u0001\u001a\u00030\u00ac\u0001H\u0002J\n\u0010\u00ce\u0001\u001a\u00030\u00ac\u0001H\u0002J\n\u0010\u00cf\u0001\u001a\u00030\u00ac\u0001H\u0002J\n\u0010\u00d0\u0001\u001a\u00030\u00ac\u0001H\u0007J\b\u0010\u00d1\u0001\u001a\u00030\u00ac\u0001J\u0011\u0010\u00d2\u0001\u001a\u00030\u00ac\u00012\u0007\u0010\u00d3\u0001\u001a\u000207J\b\u0010\u00d4\u0001\u001a\u00030\u00ac\u0001J\u0011\u0010\u00d5\u0001\u001a\u00030\u00ac\u00012\u0007\u0010\u00d6\u0001\u001a\u00020oJ\u0012\u0010\u00d7\u0001\u001a\u00030\u00ac\u00012\b\u0010\u00d8\u0001\u001a\u00030\u00d9\u0001J\u0011\u0010\u00da\u0001\u001a\u00030\u00ac\u00012\u0007\u0010\u00db\u0001\u001a\u000207J\n\u0010\u00dc\u0001\u001a\u00030\u00ac\u0001H\u0002J\'\u0010\u00dd\u0001\u001a\u00030\u00ac\u00012\t\b\u0001\u0010\u00de\u0001\u001a\u00020o2\u0007\u0010\u00df\u0001\u001a\u00020o2\t\b\u0003\u0010\u00e0\u0001\u001a\u00020oJ\'\u0010\u00dd\u0001\u001a\u00030\u00ac\u00012\b\u0010\u00e1\u0001\u001a\u00030\u00d9\u00012\u0007\u0010\u00df\u0001\u001a\u00020o2\n\b\u0002\u0010\u00e2\u0001\u001a\u00030\u00d9\u0001J\u0012\u0010\u00e3\u0001\u001a\u00030\u00ac\u00012\b\u0010\u00d8\u0001\u001a\u00030\u00d9\u0001J\u0013\u0010\u00e4\u0001\u001a\u00030\u00ac\u00012\t\b\u0002\u0010\u00e5\u0001\u001a\u000207J\u0011\u0010\u00e6\u0001\u001a\u00030\u00ac\u00012\u0007\u0010\u00e7\u0001\u001a\u00020oJ\u0011\u0010\u00e8\u0001\u001a\u00030\u00ac\u00012\u0007\u0010\u00e9\u0001\u001a\u000207J\b\u0010\u00ea\u0001\u001a\u00030\u00ac\u0001J\u0011\u0010\u00eb\u0001\u001a\u00030\u00ac\u00012\u0007\u0010\u00ec\u0001\u001a\u00020oJ\b\u0010\u00ed\u0001\u001a\u00030\u00ac\u0001J\b\u0010\u00ee\u0001\u001a\u00030\u00ac\u0001J\b\u0010\u00ef\u0001\u001a\u00030\u00ac\u0001J\b\u0010\u00f0\u0001\u001a\u00030\u00ac\u0001J\b\u0010\u00f1\u0001\u001a\u00030\u00ac\u0001J\u0013\u0010\u00f2\u0001\u001a\u00030\u00ac\u00012\t\b\u0002\u0010\u00f3\u0001\u001a\u000207J\u0011\u0010\u00f4\u0001\u001a\u00030\u00ac\u00012\u0007\u0010\u00f5\u0001\u001a\u000207J\b\u0010\u00f6\u0001\u001a\u00030\u00ac\u0001J\b\u0010\u00f7\u0001\u001a\u00030\u00ac\u0001J\u0011\u0010\u00f8\u0001\u001a\u00030\u00ac\u00012\u0007\u0010\u00f9\u0001\u001a\u000207J\b\u0010\u00fa\u0001\u001a\u00030\u00ac\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\u001c\u0010 \u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\u001c\u0010#\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R\u001c\u0010&\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u0014\"\u0004\b(\u0010\u0016R\u001c\u0010)\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0014\"\u0004\b+\u0010\u0016R\u000e\u0010,\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u00100\u001a\u000201X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u000207X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R(\u0010>\u001a\u0004\u0018\u00010=2\b\u0010<\u001a\u0004\u0018\u00010=@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010C\u001a\u000207X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u00109\"\u0004\bE\u0010;R\u001c\u0010F\u001a\u0004\u0018\u00010GX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001c\u0010L\u001a\u0004\u0018\u00010GX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010I\"\u0004\bN\u0010KR\u000e\u0010O\u001a\u000207X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010P\u001a\u0004\u0018\u0001018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bQ\u00103R\u001a\u0010T\u001a\u00020UX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u001d\u0010Z\u001a\u0004\u0018\u0001018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\\\u0010S\u001a\u0004\b[\u00103R\u001a\u0010]\u001a\u00020^X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001c\u0010c\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bd\u0010\u0014\"\u0004\be\u0010\u0016R\u001c\u0010f\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\u0014\"\u0004\bh\u0010\u0016R\u000e\u0010i\u001a\u000207X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010j\u001a\u0004\u0018\u000101X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010k\u001a\u0004\u0018\u000101X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bl\u00103\"\u0004\bm\u00105R\u000e\u0010n\u001a\u00020oX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010p\u001a\u00020qX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u001a\u0010v\u001a\u00020qX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bw\u0010s\"\u0004\bx\u0010uR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020zX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020|X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u00020|X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010~\u001a\u00020\u007fX\u0086.\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R\u000f\u0010\u0084\u0001\u001a\u00020zX\u0082.\u00a2\u0006\u0002\n\u0000R \u0010\u0085\u0001\u001a\u00030\u0086\u0001X\u0086.\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001R \u0010\u008b\u0001\u001a\u00030\u008c\u0001X\u0086.\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001d\u0010\u0091\u0001\u001a\u000201X\u0086.\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u00103\"\u0005\b\u0093\u0001\u00105R \u0010\u0094\u0001\u001a\u00030\u0095\u0001X\u0086.\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001\"\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001d\u0010\u009a\u0001\u001a\u000207X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u009b\u0001\u00109\"\u0005\b\u009c\u0001\u0010;R\u001f\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u009e\u0001\u0010\u0014\"\u0005\b\u009f\u0001\u0010\u0016R\u0010\u0010\u00a0\u0001\u001a\u00030\u00a1\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u00a2\u0001\u001a\u00030\u00a1\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00a3\u0001\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00a4\u0001\u001a\u000207X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u00fb\u0001"}, d2 = {"Lorg/videolan/vlc/gui/video/VideoPlayerOverlayDelegate;", "", "player", "Lorg/videolan/vlc/gui/video/VideoPlayerActivity;", "(Lorg/videolan/vlc/gui/video/VideoPlayerActivity;)V", "_bt_exit", "Landroid/widget/Button;", "get_bt_exit", "()Landroid/widget/Button;", "set_bt_exit", "(Landroid/widget/Button;)V", "_rl_time_select", "Landroid/widget/RelativeLayout;", "get_rl_time_select", "()Landroid/widget/RelativeLayout;", "set_rl_time_select", "(Landroid/widget/RelativeLayout;)V", "_tv_time_hour_1", "Landroid/widget/TextView;", "get_tv_time_hour_1", "()Landroid/widget/TextView;", "set_tv_time_hour_1", "(Landroid/widget/TextView;)V", "_tv_time_hour_2", "get_tv_time_hour_2", "set_tv_time_hour_2", "_tv_time_min_1", "get_tv_time_min_1", "set_tv_time_min_1", "_tv_time_min_2", "get_tv_time_min_2", "set_tv_time_min_2", "_tv_time_sec_1", "get_tv_time_sec_1", "set_tv_time_sec_1", "_tv_time_sec_2", "get_tv_time_sec_2", "set_tv_time_sec_2", "_tv_video_err", "get_tv_video_err", "set_tv_video_err", "_tv_video_rate", "get_tv_video_rate", "set_tv_video_rate", "abRepeatAddMarker", "bookmarkListDelegate", "Lorg/videolan/vlc/gui/helpers/BookmarkListDelegate;", "brightnessValueText", "closeButton", "Landroid/view/View;", "getCloseButton", "()Landroid/view/View;", "setCloseButton", "(Landroid/view/View;)V", "enableSubs", "", "getEnableSubs", "()Z", "setEnableSubs", "(Z)V", "value", "Landroidx/window/layout/FoldingFeature;", "foldingFeature", "getFoldingFeature", "()Landroidx/window/layout/FoldingFeature;", "setFoldingFeature", "(Landroidx/window/layout/FoldingFeature;)V", "hasPlaylist", "getHasPlaylist", "setHasPlaylist", "hingeArrowLeft", "Landroid/widget/ImageView;", "getHingeArrowLeft", "()Landroid/widget/ImageView;", "setHingeArrowLeft", "(Landroid/widget/ImageView;)V", "hingeArrowRight", "getHingeArrowRight", "setHingeArrowRight", "hingeSnackShown", "hudBackground", "getHudBackground", "hudBackground$delegate", "Lkotlin/Lazy;", "hudBinding", "Lorg/videolan/vlc/databinding/PlayerHudBinding;", "getHudBinding", "()Lorg/videolan/vlc/databinding/PlayerHudBinding;", "setHudBinding", "(Lorg/videolan/vlc/databinding/PlayerHudBinding;)V", "hudRightBackground", "getHudRightBackground", "hudRightBackground$delegate", "hudRightBinding", "Lorg/videolan/vlc/databinding/PlayerHudRightBinding;", "getHudRightBinding", "()Lorg/videolan/vlc/databinding/PlayerHudRightBinding;", "setHudRightBinding", "(Lorg/videolan/vlc/databinding/PlayerHudRightBinding;)V", "info", "getInfo", "setInfo", "mVideoInfo", "getMVideoInfo", "setMVideoInfo", "orientationLockedBeforeLock", "overlayBackground", "overlayInfo", "getOverlayInfo", "setOverlayInfo", "overlayTimeout", "", "pauseToPlay", "Landroidx/vectordrawable/graphics/drawable/AnimatedVectorDrawableCompat;", "getPauseToPlay", "()Landroidx/vectordrawable/graphics/drawable/AnimatedVectorDrawableCompat;", "setPauseToPlay", "(Landroidx/vectordrawable/graphics/drawable/AnimatedVectorDrawableCompat;)V", "playToPause", "getPlayToPause", "setPlayToPause", "playerBrightnessProgress", "Lorg/videolan/vlc/gui/view/PlayerProgress;", "playerOverlayBrightness", "Landroidx/constraintlayout/widget/ConstraintLayout;", "playerOverlayVolume", "playerUiContainer", "Landroid/view/ViewGroup;", "getPlayerUiContainer", "()Landroid/view/ViewGroup;", "setPlayerUiContainer", "(Landroid/view/ViewGroup;)V", "playerVolumeProgress", "playlist", "Landroidx/recyclerview/widget/RecyclerView;", "getPlaylist", "()Landroidx/recyclerview/widget/RecyclerView;", "setPlaylist", "(Landroidx/recyclerview/widget/RecyclerView;)V", "playlistAdapter", "Lorg/videolan/vlc/gui/audio/PlaylistAdapter;", "getPlaylistAdapter", "()Lorg/videolan/vlc/gui/audio/PlaylistAdapter;", "setPlaylistAdapter", "(Lorg/videolan/vlc/gui/audio/PlaylistAdapter;)V", "playlistContainer", "getPlaylistContainer", "setPlaylistContainer", "playlistSearchText", "Lcom/google/android/material/textfield/TextInputLayout;", "getPlaylistSearchText", "()Lcom/google/android/material/textfield/TextInputLayout;", "setPlaylistSearchText", "(Lcom/google/android/material/textfield/TextInputLayout;)V", "seekButtons", "getSeekButtons", "setSeekButtons", "subinfo", "getSubinfo", "setSubinfo", "titleConstraintSetLandscape", "Landroidx/constraintlayout/widget/ConstraintSet;", "titleConstraintSetPortrait", "volumeValueText", "wasPlaying", "applyMargin", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "view", "margin", "isEnd", "applyVerticalMargin", "dimStatusBar", "", "dim", "downloadSubtitles", "()Lkotlin/Unit;", "enterAnimate", "views", "", "translationStart", "", "endListener", "Lkotlin/Function0;", "([Landroid/view/View;FLkotlin/jvm/functions/Function0;)V", "exitAnimate", "translationEnd", "([Landroid/view/View;F)V", "fadeOutInfo", "focusPlayPause", "getOverlayBrightness", "getOverlayVolume", "hideBookmarks", "hideOverlay", "fromUser", "forceTalkback", "initInfoOverlay", "initOverlay", "initPlaylistUi", "initSeekButton", "isBookmarkShown", "isHudBindingInitialized", "isHudRightBindingInitialized", "isPlaylistAdapterInitialized", "lockScreen", "manageHinge", "manageTitleConstraints", "pickSubtitles", "resetHingeLayout", "resetHudLayout", "rotateBookmarks", "setListeners", "enabled", "showBookmarks", "showBrightnessBar", "brightness", "showChangeSpeedMsg", "msg", "", "showControls", "show", "showHingeSnackIfNeeded", "showInfo", "textId", "duration", "subtextId", "text", "subText", "showMsg", "showOverlay", "forceCheck", "showOverlayTimeout", "timeout", "showTimeSelect", "isShow", "showTracks", "showVolumeBar", "volume", "toggleOverlay", "togglePlaylist", "unlockScreen", "updateHudMargins", "updateOrientationIcon", "updateOverlayPausePlay", "skipAnim", "updatePausable", "pausable", "updateRendererVisibility", "updateScreenshotButton", "updateSeekable", "seekable", "updateTitleConstraints", "vlc-android_debug"})
public final class VideoPlayerOverlayDelegate {
    private final org.videolan.vlc.gui.video.VideoPlayerActivity player = null;
    @org.jetbrains.annotations.Nullable()
    private android.widget.Button _bt_exit;
    @org.jetbrains.annotations.Nullable()
    private android.widget.TextView mVideoInfo;
    @org.jetbrains.annotations.Nullable()
    private android.widget.TextView _tv_video_err;
    @org.jetbrains.annotations.Nullable()
    private android.widget.RelativeLayout _rl_time_select;
    @org.jetbrains.annotations.Nullable()
    private android.widget.TextView _tv_time_hour_1;
    @org.jetbrains.annotations.Nullable()
    private android.widget.TextView _tv_time_hour_2;
    @org.jetbrains.annotations.Nullable()
    private android.widget.TextView _tv_time_min_1;
    @org.jetbrains.annotations.Nullable()
    private android.widget.TextView _tv_time_min_2;
    @org.jetbrains.annotations.Nullable()
    private android.widget.TextView _tv_time_sec_1;
    @org.jetbrains.annotations.Nullable()
    private android.widget.TextView _tv_time_sec_2;
    @org.jetbrains.annotations.Nullable()
    private android.widget.TextView _tv_video_rate;
    private androidx.constraintlayout.widget.ConstraintLayout playerOverlayBrightness;
    private android.widget.TextView brightnessValueText;
    private org.videolan.vlc.gui.view.PlayerProgress playerBrightnessProgress;
    private androidx.constraintlayout.widget.ConstraintLayout playerOverlayVolume;
    private android.widget.TextView volumeValueText;
    private org.videolan.vlc.gui.view.PlayerProgress playerVolumeProgress;
    @org.jetbrains.annotations.Nullable()
    private android.widget.TextView info;
    @org.jetbrains.annotations.Nullable()
    private android.widget.TextView subinfo;
    @org.jetbrains.annotations.Nullable()
    private android.view.View overlayInfo;
    public android.view.ViewGroup playerUiContainer;
    public org.videolan.vlc.databinding.PlayerHudBinding hudBinding;
    public org.videolan.vlc.databinding.PlayerHudRightBinding hudRightBinding;
    private android.view.View overlayBackground;
    private int overlayTimeout = 0;
    private boolean wasPlaying = true;
    public androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat playToPause;
    public androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat pauseToPlay;
    private final kotlin.Lazy hudBackground$delegate = null;
    private final kotlin.Lazy hudRightBackground$delegate = null;
    private android.widget.Button abRepeatAddMarker;
    private boolean seekButtons = false;
    private boolean hasPlaylist = false;
    private boolean hingeSnackShown = false;
    private boolean enableSubs = true;
    private org.videolan.vlc.gui.helpers.BookmarkListDelegate bookmarkListDelegate;
    private boolean orientationLockedBeforeLock = false;
    public android.view.View closeButton;
    public android.view.View playlistContainer;
    @org.jetbrains.annotations.Nullable()
    private android.widget.ImageView hingeArrowRight;
    @org.jetbrains.annotations.Nullable()
    private android.widget.ImageView hingeArrowLeft;
    public androidx.recyclerview.widget.RecyclerView playlist;
    public com.google.android.material.textfield.TextInputLayout playlistSearchText;
    public org.videolan.vlc.gui.audio.PlaylistAdapter playlistAdapter;
    @org.jetbrains.annotations.Nullable()
    private androidx.window.layout.FoldingFeature foldingFeature;
    private final androidx.constraintlayout.widget.ConstraintSet titleConstraintSetLandscape = null;
    private final androidx.constraintlayout.widget.ConstraintSet titleConstraintSetPortrait = null;
    
    public VideoPlayerOverlayDelegate(@org.jetbrains.annotations.NotNull()
    org.videolan.vlc.gui.video.VideoPlayerActivity player) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.Button get_bt_exit() {
        return null;
    }
    
    public final void set_bt_exit(@org.jetbrains.annotations.Nullable()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.TextView getMVideoInfo() {
        return null;
    }
    
    public final void setMVideoInfo(@org.jetbrains.annotations.Nullable()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.TextView get_tv_video_err() {
        return null;
    }
    
    public final void set_tv_video_err(@org.jetbrains.annotations.Nullable()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.RelativeLayout get_rl_time_select() {
        return null;
    }
    
    public final void set_rl_time_select(@org.jetbrains.annotations.Nullable()
    android.widget.RelativeLayout p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.TextView get_tv_time_hour_1() {
        return null;
    }
    
    public final void set_tv_time_hour_1(@org.jetbrains.annotations.Nullable()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.TextView get_tv_time_hour_2() {
        return null;
    }
    
    public final void set_tv_time_hour_2(@org.jetbrains.annotations.Nullable()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.TextView get_tv_time_min_1() {
        return null;
    }
    
    public final void set_tv_time_min_1(@org.jetbrains.annotations.Nullable()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.TextView get_tv_time_min_2() {
        return null;
    }
    
    public final void set_tv_time_min_2(@org.jetbrains.annotations.Nullable()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.TextView get_tv_time_sec_1() {
        return null;
    }
    
    public final void set_tv_time_sec_1(@org.jetbrains.annotations.Nullable()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.TextView get_tv_time_sec_2() {
        return null;
    }
    
    public final void set_tv_time_sec_2(@org.jetbrains.annotations.Nullable()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.TextView get_tv_video_rate() {
        return null;
    }
    
    public final void set_tv_video_rate(@org.jetbrains.annotations.Nullable()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.TextView getInfo() {
        return null;
    }
    
    public final void setInfo(@org.jetbrains.annotations.Nullable()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.TextView getSubinfo() {
        return null;
    }
    
    public final void setSubinfo(@org.jetbrains.annotations.Nullable()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.view.View getOverlayInfo() {
        return null;
    }
    
    public final void setOverlayInfo(@org.jetbrains.annotations.Nullable()
    android.view.View p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.ViewGroup getPlayerUiContainer() {
        return null;
    }
    
    public final void setPlayerUiContainer(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.videolan.vlc.databinding.PlayerHudBinding getHudBinding() {
        return null;
    }
    
    public final void setHudBinding(@org.jetbrains.annotations.NotNull()
    org.videolan.vlc.databinding.PlayerHudBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.videolan.vlc.databinding.PlayerHudRightBinding getHudRightBinding() {
        return null;
    }
    
    public final void setHudRightBinding(@org.jetbrains.annotations.NotNull()
    org.videolan.vlc.databinding.PlayerHudRightBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat getPlayToPause() {
        return null;
    }
    
    public final void setPlayToPause(@org.jetbrains.annotations.NotNull()
    androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat getPauseToPlay() {
        return null;
    }
    
    public final void setPauseToPlay(@org.jetbrains.annotations.NotNull()
    androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat p0) {
    }
    
    private final android.view.View getHudBackground() {
        return null;
    }
    
    private final android.view.View getHudRightBackground() {
        return null;
    }
    
    public final boolean getSeekButtons() {
        return false;
    }
    
    public final void setSeekButtons(boolean p0) {
    }
    
    public final boolean getHasPlaylist() {
        return false;
    }
    
    public final void setHasPlaylist(boolean p0) {
    }
    
    public final boolean getEnableSubs() {
        return false;
    }
    
    public final void setEnableSubs(boolean p0) {
    }
    
    public final boolean isHudBindingInitialized() {
        return false;
    }
    
    public final boolean isHudRightBindingInitialized() {
        return false;
    }
    
    public final boolean isPlaylistAdapterInitialized() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View getCloseButton() {
        return null;
    }
    
    public final void setCloseButton(@org.jetbrains.annotations.NotNull()
    android.view.View p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View getPlaylistContainer() {
        return null;
    }
    
    public final void setPlaylistContainer(@org.jetbrains.annotations.NotNull()
    android.view.View p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.ImageView getHingeArrowRight() {
        return null;
    }
    
    public final void setHingeArrowRight(@org.jetbrains.annotations.Nullable()
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.ImageView getHingeArrowLeft() {
        return null;
    }
    
    public final void setHingeArrowLeft(@org.jetbrains.annotations.Nullable()
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.RecyclerView getPlaylist() {
        return null;
    }
    
    public final void setPlaylist(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.material.textfield.TextInputLayout getPlaylistSearchText() {
        return null;
    }
    
    public final void setPlaylistSearchText(@org.jetbrains.annotations.NotNull()
    com.google.android.material.textfield.TextInputLayout p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.videolan.vlc.gui.audio.PlaylistAdapter getPlaylistAdapter() {
        return null;
    }
    
    public final void setPlaylistAdapter(@org.jetbrains.annotations.NotNull()
    org.videolan.vlc.gui.audio.PlaylistAdapter p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.window.layout.FoldingFeature getFoldingFeature() {
        return null;
    }
    
    public final void setFoldingFeature(@org.jetbrains.annotations.Nullable()
    androidx.window.layout.FoldingFeature value) {
    }
    
    /**
     * Changes the device layout depending on the scree foldable status and features
     */
    public final void manageHinge() {
    }
    
    /**
     * Shows the fold layout snackbar if needed
     */
    private final void showHingeSnackIfNeeded() {
    }
    
    /**
     * Resets the layout to normal after a fold/hinge status change
     */
    private final void resetHingeLayout() {
    }
    
    public final void showTracks() {
    }
    
    public final void showInfo(@androidx.annotation.StringRes()
    int textId, int duration, @androidx.annotation.StringRes()
    int subtextId) {
    }
    
    /**
     * Show text in the info view for "duration" milliseconds
     * @param text
     * @param duration
     */
    public final void showInfo(@org.jetbrains.annotations.NotNull()
    java.lang.String text, int duration, @org.jetbrains.annotations.NotNull()
    java.lang.String subText) {
    }
    
    public final void fadeOutInfo(@org.jetbrains.annotations.Nullable()
    android.view.View view) {
    }
    
    public final void initInfoOverlay() {
    }
    
    /**
     * Show the brightness value with  bar
     * @param brightness the brightness value
     */
    public final void showBrightnessBar(int brightness) {
    }
    
    /**
     * Show the volume value with  bar
     * @param volume the volume value
     */
    public final void showVolumeBar(int volume) {
    }
    
    /**
     * Dim the status bar and/or navigation icons when needed on Android 3.x.
     * Hide it on Android 4.0 and later
     */
    @android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.KITKAT)
    public final void dimStatusBar(boolean dim) {
    }
    
    /**
     * show overlay
     * @param forceCheck: adjust the timeout in function of playing state
     */
    public final void showOverlay(boolean forceCheck) {
    }
    
    /**
     * show overlay
     */
    public final void showOverlayTimeout(int timeout) {
    }
    
    public final void updateOverlayPausePlay(boolean skipAnim) {
    }
    
    private final void enterAnimate(android.view.View[] views, float translationStart, kotlin.jvm.functions.Function0<kotlin.Unit> endListener) {
    }
    
    private final void exitAnimate(android.view.View[] views, float translationEnd) {
    }
    
    @android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.JELLY_BEAN_MR1)
    private final void initOverlay() {
    }
    
    public final void updateSeekable(boolean seekable) {
    }
    
    public final void setListeners(boolean enabled) {
    }
    
    public final void updatePausable(boolean pausable) {
    }
    
    @android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.JELLY_BEAN_MR1)
    public final void resetHudLayout() {
    }
    
    @android.annotation.SuppressLint(value = {"ClickableViewAccessibility"})
    private final void initSeekButton() {
    }
    
    public final void updateOrientationIcon() {
    }
    
    public final void updateRendererVisibility() {
    }
    
    private final void manageTitleConstraints() {
    }
    
    public final void updateTitleConstraints() {
    }
    
    public final void updateHudMargins() {
    }
    
    private final androidx.constraintlayout.widget.ConstraintLayout.LayoutParams applyMargin(android.view.View view, int margin, boolean isEnd) {
        return null;
    }
    
    private final androidx.constraintlayout.widget.ConstraintLayout.LayoutParams applyVerticalMargin(android.view.View view, int margin) {
        return null;
    }
    
    public final void updateScreenshotButton() {
    }
    
    private final void initPlaylistUi() {
    }
    
    public final void togglePlaylist() {
    }
    
    public final void showControls(boolean show) {
    }
    
    /**
     * hider overlay
     */
    public final void hideOverlay(boolean fromUser, boolean forceTalkback) {
    }
    
    public final void focusPlayPause() {
    }
    
    public final void toggleOverlay() {
    }
    
    /**
     * Lock player
     */
    public final void lockScreen() {
    }
    
    /**
     * Remove player lock
     */
    public final void unlockScreen() {
    }
    
    private final void pickSubtitles() {
    }
    
    private final kotlin.Unit downloadSubtitles() {
        return null;
    }
    
    public final void showBookmarks() {
    }
    
    public final void rotateBookmarks() {
    }
    
    public final boolean isBookmarkShown() {
        return false;
    }
    
    public final void hideBookmarks() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.constraintlayout.widget.ConstraintLayout getOverlayBrightness() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.constraintlayout.widget.ConstraintLayout getOverlayVolume() {
        return null;
    }
    
    public final void showMsg(@org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
    
    public final void showChangeSpeedMsg(@org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
    
    public final void showTimeSelect(boolean isShow) {
    }
}