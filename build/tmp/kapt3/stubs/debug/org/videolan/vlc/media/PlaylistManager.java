package org.videolan.vlc.media;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00d2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u00de\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u00de\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J)\u0010s\u001a\u00020\u00142\f\u0010t\u001a\b\u0012\u0004\u0012\u00020v0u2\b\b\u0002\u0010w\u001a\u00020!H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010xJ\u0006\u0010y\u001a\u00020\u000fJ\u0006\u0010z\u001a\u00020\u000fJ\u0006\u0010{\u001a\u00020\u0014J\u001b\u0010|\u001a\u00020\u00142\b\b\u0002\u0010}\u001a\u00020\u000fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010~J\b\u0010\u007f\u001a\u00020\u0014H\u0002J\u001a\u0010}\u001a\u00020!2\u0007\u0010\u0080\u0001\u001a\u00020\u000fH\u0083@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010~J\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010vJ\u0012\u0010\u0082\u0001\u001a\u0004\u0018\u00010v2\u0007\u0010\u0083\u0001\u001a\u00020!J\r\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020v0uJ\u0007\u0010\u0085\u0001\u001a\u00020!J\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010vJ\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010vJ\u0012\u0010\u0088\u0001\u001a\u0002052\u0007\u0010\u0089\u0001\u001a\u00020vH\u0002J\u0007\u0010\u008a\u0001\u001a\u00020\u000fJ\u0007\u0010\u008b\u0001\u001a\u00020\u000fJ\u0007\u0010\u008c\u0001\u001a\u00020\u000fJ\u0007\u0010\u008d\u0001\u001a\u00020\u000fJ\u001b\u0010\u008e\u0001\u001a\u00020\u00142\u0007\u0010\u0083\u0001\u001a\u00020!2\u0007\u0010\u0089\u0001\u001a\u00020vH\u0007J\u0017\u0010\u008f\u0001\u001a\u00020\u00142\f\u0010t\u001a\b\u0012\u0004\u0012\u00020v0uH\u0007J\u000f\u0010\u0090\u0001\u001a\u00020\u000fH\u0000\u00a2\u0006\u0003\b\u0091\u0001J\u0010\u0010\u0092\u0001\u001a\u00020\u000f2\u0007\u0010\u0083\u0001\u001a\u00020!J@\u0010\u0093\u0001\u001a\u00020\u00142\f\u0010t\u001a\b\u0012\u0004\u0012\u00020v0u2\u0007\u0010\u0083\u0001\u001a\u00020!2\t\b\u0002\u0010\u0094\u0001\u001a\u00020\u000f2\t\b\u0002\u0010\u0095\u0001\u001a\u00020\u000fH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u0096\u0001J\u0012\u0010\u0097\u0001\u001a\u00020\u000f2\t\b\u0002\u0010\u0098\u0001\u001a\u00020!J!\u0010\u0099\u0001\u001a\u00020\u00142\r\u0010\u009a\u0001\u001a\b\u0012\u0004\u0012\u00020+0u2\u0007\u0010\u0083\u0001\u001a\u00020!H\u0007J\u0012\u0010\u009b\u0001\u001a\u00020\u00142\u0007\u0010\u009c\u0001\u001a\u00020vH\u0002J\u001b\u0010\u009d\u0001\u001a\u00020\u00142\u0007\u0010\u009e\u0001\u001a\u00020!2\u0007\u0010\u009f\u0001\u001a\u00020!H\u0007J\u0014\u0010\u00a0\u0001\u001a\u00020\u00142\t\b\u0002\u0010\u00a1\u0001\u001a\u00020\u000fH\u0007J\u0013\u0010\u00a2\u0001\u001a\u00020\u00142\b\u0010\u00a3\u0001\u001a\u00030\u00a4\u0001H\u0016J\u001a\u0010\u00a5\u0001\u001a\u00020\u00142\u0006\u0010w\u001a\u00020!2\u0007\u0010\u00a6\u0001\u001a\u00020+H\u0017J$\u0010\u00a7\u0001\u001a\u00020\u00142\u0007\u0010\u00a8\u0001\u001a\u00020!2\u0007\u0010\u00a9\u0001\u001a\u00020!2\u0007\u0010\u00a6\u0001\u001a\u00020+H\u0016J\u001a\u0010\u00aa\u0001\u001a\u00020\u00142\u0006\u0010w\u001a\u00020!2\u0007\u0010\u00a6\u0001\u001a\u00020+H\u0017J\u0007\u0010\u00ab\u0001\u001a\u00020\u0014J\u0007\u0010\u00ac\u0001\u001a\u00020\u0014J\u0007\u0010\u00ad\u0001\u001a\u00020\u0014J<\u0010\u00ae\u0001\u001a\u00020\u00142\u0006\u0010w\u001a\u00020!2\t\b\u0002\u0010\u00af\u0001\u001a\u00020!2\t\b\u0002\u0010\u00b0\u0001\u001a\u00020\u000f2\t\b\u0002\u0010\u00b1\u0001\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u00b2\u0001J\u0011\u0010I\u001a\u00020\u00142\u0007\u0010\u00a1\u0001\u001a\u00020\u000fH\u0007J\u0007\u0010\u00b3\u0001\u001a\u000205J\u0012\u0010\u00b4\u0001\u001a\u00020\u00142\u0007\u0010\u0089\u0001\u001a\u00020vH\u0002J\u0012\u0010\u00b5\u0001\u001a\u00020\u00142\u0007\u0010\u0083\u0001\u001a\u00020!H\u0007J\u0012\u0010\u00b6\u0001\u001a\u00020\u00142\u0007\u0010\u00b7\u0001\u001a\u00020+H\u0007J\u0007\u0010\u00b8\u0001\u001a\u00020\u0014J\u0007\u0010\u00b9\u0001\u001a\u00020\u0014J\u0007\u0010\u00ba\u0001\u001a\u00020\u0014J\u0007\u0010\u00bb\u0001\u001a\u00020\u0014J\u0012\u0010\u00bc\u0001\u001a\u00020\u00142\t\b\u0002\u0010\u00bd\u0001\u001a\u00020\u000fJ\u001d\u0010\u00be\u0001\u001a\u00020\u00142\t\b\u0002\u0010\u00bd\u0001\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010~J\u0013\u0010\u00bf\u0001\u001a\u00030\u00c0\u00012\t\b\u0002\u0010\u00c1\u0001\u001a\u00020\u000fJ\u001c\u0010\u00c2\u0001\u001a\u00020\u00142\u0007\u0010\u0089\u0001\u001a\u00020vH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u00c3\u0001J\u001f\u0010\u00c4\u0001\u001a\u00020\u00142\t\b\u0002\u0010\u00c5\u0001\u001a\u00020\u000f2\t\b\u0002\u0010\u00c6\u0001\u001a\u00020\u000fH\u0002J\u0010\u0010\u00c7\u0001\u001a\u00020\u00142\u0007\u0010\u00c8\u0001\u001a\u000205J\u0010\u0010\u00c9\u0001\u001a\u00020\u00142\u0007\u0010\u00ca\u0001\u001a\u000205J\u0019\u0010\u00cb\u0001\u001a\u00020\u00142\u0007\u0010\u00c8\u0001\u001a\u0002052\u0007\u0010\u00cc\u0001\u001a\u00020\u000fJ\u0013\u0010\u00cd\u0001\u001a\u00020\u00142\n\u0010\u00ce\u0001\u001a\u0005\u0018\u00010\u00cf\u0001J\u0012\u0010\u00d0\u0001\u001a\u00020\u00142\u0007\u0010\u00d1\u0001\u001a\u00020!H\u0007J\t\u0010\u00d2\u0001\u001a\u00020\u0014H\u0002J\u0010\u0010\u00d3\u0001\u001a\u00020\u00142\u0007\u0010\u00ca\u0001\u001a\u000205J\u000f\u0010\u00d4\u0001\u001a\u00020\u00142\u0006\u0010w\u001a\u00020+J\u0010\u0010\u00d5\u0001\u001a\u00020\u00142\u0007\u0010\u00d6\u0001\u001a\u00020\u000fJ\t\u0010\u00d7\u0001\u001a\u00020\u0014H\u0007J\t\u0010\u00d8\u0001\u001a\u00020\u0014H\u0002J\u001d\u0010\u00d9\u0001\u001a\u00020\u00142\t\b\u0002\u0010\u00da\u0001\u001a\u00020\u000f2\t\b\u0002\u0010\u00c6\u0001\u001a\u00020\u000fJ\t\u0010\u00db\u0001\u001a\u00020\u000fH\u0007J\u0007\u0010\u00dc\u0001\u001a\u00020\u0014J\u0007\u0010\u00dd\u0001\u001a\u00020\u0014R!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0010\u0010\u000bR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\r\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R!\u0010&\u001a\b\u0012\u0004\u0012\u00020\'0\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010\r\u001a\u0004\b(\u0010\u000bR\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010+X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010/\"\u0004\b3\u00101R\u000e\u00104\u001a\u000205X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u00109\u001a\u00020:8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u0010\r\u001a\u0004\b;\u0010<R\u000e\u0010>\u001a\u00020?X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010C\u001a\u00020D8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bG\u0010\r\u001a\u0004\bE\u0010FR\u000e\u0010H\u001a\u00020!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010I\u001a\b\u0012\u0004\u0012\u00020!0JX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020LX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010M\u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010#\"\u0004\bO\u0010%R\u001a\u0010P\u001a\u000205X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u001b\u0010W\u001a\u00020X8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b[\u0010\r\u001a\u0004\bY\u0010ZR\u000e\u0010\\\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010]\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b^\u0010/\"\u0004\b_\u00101R\u001a\u0010`\u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\ba\u0010#\"\u0004\bb\u0010%R\u001e\u0010d\u001a\u00020\u000f2\u0006\u0010c\u001a\u00020\u000f@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\be\u0010/R\u001a\u0010f\u001a\u00020gX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR!\u0010l\u001a\b\u0012\u0004\u0012\u00020\u000f0\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bn\u0010\r\u001a\u0004\bm\u0010\u000bR#\u0010o\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010p0\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\br\u0010\r\u001a\u0004\bq\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u00df\u0001"}, d2 = {"Lorg/videolan/vlc/media/PlaylistManager;", "Lorg/videolan/vlc/media/MediaWrapperList$EventListener;", "Lorg/videolan/libvlc/interfaces/IMedia$EventListener;", "Lkotlinx/coroutines/CoroutineScope;", "service", "Lorg/videolan/vlc/PlaybackService;", "(Lorg/videolan/vlc/PlaybackService;)V", "abRepeat", "Landroidx/lifecycle/MutableLiveData;", "Lorg/videolan/vlc/media/ABRepeat;", "getAbRepeat", "()Landroidx/lifecycle/MutableLiveData;", "abRepeat$delegate", "Lkotlin/Lazy;", "abRepeatOn", "", "getAbRepeatOn", "abRepeatOn$delegate", "addUpdateActor", "Lkotlinx/coroutines/channels/SendChannel;", "", "getAddUpdateActor$annotations", "()V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "ctx", "Landroid/content/Context;", "getCtx", "()Landroid/content/Context;", "ctx$delegate", "currentIndex", "", "getCurrentIndex", "()I", "setCurrentIndex", "(I)V", "delayValue", "Lorg/videolan/vlc/media/DelayValues;", "getDelayValue", "delayValue$delegate", "endReachedFor", "", "entryUrl", "expanding", "isBenchmark", "()Z", "setBenchmark", "(Z)V", "isHardware", "setHardware", "lastPrevious", "", "loadingLastPlaylist", "mediaFactory", "Lorg/videolan/libvlc/interfaces/IMediaFactory;", "medialibrary", "Lorg/videolan/medialibrary/interfaces/Medialibrary;", "getMedialibrary", "()Lorg/videolan/medialibrary/interfaces/Medialibrary;", "medialibrary$delegate", "mediaplayerEventListener", "Lorg/videolan/vlc/media/MediaPlayerEventListener;", "newMedia", "nextIndex", "parsed", "player", "Lorg/videolan/vlc/media/PlayerController;", "getPlayer", "()Lorg/videolan/vlc/media/PlayerController;", "player$delegate", "prevIndex", "previous", "Ljava/util/Stack;", "random", "Ljava/security/SecureRandom;", "repeating", "getRepeating", "setRepeating", "savedTime", "getSavedTime", "()J", "setSavedTime", "(J)V", "getService", "()Lorg/videolan/vlc/PlaybackService;", "settings", "Landroid/content/SharedPreferences;", "getSettings", "()Landroid/content/SharedPreferences;", "settings$delegate", "shouldDisableCookieForwarding", "shuffling", "getShuffling", "setShuffling", "stopAfter", "getStopAfter", "setStopAfter", "<set-?>", "videoBackground", "getVideoBackground", "videoResumeStatus", "Lorg/videolan/vlc/media/VideoResumeStatus;", "getVideoResumeStatus", "()Lorg/videolan/vlc/media/VideoResumeStatus;", "setVideoResumeStatus", "(Lorg/videolan/vlc/media/VideoResumeStatus;)V", "videoStatsOn", "getVideoStatsOn", "videoStatsOn$delegate", "waitForConfirmation", "Lorg/videolan/vlc/media/WaitConfirmation;", "getWaitForConfirmation", "waitForConfirmation$delegate", "append", "list", "", "Lorg/videolan/medialibrary/interfaces/media/MediaWrapper;", "index", "(Ljava/util/List;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "canRepeat", "canShuffle", "clearABRepeat", "determinePrevAndNextIndices", "expand", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeUpdate", "updateHistory", "getCurrentMedia", "getMedia", "position", "getMediaList", "getMediaListSize", "getNextMedia", "getPrevMedia", "getStartTime", "mw", "hasCurrentMedia", "hasNext", "hasPlaylist", "hasPrevious", "insertItem", "insertNext", "isAudioList", "isAudioList$vlc_android_debug", "isValidPosition", "load", "mlUpdate", "avoidErasingStop", "(Ljava/util/List;IZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLastPlaylist", "type", "loadLocations", "mediaPathList", "loadMediaMeta", "media", "moveItem", "positionStart", "positionEnd", "next", "force", "onEvent", "event", "Lorg/videolan/libvlc/interfaces/IMedia$Event;", "onItemAdded", "mrl", "onItemMoved", "indexBefore", "indexAfter", "onItemRemoved", "onServiceDestroyed", "pause", "play", "playIndex", "flags", "forceResume", "forceRestart", "(IIZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "previousTotalTime", "refreshTrackMeta", "remove", "removeLocation", "location", "resetABRepeatValues", "resetDelayValues", "resetResumeStatus", "restart", "saveCurrentMedia", "forceVideo", "saveMediaList", "saveMediaMeta", "Lkotlinx/coroutines/Job;", "end", "savePlaycount", "(Lorg/videolan/medialibrary/interfaces/media/MediaWrapper;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "savePosition", "reset", "video", "setABRepeatValue", "time", "setAudioDelay", "delay", "setDelayValue", "start", "setRenderer", "item", "Lorg/videolan/libvlc/RendererItem;", "setRepeatType", "repeatType", "setRepeatTypeFromSettings", "setSpuDelay", "setSpuTrack", "setVideoTrackEnabled", "enabled", "shuffle", "skipMedia", "stop", "systemExit", "switchToVideo", "toggleABRepeat", "toggleStats", "Companion", "vlc-android_debug"})
public final class PlaylistManager implements org.videolan.vlc.media.MediaWrapperList.EventListener, org.videolan.libvlc.interfaces.IMedia.EventListener, kotlinx.coroutines.CoroutineScope {
    @org.jetbrains.annotations.NotNull()
    private final org.videolan.vlc.PlaybackService service = null;
    private java.lang.String endReachedFor;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.coroutines.CoroutineContext coroutineContext = null;
    @org.jetbrains.annotations.NotNull()
    public static final org.videolan.vlc.media.PlaylistManager.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.lifecycle.MutableLiveData<java.lang.Boolean> showAudioPlayer = null;
    private static final org.videolan.vlc.media.MediaWrapperList mediaList = null;
    private final kotlin.Lazy medialibrary$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy player$delegate = null;
    private final kotlin.Lazy settings$delegate = null;
    private final kotlin.Lazy ctx$delegate = null;
    private int currentIndex = -1;
    private int nextIndex = -1;
    private int prevIndex = -1;
    private java.util.Stack<java.lang.Integer> previous;
    private int stopAfter = -1;
    private int repeating = android.support.v4.media.session.PlaybackStateCompat.REPEAT_MODE_NONE;
    private boolean shuffling = false;
    private boolean videoBackground = false;
    private boolean isBenchmark = false;
    private boolean isHardware = false;
    private boolean parsed = false;
    private long savedTime = 0L;
    private java.security.SecureRandom random;
    private boolean newMedia = false;
    @kotlin.jvm.Volatile()
    private volatile boolean expanding = false;
    private java.lang.String entryUrl;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy abRepeat$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy abRepeatOn$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy videoStatsOn$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy delayValue$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy waitForConfirmation$delegate = null;
    private long lastPrevious = -1L;
    private final org.videolan.libvlc.interfaces.IMediaFactory mediaFactory = null;
    public org.videolan.vlc.media.VideoResumeStatus videoResumeStatus;
    private boolean shouldDisableCookieForwarding = false;
    @kotlin.jvm.Volatile()
    private volatile boolean loadingLastPlaylist = false;
    private final kotlinx.coroutines.channels.SendChannel<kotlin.Unit> addUpdateActor = null;
    private final org.videolan.vlc.media.MediaPlayerEventListener mediaplayerEventListener = null;
    
    public PlaylistManager(@org.jetbrains.annotations.NotNull()
    org.videolan.vlc.PlaybackService service) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.videolan.vlc.PlaybackService getService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    private final org.videolan.medialibrary.interfaces.Medialibrary getMedialibrary() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.videolan.vlc.media.PlayerController getPlayer() {
        return null;
    }
    
    private final android.content.SharedPreferences getSettings() {
        return null;
    }
    
    private final android.content.Context getCtx() {
        return null;
    }
    
    public final int getCurrentIndex() {
        return 0;
    }
    
    public final void setCurrentIndex(int p0) {
    }
    
    public final int getStopAfter() {
        return 0;
    }
    
    public final void setStopAfter(int p0) {
    }
    
    public final int getRepeating() {
        return 0;
    }
    
    public final void setRepeating(int p0) {
    }
    
    public final boolean getShuffling() {
        return false;
    }
    
    public final void setShuffling(boolean p0) {
    }
    
    public final boolean getVideoBackground() {
        return false;
    }
    
    public final boolean isBenchmark() {
        return false;
    }
    
    public final void setBenchmark(boolean p0) {
    }
    
    public final boolean isHardware() {
        return false;
    }
    
    public final void setHardware(boolean p0) {
    }
    
    public final long getSavedTime() {
        return 0L;
    }
    
    public final void setSavedTime(long p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<org.videolan.vlc.media.ABRepeat> getAbRepeat() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getAbRepeatOn() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getVideoStatsOn() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<org.videolan.vlc.media.DelayValues> getDelayValue() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<org.videolan.vlc.media.WaitConfirmation> getWaitForConfirmation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.videolan.vlc.media.VideoResumeStatus getVideoResumeStatus() {
        return null;
    }
    
    public final void setVideoResumeStatus(@org.jetbrains.annotations.NotNull()
    org.videolan.vlc.media.VideoResumeStatus p0) {
    }
    
    public final boolean hasCurrentMedia() {
        return false;
    }
    
    public final boolean canRepeat() {
        return false;
    }
    
    public final boolean hasPlaylist() {
        return false;
    }
    
    public final boolean canShuffle() {
        return false;
    }
    
    public final boolean isValidPosition(int position) {
        return false;
    }
    
    public final void resetResumeStatus() {
    }
    
    /**
     * Loads a selection of files (a non-user-supplied collection of media)
     * into the primary or "currently playing" playlist.
     *
     * @param mediaPathList A list of locations to load
     * @param position The position to start playing at
     */
    @androidx.annotation.MainThread()
    public final void loadLocations(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> mediaPathList, int position) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.MainThread()
    public final java.lang.Object load(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends org.videolan.medialibrary.interfaces.media.MediaWrapper> list, int position, boolean mlUpdate, boolean avoidErasingStop, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    public final boolean loadLastPlaylist(int type) {
        return false;
    }
    
    public final void play() {
    }
    
    public final void pause() {
    }
    
    @androidx.annotation.MainThread()
    public final void next(boolean force) {
    }
    
    public final void restart() {
    }
    
    public final void stop(boolean systemExit, boolean video) {
    }
    
    @androidx.annotation.MainThread()
    public final void previous(boolean force) {
    }
    
    @androidx.annotation.MainThread()
    public final void shuffle() {
    }
    
    /**
     * Will set the repeating variable from the value that has been saved in settings
     */
    private final void setRepeatTypeFromSettings() {
    }
    
    @androidx.annotation.MainThread()
    public final void setRepeatType(int repeatType) {
    }
    
    public final void setRenderer(@org.jetbrains.annotations.Nullable()
    org.videolan.libvlc.RendererItem item) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object playIndex(int index, int flags, boolean forceResume, boolean forceRestart, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final void skipMedia() {
    }
    
    public final void onServiceDestroyed() {
    }
    
    @androidx.annotation.MainThread()
    public final boolean switchToVideo() {
        return false;
    }
    
    public final void setVideoTrackEnabled(boolean enabled) {
    }
    
    public final boolean hasPrevious() {
        return false;
    }
    
    public final boolean hasNext() {
        return false;
    }
    
    @androidx.annotation.MainThread()
    @java.lang.Override()
    public void onItemAdded(int index, @org.jetbrains.annotations.NotNull()
    java.lang.String mrl) {
    }
    
    @kotlin.OptIn(markerClass = {kotlinx.coroutines.ObsoleteCoroutinesApi.class})
    @java.lang.Deprecated()
    private static void getAddUpdateActor$annotations() {
    }
    
    @androidx.annotation.MainThread()
    @java.lang.Override()
    public void onItemRemoved(int index, @org.jetbrains.annotations.NotNull()
    java.lang.String mrl) {
    }
    
    private final void executeUpdate() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job saveMediaMeta(boolean end) {
        return null;
    }
    
    public final void setSpuTrack(@org.jetbrains.annotations.NotNull()
    java.lang.String index) {
    }
    
    public final void setAudioDelay(long delay) {
    }
    
    public final void setSpuDelay(long delay) {
    }
    
    private final void loadMediaMeta(org.videolan.medialibrary.interfaces.media.MediaWrapper media) {
    }
    
    @kotlin.jvm.Synchronized()
    public final synchronized void saveCurrentMedia(boolean forceVideo) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveMediaList(boolean forceVideo, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @java.lang.Override()
    public void onItemMoved(int indexBefore, int indexAfter, @org.jetbrains.annotations.NotNull()
    java.lang.String mrl) {
    }
    
    private final java.lang.Object determinePrevAndNextIndices(boolean expand, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    public final long previousTotalTime() {
        return 0L;
    }
    
    /**
     * Expand the current media.
     * @return the index of the media was expanded, and -1 if no media was expanded
     */
    @androidx.annotation.MainThread()
    private final java.lang.Object expand(boolean updateHistory, kotlin.coroutines.Continuation<? super java.lang.Integer> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.videolan.medialibrary.interfaces.media.MediaWrapper getCurrentMedia() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.videolan.medialibrary.interfaces.media.MediaWrapper getPrevMedia() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.videolan.medialibrary.interfaces.media.MediaWrapper getNextMedia() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.videolan.medialibrary.interfaces.media.MediaWrapper getMedia(int position) {
        return null;
    }
    
    private final long getStartTime(org.videolan.medialibrary.interfaces.media.MediaWrapper mw) {
        return 0L;
    }
    
    @kotlin.jvm.Synchronized()
    private final synchronized void savePosition(boolean reset, boolean video) {
    }
    
    /**
     * Append to the current existing playlist
     */
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.MainThread()
    public final java.lang.Object append(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends org.videolan.medialibrary.interfaces.media.MediaWrapper> list, int index, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    /**
     * Insert into the current existing playlist
     */
    @androidx.annotation.MainThread()
    public final void insertNext(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends org.videolan.medialibrary.interfaces.media.MediaWrapper> list) {
    }
    
    /**
     * Move an item inside the playlist.
     */
    @androidx.annotation.MainThread()
    public final void moveItem(int positionStart, int positionEnd) {
    }
    
    @androidx.annotation.MainThread()
    public final void insertItem(int position, @org.jetbrains.annotations.NotNull()
    org.videolan.medialibrary.interfaces.media.MediaWrapper mw) {
    }
    
    @androidx.annotation.MainThread()
    public final void remove(int position) {
    }
    
    @androidx.annotation.MainThread()
    public final void removeLocation(@org.jetbrains.annotations.NotNull()
    java.lang.String location) {
    }
    
    public final int getMediaListSize() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<org.videolan.medialibrary.interfaces.media.MediaWrapper> getMediaList() {
        return null;
    }
    
    public final void setABRepeatValue(long time) {
    }
    
    public final void setDelayValue(long time, boolean start) {
    }
    
    public final void resetDelayValues() {
    }
    
    public final void resetABRepeatValues() {
    }
    
    public final void toggleABRepeat() {
    }
    
    public final void toggleStats() {
    }
    
    public final void clearABRepeat() {
    }
    
    @java.lang.Override()
    public void onEvent(@org.jetbrains.annotations.NotNull()
    org.videolan.libvlc.interfaces.IMedia.Event event) {
    }
    
    /**
     * Refresh the track meta as the title and then updates the player
     * Useful for web radios changing the metadata during playback
     * @param mw: The [MediaWrapper] to be updated
     */
    private final void refreshTrackMeta(org.videolan.medialibrary.interfaces.media.MediaWrapper mw) {
    }
    
    private final java.lang.Object savePlaycount(org.videolan.medialibrary.interfaces.media.MediaWrapper mw, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    public final boolean isAudioList$vlc_android_debug() {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"Lorg/videolan/vlc/media/PlaylistManager$Companion;", "", "()V", "mediaList", "Lorg/videolan/vlc/media/MediaWrapperList;", "showAudioPlayer", "Landroidx/lifecycle/MutableLiveData;", "", "getShowAudioPlayer", "()Landroidx/lifecycle/MutableLiveData;", "hasMedia", "vlc-android_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getShowAudioPlayer() {
            return null;
        }
        
        public final boolean hasMedia() {
            return false;
        }
    }
}