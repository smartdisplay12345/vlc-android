package org.videolan.vlc;

import org.videolan.vlc.items.LastPlayItem;
import org.videolan.vlc.items.PlayListItem;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.net.Uri;

public class PlayListProvider extends ContentProvider {
	/** Called when the activity is first created. */

	public static String TAG = "PlayListProvider";
	private static final String myURI = "content://org.videolan.vlc.provider/";
	public static final Uri CONTENT_URI = Uri.parse(myURI);

	private static final String DATABASE_NAME = "PlayListDatabase.db";

	private static final String DATABASE_TABLE_PLAY_LIST_USB = "PlayListTableUsb";
	private static final String DATABASE_TABLE_PLAY_LIST_SD = "PlayListTableSD";
	private static final String DATABASE_TABLE_LAST_PLAY = "LastPlayTable";

	private static final int DATABASE_VERSION = 1;

	private SQLiteDatabase m_db;

	private DeviceProviderDbHelper dbHelper;
	private Context mContext = null;

	public static final String pl_USB_KEY_ID = "_pl_USB_id";

	public static final String pl_USB_path = "pl_USB_path";
	public static final String pl_USB_name = "pl_USB_name";
	public static final String pl_USB_type = "pl_USB_type";
	public static final String pl_USB_etc_1 = "pl_USB_etc_1";
	public static final String pl_USB_etc_2 = "pl_USB_etc_2";
	public static final String pl_USB_etc_3 = "pl_USB_etc_3";
	public static final String pl_USB_etc_4 = "pl_USB_etc_4";
	public static final String pl_USB_etc_5 = "pl_USB_etc_5";

	public static final String pl_SD_KEY_ID = "_pl_SD_id";

	public static final String pl_SD_path = "pl_SD_path";
	public static final String pl_SD_name = "pl_SD_name";
	public static final String pl_SD_type = "pl_SD_type";
	public static final String pl_SD_etc_1 = "pl_SD_etc_1";
	public static final String pl_SD_etc_2 = "pl_SD_etc_2";
	public static final String pl_SD_etc_3 = "pl_SD_etc_3";
	public static final String pl_SD_etc_4 = "pl_SD_etc_4";
	public static final String pl_SD_etc_5 = "pl_SD_etc_5";

	public static final String lp_KEY_ID = "_lp_id";
	public static final String lp_path = "lp_path";
	public static final String lp_type = "lp_type";
	public static final String lp_time = "lp_time";

	private static final String argTable[] = {"PlayListUSB", "PlayListSD", "LastPlay"};

	public static final String[] strTablePlayList_USB = new String[] {
			pl_USB_KEY_ID,
			pl_USB_path,
			pl_USB_name,
			pl_USB_type,
			pl_USB_etc_1,
			pl_USB_etc_2,
			pl_USB_etc_3,
			pl_USB_etc_4,
			pl_USB_etc_5};

	public static final String[] strTablePlayList_SD = new String[] {
			pl_SD_KEY_ID,
			pl_SD_path,
			pl_SD_name,
			pl_SD_type,
			pl_SD_etc_1,
			pl_SD_etc_2,
			pl_SD_etc_3,
			pl_SD_etc_4,
			pl_SD_etc_5};

	public static final String[] strTableLastPlay = new String[] {
			lp_KEY_ID,
			lp_path,
			lp_type,
			lp_time};

	private static class DeviceProviderDbHelper extends SQLiteOpenHelper {

		private static final String DATABASE_CREATE_PLAY_LIST_USB =
				"create table " + DATABASE_TABLE_PLAY_LIST_USB + " ("
						+ pl_USB_KEY_ID + " integer primary key autoincrement, "
						+ pl_USB_path + " TEXT, "
						+ pl_USB_name + " TEXT, "
						+ pl_USB_type + " TEXT, "
						+ pl_USB_etc_1 + " TEXT, "
						+ pl_USB_etc_2 + " TEXT, "
						+ pl_USB_etc_3 + " TEXT, "
						+ pl_USB_etc_4 + " TEXT, "
						+ pl_USB_etc_5 + " TEXT);";

		private static final String DATABASE_CREATE_PLAY_LIST_SD =
				"create table " + DATABASE_TABLE_PLAY_LIST_SD + " ("
						+ pl_SD_KEY_ID + " integer primary key autoincrement, "
						+ pl_SD_path + " TEXT, "
						+ pl_SD_name + " TEXT, "
						+ pl_SD_type + " TEXT, "
						+ pl_SD_etc_1 + " TEXT, "
						+ pl_SD_etc_2 + " TEXT, "
						+ pl_SD_etc_3 + " TEXT, "
						+ pl_SD_etc_4 + " TEXT, "
						+ pl_SD_etc_5 + " TEXT);";

		private static final String DATABASE_CREATE_LAST_PLAY =
				"create table " + DATABASE_TABLE_LAST_PLAY + " ("
						+ lp_KEY_ID + " integer primary key autoincrement, "
						+ lp_path + " TEXT, "
						+ lp_type + " TEXT, "
						+ lp_time + " TEXT);";

		public DeviceProviderDbHelper(Context context, String name, CursorFactory factory,
									  int version) {
			super(context, name, factory, version);
		}

		@Override
		public  void onCreate(SQLiteDatabase db) {
			db.execSQL(DATABASE_CREATE_PLAY_LIST_USB);
			db.execSQL(DATABASE_CREATE_PLAY_LIST_SD);
			db.execSQL(DATABASE_CREATE_LAST_PLAY);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DOP TABLE IF EXISTS " + DATABASE_CREATE_PLAY_LIST_USB);
			db.execSQL("DOP TABLE IF EXISTS " + DATABASE_CREATE_PLAY_LIST_SD);
			db.execSQL("DOP TABLE IF EXISTS " + DATABASE_CREATE_LAST_PLAY);

			onCreate(db);
		}
	}

	@Override
	public boolean onCreate(){
		mContext = getContext();
		dbHelper = new DeviceProviderDbHelper(mContext, DATABASE_NAME, null, DATABASE_VERSION);
		m_db = dbHelper.getWritableDatabase();

		return true;
	}

	public static ContentValues insertDataPlayList_USB(
			ContentValues values,
			PlayListItem info) {

		values.put(pl_USB_path, info.pl_path);
		values.put(pl_USB_name, info.pl_name);
		values.put(pl_USB_type, info.pl_type);
		values.put(pl_USB_etc_1, info.pl_etc_1);
		values.put(pl_USB_etc_2, info.pl_etc_2);
		values.put(pl_USB_etc_3, info.pl_etc_3);
		values.put(pl_USB_etc_4, info.pl_etc_4);
		values.put(pl_USB_etc_5, info.pl_etc_5);

		return values;
	}

	public static ContentValues insertDataPlayList_SD(
			ContentValues values,
			PlayListItem info) {

		values.put(pl_SD_path, info.pl_path);
		values.put(pl_SD_name, info.pl_name);
		values.put(pl_SD_type, info.pl_type);
		values.put(pl_SD_etc_1, info.pl_etc_1);
		values.put(pl_SD_etc_2, info.pl_etc_2);
		values.put(pl_SD_etc_3, info.pl_etc_3);
		values.put(pl_SD_etc_4, info.pl_etc_4);
		values.put(pl_SD_etc_5, info.pl_etc_5);

		return values;
	}

	public static ContentValues insertDataLastPlay(
			ContentValues values,
			LastPlayItem info) {

		values.put(lp_path, info.lp_path);
		values.put(lp_type, info.lp_type);
		values.put(lp_time, info.lp_time);

		return values;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) throws SQLException{
		try{
			String strDBTable = null;
			if(values.containsKey(pl_USB_path)){
				strDBTable = DATABASE_TABLE_PLAY_LIST_USB;
			}
			else if(values.containsKey(pl_SD_path)){
				strDBTable = DATABASE_TABLE_PLAY_LIST_SD;
			}
			else if(values.containsKey(lp_path)){
				strDBTable = DATABASE_TABLE_LAST_PLAY;
			}

			long rowID = 0;
			rowID = m_db.insert(strDBTable, null, values);

			if(rowID > 0){
				Uri _uri = ContentUris.withAppendedId(uri, rowID);
				mContext.getContentResolver().notifyChange(_uri, null);

				return _uri;
			}

			return null;
		}catch(SQLException e){
			return null;
		}
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
		String strDBTable = null;
		if(values.containsKey(pl_USB_path)){
			strDBTable = DATABASE_TABLE_PLAY_LIST_USB;
		}
		else if(values.containsKey(pl_SD_path)){
			strDBTable = DATABASE_TABLE_PLAY_LIST_SD;
		}
		else if(values.containsKey(lp_path)){
			strDBTable = DATABASE_TABLE_LAST_PLAY;
		}

		int count = 0;
		count = m_db.update(strDBTable, values, selection, selectionArgs);

		mContext.getContentResolver().notifyChange(uri, null);

		return count;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder){
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

		if(projection == strTablePlayList_USB){
			qb.setTables(DATABASE_TABLE_PLAY_LIST_USB);
		}
		else if(projection == strTablePlayList_SD){
			qb.setTables(DATABASE_TABLE_PLAY_LIST_SD);
		}
		else if(projection == strTableLastPlay){
			qb.setTables(DATABASE_TABLE_LAST_PLAY);
		}

		try{
			Cursor result = qb.query(m_db, projection, selection, selectionArgs, null, null, sortOrder);
			result.setNotificationUri(mContext.getContentResolver(), uri);
			return result;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		String strDBTable = null;

		if(selectionArgs[0].equalsIgnoreCase(argTable[0])){
			strDBTable = DATABASE_TABLE_PLAY_LIST_USB;
		}
		else if(selectionArgs[0].equalsIgnoreCase(argTable[1])){
			strDBTable = DATABASE_TABLE_PLAY_LIST_SD;
		}
		else if(selectionArgs[0].equalsIgnoreCase(argTable[2])){
			strDBTable = DATABASE_TABLE_LAST_PLAY;
		}

		int count = m_db.delete(strDBTable, selection, null);

		return count;
	}

	private static final int ALLROWS = 1;
	private static final int SINGLE_ROW = 2;

	private static final UriMatcher uriMatcher;

	static{
		uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		uriMatcher.addURI("org.videolan.vlc.provider", "info",ALLROWS);
		uriMatcher.addURI("org.videolan.vlc.provider", "info/#", SINGLE_ROW);
	}

	@Override
	public String getType(Uri uri) {
		switch (uriMatcher.match(uri)) {
			case ALLROWS:
				return "vnd.paad.cursor.dir/myprovidercontent";

			case SINGLE_ROW:
				return "vnd.paad.cursor.item/myprovidercontent";

			default:
				throw new IllegalArgumentException("Unsupported URI: " + uri);

		}
	}
}

