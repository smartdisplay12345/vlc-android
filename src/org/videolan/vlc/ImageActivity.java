package org.videolan.vlc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.videolan.libvlc.LibVLC;
import org.videolan.libvlc.Media;
import org.videolan.vlc.common.MyConstants;
import org.videolan.vlc.common.DefineRemocon;
import org.videolan.vlc.common.Function;
import org.videolan.vlc.common.kog;
import org.videolan.vlc.items.FileItem;
import org.videolan.vlc.items.PlayListItem;
import org.videolan.vlc.media.MediaUtils;
import org.videolan.vlc.util.PreferenceUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.viewpager.widget.ViewPager;

public class ImageActivity extends Activity implements OnClickListener {
	private static final int IDEX_SHOW_SLIDE = 1, TIME_SHOW_SLIDE = 3000;
    private static final int IDEX_CHECK_FILE = 2, TIME_CHECK_FILE = 200;
    private static final int IDEX_MAIN_LIST = 3, TIME_MAIN_LIST = 5000;

	private Button _bt_list;

	private ArrayList<FileItem> mArrImageFile = new ArrayList<FileItem>();

	private ViewPager mPager = null;
	private ModImagePageAdapter mApPager;

	private BroadcastReceiver mRemoconReceiver;

	private boolean mIsRemoconControl = true, mIsSlide = true, mIsCheckFileNext = true;

	private int mIdxImageVideoFile = -1, mStorageMode;

	private ArrayList<PlayListItem> mArrPlayList = new ArrayList<PlayListItem>();

	private Cursor mPlayListDB = null;
	private String[] mstrProjection;

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

		setContentView(R.layout.activity_image);
		mContentView = findViewById(R.id.main_layout);

		_bt_list = (Button) findViewById(R.id.bt_list);
		_bt_list.setOnClickListener(this);

		mPager = (ViewPager) findViewById(R.id.viewpager_image);

		mStorageMode = PreferenceUtil.getModeStorage();

		if(!MyConstants.g_SelPlayList){
			setImageFileList();
		}
		else{
			mIdxImageVideoFile = 0;
		}

		mApPager = new ModImagePageAdapter(this);
		mPager.setAdapter(mApPager);

		mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
				if(position == mPager.getCurrentItem()){
				}
			}

			@Override
			public void onPageSelected(int position) {}

			@Override
			public void onPageScrollStateChanged(int state) {}
		});

		kog.m("[ImageActivity] onCreate mIdxImageVideoFile : " + mIdxImageVideoFile);
		mPager.setCurrentItem(mIdxImageVideoFile, true);

        /*mPager.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

		/*if(!MyConstants.g_SelPlayList){
			if(mArrImageFile.size() > 1) {
				mHandler.sendEmptyMessageDelayed(IDEX_SHOW_SLIDE, TIME_SHOW_SLIDE);
				mIsSlide = true;
			}
		}
		else{
			mHandler.sendEmptyMessageDelayed(IDEX_SHOW_SLIDE, TIME_SHOW_SLIDE);
		}*/

		IntentFilter mRemoconFilter = new IntentFilter();
		mRemoconFilter.addAction("MSG_UART_REMOCON");
		mRemoconFilter.addAction("MSG_FINISH");
		mRemoconFilter.addAction("MSG_IMAGE_CLICK");
        mRemoconFilter.addAction("MSG_LAUNCHER_EXIT");

		mRemoconReceiver  = new BroadcastReceiver(){
			public void onReceive(Context context, Intent intent) {
				String action = intent.getAction();
				if(action.equals("MSG_UART_REMOCON")){
					if(mIsRemoconControl) {
						byte key = intent.getByteExtra("Key", (byte) -1);
						onRemoconMode(key);
					}
				}
				else if(action.equals("MSG_FINISH")){
					finish();
				}
                else if(action.equals("MSG_LAUNCHER_EXIT")){
                    finish();
                }
                else if(action.equals("MSG_IMAGE_CLICK")){
                    kog.m("[ImageActivity] MSG_IMAGE_CLICK");

                    /*if(_bt_list.getVisibility() == View.VISIBLE){
                        mHandler.removeMessages(IDEX_MAIN_LIST);

                        _bt_list.setVisibility(View.GONE);
                    }
                    else if(_bt_list.getVisibility() == View.GONE){
                        _bt_list.setVisibility(View.VISIBLE);

                        mHandler.removeMessages(IDEX_MAIN_LIST);
                        mHandler.sendEmptyMessageDelayed(IDEX_MAIN_LIST, TIME_MAIN_LIST);
                    }*/

                    mIsRemoconControl = false;
                    Intent intentMsg = new Intent("MSG_MAIN_LIST");
                    sendBroadcast(intentMsg);

                    _bt_list.setVisibility(View.GONE);
                    mHandler.removeMessages(IDEX_SHOW_SLIDE);
                }
			}
		};
		registerReceiver(mRemoconReceiver, mRemoconFilter);
	}

	private void onRemoconMode(byte key){
		switch(key){
		case DefineRemocon.play:
			if(!MyConstants.g_SelPlayList){
				if(!mIsSlide){
					mHandler.sendEmptyMessageDelayed(IDEX_SHOW_SLIDE, TIME_SHOW_SLIDE);
					mIsSlide = true;
				}
			}
			break;

		case DefineRemocon.pause:
			if(!MyConstants.g_SelPlayList){
				if(mIsSlide) {
					mHandler.removeMessages(IDEX_SHOW_SLIDE);
					mIsSlide = false;
				}
			}
			break;

		case DefineRemocon.next:
			onPlayNext();
			break;

		case DefineRemocon.back:
			onPlayPrev();
			break;

		case DefineRemocon.stop:
			finish();
			Intent intentStop = new Intent("MSG_PLAY_STOP");
			sendBroadcast(intentStop);
			break;
			
		case DefineRemocon.list:
			//mIsRemoconList = true;
			//stopExit();
			kog.m("[ImageActivity] Remocon MSG_MAIN_LIST");
			mIsRemoconControl = false;
			Intent intentMsg = new Intent("MSG_MAIN_LIST");
			sendBroadcast(intentMsg);

            mHandler.removeMessages(IDEX_SHOW_SLIDE);
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

			//mArrPlayList.add(0, item);
			mArrPlayList.add(item);

			mPlayListDB.moveToNext();
		}
		mPlayListDB.close();

		return true;
	}

	private void setPlayListImageFileList(){
		mArrImageFile.clear();

		FileItem item = null;
		for(int i = 0; i < mArrPlayList.size(); i++) {
			PlayListItem plItem = mArrPlayList.get(i);

			int type = Integer.parseInt(plItem.pl_type);
			if(type == MyConstants.TYPE_IMAGE){
				item = new FileItem();
				item.name = plItem.pl_name;
				item.type = MyConstants.TYPE_IMAGE;
				item.path = plItem.pl_path;

				mArrImageFile.add(item);
			}
		}

		Collections.sort(mArrImageFile);

		MyConstants.g_ArrImageFile.clear();
		for(int i = 0; i < mArrImageFile.size(); i++) {
			MyConstants.g_ArrImageFile.add(mArrImageFile.get(i));

			FileItem subItem = mArrImageFile.get(i);
			if(subItem.path.equals(MyConstants.g_SelImageFileItem.path)){
				MyConstants.g_CurrPlayFilePath = subItem.path;
				kog.m("setImageFileList g_CurrPlayFilePath : " + MyConstants.g_CurrPlayFilePath);

				mIdxImageVideoFile = i;
			}
		}
	}

	private void setImageFileList(){
		File fileAudio = new File(MyConstants.g_SelImageFileItem.path_parrent);
		mArrImageFile.clear();

		FileItem item = null;
		File[] dirs = fileAudio.listFiles();

		List<FileItem> fls = new ArrayList<FileItem>();
		try{
			for(File ff: dirs){
				if(!ff.isHidden()){
					item = new FileItem();

					if(!ff.isDirectory()){
						int type = Function.defineType(ff.getName());

						kog.m("setImageFileList getName : " + ff.getName() + "   type : " + type);
						if(type == MyConstants.TYPE_IMAGE){
							item.name = ff.getName();
							item.type = MyConstants.TYPE_IMAGE;
							item.path = ff.getAbsolutePath();

							mArrImageFile.add(item);
						}
					}
				}
			}
		}
		catch(Exception e){
		}

		Collections.sort(mArrImageFile);

		MyConstants.g_ArrImageFile.clear();

		for(int i = 0; i < mArrImageFile.size(); i++) {
			MyConstants.g_ArrImageFile.add(mArrImageFile.get(i));

			FileItem subItem = mArrImageFile.get(i);
			if(subItem.path.equals(MyConstants.g_SelImageFileItem.path)){
				MyConstants.g_CurrPlayFilePath = subItem.path;
				kog.m("setImageFileList g_CurrPlayFilePath : " + MyConstants.g_CurrPlayFilePath);

				mIdxImageVideoFile = i;
			}
		}
	}

    private boolean checkFile(){
        File imgFile = new File(MyConstants.g_ArrImageFile.get(mIdxImageVideoFile).path);

        if(imgFile.exists()){
            if(imgFile.length() > 0){
                return true;
            }
        }
	    return false;
    }

	private void onPlayNext(){
		if(MyConstants.g_SelPlayList){
			mIsRemoconControl = false;
			Function.sendMsgPlayListNext(this);
			finish();
			return;
		}

		if(mArrImageFile.size() == 0) return;

		mHandler.removeMessages(IDEX_SHOW_SLIDE);
		mIdxImageVideoFile ++;

		if(mIdxImageVideoFile == mArrImageFile.size()){
			mIdxImageVideoFile = 0;
		}

        if(!checkFile()){
            mIsCheckFileNext = true;
            mHandler.sendEmptyMessageDelayed(IDEX_CHECK_FILE, TIME_CHECK_FILE);
            return;
        }

		//Constants.g_CurrPlayFilePath = mArrImageFile.get(mIdxImageVideoFile).path;
		//kog.m("onPlayNext g_CurrPlayFilePath : " + Constants.g_CurrPlayFilePath);

		mPager.setCurrentItem(mIdxImageVideoFile, true);
		mHandler.sendEmptyMessageDelayed(IDEX_SHOW_SLIDE, TIME_SHOW_SLIDE);
	}

	private void onPlayPrev(){
		if(MyConstants.g_SelPlayList){
			mIsRemoconControl = false;
			Function.sendMsgPlayListPrev(this);
			finish();
			return;
		}

		if(mArrImageFile.size() == 0) return;

		mHandler.removeMessages(IDEX_SHOW_SLIDE);
		mIdxImageVideoFile --;

		if(mIdxImageVideoFile < 0){
			mIdxImageVideoFile = mArrImageFile.size() - 1;
		}

        if(!checkFile()){
            mIsCheckFileNext = false;
            mHandler.sendEmptyMessageDelayed(IDEX_CHECK_FILE, TIME_CHECK_FILE);
            return;
        }

		//Constants.g_CurrPlayFilePath = mArrImageFile.get(mIdxImageVideoFile).path;
		//kog.m("onPlayNext g_CurrPlayFilePath : " + Constants.g_CurrPlayFilePath);

		mPager.setCurrentItem(mIdxImageVideoFile, true);
		mHandler.sendEmptyMessageDelayed(IDEX_SHOW_SLIDE, TIME_SHOW_SLIDE);
	}

	@SuppressLint("HandlerLeak")
	private Handler mHandler = new Handler(){
		public void handleMessage(Message msg){
			if(msg.what == IDEX_SHOW_SLIDE){
				mHandler.removeMessages(IDEX_SHOW_SLIDE);

				onPlayNext();
			}
			else if(msg.what == IDEX_CHECK_FILE){
                mHandler.removeMessages(IDEX_CHECK_FILE);

                if(mIsCheckFileNext) onPlayNext();
                else onPlayPrev();
            }
            else if(msg.what == IDEX_MAIN_LIST) {
                mHandler.removeMessages(IDEX_MAIN_LIST);

                _bt_list.setVisibility(View.GONE);
            }
		}
	};

	@Override
	protected void onResume() {
		super.onResume();

		mIsRemoconControl = true;
		
		Intent intentMsg = new Intent("MSG_LIST_PLAY_START");
		sendBroadcast(intentMsg);

        if(!MyConstants.g_SelPlayList){
            if(mArrImageFile.size() > 1) {
                mHandler.sendEmptyMessageDelayed(IDEX_SHOW_SLIDE, TIME_SHOW_SLIDE);
                mIsSlide = true;
            }
        }
        else{
            mHandler.sendEmptyMessageDelayed(IDEX_SHOW_SLIDE, TIME_SHOW_SLIDE);
        }
	}

	@Override
	protected void onPause() {
		super.onPause();

		mIsRemoconControl = false;
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		mHandler.removeMessages(IDEX_SHOW_SLIDE);
        mHandler.removeMessages(IDEX_MAIN_LIST);

		if(mRemoconReceiver != null)
			unregisterReceiver(mRemoconReceiver);
	}

    /*@Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            kog.m("[ImageActivity] onTouchEvent ACTION_DOWN");

            if(_bt_list.getVisibility() == View.VISIBLE){
                _bt_list.setVisibility(View.GONE);
            }
            else if(_bt_list.getVisibility() == View.GONE){
                _bt_list.setVisibility(View.VISIBLE);
            }
        }
        return false;
    }*/

    @Override
	public void onClick(View v) {
		if (v.getId() == R.id.bt_list) {
			kog.m("[ImageActivity] onClick bt_list");
			mIsRemoconControl = false;
			Intent intentMsg = new Intent("MSG_MAIN_LIST");
			sendBroadcast(intentMsg);

			_bt_list.setVisibility(View.GONE);
			mHandler.removeMessages(IDEX_SHOW_SLIDE);
		}
	}

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

}
