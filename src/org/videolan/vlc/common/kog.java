package org.videolan.vlc.common;

import android.util.Log;

/**
 * API for sending log output. 
 * SHOW_LOGS if true, then logs are appeared,  
 */

public class kog {

	public static boolean TEST = false;

	private static boolean SHOW_LOGS = true;
	//private static boolean SHOW_LOGS = false;

	private kog() {
	}

	public static void m(String msg) {
		if (SHOW_LOGS) {
			Log.d("bslim", msg);
		}
	}

	public static void d(String tag, String msg) {
		if (SHOW_LOGS) {
			Log.d(tag, msg);
		}
	}

	public static void e(String msg) {
		if (SHOW_LOGS) {
			Log.e("bslim", msg);
		}
	}

	public static void e(String msg, Exception e) {
		if (SHOW_LOGS) {
			Log.e("bslim", msg, e);
		}
	}

	public static void i(String tag, String msg) {
		if (SHOW_LOGS) {
			Log.i(tag, msg);
		}
	}

	public static void w(String tag, String msg) {
		if (SHOW_LOGS) {
			Log.w(tag, msg);
		}

	}
}
