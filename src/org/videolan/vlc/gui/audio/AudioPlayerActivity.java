/*****************************************************************************
 * AudioPlayerActivity.java
 *****************************************************************************
 * Copyright © 2014-2015 VLC authors, VideoLAN and VideoLabs
 * Author: Geoffrey Métais
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
 *****************************************************************************/
package org.videolan.vlc.gui.audio;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.videolan.medialibrary.Tools;
import org.videolan.medialibrary.interfaces.media.MediaWrapper;
import org.videolan.vlc.ExplorerActivity;
import org.videolan.vlc.PlayListProvider;
import org.videolan.vlc.PlaybackService;
import org.videolan.vlc.R;
import org.videolan.vlc.common.DefineRemocon;
import org.videolan.vlc.common.Function;
import org.videolan.vlc.common.MyConstants;
import org.videolan.vlc.common.kog;
import org.videolan.vlc.gui.helpers.AudioUtil;
import org.videolan.vlc.gui.helpers.UiTools;
import org.videolan.vlc.items.FileItem;
import org.videolan.vlc.items.LastPlayItem;
import org.videolan.vlc.items.PlayListItem;
import org.videolan.vlc.media.MediaUtils;
import org.videolan.resources.AndroidDevices;
import org.videolan.vlc.util.PreferenceUtil;
import org.videolan.tools.WorkersKt;
import org.videolan.vlc.viewmodels.PlayerState;
import org.videolan.vlc.viewmodels.PlaylistModel;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
public class AudioPlayerActivity extends FragmentActivity {
    public static final String TAG = "VLC/AudioPlayerActivity";

    public static final String MEDIA_LIST = "media_list";
    public static final String MEDIA_POSITION = "media_position";

    private static final int IDEX_SHOW_CHANGE_SPEED_MSG = 1, TIME_SHOW_CHANGE_SPEED_MSG = 3000;
	// Play the next song quickly.
    private static final int IDEX_SHOW_PLAY_TIME_MSG = 2, TIME_SHOW_PLAY_TIME_MSG = 1000, TIME_SHOW_PLAY_TIME_MSG_SHORT = 10;
    private static final int IDEX_NEXT_PLAY = 3, TIME_NEXT_PLAY = 1;//000;
    private static final int IDEX_REMOCON_ENABLE = 4, TIME_REMOCON_ENABLE = 3000;
    private static final int IDEX_MAIN_LIST_TO_AUDIO = 5, TIME_MAIN_LIST_TO_AUDIO = 1000;
    private static final int IDEX_PLAY_NEW = 6, TIME_PLAY_NEW = 1000;

    //PAD navigation
    private static final int JOYSTICK_INPUT_DELAY = 300;
    private long mLastMove;
    private boolean mShuffling = false;
    private String mCurrentCoverArt;
    private PlaylistModel model;
    private SharedPreferences mSettings;
    private final Handler mHandler = new Handler();

    private TextView mTitle, mArtist, mAlbum, _tv_audio_rate, _tv_play_time_curr, _tv_play_time_max;
    private ImageView mPlayPauseButton, mCover, mNext, mShuffle, mRepeat, mBackground;
    private ImageView _iv_repeat, _iv_volume, _iv_mute, _iv_up_down;
    private ProgressBar mProgressBar;

    private ListView mListViewAudioFileList;

    private ArrayList<FileItem> mArrAudioFile = new ArrayList<FileItem>();

    private AudioFileAdapter mAdapterAudioFile;

    private int mSelListAudioFile = 0, mPlayAudioFile = 0, mRepeatMode = MyConstants.REPEAT_FOLDER, mVolMax, mCurrVol,
            mStorageMode, mPlayTime = 0, mStopCnt = 0, mTotPlayTime = 0, mServicePlayTime = 0, mPlayPos = 0, mRemoconDvdMode = -1;

    private BroadcastReceiver mRemoconReceiver;

    // edit by ssh 20200807
    private BroadcastReceiver mVolumeReceiver;

    private AudioManager mAudioManager;

    private boolean mIsRemoconControl = true, mIsMute = false, mIsLastSetTime = false, mIsNewPlay = true, mIsPlaying = true,
            mIsRemoconList = false;

    private float mPlayRate = 1;

    private LastPlayItem mInsertLastPlayItem = new LastPlayItem();
    private LastPlayItem mGetLastPlayItem = new LastPlayItem();

    private String[] mstrProjection;
    private ArrayList<PlayListItem> mArrPlayList = new ArrayList<PlayListItem>();
    private Cursor mPlayListDB = null;

    private PlaybackService mService = null;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        kog.m("[AudioPlay] onCreate");

        PreferenceUtil.init(this);
        mRepeatMode = PreferenceUtil.getModeAudioRepeat();
        mStorageMode = PreferenceUtil.getModeStorage();

        setContentView(R.layout.mod_audio_player);
        mContentView = findViewById(R.id.main_layout);

        // edit by ssh 20200104
        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kog.m("[AudioPlay] iv_back");
                //onExit();
                //runMain();
                mIsRemoconControl = false;
                Intent intentMsg = new Intent("MSG_MAIN_LIST");
                sendBroadcast(intentMsg);
            }
        });

        /*findViewById(R.id.tv_play_time_curr).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeSpeed(-0.003f);
            }
        });

        findViewById(R.id.tv_play_time_max).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeSpeed(0.003f);
            }
        });*/

        mTitle = (TextView)findViewById(R.id.media_title);
        mArtist = (TextView)findViewById(R.id.media_artist);
        mAlbum = (TextView)findViewById(R.id.media_album);
        mProgressBar = (ProgressBar)findViewById(R.id.media_progress);
        mCover = (ImageView)findViewById(R.id.album_cover);

        _iv_repeat = (ImageView) findViewById(R.id.iv_repeat);
        _iv_volume = (ImageView) findViewById(R.id.iv_volume);
        _iv_mute = (ImageView) findViewById(R.id.iv_mute);
        _iv_up_down = (ImageView) findViewById(R.id.iv_up_down);

        _tv_audio_rate = (TextView)findViewById(R.id.tv_audio_rate);
        _tv_play_time_curr = (TextView)findViewById(R.id.tv_play_time_curr);
        _tv_play_time_max = (TextView)findViewById(R.id.tv_play_time_max);

        mAudioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        mVolMax = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        // edit by ssh 20200828
        mAudioManager.setStreamMute(AudioManager.STREAM_MUSIC, false);
        //mAudioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_UNMUTE, 0);

        // edit by ssh 20200812
        //mCurrVol = PreferenceUtil.getMainVol();
        mCurrVol = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        kog.m("[AudioPlay] mVolMax : " + mVolMax + "   mCurrVol : " + mCurrVol);

        showCurrVol();

        mListViewAudioFileList = (ListView) findViewById(R.id.lv_audio_list);
        mAdapterAudioFile = new AudioFileAdapter(this);
        mListViewAudioFileList.setAdapter(mAdapterAudioFile);
        mListViewAudioFileList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onPlayAudio(position);
            }
        });

        mPlayRate = MyConstants.g_AudioPlayRate;
        //changeSpeed(mPlayRate);
        //if(mPlayRate != 1.0f) {
            String msg = getString(R.string.playback_speed) + " : " + String.format("%.2f", (mPlayRate-1.0f)*10/3+1.0f);
            showChangeSpeedMsg(msg);
        //}

        showRepeatMode();

        IntentFilter mRemoconFilter = new IntentFilter();
        mRemoconFilter.addAction("MSG_UART_REMOCON");
        mRemoconFilter.addAction("MSG_FINISH");
        mRemoconFilter.addAction("MSG_LAUNCHER_EXIT");

        mRemoconReceiver  = new BroadcastReceiver(){
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if(action.equals("MSG_UART_REMOCON")){
                    kog.m("[AudioPlay] mRemoconReceiver mIsRemoconControl : " + mIsRemoconControl);

                    if(mIsRemoconControl) {
                        byte key = intent.getByteExtra("Key", (byte) -1);
                        onRemoconMode(key);
                    }
                }
                else if(action.equals("MSG_FINISH")){
                    kog.m("[AudioPlay] MSG_FINISH");
                    //mAudioManager.setStreamMute(AudioManager.STREAM_MUSIC, true);
                    //mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 0, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
                    if (mService != null) {
                        kog.m("[AudioPlay] mRemoconReceiver pause");
                        mService.pause();
                    }

                    onExit();
                }
                else if(action.equals("MSG_LAUNCHER_EXIT")){
                    kog.m("[AudioPlay] MSG_LAUNCHER_EXIT");
                    if (mService != null) {
                        mService.pause();
                    }

                    onExit();
                }
            }
        };
        registerReceiver(mRemoconReceiver, mRemoconFilter);

        // edit by ssh 20200812
        IntentFilter mVolumeFilter = new IntentFilter();
        mVolumeFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
        mVolumeReceiver  = new BroadcastReceiver(){
            public void onReceive(Context context, Intent intent) {
                showCurrVolOnly();
            }
        };
        registerReceiver(mVolumeReceiver, mVolumeFilter);

        model = new ViewModelProvider(this).get(PlaylistModel.class);
        model.getPlayerState().observe(this, new Observer<PlayerState>() {
            @Override
            public void onChanged(PlayerState playerState) {
                update(playerState);
            }
        });

        if(!MyConstants.g_SelPlayList){
            setAudioFileList();
        }
        else{
            getPlayListDB();
            setPlayistFileList();
        }

        /*final List<MediaWrapper> medialist = getIntent().getParcelableArrayListExtra(MEDIA_LIST);
        final int position = getIntent().getIntExtra(MEDIA_POSITION, 0);
        if (medialist != null) MediaUtils.INSTANCE.openList(this, medialist, position);*/
    }

    private void onRemoconMode(byte key){
        switch(key){
            case DefineRemocon.vol_down:
                // edit by ssh 20200812
                /*
                mCurrVol --;

                if(mCurrVol < 0){
                    mCurrVol = 0;
                }
                else{
                    showCurrVol();
                }
                */
                break;

            case DefineRemocon.vol_up:
                // edit by ssh 20200812
                /*
                mCurrVol ++;

                if(mCurrVol > mVolMax){
                    mCurrVol = mVolMax;
                }
                else{
                    showCurrVol();
                }
                */
                break;

            case DefineRemocon.mute:
                // edit by ssh 20200812
                /*
                if(mIsMute){
                    mIsMute = false;
                }
                else{
                    mIsMute = true;
                }
                showMute();
                */
                break;

            case DefineRemocon.up:
                _iv_up_down.setBackgroundResource(R.drawable.a_updown_01);

			/*try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/

                if(mArrAudioFile.size() == 0) return;

                mSelListAudioFile --;
                if(mSelListAudioFile < 0){
                    mSelListAudioFile = mArrAudioFile.size() - 1;
                }
                //mPlayAudioFile = mSelListAudioFile;

                refreshListView();
                break;

            case DefineRemocon.down:
                _iv_up_down.setBackgroundResource(R.drawable.a_updown_02);

			/*try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/

                if(mArrAudioFile.size() == 0) return;

                mSelListAudioFile ++;
                if(mSelListAudioFile == mArrAudioFile.size()){
                    mSelListAudioFile = 0;
                }
                //mPlayAudioFile = mSelListAudioFile;

                refreshListView();
                break;

            case DefineRemocon.left:
                changeSpeed(-0.003f);
                break;

            case DefineRemocon.right:
                changeSpeed(0.003f);
                break;

            case DefineRemocon.enter:
                onPlayAudio(mSelListAudioFile);
                mPlayAudioFile = mSelListAudioFile;
                mAdapterAudioFile.notifyDataSetChanged();
                break;

            case DefineRemocon.play:
                if(false) {//mPlayRate != 1){
                    mPlayRate = 1;
                    MyConstants.g_VideoPlayRate = mPlayRate;
                    mService.setRate(mPlayRate, false);

                    MyConstants.g_AudioPlayRate = mPlayRate;

                    String msg = getString(R.string.playback_speed) + " : " + String.format("%.2f", mPlayRate);
                    showChangeSpeedMsg(msg);
                }
                else {
                    if (mService != null){
                        if (!mService.isPlaying()){
                            mService.play();

                            mHandlerMsg.sendEmptyMessageDelayed(IDEX_SHOW_PLAY_TIME_MSG, TIME_SHOW_PLAY_TIME_MSG);
                            mStopCnt = 0;
                            mIsPlaying = true;
                        }
                    }
                }
                break;

            case DefineRemocon.pause:
                if (mService.isPlaying()){
                    mHandlerMsg.removeMessages(IDEX_SHOW_PLAY_TIME_MSG);
                    mService.pause();
                    mIsPlaying = false;
                }
                break;

            case DefineRemocon.next:
                onPlayNext();
                if(mRepeatMode == MyConstants.REPEAT_ONE){
                    //mRepeatMode = MyConstants.REPEAT_ALL;
                    mRepeatMode = MyConstants.REPEAT_FOLDER;
                    PreferenceUtil.saveModeAudioRepeat(mRepeatMode);
                    showRepeatMode();
                }
                break;

            case DefineRemocon.back:
                onPlayPrev();
                if(mRepeatMode == MyConstants.REPEAT_ONE){
                    //mRepeatMode = MyConstants.REPEAT_ALL;
                    mRepeatMode = MyConstants.REPEAT_FOLDER;
                    PreferenceUtil.saveModeAudioRepeat(mRepeatMode);
                    showRepeatMode();
                }
                break;

            case DefineRemocon.stop:
                if(mStopCnt == 0){
                    if (mService.isPlaying()){
                        mHandlerMsg.removeMessages(IDEX_SHOW_PLAY_TIME_MSG);
                        mService.pause();
                        mIsPlaying = false;
                        mStopCnt ++;
                        kog.m("[AudioPlay] Remocon stop mStopCnt : " + mStopCnt);
                    }
                    else{
                        if(mRepeatMode == MyConstants.REPEAT_ONE){
                            //mRepeatMode = MyConstants.REPEAT_ALL;
                            mRepeatMode = MyConstants.REPEAT_FOLDER;
                            PreferenceUtil.saveModeAudioRepeat(mRepeatMode);
                            showRepeatMode();
                        }
                        stopExit();
                    }
                }
                else{
                    stopExit();
                }
                break;

            case DefineRemocon.dvd:
                if(mRemoconDvdMode != 0){
                    kog.m("[AudioPlay] Remocon dvd : " + mRemoconDvdMode);

                    if(mService != null){
                        if(mService.isPlaying()){
                            mService.pause();
                        }
                    }

                    mRemoconDvdMode = 1;
                }
                break;

            case DefineRemocon.usb:
                if(mRemoconDvdMode == 1){
                    kog.m("[AudioPlay] Remocon dvd -> usb : " + mRemoconDvdMode);

                    if(mStopCnt == 0){
                        if(mService != null){
                            if(!mService.isPlaying()){
                                mService.play();
                            }
                        }
                    }

                    mRemoconDvdMode = -1;
                }
                break;

            case DefineRemocon.repeat:
                /*if(mRepeatMode == MyConstants.REPEAT_NO){
                    mRepeatMode = MyConstants.REPEAT_ONE;
                }
                else if(mRepeatMode == MyConstants.REPEAT_ONE){
                    mRepeatMode = MyConstants.REPEAT_FOLDER;
                }
                else if(mRepeatMode == MyConstants.REPEAT_FOLDER){
                    mRepeatMode = MyConstants.REPEAT_ALL;
                }
                else if(mRepeatMode == MyConstants.REPEAT_ALL){
                    mRepeatMode = MyConstants.REPEAT_ONE;
                }*/
                if(mRepeatMode == MyConstants.REPEAT_ONE){
                    mRepeatMode = MyConstants.REPEAT_FOLDER;
                }
                else if(mRepeatMode == MyConstants.REPEAT_FOLDER){
                    mRepeatMode = MyConstants.REPEAT_ONE;
                }

                PreferenceUtil.saveModeAudioRepeat(mRepeatMode);
                showRepeatMode();
                break;

            case DefineRemocon.fast_backward:
                seek(-60000);
                break;

            case DefineRemocon.fast_forward:
                seek(60000);
                break;

            case DefineRemocon.slow_backward:
                seek(-10000);
                break;

            case DefineRemocon.slow_forward:
                seek(10000);
                break;

            case DefineRemocon.list:
                //mIsRemoconList = true;
                //stopExit();
                kog.m("[AudioPlay] Remocon MSG_MAIN_LIST");
                mIsRemoconControl = false;
                Intent intentMsg = new Intent("MSG_MAIN_LIST");
                sendBroadcast(intentMsg);
                break;
        }
    }

    private boolean getPlayListDB(){
        ContentResolver cr = this.getContentResolver();
        if(mStorageMode == 1)
            mstrProjection = PlayListProvider.strTablePlayList_USB;
        else if(mStorageMode == 2)
            mstrProjection = PlayListProvider.strTablePlayList_SD;

        mPlayListDB = cr.query(
                PlayListProvider.CONTENT_URI,
                mstrProjection,
                null, //QueryString
                null, //SelectionArg
                null); //sortOrder

        if(mArrPlayList != null) mArrPlayList.clear();

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

			// add fav to last pos
			// Play the next song quickly.
            //mArrPlayList.add(0, item);
            mArrPlayList.add(item);

            mPlayListDB.moveToNext();
        }
        mPlayListDB.close();

        return true;
    }

    private void setPlayistFileList(){
        mArrAudioFile.clear();

        FileItem item = null;
        for(int i = 0; i < mArrPlayList.size(); i++) {
            PlayListItem plItem = mArrPlayList.get(i);

            /*int type = Integer.parseInt(plItem.pl_type);
            if(type == MyConstants.TYPE_AUDIO){
                item = new FileItem();
                item.name = plItem.pl_name;
                item.type = MyConstants.TYPE_AUDIO;
                item.path = plItem.pl_path;

                mArrAudioFile.add(item);
            }*/
            item = new FileItem();
            item.name = plItem.pl_name;
            item.type = Integer.parseInt(plItem.pl_type);
            item.path = plItem.pl_path;

            mArrAudioFile.add(item);
        }

        for(int i = 0; i < mArrAudioFile.size(); i++) {
            FileItem subItem = mArrAudioFile.get(i);

            if(subItem.path.equals(MyConstants.g_CurrPlayFilePath)){
                MyConstants.g_CurrPlayFilePath = subItem.path;
                kog.m("[AudioPlay] setPlayistFileList g_CurrPlayFilePath : " + MyConstants.g_CurrPlayFilePath);

                mPlayAudioFile = i;
                subItem.isSelect = true;
                break;
            }
        }

        mSelListAudioFile = mPlayAudioFile;

        refreshListView();
    }

    private void stopExit(){
        kog.m("[AudioPlay] stopExit");
        mIsRemoconControl = false;

        Intent intent = null;
        if(mIsRemoconList){
            intent = new Intent("MSG_MAIN_LIST");
        }
        else{
            intent = new Intent("MSG_PLAY_STOP");
        }
        sendBroadcast(intent);

        onExit();
    }

    private void setTimeLastPlayDB(){
        if(MyConstants.g_IsLastPlay){
            int last_time = 0;
            if(mStorageMode == 1)
                last_time = PreferenceUtil.getLastPlaySaveTime_USB();
            else if(mStorageMode == 2)
                last_time = PreferenceUtil.getLastPlaySaveTime_SD();

            kog.m("[AudioPlay] last_time : " + last_time + "   mStorageMode : " + mStorageMode);

            if(last_time >= mTotPlayTime){
                kog.m("[AudioPlay] ****** last_time err : " + last_time + "   mTotPlayTime : " + mTotPlayTime);
                last_time = 0;
            }

            mService.setTime(last_time, false);
            mPlayTime = last_time;

            MyConstants.g_IsLastPlay = false;
            mIsLastSetTime = true;
        }
    }

    private void showChangeSpeedMsg(String msg){
        _tv_audio_rate.setText(msg);
        _tv_audio_rate.setVisibility(View.VISIBLE);
        mHandlerMsg.removeMessages(IDEX_SHOW_CHANGE_SPEED_MSG);
        mHandlerMsg.sendEmptyMessageDelayed(IDEX_SHOW_CHANGE_SPEED_MSG, TIME_SHOW_CHANGE_SPEED_MSG);
    }

    private void showRepeatMode(){
        kog.m("[AudioPlay] showRepeatMode mRepeatMode : " + mRepeatMode);

        if(mRepeatMode == MyConstants.REPEAT_ONE){
            _iv_repeat.setBackgroundResource(R.drawable.a_repeat_1_on);
        }
        else if(mRepeatMode == MyConstants.REPEAT_FOLDER){
            _iv_repeat.setBackgroundResource(R.drawable.a_repeat_folder_on);
        }
        else if(mRepeatMode == MyConstants.REPEAT_ALL){
            _iv_repeat.setBackgroundResource(R.drawable.a_repeat_on);
        }
        else if(mRepeatMode == MyConstants.REPEAT_NO){
            _iv_repeat.setBackgroundResource(R.drawable.a_repeat_off);
        }
    }

    private void showMute(){
        if(mIsMute){
            mAudioManager.setStreamMute(AudioManager.STREAM_MUSIC, true);
            //mAudioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_MUTE, 0);
            _iv_mute.setBackgroundResource(R.drawable.a_sound_off);
        }
        else{
            mAudioManager.setStreamMute(AudioManager.STREAM_MUSIC, false);
            //mAudioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_UNMUTE, 0);
            _iv_mute.setBackgroundResource(R.drawable.a_sound);
        }
    }

    private void showCurrVol(){
        if(mIsMute){
            mIsMute = false;
            showMute();
        }

        if(mCurrVol == 0)
            _iv_volume.setBackgroundResource(R.drawable.a_vol0);
        else if(mCurrVol == 1)
            _iv_volume.setBackgroundResource(R.drawable.a_vol1);
        else if(mCurrVol == 2)
            _iv_volume.setBackgroundResource(R.drawable.a_vol2);
        else if(mCurrVol == 3)
            _iv_volume.setBackgroundResource(R.drawable.a_vol3);
        else if(mCurrVol == 4)
            _iv_volume.setBackgroundResource(R.drawable.a_vol4);
        else if(mCurrVol == 5)
            _iv_volume.setBackgroundResource(R.drawable.a_vol5);
        else if(mCurrVol == 6)
            _iv_volume.setBackgroundResource(R.drawable.a_vol6);
        else if(mCurrVol == 7)
            _iv_volume.setBackgroundResource(R.drawable.a_vol7);
        else if(mCurrVol == 8)
            _iv_volume.setBackgroundResource(R.drawable.a_vol8);
        else if(mCurrVol == 9)
            _iv_volume.setBackgroundResource(R.drawable.a_vol9);
        else if(mCurrVol == 10)
            _iv_volume.setBackgroundResource(R.drawable.a_vol10);
        else if(mCurrVol == 11)
            _iv_volume.setBackgroundResource(R.drawable.a_vol11);
        else if(mCurrVol == 12)
            _iv_volume.setBackgroundResource(R.drawable.a_vol12);
        else if(mCurrVol == 13)
            _iv_volume.setBackgroundResource(R.drawable.a_vol13);
        else if(mCurrVol == 14)
            _iv_volume.setBackgroundResource(R.drawable.a_vol14);
        else if(mCurrVol == 15)
            _iv_volume.setBackgroundResource(R.drawable.a_vol15);

        mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, mCurrVol, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
        PreferenceUtil.saveMainVol(mCurrVol);
    }

    // edit by ssh 20200812
    private void showCurrVolOnly(){
        if(mIsMute){
            mIsMute = mAudioManager.isStreamMute(AudioManager.STREAM_MUSIC);
            showMute();
        }

        mCurrVol = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        PreferenceUtil.saveMainVol(mCurrVol);

        if(mCurrVol == 0)
            _iv_volume.setBackgroundResource(R.drawable.a_vol0);
        else if(mCurrVol == 1)
            _iv_volume.setBackgroundResource(R.drawable.a_vol1);
        else if(mCurrVol == 2)
            _iv_volume.setBackgroundResource(R.drawable.a_vol2);
        else if(mCurrVol == 3)
            _iv_volume.setBackgroundResource(R.drawable.a_vol3);
        else if(mCurrVol == 4)
            _iv_volume.setBackgroundResource(R.drawable.a_vol4);
        else if(mCurrVol == 5)
            _iv_volume.setBackgroundResource(R.drawable.a_vol5);
        else if(mCurrVol == 6)
            _iv_volume.setBackgroundResource(R.drawable.a_vol6);
        else if(mCurrVol == 7)
            _iv_volume.setBackgroundResource(R.drawable.a_vol7);
        else if(mCurrVol == 8)
            _iv_volume.setBackgroundResource(R.drawable.a_vol8);
        else if(mCurrVol == 9)
            _iv_volume.setBackgroundResource(R.drawable.a_vol9);
        else if(mCurrVol == 10)
            _iv_volume.setBackgroundResource(R.drawable.a_vol10);
        else if(mCurrVol == 11)
            _iv_volume.setBackgroundResource(R.drawable.a_vol11);
        else if(mCurrVol == 12)
            _iv_volume.setBackgroundResource(R.drawable.a_vol12);
        else if(mCurrVol == 13)
            _iv_volume.setBackgroundResource(R.drawable.a_vol13);
        else if(mCurrVol == 14)
            _iv_volume.setBackgroundResource(R.drawable.a_vol14);
        else if(mCurrVol == 15)
            _iv_volume.setBackgroundResource(R.drawable.a_vol15);
    }

    private void runMain(){
        Intent i = new Intent(this, ExplorerActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(i);
    }

    private void setAudioFileList(){
        if(MyConstants.g_PlayPathParrent == null){
            finish();
            //runMain();
            return;
        }

        File fileAudio = new File(MyConstants.g_PlayPathParrent);
        mArrAudioFile.clear();

        FileItem item = null;
        File[] dirs = fileAudio.listFiles();

        List<FileItem> fls = new ArrayList<FileItem>();
        try{
            for(File ff: dirs){
                if(!ff.isHidden()){
                    item = new FileItem();

                    if(!ff.isDirectory()){
                        int type = Function.defineType(ff.getName());

                        kog.m("[AudioPlay] setAudioFileList getName : " + ff.getName() + "   type : " + type);
                        if(type == MyConstants.TYPE_AUDIO){
                            item.name = ff.getName();
                            item.type = MyConstants.TYPE_AUDIO;
                            item.path = ff.getAbsolutePath();

                            mArrAudioFile.add(item);
                        }
                    }
                }
            }
        }
        catch(Exception e){
        }

        Collections.sort(mArrAudioFile);

        for(int i = 0; i < mArrAudioFile.size(); i++) {
            FileItem subItem = mArrAudioFile.get(i);

            if(subItem.path.equals(MyConstants.g_CurrPlayFilePath)){
                MyConstants.g_CurrPlayFilePath = subItem.path;
                kog.m("[AudioPlay] setAudioFileList g_CurrPlayFilePath : " + MyConstants.g_CurrPlayFilePath);

                mPlayAudioFile = i;
                subItem.isSelect = true;
                break;
            }
        }

        mSelListAudioFile = mPlayAudioFile;

        refreshListView();
    }

    public class AudioFileAdapter extends BaseAdapter {
        LayoutInflater inflater;

        public AudioFileAdapter(Context context) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        public int getCount(){
            return mArrAudioFile.size();
        }

        public Object getItem(int position) {
            return mArrAudioFile.get(position);
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(final int position, View view, ViewGroup parent) {
            if(view == null){
                view = inflater.inflate(R.layout.item_audio_file_list, parent, false);
            }

            final FileItem item = (FileItem) getItem(position);

            view.setBackgroundResource(R.drawable.a_list_nor);

            TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_name.setText(item.name);

            tv_name.setTextColor(getResources().getColor(R.color.white));

            if(position == mSelListAudioFile){
                view.setBackgroundResource(R.drawable.a_list_sel);

                tv_name.setTextColor(getResources().getColor(R.color.black));
            }
            else{
                if(item.isSelect){
                    tv_name.setTextColor(getResources().getColor(R.color.orange300));
                }
            }

            return view;
        }
    }

    private void initFileListVal(){
        for(int i = 0; i < mArrAudioFile.size(); i++) {
            FileItem subItem = mArrAudioFile.get(i);

            subItem.isSelect = false;
        }
    }

    private void onPlayAudio(int pos){
        mHandlerMsg.removeMessages(IDEX_SHOW_PLAY_TIME_MSG);

		// Play the next song quickly.
		// block to black screen when play next fav file
        /*if(MyConstants.g_SelPlayList){
            MyConstants.g_IdxPlayList = pos;
            kog.m("[AudioPlay] onPlayAudio g_IdxPlayList : " + MyConstants.g_IdxPlayList);
            onExit();
            Function.sendMsgPlayListOne(this);
            return;
        }*/

        if(mService != null){
            mService.stop();
            //mService.removeCallback(this);
        }

        mPlayPos = pos;

        kog.m("[AudioPlay] onPlayAudio mPlayPos : " + mPlayPos);

        mHandlerMsg.sendEmptyMessageDelayed(IDEX_NEXT_PLAY, TIME_NEXT_PLAY);
        //mHandlerMsg.sendEmptyMessageDelayed(IDEX_REMOCON_ENABLE, TIME_REMOCON_ENABLE);
    }

    private void onPlayNext(){
        mIsRemoconControl = false;
        mHandlerMsg.removeMessages(IDEX_SHOW_PLAY_TIME_MSG);

		// Play the next song quickly.
		// block to black screen when play next fav file
        /*if(MyConstants.g_SelPlayList){
            onExit();
            Function.sendMsgPlayListNext(this);
            return;
        }*/

        if(mArrAudioFile.size() == 0) return;

        mPlayAudioFile ++;

        if(mPlayAudioFile == mArrAudioFile.size()){
            mPlayAudioFile = 0;
        }

        kog.m("[AudioPlay] onPlayNext mPlayAudioFile : " + mPlayAudioFile);

        onPlayAudio(mPlayAudioFile);
        mIsLastSetTime = true;
    }

    private void onPlayPrev(){
        mIsRemoconControl = false;
        mHandlerMsg.removeMessages(IDEX_SHOW_PLAY_TIME_MSG);

		// Play the next song quickly.
		// block to black screen when play next fav file
        /*if(MyConstants.g_SelPlayList){
            onExit();
            Function.sendMsgPlayListPrev(this);
            return;
        }*/

        if(mArrAudioFile.size() == 0) return;

        mPlayAudioFile --;

        if(mPlayAudioFile < 0){
            mPlayAudioFile = mArrAudioFile.size() - 1;
        }

        onPlayAudio(mPlayAudioFile);
        mIsLastSetTime = true;
    }

    private void refreshListView(){
        mAdapterAudioFile.notifyDataSetChanged();
        mListViewAudioFileList.setSelection(mSelListAudioFile);

        //_iv_up_down.setBackgroundResource(R.drawable.a_updown_nor);
    }

    private void setSpeed(float speed) {
        if(mService == null) return;

        if (mPlayRate < 0.7f || mPlayRate > 1.3f)
            return;
        mService.setRate(mPlayRate, false);

        MyConstants.g_AudioPlayRate = mPlayRate;
    }

    private void changeSpeed(float delta){
        if(mService == null) return;

        mPlayRate = Math.round((mService.getRate()+delta)*1000f)/1000f;

        if (mPlayRate < 0.7f || mPlayRate > 1.3f)
            return;
        mService.setRate(mPlayRate, false);

        MyConstants.g_AudioPlayRate = mPlayRate;

        String msg = getString(R.string.playback_speed) + " : " + String.format("%.2f", (mPlayRate-1.0f)*10/3+1.0f);
        showChangeSpeedMsg(msg);

		/*try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

    private void onPlayRepeat(){
        mGetLastPlayItem.lp_time = "-1";

        if(mRepeatMode == MyConstants.REPEAT_NO){
            onExit();
        }
        else if(mRepeatMode == MyConstants.REPEAT_ONE){
			// Play the next song quickly.
			// block to black screen when play next fav file
            /*if(MyConstants.g_SelPlayList){
                onExit();
                Function.sendMsgPlayListOne(this);
            }
            else*/
            {
                onPlayAudio(mPlayAudioFile);
            }
            //if(mService != null) mService.setTime(0);
        }
        else if(mRepeatMode == MyConstants.REPEAT_ALL){
            onPlayNext();
        }
        else if(mRepeatMode == MyConstants.REPEAT_FOLDER){
            onPlayNext();
        }
    }

    private void onExit(){
        kog.m("[AudioPlay] onExit");
        if (mService != null) {
            kog.m("[AudioPlay] AudioPlayerActivity onExit stop");
            mService.stop();
        }
        finish();
    }

    @SuppressLint("HandlerLeak")
    private Handler mHandlerMsg = new Handler(){
        public void handleMessage(Message msg){
            if(msg.what == IDEX_SHOW_CHANGE_SPEED_MSG){
                mHandlerMsg.removeMessages(IDEX_SHOW_CHANGE_SPEED_MSG);
                //if(mPlayRate == 1.0f)
                //    _tv_audio_rate.setVisibility(View.GONE);
                //else
                //    mHandlerMsg.sendEmptyMessageDelayed(IDEX_SHOW_CHANGE_SPEED_MSG, TIME_SHOW_CHANGE_SPEED_MSG);
            }
            else if(msg.what == IDEX_SHOW_PLAY_TIME_MSG){
                mHandlerMsg.removeMessages(IDEX_SHOW_PLAY_TIME_MSG);

                if(mService != null){
                    mServicePlayTime = (int) mService.getTime();

                    if(mServicePlayTime > 0){
                        mPlayTime = mServicePlayTime;
                    }
                    else{
                        mPlayTime += 1000;
                    }

                    //if(mPlayTime < 5000)
                    //    mService.setTime(mTotPlayTime - 5000, false);

                    mProgressBar.setProgress(mPlayTime);
                    _tv_play_time_curr.setText(Tools.millisToString(mPlayTime));

                    if(mIsLastSetTime){
                        if(mPlayTime > 0){
                            if(mStorageMode == 1)
                                PreferenceUtil.saveLastPlaySaveTime_USB(mPlayTime);
                            else if(mStorageMode == 2)
                                PreferenceUtil.saveLastPlaySaveTime_SD(mPlayTime);
                        }
                    }

                    //kog.m("[AudioPlay] IDEX_SHOW_PLAY_TIME_MSG playTime : " + mPlayTime + "   mTotPlayTime : " + mTotPlayTime +
                    //        "   mServicePlayTime : " + mServicePlayTime);

                    if(mPlayTime >= mTotPlayTime){
                        onPlayRepeat();
                        return;
                    }
                }
                else{
                    if(mServicePlayTime > 0){
                        mPlayTime += 1000;
                    }

                    //kog.m("[AudioPlay] IDEX_SHOW_PLAY_TIME_MSG mService null playTime : " + mPlayTime);
                }

				// Play the next song quickly.
                if(mTotPlayTime - mPlayTime < 2000)
                    mHandlerMsg.sendEmptyMessageDelayed(IDEX_SHOW_PLAY_TIME_MSG, TIME_SHOW_PLAY_TIME_MSG_SHORT);
                else
                    mHandlerMsg.sendEmptyMessageDelayed(IDEX_SHOW_PLAY_TIME_MSG, TIME_SHOW_PLAY_TIME_MSG);
            }
            else if(msg.what == IDEX_REMOCON_ENABLE){
                mHandlerMsg.removeMessages(IDEX_REMOCON_ENABLE);

                mIsRemoconControl = true;

                kog.m("[AudioPlay] IDEX_REMOCON_ENABLE mIsRemoconControl : " + mIsRemoconControl);
            }
            else if(msg.what == IDEX_NEXT_PLAY){
                mHandlerMsg.removeMessages(IDEX_NEXT_PLAY);

                initFileListVal();
                FileItem item = mArrAudioFile.get(mPlayPos);
                item.isSelect = true;
                mSelListAudioFile = mPlayPos;

                MyConstants.g_CurrPlayFilePath = item.path;
                if(mStorageMode == 1){
                    PreferenceUtil.saveLastPlayFilePath_USB(item.path);
                }
                else if(mStorageMode == 2){
                    PreferenceUtil.saveLastPlayFilePath_SD(item.path);
                }

                kog.m("[AudioPlay] IDEX_NEXT_PLAY g_CurrPlayFilePath : " + MyConstants.g_CurrPlayFilePath);

                File audioFile = new File(item.path);
                Uri uriFromAudioFile = null;
                uriFromAudioFile = Uri.fromFile(audioFile);

                //kog.m("[AudioPlay] IDEX_NEXT_PLAY uriFromAudioFile : " + uriFromAudioFile);

                if(uriFromAudioFile != null) {
                    MediaUtils.INSTANCE.openMediaNoUi(uriFromAudioFile);
                }
                else{
                    kog.m("[AudioPlay] IDEX_NEXT_PLAY uriFromAudioFile null ");
                }

                refreshListView();
            }
            else if(msg.what == IDEX_MAIN_LIST_TO_AUDIO){
                mHandlerMsg.removeMessages(IDEX_MAIN_LIST_TO_AUDIO);

                mIsRemoconControl = true;

                Intent intentMsg = new Intent("MSG_LIST_PLAY_START");
                sendBroadcast(intentMsg);

                kog.m("[AudioPlay] IDEX_MAIN_LIST_TO_AUDIO mIsRemoconControl : " + mIsRemoconControl);
            }
        }
    };

    PlayerState gState;
    public void update(PlayerState state) {
        if (state == null){
            kog.m("[AudioPlay] update state == null");
            return;
        }

        gState = state;
        mService = model.getService();

        if(mService == null){
            kog.m("[AudioPlay] update mService == null");
            return;
        }

        kog.m("[AudioPlay] update Title : " + state.getTitle());
        kog.m("[AudioPlay] update Artist : " + state.getArtist());
        kog.m("[AudioPlay] update Album : " + mService.getAlbum());
        kog.m("[AudioPlay] update getLength : " + mService.getLength());

        if(mService.getLength() <= 0){
            kog.m("[AudioPlay] update mService.getLength() <= 0");
            return;
        }

        mTitle.setText("Title : " + state.getTitle());
        mArtist.setText("Artist : " + state.getArtist());
        mAlbum.setText("Album : " + mService.getAlbum());

        mTotPlayTime = (int) mService.getLength();
        mProgressBar.setMax(mTotPlayTime);

        _tv_play_time_max.setText(Tools.millisToString(mTotPlayTime));

        if(!mIsPlaying){
            kog.m("[AudioPlay] update mIsPlaying : " + mIsPlaying);
            return;
        }

        _tv_play_time_curr.setText(Tools.millisToString(0));

        mService.setRate(mPlayRate, false);

        //mPlayTime = (int) mService.getTime();
        mPlayTime = 0;
        mStopCnt = 0;

        setSpeed(mPlayRate);

        setTimeLastPlayDB();

        mProgressBar.setProgress(mPlayTime);

        mHandlerMsg.removeMessages(IDEX_SHOW_PLAY_TIME_MSG);
        mHandlerMsg.sendEmptyMessageDelayed(IDEX_SHOW_PLAY_TIME_MSG, TIME_SHOW_PLAY_TIME_MSG);

        mHandlerMsg.removeMessages(IDEX_MAIN_LIST_TO_AUDIO);
        mHandlerMsg.sendEmptyMessageDelayed(IDEX_MAIN_LIST_TO_AUDIO, TIME_MAIN_LIST_TO_AUDIO);

        kog.m("[AudioPlay] update mPlayTime : " + mPlayTime);

        final MediaWrapper mw = model.getCurrentMediaWrapper();
        if (mw == null || TextUtils.equals(mCurrentCoverArt, mw.getArtworkMrl())) return;
        mCurrentCoverArt = mw.getArtworkMrl();
        updateBackground();
    }

    private void updateBackground() {
        WorkersKt.runIO(new Runnable() {
            @Override
            public void run() {
                final Bitmap cover = AudioUtil.readCoverBitmapJava(Uri.decode(mCurrentCoverArt), mCover.getWidth());
                final Bitmap blurredCover = cover != null ? UiTools.blurBitmap(cover) : null;
                WorkersKt.runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        if (cover == null) {
                            mCover.setImageResource(R.drawable.a_cd);
                        } else {
                            mCover.setImageBitmap(cover);
                        }
                    }
                });
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        kog.m("[AudioPlay] onResume");

        //mIsRemoconControl = true;
        mHandlerMsg.sendEmptyMessageDelayed(IDEX_REMOCON_ENABLE, TIME_REMOCON_ENABLE);
        //mHandlerMsg.sendEmptyMessageDelayed(IDEX_SHOW_PLAY_TIME_MSG, TIME_SHOW_PLAY_TIME_MSG);

        update(gState);
    }

    @Override
    protected void onPause() {
        super.onPause();
        kog.m("[AudioPlay] onPause");

        mIsRemoconControl = false;

        mHandlerMsg.removeMessages(IDEX_MAIN_LIST_TO_AUDIO);
        mHandlerMsg.removeMessages(IDEX_REMOCON_ENABLE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // bslim
        kog.m("[AudioPlay] onDestroy");

        mHandlerMsg.removeMessages(IDEX_SHOW_CHANGE_SPEED_MSG);
        mHandlerMsg.removeMessages(IDEX_SHOW_PLAY_TIME_MSG);
        mHandlerMsg.removeMessages(IDEX_NEXT_PLAY);
        mHandlerMsg.removeMessages(IDEX_REMOCON_ENABLE);
        mHandlerMsg.removeMessages(IDEX_MAIN_LIST_TO_AUDIO);

        if(mRemoconReceiver != null)
            unregisterReceiver(mRemoconReceiver);

        // edit by ssh 20200812
        if(mVolumeReceiver != null)
            unregisterReceiver(mVolumeReceiver);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean dispatchGenericMotionEvent(MotionEvent event){
        //Check for a joystick event
        if ((event.getSource() & InputDevice.SOURCE_JOYSTICK) !=
                InputDevice.SOURCE_JOYSTICK ||
                event.getAction() != MotionEvent.ACTION_MOVE)
            return false;

        final InputDevice inputDevice = event.getDevice();

        float dpadx = event.getAxisValue(MotionEvent.AXIS_HAT_X);
        float dpady = event.getAxisValue(MotionEvent.AXIS_HAT_Y);
        if (inputDevice == null || Math.abs(dpadx) == 1.0f || Math.abs(dpady) == 1.0f) return false;

        float x = AndroidDevices.getCenteredAxis(event, inputDevice,
                MotionEvent.AXIS_X);

        if (Math.abs(x) > 0.3 && System.currentTimeMillis() - mLastMove > JOYSTICK_INPUT_DELAY) {
            seek(x > 0.0f ? 10000 : -10000);
            mLastMove = System.currentTimeMillis();
            return true;
        }
        return true;
    }

    private void seek(int delta) {
        int time = (int) mService.getTime()+delta;
        if (time < 0 || time > mService.getLength()) return;

        kog.m("[AudioPlay] seek time : " + time);

        mService.setTime(time, false);
    }

    public void playSelection() {
    }

    public void onUpdateFinished() {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
            }
        });
    }
}
