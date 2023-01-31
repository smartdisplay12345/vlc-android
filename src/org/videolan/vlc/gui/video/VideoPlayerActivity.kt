/*****************************************************************************
 * VideoPlayerActivity.java
 *
 * Copyright © 2011-2017 VLC authors and VideoLAN
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston MA 02110-1301, USA.
 */

package org.videolan.vlc.gui.video

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.Activity
import android.app.KeyguardManager
import android.app.PictureInPictureParams
import android.bluetooth.BluetoothA2dp
import android.bluetooth.BluetoothHeadset
import android.content.*
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.graphics.Bitmap
import android.media.AudioManager
import android.net.Uri
import android.os.*
import android.text.Editable
import android.text.TextWatcher
import android.util.DisplayMetrics
import android.util.Log
import android.util.Rational
import android.view.*
import android.view.View.OnClickListener
import android.view.View.OnLongClickListener
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.DecelerateInterpolator
import android.view.animation.RotateAnimation
import android.widget.*
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.BaseContextWrappingDelegate
import androidx.appcompat.widget.PopupMenu
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.Guideline
import androidx.core.content.edit
import androidx.core.content.getSystemService
import androidx.core.net.toFile
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.databinding.BindingAdapter
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import androidx.window.layout.FoldingFeature
import androidx.window.layout.WindowInfoTracker
import androidx.window.layout.WindowLayoutInfo
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.videolan.libvlc.Dialog
import org.videolan.libvlc.MediaPlayer
import org.videolan.libvlc.interfaces.IMedia
import org.videolan.libvlc.util.AndroidUtil
import org.videolan.libvlc.util.DisplayManager
import org.videolan.libvlc.util.VLCVideoLayout
import org.videolan.medialibrary.MLServiceLocator
import org.videolan.medialibrary.Tools
import org.videolan.medialibrary.interfaces.Medialibrary
import org.videolan.medialibrary.interfaces.media.MediaWrapper
import org.videolan.resources.*
import org.videolan.resources.util.parcelable
import org.videolan.resources.util.parcelableList
import org.videolan.tools.*
import org.videolan.vlc.*
import org.videolan.vlc.BuildConfig
import org.videolan.vlc.R
import org.videolan.vlc.common.DefineRemocon
import org.videolan.vlc.common.Function
import org.videolan.vlc.common.MyConstants
import org.videolan.vlc.common.kog
import org.videolan.vlc.gui.DialogActivity
import org.videolan.vlc.gui.audio.EqualizerFragment
import org.videolan.vlc.gui.audio.PlaylistAdapter
import org.videolan.vlc.gui.browser.EXTRA_MRL
import org.videolan.vlc.gui.dialogs.PlaybackSpeedDialog
import org.videolan.vlc.gui.dialogs.RenderersDialog
import org.videolan.vlc.gui.dialogs.SleepTimerDialog
import org.videolan.vlc.gui.dialogs.adapters.VlcTrack
import org.videolan.vlc.gui.helpers.*
import org.videolan.vlc.gui.helpers.hf.StoragePermissionsDelegate
import org.videolan.vlc.interfaces.IPlaybackSettingsController
import org.videolan.vlc.media.NO_LENGTH_PROGRESS_MAX
import org.videolan.vlc.media.VideoResumeStatus
import org.videolan.vlc.media.WaitConfirmation
import org.videolan.vlc.repository.ExternalSubRepository
import org.videolan.vlc.repository.SlaveRepository
import org.videolan.vlc.util.*
import org.videolan.vlc.util.FileUtils
import org.videolan.vlc.util.FileUtils.getUri
import org.videolan.vlc.viewmodels.BookmarkModel
import org.videolan.vlc.viewmodels.PlaylistModel
import java.io.File
import java.lang.Runnable
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt


open class VideoPlayerActivity : AppCompatActivity(), PlaybackService.Callback, PlaylistAdapter.IPlayer, OnClickListener, OnLongClickListener, StoragePermissionsDelegate.CustomActionController, TextWatcher, IDialogManager, KeycodeListener {

    var hasPhysicalNotch: Boolean = false
    private var subtitlesExtraPath: String? = null
    private lateinit var startedScope: CoroutineScope
    var service: PlaybackService? = null
    lateinit var medialibrary: Medialibrary
    var videoLayout: VLCVideoLayout? = null
    lateinit var displayManager: DisplayManager
    var rootView: View? = null
    var videoUri: Uri? = null
    var savedMediaList: ArrayList<MediaWrapper>? = null
    var savedMediaIndex: Int = 0
    private var askResume = true

    var playlistModel: PlaylistModel? = null

    lateinit var settings: SharedPreferences

    private var isDragging: Boolean = false
    var isShowing: Boolean = false
    var isShowingDialog: Boolean = false
    internal var isLoading: Boolean = false
        private set
    private var isPlaying = false
    private var loadingImageView: ImageView? = null
    var enableCloneMode: Boolean = false
    lateinit var orientationMode: PlayerOrientationMode

    private var currentAudioTrack = "-2"
    private var currentSpuTrack = "-2"

    var isLocked = false

    /* -1 is a valid track (Disable) */
    private var lastAudioTrack = "-2"
    private var lastSpuTrack = "-2"
    var lockBackButton = false
    private var wasPaused = false
    private var savedTime: Long = -1

    lateinit var windowLayoutInfo: WindowLayoutInfo

    /**
     * For uninterrupted switching between audio and video mode
     */
    private var switchingView: Boolean = false
    private var switchToPopup: Boolean = false

    //Volume
    internal lateinit var audiomanager: AudioManager
        private set
    internal var audioMax: Int = 0
        private set
    internal var isAudioBoostEnabled: Boolean = false
        private set
    private var isMute = false
    private var volSave: Int = 0
    internal var volume: Float = 0.toFloat()
    internal var originalVol: Float = 0.toFloat()
    private var warningToast: Toast? = null

    internal var fov: Float = 0.toFloat()
    lateinit var touchDelegate: VideoTouchDelegate
    val statsDelegate: VideoStatsDelegate by lazy(LazyThreadSafetyMode.NONE) { VideoStatsDelegate(this, { overlayDelegate.showOverlayTimeout(OVERLAY_INFINITE) }, { overlayDelegate.showOverlay(true) }) }
    val delayDelegate: VideoDelayDelegate by lazy(LazyThreadSafetyMode.NONE) { VideoDelayDelegate(this@VideoPlayerActivity) }
    val screenshotDelegate: VideoPlayerScreenshotDelegate by lazy(LazyThreadSafetyMode.NONE) { VideoPlayerScreenshotDelegate(this@VideoPlayerActivity) }
    val overlayDelegate: VideoPlayerOverlayDelegate by lazy(LazyThreadSafetyMode.NONE) { VideoPlayerOverlayDelegate(this@VideoPlayerActivity) }
    val resizeDelegate: VideoPlayerResizeDelegate by lazy(LazyThreadSafetyMode.NONE) { VideoPlayerResizeDelegate(this@VideoPlayerActivity) }
    private val playerKeyListenerDelegate: PlayerKeyListenerDelegate by lazy(LazyThreadSafetyMode.NONE) { PlayerKeyListenerDelegate(this@VideoPlayerActivity) }
    val tipsDelegate: VideoTipsDelegate by lazy(LazyThreadSafetyMode.NONE) { VideoTipsDelegate(this@VideoPlayerActivity) }
    var isTv: Boolean = false

    private val dialogsDelegate = DialogDelegate()
    private var baseContextWrappingDelegate: AppCompatDelegate? = null

    /**
     * Flag to indicate whether the media should be paused once loaded
     * (e.g. lock screen, or to restore the pause state)
     */
    private var playbackStarted = false

    // Navigation handling (DVD, Blu-Ray...)
    var menuIdx = -1
    var isNavMenu = false

    /* for getTime and seek */
    private var forcedTime: Long = -1
    private var lastTime: Long = -1

    private var alertDialog: AlertDialog? = null

    var isBenchmark = false

    private val addedExternalSubs = ArrayList<org.videolan.vlc.mediadb.models.ExternalSub>()
    private var downloadedSubtitleLiveData: LiveData<List<org.videolan.vlc.mediadb.models.ExternalSub>>? = null
    private var previousMediaPath: String? = null

    private val isInteractive: Boolean
        @TargetApi(Build.VERSION_CODES.KITKAT_WATCH)
        get() {
            val pm = applicationContext.getSystemService<PowerManager>()!!
            return if (AndroidUtil.isLolliPopOrLater) pm.isInteractive else pm.isScreenOn
        }

    val playlistObserver = Observer<List<MediaWrapper>> { mediaWrappers -> if (mediaWrappers != null) overlayDelegate.playlistAdapter.update(mediaWrappers) }

    private var addNextTrack = false

    internal val isPlaybackSettingActive: Boolean
        get() = delayDelegate.playbackSetting != IPlaybackSettingsController.DelayState.OFF

    /**
     * Handle resize of the surface and the overlay
     */
    val handler: Handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            service?.run {
                when (msg.what) {
                    FADE_OUT -> overlayDelegate.hideOverlay(false)
                    FADE_OUT_INFO -> overlayDelegate.fadeOutInfo(overlayDelegate.overlayInfo)
                    FADE_OUT_BRIGHTNESS_INFO -> overlayDelegate.fadeOutInfo(overlayDelegate.getOverlayBrightness())
                    FADE_OUT_VOLUME_INFO -> overlayDelegate.fadeOutInfo(overlayDelegate.getOverlayVolume())
                    START_PLAYBACK -> startPlayback()
                    AUDIO_SERVICE_CONNECTION_FAILED -> exit(RESULT_CONNECTION_FAILED)
                    RESET_BACK_LOCK -> lockBackButton = true
                    CHECK_VIDEO_TRACKS -> if (videoTracksCount < 1 && audioTracksCount > 0) {
                        Log.i(TAG, "No video track, open in audio mode")
                        switchToAudioMode(true)
                    }
                    LOADING_ANIMATION -> startLoading()
                    HIDE_INFO -> overlayDelegate.hideOverlay(true)
                    SHOW_INFO -> overlayDelegate.showOverlay()
                    HIDE_SEEK -> touchDelegate.hideSeekOverlay()
                    HIDE_SETTINGS -> delayDelegate.endPlaybackSetting()
                    FADE_OUT_SCREENSHOT -> screenshotDelegate.hide()
                    else -> {
                    }
                }
            }
        }
    }

    private val switchAudioRunnable = Runnable {
        if (displayManager.isPrimary && service?.hasMedia() == true && service?.videoTracksCount == 0) {
            Log.i(TAG, "Video track lost, switching to audio")
            switchingView = true
            exit(RESULT_VIDEO_TRACK_LOST)
        }
    }

    /**
     * handle changes of the seekbar (slicer)
     */
    val seekListener = object : OnSeekBarChangeListener {

        override fun onStartTrackingTouch(seekBar: SeekBar) {
            isDragging = true
            overlayDelegate.showOverlayTimeout(OVERLAY_INFINITE)
        }

        override fun onStopTrackingTouch(seekBar: SeekBar) {
            isDragging = false
            overlayDelegate.showOverlay(true)
            seek(seekBar.progress.toLong(), fromUser = true, fast = false)
        }

        override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
            if (!isFinishing && fromUser && service?.isSeekable == true) {
                seek(progress.toLong(), fromUser, isDragging)
                if (service?.length != 0L) overlayDelegate.showInfo(Tools.millisToString(progress.toLong()), 1000)
            }
            if (fromUser) {
                overlayDelegate.showOverlay(true)
                overlayDelegate.hudBinding.playerOverlaySeekbar.forceAccessibilityUpdate()
            }
        }
    }

    internal val isOnPrimaryDisplay: Boolean
        get() = displayManager.isPrimary

    val currentScaleType: MediaPlayer.ScaleType
        get() = service?.mediaplayer?.videoScale ?: MediaPlayer.ScaleType.SURFACE_BEST_FIT

    private val isOptionsListShowing: Boolean
        get() = optionsDelegate?.isShowing() == true

    /* XXX: After a seek, playbackService.getTime can return the position before or after
             * the seek position. Therefore we return forcedTime in order to avoid the seekBar
             * to move between seek position and the actual position.
             * We have to wait for a valid position (that is after the seek position).
             * to re-init lastTime and forcedTime to -1 and return the actual position.
             */
    val time: Long
        get() {
            var time = service?.getTime() ?: 0L
            if (forcedTime != -1L && lastTime != -1L) {
                if (lastTime > forcedTime) {
                    if (time in (forcedTime + 1)..lastTime || time > lastTime) {
                        forcedTime = -1
                        lastTime = forcedTime
                    }
                } else {
                    if (time > forcedTime) {
                        forcedTime = -1
                        lastTime = forcedTime
                    }
                }
            } else if (time == 0L) service?.currentMediaWrapper?.time?.let { time = it }
            return if (forcedTime == -1L) time else forcedTime
        }

    private val downloadedSubtitleObserver = Observer<List<org.videolan.vlc.mediadb.models.ExternalSub>> { externalSubs ->
        for (externalSub in externalSubs) {
            if (!addedExternalSubs.contains(externalSub)) {
                service?.addSubtitleTrack(externalSub.subtitlePath, currentSpuTrack == "-2")
                addedExternalSubs.add(externalSub)
            }
        }
    }

    private val screenRotation: Int
        get() {
            val wm = applicationContext.getSystemService<WindowManager>()!!
            return wm.defaultDisplay?.rotation ?: Surface.ROTATION_0
        }

    private var optionsDelegate: PlayerOptionsDelegate? = null

    lateinit var bookmarkModel: BookmarkModel
    val isPlaylistVisible: Boolean
        get() = overlayDelegate.playlistContainer.visibility == View.VISIBLE

    private val btReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent?) {
            if (intent == null) return
            service?.let { service ->
                when (intent.action) {
                    BluetoothA2dp.ACTION_CONNECTION_STATE_CHANGED, BluetoothHeadset.ACTION_CONNECTION_STATE_CHANGED -> {
                        val savedDelay = settings.getLong(KEY_BLUETOOTH_DELAY, 0L)
                        val currentDelay = service.audioDelay
                        if (savedDelay != 0L) {
                            val connected = intent.getIntExtra(BluetoothA2dp.EXTRA_STATE, -1) == BluetoothA2dp.STATE_CONNECTED
                            if (connected && currentDelay == 0L)
                                toggleBtDelay(true)
                            else if (!connected && savedDelay == currentDelay)
                                toggleBtDelay(false)
                        }
                    }
                }
            }
        }
    }

    private val serviceReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if (intent.action == PLAY_FROM_SERVICE) onNewIntent(intent)
            else if (intent.action == EXIT_PLAYER) exitOK()
        }
    }

    // bslim
    private val IDEX_SHOW_MSG = 1
    private val TIME_SHOW_MSG = 3000
    private val IDEX_SHOW_CHANGE_SPEED_MSG = 2
    private val TIME_SHOW_CHANGE_SPEED_MSG = 3000
    private val IDEX_SHOW_TIME_SELECT = 3
    private val TIME_SHOW_TIME_SELECT = 3000

    private val IDEX_SHOW_PLAY_TIME_MSG = 4
    private val TIME_SHOW_PLAY_TIME_MSG = 1000
    private val IDEX_FIRST_MUTE = 5
    private val TIME_FIRST_MUTE = 1000
    private val IDEX_MAIN_LIST = 6
    private val TIME_MAIN_LIST = 5000


    private var mRepeatMode = MyConstants.REPEAT_FOLDER
    private var mIdxPlayVideoFile = -1

    private var mRemoconReceiver: BroadcastReceiver? = null

    // edit by ssh 20200812
    private var mVolumeReceiver: BroadcastReceiver? = null

    private var mIsRemoconControl = false
    private var mIsMute = false
    private var mIsTimeSelect = false
    private var mIsChangeSpeed = false
    private var mIsLastSetTime = false
    private var mIsMainList = false
    private var mIsListTouch = false

    private var mTimeSelHour1 = 0
    private var mTimeSelHour2 = 0
    private var mTimeSelMin1 = 0
    private var mTimeSelMin2 = 0
    private var mTimeSelSec1 = 0
    private var mTimeSelSec2 = 0
    private var mTimeSelMode = 0
    private var mStorageMode = 0
    private var mCurrVol = 0

    private var mPlayRate = 1.0f
    private var mLastSetTime = -1L

    private var mStopMode = 0
    private var mStopCnt = 0
    private var mRemoconDvdMode = -1
    private var mScaleType = 0
    private var mErrCount = 0

    private fun hide() {
        rootView?.systemUiVisibility = (View.SYSTEM_UI_FLAG_LOW_PROFILE
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
    }


    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hide()
    }

    override fun getApplicationContext(): Context {
        return super.getApplicationContext().getContextWithLocale(AppContextProvider.locale)
    }

    override fun getDelegate() = baseContextWrappingDelegate
            ?: BaseContextWrappingDelegate(super.getDelegate()).apply { baseContextWrappingDelegate = this }

    override fun createConfigurationContext(overrideConfiguration: Configuration) = super.createConfigurationContext(overrideConfiguration).getContextWithLocale(AppContextProvider.locale)

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        PreferenceUtil.init(this)

        dialogsDelegate.observeDialogs(this, this)
        Util.checkCpuCompatibility(this)

        settings = Settings.getInstance(this)

        /* Services and miscellaneous */
        audiomanager = applicationContext.getSystemService<AudioManager>()!!
        audioMax = audiomanager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        isAudioBoostEnabled = settings.getBoolean("audio_boost", true)

        enableCloneMode = clone ?: settings.getBoolean("enable_clone_mode", false)
        displayManager = DisplayManager(this, PlaybackService.renderer, false, enableCloneMode, isBenchmark)
        //setContentView(if (displayManager.isPrimary) R.layout.player else R.layout.player_remote_control)
        setContentView(R.layout.player)


        rootView = findViewById(R.id.player_root)


        overlayDelegate.playlist = findViewById(R.id.video_playlist)
        overlayDelegate.playlistSearchText = findViewById(R.id.playlist_search_text)
        overlayDelegate.playlistContainer = findViewById(R.id.video_playlist_container)
        overlayDelegate.closeButton = findViewById(R.id.close_button)
        overlayDelegate.hingeArrowRight = findViewById(R.id.hinge_go_right)
        overlayDelegate.hingeArrowLeft = findViewById(R.id.hinge_go_left)
        overlayDelegate.playlistSearchText.editText?.addTextChangedListener(this)

        overlayDelegate.playerUiContainer = findViewById(R.id.player_ui_container)

        overlayDelegate.mVideoInfo = findViewById(R.id.tv_video_info)
        overlayDelegate._tv_video_err = findViewById(R.id.tv_video_err)

        //overlayDelegate._tv_video_err.setText("파일에 문제가 있어서 원활한 재생이 되지 않을 수 있습니다.")

        overlayDelegate._rl_time_select = findViewById(R.id.rl_time_select)

        overlayDelegate._tv_time_hour_1 = findViewById(R.id.tv_time_hour_1)
        overlayDelegate._tv_time_hour_2 = findViewById(R.id.tv_time_hour_2)
        overlayDelegate._tv_time_min_1 = findViewById(R.id.tv_time_min_1)
        overlayDelegate._tv_time_min_2 = findViewById(R.id.tv_time_min_2)
        overlayDelegate._tv_time_sec_1 = findViewById(R.id.tv_time_sec_1)
        overlayDelegate._tv_time_sec_2 = findViewById(R.id.tv_time_sec_2)

        val screenOrientationSetting = Integer.valueOf(settings.getString(SCREEN_ORIENTATION, "99" /*SCREEN ORIENTATION SENSOR*/)!!)
        val sensor = settings.getBoolean(LOCK_USE_SENSOR, true)
        orientationMode = when (screenOrientationSetting) {
            99 -> PlayerOrientationMode(false)
            101 -> PlayerOrientationMode(true, if (sensor) ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE else ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
            102 -> PlayerOrientationMode(true, if (sensor) ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT else ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
            103 -> PlayerOrientationMode(true, ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE)
            98 -> PlayerOrientationMode(true, settings.getInt(LAST_LOCK_ORIENTATION, ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE))
            else -> PlayerOrientationMode(true, getOrientationForLock())
        }

        videoLayout = findViewById(R.id.video_layout)

        /* Loading view */
        loadingImageView = findViewById(R.id.player_overlay_loading)
        overlayDelegate.dimStatusBar(true)
        handler.sendEmptyMessageDelayed(LOADING_ANIMATION, LOADING_ANIMATION_DELAY.toLong())

        switchingView = false

        askResume = settings.getString(KEY_VIDEO_CONFIRM_RESUME, "0") == "2"
        sDisplayRemainingTime = settings.getBoolean(KEY_REMAINING_TIME_DISPLAY, false)
        // Clear the resume time, since it is only used for resumes in external
        // videos.
        //settings.putSingle(VIDEO_RESUME_TIME, -1L)
        // Paused flag - per session too, like the subs list.
        this.volumeControlStream = AudioManager.STREAM_MUSIC

        // 100 is the value for screen_orientation_start_lock
        try {
            requestedOrientation = getScreenOrientation(orientationMode)
            //as there is no ActivityInfo.SCREEN_ORIENTATION_SENSOR_REVERSE_LANDSCAPE, now that we are in reverse landscape, enable the sensor if needed
            if (screenOrientationSetting == 103 && sensor){
                orientationMode = PlayerOrientationMode(true,ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE)
                requestedOrientation = getScreenOrientation(orientationMode)
            }

            if (orientationMode.locked) settings.putSingle(LAST_LOCK_ORIENTATION, requestedOrientation)
        } catch (ignored: IllegalStateException) {
            Log.w(TAG, "onCreate: failed to set orientation")
        }
        overlayDelegate.updateOrientationIcon()

        // Extra initialization when no secondary display is detected
        isTv = Settings.showTvUi
        if (displayManager.isPrimary) {
            // Orientation
            // Tips
            if (!BuildConfig.DEBUG && !isTv && !settings.getBoolean(PREF_TIPS_SHOWN, false)
                && !isBenchmark
            ) {
                tipsDelegate.init()
            }
        }


        medialibrary = Medialibrary.getInstance()
        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)
        val yRange = dm.widthPixels.coerceAtMost(dm.heightPixels)
        val xRange = dm.widthPixels.coerceAtLeast(dm.heightPixels)
        val sc = ScreenConfig(dm, xRange, yRange, resources.configuration.orientation)
        touchDelegate = VideoTouchDelegate(this, generateTouchFlags(), sc, isTv)
        UiTools.setRotationAnimation(this)
        if (savedInstanceState != null) {
            savedTime = savedInstanceState.getLong(KEY_TIME)
            savedMediaList = savedInstanceState.parcelableList(KEY_MEDIA_LIST)
            savedMediaIndex = savedInstanceState.getInt(KEY_MEDIA_INDEX)
            val list = savedInstanceState.getBoolean(KEY_LIST, false)
            if (list) {
                intent.removeExtra(PLAY_EXTRA_ITEM_LOCATION)
            } else {
                videoUri = savedInstanceState.parcelable<Parcelable>(KEY_URI) as Uri?
            }
        }

        bookmarkModel = BookmarkModel.get(this)
        overlayDelegate.playToPause = AnimatedVectorDrawableCompat.create(this, R.drawable.anim_play_pause_video)!!
        overlayDelegate.pauseToPlay = AnimatedVectorDrawableCompat.create(this, R.drawable.anim_pause_play_video)!!

        ViewCompat.getWindowInsetsController(window.decorView)?.let { windowInsetsController ->
            windowInsetsController.systemBarsBehavior =
                    WindowInsetsControllerCompat.BEHAVIOR_SHOW_BARS_BY_SWIPE
        }

        lifecycleScope.launch(Dispatchers.Main) {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                WindowInfoTracker.getOrCreate(this@VideoPlayerActivity)
                        .windowLayoutInfo(this@VideoPlayerActivity)
                        .collect { layoutInfo ->
                            overlayDelegate.foldingFeature = layoutInfo.displayFeatures
                                    .firstOrNull() as? FoldingFeature
                            windowLayoutInfo = layoutInfo
                        }
            }
        }

        /*onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (optionsDelegate?.isShowing() == true) {
                    optionsDelegate?.hide()
                } else if (resizeDelegate.isShowing()) {
                    resizeDelegate.hideResizeOverlay()
                } else if (lockBackButton) {
                    lockBackButton = false
                    handler.sendEmptyMessageDelayed(RESET_BACK_LOCK, 2000)
                    Toast.makeText(applicationContext, getString(R.string.back_quit_lock), Toast.LENGTH_SHORT).show()
                } else if (isPlaylistVisible) {
                    overlayDelegate.togglePlaylist()
                } else if (isPlaybackSettingActive) {
                    delayDelegate.endPlaybackSetting()
                } else if (isShowing && service?.playlistManager?.videoStatsOn?.value == true) {
                    //hides video stats if they are displayed
                    service?.playlistManager?.videoStatsOn?.postValue(false)
                } else if (overlayDelegate.isBookmarkShown()) {
                    overlayDelegate.hideBookmarks()
                } else if ((AndroidDevices.isAndroidTv || isTalkbackIsEnabled()) && isShowing && !isLocked) {
                    overlayDelegate.hideOverlay(true)
                } else {
                    exitOK()
                }
            }
        })*/

        PlaybackService.start(this)

        // bslim
        mIsLastSetTime = false
        mIsMainList = false

        mPlayRate = MyConstants.g_VideoPlayRate
        //changeSpeed(mPlayRate)

        // edit by ssh 20200812
        //mCurrVol = PreferenceUtil.getMainVol()
        mCurrVol = audiomanager.getStreamVolume(AudioManager.STREAM_MUSIC)
        MyConstants.g_IsVideoMute = audiomanager.isStreamMute(AudioManager.STREAM_MUSIC)
        mIsMute = MyConstants.g_IsVideoMute
        kog.m("[VideoPlay] mAudioMax : $audioMax   mCurrVol : $mCurrVol   mIsMute : $mIsMute")

        Log.d("VOLUME", "onCreate")
        audiomanager.setStreamMute(AudioManager.STREAM_MUSIC, true)
        //audiomanager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_UNMUTE, 0)

        mRepeatMode = PreferenceUtil.getModeVideoRepeat()
        if (mRepeatMode == MyConstants.REPEAT_NO) {
            mStopMode = 0
        } else if (mRepeatMode == MyConstants.REPEAT_ONE) {
            mStopMode = 3
        } else if (mRepeatMode == MyConstants.REPEAT_ALL) {
            mStopMode = 2
        } else if (mRepeatMode == MyConstants.REPEAT_FOLDER) {
            mStopMode = 2
        }

        mStorageMode = PreferenceUtil.getModeStorage()

        mScaleType = MediaPlayer.ScaleType.SURFACE_16_9.ordinal
        //setVideoScale(MediaPlayer.ScaleType.SURFACE_16_9)
        kog.m("[VideoPlay] onCreate mRepeatMode : $mRepeatMode   mStopMode : $mStopMode   mScaleType : $mScaleType")

        val mRemoconFilter = IntentFilter()
        mRemoconFilter.addAction("MSG_UART_REMOCON")
        mRemoconFilter.addAction("MSG_FINISH")
        mRemoconFilter.addAction("MSG_LAUNCHER_EXIT")

        mRemoconReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent) {
                val action = intent.action
                if (action == "MSG_UART_REMOCON") {
                    val key = intent.getByteExtra("Key", (-1.toByte()).toByte())
                    val msg = String.format("%02x ", key.toInt().and(0xff))
                    kog.m("[VideoPlay] REMOCON : $msg   mIsRemoconControl : $mIsRemoconControl")
                    if (mIsRemoconControl) {
                        onRemoconMode(key)
                    }
                } else if (action == "MSG_FINISH") {
                    kog.m("[VideoPlay] MSG_FINISH")
                    mStopMode = -1
                    exitOK()
                } else if (action == "MSG_LAUNCHER_EXIT") {
                    mStopMode = -1
                    exitOK()
                }
            }
        }
        registerReceiver(mRemoconReceiver, mRemoconFilter)

        // edit by ssh 20200812
        val mVolumeFilter = IntentFilter()
        mVolumeFilter.addAction("android.media.VOLUME_CHANGED_ACTION")
        mVolumeReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                showCurrVolOnly()
            }
        }
        registerReceiver(mVolumeReceiver, mVolumeFilter)

        mHandlerMsg.sendEmptyMessageDelayed(IDEX_FIRST_MUTE, TIME_FIRST_MUTE.toLong())

        overlayDelegate._bt_exit = findViewById<View>(R.id.bt_exit) as Button
        overlayDelegate._bt_exit!!.setOnClickListener(this)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        hasPhysicalNotch = hasNotch()
        if (hasPhysicalNotch) {
            window.attributes.layoutInDisplayCutoutMode = settings.getInt(DISPLAY_UNDER_NOTCH, WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES)
        }
    }

    /**
     * Generates the touch flags for the [overlayDelegate] based on the controls settings
     *
     * @return the flag corresponding to the gesture the user wants to use
     */
    private fun generateTouchFlags() = if (false) {//!isTv) {
        val audioTouch = (!AndroidUtil.isLolliPopOrLater || !audiomanager.isVolumeFixed) && settings.getBoolean(ENABLE_VOLUME_GESTURE, true)
        val brightnessTouch = !AndroidDevices.isChromeBook && settings.getBoolean(ENABLE_BRIGHTNESS_GESTURE, true)
        ((if (audioTouch) TOUCH_FLAG_AUDIO_VOLUME else 0)
                + (if (brightnessTouch) TOUCH_FLAG_BRIGHTNESS else 0)
                + (if (settings.getBoolean(ENABLE_DOUBLE_TAP_SEEK, true)) TOUCH_FLAG_DOUBLE_TAP_SEEK else 0)
                + (if (settings.getBoolean(ENABLE_DOUBLE_TAP_PLAY, true)) TOUCH_FLAG_PLAY else 0)
                + (if (settings.getBoolean(ENABLE_SWIPE_SEEK, true)) TOUCH_FLAG_SWIPE_SEEK else 0)
                + (if (settings.getString(SCREENSHOT_MODE, "0") in arrayOf("2", "3")) TOUCH_FLAG_SCREENSHOT else 0)
                + (if (settings.getBoolean(ENABLE_SCALE_GESTURE, true)) TOUCH_FLAG_SCALE else 0))
    } else 0

    override fun fireDialog(dialog: Dialog) {
        DialogActivity.dialog = dialog
        startActivity(Intent(DialogActivity.KEY_DIALOG, null, this, DialogActivity::class.java))
    }

    override fun dialogCanceled(dialog: Dialog?) {
        (dialog?.context as? DialogFragment)?.dismiss()
    }

    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        if (s == null) return
        val length = s.length
        if (length > 0) {
            playlistModel?.filter(s)
        } else {
            playlistModel?.filter(null)
        }
    }

    private fun hideSearchField(): Boolean {
        if (overlayDelegate.playlistSearchText.visibility != View.VISIBLE) return false
        overlayDelegate.playlistSearchText.editText?.apply {
            removeTextChangedListener(this@VideoPlayerActivity)
            setText("")
            addTextChangedListener(this@VideoPlayerActivity)
        }
        UiTools.setKeyboardVisibility(overlayDelegate.playlistSearchText, false)

        return true
    }

    override fun onResume() {
        overridePendingTransition(0, 0)
        super.onResume()
        isShowingDialog = false
        /*
         * Set listeners here to avoid NPE when activity is closing
         */
        overlayDelegate.setListeners(true)

        if (isLocked && !orientationMode.locked) requestedOrientation = orientationMode.orientation
        overlayDelegate.updateOrientationIcon()
        arrayOf(FADE_OUT_VOLUME_INFO, FADE_OUT_BRIGHTNESS_INFO, FADE_OUT, FADE_OUT_INFO).forEach {
            handler.removeMessages(it)
            handler.sendEmptyMessage(it)
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        if (playbackStarted) service?.run {
            //if (overlayDelegate.isHudRightBindingInitialized()) {
            //    overlayDelegate.hudRightBinding.playerOverlayTitle.text = currentMediaWrapper?.title
            //            ?: return@run
            //}
            var uri: Uri? = if (intent.hasExtra(PLAY_EXTRA_ITEM_LOCATION)) {
                intent.extras?.parcelable<Parcelable>(PLAY_EXTRA_ITEM_LOCATION) as Uri?
            } else intent.data
            if (uri == null || uri == videoUri) return
            if ("file" == uri.scheme && uri.path?.startsWith("/sdcard") == true) {
                val convertedUri = FileUtils.convertLocalUri(uri)
                if (convertedUri == videoUri) return
                else uri = convertedUri
            }
            videoUri = uri
            if (isPlaylistVisible) {
                overlayDelegate.playlistAdapter.currentIndex = currentMediaPosition
                overlayDelegate.playlistContainer.setGone()
            }
            if (settings.getBoolean(VIDEO_TRANSITION_SHOW, true)) showTitle()
            initUI()
            lastTime = -1
            forcedTime = lastTime
            enableSubs()
            if (this.isPlaying) loadMedia(forceUsingNew = true)
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onPause() {
        kog.m("[VideoPlay] onPause")

        //mHandlerMsg.removeMessages(IDEX_SHOW_PLAY_TIME_MSG)
        mIsRemoconControl = false

        /*val finishing = isFinishing
        if (finishing)
            overridePendingTransition(0, 0)
        else
            overlayDelegate.hideOverlay(true)*/
        super.onPause()
        overlayDelegate.setListeners(false)

        /* Stop the earliest possible to avoid vout error */

        /*if (!isInPictureInPictureMode
                && (finishing || (AndroidUtil.isNougatOrLater && !AndroidUtil.isOOrLater //Video on background on Nougat Android TVs
                        && AndroidDevices.isAndroidTv && !requestVisibleBehind(true))))
            stopPlayback()*/
    }

    @TargetApi(Build.VERSION_CODES.O)
    override fun onUserLeaveHint() {
        if (!isInPictureInPictureMode && displayManager.isPrimary && !isShowingDialog &&
                "2" == settings.getString(KEY_VIDEO_APP_SWITCH, "0") && isInteractive && service?.hasRenderer() == false)
            switchToPopup()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        kog.m("[VideoPlay] onSaveInstanceState savedTime : " + savedTime);
        if (videoUri != null && "content" != videoUri?.scheme) {
            outState.putLong(KEY_TIME, savedTime)
            if (playlistModel == null) outState.putParcelable(KEY_URI, videoUri)
        }
        val mediaList = service?.playlistManager?.getMediaList() ?: savedMediaList
        val mediaIndex = service?.playlistManager?.currentIndex ?: 0
        if (mediaList != null) {
            outState.putParcelableArrayList(KEY_MEDIA_LIST, ArrayList(mediaList))
            outState.putInt(KEY_MEDIA_INDEX, mediaIndex)
            savedMediaList = null
        }
        videoUri = null
        outState.putBoolean(KEY_LIST, overlayDelegate.hasPlaylist)
    }

    @TargetApi(Build.VERSION_CODES.O)
    fun switchToPopup() {
        kog.m("[VideoPlay] onStart")

        if (isBenchmark) return
        optionsDelegate?.hide()
        //look for dialogs and close them
        supportFragmentManager.fragments.forEach { (it as? DialogFragment)?.dismiss() }
        val mw = service?.currentMediaWrapper
        if (mw == null || !AndroidDevices.pipAllowed || !isStarted()) return

        val forceLegacy = Settings.getInstance(this).getBoolean(POPUP_FORCE_LEGACY, false)
        if (AndroidDevices.hasPiP && !forceLegacy) {
            Permissions.checkPiPPermission(this)
            if (AndroidUtil.isOOrLater)
                try {
                    val track = service?.playlistManager?.player?.mediaplayer?.getSelectedVideoTrack()
                            ?: return
                    val ar = Rational(track.getWidth().coerceAtMost((track.getHeight() * 2.39f).toInt()), track.getHeight())
                    service?.updateWidgetState()
                    enterPictureInPictureMode(PictureInPictureParams.Builder().setAspectRatio(ar).build())
                } catch (e: IllegalArgumentException) { // Fallback with default parameters
                    enterPictureInPictureMode()
                }
            else enterPictureInPictureMode()
        } else {
            if (Permissions.canDrawOverlays(this)) {
                switchingView = true
                switchToPopup = true
                if (service?.isPlaying != true) mw.addFlags(MediaWrapper.MEDIA_PAUSED)
                cleanUI()
                exitOK()
            } else Permissions.checkDrawOverlaysPermission(this)
        }
    }

    override fun onVisibleBehindCanceled() {
        super.onVisibleBehindCanceled()
        stopPlayback()
        exitOK()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        this.resources.configuration.orientation = newConfig.orientation
        super.onConfigurationChanged(newConfig)

        /*if (::touchDelegate.isInitialized) {
            val dm = DisplayMetrics()
            windowManager.defaultDisplay.getMetrics(dm)
            val sc = ScreenConfig(dm,
                    dm.widthPixels.coerceAtLeast(dm.heightPixels),
                    dm.widthPixels.coerceAtMost(dm.heightPixels),
                    newConfig.orientation)
            touchDelegate.screenConfig = sc
        }*/
        overlayDelegate.resetHudLayout()
        overlayDelegate.showControls(isShowing)
        statsDelegate.onConfigurationChanged()
        overlayDelegate.updateHudMargins()
        overlayDelegate.updateTitleConstraints()
        overlayDelegate.rotateBookmarks()
        screenshotDelegate.hide()
    }

    override fun onStart() {
        medialibrary.pauseBackgroundOperations()
        super.onStart()
        kog.m("[VideoPlay] onStart")

        //PlaybackService.start(this)
        startedScope = MainScope()
        PlaybackService.serviceFlow.onEach { onServiceChanged(it) }.launchIn(startedScope)
        //restoreBrightness()
        val filter = IntentFilter(PLAY_FROM_SERVICE)
        filter.addAction(EXIT_PLAYER)
        LocalBroadcastManager.getInstance(this).registerReceiver(
                serviceReceiver, filter)
        val btFilter = IntentFilter(BluetoothA2dp.ACTION_CONNECTION_STATE_CHANGED)
        btFilter.addAction(BluetoothHeadset.ACTION_CONNECTION_STATE_CHANGED)
        registerReceiver(btReceiver, btFilter)
        overlayDelegate.overlayInfo.setInvisible()
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onStop() {
        super.onStop()
        kog.m("[VideoPlay] onStop")

        /*
        service?.playlistManager?.getMediaList()?.let {
            savedMediaList = ArrayList(it)
        }
        startedScope.cancel()
        LocalBroadcastManager.getInstance(this).unregisterReceiver(serviceReceiver)

        unregisterReceiver(btReceiver)
        alertDialog?.dismiss()
        if (displayManager.isPrimary && !isFinishing && service?.isPlaying == true
                && "1" == settings.getString(KEY_VIDEO_APP_SWITCH, "0") && !PlaybackService.hasRenderer()) {
            switchToAudioMode(false)
        }

        cleanUI()
        stopPlayback()*/

        service?.playlistManager?.videoStatsOn?.postValue(false)

        //if (savedTime != -1L) settings.putSingle(VIDEO_RESUME_TIME, savedTime)

        //saveBrightness()

        /*
        service?.playlistManager?.resetResumeStatus()

        service?.removeCallback(this)
        service = null
        // Clear Intent to restore playlist on activity restart
        intent = Intent()
        handler.removeCallbacksAndMessages(null)
        removeDownloadedSubtitlesObserver()
        previousMediaPath = null
        addedExternalSubs.clear()
        medialibrary.resumeBackgroundOperations()
         */
    }

    private fun saveBrightness() {
        // Save brightness if user wants to
        if (settings.getBoolean(SAVE_BRIGHTNESS, false)) {
            val brightness = window.attributes.screenBrightness
            if (brightness != -1f) settings.putSingle(BRIGHTNESS_VALUE, brightness)
        }
    }

    private fun restoreBrightness() {
        if (settings.getBoolean(SAVE_BRIGHTNESS, false)) {
            val brightness = settings.getFloat(BRIGHTNESS_VALUE, -1f)
            if (brightness != -1f) setWindowBrightness(brightness)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        kog.m("[VideoPlay] onDestroy")

        service?.playlistManager?.getMediaList()?.let {
            savedMediaList = ArrayList(it)
        }
        startedScope.cancel()
        LocalBroadcastManager.getInstance(this).unregisterReceiver(serviceReceiver)

        unregisterReceiver(btReceiver)
        alertDialog?.dismiss()
        if (displayManager.isPrimary && !isFinishing && service?.isPlaying == true
            && "1" == settings.getString(KEY_VIDEO_APP_SWITCH, "0") && !PlaybackService.hasRenderer()) {
            switchToAudioMode(false)
        }

        cleanUI()
        stopPlayback()

        service?.playlistManager?.videoStatsOn?.postValue(false)

        service?.playlistManager?.resetResumeStatus()

        service?.removeCallback(this)
        service = null
        // Clear Intent to restore playlist on activity restart
        intent = Intent()
        handler.removeCallbacksAndMessages(null)
        removeDownloadedSubtitlesObserver()
        previousMediaPath = null
        addedExternalSubs.clear()
        medialibrary.resumeBackgroundOperations()


        mHandlerMsg.removeMessages(IDEX_SHOW_MSG)
        mHandlerMsg.removeMessages(IDEX_SHOW_CHANGE_SPEED_MSG)
        mHandlerMsg.removeMessages(IDEX_SHOW_TIME_SELECT)
        mHandlerMsg.removeMessages(IDEX_SHOW_PLAY_TIME_MSG)
        mHandlerMsg.removeMessages(IDEX_FIRST_MUTE)
        mHandlerMsg.removeMessages(IDEX_MAIN_LIST)

        playlistModel?.run {
            dataset.removeObserver(playlistObserver)
            onCleared()
        }

        // Dismiss the presentation when the activity is not visible.
        displayManager.release()

        mIsLastSetTime = false
        mErrCount = 0

        /*if (mHandlerMsg != null){
			mHandlerMsg.removeMessages(IDEX_SHOW_MSG)
			mHandlerMsg.removeMessages(IDEX_SHOW_MSG)
			mHandlerMsg.removeMessages(IDEX_SHOW_CHANGE_SPEED_MSG)
			mHandlerMsg.removeMessages(IDEX_SHOW_TIME_SELECT)
			mHandlerMsg.removeMessages(IDEX_SHOW_PLAY_TIME_MSG)
		}*/

        if (mRemoconReceiver != null) unregisterReceiver(mRemoconReceiver)

        // edit by ssh 20200812
        if (mVolumeReceiver != null) unregisterReceiver(mVolumeReceiver)

        if (MyConstants.g_SelPlayList) {
            var intent: Intent? = null
            if (mStopMode == 0) {
                intent = Intent("MSG_PLAY_STOP")
                sendBroadcast(intent)
            } else if (mStopMode == 1) {
                Function.sendMsgPlayListPrev(this)
            } else if (mStopMode == 2) {
                Function.sendMsgPlayListNext(this)
            } else if (mStopMode == 3) {
                Function.sendMsgPlayListOne(this)
            } else if (mStopMode == 10) {
                intent = Intent("MSG_MAIN_LIST")
                sendBroadcast(intent)
            } else {
                intent = Intent("MSG_PLAY_STOP")
                sendBroadcast(intent)
            }
        } else {
            var intent: Intent? = null
            intent = if (mStopMode == 0) {
                Intent("MSG_PLAY_STOP")
            } else if (mStopMode == 1) {
                Intent("MSG_VIDEO_PLAY_PREV")
            } else if (mStopMode == 2) {
                Intent("MSG_VIDEO_PLAY_NEXT")
            } else if (mStopMode == 3) {
                Intent("MSG_VIDEO_PLAY_ONE")
            } else if (mStopMode == 10) {
                Intent("MSG_MAIN_LIST")
            } else if (mStopMode == 11) {
                Intent("MSG_VIDEO_STOP")
            } else {
                Intent("MSG_PLAY_STOP")
            }
            sendBroadcast(intent)
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private fun startPlayback() {
        /* start playback only when audio service and both surfaces are ready */
        if (playbackStarted) return

        // bslim
        savedTime = -1;

        service?.run {
            playbackStarted = true

            val vlcVout = vout
            if (vlcVout != null && vlcVout.areViewsAttached()) {
                if (isPlayingPopup) {
                    stop(video = true)
                } else
                    vlcVout.detachViews()
            }

            // bslim
            val mediaPlayer = mediaplayer
            if (!displayManager.isOnRenderer) videoLayout?.let {
                mediaPlayer.attachViews(it, displayManager, true, false)
                //val size = if (isBenchmark) MediaPlayer.ScaleType.SURFACE_FILL else MediaPlayer.ScaleType.values()[settings.getInt(VIDEO_RATIO, MediaPlayer.ScaleType.SURFACE_BEST_FIT.ordinal)]
                //mediaPlayer.videoScale = size
                mediaPlayer.videoScale = MediaPlayer.ScaleType.SURFACE_16_9
            }

            initUI()

            loadMedia()

            // bslim
            service?.setRate(mPlayRate, false);
        }
    }

    private fun initUI() {

        /* Listen for changes to media routes. */
        if (!isBenchmark) displayManager.setMediaRouterCallback()

        rootView?.run { keepScreenOn = true }
    }

    private fun setPlaybackParameters() {
        service?.run {
            if (audioDelay != 0L && audioDelay != audioDelay) setAudioDelay(audioDelay)
            else if (audiomanager.isBluetoothA2dpOn || audiomanager.isBluetoothScoOn) toggleBtDelay(true)
            if (spuDelay != 0L && spuDelay != spuDelay) setSpuDelay(spuDelay)
        }
    }

    private fun stopPlayback() {
        if (!playbackStarted) return

        if (!displayManager.isPrimary && !isFinishing || service == null) {
            playbackStarted = false
            return
        }
        service?.run {
            val tv = Settings.showTvUi
            val interactive = isInteractive
            wasPaused = !isPlaying || (!tv && !interactive)
            if (wasPaused) settings.putSingle(VIDEO_PAUSED, true)
            if (!isFinishing) {
                currentAudioTrack = audioTrack
                currentSpuTrack = spuTrack
                if (tv) finish() // Leave player on TV, restauration can be difficult
            }

            if (isMute) mute(false)

            playbackStarted = false

            handler.removeCallbacksAndMessages(null)
            if (hasMedia() && switchingView) {
                if (BuildConfig.DEBUG) Log.d(TAG, "mLocation = \"$videoUri\"")
                if (switchToPopup)
                    switchToPopup(currentMediaPosition)
                else {
                    mediaplayer.detachViews()
                    currentMediaWrapper?.addFlags(MediaWrapper.MEDIA_FORCE_AUDIO)
                    showWithoutParse(currentMediaPosition)
                }
                return
            }

            /* if (isSeekable) {
                savedTime = time
                val length = length
                //remove saved position if in the last 5 seconds
                if (length - savedTime < 5000)
                    savedTime = 0
                else
                    savedTime -= 2000 // go back 2 seconds, to compensate loading time
            } */

            // bslim
            service?.setRate(1.0f, false);

            stop(video = true)
        }
    }

    /**
     * Takes a screenshot from the surface view and forwards it to the [screenshotDelegate]
     *
     */
    fun takeScreenshot() {
        if (AndroidUtil.isOOrLater && !Permissions.canWriteStorage(this)) {
            Permissions.askWriteStoragePermission(this, false){}
            return
        }
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                videoLayout?.findViewById<FrameLayout>(R.id.player_surface_frame)?.let {
                    val surfaceView = it.findViewById<SurfaceView>(R.id.surface_video)
                    surfaceView?.let { surface ->
                        val width = service?.currentVideoTrack?.getWidth() ?: surface.width
                        val height = service?.currentVideoTrack?.getHeight() ?: surface.height
                        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
                        val simpleDateFormat = SimpleDateFormat("yyyyMMdd_HHmmss")
                        AndroidDevices.MediaFolders.EXTERNAL_PUBLIC_SCREENSHOTS_URI_DIRECTORY.toFile().mkdirs()
                        val dst = File(AndroidDevices.MediaFolders.EXTERNAL_PUBLIC_SCREENSHOTS_URI_DIRECTORY.path + "/vlc_${simpleDateFormat.format(Date())}.jpg")

                        PixelCopy.request(surface, bitmap, { copyResult ->
                            if (copyResult != 0) {
                                UiTools.snacker(this@VideoPlayerActivity, R.string.screenshot_error)
                                return@request
                            }
                            val coords = IntArray(2)
                            surfaceView.getLocationOnScreen(coords)
                            if (BitmapUtil.saveOnDisk(bitmap, dst.absolutePath))
                                screenshotDelegate.takeScreenshot(dst, bitmap, coords, surface.width, surface.height)
                            else
                                UiTools.snacker(this@VideoPlayerActivity, R.string.screenshot_error)
                        }, Handler(Looper.getMainLooper()))
                    }
                }

            }
        }

    }

    private fun cleanUI() {

        rootView?.run { keepScreenOn = false }

        /* Stop listening for changes to media routes. */
        if (!isBenchmark) displayManager.removeMediaRouterCallback()

        if (!displayManager.isSecondary) service?.mediaplayer?.detachViews()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null) return

        if (data.hasExtra(EXTRA_MRL)) {
            val subtitleUri = data.getStringExtra(EXTRA_MRL)!!.toUri()
            service?.addSubtitleTrack(getUri(subtitleUri) ?: subtitleUri, false)
            service?.currentMediaWrapper?.let {
                SlaveRepository.getInstance(this).saveSlave(it.location, IMedia.Slave.Type.Subtitle, 2, data.getStringExtra(EXTRA_MRL)!!)
            }
            addNextTrack = true
        } else if (BuildConfig.DEBUG) Log.d(TAG, "Subtitle selection dialog was cancelled")
    }

    open fun exit(resultCode: Int) {
        // bslim
        /*if (isFinishing) return
        val resultIntent = Intent(ACTION_RESULT)
        videoUri?.let { uri ->
            service?.run {
                if (AndroidUtil.isNougatOrLater)
                    resultIntent.putExtra(EXTRA_URI, uri.toString())
                else
                    resultIntent.data = videoUri
                resultIntent.putExtra(EXTRA_POSITION, time)
                resultIntent.putExtra(EXTRA_DURATION, length)
            }
            setResult(resultCode, resultIntent)
            finish()
        }*/
        finish()
    }

    private fun exitOK() {
        // bslim
        mIsRemoconControl = false

        exit(Activity.RESULT_OK)
    }

    override fun onTrackballEvent(event: MotionEvent): Boolean {
        if (isLoading) return false
        overlayDelegate.showOverlay()
        return true
    }

    override fun dispatchGenericMotionEvent(event: MotionEvent): Boolean {
        val result = !isLoading && ::touchDelegate.isInitialized && touchDelegate.dispatchGenericMotionEvent(event)
        return if (result) true else super.dispatchGenericMotionEvent(event)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true
        }
        /*
        if (service == null || keyCode == KeyEvent.KEYCODE_BACK || keyCode == KeyEvent.KEYCODE_BUTTON_B)
            return super.onKeyDown(keyCode, event)
        if (isOptionsListShowing) return false
        if (isPlaybackSettingActive && keyCode != KeyEvent.KEYCODE_J && keyCode != KeyEvent.KEYCODE_K
                && keyCode != KeyEvent.KEYCODE_G && keyCode != KeyEvent.KEYCODE_H) return false
        if (isLoading) {
            when (keyCode) {
                KeyEvent.KEYCODE_S, KeyEvent.KEYCODE_MEDIA_STOP -> {
                    exitOK()
                    return true
                }
            }
            return false
        }
        if (isShowing || fov == 0f && keyCode == KeyEvent.KEYCODE_DPAD_DOWN && !overlayDelegate.playlistContainer.isVisible())
            overlayDelegate.showOverlayTimeout(Settings.videoHudDelay * 1000)
        when (keyCode) {
            KeyEvent.KEYCODE_MEDIA_FAST_FORWARD -> {
                touchDelegate.seekDelta(Settings.videoDoubleTapJumpDelay * 1000)
                return true
            }
            KeyEvent.KEYCODE_MEDIA_REWIND -> {
                touchDelegate.seekDelta(-Settings.videoDoubleTapJumpDelay * 1000)
                return true
            }
            KeyEvent.KEYCODE_BUTTON_A -> {
                if (overlayDelegate.isHudBindingInitialized() && overlayDelegate.hudBinding.progressOverlay.isVisible())
                    return false
                when {
                    isNavMenu -> return navigateDvdMenu(keyCode)
                    keyCode == KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE
                        //prevent conflict with remote control
                    -> return super.onKeyDown(keyCode, event)
                    else -> doPlayPause()
                }
                return true
            }
            KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE, KeyEvent.KEYCODE_MEDIA_PLAY, KeyEvent.KEYCODE_MEDIA_PAUSE, KeyEvent.KEYCODE_SPACE -> {
                when {
                    isNavMenu -> return navigateDvdMenu(keyCode)
                    keyCode == KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE -> return super.onKeyDown(keyCode, event)
                    else -> doPlayPause()
                }
                return true
            }
            KeyEvent.KEYCODE_V, KeyEvent.KEYCODE_MEDIA_AUDIO_TRACK, KeyEvent.KEYCODE_BUTTON_X -> {
                onAudioSubClick(if (overlayDelegate.isHudBindingInitialized()) overlayDelegate.hudBinding.playerOverlayTracks else null)
                return true
            }
            KeyEvent.KEYCODE_A -> {
                resizeVideo()
                return true
            }
            KeyEvent.KEYCODE_M, KeyEvent.KEYCODE_VOLUME_MUTE -> {
                updateMute()
                return true
            }
            KeyEvent.KEYCODE_S, KeyEvent.KEYCODE_MEDIA_STOP -> {
                exitOK()
                return true
            }
            KeyEvent.KEYCODE_P -> {
                takeScreenshot()
                return true
            }
            KeyEvent.KEYCODE_DPAD_LEFT -> {
                if (isNavMenu)
                    return navigateDvdMenu(keyCode)
                else if (isLocked) {
                    overlayDelegate.showOverlayTimeout(Settings.videoHudDelay * 1000)
                } else if (!isShowing && !overlayDelegate.playlistContainer.isVisible() && !resizeDelegate.isShowing()) {
                    if (event.isAltPressed && event.isCtrlPressed) {
                        touchDelegate.seekDelta(-300000)
                    } else if (event.isShiftPressed && event.isCtrlPressed) {
                        touchDelegate.seekDelta(-30000)
                    } else if (event.isShiftPressed) {
                        touchDelegate.seekDelta(-5000)
                    } else if (event.isCtrlPressed) {
                        touchDelegate.seekDelta(-60000)
                    } else if (fov == 0f)
                        touchDelegate.seekDelta(-Settings.videoDoubleTapJumpDelay * 1000)
                    else
                        service?.updateViewpoint(-5f, 0f, 0f, 0f, false)
                    return true
                }
            }
            KeyEvent.KEYCODE_DPAD_RIGHT -> {
                if (isNavMenu)
                    return navigateDvdMenu(keyCode)
                else if (isLocked) {
                    overlayDelegate.showOverlayTimeout(Settings.videoHudDelay * 1000)
                } else if (!isShowing && !overlayDelegate.playlistContainer.isVisible() && !resizeDelegate.isShowing()) {
                    if (event.isAltPressed && event.isCtrlPressed) {
                        touchDelegate.seekDelta(300000)
                    } else if (event.isShiftPressed && event.isCtrlPressed) {
                        touchDelegate.seekDelta(30000)
                    } else if (event.isShiftPressed) {
                        touchDelegate.seekDelta(5000)
                    } else if (event.isCtrlPressed) {
                        touchDelegate.seekDelta(60000)
                    } else if (fov == 0f)
                        touchDelegate.seekDelta(Settings.videoDoubleTapJumpDelay * 1000)
                    else
                        service?.updateViewpoint(5f, 0f, 0f, 0f, false)
                    return true
                }
            }
            KeyEvent.KEYCODE_DPAD_UP -> {
                if (isNavMenu)
                    return navigateDvdMenu(keyCode)
                else if (isLocked) {
                    overlayDelegate.showOverlayTimeout(Settings.videoHudDelay * 1000)
                } else if (event.isCtrlPressed) {
                    volumeUp()
                    return true
                } else if (!isShowing && !overlayDelegate.playlistContainer.isVisible()) {
                    if (fov == 0f)
                        showAdvancedOptions()
                    else
                        service?.updateViewpoint(0f, -5f, 0f, 0f, false)
                    return true
                }
            }
            KeyEvent.KEYCODE_DPAD_DOWN -> {
                if (isNavMenu)
                    return navigateDvdMenu(keyCode)
                else if (isLocked) {
                    overlayDelegate.showOverlayTimeout(Settings.videoHudDelay * 1000)
                } else if (event.isCtrlPressed) {
                    volumeDown()
                    return true
                } else if (!isShowing && fov != 0f) {
                    service?.updateViewpoint(0f, 5f, 0f, 0f, false)
                    return true
                }
            }
            KeyEvent.KEYCODE_DPAD_CENTER -> {
                if (isNavMenu)
                    return navigateDvdMenu(keyCode)
                else if (isLocked) {
                    overlayDelegate.showOverlayTimeout(Settings.videoHudDelay * 1000)
                } else if (!isShowing && !resizeDelegate.isShowing()) {
                    doPlayPause()
                    return true
                }
            }
            KeyEvent.KEYCODE_ENTER -> return if (isNavMenu)
                navigateDvdMenu(keyCode)
            else
                super.onKeyDown(keyCode, event)
            KeyEvent.KEYCODE_J -> {
                delayDelegate.delayAudioOrSpu(delta = -50000L, delayState = IPlaybackSettingsController.DelayState.AUDIO)
                handler.removeMessages(HIDE_SETTINGS)
                handler.sendEmptyMessageDelayed(HIDE_SETTINGS, 4000L)
                return true
            }
            KeyEvent.KEYCODE_K -> {
                delayDelegate.showDelayControls()
                delayDelegate.delayAudioOrSpu(delta = 50000L, delayState = IPlaybackSettingsController.DelayState.AUDIO)
                handler.removeMessages(HIDE_SETTINGS)
                handler.sendEmptyMessageDelayed(HIDE_SETTINGS, 4000L)
                return true
            }
            KeyEvent.KEYCODE_G -> {
                delayDelegate.delayAudioOrSpu(delta = -50000L, delayState = IPlaybackSettingsController.DelayState.SUBS)
                handler.removeMessages(HIDE_SETTINGS)
                handler.sendEmptyMessageDelayed(HIDE_SETTINGS, 4000L)
                return true
            }
            KeyEvent.KEYCODE_T -> {
                overlayDelegate.showOverlay()
            }
            KeyEvent.KEYCODE_H -> {
                if (event.isCtrlPressed) {
                    overlayDelegate.showOverlay()
                } else {
                    delayDelegate.delayAudioOrSpu(delta = 50000L, delayState = IPlaybackSettingsController.DelayState.SUBS)
                    handler.removeMessages(HIDE_SETTINGS)
                    handler.sendEmptyMessageDelayed(HIDE_SETTINGS, 4000L)
                }
                return true
            }
            KeyEvent.KEYCODE_Z -> {
                resizeVideo()
                return true
            }
            KeyEvent.KEYCODE_VOLUME_DOWN -> {
                volumeDown()
                return true
            }
            KeyEvent.KEYCODE_VOLUME_UP -> {
                volumeUp()
                return true
            }
            KeyEvent.KEYCODE_CAPTIONS -> {
                onAudioSubClick(if (overlayDelegate.isHudBindingInitialized()) overlayDelegate.hudBinding.playerOverlayTracks else null)
                return true
            }
            KeyEvent.KEYCODE_C -> {
                resizeVideo()
                return true
            }
        }
        if (playerKeyListenerDelegate.onKeyDown(keyCode, event)) return true
         */

        return super.onKeyDown(keyCode, event)
    }

    override fun showEqualizer() {
        val newFragment = EqualizerFragment()
        newFragment.onDismissListener = DialogInterface.OnDismissListener { overlayDelegate.dimStatusBar(true) }
        newFragment.show(supportFragmentManager, "equalizer")
    }

    override fun next() {
        service?.next()
    }

    override fun previous() {
        service?.previous(false)
    }

    override fun stop() {
        service?.stop()
    }

    override fun seek(delta: Int) {
        touchDelegate.seekDelta(delta)
    }


    override fun togglePlayPause() {
        doPlayPause()
    }

    override fun increaseRate() {
        service?.increaseRate()
    }

    override fun decreaseRate() {
        service?.decreaseRate()
    }

    override fun resetRate() {
        service?.resetRate()
    }

    override fun bookmark() {
        bookmarkModel.addBookmark(this)
        UiTools.snackerConfirm(this, getString(R.string.bookmark_added), confirmMessage = R.string.show) {
            overlayDelegate.showOverlay()
            overlayDelegate.showBookmarks()
        }
    }

    override fun isReady() = true

    override fun showAdvancedOptions() {
        if (optionsDelegate == null) service?.let {
            optionsDelegate = PlayerOptionsDelegate(this, it)
            optionsDelegate!!.setBookmarkClickedListener {
                overlayDelegate.showBookmarks()
            }
        }
        optionsDelegate?.show()
        overlayDelegate.hideOverlay(fromUser = false, forceTalkback = true)
    }

    private fun volumeUp() {
        if (isMute) {
            updateMute()
        } else service?.let { service ->
            var volume = if (audiomanager.getStreamVolume(AudioManager.STREAM_MUSIC) < audioMax)
                audiomanager.getStreamVolume(AudioManager.STREAM_MUSIC) + 1
            else
                (service.volume.toFloat() * audioMax / 100 + 1).roundToInt()
            volume = volume.coerceAtLeast(0).coerceAtMost(audioMax * if (isAudioBoostEnabled) 2 else 1)
            setAudioVolume(volume)
        }
    }

    private fun volumeDown() {
        service?.let { service ->
            var vol = if (service.volume > 100)
                (service.volume.toFloat() * audioMax / 100 - 1).roundToInt()
            else
                audiomanager.getStreamVolume(AudioManager.STREAM_MUSIC) - 1
            vol = vol.coerceAtLeast(0).coerceAtMost(audioMax * if (isAudioBoostEnabled) 2 else 1)
            originalVol = vol.toFloat()
            setAudioVolume(vol)
        }
    }

    internal fun navigateDvdMenu(keyCode: Int): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_DPAD_UP -> {
                service?.navigate(MediaPlayer.Navigate.Up)
                return true
            }
            KeyEvent.KEYCODE_DPAD_DOWN -> {
                service?.navigate(MediaPlayer.Navigate.Down)
                return true
            }
            KeyEvent.KEYCODE_DPAD_LEFT -> {
                service?.navigate(MediaPlayer.Navigate.Left)
                return true
            }
            KeyEvent.KEYCODE_DPAD_RIGHT -> {
                service?.navigate(MediaPlayer.Navigate.Right)
                return true
            }
            KeyEvent.KEYCODE_DPAD_CENTER, KeyEvent.KEYCODE_ENTER, KeyEvent.KEYCODE_BUTTON_X, KeyEvent.KEYCODE_BUTTON_A -> {
                service?.navigate(MediaPlayer.Navigate.Activate)
                return true
            }
            else -> return false
        }
    }

    override fun update() {
        if (service == null || !overlayDelegate.isPlaylistAdapterInitialized()) return
        playlistModel?.update()
    }

    override fun onMediaEvent(event: IMedia.Event) {
        when (event.type) {
            IMedia.Event.ParsedChanged -> updateNavStatus()
            IMedia.Event.MetaChanged -> {
            }
        }
    }

    override fun onMediaPlayerEvent(event: MediaPlayer.Event) {
        service?.let { service ->
            when (event.type) {
                MediaPlayer.Event.Playing -> onPlaying()
                MediaPlayer.Event.Paused -> overlayDelegate.updateOverlayPausePlay()
                MediaPlayer.Event.Opening -> {
                    forcedTime = -1
                    if (!subtitlesExtraPath.isNullOrEmpty()) {
                        service.addSubtitleTrack(subtitlesExtraPath!!, true)
                        subtitlesExtraPath = null
                    }
                }
                MediaPlayer.Event.Vout -> {
                    updateNavStatus()
                    if (event.voutCount > 0)
                        service.mediaplayer.updateVideoSurfaces()
                    if (menuIdx == -1)
                        handleVout(event.voutCount)
                }
                MediaPlayer.Event.ESAdded -> {
                    if (menuIdx == -1) {
                        val mw = service.currentMediaWrapper ?: return
                        if (event.esChangedType == IMedia.Track.Type.Audio) {
                            lifecycleScope.launch(Dispatchers.IO) {
                                val media = medialibrary.findMedia(mw)
                                var preferredTrack = "0"
                                val preferredAudioLang = settings.getString(AUDIO_PREFERRED_LANGUAGE, "")
                                if (!preferredAudioLang.isNullOrEmpty()) {
                                    /** ⚠️limitation: See [LocaleUtil] header comment */
                                    val allTracks = getCurrentMediaTracks()
                                    service.audioTracks?.iterator()?.let { audioTracks ->
                                        while (audioTracks.hasNext()) {
                                            val next = audioTracks.next()
                                            val realTrack = allTracks.find { it.id.toString() == next.getId() }
                                            if (LocaleUtil.getLocaleFromVLC(realTrack?.language
                                                            ?: "") == preferredAudioLang) {
                                                preferredTrack = next.getId()
                                                break
                                            }
                                        }
                                    }
                                }
                                val audioTrack = when (val savedTrack = media.getMetaString(MediaWrapper.META_AUDIOTRACK) ?: "0") {
                                    "0" -> preferredTrack
                                    else -> savedTrack
                                }
                                if (audioTrack != "0" || currentAudioTrack != "-2")
                                    service.setAudioTrack(audioTrack.toString())
                            }
                        } else if (event.esChangedType == IMedia.Track.Type.Text) {
                            lifecycleScope.launch(Dispatchers.IO) {
                                val media = medialibrary.findMedia(mw)
                                var preferredTrack = "0"
                                val preferredSpuLang = settings.getString(SUBTITLE_PREFERRED_LANGUAGE, "")
                                if (!preferredSpuLang.isNullOrEmpty()) {
                                    val allTracks = getCurrentMediaTracks()
                                    service.spuTracks?.iterator()?.let { spuTracks ->
                                        while (spuTracks.hasNext()) {
                                            val next = spuTracks.next()
                                            val realTrack = allTracks.find {it.id.toString() == next.getId() }
                                            if (LocaleUtil.getLocaleFromVLC(realTrack?.language
                                                            ?: "") == preferredSpuLang) {
                                                preferredTrack = next.getId()
                                                break
                                            }
                                        }
                                    }
                                }
                                val spuTrack = when (val savedTrack = media.getMetaString(MediaWrapper.META_SUBTITLE_TRACK) ?: "0") {
                                    "0" -> preferredTrack
                                    else -> savedTrack
                                }
                                if (addNextTrack) {
                                    val tracks = service.spuTracks
                                    @Suppress("UNCHECKED_CAST")
                                    if ((tracks as Array<VlcTrack>).isNotEmpty()) service.setSpuTrack(tracks[tracks.size - 1].getId())
                                    addNextTrack = false
                                } else if (spuTrack != "0" || currentSpuTrack != "-2") {
                                    service.setSpuTrack(spuTrack)
                                    lastSpuTrack = "-2"
                                }
                            }
                        }
                    }
                    if (menuIdx == -1 && event.esChangedType == IMedia.Track.Type.Video) {
                        handler.removeMessages(CHECK_VIDEO_TRACKS)
                        handler.sendEmptyMessageDelayed(CHECK_VIDEO_TRACKS, 1000)
                        lifecycleScope.launch(Dispatchers.IO) {
                            service.currentMediaWrapper?.let { mw ->
                                val media = medialibrary.findMedia(mw)
                                val videoTrack = media.getMetaString(MediaWrapper.META_VIDEOTRACK) ?: "0"
                                if (videoTrack != "0" && media.id != 0L) service.setVideoTrack(videoTrack)
                            }
                        }
                    }
                }
                MediaPlayer.Event.ESDeleted -> {
                    if (menuIdx == -1 && event.esChangedType == IMedia.Track.Type.Video) {
                        handler.removeMessages(CHECK_VIDEO_TRACKS)
                        handler.sendEmptyMessageDelayed(CHECK_VIDEO_TRACKS, 1000)
                    }
                }
                MediaPlayer.Event.ESSelected -> if (event.esChangedType == IMedia.Track.Type.Video) {
                    val vt = service.currentVideoTrack
                    if (vt != null)
                        fov = if (vt.getProjection() == IMedia.VideoTrack.Projection.Rectangular) 0f else DEFAULT_FOV
                }
                MediaPlayer.Event.SeekableChanged -> overlayDelegate.updateSeekable(event.seekable)
                MediaPlayer.Event.PausableChanged -> overlayDelegate.updatePausable(event.pausable)
                MediaPlayer.Event.Buffering -> {
                    if (isPlaying) {
                        if (event.buffering == 100f)
                            stopLoading()
                        else if (!handler.hasMessages(LOADING_ANIMATION) && !isLoading
                                && (!::touchDelegate.isInitialized || !touchDelegate.isSeeking()) && !isDragging)
                            handler.sendEmptyMessageDelayed(LOADING_ANIMATION, LOADING_ANIMATION_DELAY.toLong())
                    }
                }
            }
        }
    }

    private var currentTracks: Pair<String, List<IMedia.Track>>? = null

    /**
     * Extract all the tracks from the current media
     * The tracks are also cached in [currentTracks] to avoid some native calls
     *
     * @return a list of [IMedia.Track]
     */
    private fun getCurrentMediaTracks():List<IMedia.Track> {

        service?.let { service ->
            val allTracks= ArrayList<IMedia.Track>()
            service.mediaplayer.media?.let { media ->
                if (currentTracks?.first == media.uri.toString()) return currentTracks!!.second
                for (i in 0..media.getAllTracks().size) {
                    val track = media.getAllTracks()[i]
                    allTracks.add(track)
                }
                currentTracks = Pair(media.uri.toString(), allTracks)
            }
            return allTracks
        }
        return listOf()
    }

    private fun onPlaying() {
        val mw = service?.currentMediaWrapper ?: return
        isPlaying = true
        overlayDelegate.hasPlaylist = service?.hasPlaylist() == true
        setPlaybackParameters()
        stopLoading()
        overlayDelegate.updateOverlayPausePlay()
        updateNavStatus()
        if (!mw.hasFlag(MediaWrapper.MEDIA_PAUSED) && Settings.videoHudDelay != -1)
            handler.sendEmptyMessageDelayed(FADE_OUT, Settings.videoHudDelay.toLong() * 1000)
        else {
            mw.removeFlags(MediaWrapper.MEDIA_PAUSED)
            wasPaused = false
        }
        setESTracks()
        //if (overlayDelegate.isHudRightBindingInitialized() && overlayDelegate.hudRightBinding.playerOverlayTitle.length() == 0)
        //    overlayDelegate.hudRightBinding.playerOverlayTitle.text = mw.title
        // Get possible subtitles
        observeDownloadedSubtitles()
        optionsDelegate?.setup()
        settings.edit { remove(VIDEO_PAUSED) }
        if (isInPictureInPictureMode && Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val track = service?.playlistManager?.player?.mediaplayer?.getSelectedVideoTrack() ?: return
            val ar =
                Rational(track.getWidth().coerceAtMost((track.getHeight() * 2.39f).toInt()), track.getHeight())
            if (ar.isFinite && !ar.isZero) {
                setPictureInPictureParams(
                    PictureInPictureParams.Builder().setAspectRatio(ar).build()
                )
            }
        }
        if (tipsDelegate.currentTip != null) pause()

        //if possible, match display with content frame rate
        val preferMatchFrameRate =
            settings.getBoolean("video_match_frame_rate", false)
        if (preferMatchFrameRate) {
            val surfaceView = rootView?.findViewById<View>(R.id.surface_video) as SurfaceView
            FrameRateManager(this, service!!).matchFrameRate(surfaceView, window)
        }
    }

    private fun encounteredError() {
        if (isFinishing || service?.hasNext() == true) return
        /* Encountered Error, exit player with a message */
        alertDialog = AlertDialog.Builder(this@VideoPlayerActivity)
            .setOnCancelListener { exit(RESULT_PLAYBACK_ERROR) }
            .setPositiveButton(R.string.ok) { _, _ -> exit(RESULT_PLAYBACK_ERROR) }
            .setTitle(R.string.encountered_error_title)
            .setMessage(R.string.encountered_error_message)
            .create().apply { show() }
    }

    private fun handleVout(voutCount: Int) {
        handler.removeCallbacks(switchAudioRunnable)

        val vlcVout = service?.vout ?: return
        if (displayManager.isPrimary && vlcVout.areViewsAttached() && voutCount == 0) {
            handler.postDelayed(switchAudioRunnable, 4000)
        }
    }

    override fun recreate() {
        handler.removeCallbacks(switchAudioRunnable)
        super.recreate()
    }

    fun switchToAudioMode(showUI: Boolean) {
        if (service == null) return
        switchingView = true
        // Show the MainActivity if it is not in background.
        if (showUI && intent.getBooleanExtra(FROM_EXTERNAL, false)) {
            val i = Intent().apply {
                setClassName(applicationContext, if (isTv) TV_AUDIOPLAYER_ACTIVITY else MOBILE_MAIN_ACTIVITY)
            }
            startActivity(i)
        }
        exitOK()
    }

    override fun isInPictureInPictureMode(): Boolean {
        return AndroidUtil.isNougatOrLater && super.isInPictureInPictureMode()
    }

    override fun setPictureInPictureParams(params: PictureInPictureParams) {
        try {
            super.setPictureInPictureParams(params)
        } catch (e: IllegalArgumentException) {
            if (BuildConfig.DEBUG) throw e
        }
    }

    override fun onPictureInPictureModeChanged(isInPictureInPictureMode: Boolean) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode)
        service?.mediaplayer?.updateVideoSurfaces()
    }

    internal fun sendMouseEvent(action: Int, x: Int, y: Int) {
        service?.vout?.sendMouseEvent(action, 0, x, y)
    }

    /**
     * show/hide the overlay
     */

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action === MotionEvent.ACTION_DOWN) {
            //kog.m("[VideoPlay] onTouchEvent ACTION_DOWN");

            /*if(_bt_exit.getVisibility() == View.VISIBLE){
                mHandlerMsg.removeMessages(IDEX_MAIN_LIST);

                _bt_exit.setVisibility(View.GONE);
            }
            else if(_bt_exit.getVisibility() == View.GONE){
                _bt_exit.setVisibility(View.VISIBLE);

                mHandlerMsg.removeMessages(IDEX_MAIN_LIST);
                mHandlerMsg.sendEmptyMessageDelayed(IDEX_MAIN_LIST, TIME_MAIN_LIST);
            }*/
        } else if (event.action === MotionEvent.ACTION_UP) {
            kog.m("[VideoPlay] onTouchEvent ACTION_UP mIsListTouch : $mIsListTouch")
            if (mIsListTouch) {
                mIsListTouch = false
                mIsRemoconControl = false
                mIsMainList = true
                val intentMsg = Intent("MSG_MAIN_LIST")
                sendBroadcast(intentMsg)
            }
        }
        return true
        //return service != null && touchDelegate.onTouchEvent(event)
    }

    internal fun updateViewpoint(yaw: Float, pitch: Float, fov: Float): Boolean {
        return service?.updateViewpoint(yaw, pitch, 0f, fov, false) ?: false
    }

    internal fun initAudioVolume() = service?.let { service ->
        if (service.volume <= 100) {
            volume = audiomanager.getStreamVolume(AudioManager.STREAM_MUSIC).toFloat()
            originalVol = audiomanager.getStreamVolume(AudioManager.STREAM_MUSIC).toFloat()
        } else {
            volume = service.volume.toFloat() * audioMax / 100
        }
    }

    //Toast that appears only once
    fun displayWarningToast() {
        warningToast?.cancel()
        warningToast = Toast.makeText(application, R.string.audio_boost_warning, Toast.LENGTH_SHORT).apply {
            setGravity(Gravity.LEFT or Gravity.BOTTOM, 16.dp, 0)
            show()
        }
    }

    internal fun setAudioVolume(volume: Int) {
        var vol = volume
        if (AndroidUtil.isNougatOrLater && (vol <= 0) xor isMute) {
            mute(!isMute)
            return  //Android N+ throws "SecurityException: Not allowed to change Do Not Disturb state"
        }

        /* Since android 4.3, the safe volume warning dialog is displayed only with the FLAG_SHOW_UI flag.
         * We don't want to always show the default UI volume, so show it only when volume is not set. */
        service?.let { service ->
            if (vol <= audioMax) {
                service.setVolume(100)
                if (vol != audiomanager.getStreamVolume(AudioManager.STREAM_MUSIC)) {
                    try {
                        audiomanager.setStreamVolume(AudioManager.STREAM_MUSIC, vol, 0)
                        // High Volume warning can block volume setting
                        if (audiomanager.getStreamVolume(AudioManager.STREAM_MUSIC) != vol)
                            audiomanager.setStreamVolume(AudioManager.STREAM_MUSIC, vol, AudioManager.FLAG_SHOW_UI)
                    } catch (ignored: RuntimeException) {
                    }
                    //Some device won't allow us to change volume
                }
                vol = (vol * 100 / audioMax.toFloat()).roundToInt()
            } else {
                vol = (vol * 100 / audioMax.toFloat()).roundToInt()
                service.setVolume(vol.toFloat().roundToInt())
            }
            overlayDelegate.showVolumeBar(vol)
            volSave = service.volume
        }
    }

    private fun mute(mute: Boolean) {
        service?.let { service ->
            isMute = mute
            if (isMute) volSave = service.volume
            service.setVolume(if (isMute) 0 else volSave)
        }
    }

    private fun updateMute() {
        mute(!isMute)
        overlayDelegate.showInfo(if (isMute) R.string.sound_off else R.string.sound_on, 1000)
    }

    internal fun changeBrightness(delta: Float) {
        // Estimate and adjust Brightness
        val lp = window.attributes
        var brightness = (lp.screenBrightness + delta).coerceIn(0.01f, 1f)
        setWindowBrightness(brightness)
        brightness = (brightness * 100).roundToInt().toFloat()
        overlayDelegate.showBrightnessBar(brightness.toInt())
    }

    private fun setWindowBrightness(brightness: Float) {
        val lp = window.attributes
        lp.screenBrightness = brightness
        // Set Brightness
        window.attributes = lp
    }

    open fun onAudioSubClick(anchor: View?) {
        overlayDelegate.showTracks()
        overlayDelegate.hideOverlay(false)
    }

    override fun onPopupMenu(view: View, position: Int, item: MediaWrapper?) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.menuInflater.inflate(R.menu.audio_player, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { curentItem ->
            if (curentItem.itemId == R.id.audio_player_mini_remove) service?.run {
                remove(position)
                return@OnMenuItemClickListener true
            }
            false
        })
        popupMenu.show()
    }

    override fun onSelectionSet(position: Int) = overlayDelegate.playlist.scrollToPosition(position)

    override fun playItem(position: Int, item: MediaWrapper) {
        service?.saveMediaMeta()
        service?.playlistManager?.getMedia(position)
        service?.playlistManager?.getMediaList()?.let {
            if (it[position] == item)  service?.playIndex(position)
            else {
                for ((index, media) in it.withIndex()) if (item == media) {
                    service?.playIndex(index)
                }
            }
        }
        overlayDelegate.togglePlaylist()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.bt_exit -> {
                kog.m("[VideoPlay] bt_exit")
                mIsRemoconControl = false
                mIsMainList = true
                val intentMsg = Intent("MSG_MAIN_LIST")
                sendBroadcast(intentMsg)
            }
            R.id.orientation_toggle -> toggleOrientation()
            R.id.playlist_toggle -> overlayDelegate.togglePlaylist()
            R.id.player_overlay_forward -> touchDelegate.seekDelta(Settings.videoJumpDelay * 1000)
            R.id.player_overlay_rewind -> touchDelegate.seekDelta(-Settings.videoJumpDelay * 1000)
            R.id.ab_repeat_add_marker -> service?.playlistManager?.setABRepeatValue(overlayDelegate.hudBinding.playerOverlaySeekbar.progress.toLong())
            R.id.ab_repeat_reset -> service?.playlistManager?.resetABRepeatValues()
            R.id.ab_repeat_stop -> service?.playlistManager?.clearABRepeat()
            R.id.player_overlay_navmenu -> showNavMenu()
            R.id.player_overlay_length, R.id.player_overlay_time -> toggleTimeDisplay()
            R.id.video_renderer -> if (supportFragmentManager.findFragmentByTag("renderers") == null)
                RenderersDialog().show(supportFragmentManager, "renderers")
            R.id.video_secondary_display -> {
                clone = displayManager.isSecondary
                recreate()
            }
            R.id.playback_speed_quick_action -> {
                val newFragment = PlaybackSpeedDialog.newInstance()
                newFragment.onDismissListener = DialogInterface.OnDismissListener { overlayDelegate.dimStatusBar(true) }
                newFragment.show(supportFragmentManager, "playback_speed")
                overlayDelegate.hideOverlay(false)
            }
            R.id.sleep_quick_action -> {
                val newFragment = SleepTimerDialog.newInstance()
                newFragment.onDismissListener = DialogInterface.OnDismissListener { overlayDelegate.dimStatusBar(true) }
                newFragment.show(supportFragmentManager, "time")
                overlayDelegate.hideOverlay(false)
            }
            R.id.audio_delay_quick_action -> {
                delayDelegate.showAudioDelaySetting()
                overlayDelegate.hideOverlay(false)
            }
            R.id.spu_delay_quick_action -> {
                delayDelegate.showSubsDelaySetting()
                overlayDelegate.hideOverlay(false)
            }
            R.id.player_screenshot -> {
                overlayDelegate.hideOverlay(false)
                takeScreenshot()
            }
        }
    }

    override fun onLongClick(v: View): Boolean {
        when (v.id) {
            R.id.player_overlay_forward -> {
                touchDelegate.seekDelta(Settings.videoLongJumpDelay * 1000)
                return true
            }
            R.id.player_overlay_rewind -> {
                touchDelegate.seekDelta(-Settings.videoLongJumpDelay * 1000)
                return true
            }
        }
        return false
    }

    fun toggleTimeDisplay() {
        sDisplayRemainingTime = !sDisplayRemainingTime
        overlayDelegate.showOverlay()
        settings.putSingle(KEY_REMAINING_TIME_DISPLAY, sDisplayRemainingTime)
    }

    fun toggleLock() {
        if (isLocked)
            overlayDelegate.unlockScreen()
        else
            overlayDelegate.lockScreen()
        overlayDelegate.updateRendererVisibility()
    }

    override fun onStorageAccessGranted() {
        handler.sendEmptyMessage(START_PLAYBACK)
    }

    fun hideOptions() {
        optionsDelegate?.hide()
    }

    private fun showNavMenu() {
        if (menuIdx >= 0) service?.titleIdx = menuIdx
    }

    fun doPlayPause() {
        if (service?.isPausable != true) return
        if (service?.isPlaying == true) {
            overlayDelegate.showOverlayTimeout(OVERLAY_INFINITE)
            pause()
        } else {
            if (Settings.videoHudDelay != -1) handler.sendEmptyMessageDelayed(FADE_OUT, 800L)
            play()
        }
    }

    fun seek(position: Long, fromUser: Boolean = false) {
        service?.let { seek(position, it.length, fromUser) }
    }

    fun seek(position: Long, fromUser: Boolean = false, fast:Boolean = false) {
        service?.let { seek(position, it.length, fromUser, fast) }
    }

    internal fun seek(position: Long, length: Long, fromUser: Boolean = false, fast:Boolean = false) {
        service?.let { service ->
            forcedTime = position
            lastTime = service.getTime()
            service.seek(position, length.toDouble(), fromUser, fast)
            service.playlistManager.player.updateProgress(position)
        }
    }

    fun resizeVideo() = resizeDelegate.resizeVideo()

    fun displayResize() = resizeDelegate.displayResize()

    private fun showTitle() {
        if (isNavMenu) return

        var visibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        var navbar = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        navbar = navbar or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION

        if (AndroidDevices.hasNavBar) visibility = visibility or navbar
        window.decorView.systemUiVisibility = visibility
    }

    private fun setESTracks() {
        if (lastAudioTrack >= "-1") {
            service?.setAudioTrack(lastAudioTrack)
            lastAudioTrack = "-2"
        }
        if (lastSpuTrack >=" -1") {
            service?.setSpuTrack(lastSpuTrack)
            lastSpuTrack = "-2"
        }
    }

    /**
     *
     */
    fun play() {
        service?.play()
        rootView?.run { keepScreenOn = true }
    }

    /**
     *
     */
    private fun pause() {
        service?.pause()
        rootView?.run { keepScreenOn = false }
    }


    /**
     * External extras:
     * - position (long) - position of the video to start with (in ms)
     * - subtitles_location (String) - location of a subtitles file to load
     * - from_start (boolean) - Whether playback should start from start or from resume point
     * - title (String) - video title, will be guessed from file if not set.
     */
    @SuppressLint("SdCardPath")
    @TargetApi(12)
    protected open fun loadMedia(fromStart: Boolean = false, forceUsingNew:Boolean = false) {
        kog.m("[VideoPlay] loadMedia");
        overlayDelegate._tv_video_err.setVisibility(View.GONE);

        if (fromStart) {
            askResume = false
            intent.putExtra(PLAY_EXTRA_FROM_START, fromStart)
        }
        service?.let { service ->
            isPlaying = false
            var title: String? = null
            var fromStart = settings.getString(KEY_VIDEO_CONFIRM_RESUME, "0") == "1"
            var itemTitle: String? = null
            var positionInPlaylist = -1
            val intent = intent
            val extras = intent.extras
            var startTime = 0L
            val currentMedia = service.currentMediaWrapper
            val hasMedia = currentMedia != null
            val isPlaying = service.isPlaying
            /*
         * If the activity has been paused by pressing the power button, then
         * pressing it again will show the lock screen.
         * But onResume will also be called, even if vlc-android is still in
         * the background.
         * To workaround this, pause playback if the lockscreen is displayed.
         */
            val km = applicationContext.getSystemService<KeyguardManager>()!!
            if (km.inKeyguardRestrictedInputMode())
                wasPaused = true
            if (wasPaused && BuildConfig.DEBUG)
                Log.d(TAG, "Video was previously paused, resuming in paused mode")
            intent.data?.let {
                val translatedPath = try {
                    FileUtils.getPathFromURI(it)
                } catch (e: IllegalStateException) {
                    ""
                }
                videoUri = if (translatedPath.isNotEmpty()) translatedPath.toUri() else it
            }
            if (extras != null) {
                if (intent.hasExtra(PLAY_EXTRA_ITEM_LOCATION)) {
                    videoUri = extras.parcelable(PLAY_EXTRA_ITEM_LOCATION)
                    intent.removeExtra(PLAY_EXTRA_ITEM_LOCATION)
                }
                fromStart = fromStart or extras.getBoolean(PLAY_EXTRA_FROM_START, false)
                // Consume fromStart option after first use to prevent
                // restarting again when playback is paused.
                intent.putExtra(PLAY_EXTRA_FROM_START, false)
                askResume = askResume and !fromStart
                startTime = if (fromStart) 0L else extras.getLong(PLAY_EXTRA_START_TIME) // position passed in by intent (ms)
                if (!fromStart && startTime == 0L) {
                    startTime = extras.getInt(PLAY_EXTRA_START_TIME).toLong()
                }
                positionInPlaylist = extras.getInt(PLAY_EXTRA_OPENED_POSITION, -1)

                subtitlesExtraPath = extras.getString(PLAY_EXTRA_SUBTITLES_LOCATION)
                if (!subtitlesExtraPath.isNullOrEmpty()) service.addSubtitleTrack(subtitlesExtraPath!!, true)
                if (intent.hasExtra(PLAY_EXTRA_ITEM_TITLE))
                    itemTitle = extras.getString(PLAY_EXTRA_ITEM_TITLE)
            }
            val restorePlayback = hasMedia && currentMedia?.uri == videoUri
            if (startTime == 0L && savedTime > 0L && restorePlayback) startTime = savedTime

            var openedMedia: MediaWrapper? = null
            val resumePlaylist = service.isValidIndex(positionInPlaylist)
            val continueplayback = isPlaying && (restorePlayback || positionInPlaylist == service.currentMediaPosition)
            if (resumePlaylist) {
                // Provided externally from AudioService
                if (BuildConfig.DEBUG) Log.v(TAG, "Continuing playback from PlaybackService at index $positionInPlaylist")
                openedMedia = service.media[positionInPlaylist]
                itemTitle = openedMedia.title
                overlayDelegate.updateSeekable(service.isSeekable)
                overlayDelegate.updatePausable(service.isPausable)
            }
            if (videoUri != null) {
                var uri = videoUri ?: return
                var media: MediaWrapper? = null
                if (!continueplayback) {
                    if (!resumePlaylist) {
                        // restore last position
                        media = medialibrary.getMedia(uri)
                        if (media == null && uri.scheme == "file" &&
                                uri.path?.startsWith("/sdcard") == true) {
                            uri = FileUtils.convertLocalUri(uri)
                            videoUri = uri
                            media = medialibrary.getMedia(uri)
                        }

                        // bslim
                        kog.m("[VideoPlay] media.setTime(media.getMetaLong(MediaWrapper.META_PROGRESS)");
                        /*if (media != null && media.getId() != 0L && media.getTime() == 0L)
                            media.setTime(media.getMetaLong(MediaWrapper.META_PROGRESS));*/
                    } else media = openedMedia
                    if (media != null) {
                        // in media library

                        lastAudioTrack = media.audioTrack.toString()
                        lastSpuTrack = media.spuTrack.toString()
                    } else if (!fromStart) {
                        // not in media library
                            val rTime = settings.getLong(VIDEO_RESUME_TIME, -1L)
                            val lastUri = settings.getString(VIDEO_RESUME_URI, "")
                            if (rTime > 0 && service.currentMediaLocation == lastUri) {
                                    settings.putSingle(VIDEO_RESUME_TIME, -1L)
                                    startTime = rTime
                            }
                    }
                }

                // Start playback & seek
                /* prepare playback */
                val medialoaded = media != null
                if (!medialoaded) media = if (hasMedia && !forceUsingNew) currentMedia else MLServiceLocator.getAbstractMediaWrapper(uri)
                itemTitle?.let { media?.title = Uri.decode(it) }
                if (wasPaused) media?.addFlags(MediaWrapper.MEDIA_PAUSED)
                if (intent.hasExtra(PLAY_DISABLE_HARDWARE)) media?.addFlags(MediaWrapper.MEDIA_NO_HWACCEL)
                media!!.removeFlags(MediaWrapper.MEDIA_FORCE_AUDIO)
                media.addFlags(MediaWrapper.MEDIA_VIDEO)
                if (fromStart) media.addFlags(MediaWrapper.MEDIA_FROM_START)

                // Set resume point
                // bslim
                /*if (!continueplayback && !fromStart) {
                    if (startTime <= 0L && media.time > 0L) startTime = media.time
                    if (startTime > 0L) service.saveStartTime(startTime)
                }*/

                if(MyConstants.g_IsLastPlay){
                    //setTimeLastPlayDB();
                    if(mStorageMode == 1)
                        mLastSetTime = PreferenceUtil.getLastPlaySaveTime_USB().toLong()
                    else if(mStorageMode == 2)
                        mLastSetTime = PreferenceUtil.getLastPlaySaveTime_SD().toLong()
                    kog.m("[VideoPlay] mLastSetTime : $mLastSetTime   mStorageMode : $mStorageMode");

                    if((MyConstants.g_VideoPlayErr == MyConstants.CHECK_VIDEO_RATE_FAIL) ||
                        (MyConstants.g_VideoPlayErr == MyConstants.CHECK_VIDEO_TRACK_FAIL)){
                        media.time = 0L;
                        service.saveStartTime(0L);
                    }
                    else{
                        media.time = mLastSetTime;
                        service.saveStartTime(mLastSetTime);
                    }
                }
                else{
                    kog.m("[VideoPlay] loadMedia setTime 0");
                    media.time = 0L;
                    service.saveStartTime(0L);
                }

                mIsLastSetTime = true;
                MyConstants.g_IsLastPlay = false;
                mErrCount = 0;

                // Handle playback
                if (resumePlaylist) {
                    if (continueplayback) {
                        if (displayManager.isPrimary) service.flush()
                        onPlaying()
                    } else service.playIndex(positionInPlaylist)
                } else service.load(media)

                // Get the title
                if (itemTitle == null && "content" != uri.scheme) title = uri.lastPathSegment
            } else if (service.hasMedia() && !displayManager.isPrimary) {
                onPlaying()
            } else {
                service.loadLastPlaylist(PLAYLIST_TYPE_VIDEO_RESUME)
            }
            if (itemTitle != null) title = itemTitle

            // bslim
            //mTitle.setText(title);
            if (title != null) showMsg(title)

            //if (overlayDelegate.isHudRightBindingInitialized()) {
            //    overlayDelegate.hudRightBinding.playerOverlayTitle.text = title
            //}

            /*if (wasPaused) {
                // XXX: Workaround to update the seekbar position
                forcedTime = startTime
                forcedTime = -1
                overlayDelegate.showOverlay(true)
            }*/
            enableSubs()

            // bslim
            //kog.m("[VideoPlay] loadMedia IDEX_SHOW_PLAY_TIME_MSG")
            mHandlerMsg.sendEmptyMessageDelayed(IDEX_SHOW_PLAY_TIME_MSG, 1500)
            //mHandlerMsg.sendEmptyMessageDelayed(IDEX_MAIN_LIST, TIME_MAIN_LIST);
            //mHandlerMsg.sendEmptyMessageDelayed(IDEX_FIRST_MUTE, TIME_FIRST_MUTE);

            val intentMsg = Intent("MSG_LIST_PLAY_START")
            sendBroadcast(intentMsg)

            /*if(MyConstants.g_VideoPlayErr == MyConstants.CHECK_VIDEO_RATE_FAIL){
                if(MyConstants.g_VideoPlayInfo.length() > 0){
                    _tv_video_err.setText(MyConstants.g_VideoPlayInfo);
                }
                else{
                    _tv_video_err.setText("프레임레이트 오류");
                }
                _tv_video_err.setVisibility(View.VISIBLE);

                return;
            }

            if(MyConstants.g_VideoPlayErr == MyConstants.CHECK_VIDEO_TRACK_FAIL){
                _tv_video_err.setText("Video Codec 파싱 오류");
                _tv_video_err.setVisibility(View.VISIBLE);
                return;
            }

            if(MyConstants.g_VideoPlayErr == MyConstants.CHECK_AUDIO_TRACK_FAIL){
                _tv_video_err.setText("Audio Codec 파싱 오류");
                _tv_video_err.setVisibility(View.VISIBLE);
                return;
            }

            if(MyConstants.g_VideoPlayInfo.length() > 0){
                _tv_video_err.setText(MyConstants.g_VideoPlayInfo);
                _tv_video_err.setVisibility(View.VISIBLE);

            }*/
        }
    }

    private fun enableSubs() {
        videoUri?.let {
            val lastPath = it.lastPathSegment ?: return
            overlayDelegate.enableSubs = (lastPath.isNotEmpty() && !lastPath.endsWith(".ts") && !lastPath.endsWith(".m2ts")
                    && !lastPath.endsWith(".TS") && !lastPath.endsWith(".M2TS"))
        }
    }

    private fun removeDownloadedSubtitlesObserver() {
        downloadedSubtitleLiveData?.removeObserver(downloadedSubtitleObserver)
        downloadedSubtitleLiveData = null
    }

    private fun observeDownloadedSubtitles() {
        service?.let { service ->
            val uri = service.currentMediaWrapper?.uri ?: return
            val path = uri.path ?: return
            if (previousMediaPath == null || path != previousMediaPath) {
                previousMediaPath = path
                removeDownloadedSubtitlesObserver()
                downloadedSubtitleLiveData = ExternalSubRepository.getInstance(this).getDownloadedSubtitles(uri).apply {
                    observe(this@VideoPlayerActivity, downloadedSubtitleObserver)
                }
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    fun getScreenOrientation(mode: PlayerOrientationMode): Int {
        return if (!mode.locked) {
            if (AndroidUtil.isJellyBeanMR2OrLater)
                ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR
            else
                ActivityInfo.SCREEN_ORIENTATION_SENSOR
        } else {
            mode.orientation
        }
    }

    private fun getOrientationForLock(): Int {
        val wm = applicationContext.getSystemService<WindowManager>()!!
        val display = wm.defaultDisplay
        val rot = screenRotation
        /*
         * Since getRotation() returns the screen's "natural" orientation,
         * which is not guaranteed to be SCREEN_ORIENTATION_PORTRAIT,
         * we have to invert the SCREEN_ORIENTATION value if it is "naturally"
         * landscape.
         */
        var defaultWide = display.width > display.height
        if (rot == Surface.ROTATION_90 || rot == Surface.ROTATION_270)
            defaultWide = !defaultWide
        return if (defaultWide) {
            when (rot) {
                Surface.ROTATION_0 -> ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
                Surface.ROTATION_90 -> ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT
                Surface.ROTATION_180 -> ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
                Surface.ROTATION_270 -> ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT
                else -> 0
            }
        } else {
            when (rot) {
                Surface.ROTATION_0 -> ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT
                Surface.ROTATION_90 -> ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
                Surface.ROTATION_180 -> ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT
                Surface.ROTATION_270 -> ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
                else -> 0
            }
        }
    }

    private fun showConfirmResumeDialog(confirmation: WaitConfirmation) {
        if (isFinishing) return
        if (isInPictureInPictureMode) {
            lifecycleScope.launch { service?.playlistManager?.playIndex(confirmation.index, confirmation.flags, forceResume = true) }
            return
        }
        service?.pause()
        val inflater = this.layoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_video_resume, null)
        val resumeAllCheck = dialogView.findViewById<CheckBox>(R.id.video_resume_checkbox)
        alertDialog = AlertDialog.Builder(this@VideoPlayerActivity)
                .setTitle(confirmation.title)
                .setView(dialogView)
                .setPositiveButton(R.string.resume) { _, _ ->
                    if (resumeAllCheck.isChecked) service?.playlistManager?.videoResumeStatus = VideoResumeStatus.ALWAYS
                    lifecycleScope.launch { service?.playlistManager?.playIndex(confirmation.index, confirmation.flags, forceResume = true) }
                }
                .setNegativeButton(R.string.no) { _, _ ->
                    if (resumeAllCheck.isChecked) service?.playlistManager?.videoResumeStatus = VideoResumeStatus.NEVER
                    lifecycleScope.launch { service?.playlistManager?.playIndex(confirmation.index, confirmation.flags, forceRestart = true) }
                }
                .create().apply {
                    setCancelable(false)
                    setOnKeyListener { dialog, keyCode, _ ->
                        if (keyCode == KeyEvent.KEYCODE_BACK) {
                            dialog.dismiss()
                            finish()
                            true
                        } else false
                    }
                    show()
                }
    }

    fun toggleOrientation() {
        orientationMode.locked = !orientationMode.locked
        orientationMode.orientation = getOrientationForLock()

        requestedOrientation = getScreenOrientation(orientationMode)
        if (orientationMode.locked) settings.putSingle(LAST_LOCK_ORIENTATION, requestedOrientation)
        overlayDelegate.updateOrientationIcon()
    }

    private fun toggleBtDelay(connected: Boolean) {
        service?.setAudioDelay(if (connected) settings.getLong(KEY_BLUETOOTH_DELAY, 0) else 0L)
    }

    /**
     * Start the video loading animation.
     */
    private fun startLoading() {
        if (isLoading) return
        isLoading = true
        val anim = AnimationSet(true)
        val rotate = RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        rotate.duration = 800
        rotate.interpolator = DecelerateInterpolator()
        rotate.repeatCount = RotateAnimation.INFINITE
        anim.addAnimation(rotate)
        loadingImageView.setVisible()
        loadingImageView?.startAnimation(anim)
    }

    /**
     * Stop the video loading animation.
     */
    private fun stopLoading() {
        handler.removeMessages(LOADING_ANIMATION)
        if (!isLoading) return
        isLoading = false
        loadingImageView.setInvisible()
        loadingImageView?.clearAnimation()
    }

    fun onClickDismissTips(@Suppress("UNUSED_PARAMETER") v: View) {
        tipsDelegate.close()
    }

    fun onClickNextTips(@Suppress("UNUSED_PARAMETER") v: View?) {
        tipsDelegate.next()
    }

    fun updateNavStatus() {
        /*if (service == null) return
        menuIdx = -1
        lifecycleScope.launchWhenStarted {
            val titles = withContext(Dispatchers.IO) { service?.titles }
            if (isFinishing) return@launchWhenStarted
            isNavMenu = false
            if (titles != null) {
                val currentIdx = service?.titleIdx ?: return@launchWhenStarted
                for (i in titles.indices) {
                    val title = titles[i]
                    if (title.isMenu) {
                        menuIdx = i
                        break
                    }
                }
                val interactive = service?.mediaplayer?.let {
                    try {
                        (it.titles[it.title])?.isInteractive ?: false
                    } catch (e: NullPointerException) {
                        false
                    }
                } ?: false
                isNavMenu = menuIdx == currentIdx || interactive
            }

            if (isNavMenu) {
                /*
                         * Keep the overlay hidden in order to have touch events directly
                         * transmitted to navigation handling.
                         */
                overlayDelegate.hideOverlay(false)
            } else if (menuIdx != -1) setESTracks()

            if (overlayDelegate.isHudRightBindingInitialized()) overlayDelegate.hudRightBinding.playerOverlayNavmenu.setVisibility(if (menuIdx >= 0) View.VISIBLE else View.GONE)
            supportInvalidateOptionsMenu()
        }*/
    }

    open fun onServiceChanged(service: PlaybackService?) {
        if (service != null) {
            this.service = service
            if (savedMediaList != null && service.currentMediaWrapper == null) {
                service.append(savedMediaList!!, savedMediaIndex)
                savedMediaList = null
            }
            //We may not have the permission to access files
            if (!switchingView)
                handler.sendEmptyMessage(START_PLAYBACK)
            switchingView = false
            handler.post {
                // delay mediaplayer loading, prevent ANR
                if (service.volume > 100 && !isAudioBoostEnabled) service.setVolume(100)
                if (volSave > 100 && service.volume != volSave) service.setVolume(volSave)
            }
            service.addCallback(this)
            service.playlistManager.waitForConfirmation.observe(this) {
                if (it != null) showConfirmResumeDialog(it)
            }
            //if (isTalkbackIsEnabled()) overlayDelegate.showOverlayTimeout(OVERLAY_INFINITE)
        } else if (this.service != null) {
            this.service?.removeCallback(this)
            this.service = null
            handler.sendEmptyMessage(AUDIO_SERVICE_CONNECTION_FAILED)
            removeDownloadedSubtitlesObserver()
            previousMediaPath = null
        }
    }

    /**
     * Callback called when a Control setting has been changed in the advanced options
     */
    fun onChangedControlSetting(key: String) = when(key) {
        AUDIO_BOOST -> isAudioBoostEnabled = settings.getBoolean(AUDIO_BOOST, true)
        ENABLE_VOLUME_GESTURE, ENABLE_BRIGHTNESS_GESTURE, ENABLE_DOUBLE_TAP_SEEK, ENABLE_DOUBLE_TAP_PLAY, ENABLE_SWIPE_SEEK, ENABLE_SCALE_GESTURE -> touchDelegate.touchControls = generateTouchFlags()
        SCREENSHOT_MODE -> {
            touchDelegate.touchControls = generateTouchFlags()
            overlayDelegate.updateScreenshotButton()
        }
        ENABLE_SEEK_BUTTONS -> overlayDelegate.seekButtons = settings.getBoolean(ENABLE_SEEK_BUTTONS, false)
        else -> {}
    }

    companion object {

        private const val TAG = "VLC/VideoPlayerActivity"

        private val ACTION_RESULT = "player.result".buildPkgString()
        private const val EXTRA_POSITION = "extra_position"
        private const val EXTRA_DURATION = "extra_duration"
        private const val EXTRA_URI = "extra_uri"
        const val FROM_EXTERNAL = "from_external"
        private const val RESULT_CONNECTION_FAILED = Activity.RESULT_FIRST_USER + 1
        private const val RESULT_PLAYBACK_ERROR = Activity.RESULT_FIRST_USER + 2
        private const val RESULT_VIDEO_TRACK_LOST = Activity.RESULT_FIRST_USER + 3
        internal const val DEFAULT_FOV = 80f
        private const val KEY_TIME = "saved_time"
        private const val KEY_LIST = "saved_list"
        private const val KEY_MEDIA_LIST = "media_list"
        private const val KEY_MEDIA_INDEX = "media_index"
        private const val KEY_URI = "saved_uri"
        const val OVERLAY_INFINITE = -1
        const val FADE_OUT = 1
        const val FADE_OUT_INFO = 2
        private const val START_PLAYBACK = 3
        private const val AUDIO_SERVICE_CONNECTION_FAILED = 4
        private const val RESET_BACK_LOCK = 5
        private const val CHECK_VIDEO_TRACKS = 6
        private const val LOADING_ANIMATION = 7
        internal const val SHOW_INFO = 8
        internal const val HIDE_INFO = 9
        internal const val HIDE_SEEK = 10
        internal const val HIDE_SETTINGS = 11
        const val FADE_OUT_BRIGHTNESS_INFO = 12
        const val FADE_OUT_VOLUME_INFO = 13
        const val FADE_OUT_SCREENSHOT = 14
        private const val KEY_REMAINING_TIME_DISPLAY = "remaining_time_display"
        const val KEY_BLUETOOTH_DELAY = "key_bluetooth_delay"

        private const val LOADING_ANIMATION_DELAY = 1000

        @Volatile
        internal var sDisplayRemainingTime: Boolean = false

        private var clone: Boolean? = null

        fun start(context: Context, uri: Uri) {
            start(context, uri, null, false, -1)
        }

        fun start(context: Context, uri: Uri, fromStart: Boolean) {
            start(context, uri, null, fromStart, -1)
        }

        fun start(context: Context, uri: Uri, title: String) {
            start(context, uri, title, false, -1)
        }

        fun startOpened(context: Context, uri: Uri, openedPosition: Int) {
            start(context, uri, null, false, openedPosition)
        }

        private fun start(context: Context, uri: Uri, title: String?, fromStart: Boolean, openedPosition: Int) {
            val intent = getIntent(context, uri, title, fromStart, openedPosition)
            context.startActivity(intent)
        }

        fun getIntent(action: String, mw: MediaWrapper, fromStart: Boolean, openedPosition: Int): Intent {
            return getIntent(action, AppContextProvider.appContext, mw.uri, mw.title, fromStart, openedPosition)
        }

        fun getIntent(context: Context, uri: Uri, title: String?, fromStart: Boolean, openedPosition: Int): Intent {
            return getIntent(PLAY_FROM_VIDEOGRID, context, uri, title, fromStart, openedPosition)
        }

        fun getIntent(action: String, context: Context, uri: Uri, title: String?, fromStart: Boolean, openedPosition: Int): Intent {
            val intent = Intent(context, VideoPlayerActivity::class.java)
            intent.action = action
            intent.putExtra(PLAY_EXTRA_ITEM_LOCATION, uri)
            intent.putExtra(PLAY_EXTRA_ITEM_TITLE, title)
            intent.putExtra(PLAY_EXTRA_FROM_START, fromStart)

            if (openedPosition != -1 || context !is Activity) {
                if (openedPosition != -1)
                    intent.putExtra(PLAY_EXTRA_OPENED_POSITION, openedPosition)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            return intent
        }
    }

    private fun onRemoconMode(key: Byte)
    {
        when(key) {
            DefineRemocon.vol_down -> {
                //volumeDown()
                return
            }
            DefineRemocon.vol_up -> {
                //volumeUp()
                return
            }
            DefineRemocon.mute -> {
                //updateMute()
                return
            }
            DefineRemocon.left -> {
                if(mIsTimeSelect){
                    mTimeSelMode --

                    if(mTimeSelMode < 0){
                        mTimeSelMode = 5
                    }
                    setSelTimeBg()
                }
                else
                    changeSpeed(-0.01f)
            }
            DefineRemocon.right -> {
                if(mIsTimeSelect){
                    mTimeSelMode ++

                    if(mTimeSelMode > 5){
                        mTimeSelMode = 0
                    }
                    setSelTimeBg()
                }
                else
                    changeSpeed(0.01f)
            }
            DefineRemocon.up -> {
                if(mIsTimeSelect){
                    setSelTimeNum(true)
                }
            }
            DefineRemocon.down -> {
                if(mIsTimeSelect){
                    setSelTimeNum(false)
                }
            }
            DefineRemocon.num_0 -> {
                setSelTimeNumKey(0)
            }
            DefineRemocon.num_1 -> {
                setSelTimeNumKey(1)
            }
            DefineRemocon.num_2 -> {
                setSelTimeNumKey(2)
            }
            DefineRemocon.num_3 -> {
                setSelTimeNumKey(3)
            }
            DefineRemocon.num_4 -> {
                setSelTimeNumKey(4)
            }
            DefineRemocon.num_5 -> {
                setSelTimeNumKey(5)
            }
            DefineRemocon.num_6 -> {
                setSelTimeNumKey(6)
            }
            DefineRemocon.num_7 -> {
                setSelTimeNumKey(7)
            }
            DefineRemocon.num_8 -> {
                setSelTimeNumKey(8)
            }
            DefineRemocon.num_9 -> {
                setSelTimeNumKey(9)
            }
            DefineRemocon.next -> {
                //PreferenceUtil.saveModeVideoRepeat(MyConstants.REPEAT_ALL)
                PreferenceUtil.saveModeVideoRepeat(MyConstants.REPEAT_FOLDER)
                onPlayNext()
                exitOK()
            }
            DefineRemocon.back -> {
                //PreferenceUtil.saveModeVideoRepeat(MyConstants.REPEAT_ALL)
                PreferenceUtil.saveModeVideoRepeat(MyConstants.REPEAT_FOLDER)
                onPlayPrev()
                exitOK()
            }
            DefineRemocon.play -> {
                if (mPlayRate != 1f) {
                    mPlayRate = 1f
                    MyConstants.g_VideoPlayRate = mPlayRate
                    service?.setRate(mPlayRate, false)
                    val msg = getString(R.string.playback_speed) + " : " + String.format(
                        "%.2f",
                        mPlayRate
                    )
                    showChangeSpeedMsg(msg)
                } else {
                    if (service?.isPlaying == false) {
                        play()
                        mStopCnt = 0
                    }
                }
            }
            DefineRemocon.pause -> {
                if(service?.isPlaying == true){
                    pause()
                }
            }
            DefineRemocon.dvd -> {
                if(!mIsMainList){
                    if(mRemoconDvdMode != 0){
                        kog.m("[VideoPlay] Remocon dvd : " + mRemoconDvdMode)

                        if(service != null){
                            if(service?.isPlaying == true){
                                pause()
                            }
                        }

                        mRemoconDvdMode = 1
                    }
                }
            }
            DefineRemocon.usb -> {
                if(!mIsMainList){
                    if(mRemoconDvdMode == 1){
                        kog.m("[VideoPlay] Remocon dvd -> usb : " + mRemoconDvdMode)

                        if(mStopCnt == 0){
                            if(service != null){
                                if(service?.isPlaying == false){
                                    play()
                                }
                            }
                        }

                        mRemoconDvdMode = -1
                    }
                }
            }
            DefineRemocon.fast_backward -> {
                touchDelegate.seekDelta(-60000)
            }
            DefineRemocon.fast_forward -> {
                touchDelegate.seekDelta(60000)
            }
            DefineRemocon.slow_backward -> {
                touchDelegate.seekDelta(-10000)
            }
            DefineRemocon.slow_forward -> {
                touchDelegate.seekDelta(10000)
            }
            DefineRemocon.stop -> {
                if(mStopCnt == 0){
                    if (service?.isPlaying == true){
                        //mService.pause()
                        mStopCnt ++

                        mStopMode = 11
                        exitOK()
                    }
                    else{
                        mStopMode = 0
                        //PreferenceUtil.saveModeVideoRepeat(MyConstants.REPEAT_ALL)
                        PreferenceUtil.saveModeVideoRepeat(MyConstants.REPEAT_FOLDER)
                        exitOK()
                    }
                }
                else{
                    mStopMode = 0
                    exitOK()
                }
            }
            DefineRemocon.repeat -> {
                setRepeatMode()
            }
            DefineRemocon.display -> {
                showMsg(Tools.millisToString(service?.getTime()!!) + " / " + Tools.millisToString(service?.length!!))
            }
            DefineRemocon.go_to -> {
                if(!mIsTimeSelect){
                    showTimeSelect(true)
                }
                else{
                    showTimeSelect(false)
                }
            }
            DefineRemocon.enter -> {
                if(mIsTimeSelect){
                    setPlayTime()
                }
            }
            DefineRemocon.zoom -> {
                mScaleType ++

                if(mScaleType > MediaPlayer.ScaleType.SURFACE_ORIGINAL.ordinal){
                    mScaleType = MediaPlayer.ScaleType.SURFACE_FILL.ordinal
                }

                kog.m("[VideoPlay] Remocon zoom mCurrentSize : " + mScaleType)

                if(mScaleType == MediaPlayer.ScaleType.SURFACE_FILL.ordinal){
                    resizeDelegate.setVideoScale(MediaPlayer.ScaleType.SURFACE_FILL)
                }
                else if(mScaleType == MediaPlayer.ScaleType.SURFACE_16_9.ordinal){
                    resizeDelegate.setVideoScale(MediaPlayer.ScaleType.SURFACE_16_9)
                }
                else if(mScaleType == MediaPlayer.ScaleType.SURFACE_4_3.ordinal){
                    resizeDelegate.setVideoScale(MediaPlayer.ScaleType.SURFACE_4_3)
                }
                else if(mScaleType == MediaPlayer.ScaleType.SURFACE_ORIGINAL.ordinal){
                    resizeDelegate.setVideoScale(MediaPlayer.ScaleType.SURFACE_ORIGINAL)
                }
            }
            DefineRemocon.list -> {
                /*mStopMode = 10
                exitOK()*/

                /*mStopMode = 10
                exitOK()*/kog.m("[VideoPlay] Remocon MSG_MAIN_LIST mIsListTouch : $mIsListTouch")
                if (mIsListTouch) {
                    mIsListTouch = false
                    mIsRemoconControl = false
                    mIsMainList = true
                    val intentMsg = Intent("MSG_MAIN_LIST")
                    sendBroadcast(intentMsg)
                }
            }
        }
    }

    private fun setPlayTime() {
        val hour = mTimeSelHour1 * 10 + mTimeSelHour2
        val min = mTimeSelMin1 * 10 + mTimeSelMin2
        val sec = mTimeSelSec1 * 10 + mTimeSelSec2
        val time = ((hour * 3600 + min * 60 + sec) * 1000).toLong()
        kog.m("[VideoPlay] setPlayTime time : " + time + "   total time : " + service?.length)
        if (time < service?.length!!) {
            seek(time)
        }
        showTimeSelect(false)
    }

    private fun setSelTimeNumKey(num: Int) {
        mHandlerMsg.removeMessages(IDEX_SHOW_TIME_SELECT)
        if (mTimeSelMode == 0) {
            mTimeSelHour1 = num
        } else if (mTimeSelMode == 1) {
            mTimeSelHour2 = num
        } else if (mTimeSelMode == 2) {
            mTimeSelMin1 = num
        } else if (mTimeSelMode == 3) {
            mTimeSelMin2 = num
        } else if (mTimeSelMode == 4) {
            mTimeSelSec1 = num
        } else if (mTimeSelMode == 5) {
            mTimeSelSec2 = num
        }
        overlayDelegate._tv_time_hour_1!!.text = String.format("%d", mTimeSelHour1)
        overlayDelegate._tv_time_hour_2!!.text = String.format("%d", mTimeSelHour2)
        overlayDelegate._tv_time_min_1!!.text = String.format("%d", mTimeSelMin1)
        overlayDelegate._tv_time_min_2!!.text = String.format("%d", mTimeSelMin2)
        overlayDelegate._tv_time_sec_1!!.text = String.format("%d", mTimeSelSec1)
        overlayDelegate._tv_time_sec_2!!.text = String.format("%d", mTimeSelSec2)
    }

    private fun setSelTimeNum(isUp: Boolean) {
        mHandlerMsg.removeMessages(IDEX_SHOW_TIME_SELECT)
        if (mTimeSelMode == 0) {
            if (isUp) {
                mTimeSelHour1++
                if (mTimeSelHour1 > 9) mTimeSelHour1 = 0
            } else {
                mTimeSelHour1--
                if (mTimeSelHour1 < 0) mTimeSelHour1 = 9
            }
        } else if (mTimeSelMode == 1) {
            if (isUp) {
                mTimeSelHour2++
                if (mTimeSelHour2 > 9) mTimeSelHour2 = 0
            } else {
                mTimeSelHour2--
                if (mTimeSelHour2 < 0) mTimeSelHour2 = 9
            }
        } else if (mTimeSelMode == 2) {
            if (isUp) {
                mTimeSelMin1++
                if (mTimeSelMin1 > 9) mTimeSelMin1 = 0
            } else {
                mTimeSelMin1--
                if (mTimeSelMin1 < 0) mTimeSelMin1 = 9
            }
        } else if (mTimeSelMode == 3) {
            if (isUp) {
                mTimeSelMin2++
                if (mTimeSelMin2 > 9) mTimeSelMin2 = 0
            } else {
                mTimeSelMin2--
                if (mTimeSelMin2 < 0) mTimeSelMin2 = 9
            }
        } else if (mTimeSelMode == 4) {
            if (isUp) {
                mTimeSelSec1++
                if (mTimeSelSec1 > 9) mTimeSelSec1 = 0
            } else {
                mTimeSelSec1--
                if (mTimeSelSec1 < 0) mTimeSelSec1 = 9
            }
        } else if (mTimeSelMode == 5) {
            if (isUp) {
                mTimeSelSec2++
                if (mTimeSelSec2 > 9) mTimeSelSec2 = 0
            } else {
                mTimeSelSec2--
                if (mTimeSelSec2 < 0) mTimeSelSec2 = 9
            }
        }
        overlayDelegate._tv_time_hour_1!!.text = String.format("%d", mTimeSelHour1)
        overlayDelegate._tv_time_hour_2!!.text = String.format("%d", mTimeSelHour2)
        overlayDelegate._tv_time_min_1!!.text = String.format("%d", mTimeSelMin1)
        overlayDelegate._tv_time_min_2!!.text = String.format("%d", mTimeSelMin2)
        overlayDelegate._tv_time_sec_1!!.text = String.format("%d", mTimeSelSec1)
        overlayDelegate._tv_time_sec_2!!.text = String.format("%d", mTimeSelSec2)
    }

    private fun setSelTimeBg() {
        mHandlerMsg.removeMessages(IDEX_SHOW_TIME_SELECT)
        overlayDelegate._tv_time_hour_1!!.setBackgroundResource(R.drawable.time_nor)
        overlayDelegate._tv_time_hour_2!!.setBackgroundResource(R.drawable.time_nor)
        overlayDelegate._tv_time_min_1!!.setBackgroundResource(R.drawable.time_nor)
        overlayDelegate._tv_time_min_2!!.setBackgroundResource(R.drawable.time_nor)
        overlayDelegate._tv_time_sec_1!!.setBackgroundResource(R.drawable.time_nor)
        overlayDelegate._tv_time_sec_2!!.setBackgroundResource(R.drawable.time_nor)
        if (mTimeSelMode == 0) overlayDelegate._tv_time_hour_1!!.setBackgroundResource(R.drawable.time_select) else if (mTimeSelMode == 1) overlayDelegate._tv_time_hour_2!!.setBackgroundResource(
            R.drawable.time_select
        ) else if (mTimeSelMode == 2) overlayDelegate._tv_time_min_1!!.setBackgroundResource(R.drawable.time_select) else if (mTimeSelMode == 3) overlayDelegate._tv_time_min_2!!.setBackgroundResource(
            R.drawable.time_select
        ) else if (mTimeSelMode == 4) overlayDelegate._tv_time_sec_1!!.setBackgroundResource(R.drawable.time_select) else if (mTimeSelMode == 5) overlayDelegate._tv_time_sec_2!!.setBackgroundResource(
            R.drawable.time_select
        )
    }

    fun showMsg(msg: String) {
        overlayDelegate.showMsg(msg)

        mHandlerMsg.removeMessages(IDEX_SHOW_MSG)
        mHandlerMsg.sendEmptyMessageDelayed(IDEX_SHOW_MSG, TIME_SHOW_MSG.toLong())
    }

    private fun showChangeSpeedMsg(msg: String) {
        overlayDelegate.showChangeSpeedMsg(msg)

        mHandlerMsg.removeMessages(IDEX_SHOW_CHANGE_SPEED_MSG)
        mHandlerMsg.sendEmptyMessageDelayed(
            IDEX_SHOW_CHANGE_SPEED_MSG,
            TIME_SHOW_CHANGE_SPEED_MSG.toLong()
        )
    }

    private fun showTimeSelect(isShow: Boolean) {
        if (isShow) {
            overlayDelegate.showTimeSelect(isShow)

            mIsTimeSelect = true
            mHandlerMsg.removeMessages(IDEX_SHOW_TIME_SELECT)
            mHandlerMsg.sendEmptyMessageDelayed(
                IDEX_SHOW_TIME_SELECT,
                TIME_SHOW_TIME_SELECT.toLong()
            )
        } else {
            overlayDelegate.showTimeSelect(isShow)

            mHandlerMsg.removeMessages(IDEX_SHOW_TIME_SELECT)
            mIsTimeSelect = false
        }
    }

    @SuppressLint("HandlerLeak")
    private val mHandlerMsg: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            if (msg.what === IDEX_SHOW_MSG) {
                this.removeMessages(IDEX_SHOW_MSG)
                overlayDelegate.mVideoInfo.setVisibility(View.GONE)
                //overlayDelegate._tv_video_err.setVisibility(View.GONE)
            } else if (msg.what === IDEX_SHOW_CHANGE_SPEED_MSG) {
                this.removeMessages(IDEX_SHOW_CHANGE_SPEED_MSG)
                overlayDelegate._tv_video_rate.setVisibility(View.GONE)
                mIsChangeSpeed = false
            } else if (msg.what === IDEX_SHOW_TIME_SELECT) {
                this.removeMessages(IDEX_SHOW_TIME_SELECT)
                overlayDelegate._rl_time_select.setVisibility(View.GONE)
                overlayDelegate.mVideoInfo.setVisibility(View.GONE)
                //overlayDelegate._tv_video_err.setVisibility(View.GONE)
                mIsTimeSelect = false
            } else if (msg.what === IDEX_SHOW_PLAY_TIME_MSG) {
                this.removeMessages(IDEX_SHOW_PLAY_TIME_MSG)
                mIsRemoconControl = true

                if (mIsLastSetTime) {
                    //kog.m("[VideoPlay] IDEX_SHOW_PLAY_TIME_MSG mIsLastSetTime : " + mIsLastSetTime)

                    if (service != null) {
                        val playTime = service!!.getTime().toInt()
                        //kog.m("[VideoPlay] IDEX_SHOW_PLAY_TIME_MSG playTime : $playTime")
                        if (playTime > 0) {
                            mIsListTouch = true
                            mErrCount = 0
                            overlayDelegate._tv_video_err.setVisibility(View.GONE)
                            if (mStorageMode == 1)
                                PreferenceUtil.saveLastPlaySaveTime_USB(playTime) else if (mStorageMode == 2) PreferenceUtil.saveLastPlaySaveTime_SD(playTime)
                        } else {
                            mErrCount++
                            kog.m("[VideoPlay] IDEX_SHOW_PLAY_TIME_MSG mErrCount : $mErrCount")
                            if (mErrCount == 18) {
                                overlayDelegate._tv_video_err!!.text = "파일에 문제가 있어 재생 할 수 없습니다."
                                overlayDelegate._tv_video_err.setVisibility(View.VISIBLE)
                            }
                            if (mErrCount > 19) {
                                exitOK()
                            }
                        }
                    } else {
                        kog.m("[VideoPlay] IDEX_SHOW_PLAY_TIME_MSG mService null")
                    }
                }
                sendEmptyMessageDelayed(
                    IDEX_SHOW_PLAY_TIME_MSG,
                    TIME_SHOW_PLAY_TIME_MSG.toLong()
                )
            } else if (msg.what === IDEX_FIRST_MUTE) {
                this.removeMessages(IDEX_FIRST_MUTE)
                if (!mIsMute) {
                    if (audiomanager != null) {
                        Log.d("VOLUME", "IDEX_FIRST_MUTE")
                        audiomanager.setStreamMute(AudioManager.STREAM_MUSIC, false)
                        audiomanager.setStreamVolume(
                            AudioManager.STREAM_MUSIC,
                            mCurrVol,
                            AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE
                        )
                    }
                }
            } else if (msg.what === IDEX_MAIN_LIST) {
                this.removeMessages(IDEX_MAIN_LIST)
                mIsListTouch = true

                //_bt_exit.setVisibility(View.GONE)
            }
        }
    }

    private fun showMute() {
        Log.d("VOLUME", "showMute $mIsMute")
        if (mIsMute) {
            audiomanager.setStreamMute(AudioManager.STREAM_MUSIC, true)
            //mAudioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_MUTE, 0)
            showMsg("Mute")
        } else {
            audiomanager.setStreamMute(AudioManager.STREAM_MUSIC, false)
            //mAudioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_UNMUTE, 0)
            showMsg("UnMute")
        }
    }

    private fun showCurrVol() {
        Log.d("VOLUME", "showCurrVol $mIsMute $mCurrVol")
        if (mIsMute) {
            mIsMute = false
            audiomanager.setStreamMute(AudioManager.STREAM_MUSIC, false)
        }
        audiomanager.setStreamVolume(
            AudioManager.STREAM_MUSIC,
            mCurrVol,
            AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE
        )
        PreferenceUtil.saveMainVol(mCurrVol)
        val msg = "Volume : $mCurrVol"
        showMsg(msg)
        //Function.toast(this, msg)
    }

    // edit by ssh 20200812
    private fun showCurrVolOnly() {
        mIsMute = audiomanager.isStreamMute(AudioManager.STREAM_MUSIC)
        mCurrVol = audiomanager.getStreamVolume(AudioManager.STREAM_MUSIC)
        PreferenceUtil.saveMainVol(mCurrVol)

        //String msg =  "Volume : " + String.valueOf(mCurrVol)
        //showMsg(msg)
        //Function.toast(this, msg)
    }

    private fun setRepeatMode() {
        /*if(mRepeatMode == MyConstants.REPEAT_ONE){
            mRepeatMode = MyConstants.REPEAT_ALL
            mStopMode = 2
            showMsg("전체 반복")
        }
        else if(mRepeatMode == MyConstants.REPEAT_ALL){
            mRepeatMode = MyConstants.REPEAT_FOLDER
            mStopMode = 2
            showMsg("폴더 반복")
        }
        else if(mRepeatMode == MyConstants.REPEAT_FOLDER){
            mRepeatMode = MyConstants.REPEAT_ONE
            mStopMode = 3
            showMsg("한동영상 반복")
        }*/
        if (mRepeatMode == MyConstants.REPEAT_ONE) {
            mRepeatMode = MyConstants.REPEAT_FOLDER
            mStopMode = 2
            showMsg("폴더 반복")
        } else if (mRepeatMode == MyConstants.REPEAT_FOLDER) {
            mRepeatMode = MyConstants.REPEAT_ONE
            mStopMode = 3
            showMsg("한동영상 반복")
        }
        kog.m("[VideoPlay] setRepeatMode : $mRepeatMode")
        PreferenceUtil.saveModeVideoRepeat(mRepeatMode)
    }

    private fun onPlayNext() {
        mStopMode = 2
        /*Intent intent = new Intent("MSG_VIDEO_PLAY_NEXT")
 		sendBroadcast(intent)
 		exitOK()*/
    }

    private fun onPlayPrev() {
        mStopMode = 1
        /*Intent intent = new Intent("MSG_VIDEO_PLAY_PREV")
 		sendBroadcast(intent)
 		exitOK()*/
    }

    private fun changeSpeed(delta: Float) {
        mIsChangeSpeed = true
        mPlayRate = Math.round((service?.rate!! + delta) * 100f) / 100f
        if (mPlayRate < 0.7f || mPlayRate > 1.3f) return
        service?.setRate(mPlayRate, false)
        MyConstants.g_VideoPlayRate = mPlayRate
        val msg = getString(R.string.playback_speed) + " : " + String.format("%.2f", mPlayRate)
        showChangeSpeedMsg(msg)

        /*try {
             Thread.sleep(100)
         } catch (InterruptedException e) {
             e.printStackTrace()
         }*/
    }
}

data class PlayerOrientationMode(
        var locked: Boolean = false,
        var orientation: Int = 0
)

@BindingAdapter("length", "time")
fun setPlaybackTime(view: TextView, length: Long, time: Long) {
    view.text = if (VideoPlayerActivity.sDisplayRemainingTime && length > 0)
        "-" + '\u00A0'.toString() + Tools.millisToString(length - time)
    else
        Tools.millisToString(length)
}

@BindingAdapter("constraintPercent")
fun setConstraintPercent(view: Guideline, percent: Float) {
    val constraintLayout = view.parent as ConstraintLayout
    val constraintSet = ConstraintSet()
    constraintSet.clone(constraintLayout)
    constraintSet.setGuidelinePercent(view.id, percent)
    constraintSet.applyTo(constraintLayout)
}

@BindingAdapter("mediamax")
fun setProgressMax(view: SeekBar, length: Long) {
    view.max =  if (length == 0L) NO_LENGTH_PROGRESS_MAX else length.toInt()
}
