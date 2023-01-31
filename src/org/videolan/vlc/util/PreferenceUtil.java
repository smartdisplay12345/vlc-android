package org.videolan.vlc.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import org.videolan.vlc.common.MyConstants;

/**
 * 설정 관련 함수 Class
 */
public class PreferenceUtil {
	public static final String PREF_NAME = "vlc_player"; // Preference Name

	private static Context mContext = null;
	private static SharedPreferences mPreference = null;

	public static final String KEY_MODE_STORAGE = "KEY_MODE_STORAGE";
	public static final String KEY_MODE_VIDEO_REPEAT= "KEY_MODE_VIDEO_REPEAT";
	public static final String KEY_MODE_AUDIO_REPEAT = "KEY_MODE_AUDIO_REPEAT";

	public static final String KEY_LAST_PLAY_FILE_PATH_USB = "KEY_LAST_PLAY_FILE_PATH_USB";
	public static final String KEY_LAST_PLAY_FILE_PATH_PARRENT_USB = "KEY_LAST_PLAY_FILE_PATH_PARRENT_USB";
	public static final String KEY_LAST_PLAY_SAVE_TIME_USB = "KEY_LAST_PLAY_SAVE_TIME_USB";
	public static final String KEY_LAST_PLAY_SAVE_MODE_USB = "KEY_LAST_PLAY_SAVE_MODE_USB";

	public static final String KEY_LAST_PLAY_FILE_PATH_SD = "KEY_LAST_PLAY_FILE_PATH_SD";
	public static final String KEY_LAST_PLAY_FILE_PATH_PARRENT_SD = "KEY_LAST_PLAY_FILE_PATH_PARRENT_SD";
	public static final String KEY_LAST_PLAY_SAVE_TIME_SD = "KEY_LAST_PLAY_SAVE_TIME_SD";
	public static final String KEY_LAST_PLAY_SAVE_MODE_SD = "KEY_LAST_PLAY_SAVE_MODE_SD";
	public static final String KEY_MAIN_VOL = "KEY_MAIN_VOL";
	
	public static final String KEY_PLAY_LIST_MODE = "KEY_PLAY_LIST_MODE";

	public static final String KEY_LAST_MOUNT_PATH_USB = "KEY_LAST_MOUNT_PATH_USB";
	public static final String KEY_LAST_MOUNT_TYPE_USB = "KEY_LAST_MOUNT_TYPE_USB";

	public static final String KEY_LAST_MOUNT_PATH_SD = "KEY_LAST_MOUNT_PATH_SD";
	public static final String KEY_LAST_MOUNT_TYPE_SD = "KEY_LAST_MOUNT_TYPE_SD";

	/**
	 * Singleton
	 * 
	 * @param context : getApplicationContext();
	 **/
	public static void init(Context context) {
		mContext = context;
		if (context != null) {
			mPreference = mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
		}
	}
	
	public static int getPlayListMode() {
		return mPreference.getInt(KEY_PLAY_LIST_MODE, 0);
	}

	public static void savePlayListMode(int val) {
		setPreferenceValue(KEY_PLAY_LIST_MODE, val);
	}

	public static int getMainVol() {
		return mPreference.getInt(KEY_MAIN_VOL, 15);
	}

	public static void saveMainVol(int val) {
		setPreferenceValue(KEY_MAIN_VOL, val);
	}

	public static void saveLastPlayFilePath_SD(String path) {
		setPreferenceValue(KEY_LAST_PLAY_FILE_PATH_SD, path);
	}

	public static String getLastPlayFilePath_SD() {
		return mPreference.getString(KEY_LAST_PLAY_FILE_PATH_SD, "");
	}

	public static void saveLastPlayFilePathParrent_SD(String path) {
		setPreferenceValue(KEY_LAST_PLAY_FILE_PATH_PARRENT_SD, path);
	}

	public static String getLastPlayFilePathParrent_SD() {
		return mPreference.getString(KEY_LAST_PLAY_FILE_PATH_PARRENT_SD, "");
	}

	public static void saveLastPlaySaveTime_SD(int time) {
		setPreferenceValue(KEY_LAST_PLAY_SAVE_TIME_SD, time);
	}

	public static int getLastPlaySaveTime_SD() {
		return mPreference.getInt(KEY_LAST_PLAY_SAVE_TIME_SD, -1);
	}

	public static void saveLastPlaySaveMode_SD(int mode) {
		setPreferenceValue(KEY_LAST_PLAY_SAVE_MODE_SD, mode);
	}

	public static int getLastPlaySaveMode_SD() {
		return mPreference.getInt(KEY_LAST_PLAY_SAVE_MODE_SD, -1);
	}

	public static void saveLastPlayFilePath_USB(String path) {
		setPreferenceValue(KEY_LAST_PLAY_FILE_PATH_USB, path);
	}

	public static String getLastPlayFilePath_USB() {
		return mPreference.getString(KEY_LAST_PLAY_FILE_PATH_USB, "");
	}

	public static void saveLastPlayFilePathParrent_USB(String path) {
		setPreferenceValue(KEY_LAST_PLAY_FILE_PATH_PARRENT_USB, path);
	}

	public static String getLastPlayFilePathParrent_USB() {
		return mPreference.getString(KEY_LAST_PLAY_FILE_PATH_PARRENT_USB, "");
	}

	public static void saveLastPlaySaveTime_USB(int time) {
		setPreferenceValue(KEY_LAST_PLAY_SAVE_TIME_USB, time);
	}

	public static int getLastPlaySaveTime_USB() {
		return mPreference.getInt(KEY_LAST_PLAY_SAVE_TIME_USB, -1);
	}

	public static void saveLastPlaySaveMode_USB(int mode) {
		setPreferenceValue(KEY_LAST_PLAY_SAVE_MODE_USB, mode);
	}

	public static int getLastPlaySaveMode_USB() {
		return mPreference.getInt(KEY_LAST_PLAY_SAVE_MODE_USB, -1);
	}

	public static void saveModeVideoRepeat(int mode) {
		setPreferenceValue(KEY_MODE_VIDEO_REPEAT, mode);
	}

	public static int getModeVideoRepeat() {
		return mPreference.getInt(KEY_MODE_VIDEO_REPEAT, MyConstants.REPEAT_FOLDER);
	}

	public static void saveModeAudioRepeat(int mode) {
		setPreferenceValue(KEY_MODE_AUDIO_REPEAT, mode);
	}

	public static int getModeAudioRepeat() {
		return mPreference.getInt(KEY_MODE_AUDIO_REPEAT, MyConstants.REPEAT_FOLDER);
	}
	
	public static void saveModeStorage(int mode) {
		setPreferenceValue(KEY_MODE_STORAGE, mode);
	}
	
	public static int getModeStorage() {
		return mPreference.getInt(KEY_MODE_STORAGE, 1);
	}

	public static String getKeyLastMountPathUsb() {
		return mPreference.getString(KEY_LAST_MOUNT_PATH_USB, "");
	}

	public static void saveKeyLastMountPathUsb(String path) {
		setPreferenceValue(KEY_LAST_MOUNT_PATH_USB, path);
	}

	public static String getKeyLastMountPathSd() {
		return mPreference.getString(KEY_LAST_MOUNT_PATH_SD, "");
	}

	public static void saveKeyLastMountPathSd(String path) {
		setPreferenceValue(KEY_LAST_MOUNT_PATH_SD, path);
	}

	public static boolean getUseVideo() {
		return mPreference.getBoolean("USE_VIDEO", false);
	}

	public static void saveUseVideo(boolean value) {
		setPreferenceValue("USE_VIDEO", value);
	}
	// ------- Overloading Method (Set preference data) ------->> //
	/**
	 * boolean 값 Preference를 저장
	 * 
	 * @param preName 키 이름
	 * @param flag value
	 */
	private static void setPreferenceValue(String preName, boolean flag) {
		Editor editor = mPreference.edit();
		editor.putBoolean(preName, flag);
		editor.commit();
	}

	/**
	 * String 값 Preference를 저장
	 * 
	 * @param preName 키 이름
	 * @param flag value
	 */
	private static void setPreferenceValue(String preName, String str) {
		Editor editor = mPreference.edit();
		editor.putString(preName, str);
		editor.commit();
	}

	/**
	 * int 값 Preference를 저장
	 * 
	 * @param preName 키 이름
	 * @param flag value
	 */
	private static void setPreferenceValue(String preName, int value) {
		Editor editor = mPreference.edit();
		editor.putInt(preName, value);
		editor.commit();
	}

}