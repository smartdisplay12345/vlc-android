package org.videolan.vlc;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.videolan.libvlc.LibVLC;
import org.videolan.libvlc.Media;
import org.videolan.libvlc.util.VLCUtil;
import org.videolan.vlc.common.MyConstants;
import org.videolan.vlc.common.DefineRemocon;
import org.videolan.vlc.common.Function;
import org.videolan.vlc.common.kog;
import org.videolan.vlc.gui.audio.AudioPlayerActivity;
import org.videolan.vlc.gui.preferences.PreferencesActivity;
import org.videolan.vlc.gui.video.VideoPlayerActivity;
import org.videolan.vlc.items.FileItem;
import org.videolan.vlc.items.PlayListItem;
import org.videolan.vlc.media.MediaUtils;
import org.videolan.vlc.util.*;
import org.videolan.vlc.util.VLCInstanceJava;
import org.videolan.resources.Constants;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.AudioManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;


public class ExplorerActivity extends Activity implements OnClickListener {
    private final static String ACTION_MOUNT_USB = "org.videolan.vlc.mount.usb";
    private final static String ACTION_MOUNT_SD = "org.videolan.vlc.mount.sd";

    private int USE_VIDEO_COUNT = 0;
    private Boolean USE_VIDEO = false;

    private final String NO_USB = "USB가 없습니다.";
    private final String NO_SD_CARD = "SD Card가 없습니다.";

    private static final int IDEX_VIDEO_PLAY_CHECK = 1, TIME_VIDEO_PLAY_CHECK = 5000;
    private static final int IDEX_MOUNT_CHECK = 2, TIME_MOUNT_CHECK = 1000;
    private static final int IDEX_LAST_PLAY = 3, TIME_LAST_PLAY = 500;
    private static final int IDEX_VIDEO_PLAY_MODE = 4, TIME_VIDEO_PLAY_MODE = 2000;
    private static final int IDEX_PLAY_LIST_MODE = 5, TIME_PLAY_LIST_MODE = 2000;
    private static final int IDEX_REMOCON_ENABLE = 6, TIME_REMOCON_ENABLE = 1500;
    private static final int IDEX_LIST_PLAY = 7, TIME_LIST_PLAY = 1500;
    private static final int IDEX_LIST_CONTROL = 8, TIME_LIST_CONTROL = 400;
    private static final int IDEX_CHECK_MOUNT_USB = 9, TIME_CHECK_MOUNT_USB = 2000;
    private static final int IDEX_CHECK_VIDEO_FILE = 10, TIME_CHECK_VIDEO_FILE = 1500;
    private static final int IDEX_VLC_LIVE = 11, TIME_VLC_LIVE = 1000;
    private static final int IDEX_MAIN_EXIT = 12, TIME_MAIN_EXIT = 4000;

    private static final int MODE_AUX = 0, MODE_USB = 1, MODE_SD = 2, MODE_PHONE = 3, MODE_VIDEO_PLAY_NEXT = 4, MODE_VIDEO_PLAY_PREV = 5,
            MODE_VIDEO_PLAY_ONE = 6, MODE_DVD = 7;

    private static final int DELAY_PLAY_TIME = 2000;

    private Button _bt_exit, _bt_usb, _bt_up, _bt_down, _bt_left, _bt_right, _bt_ok, _bt_del, _bt_eq, _bt_setting;

    private RelativeLayout _rl_aux_bg;
    private LinearLayout _ll_wifi_display;

    private ImageView _iv_storage;

    private TextView _tv_storage, _tv_ver, _tv_aux_msg, _tv_video_file_name;

    private ListView mListViewDir, mListViewFile, mListViewPlayList;

    private String rootPathPhone = Environment.getExternalStorageDirectory().getPath();
    private String rootPathUSB1 = "";
    private String rootPathUSB2 = "";
    private String rootPathSD = "";

    private String mMountPath = "", mMountType;

    private ArrayList<FileItem> mArrDir = new ArrayList<FileItem>();
    private ArrayList<FileItem> mArrFile = new ArrayList<FileItem>();

    private ArrayList<PlayListItem> mArrPlayList = new ArrayList<PlayListItem>();

    private ArrayList<FileItem> mArrDirUSB = new ArrayList<FileItem>();
    private ArrayList<FileItem> mArrFileUSB = new ArrayList<FileItem>();

    private ArrayList<FileItem> mArrDirSD = new ArrayList<FileItem>();
    private ArrayList<FileItem> mArrFileSD = new ArrayList<FileItem>();

    private Cursor mPlayListDB = null;
    private String[] mstrProjection;

    private static final String argTableUSB[] = {"PlayListUSB"};
    private static final String argTableSD[] = {"PlayListSD"};

    private DirAdapter mAdapterDir;
    private FileAdapter mAdapterFile;
    private PlayListAdapter mAdapterPlayList;

    private File mCurrentDir = null;

    private PlayListItem mInsertPlayListItem = new PlayListItem();

    private int mSelDirIdx = -1, mDelKeyID = -1;

    //private int mStorageMode = MODE_PHONE;
    private int mStorageMode = -1, mPlayMode = -1, mMsgPlayMode = -1, mLastPlayMode = -1;

    private int mSelLivsView = 0, mSelListDir = 0, mSelListFile = 0, mSelListPlayList = 0, mIdxPlayVideoFile = -1, mPlayListType = -1,
            mLastPlayListMode = -1;

    private int mSelListViewUSB = 0, mSelListDirUSB = 0, mSelListFileUSB = 0;
    private int mSelListViewSD = 0, mSelListDirSD = 0, mSelListFileSD = 0;

    private int mVideoStopCnt = 0;

    private BroadcastReceiver mRemoconReceiver;

    private boolean mIsRemoconControl = true, mIsListShow = false, mIsVideoPlayMode = false, mIsInitFileList = false,
            mIsFirstLastPlay = true, mIsListControl = false, mIsFirstLastListUSB = true, mIsFirstLastListSD = true,
            mIsFirstBoot = true, mIsExistPlayList = false, mIsWifiEnable = false, mIsMainExit = false, mIsPlayClick = false,
            mIsListPlay = false, mIsFirstMainExit = true;

    private String mLastPlayPathParrent = "", mLastPlayPath = "", mVideoPlayModePath = "", mVideoPlayModePathParrent = "",
            mPlayListFilePath = "", mPlayListFileName ="";

    private ProgressDialog mProgressDialog;

    private ArrayList<FileItem> mArrVideoFile = new ArrayList<FileItem>();

    private FileItem mListPlayItem;

    private WifiManager mWifiManager;

    private AudioManager mAudioManager;

    private View mContentView;
    private void hide() {
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus)
            hide();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        kog.m("[Main] onCreate");

        PreferenceUtil.init(this);
        //PreferenceUtil.saveModeVideoRepeat(MyConstants.REPEAT_ALL);
        //PreferenceUtil.saveModeAudioRepeat(MyConstants.REPEAT_ALL);
        PreferenceUtil.saveModeVideoRepeat(MyConstants.REPEAT_FOLDER);
        PreferenceUtil.saveModeAudioRepeat(MyConstants.REPEAT_FOLDER);

// storage permission
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                    || checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                    || checkSelfPermission(Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED
            ) {
                if(shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    Toast.makeText(this, "외부 저장소 사용을 위해 읽기/쓰기 필요", Toast.LENGTH_SHORT).show();
                }

                requestPermissions(new String[]
                        {Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO}, 3);
            }
        }

        setContentView(R.layout.activity_explorer);
        mContentView = findViewById(R.id.main_layout);

        USE_VIDEO = PreferenceUtil.getUseVideo();
        findViewById(R.id.tv_ver).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(++USE_VIDEO_COUNT > 10) {
                    if(USE_VIDEO) USE_VIDEO = false; else USE_VIDEO = true;
                    PreferenceUtil.saveUseVideo(USE_VIDEO);
                }
            }
        });

        _rl_aux_bg = (RelativeLayout) findViewById(R.id.rl_aux_bg);
        _ll_wifi_display = (LinearLayout) findViewById(R.id.ll_wifi_display);

        _bt_exit = (Button) findViewById(R.id.bt_exit);
        _bt_exit.setOnClickListener(this);

        _bt_usb = (Button) findViewById(R.id.bt_usb);
        _bt_usb.setOnClickListener(this);

        _bt_up = (Button) findViewById(R.id.bt_up);
        _bt_up.setOnClickListener(this);

        _bt_down = (Button) findViewById(R.id.bt_down);
        _bt_down.setOnClickListener(this);

        _bt_left = (Button) findViewById(R.id.bt_left);
        _bt_left.setOnClickListener(this);

        _bt_right = (Button) findViewById(R.id.bt_right);
        _bt_right.setOnClickListener(this);

        _bt_ok = (Button) findViewById(R.id.bt_ok);
        _bt_ok.setOnClickListener(this);

        _bt_del = (Button) findViewById(R.id.bt_del);
        _bt_del.setOnClickListener(this);

        _bt_eq = (Button) findViewById(R.id.bt_eq);
        _bt_eq.setOnClickListener(this);

        _bt_setting = (Button) findViewById(R.id.bt_setting);
        _bt_setting.setOnClickListener(this);

        _iv_storage = (ImageView) findViewById(R.id.iv_storage);

        _tv_storage = (TextView) findViewById(R.id.tv_storage);
        _tv_ver = (TextView) findViewById(R.id.tv_ver);
        _tv_aux_msg = (TextView) findViewById(R.id.tv_aux_msg);
        _tv_video_file_name = (TextView) findViewById(R.id.tv_video_file_name);

        mListViewDir = (ListView) findViewById(R.id.lv_dir);
        mAdapterDir = new DirAdapter(this);
        mListViewDir.setAdapter(mAdapterDir);

        mListViewFile = (ListView) findViewById(R.id.lv_file);
        mAdapterFile = new FileAdapter(this);
        mListViewFile.setAdapter(mAdapterFile);

        mListViewPlayList = (ListView) findViewById(R.id.lv_play_list);
        mAdapterPlayList = new PlayListAdapter(this);
        mListViewPlayList.setAdapter(mAdapterPlayList);

        mWifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        mWifiManager.setWifiEnabled(true);

        mAudioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        _rl_aux_bg.setVisibility(View.GONE);

        //mStorageMode = PreferenceUtil.getModeStorage();
        //checkStorageMode();

        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_MOUNT_USB);
        filter.addAction(ACTION_MOUNT_SD);
        filter.addAction(MyConstants.MSG_PLAYLIST_LIST_NEXT);
        filter.addAction(MyConstants.MSG_PLAYLIST_LIST_PREV);
        filter.addAction(MyConstants.MSG_PLAYLIST_LIST_ONE);
        filter.addAction("MSG_VIDEO_PLAY_NEXT");
        filter.addAction("MSG_VIDEO_PLAY_PREV");
        filter.addAction("MSG_VIDEO_PLAY_ONE");
        filter.addAction("MSG_PLAY_STOP");
        filter.addAction("MSG_MAIN_LIST");
        filter.addAction("MSG_LIST_PLAY_START");
        filter.addAction("MSG_VIDEO_STOP");
        filter.addAction("MSG_VLC_REBOOT_MODE");
        filter.addAction("MSG_SYSTEM_RESET");
        filter.addAction("MSG_VLC_LAUNCHER_RUN");
        //filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        registerReceiver(mReceiver, filter);

        IntentFilter storageFilter = new IntentFilter();
        storageFilter.addAction(Intent.ACTION_MEDIA_MOUNTED);
        storageFilter.addAction(Intent.ACTION_MEDIA_REMOVED);
        storageFilter.addAction(Intent.ACTION_MEDIA_UNMOUNTED);
        storageFilter.addDataScheme("file");
        registerReceiver(mReceiverStorage, storageFilter);

        IntentFilter mRemoconFilter = new IntentFilter();
        mRemoconFilter.addAction("MSG_UART_REMOCON");

        mRemoconReceiver = new BroadcastReceiver(){
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if(action.equals("MSG_UART_REMOCON")) {
                    byte key = intent.getByteExtra("Key", (byte) -1);

                    String msg = String.format("%02x", key&0xff);
                    //Function.toast(ExplorerActivity.this, msg);
                    kog.m("[Main] MSG_UART_REMOCON : " + msg);

                    onRemoconMode(key);
                }
            }
        };
        registerReceiver(mRemoconReceiver, mRemoconFilter);

        mListViewDir.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mSelLivsView = 0;

                mSelListDir = position;
                onSetDirList(position);

                mAdapterDir.notifyDataSetChanged();
                mAdapterFile.notifyDataSetChanged();
                mAdapterPlayList.notifyDataSetChanged();

                saveModeListUSB_SD();
            }
        });

        mListViewFile.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                kog.m("[Main] mListViewFile.setOnItemClickListener mIsPlayClick : " + mIsPlayClick);

                if(mIsPlayClick) return;

                mIsPlayClick = true;
                mSelLivsView = 1;

                MyConstants.g_IsLastPlay = false;
                mSelListFile = position;
                onPlayFile(position);

                mAdapterDir.notifyDataSetChanged();
                mAdapterFile.notifyDataSetChanged();
                mAdapterPlayList.notifyDataSetChanged();
            }
        });

        mListViewFile.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                onAddPlayList(position);

                return true;
            }
        });

        mListViewPlayList.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(mIsPlayClick) return;

                mIsPlayClick = true;
                mSelLivsView = 2;

                MyConstants.g_IsLastPlay = false;
                mSelListPlayList = position;
                onPlayListFile(position);

                mAdapterDir.notifyDataSetChanged();
                mAdapterFile.notifyDataSetChanged();
                mAdapterPlayList.notifyDataSetChanged();
            }
        });

        mListViewPlayList.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                PlayListItem item = (PlayListItem) mArrPlayList.get(position);
                mDelKeyID = item.key_id;

                if(mStorageMode == MODE_USB){
                    delPlayListDB(true);
                }
                else if(mStorageMode == MODE_SD){
                    delPlayListDB(false);
                }

                getPlayListDB();

                if(mArrPlayList.size() == 0){
                    mSelLivsView = 0;
                    mAdapterDir.notifyDataSetChanged();
                }
                else{
                    if(mSelListPlayList >= mArrPlayList.size()){
                        mSelListPlayList = mArrPlayList.size() - 1;
                        mListViewPlayList.setSelection(mSelListPlayList);
                    }
                }
                return true;
            }
        });

        _tv_ver.setText("2023-01-16");

        if((PreferenceUtil.getModeStorage() == MODE_USB) || (PreferenceUtil.getModeStorage() == MODE_SD)){
            mStorageMode = PreferenceUtil.getModeStorage();

            kog.m("[Main] onCreate mStorageMode : " + mStorageMode);
        }

        mHandler.sendEmptyMessage(IDEX_VLC_LIVE);
        mHandler.sendEmptyMessageDelayed(IDEX_MAIN_EXIT, TIME_MAIN_EXIT);

        findViewById(R.id.iv_back).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mIsMainExit){
                    sendMsgLauncherExit();

                    /*Intent intent = getPackageManager().getLaunchIntentForPackage("com.microcity.launcher");
                    if (intent != null) {
                        Intent intentMsg = new Intent("com.microcity.action.SHOW_STATUSBAR");
                        sendBroadcast(intentMsg);

                        startActivity(intent);
                    }*/
                    sendMsgStatusBar();

                    onExitLauncher();
                }
            }
        });

        findViewById(R.id.iv_youtube).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mIsMainExit){
                    sendMsgLauncherExit();

                    Intent intent = getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");
                    if (intent != null) {
                        sendMsgStatusBar();

                        startActivity(intent);
                    }
                    onExitLauncher();
                }
            }
        });

        findViewById(R.id.iv_wifi).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mIsMainExit){
                    sendMsgLauncherExit();
                    Intent intent = getPackageManager().getLaunchIntentForPackage("com.rockchip.wfd");
                    if (intent != null) {
                        sendMsgStatusBar();

                        startActivity(intent);
                    }

                    onExitLauncher();
                }
            }
        });

        findViewById(R.id.iv_wave).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mIsMainExit){
                    sendMsgLauncherExit();
                    Intent intent = getPackageManager().getLaunchIntentForPackage("kr.co.captv.pooqV2");
                    if (intent != null) {
                        sendMsgStatusBar();

                        startActivity(intent);
                    }

                    onExitLauncher();
                }
            }
        });
        if(!USE_VIDEO) {
            findViewById(R.id.rl_main_top).setBackground(getResources().getDrawable(R.drawable.m_background_bar));
            findViewById(R.id.iv_back).setVisibility(View.INVISIBLE);
            findViewById(R.id.iv_youtube).setVisibility(View.INVISIBLE);
            findViewById(R.id.iv_wifi).setVisibility(View.INVISIBLE);
            findViewById(R.id.iv_wave).setVisibility(View.INVISIBLE);
        }
    }

    private void sendMsgStatusBar(){
        Intent intentMsg = new Intent("com.microcity.action.SHOW_STATUSBAR");
        sendBroadcast(intentMsg);
    }

    private void sendMsgLauncherExit(){
        Intent intent = new Intent("MSG_LAUNCHER_EXIT");
        sendBroadcast(intent);

        Intent iLauncher = new Intent(Intent.ACTION_MAIN); //태스크의 첫 액티비티로 시작
        iLauncher.addCategory(Intent.CATEGORY_HOME);   //홈화면 표시
        startActivity(iLauncher);
    }

    private void onExitLauncher(){
        //mAudioManager.setStreamMute(AudioManager.STREAM_MUSIC, false);

        int currVol = PreferenceUtil.getMainVol();
        kog.m("[onExitLauncher] CurrVol : " + currVol);

        //mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, currVol, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
        // edit by ssh 20200807
        mAudioManager.setStreamMute(AudioManager.STREAM_MUSIC, false);
        finish();
    }

    private void onRemoconMode(byte key){
        switch(key){
            case DefineRemocon.up:
                if(mIsRemoconControl) {
                    if (mSelLivsView == 0) {
                        if (mArrDir.size() == 0) return;

                        mSelListDir--;

                        if (mSelListDir < 0) {
                            mSelListDir = mArrDir.size() - 1;
                        }
                    } else if (mSelLivsView == 1) {
                        if (mArrFile.size() == 0) return;

                        mSelListFile--;
                        mIsInitFileList = false;

                        if (mSelListFile < 0) {
                            mSelListFile = mArrFile.size() - 1;
                        }
                    } else if (mSelLivsView == 2) {
                        if (mArrPlayList.size() == 0) return;

                        mSelListPlayList--;

                        if (mSelListPlayList < 0) {
                            mSelListPlayList = mArrPlayList.size() - 1;
                        }
                    }

                    refreshListView();
                    saveModeListSelUSB_SD();
                }
                break;

            case DefineRemocon.down:
                if(mIsRemoconControl) {
                    if (mSelLivsView == 0) {
                        if (mArrDir.size() == 0) return;

                        mSelListDir++;

                        if (mSelListDir == mArrDir.size()) {
                            mSelListDir = 0;
                        }
                    } else if (mSelLivsView == 1) {
                        if (mArrFile.size() == 0) return;

                        mSelListFile++;
                        mIsInitFileList = false;

                        if (mSelListFile == mArrFile.size()) {
                            mSelListFile = 0;
                        }
                    } else if (mSelLivsView == 2) {
                        if (mArrPlayList.size() == 0) return;

                        mSelListPlayList++;

                        if (mSelListPlayList == mArrPlayList.size()) {
                            mSelListPlayList = 0;
                        }
                    }

                    refreshListView();
                    saveModeListSelUSB_SD();
                }
                break;

            case DefineRemocon.left:
                if(mIsRemoconControl) {
                    mSelLivsView--;

                    if (mSelLivsView < 0) {
                        mSelLivsView = 2;
                    }

                    if(mSelLivsView == 1){
                        if (mArrFile.size() == 0){
                            mSelLivsView = 0;
                        }

                        mIsInitFileList = false;
                    }

                    if(mSelLivsView == 2){
                        if (mArrPlayList.size() == 0){
                            mSelLivsView = 0;
                            return;
                        }
                    }

                    mAdapterDir.notifyDataSetChanged();
                    mAdapterFile.notifyDataSetChanged();
                    mAdapterPlayList.notifyDataSetChanged();

                    saveModeListSelUSB_SD();
                }
                break;

            case DefineRemocon.right:
                if(mIsRemoconControl) {
                    mSelLivsView++;

                    if(mSelLivsView == 1){
                        if(mArrFile.size() == 0){
                            if(mArrPlayList.size() == 0){
                                mSelLivsView = 0;
                                return;
                            }
                            else{
                                mSelLivsView = 2;
                            }
                        }
						else{
                            mIsInitFileList = false;
                        }
                    }

                    if(mSelLivsView == 2){
                        if(mArrPlayList.size() == 0){
                            mSelLivsView = 1;
                            return;
                        }
                    }

                    if (mSelLivsView > 2) {
                        mSelLivsView = 0;
                    }

                    mAdapterDir.notifyDataSetChanged();
                    mAdapterFile.notifyDataSetChanged();
                    mAdapterPlayList.notifyDataSetChanged();

                    saveModeListSelUSB_SD();
                }
                break;

            case DefineRemocon.enter:
                if(mIsRemoconControl) {
                    kog.m("[Main] onRemoconMode enter mSelListDir : " + mSelListDir);
                    if (mSelLivsView == 0) {
                        onSetDirList(mSelListDir);
                        saveModeListUSB_SD();
                    } else if (mSelLivsView == 1) {
                        MyConstants.g_IsLastPlay = false;
                        onPlayFile(mSelListFile);
                        mAdapterFile.notifyDataSetChanged();
                    } else if (mSelLivsView == 2) {
                        MyConstants.g_IsLastPlay = false;
                        onPlayListFile(mSelListPlayList);
                    }
                }
                break;

            case DefineRemocon.dvd:
                if(mStorageMode == MODE_DVD) return;

                sendMsgFinish();
                resetHandlerMsg();

                mStorageMode = MODE_DVD;
                kog.m("[Main] onRemoconMode MODE_DVD mStorageMode : " + mStorageMode);
                break;

			case DefineRemocon.aux:
                if(mStorageMode == MODE_AUX) return;

                sendMsgFinish();
                resetHandlerMsg();

                mStorageMode = MODE_AUX;
                PreferenceUtil.saveModeStorage(mStorageMode);

                setAuxMode();
                kog.m("[Main] onRemoconMode MODE_AUX mStorageMode : " + mStorageMode);
                break;


            case DefineRemocon.sd:
                if(mIsFirstBoot){
                    mStorageMode = MODE_SD;
                    PreferenceUtil.saveModeStorage(mStorageMode);

                    if(mArrDir.isEmpty()) {
                        _tv_storage.setText(NO_SD_CARD);
                        _tv_storage.setVisibility(View.VISIBLE);

                        _tv_aux_msg.setText("");
                        _rl_aux_bg.setVisibility(View.GONE);
                    } else {
                        _tv_storage.setVisibility(View.GONE);
                    }

                    sendMsgVlcStart();

                    mIsFirstBoot = false;
                    return;
                }
                if(mStorageMode == MODE_SD) return;

                sendMsgFinish();
                resetHandlerMsg();

                _tv_aux_msg.setText("");
                _rl_aux_bg.setVisibility(View.GONE);

                mStorageMode = MODE_SD;
                PreferenceUtil.saveModeStorage(mStorageMode);

                initModeDir();
                //setStorageModeChange(false);
                getModeListSD();
                //getPlayListDB();
                mSelListPlayList = 0;
                kog.m("[Main] onRemoconMode MODE_SD mStorageMode : " + mStorageMode);
                break;

            case DefineRemocon.usb:
                if(mIsFirstBoot){
                    mStorageMode = MODE_USB;
                    PreferenceUtil.saveModeStorage(mStorageMode);

                    if(mArrDir.isEmpty()) {
                        _tv_storage.setText(NO_USB);
                        _tv_storage.setVisibility(View.VISIBLE);

                        _tv_aux_msg.setText("");
                        _rl_aux_bg.setVisibility(View.GONE);
                    } else {
                        _tv_storage.setVisibility(View.GONE);
                    }

                    sendMsgVlcStart();

                    mIsFirstBoot = false;
                    return;
                }

                if(mStorageMode == MODE_USB) return;

                sendMsgFinish();
                resetHandlerMsg();

                _tv_aux_msg.setText("");
                _rl_aux_bg.setVisibility(View.GONE);

                mStorageMode = MODE_USB;
                PreferenceUtil.saveModeStorage(mStorageMode);

                initModeDir();
                //setStorageModeChange(true);
                getModeListUSB();
                //getPlayListDB();
                mSelListPlayList = 0;
                kog.m("[Main] onRemoconMode MODE_USB mStorageMode : " + mStorageMode);
                break;

            case DefineRemocon.list:
                kog.m("[Main] onRemoconMode list mIsListShow : " + mIsListShow + "   mIsListControl : " + mIsListControl + "   mIsRemoconControl : " + mIsRemoconControl);
                if(mIsRemoconControl){
                    if(mIsListControl) {
                        if(mIsListShow){
                            mIsListControl = false;
                            mIsListShow = false;

                            Intent iMode = null;
                            if(mPlayMode == MyConstants.MODE_PLAY_VIDEO){
                                sendMsgFinish();
                                onListPlay(2000);
                            }
                            else if(mPlayMode == MyConstants.MODE_PLAY_AUDIO){
                                iMode = new Intent(this, AudioPlayerActivity.class);
                                iMode.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                startActivity(iMode);
                            }
                            else if(mPlayMode == MyConstants.MODE_PLAY_IMAGE){
                                iMode = new Intent(this, ImageActivity.class);
                                iMode.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                startActivity(iMode);
                            }
                        }
                    }
                    else{
                        if(mIsWifiEnable){
                            Intent intentWfd = getPackageManager().getLaunchIntentForPackage("com.rockchip.wfd");
                            if(intentWfd != null){
                                startActivity(intentWfd);
                                overridePendingTransition(0, 0);
                            }
                            else{
                                kog.m("WFD app not install!");
                            }
                        }
                    }
                }

                break;

            case DefineRemocon.play:
                kog.m("[Main] onRemoconMode play mVideoStopCnt : " + mVideoStopCnt);
                if(mPlayMode == MyConstants.MODE_PLAY_VIDEO){
                    if(mVideoStopCnt == 1){
                        sendMsgFinish();
                        onListPlay(2000);
                    }
                    else if(mVideoStopCnt == 2){
                        kog.m("[Main] onRemoconMode play mVideoStopCnt2 g_CurrPlayFilePath : " + MyConstants.g_CurrPlayFilePath);
                        playVideo(MyConstants.g_CurrPlayFilePath);
                    }
                }
                break;

            case DefineRemocon.stop:
                if(mPlayMode == MyConstants.MODE_PLAY_VIDEO){
                    if(mVideoStopCnt == 0){
                        stopCheckVideFile();
                    }
                    else if(mVideoStopCnt == 1){
                        mVideoStopCnt ++;
                    }
                }
                break;

            case DefineRemocon.fav_del_all:
                if(mIsRemoconControl) {
                    if(mStorageMode == MODE_USB){
                        delAllPlayListDB(true);

                        mSelListPlayList = 0;
                        mArrPlayList.clear();
                        mAdapterPlayList.notifyDataSetChanged();
                    }
                    else if(mStorageMode == MODE_SD){
                        delAllPlayListDB(false);

                        mSelListPlayList = 0;
                        mArrPlayList.clear();
                        mAdapterPlayList.notifyDataSetChanged();
                    }

                    if(mSelLivsView == 2){
                        mSelLivsView = 0;
                        mAdapterDir.notifyDataSetChanged();
                    }
                }
                break;

            case DefineRemocon.fav_add:
                if(mIsRemoconControl) {
                    if (mSelLivsView == 1) {
                        onAddPlayList(mSelListFile);
                    }
                }
                break;

            case DefineRemocon.fav_del:
                if(mIsRemoconControl) {
                    if (mSelLivsView == 2) {
                        PlayListItem item = (PlayListItem) mArrPlayList.get(mSelListPlayList);
                        mDelKeyID = item.key_id;

                        if(mStorageMode == MODE_USB){
                            delPlayListDB(true);
                        }
                        else if(mStorageMode == MODE_SD){
                            delPlayListDB(false);
                        }

                        getPlayListDB();

                        if(mArrPlayList.size() == 0){
                            mSelLivsView = 0;
                            mAdapterDir.notifyDataSetChanged();
                        }
                        else{
                            if(mSelListPlayList >= mArrPlayList.size()){
                                mSelListPlayList = mArrPlayList.size() - 1;
                                mListViewPlayList.setSelection(mSelListPlayList);
                            }
                        }
                    }
                }
                break;
        }
    }

    private BroadcastReceiver mReceiverStorage = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(Intent.ACTION_MEDIA_MOUNTED)) {
                kog.m("[Main] ACTION_MEDIA_MOUNTED : " + intent.toString());
            }
            else if (action.equals(Intent.ACTION_MEDIA_UNMOUNTED)) {
                mMountPath = intent.getData().getPath();
                kog.m("[Main] ACTION_MEDIA_UNMOUNTED : " + mMountPath);

                checkMountPath(false);

                mSelLivsView = 0;

                if(mStorageMode == MODE_AUX){
                    _rl_aux_bg.setVisibility(View.VISIBLE);
                }
                else{
                    _rl_aux_bg.setVisibility(View.GONE);
                }
            }
        }
    };

    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if(action.equals(ACTION_MOUNT_USB)){
                mMountPath = intent.getStringExtra("path");
                mMountType = intent.getStringExtra("type");
                kog.m("[Main] ACTION_MOUNT_USB mMountPath : " + mMountPath + "   mMountType : " + mMountType);

                PreferenceUtil.saveKeyLastMountPathUsb(mMountPath);

                if(mMountType != null){
                    checkExistMountPath();
                }
            }
            else if(action.equals(ACTION_MOUNT_SD)){
                mMountPath = intent.getStringExtra("path");
                mMountType = intent.getStringExtra("type");
                kog.m("[Main] ACTION_MOUNT_SD mMountPath : " + mMountPath + "   mMountType : " + mMountType);

                PreferenceUtil.saveKeyLastMountPathSd(mMountPath);

                if(mMountType != null){
                    checkExistMountPath();
                }
            }
            else if(action.equals("MSG_VIDEO_PLAY_NEXT")){
                kog.m("[Main] onReceive MODE_VIDEO_PLAY_NEXT");
                mMsgPlayMode = MODE_VIDEO_PLAY_NEXT;
                onVideoPlayMode();
            }
            else if(action.equals("MSG_VIDEO_PLAY_PREV")){
                kog.m("[Main] onReceive MSG_VIDEO_PLAY_PREV");
                mMsgPlayMode = MODE_VIDEO_PLAY_PREV;
                onVideoPlayMode();
            }
            else if(action.equals("MSG_VIDEO_PLAY_ONE")){
                kog.m("[Main] onReceive MSG_VIDEO_PLAY_ONE");
                mMsgPlayMode = MODE_VIDEO_PLAY_ONE;
                onVideoPlayMode();
            }
            else if(action.equals("MSG_PLAY_STOP")){
                kog.m("[Main] onReceive MSG_PLAY_STOP");
                if(mStorageMode == MODE_AUX){
                    setAuxMode();
                }
                else{
                    _rl_aux_bg.setVisibility(View.GONE);
                }
            }
            else if(action.equals(MyConstants.MSG_PLAYLIST_LIST_NEXT)){
                kog.m("[Main] onReceive MSG_PLAYLIST_LIST_NEXT");
                onPlayListNext();
            }
            else if(action.equals(MyConstants.MSG_PLAYLIST_LIST_PREV)){
                kog.m("[Main] onReceive MSG_PLAYLIST_LIST_PREV");
                onPlayListPrev();
            }
            else if(action.equals(MyConstants.MSG_PLAYLIST_LIST_ONE)){
                kog.m("[Main] onReceive MSG_PLAYLIST_LIST_ONE");
                onPlayListOne();
            }
            else if(action.equals("MSG_MAIN_LIST")){
                kog.m("[Main] onReceive MSG_MAIN_LIST mIsListShow : " + mIsListShow);

                if(!mIsListShow){
                    _rl_aux_bg.setVisibility(View.GONE);

                    if((mPlayMode == MyConstants.MODE_PLAY_AUDIO) ||
                            (mPlayMode == MyConstants.MODE_PLAY_IMAGE) ||
                            (mPlayMode == MyConstants.MODE_PLAY_VIDEO)){
                        runMain();
                    }

                    mHandler.removeMessages(IDEX_LIST_CONTROL);
                    mHandler.sendEmptyMessageDelayed(IDEX_LIST_CONTROL, TIME_LIST_CONTROL);
                }
                mIsListShow = false;
            }
            else if(action.equals("MSG_VIDEO_STOP")){
                kog.m("[Main] onReceive MSG_VIDEO_STOP mIsVideoStop : " + mVideoStopCnt);

                mVideoStopCnt++;
            }
            else if(action.equals("MSG_LIST_PLAY_START")){
                kog.m("[Main] onReceive MSG_LIST_PLAY_START mIsListShow : " + mIsListShow);

                mIsListShow = false;
            }
            /*else if(WifiManager.WIFI_STATE_CHANGED_ACTION.equals(action)){
                int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN);
                if(WifiManager.WIFI_STATE_ENABLED == wifiState){
                    kog.m("[Main] onReceive WIFI_STATE_ENABLED");
                    _ll_wifi_display.setVisibility(View.VISIBLE);
                    mIsWifiEnable = true;
                }
                else{
                    kog.m("[Main] onReceive WIFI_STATE_DISABLED");
                    _ll_wifi_display.setVisibility(View.GONE);
                    mIsWifiEnable = false;
                }
            }*/
            else if(action.equals("MSG_VLC_REBOOT_MODE")){
                kog.m("[Main] onReceive MSG_VLC_REBOOT_MODE");

                clearAllData();
            }
            else if(action.equals("MSG_SYSTEM_RESET")){
                kog.m("[Main] onReceive MSG_SYSTEM_RESET");

                _tv_aux_msg.setText("업데이트가 완료 되었습니다. \n전원을 껏다 켜 주시기 바랍니다.");
                _rl_aux_bg.setVisibility(View.VISIBLE);
            }
            else if(action.equals("MSG_VLC_LAUNCHER_RUN")){
                kog.m("[Main] onReceive MSG_VLC_LAUNCHER_RUN mStorageMode :" + mStorageMode);

                if(mIsFirstBoot){
                    if(mStorageMode == MODE_USB){
                        _tv_storage.setText(NO_USB);
                    }
                    else if(mStorageMode == MODE_SD){
                        _tv_storage.setText(NO_SD_CARD);
                    }
                    _tv_storage.setVisibility(View.VISIBLE);

                    sendMsgVlcStart();
                    mIsFirstBoot = false;
                }
            }
        }
    };

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler(){
        public void handleMessage(Message msg){
            if(msg.what == IDEX_VIDEO_PLAY_CHECK){
                mHandler.removeMessages(IDEX_VIDEO_PLAY_CHECK);
                onVideoPlayMode();
            }
            else if(msg.what == IDEX_MOUNT_CHECK){
                mHandler.removeMessages(IDEX_MOUNT_CHECK);
                //setStorageMode(true);
            }
            else if(msg.what == IDEX_LAST_PLAY){
                mHandler.removeMessages(IDEX_LAST_PLAY);
                kog.m("[Main] mHandler IDEX_LAST_PLAY");

                if(mLastPlayMode == MyConstants.MODE_PLAY_VIDEO){
                    MyConstants.g_IsLastPlay = true;

                    mPlayMode = MyConstants.MODE_PLAY_VIDEO;

                    if(mLastPlayListMode == 0){
                        if(checkVideFile(mLastPlayPath, "")){
                            MyConstants.g_SelPlayList = false;
                            setVideoFileList(mLastPlayPathParrent, mLastPlayPath);
                            playVideo(mLastPlayPath);

                            setResumePlayFileList();
                        }
                    }
                    else{
                        MyConstants.g_SelPlayList = true;

                        if(checkVideFile(mLastPlayPath, "")){
                            playVideo(mLastPlayPath);

                            mSelLivsView = 2;
                            mAdapterDir.notifyDataSetChanged();
                            mAdapterFile.notifyDataSetChanged();
                            setResumePlayListFileList();
                            MyConstants.g_IdxPlayList = mSelListPlayList;
                        }
                    }
                }
                else if(mLastPlayMode == MyConstants.MODE_PLAY_AUDIO){
                    MyConstants.g_IsLastPlay = true;

                    mPlayMode = MyConstants.MODE_PLAY_AUDIO;

                    if(mLastPlayListMode == 0){
                        MyConstants.g_SelPlayList = false;

                        MyConstants.g_PlayPathParrent = mLastPlayPathParrent;
                        MyConstants.g_CurrPlayFilePath = mLastPlayPath;

                        playAudio(MyConstants.g_CurrPlayFilePath);

                        setResumePlayFileList();
                    }
                    else{
                        MyConstants.g_SelPlayList = true;

                        MyConstants.g_CurrPlayFilePath = mLastPlayPath;
                        playAudio(mLastPlayPath);

                        mSelLivsView = 2;
                        mAdapterDir.notifyDataSetChanged();
                        mAdapterFile.notifyDataSetChanged();
                        setResumePlayListFileList();
                        MyConstants.g_IdxPlayList = mSelListPlayList;
                    }
                }

                mIsMainExit = true;
                mIsPlayClick = false;
                mIsFirstMainExit = false;
                mHandler.removeMessages(IDEX_MAIN_EXIT);
            }
            else if(msg.what == IDEX_VIDEO_PLAY_MODE){
                mHandler.removeMessages(IDEX_VIDEO_PLAY_MODE);
                kog.m("[Main] mHandler IDEX_VIDEO_PLAY_MODE");

                if(!Function.isFileExist(mVideoPlayModePath)){
                    Function.toast(ExplorerActivity.this, "재생할 파일이 없습니다.");
                    _rl_aux_bg.setVisibility(View.GONE);
                    mIsRemoconControl = true;
                }
                else{
                    saveLastPlayValue(mVideoPlayModePath, mVideoPlayModePathParrent, MyConstants.MODE_PLAY_VIDEO);
                    PreferenceUtil.savePlayListMode(0);
                    playVideo(mVideoPlayModePath);
                }
            }
            else if(msg.what == IDEX_PLAY_LIST_MODE){
                mHandler.removeMessages(IDEX_PLAY_LIST_MODE);
                kog.m("[Main] mHandler IDEX_PLAY_LIST_MODE");

                if(!Function.isFileExist(mPlayListFilePath)){
                    Function.toast(ExplorerActivity.this, "재생할 파일이 없습니다.");
                    _rl_aux_bg.setVisibility(View.GONE);
                    mIsRemoconControl = true;
                }
                else{
                    if(mPlayListType == MyConstants.TYPE_VIDEO){
                        mPlayMode = MyConstants.MODE_PLAY_VIDEO;

                        if(checkVideFile(mPlayListFilePath, mPlayListFileName)){
                            saveLastPlayValue(mPlayListFilePath, "", MyConstants.MODE_PLAY_VIDEO);
                            PreferenceUtil.savePlayListMode(1);
                            playVideo(mPlayListFilePath);
                        }
                    }
                    else if(mPlayListType == MyConstants.TYPE_AUDIO){
                        mPlayMode = MyConstants.MODE_PLAY_AUDIO;
                        saveLastPlayValue(mPlayListFilePath, "", MyConstants.TYPE_AUDIO);
                        PreferenceUtil.savePlayListMode(1);
                        MyConstants.g_CurrPlayFilePath = mPlayListFilePath;
                        playAudio(mPlayListFilePath);
                    }
                    else if(mPlayListType == MyConstants.TYPE_IMAGE){
                        mPlayMode = MyConstants.MODE_PLAY_IMAGE;
                        saveLastPlayValue(mPlayListFilePath, "", MyConstants.TYPE_IMAGE);
                        PreferenceUtil.savePlayListMode(1);
                        MyConstants.g_CurrPlayFilePath = mPlayListFilePath;
                        playImage(mPlayListFilePath);
                    }
                }
            }
            else if(msg.what == IDEX_REMOCON_ENABLE){
                mHandler.removeMessages(IDEX_REMOCON_ENABLE);

                mIsRemoconControl = true;
            }
            else if(msg.what == IDEX_LIST_CONTROL){
                kog.m("[Main] mHandler IDEX_LIST_CONTROL");
                mHandler.removeMessages(IDEX_LIST_CONTROL);

                mIsListControl = true;
                mIsListShow = true;

                mIsPlayClick = false;
            }
            else if(msg.what == IDEX_LIST_PLAY){
                mHandler.removeMessages(IDEX_LIST_PLAY);
                kog.m("[Main] mHandler IDEX_LIST_PLAY");

                if(mListPlayItem.type == MyConstants.TYPE_VIDEO){
                    mPlayMode = MyConstants.MODE_PLAY_VIDEO;
                    MyConstants.g_SelVideoFileItem = mListPlayItem;
                    setVideoFileList(mListPlayItem.path_parrent, mListPlayItem.path);

                    if(checkVideFile(mListPlayItem.path, mListPlayItem.name)){
                        saveLastPlayValue(mListPlayItem.path, mListPlayItem.path_parrent, MyConstants.MODE_PLAY_VIDEO);
                        PreferenceUtil.savePlayListMode(0);
                        playVideo(mListPlayItem.path);
                    }
                }
                else if(mListPlayItem.type == MyConstants.TYPE_AUDIO){
                    mPlayMode = MyConstants.MODE_PLAY_AUDIO;
                    //Constants.g_SelAudioFileItem = item;
                    MyConstants.g_PlayPathParrent = mListPlayItem.path_parrent;
                    MyConstants.g_CurrPlayFilePath = mListPlayItem.path;

                    kog.m("[Main] onPlayFile g_PlayPathParrent : " + MyConstants.g_PlayPathParrent + "   g_CurrPlayFilePath : " + MyConstants.g_CurrPlayFilePath);

                    saveLastPlayValue(mListPlayItem.path, mListPlayItem.path_parrent, MyConstants.MODE_PLAY_AUDIO);
                    PreferenceUtil.savePlayListMode(0);
                    playAudio(mListPlayItem.path);
                }
                else if(mListPlayItem.type == MyConstants.TYPE_IMAGE){
                    mPlayMode = MyConstants.MODE_PLAY_IMAGE;
                    MyConstants.g_SelImageFileItem = mListPlayItem;

                    kog.m("[Main] onPlayFile MODE_PLAY_IMAGE path : " + mListPlayItem.path);

                    saveLastPlayValue(mListPlayItem.path, mListPlayItem.path_parrent, MyConstants.MODE_PLAY_IMAGE);
                    PreferenceUtil.savePlayListMode(0);
                    playImage(mListPlayItem.path);
                }
            }
            else if(msg.what == IDEX_CHECK_MOUNT_USB) {
                kog.m("[Main] mHandler IDEX_CHECK_MOUNT_USB");
                mHandler.removeMessages(IDEX_CHECK_MOUNT_USB);

                delAllPlayListDB(true);

                mSelListPlayList = 0;
                mArrPlayList.clear();
                mAdapterPlayList.notifyDataSetChanged();
            }
            else if(msg.what == IDEX_CHECK_VIDEO_FILE) {
                kog.m("[Main] mHandler IDEX_CHECK_VIDEO_FILE");
                mHandler.removeMessages(IDEX_VIDEO_PLAY_MODE);
                mHandler.removeMessages(IDEX_CHECK_VIDEO_FILE);

                _tv_aux_msg.setText("");
                _rl_aux_bg.setVisibility(View.GONE);

                mMsgPlayMode = MODE_VIDEO_PLAY_NEXT;
                onVideoPlayMode();
            }
            else if(msg.what == IDEX_VLC_LIVE) {
                mHandler.removeMessages(IDEX_VLC_LIVE);
                sendMsgLiveVLC();
                mHandler.sendEmptyMessageDelayed(IDEX_VLC_LIVE, TIME_VLC_LIVE);
            }
            else if(msg.what == IDEX_MAIN_EXIT) {
                mHandler.removeMessages(IDEX_MAIN_EXIT);
                mIsMainExit = true;
                mIsPlayClick = false;
                mIsFirstMainExit = false;
            }
        }
    };

    private void stopCheckVideFile(){
        mHandler.removeMessages(IDEX_VIDEO_PLAY_MODE);
        mHandler.removeMessages(IDEX_CHECK_VIDEO_FILE);
        _tv_aux_msg.setText("");
        _rl_aux_bg.setVisibility(View.GONE);

        mIsRemoconControl = true;
    }

    private boolean checkVideFile(String path, String name){
        mHandler.removeMessages(IDEX_CHECK_VIDEO_FILE);

        MyConstants.g_VideoPlayErr = MyConstants.CHECK_VIDEO_OK;
        _tv_video_file_name.setVisibility(View.GONE);

        kog.m("[Main] checkVideFile path : " + path);

        File videoFile = new File(path);
        if(!videoFile.exists()){
            _tv_aux_msg.setText("재생할 파일이 없습니다.");
            _rl_aux_bg.setVisibility(View.VISIBLE);

            kog.m("[Main] checkVideFile !videoFile.exists");

            mHandler.sendEmptyMessageDelayed(IDEX_CHECK_VIDEO_FILE, TIME_CHECK_VIDEO_FILE);
            return false;
        }

        kog.m("[Main] checkVideFile length : " + videoFile.length());

        if(videoFile.length() < (1024*1024)){
            _tv_video_file_name.setText(name);
            _tv_video_file_name.setVisibility(View.VISIBLE);

            _tv_aux_msg.setText("파일에 문제가 있어 재생할 수 없습니다.");
            _rl_aux_bg.setVisibility(View.VISIBLE);

            kog.m("[Main] checkVideFile path.length()");

            mHandler.sendEmptyMessageDelayed(IDEX_CHECK_VIDEO_FILE, TIME_CHECK_VIDEO_FILE);
            return false;
        }

        int res = getVideoTrack(path);
        kog.m("[Main] checkVideFile getVideoTrack res : " + res);

        if(res == MyConstants.CHECK_VIDEO_UHD){
            _tv_video_file_name.setText(name);
            _tv_video_file_name.setVisibility(View.VISIBLE);

            //_tv_aux_msg.setText("UHD 사이즈 이상 파일은 재생할 수 없습니다.");
            _tv_aux_msg.setText("재생 불가 파일입니다.");
            _rl_aux_bg.setVisibility(View.VISIBLE);

            mHandler.sendEmptyMessageDelayed(IDEX_CHECK_VIDEO_FILE, TIME_CHECK_VIDEO_FILE);
            return false;
        }

        if(res == MyConstants.CHECK_VIDEO_HEVC_RATE_FAIL){
            _tv_video_file_name.setText(name);
            _tv_video_file_name.setVisibility(View.VISIBLE);

            //_tv_aux_msg.setText("HEVC 코덱, 프레임레이트 이상 파일은 재생할 수 없습니다.");
            _tv_aux_msg.setText("재생 불가 파일입니다.");
            _rl_aux_bg.setVisibility(View.VISIBLE);

            mHandler.sendEmptyMessageDelayed(IDEX_CHECK_VIDEO_FILE, TIME_CHECK_VIDEO_FILE);
            return false;
        }

        if(res == MyConstants.CHECK_VIDEO_HEVC_OVER_HD){
            _tv_video_file_name.setText(name);
            _tv_video_file_name.setVisibility(View.VISIBLE);

            //_tv_aux_msg.setText("HEVC 코덱, Full HD 사이즈 이상 파일은 재생할 수 없습니다.");
            _tv_aux_msg.setText("재생 불가 파일입니다.");
            _rl_aux_bg.setVisibility(View.VISIBLE);

            mHandler.sendEmptyMessageDelayed(IDEX_CHECK_VIDEO_FILE, TIME_CHECK_VIDEO_FILE);
            return false;
        }

        /*if(res == MyConstants.CHECK_VIDEO_DIVX){
            _tv_video_file_name.setText(name);
            _tv_video_file_name.setVisibility(View.VISIBLE);

            _tv_aux_msg.setText("재생 불가 파일입니다.");
            _rl_aux_bg.setVisibility(View.VISIBLE);

            mHandler.sendEmptyMessageDelayed(IDEX_CHECK_VIDEO_FILE, TIME_CHECK_VIDEO_FILE);
            return false;
        }*/

        if((res == MyConstants.CHECK_VIDEO_TRACK_FAIL) ||
                (res == MyConstants.CHECK_VIDEO_RATE_FAIL) ||
                (res == MyConstants.CHECK_AUDIO_TRACK_FAIL)){
            mIsRemoconControl = false;
            //_tv_aux_msg.setText("파일에 문제가 있어서 원활한 재생이 되지 않을 수 있습니다.");
            _tv_aux_msg.setText("");
            _rl_aux_bg.setVisibility(View.VISIBLE);

            MyConstants.g_VideoPlayErr = res;

            return true;
        }
        else if(res == MyConstants.CHECK_VIDEO_OK){
            return true;
        }

        return true;
    }

    private void runMain(){
		_rl_aux_bg.setVisibility(View.GONE);
        Intent i = new Intent(this, ExplorerActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(i);
    }

    private void resetHandlerMsg(){
        mHandler.removeMessages(IDEX_LAST_PLAY);
        mHandler.removeMessages(IDEX_VIDEO_PLAY_MODE);
        mHandler.removeMessages(IDEX_PLAY_LIST_MODE);
        mHandler.removeMessages(IDEX_LIST_PLAY);
        mHandler.removeMessages(IDEX_CHECK_VIDEO_FILE);
    }

    private void getModeListUSB(){
        int usbCnt = 0;

        if(rootPathUSB1.length() > 0){
            usbCnt ++;
        }

        if(rootPathUSB2.length() > 0){
            usbCnt ++;
        }

        _iv_storage.setVisibility(View.VISIBLE);
        _iv_storage.setBackgroundResource(R.drawable.m_usb);

        if(usbCnt == 0){
            kog.m("[Main] getModeListUSB no USB");
            _iv_storage.setVisibility(View.GONE);
            _tv_storage.setText(NO_USB);
            _tv_storage.setVisibility(View.VISIBLE);
        }
        else{
            _tv_storage.setVisibility(View.GONE);

            if(mArrDirUSB.size() > 0){
                _iv_storage.setVisibility(View.VISIBLE);
                _iv_storage.setBackgroundResource(R.drawable.m_usb);

                for(int i = 0; i < mArrDirUSB.size(); i++) {
                    FileItem subItem = mArrDirUSB.get(i);
                    mArrDir.add(subItem);
                }

                mAdapterDir.notifyDataSetChanged();

                if(mArrFileUSB.size() > 0){
                    for(int i = 0; i < mArrFileUSB.size(); i++) {
                        FileItem subItem = mArrFileUSB.get(i);
                        if(!USE_VIDEO) {
                            if (subItem.type != MyConstants.TYPE_AUDIO)
                                continue;
                        }
                        mArrFile.add(subItem);
                    }

                    mAdapterFile.notifyDataSetChanged();
                }

                mSelLivsView = mSelListViewUSB;
                mSelListDir = mSelListDirUSB;
                mSelListFile = mSelListFileUSB;

                kog.m("[Main] getModeListUSB mSelLivsView : " + mSelLivsView + "   mSelListDir : " + mSelListDir +
                        "   mSelListFile : " + mSelListFile);

                mListViewDir.setSelectionFromTop(mSelListDir, 1);
                mListViewFile.setSelectionFromTop(mSelListFile, 0);

                //if(!mIsFirstLastPlay) checkLastPlay();
                checkLastPlay();
            }
            else{
                setStorageModeChange(true);
            }

            if(checkExistPlayListDB(rootPathUSB1)){
                if(mArrPlayList.size() > 0){
                    mAdapterPlayList.notifyDataSetChanged();
                }
            }
            /*else{
                kog.m("[Main] getModeListUSB USB delAllPlayListDB");
                delAllPlayListDB(true);
                mArrPlayList.clear();
                mAdapterPlayList.notifyDataSetChanged();
            }*/
        }
    }

    private void getModeListSD(){
        _iv_storage.setVisibility(View.VISIBLE);
        _iv_storage.setBackgroundResource(R.drawable.m_sd);

        if(rootPathSD.length() > 0){
            _tv_storage.setVisibility(View.GONE);

            if(mArrDirSD.size() > 0){
                _iv_storage.setVisibility(View.VISIBLE);
                _iv_storage.setBackgroundResource(R.drawable.m_sd);

                for(int i = 0; i < mArrDirSD.size(); i++) {
                    FileItem subItem = mArrDirSD.get(i);
                    mArrDir.add(subItem);
                }

                mAdapterDir.notifyDataSetChanged();

                if(mArrFileSD.size() > 0){
                    for(int i = 0; i < mArrFileSD.size(); i++) {
                        FileItem subItem = mArrFileSD.get(i);
                        if(!USE_VIDEO) {
                            if (subItem.type != MyConstants.TYPE_AUDIO)
                                continue;
                        }
                        mArrFile.add(subItem);
                    }

                    mAdapterFile.notifyDataSetChanged();
                }

                mSelLivsView = mSelListViewSD;
                mSelListDir = mSelListDirSD;
                mSelListFile = mSelListFileSD;

                kog.m("[Main] getModeListSD mSelLivsView : " + mSelLivsView + "   mSelListDir : " + mSelListDir +
                        "   mSelListFile : " + mSelListFile);

                mListViewDir.setSelectionFromTop(mSelListDir, 1);
                mListViewFile.setSelectionFromTop(mSelListFile, 0);

                //if(!mIsFirstLastPlay) checkLastPlay();
                checkLastPlay();
            }
            else{
                setStorageModeChange(false);
            }

            if(checkExistPlayListDB(rootPathSD)){
                if(mArrPlayList.size() > 0){
                    mAdapterPlayList.notifyDataSetChanged();
                }
            }
            else{
                kog.m("[Main] getModeListSD SD delAllPlayListDB");
                delAllPlayListDB(false);
                mArrPlayList.clear();
                mAdapterPlayList.notifyDataSetChanged();
            }
        }
        else{
            kog.m("[Main] getModeListSD no SD");
            _iv_storage.setVisibility(View.GONE);
            _tv_storage.setText(NO_SD_CARD);
            _tv_storage.setVisibility(View.VISIBLE);
        }
    }

    private void saveModeListUSB_SD(){
        kog.m("[Main] saveModeListUSB_SD mStorageMode : " + mStorageMode);
        if(mStorageMode == MODE_USB){
            mArrDirUSB.clear();
            mArrFileUSB.clear();

            if(mArrDir.size() > 0){
                for(int i = 0; i < mArrDir.size(); i++) {
                    FileItem subItem = mArrDir.get(i);
                    mArrDirUSB.add(subItem);
                }
            }

            if(mArrFile.size() > 0){
                for(int i = 0; i < mArrFile.size(); i++) {
                    FileItem subItem = mArrFile.get(i);
                    if(!USE_VIDEO) {
                        if (subItem.type != MyConstants.TYPE_AUDIO)
                            continue;
                    }
                    mArrFileUSB.add(subItem);
                }
            }
        }
        else if(mStorageMode == MODE_SD){
            mArrDirSD.clear();
            mArrFileSD.clear();

            if(mArrDir.size() > 0){
                for(int i = 0; i < mArrDir.size(); i++) {
                    FileItem subItem = mArrDir.get(i);
                    mArrDirSD.add(subItem);
                }
            }

            if(mArrFile.size() > 0){
                for(int i = 0; i < mArrFile.size(); i++) {
                    FileItem subItem = mArrFile.get(i);
                    if(!USE_VIDEO) {
                        if (subItem.type != MyConstants.TYPE_AUDIO)
                            continue;
                    }
                    mArrFileSD.add(subItem);
                }
            }
        }
    }

    private void saveModeListSelUSB_SD(){
        kog.m("[Main] saveModeListSelUSB_SD mStorageMode : " + mStorageMode);
        if(mStorageMode == MODE_USB){
            mSelListViewUSB = mSelLivsView;
            mSelListDirUSB = mSelListDir;
            mSelListFileUSB = mSelListFile;
        }
        else if(mStorageMode == MODE_SD){
            mSelListViewSD = mSelLivsView;
            mSelListDirSD = mSelListDir;
            mSelListFileSD = mSelListFile;
        }
    }

    private void initModeListSelUSB_SD(boolean isUsb){
        kog.m("[Main] initModeListSelUSB_SD isUsb : " + isUsb);
        if(isUsb){
            mArrDirUSB.clear();
            mArrFileUSB.clear();

            mSelListViewUSB = 0;
            mSelListDirUSB = 0;
            mSelListFileUSB = 0;
        }
        else{
            mArrDirSD.clear();
            mArrFileSD.clear();

            mSelListViewSD = 0;
            mSelListDirSD = 0;
            mSelListFileSD = 0;
        }
    }

    private void setStorageModeChange(boolean isUSB){
        if(isUSB){
            int usbCnt = 0;

            if(rootPathUSB1.length() > 0){
                usbCnt ++;
                setStorageMode(true, 1);
            }

            if(rootPathUSB2.length() > 0){
                usbCnt ++;
                setStorageMode(true, 2);
            }

            _iv_storage.setVisibility(View.VISIBLE);
            _iv_storage.setBackgroundResource(R.drawable.m_usb);

            if(usbCnt == 0){
                _iv_storage.setVisibility(View.GONE);
                _tv_storage.setText(NO_USB);
                _tv_storage.setVisibility(View.VISIBLE);

                mArrPlayList.clear();
                mAdapterPlayList.notifyDataSetChanged();
            }
            else{
                _tv_storage.setVisibility(View.GONE);

                //if(!mIsFirstLastPlay) checkLastPlay();
                checkLastPlay();

                if(mIsFirstLastListUSB){
                    mIsFirstLastListUSB = false;

                    ckeckFirstLastList(true);
                }
            }
        }
        else{
            _iv_storage.setVisibility(View.VISIBLE);
            _iv_storage.setBackgroundResource(R.drawable.m_sd);

            if(rootPathSD.length() > 0){
                _tv_storage.setVisibility(View.GONE);

                setStorageMode(true, 0);

                //if(!mIsFirstLastPlay) checkLastPlay();
                checkLastPlay();

                if(mIsFirstLastListSD){
                    mIsFirstLastListSD = false;

                    ckeckFirstLastList(false);
                }
            }
            else{
                _iv_storage.setVisibility(View.GONE);
                _tv_storage.setText(NO_SD_CARD);
                _tv_storage.setVisibility(View.VISIBLE);

                mArrPlayList.clear();
                mAdapterPlayList.notifyDataSetChanged();
            }
        }
    }

    private void ckeckFirstLastList(boolean isUSB){
        if(mLastPlayPath.length() == 0) return;

        String sLastPath = null;

        if(isUSB){
            int usbCnt = 0, lastUsb = -1;

            if(rootPathUSB1.length() > 0){
                usbCnt ++;

                if(mLastPlayPath.contains(rootPathUSB1)){
                    lastUsb = 0;
                }
            }

            if(rootPathUSB2.length() > 0){
                usbCnt ++;

                if(mLastPlayPath.contains(rootPathUSB2)){
                    lastUsb = 1;
                }
            }

            kog.m("[Main] ckeckFirstLastList mLastPlayPath : " + mLastPlayPath + "   lastUsb : " + lastUsb);

            if(lastUsb < 0) return;

            String[] arrData = mLastPlayPath.split("/");
			/*for (int i = 0; i < arrData.length; i++) {
				kog.m("[Main] ckeckFirstLastList arrData : " + arrData[i]);
			}*/

            if(arrData.length >= 10) return;

            if(usbCnt > 1){
                onSetDirList(lastUsb);
            }
            else{
                onSetDirList(0);
            }

            for (int j = 2; j < (arrData.length - 1); j++) {
                kog.m("[Main] ckeckFirstLastList USB arrData : " + arrData[j]);

                int idx = isExistDir(arrData[j]);
                if(idx > -1){
                    mSelListDir = idx;
                    onSetDirList(mSelListDir);
                }
            }

            mIsFirstLastListUSB = false;

            mListViewDir.setSelectionFromTop(mSelListDir, 1);
            mSelLivsView = 1;

            saveModeListUSB_SD();
            saveModeListSelUSB_SD();
        }
        else{
            if(rootPathSD.length() > 0){
                if(!mLastPlayPath.contains(rootPathSD)) return;

                kog.m("[Main] ckeckFirstLastList mLastPlayPath : " + mLastPlayPath + "   rootPathSD : " + rootPathSD);

                String[] arrData = mLastPlayPath.split("/");

                if(arrData.length >= 10) return;

                onSetDirList(0);

                for (int j = 2; j < (arrData.length - 1); j++) {
                    kog.m("[Main] ckeckFirstLastList SD arrData : " + arrData[j]);

                    int idx = isExistDir(arrData[j]);
                    if(idx > -1){
                        mSelListDir = idx;
                        onSetDirList(mSelListDir);
                    }
                }

                mIsFirstLastListSD = false;

                mListViewDir.setSelectionFromTop(mSelListDir, 1);
                mSelLivsView = 1;

                saveModeListUSB_SD();
                saveModeListSelUSB_SD();
            }
        }
    }

    private int isExistDir(String val){
        int idx = -1;
        for (int i = 0; i < mArrDir.size(); i++) {
            FileItem item = mArrDir.get(i);

            kog.m("[Main] isExistDir item.name : " + item.name + "   val : " + val);

            if(item.name.equals(val)){
                idx = i;
                kog.m("[Main] isExistDir idx : " + idx);
                break;
            }
        }

        return idx;
    }

    private void onListPlay(int time){
        if(mIsListPlay) return;

        mIsListPlay = true;

        mLastPlayMode = -1;

        if(mStorageMode == MODE_USB){
            mLastPlayPathParrent = PreferenceUtil.getLastPlayFilePathParrent_USB();
            mLastPlayPath = PreferenceUtil.getLastPlayFilePath_USB();
            mLastPlayMode = PreferenceUtil.getLastPlaySaveMode_USB();
        }
        else if(mStorageMode == MODE_SD){
            mLastPlayPathParrent = PreferenceUtil.getLastPlayFilePathParrent_SD();
            mLastPlayPath = PreferenceUtil.getLastPlayFilePath_SD();
            mLastPlayMode = PreferenceUtil.getLastPlaySaveMode_SD();
        }

        mLastPlayListMode = PreferenceUtil.getPlayListMode();

        kog.m("[Main] onListPlay getLastPlayFilePathParrent : " + mLastPlayPathParrent +
                "   getLastPlayFilePath : " + mLastPlayPath + "   mLastPlayMode : " + mLastPlayMode +
                "   mLastPlayListMode : " + mLastPlayListMode + "   time : " + time);

        if(mLastPlayPath.length() == 0){
            MyConstants.g_IsLastPlay = false;
            return;
        }

        if(!Function.isFileExist(mLastPlayPath)){
            kog.m("[Main] checkLastPlay isFileExist false : " + mLastPlayPath);
            MyConstants.g_IsLastPlay = false;
            _rl_aux_bg.setVisibility(View.GONE);
            Function.toast(this, "재생할 파일이 없습니다.");
            return;
        }

		_tv_aux_msg.setText("");
        _tv_video_file_name.setText("");
        _rl_aux_bg.setVisibility(View.VISIBLE);

        mHandler.sendEmptyMessageDelayed(IDEX_LAST_PLAY, time);
    }

    private void checkLastPlay(){
        mLastPlayMode = -1;
        _rl_aux_bg.setVisibility(View.VISIBLE);

        if(mStorageMode == MODE_USB){
            mLastPlayPathParrent = PreferenceUtil.getLastPlayFilePathParrent_USB();
            mLastPlayPath = PreferenceUtil.getLastPlayFilePath_USB();
            mLastPlayMode = PreferenceUtil.getLastPlaySaveMode_USB();
        }
        else if(mStorageMode == MODE_SD){
            mLastPlayPathParrent = PreferenceUtil.getLastPlayFilePathParrent_SD();
            mLastPlayPath = PreferenceUtil.getLastPlayFilePath_SD();
            mLastPlayMode = PreferenceUtil.getLastPlaySaveMode_SD();
        }

        mLastPlayListMode = PreferenceUtil.getPlayListMode();

        kog.m("[Main] checkLastPlay getLastPlayFilePathParrent : " + mLastPlayPathParrent +
                "   getLastPlayFilePath : " + mLastPlayPath + "   mLastPlayMode : " + mLastPlayMode + "   mLastPlayListMode : " + mLastPlayListMode);

        if(mLastPlayPath.length() == 0){
            MyConstants.g_IsLastPlay = false;
            _rl_aux_bg.setVisibility(View.GONE);
            return;
        }

        if(!Function.isFileExist(mLastPlayPath)){
            kog.m("[Main] checkLastPlay isFileExist false : " + mLastPlayPath);
            MyConstants.g_IsLastPlay = false;
            _rl_aux_bg.setVisibility(View.GONE);
            //Function.toast(this, "재생할 파일이 없습니다.");
            return;
        }

        if(mLastPlayMode == MyConstants.MODE_PLAY_IMAGE){
            _rl_aux_bg.setVisibility(View.GONE);
            return;
        }

        mHandler.sendEmptyMessageDelayed(IDEX_LAST_PLAY, TIME_LAST_PLAY);
    }

    private void setAuxMode(){
        _tv_aux_msg.setText("HDMI로는 외부입력이 나타나지 않습니다.");
        _rl_aux_bg.setVisibility(View.VISIBLE);
    }

    private void checkStorageMode(){
        kog.m("[Main] checkStorageMode : " + mStorageMode);
        if(mStorageMode == MODE_USB){
            _iv_storage.setBackgroundResource(R.drawable.m_usb);
            _tv_storage.setText(NO_USB);
        }
        else if(mStorageMode == MODE_SD){
            _iv_storage.setBackgroundResource(R.drawable.m_sd);
            _tv_storage.setText(NO_SD_CARD);
        }
        else if(mStorageMode == MODE_AUX){
            setAuxMode();
        }
        _iv_storage.setVisibility(View.VISIBLE);
        _tv_storage.setVisibility(View.VISIBLE);
    }

    private String getMountName(String path){
        String[] arrData = path.split("/");

        String name = arrData[2];
        kog.m("getMountName name : " + name);
        return name;
    }

    private void clearPlayList(){
        if(!mIsExistPlayList){
            mArrPlayList.clear();
            mAdapterPlayList.notifyDataSetChanged();
        }
    }

    private void checkExistMountPath(){
        kog.m("[Main] checkExistMountPath mMountType : " + mMountType);
        String apkPath = mMountPath + "/DVX15000.apk";
        File apkFile = new File(apkPath);

        if(apkFile.exists()){
            if(apkFile.length() > 0){
                kog.m("checkExistMountPath apkPath : " + apkPath);
                sendMsgFinish();

                _tv_aux_msg.setText("업데이트 중입니다. \nUSB 메모리나 SDCard를 제거하지 마세요.");
                _rl_aux_bg.setVisibility(View.VISIBLE);

                Intent iInstall = new Intent("MSG_VLC_INSTALL");
                iInstall.putExtra("Path", apkPath);
                sendBroadcast(iInstall);
                return;
            }
        }

        String apkPathM = mMountPath + "/DVX15000M.apk";
        File apkFileM = new File(apkPathM);

        if(apkFileM.exists()){
            if(apkFileM.length() > 0){
                kog.m("checkExistMountPath apkPathM : " + apkPathM);
                sendMsgFinish();

                _tv_aux_msg.setText("업데이트 중입니다. \nUSB 메모리나 SDCard를 제거하지 마세요.");
                _rl_aux_bg.setVisibility(View.VISIBLE);

                Intent iInstall = new Intent("MSG_VLC_INSTALL");
                iInstall.putExtra("Path", apkPathM);
                sendBroadcast(iInstall);
                return;
            }
        }

        if(mMountType.equals("usb")){
            if(rootPathUSB1.equals(mMountPath)){
                return;
            }

            if(rootPathUSB2.equals(mMountPath)){
                return;
            }

            checkMountPath(true);
        }
        else if(mMountType.equals("sdcard")){
            if(rootPathSD.equals(mMountPath)){
                return;
            }

            checkMountPath(true);
        }
    }

    private void checkMountPath(boolean isMount){
        kog.m("[Main] checkMountPath isMount : " + isMount);
        if(isMount){
            if(mMountType.equals("usb")){
                if(rootPathUSB1.length() == 0){
                    rootPathUSB1 = mMountPath;

                    kog.m("[Main] checkMountPath rootPathUSB1 : " + rootPathUSB1);

                    if(mStorageMode == MODE_USB){
                        setStorageMode(true, 1);

                        if(!mIsListShow) checkLastPlay();

                        if(mIsFirstLastListUSB){
                            ckeckFirstLastList(true);
                        }

                        if(checkExistPlayListDB(rootPathUSB1)){
                            kog.m("[Main] checkMountPath USB1 checkExistPlayListDB true");

                            if(mArrPlayList.size() > 0){
                                mAdapterPlayList.notifyDataSetChanged();
                            }

                            mIsExistPlayList = true;
                        }
                        else{
                            kog.m("[Main] checkMountPath USB1 checkExistPlayListDB false");

                            clearPlayList();
                        }
                    }
                }
                else if(rootPathUSB2.length() == 0){
                    rootPathUSB2 = mMountPath;

                    kog.m("[Main] checkMountPath rootPathUSB2 : " + rootPathUSB2);

                    if(mStorageMode == MODE_USB){
                        setStorageMode(true, 2);

                        if(!mIsListShow) checkLastPlay();

                        if(mIsFirstLastListUSB){
                            ckeckFirstLastList(true);
                        }

                        if(checkExistPlayListDB(rootPathUSB2)){
                            kog.m("[Main] checkMountPath USB2 checkExistPlayListDB");

                            //mHandler.removeMessages(IDEX_CHECK_MOUNT_USB);

                            if(mArrPlayList.size() > 0){
                                mAdapterPlayList.notifyDataSetChanged();
                            }
                        }
                        else{
                            kog.m("[Main] checkMountPath USB2 checkExistPlayListDB false");

                            clearPlayList();
                        }
                    }
                }
            }
            else if(mMountType.equals("sdcard")){
                rootPathSD = mMountPath;

                kog.m("[Main] checkMountPath rootPathSD : " + rootPathSD);

                if(mStorageMode == MODE_SD){
                    setStorageMode(true, 0);

                    checkLastPlay();

                    if(mIsFirstLastListSD){
                        ckeckFirstLastList(false);
                    }

                    if(checkExistPlayListDB(rootPathSD)){
                        kog.m("[Main] checkMountPath SD checkExistPlayListDB true");

                        if(mArrPlayList.size() > 0){
                            mAdapterPlayList.notifyDataSetChanged();
                        }
                    }
                    else{
                        kog.m("[Main] checkMountPath SD checkExistPlayListDB false");

                        clearPlayList();
                    }
                }
            }
        }
        else{
            kog.m("[Main] checkMountPath false mMountPath : " + mMountPath);
            kog.m("[Main] checkMountPath false rootPathUSB1 : " + rootPathUSB1 + "   rootPathUSB2 : " + rootPathUSB2);
            kog.m("[Main] checkMountPath false mPlayMode : " + mPlayMode);
            kog.m("[Main] checkMountPath false g_CurrPlayFilePath : " + MyConstants.g_CurrPlayFilePath);

            if(mIsFirstBoot){
                if(mStorageMode == MODE_USB){
                    onRemoconMode(DefineRemocon.usb);
                }
                else if(mStorageMode == MODE_SD){
                    onRemoconMode(DefineRemocon.sd);
                }
                return;
            }

            if(mStorageMode == MODE_AUX){
                kog.m("[Main] checkMountPath mStorageMode MODE_AUX");
                clearAllData();
                return;
            }

            if(mPlayMode == MyConstants.MODE_PLAY_IMAGE){
                kog.m("[Main] checkMountPath false MyConstants.g_SelImageFile : " + MyConstants.g_SelImageFile);
                if(MyConstants.g_SelImageFile.contains(mMountPath)){
                    sendMsgFinish();
                }
            }

            stopCheckVideFile();

            /*if(mStorageMode == MODE_USB){
                _iv_storage.setVisibility(View.GONE);
                _tv_storage.setText("USB 메모리가 없습니다.");
                _tv_storage.setVisibility(View.VISIBLE);
            }
            else if(mStorageMode == MODE_SD){
                _iv_storage.setVisibility(View.GONE);
                _tv_storage.setText("SD Card가 없습니다.");
                _tv_storage.setVisibility(View.VISIBLE);
            }*/

            if(rootPathUSB1.length() > 0){
                if(rootPathUSB1.equals(mMountPath)){
                    rootPathUSB1 = "";

                    if(mStorageMode == MODE_USB){
                        setStorageMode(false, 0);
                    }

                    initModeListSelUSB_SD(true);

                    clearAllData();

					/*delAllPlayListDB(true);

					if(mStorageMode == MODE_USB){
						mSelListPlayList = 0;
						mArrPlayList.clear();
						mAdapterPlayList.notifyDataSetChanged();
					}*/
                }
            }

            if(rootPathUSB2.length() > 0){
                if(rootPathUSB2.equals(mMountPath)){
                    rootPathUSB2 = "";

                    if(mStorageMode == MODE_USB){
                        setStorageMode(false, 0);
                    }

                    initModeListSelUSB_SD(true);

                    clearAllData();

					/*delAllPlayListDB(true);

					if(mStorageMode == MODE_USB){
						mSelListPlayList = 0;
						mArrPlayList.clear();
						mAdapterPlayList.notifyDataSetChanged();
					}*/
                }
            }

            if(rootPathSD.length() > 0){
                if(rootPathSD.equals(mMountPath)){
                    rootPathSD = "";

                    if(mStorageMode == MODE_SD){
                        setStorageMode(false, 0);
                    }

                    initModeListSelUSB_SD(false);

                    clearAllData();

					/*delAllPlayListDB(false);

					if(mStorageMode == MODE_SD){
						mSelListPlayList = 0;
						mArrPlayList.clear();
						mAdapterPlayList.notifyDataSetChanged();
					}*/
                }
            }
        }
    }

    private void clearAllData(){
        /*if(getDelPlayListDB(true)){
            delAllPlayListDB(true);
        }

        if(getDelPlayListDB(false)){
            delAllPlayListDB(false);
        }*/

		/*if(PreferenceUtil.getPlayListMode() == 1){
		if(mStorageMode == MODE_USB){
			PreferenceUtil.saveLastPlayFilePath_USB("");
			PreferenceUtil.saveLastPlayFilePathParrent_USB("");
			PreferenceUtil.saveLastPlaySaveMode_USB(-1);
		}
		else if(mStorageMode == MODE_SD){
			PreferenceUtil.saveLastPlayFilePath_SD("");
			PreferenceUtil.saveLastPlayFilePathParrent_SD("");
			PreferenceUtil.saveLastPlaySaveMode_SD(-1);
		}

		PreferenceUtil.savePlayListMode(0);
		}*/

        /*PreferenceUtil.saveLastPlayFilePath_USB("");
        PreferenceUtil.saveLastPlayFilePathParrent_USB("");
        PreferenceUtil.saveLastPlaySaveMode_USB(-1);
        PreferenceUtil.saveLastPlayFilePath_SD("");
        PreferenceUtil.saveLastPlayFilePathParrent_SD("");
        PreferenceUtil.saveLastPlaySaveMode_SD(-1);
        PreferenceUtil.savePlayListMode(0);*/

        mSelListPlayList = 0;
        mArrPlayList.clear();

        mAdapterPlayList.notifyDataSetChanged();

        mIsExistPlayList = false;

        kog.m("[Main] clearAllData...");
    }

    private void setStorageMode(boolean isMount, int usb){
        _tv_storage.setVisibility(View.GONE);
        //_iv_storage.setVisibility(View.GONE);
        kog.m("[Main] setStorageMode mStorageMode : " + mStorageMode);

        int usbDiskCnt = 0;
        if(isMount) {
            if(mStorageMode == MODE_USB){
                if(usb == 1){
                    if(rootPathUSB1.length() > 0){
                        if(Function.isFileExist(rootPathUSB1)){
                            mCurrentDir = new File(rootPathUSB1);

                            //if(setUSBDirList(getMountName(rootPathUSB1), rootPathUSB1)) {
                            if(setUSBDirList("하드디스크 1", rootPathUSB1, isMount)) {
                                _iv_storage.setVisibility(View.VISIBLE);
                                _iv_storage.setBackgroundResource(R.drawable.m_usb);

                                usbDiskCnt++;
                            }
                        }
                    }
                }
                else if(usb == 2){
                    if(rootPathUSB2.length() > 0){
                        if(Function.isFileExist(rootPathUSB2)){
                            mCurrentDir = new File(rootPathUSB2);

                            //if(setUSBDirList(getMountName(rootPathUSB2), rootPathUSB2)) {
                            if(setUSBDirList("하드디스크 2", rootPathUSB2, isMount)) {
                                _iv_storage.setVisibility(View.VISIBLE);
                                _iv_storage.setBackgroundResource(R.drawable.m_usb);

                                usbDiskCnt++;
                            }
                        }
                    }
                }

                if(usbDiskCnt == 0){
                    _tv_storage.setText(NO_USB);
                    _tv_storage.setVisibility(View.VISIBLE);
                    sendMsgFinish();
                    _rl_aux_bg.setVisibility(View.GONE);
                }
                else{
					/*if(mIsFirstLastPlay){
						mIsFirstLastPlay = false;
						checkLastPlay();
					}*/
                }
            }
            else if(mStorageMode == MODE_SD){
                if(rootPathSD.length() > 0){
                    if(setSDDirList("SD Card", rootPathSD)) {
                        _iv_storage.setVisibility(View.VISIBLE);
                        _iv_storage.setBackgroundResource(R.drawable.m_sd);

						/*if(mIsFirstLastPlay){
							mIsFirstLastPlay = false;
							checkLastPlay();
						}*/
                    }
                }
                else {
                    _iv_storage.setVisibility(View.GONE);
                    _tv_storage.setText(NO_SD_CARD);
                    _tv_storage.setVisibility(View.VISIBLE);
                    sendMsgFinish();
                    _rl_aux_bg.setVisibility(View.GONE);
                }
            }
        }
        else{
            //sendMsgFinish();
            _rl_aux_bg.setVisibility(View.GONE);

            mArrDir.clear();
            mArrFile.clear();

            mAdapterDir.notifyDataSetChanged();
            mAdapterFile.notifyDataSetChanged();

            if(mStorageMode == MODE_USB) {
                if(rootPathUSB1.length() > 0){
                    if(Function.isFileExist(rootPathUSB1)){
                        mCurrentDir = new File(rootPathUSB1);

                        //if(setUSBDirList(getMountName(rootPathUSB1), rootPathUSB1)) {
                        if(setUSBDirList("하드디스크 1", rootPathUSB1, isMount)) {
                            _iv_storage.setVisibility(View.VISIBLE);
                            _iv_storage.setBackgroundResource(R.drawable.m_usb);

                            usbDiskCnt++;
                        }
                    }
                }

                if(rootPathUSB2.length() > 0){
                    if(Function.isFileExist(rootPathUSB2)){
                        mCurrentDir = new File(rootPathUSB2);

                        //if(setUSBDirList(getMountName(rootPathUSB2), rootPathUSB2)) {
                        if(setUSBDirList("하드디스크 2", rootPathUSB2, isMount)) {
                            _iv_storage.setVisibility(View.VISIBLE);
                            _iv_storage.setBackgroundResource(R.drawable.m_usb);

                            usbDiskCnt++;
                        }
                    }
                }

                if(usbDiskCnt == 0){
                    _iv_storage.setVisibility(View.GONE);
                    _tv_storage.setText(NO_USB);
                    _tv_storage.setVisibility(View.VISIBLE);
                }
            }
            else if(mStorageMode == MODE_SD) {
                if(rootPathSD.length() > 0){
                    if(setSDDirList("SD Card", rootPathSD)) {
                        _iv_storage.setVisibility(View.VISIBLE);
                        _iv_storage.setBackgroundResource(R.drawable.m_sd);
                    }
                }
                else {
                    _iv_storage.setVisibility(View.GONE);
                    _tv_storage.setText(NO_SD_CARD);
                    _tv_storage.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    private boolean checkExistPlayListDB(String path){
        boolean ret = false;
        if(getPlayListDB()){
            for( int i = 0 ; i< mArrPlayList.size() ; i ++){
                PlayListItem item = (PlayListItem) mArrPlayList.get(i);

                if(item.pl_path.contains(path)){
                    kog.m("[Main] checkExistPlayListDB path : " + path + "   pl_path : " + item.pl_path);
                    ret = true;
                    break;
                }
            }
        }

        return ret;
    }

    private boolean getDelPlayListDB(boolean isUsb){
        kog.m("[Main] getDelPlayListDB isUsb : " + isUsb);

        if(mArrPlayList != null){
            mArrPlayList.clear();
        }

        ContentResolver cr = this.getContentResolver();
        if(isUsb){
            mstrProjection = PlayListProvider.strTablePlayList_USB;
        }
        else{
            mstrProjection = PlayListProvider.strTablePlayList_SD;
        }

        mPlayListDB = cr.query(
                PlayListProvider.CONTENT_URI,
                mstrProjection,
                null, //QueryString
                null, //SelectionArg
                null); //sortOrder

        if(mPlayListDB == null){
            kog.m("[Main] getDelPlayListDB mPlayListDB null");
            return false;
        }

        if(mPlayListDB.getCount() == 0){
            kog.m("[Main] getDelPlayListDB mPlayListDB getCount 0");
            mPlayListDB.close();
            return false;
        }

        mPlayListDB.moveToFirst();
        int count = mPlayListDB.getCount();

        for(int i = 0; i < count; i++) {
            PlayListItem item = new PlayListItem();
            item.key_id = mPlayListDB.getInt(0);
            item.pl_path = mPlayListDB.getString(1);
            item.pl_name = mPlayListDB.getString(2);
            item.pl_type = mPlayListDB.getString(3);
            item.pl_etc_1 = mPlayListDB.getString(4);
            item.pl_etc_2 = mPlayListDB.getString(5);
            item.pl_etc_3 = mPlayListDB.getString(6);
            item.pl_etc_4 = mPlayListDB.getString(7);
            item.pl_etc_5 = mPlayListDB.getString(8);

            if(!USE_VIDEO) {
                if (Integer.parseInt(item.pl_type) != MyConstants.TYPE_AUDIO) {
                    mPlayListDB.moveToNext();
                    continue;
                }
            }
			// add fav to last pos
            //mArrPlayList.add(0, item);
            mArrPlayList.add(item);
            kog.m("[Main] getDelPlayListDB item.pl_path : " + item.pl_path);

            mPlayListDB.moveToNext();
        }
        mPlayListDB.close();

        return true;
    }

    private boolean getPlayListDB(){
        if(mArrPlayList != null){
            mArrPlayList.clear();
            mAdapterPlayList.notifyDataSetChanged();
        }

        kog.m("[Main] getPlayListDB mStorageMode : " + mStorageMode);

        ContentResolver cr = this.getContentResolver();
        if(mStorageMode == MODE_USB){
            mstrProjection = PlayListProvider.strTablePlayList_USB;
        }
        else if(mStorageMode == MODE_SD){
            mstrProjection = PlayListProvider.strTablePlayList_SD;
        }

        mPlayListDB = cr.query(
                PlayListProvider.CONTENT_URI,
                mstrProjection,
                null, //QueryString
                null, //SelectionArg
                null); //sortOrder

        if(mPlayListDB == null){
            return false;
        }

        if(mPlayListDB.getCount() == 0){
            mPlayListDB.close();
            return false;
        }

        mPlayListDB.moveToFirst();
        int count = mPlayListDB.getCount();

        for(int i = 0; i < count; i++) {
            PlayListItem item = new PlayListItem();
            item.key_id = mPlayListDB.getInt(0);
            item.pl_path = mPlayListDB.getString(1);
            item.pl_name = mPlayListDB.getString(2);
            item.pl_type = mPlayListDB.getString(3);
            item.pl_etc_1 = mPlayListDB.getString(4);
            item.pl_etc_2 = mPlayListDB.getString(5);
            item.pl_etc_3 = mPlayListDB.getString(6);
            item.pl_etc_4 = mPlayListDB.getString(7);
            item.pl_etc_5 = mPlayListDB.getString(8);

            if(!USE_VIDEO) {
                if (Integer.parseInt(item.pl_type) != MyConstants.TYPE_AUDIO) {
                    mPlayListDB.moveToNext();
                    continue;
                }
            }
			// add fav to last pos
            //mArrPlayList.add(0, item);
            mArrPlayList.add(item);
            kog.m("[Main] getPlayListDB mArrPlayList item.pl_path : " + item.pl_path);

            mPlayListDB.moveToNext();
        }
        mPlayListDB.close();

        return true;
    }

    private boolean insertPlayListDB(){
        ContentValues values = new ContentValues();
        ContentResolver cr = this.getContentResolver();

        kog.m("[Main] insertPlayListDB mStorageMode : " + mStorageMode);

        if(mStorageMode == MODE_USB){
            values = PlayListProvider.insertDataPlayList_USB(values, mInsertPlayListItem);
        }
        else if(mStorageMode == MODE_SD){
            values = PlayListProvider.insertDataPlayList_SD(values, mInsertPlayListItem);
        }

        kog.m("[Main] insertPlayListDB mInsertPlayListItem : " + mInsertPlayListItem.pl_path);

        cr.insert(PlayListProvider.CONTENT_URI, values);

        if(mStorageMode == MODE_USB){
            mstrProjection = PlayListProvider.strTablePlayList_USB;
        }
        else if(mStorageMode == MODE_SD){
            mstrProjection = PlayListProvider.strTablePlayList_SD;
        }
        mPlayListDB = cr.query(
                PlayListProvider.CONTENT_URI,
                mstrProjection,
                null, //QueryString
                null, //SelectionArg
                null); //sortOrder

        if(mPlayListDB == null || mPlayListDB.getCount() == 0){
            mPlayListDB.close();
            return false;
        }

        mPlayListDB.moveToLast();
        mPlayListDB.close();

        return true;
    }

    private void delAllPlayListDB(boolean isUsb){
        kog.m("[Main] delAllPlayListDB isUsb : " + isUsb);

        if(mArrPlayList.size() == 0) return;

        kog.m("[Main] delAllPlayListDB size : " + mArrPlayList.size());

        for( int i = 0 ; i< mArrPlayList.size() ; i ++){
            PlayListItem item = (PlayListItem) mArrPlayList.get(i);
            mDelKeyID = item.key_id;
            delPlayListDB(isUsb);
        }
    }

    private void delPlayListDB(boolean isUsb){
        ContentResolver cr = this.getContentResolver();
        String arg = null;
        if(isUsb){
            arg = PlayListProvider.pl_USB_KEY_ID + " = " + mDelKeyID;
            cr.delete(PlayListProvider.CONTENT_URI, arg, argTableUSB);
        }
        else{
            arg = PlayListProvider.pl_SD_KEY_ID + " = " + mDelKeyID;
            cr.delete(PlayListProvider.CONTENT_URI, arg, argTableSD);
        }
    }

    private void sendMsgVlcStart(){
        Intent intent = new Intent("org.videolan.vlc.start");
        sendBroadcast(intent);
    }

    private void sendMsgFinish(){
        kog.m("[Main] sendMsgFinish");
        Intent intent = new Intent("MSG_FINISH");
        sendBroadcast(intent);
    }

    private void sendMsgLiveVLC(){
        Intent intent = new Intent("MSG_VLC_LIVE");
        sendBroadcast(intent);
    }

    private void sendMsgLauncher(){
        Intent intent = new Intent("MSG_VLC_LAUNCHER");
        sendBroadcast(intent);
    }

    private void initModeDir(){
        mSelLivsView = mSelListDir = mSelListFile = 0;

        mArrDir.clear();
        mArrFile.clear();
        mArrPlayList.clear();

        mAdapterPlayList.notifyDataSetChanged();
        mAdapterDir.notifyDataSetChanged();
        mAdapterFile.notifyDataSetChanged();
    }

    private void refreshListView(){
        if(mSelLivsView == 0){
            mAdapterDir.notifyDataSetChanged();
            mListViewDir.setSelectionFromTop(mSelListDir, 1);
        }
        else if(mSelLivsView == 1){
            mAdapterFile.notifyDataSetChanged();
            mListViewFile.setSelection(mSelListFile);
            //mListViewFile.setSelectionFromTop(mSelListFile, 0);
        }
        else if(mSelLivsView == 2){
            mAdapterPlayList.notifyDataSetChanged();
            mListViewPlayList.setSelection(mSelListPlayList);
        }
    }

    private boolean checkPlayListItem(String path){
        boolean ret = false;
        if(getPlayListDB()){
            for( int i = 0 ; i< mArrPlayList.size() ; i ++){
                PlayListItem item = (PlayListItem) mArrPlayList.get(i);

                if(item.pl_path.equals(path)){
                    mDelKeyID = item.key_id;
                    ret = true;
                    break;
                }
            }
        }

        return ret;
    }

    private void initDirListVal(){
        for(int i = 0; i < mArrDir.size(); i++) {
            FileItem subItem = mArrDir.get(i);

            subItem.isSelect = false;
        }

        mSelListFile = 0;
    }

    private void initFileListVal(){
        for(int i = 0; i < mArrFile.size(); i++) {
            FileItem subItem = mArrFile.get(i);

            subItem.isSelect = false;
        }
    }

    private boolean setSDDirList(String name, String path){
        kog.m("[Main] setSDDirList path : " + path);
        mSelLivsView = mSelListDir = mSelListFile = 0;

        File fileDir = new File(path);
        File[] dirs = fileDir.listFiles();

        if(dirs == null){
            kog.m("setSDDirList dirs null");
            return false;
        }

        int dirCnt = dirs.length;
        kog.m("[Main] setSDDirList dirs : " + dirCnt);
        if(dirCnt == 0){
            return false;
        }

        FileItem item = new FileItem();
        item.name = name;
        item.type = MyConstants.TYPE_ROOT_DIR;
        item.fileCnt = 1;
        item.path = path;
        item.path_parrent = path;
        //item.isVisble = true;

        mArrDir.add(item);

        mAdapterDir.notifyDataSetChanged();

        return true;
    }

    private boolean setUSBDirList(String name, String path, boolean isMount){
        kog.m("[Main] setUSBDirList path : " + path);

        if(isMount){
            if(rootPathUSB1.length() > 0){
            }
            else if(rootPathUSB2.length() > 0){
            }
            else{
                mSelLivsView = mSelListDir = mSelListFile = 0;
            }
        }
        else{
            mSelLivsView = mSelListDir = mSelListFile = 0;
        }

        File fileDir = new File(path);
        File[] dirs = fileDir.listFiles();

        if(dirs == null){
            kog.m("[Main] setUSBDirList dirs null");
            //Function.hideProg();
            return false;
        }

        int dirCnt = dirs.length;
        kog.m("[Main] setUSBDirList dirs : " + dirCnt);
        if(dirCnt == 0){
            //Function.hideProg();
            return false;
        }

        FileItem item = new FileItem();
        item.name = name;
        item.type = MyConstants.TYPE_ROOT_DIR;
        item.fileCnt = 1;
        item.path = path;
        item.path_parrent = path;
        //item.isVisble = true;

        mArrDir.add(item);

        mAdapterDir.notifyDataSetChanged();

        //Function.hideProg();
        return true;
    }

    private void onSetDirList(int pos){
        //kog.m("[Main] onSetDirList pos : " + pos);
        if(pos < 0) return;
        if(mArrDir.size() == 0) return;

        FileItem item = mArrDir.get(pos);
        kog.m("[Main] onSetDirList item.path : " + item.path);
        //if(item.fileCnt == 0) return;

        //kog.m("[Main] onSetDirList pos : " + pos + "   isVisble : " + item.isVisble);
        initDirListVal();

        if(item.isVisble){
            item.isVisble = false;

            if(item.type == MyConstants.TYPE_ROOT_DIR){
                setStorageMode(false, 0);
                return;
            }

            int count = mArrDir.size();
            int delList[] = new int[count];

            for(int i = 0; i < count; i++) {
                FileItem subItem = mArrDir.get(i);
                kog.m("[Main] onSetDirList subItem.path_parrent : " + subItem.path_parrent);

                //if(item.path.equals(subItem.path_parrent)){
                if(subItem.path_parrent.contains(item.path)){
                    delList[i] = i;
                }
                else
                    delList[i] = -1;
            }

            for(int i = count-1; i >= 0; i--) {
                if(delList[i] != -1){
                    mArrDir.remove(delList[i]);
                }
            }

            mAdapterDir.notifyDataSetChanged();
        }
        else{
            item.isSelect = true;

            mArrFile.clear();

            mCurrentDir = new File(item.path);
            if(setDirList(mCurrentDir, item.index + 1, pos)){
                item.isVisble = true;
            }
            else{
                item.isVisble = false;
            }
        }
    }

    private void onAddPlayList(int pos){
        if(pos < 0) return;

        FileItem item = mArrFile.get(pos);
        item.isSelect = true;

        mAdapterFile.notifyDataSetChanged();

        if(checkPlayListItem(item.path)){
            //delPlayListDB();
            //getPlayListDB();
        }
        else{
            mInsertPlayListItem.pl_path = item.path;
            mInsertPlayListItem.pl_name = item.name;
            mInsertPlayListItem.pl_type = String.valueOf(item.type);

            if(insertPlayListDB()){
                getPlayListDB();
            }
        }
    }

    private void setVideoFileList(String pathParrent, String path){
        kog.m("[Main] setVideoFileList path : " + pathParrent);
        File fileAudio = new File(pathParrent);
        mArrVideoFile.clear();

        FileItem item = null;
        File[] dirs = fileAudio.listFiles();

        List<FileItem> fls = new ArrayList<FileItem>();
        try{
            for(File ff: dirs){
                if(!ff.isHidden()){
                    item = new FileItem();

                    if(!ff.isDirectory()){
                        int type = Function.defineType(ff.getName());

                        kog.m("[Main] setVideoFileList getName : " + ff.getName() + "   type : " + type);
                        if(type == MyConstants.TYPE_VIDEO){
                            item.name = ff.getName();
                            item.type = MyConstants.TYPE_VIDEO;
                            item.path = ff.getAbsolutePath();
                            item.path_parrent = pathParrent;

                            mArrVideoFile.add(item);
                        }
                    }
                }
            }
        }
        catch(Exception e){
        }

        Collections.sort(mArrVideoFile);

        for(int i = 0; i < mArrVideoFile.size(); i++) {
            FileItem subItem = mArrVideoFile.get(i);

            if(subItem.path.equals(path)){
                MyConstants.g_CurrPlayFilePath = subItem.path;
                kog.m("[Main] setVideoFileList g_CurrPlayFilePath : " + MyConstants.g_CurrPlayFilePath);

                mIdxPlayVideoFile = i;
                break;
            }
        }
    }

    private void onVideoPlayMode(){
        if(mArrVideoFile.size() == 0) return;

        mIsRemoconControl = false;

        _tv_aux_msg.setText("");
        _tv_video_file_name.setText("");
        _rl_aux_bg.setVisibility(View.VISIBLE);
        sendMsgFinish();

        if(mMsgPlayMode == MODE_VIDEO_PLAY_NEXT){
            mIdxPlayVideoFile ++;

            if(mIdxPlayVideoFile == mArrVideoFile.size()){
                mIdxPlayVideoFile = 0;
            }
        }
        else if(mMsgPlayMode == MODE_VIDEO_PLAY_PREV){
            mIdxPlayVideoFile --;

            if(mIdxPlayVideoFile < 0){
                mIdxPlayVideoFile = mArrVideoFile.size() - 1;
            }
        }
        else if(mMsgPlayMode == MODE_VIDEO_PLAY_ONE){

        }

        final FileItem item = mArrVideoFile.get(mIdxPlayVideoFile);
        mVideoPlayModePath = item.path;
        mVideoPlayModePathParrent = item.path_parrent;

        kog.m("[Main] onVideoPlayMode mVideoPlayModePath : " + mVideoPlayModePath);

		if(checkVideFile(mVideoPlayModePath, item.name)){
            mHandler.sendEmptyMessageDelayed(IDEX_VIDEO_PLAY_MODE, DELAY_PLAY_TIME);
        }
    }

    private void saveLastPlayValue(String path, String pathParrent, int mode){
        if(mStorageMode == MODE_USB){
            PreferenceUtil.saveLastPlayFilePath_USB(path);
            PreferenceUtil.saveLastPlayFilePathParrent_USB(pathParrent);
            PreferenceUtil.saveLastPlaySaveMode_USB(mode);
        }
        else if(mStorageMode == MODE_SD){
            PreferenceUtil.saveLastPlayFilePath_SD(path);
            PreferenceUtil.saveLastPlayFilePathParrent_SD(pathParrent);
            PreferenceUtil.saveLastPlaySaveMode_SD(mode);
        }
    }

    private int getVideoTrack(String path){
        MyConstants.g_VideoPlayInfo = "";
        MyConstants.g_VideoPlayErr = -1;

        LibVLC libVlc = VLCInstanceJava.get(this);
        if (libVlc == null)
            return MyConstants.CHECK_VIDEO_TRACK_FAIL;

        Media media = null;
        media = new Media(libVlc, path);

        if(media == null){
            return MyConstants.CHECK_VIDEO_TRACK_FAIL;
        }

        media.parse();

        Media.VideoTrack vTrack = null;
        Media.AudioTrack aTrack = null;
        int trackCount = media.getTrackCount();
        for (int i = 0; i < trackCount; ++i) {
            final Media.Track track = media.getTrack(i);
            if (track.type == Media.Track.Type.Video) {
                vTrack = (Media.VideoTrack) track;
            }

            if (track.type == Media.Track.Type.Audio) {
                aTrack = (Media.AudioTrack) track;
            }
        }

        if(vTrack == null){
            if(media != null) media.release();
            return MyConstants.CHECK_VIDEO_TRACK_FAIL;
        }

        kog.m("[Main] getVideoTrack codec : " + vTrack.codec + "   originalCodec : " + vTrack.originalCodec);

        kog.m("[Main] getVideoTrack bitrate : " + vTrack.bitrate + "   profile : " + vTrack.profile);
        kog.m("[Main] getVideoTrack level : " + vTrack.level + "   description : " + vTrack.description);

        double framerate = vTrack.frameRateNum / (double) vTrack.frameRateDen;
        kog.m("[Main] getVideoTrack frameRateNum : " + vTrack.frameRateNum + "   frameRateDen : " + vTrack.frameRateDen +
                "   sarNum : " + vTrack.sarNum + "   sarDen : " + vTrack.sarDen);

        int vWidth = vTrack.width;
        int vHeight = vTrack.height;

        kog.m("[Main] getVideoTrack framerate : " + framerate + "   vWidth : " + vWidth + "   vHeight : " + vHeight);

        if(vHeight > 2160) return MyConstants.CHECK_VIDEO_UHD;

        if(vTrack.frameRateNum < 1){
            if(vTrack.codec.contains("HEVC")){
                MyConstants.g_VideoPlayInfo = "Video HEVC Codec 오류 / 프레임레이트 오류";
                return MyConstants.CHECK_VIDEO_HEVC_RATE_FAIL;
            }

            /*if(vTrack.codec.contains("H264")){
                MyConstants.g_VideoPlayInfo = "Video 264 Codec 오류 / 프레임레이트 오류";
            }

            if(aTrack.codec.contains("AC3")){
                MyConstants.g_VideoPlayInfo = "Audio AC3 Codec 오류 / 프레임레이트 오류";
            }*/

            return MyConstants.CHECK_VIDEO_RATE_FAIL;
        }

        //if(vWidth > 3800) return 1;

        if(vTrack.codec.contains("HEVC")){
            MyConstants.g_VideoPlayInfo = "Video HEVC Codec 오류 / 프레임레이트 정상";

            if(vWidth > 1920){
                MyConstants.g_VideoPlayInfo = "Video HEVC Codec 오류 / 프레임레이트 정상 / Width 1920 이상";
                return MyConstants.CHECK_VIDEO_HEVC_OVER_HD;
            }
        }

        if(vTrack.originalCodec.contains("DivX")){
            return MyConstants.CHECK_VIDEO_DIVX;
        }

        if(aTrack == null){
            if(media != null) media.release();
            return MyConstants.CHECK_AUDIO_TRACK_FAIL;
        }

        kog.m("[Main] getAudioTrack codec : " + aTrack.codec + "   channels : " + aTrack.channels + "   rate : " + aTrack.rate);

        if(media != null) media.release();

        /*if(aTrack.codec.contains("AC3")){
            if(aTrack.channels >= 6){
                MyConstants.g_VideoPlayInfo = "Audio AC3 Codec / channels 오류";
            }
        }*/

        return MyConstants.CHECK_VIDEO_OK;
    }

    private void playVideo(String path){
        mVideoStopCnt = 0;
        MyConstants.g_CurrPlayFilePath = path;

        File videoFile = new File(path);
        Uri uriFromVideoFile = Uri.fromFile(videoFile);

        Intent intent = new Intent(this, VideoPlayerActivity.class);
        intent.putExtra(Constants.PLAY_EXTRA_ITEM_LOCATION, uriFromVideoFile);
        //intent.putExtra(VideoPlayerActivity.PLAY_EXTRA_ITEM_TITLE, null);
        if(MyConstants.g_IsLastPlay){
            if((MyConstants.g_VideoPlayErr == MyConstants.CHECK_VIDEO_RATE_FAIL) ||
                    (MyConstants.g_VideoPlayErr == MyConstants.CHECK_VIDEO_TRACK_FAIL)){
                intent.putExtra(Constants.PLAY_EXTRA_FROM_START, true);
            }
            else{
                intent.putExtra(Constants.PLAY_EXTRA_FROM_START, false);
            }
        }
        else{
            intent.putExtra(Constants.PLAY_EXTRA_FROM_START, true);
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

        mIsListPlay = false;
    }

    private void playAudio(String path){
        if(!Function.isFileExist(path)){
            _rl_aux_bg.setVisibility(View.GONE);
            Function.toast(this, "재생할 파일이 없습니다.");
            mIsRemoconControl = true;
            return;
        }

        MyConstants.g_IsVideoMute = false;

        File audioFile = new File(path);
        Uri uriFromAudioFile = Uri.fromFile(audioFile);

        MediaUtils.INSTANCE.openMediaNoUi(uriFromAudioFile);

        Intent intent = new Intent(this, AudioPlayerActivity.class);
        startActivity(intent);

        //mHandler.removeMessages(IDEX_TEST_MP3);
        //mHandler.sendEmptyMessageDelayed(IDEX_TEST_MP3, TIME_TEST_MP3);
    }

    private void playImage(String path){
        MyConstants.g_IsVideoMute = false;

        MyConstants.g_SelImageFile = path;
        kog.m("[Main] playImage path : " + path);

        Intent intent = new Intent(this, ImageActivity.class);
        startActivity(intent);
    }

    private void onPlayFile(final int pos){
        if(mArrFile.size() == 0) return;

        mIsRemoconControl = false;
        mIsMainExit = false;
        mVideoStopCnt = 0;

        initFileListVal();
        MyConstants.g_SelPlayList = false;

        mListPlayItem = mArrFile.get(pos);
        mListPlayItem.isSelect = true;

        kog.m("[Main] mIsListShow : " + mIsListShow);
        kog.m("[Main] mIsListShow mListPlayItem.path : " + mListPlayItem.path + "   g_CurrPlayFilePath : " + MyConstants.g_CurrPlayFilePath);

        if(mIsListShow){
            if(mListPlayItem.path.equals(MyConstants.g_CurrPlayFilePath)){
                //moveTaskToBack(false);
                Intent iMode = null;
                if(mPlayMode == MyConstants.MODE_PLAY_VIDEO){
                    sendMsgFinish();
                    onListPlay(2000);
                }
                else if(mPlayMode == MyConstants.MODE_PLAY_AUDIO){
                    iMode = new Intent(this, AudioPlayerActivity.class);
                    iMode.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    startActivity(iMode);
                }
                else if(mPlayMode == MyConstants.MODE_PLAY_IMAGE){
                    iMode = new Intent(this, ImageActivity.class);
                    iMode.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    startActivity(iMode);
                }
                return;
            }
            else{
                sendMsgFinish();
            }
        }

        _rl_aux_bg.setVisibility(View.VISIBLE);

        mHandler.sendEmptyMessageDelayed(IDEX_LIST_PLAY, DELAY_PLAY_TIME);
    }

    private void onPlayListFile(int pos){
        if(mArrPlayList.size() == 0) return;

        initPlayVal();

        MyConstants.g_SelPlayList = true;
        MyConstants.g_IdxPlayList = pos;

        PlayListItem item = mArrPlayList.get(pos);
        mPlayListFilePath = item.pl_path;
        mPlayListFileName = item.pl_name;
        mPlayListType = Integer.parseInt(item.pl_type);

        kog.m("[Main] onPlayListFile mPlayListFilePath : " + mPlayListFilePath + "mIsListShow : " + mIsListShow);
        /*if(mIsListShow){
            if(mPlayListFilePath.equals(MyConstants.g_CurrPlayFilePath)){
                kog.m("[Main] Same current : " + MyConstants.g_CurrPlayFilePath);
                //moveTaskToBack(false);
                Intent iMode = null;
                if(mPlayMode == MyConstants.MODE_PLAY_VIDEO){
                    sendMsgFinish();
                    onListPlay(2000);
                }
                else if(mPlayMode == MyConstants.MODE_PLAY_AUDIO){
                    iMode = new Intent(this, AudioPlayerActivity.class);
                    iMode.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    startActivity(iMode);
                }
                else if(mPlayMode == MyConstants.MODE_PLAY_IMAGE){
                    iMode = new Intent(this, ImageActivity.class);
                    iMode.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    startActivity(iMode);
                }
                return;
            }
            else{
                sendMsgFinish();
            }
        }*/

        mHandler.sendEmptyMessageDelayed(IDEX_PLAY_LIST_MODE, 1000);
    }

    private void initPlayVal(){
        mIsRemoconControl = false;

        _rl_aux_bg.setVisibility(View.VISIBLE);
        sendMsgFinish();
    }

    private void onPlayListOne(){
        if(mArrPlayList.size() == 0) return;

        initPlayVal();

        onPlayListFile(MyConstants.g_IdxPlayList);
    }

    private void onPlayListNext(){
        if(mArrPlayList.size() == 0) return;

        initPlayVal();

        MyConstants.g_IdxPlayList ++;

        if(MyConstants.g_IdxPlayList >= mArrPlayList.size()){
            MyConstants.g_IdxPlayList = 0;
        }

        kog.m("[Main] onPlayListNext g_IdxPlayList : " + MyConstants.g_IdxPlayList);

        onPlayListFile(MyConstants.g_IdxPlayList);
    }

    private void onPlayListPrev(){
        if(mArrPlayList.size() == 0) return;

        initPlayVal();

        MyConstants.g_IdxPlayList --;

        if(MyConstants.g_IdxPlayList < 0){
            MyConstants.g_IdxPlayList = mArrPlayList.size() - 1;
        }

        onPlayListFile(MyConstants.g_IdxPlayList);
    }

    private String StringReplace(String str){
        String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
        str =str.replaceAll(match, "");
        return str;
    }

    private boolean setDirList(File fileDir, int idx, int pos){
        if(fileDir == null) return false;

        Function.showProg(this);

        boolean isDir = false;

        FileItem item = null;
        File[] dirs = fileDir.listFiles();

        List<FileItem> subList = new ArrayList<FileItem>();
        try{
            for(File ff: dirs){
                if(!ff.isHidden()){
                    item = new FileItem();

                    if(ff.isDirectory()){
                        File[] fbuf = ff.listFiles();
                        int cnt = 0;
                        if(fbuf != null){
                            cnt = fbuf.length;
                        }

                        item.name = ff.getName();
                        item.type = MyConstants.TYPE_DIR;
                        item.fileCnt = cnt;
                        item.path = ff.getAbsolutePath();
                        item.path_parrent = fileDir.getAbsolutePath();
                        item.index = idx;
                        item.isVisble = false;

                        String dirName = StringReplace(item.name);
                        kog.m("[Main] setDirList item.name : " + item.name + "   dirName : " + dirName);

                        if((item.name.equals("LOST.DIR")) || (item.name.equals("System Volume Information"))
                                || (item.name.equals("!$Rwf"))
                                || (dirName.equals("pRl")) || (dirName.equals("RECYCLEBIN"))
                                || (dirName.equals("FOUND000")) || (dirName.equals("nTwBs"))
                                || (dirName.equalsIgnoreCase("recycled"))
                                || (dirName.equalsIgnoreCase("android"))){
                        }
                        else{
                            subList.add(item);

                            isDir = true;
                        }
                    }
                    else{
                        int type = Function.defineType(ff.getName());

                        kog.m("[Main] setDirList getName : " + ff.getName() + "   type : " + type);
                        if(type == MyConstants.TYPE_VIDEO){
                            if(USE_VIDEO) {
                                item.name = ff.getName();
                                item.type = MyConstants.TYPE_VIDEO;
                                item.path = ff.getAbsolutePath();
                                item.path_parrent = fileDir.getAbsolutePath();

                                mArrFile.add(item);
                            }
                        }
                        else if(type == MyConstants.TYPE_AUDIO){
                            item.name = ff.getName();
                            item.type = MyConstants.TYPE_AUDIO;
                            item.path = ff.getAbsolutePath();
                            item.path_parrent = fileDir.getAbsolutePath();

                            mArrFile.add(item);
                        }
                        else if(type == MyConstants.TYPE_IMAGE){
                            if(!USE_VIDEO) {
                                item.name = ff.getName();
                                item.type = MyConstants.TYPE_IMAGE;
                                item.path = ff.getAbsolutePath();
                                item.path_parrent = fileDir.getAbsolutePath();

                                mArrFile.add(item);
                            }
                        }
                    }
                }
            }
        }
        catch(Exception e){
        }

        Collections.sort(subList);
        Collections.sort(mArrFile);

        mArrDir.addAll(pos + 1, subList);

        mSelListFile = 0;
        mIsInitFileList = true;

        mAdapterDir.notifyDataSetChanged();
        mAdapterFile.notifyDataSetChanged();
        mListViewFile.setSelectionFromTop(mSelListFile, 0);

        Function.hideProg();

        return isDir;
    }

    public class PlayListAdapter extends BaseAdapter {
        LayoutInflater inflater;

        public PlayListAdapter(Context context) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        public int getCount(){
            return mArrPlayList.size();
        }

        public Object getItem(int position) {
            return mArrPlayList.get(position);
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(final int position, View view, ViewGroup parent) {
            if(view == null){
                view = inflater.inflate(R.layout.item_play_list, parent, false);
            }

            final PlayListItem item = (PlayListItem) getItem(position);

            view.setBackgroundResource(R.drawable.m_list_nor);

            ImageView iv_file_type = (ImageView) view.findViewById(R.id.iv_file_type);

            int type = Integer.parseInt(item.pl_type);
            if(type == MyConstants.TYPE_VIDEO){
                iv_file_type.setBackgroundResource(R.drawable.ic_browser_video_normal);
            }
            else if(type == MyConstants.TYPE_AUDIO){
                iv_file_type.setBackgroundResource(R.drawable.ic_browser_audio_normal);
            }
            else if(type == MyConstants.TYPE_IMAGE){
                iv_file_type.setBackgroundResource(R.drawable.ic_browser_video_normal);
            }

            TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_name.setText(item.pl_name);

            tv_name.setTextColor(getResources().getColor(R.color.white));

            if(mSelLivsView == 2){
                if(position == mSelListPlayList) {
                    view.setBackgroundResource(R.drawable.m_list_sel);
                    tv_name.setTextColor(getResources().getColor(R.color.black));
                }
            }
            else{
                if(position == mSelListPlayList) {
                    tv_name.setTextColor(getResources().getColor(R.color.orange300));
                }
            }

            return view;
        }
    }

    public class DirAdapter extends BaseAdapter {
        LayoutInflater inflater;

        public DirAdapter(Context context) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        public int getCount(){
            return mArrDir.size();
        }

        public Object getItem(int position) {
            return mArrDir.get(position);
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(final int position, View view, ViewGroup parent) {
            if(view == null){
                view = inflater.inflate(R.layout.item_dir_list, parent, false);
            }

            final FileItem item = (FileItem) getItem(position);

            ImageView iv_margin = (ImageView) view.findViewById(R.id.iv_margin);
            TextView tv_name = (TextView) view.findViewById(R.id.tv_name);

            view.setBackgroundResource(R.drawable.m_list_nor);

            LayoutParams params = iv_margin.getLayoutParams();
            params.width = 20 * item.index;
            iv_margin.setLayoutParams(params);

            tv_name.setText(item.name);

            tv_name.setTextColor(getResources().getColor(R.color.white));

            if(mSelLivsView == 0) {
                if(position == mSelListDir) {
                    view.setBackgroundResource(R.drawable.m_list_sel);
                    tv_name.setTextColor(getResources().getColor(R.color.black));
                }
            }
            else{
                if(position == mSelListDir) {
                    tv_name.setTextColor(getResources().getColor(R.color.orange300));
                }
            }

            return view;
        }
    }

    public class FileAdapter extends BaseAdapter {
        LayoutInflater inflater;

        public FileAdapter(Context context) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        public int getCount(){
            return mArrFile.size();
        }

        public Object getItem(int position) {
            return mArrFile.get(position);
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(final int position, View view, ViewGroup parent) {
            if(view == null){
                view = inflater.inflate(R.layout.item_file_list, parent, false);
            }

            final FileItem item = (FileItem) getItem(position);

            view.setBackgroundResource(R.drawable.m_list_nor);

            ImageView iv_file_type = (ImageView) view.findViewById(R.id.iv_file_type);

            if(item.type == MyConstants.TYPE_VIDEO){
                iv_file_type.setBackgroundResource(R.drawable.ic_browser_video_normal);
            }
            else if(item.type == MyConstants.TYPE_AUDIO){
                iv_file_type.setBackgroundResource(R.drawable.ic_browser_audio_normal);
            }
            else if(item.type == MyConstants.TYPE_IMAGE){
                iv_file_type.setBackgroundResource(R.drawable.ic_browser_video_normal);
            }

            TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_name.setText(item.name);

            tv_name.setTextColor(getResources().getColor(R.color.white));

            if(mSelLivsView == 1) {
                if(position == mSelListFile) {
                    view.setBackgroundResource(R.drawable.m_list_sel);
                    tv_name.setTextColor(getResources().getColor(R.color.black));
                }
            }
            else{
                if(position == mSelListFile) {
                    tv_name.setTextColor(getResources().getColor(R.color.orange300));
                }
            }

            if(mIsInitFileList){
                tv_name.setTextColor(getResources().getColor(R.color.white));
            }

            return view;
        }
    }

    private void setResumePlayFileList(){
        for(int i = 0; i < mArrFile.size(); i++) {
            FileItem subItem = mArrFile.get(i);

            if(subItem.path.equals(MyConstants.g_CurrPlayFilePath)){
                mSelListFile = i;
                kog.m("[Main] setResumePlayFileList subItem.path : " + subItem.path);
                break;
            }
        }

        mAdapterFile.notifyDataSetChanged();
        mListViewFile.setSelection(mSelListFile);
    }

    private void setResumePlayListFileList(){
        for(int i = 0; i < mArrPlayList.size(); i++) {
            PlayListItem subItem = mArrPlayList.get(i);

            if(subItem.pl_path.equals(MyConstants.g_CurrPlayFilePath)){
                mSelListPlayList = i;
                kog.m("[Main] setResumePlayListFileList subItem.pl_path : " + subItem.pl_path);
                break;
            }
        }

        kog.m("[Main] setResumePlayListFileList");

        mAdapterPlayList.notifyDataSetChanged();
        mListViewPlayList.setSelection(mSelListPlayList);
    }

    @Override
    protected void onResume() {
        super.onResume();
        kog.m("[Main] onResume");

        //mHandler.sendEmptyMessageDelayed(IDEX_REMOCON_ENABLE, TIME_REMOCON_ENABLE);

        if(!MyConstants.g_SelPlayList){
            if(mPlayMode == MyConstants.MODE_PLAY_VIDEO){
                setResumePlayFileList();
            }
            else if(mPlayMode == MyConstants.MODE_PLAY_AUDIO){
                setResumePlayFileList();
            }
            else if(mPlayMode == MyConstants.MODE_PLAY_IMAGE){
                setResumePlayFileList();
            }
        }
        else{
            if(mPlayMode == MyConstants.MODE_PLAY_VIDEO){
                setResumePlayListFileList();
            }
            else if(mPlayMode == MyConstants.MODE_PLAY_AUDIO){
                setResumePlayListFileList();
            }
            else if(mPlayMode == MyConstants.MODE_PLAY_IMAGE){
                setResumePlayListFileList();
            }
        }

        mIsRemoconControl = true;

        if(!mIsFirstMainExit) mIsMainExit = true;

        if(mIsFirstBoot){
            if(mStorageMode == MODE_USB){
                mMountPath = PreferenceUtil.getKeyLastMountPathUsb();
                if(!mMountPath.isEmpty()){
                    mMountType = "usb";

                    kog.m("[Main] usb mMountPath : " + mMountPath + "   mMountType : " + mMountType);
                    checkExistMountPath();
                }

                onRemoconMode(DefineRemocon.usb);
            }
            else if(mStorageMode == MODE_SD){
                mMountPath = PreferenceUtil.getKeyLastMountPathSd();
                if(!mMountPath.isEmpty()){
                    mMountType = "sdcard";

                    kog.m("[Main] sd mMountPath : " + mMountPath + "   mMountType : " + mMountType);
                    checkExistMountPath();
                }

                onRemoconMode(DefineRemocon.sd);
            }

            return;
        }

        //Intent intentMsg = new Intent("com.microcity.action.HIDE_STATUSBAR");
        //sendBroadcast(intentMsg);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onPause() {
        super.onPause();
        kog.m("[Main] onPause");

        //_rl_aux_bg.setVisibility(View.GONE);
        mIsRemoconControl = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        kog.m("[Main] onDestroy");

        mHandler.removeMessages(IDEX_VIDEO_PLAY_CHECK);
        mHandler.removeMessages(IDEX_LAST_PLAY);
        mHandler.removeMessages(IDEX_VIDEO_PLAY_MODE);
        mHandler.removeMessages(IDEX_PLAY_LIST_MODE);
        mHandler.removeMessages(IDEX_LIST_PLAY);
        mHandler.removeMessages(IDEX_LIST_CONTROL);
        mHandler.removeMessages(IDEX_CHECK_MOUNT_USB);
        mHandler.removeMessages(IDEX_CHECK_VIDEO_FILE);
        mHandler.removeMessages(IDEX_VLC_LIVE);

        // edit by ssh 20200812
        mAudioManager = null;

        if(mRemoconReceiver != null)
            unregisterReceiver(mRemoconReceiver);

        if(mReceiver != null)
            unregisterReceiver(mReceiver);

        if(mReceiverStorage != null)
            unregisterReceiver(mReceiverStorage);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        int id = v.getId();
        if (id == R.id.bt_exit) {
            intent = new Intent("MSG_APP_END");
            sendBroadcast(intent);
            finish();
        } else if (id == R.id.bt_eq) {
			/*intent = new Intent(this, SecondaryActivity.class);
                intent.putExtra("fragment", SecondaryActivity.EQUALIZER);
                startActivity(intent);*/
        } else if (id == R.id.bt_setting) {
            intent = new Intent(this, PreferencesActivity.class);
            startActivity(intent);
        }
    }

    public static void findSubFiles(File parentFile, ArrayList<File> subFiles) {
        if(parentFile.isFile()) {
            subFiles.add(parentFile);
        }
        else if(parentFile.isDirectory()) {
            subFiles.add(parentFile);
            File[] childFiles= parentFile.listFiles();
            for(File childFile : childFiles) {
                findSubFiles(childFile, subFiles);
            }
        }
    }

}
