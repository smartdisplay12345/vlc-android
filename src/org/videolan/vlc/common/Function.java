package org.videolan.vlc.common;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;

public class Function {
	private static ProgressDialog mProgressDialog = null;
	private static Toast mToast = null;

	public static Bitmap rotateBitmap(String src, Bitmap bitmap) {
		try {
			int orientation = getExifOrientation(src);

			if (orientation == 1) {
				return bitmap;
			}

			Matrix matrix = new Matrix();
			switch (orientation) {
				case 2:
					matrix.setScale(-1, 1);
					break;
				case 3:
					matrix.setRotate(180);
					break;
				case 4:
					matrix.setRotate(180);
					matrix.postScale(-1, 1);
					break;
				case 5:
					matrix.setRotate(90);
					matrix.postScale(-1, 1);
					break;
				case 6:
					matrix.setRotate(90);
					break;
				case 7:
					matrix.setRotate(-90);
					matrix.postScale(-1, 1);
					break;
				case 8:
					matrix.setRotate(-90);
					break;
				default:
					return bitmap;
			}

			try {
				Bitmap oriented = Bitmap.createBitmap(bitmap, 0, 0,
						bitmap.getWidth(), bitmap.getHeight(), matrix, true);
				bitmap.recycle();
				return oriented;
			} catch (OutOfMemoryError e) {
				e.printStackTrace();
				return bitmap;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return bitmap;
	}

	private static int getExifOrientation(String src) throws IOException {
		int orientation = 1;

		try {
			/**
			 * if your are targeting only api level >= 5 ExifInterface exif =
			 * new ExifInterface(src); orientation =
			 * exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
			 */
			if (Build.VERSION.SDK_INT >= 5) {
				Class<?> exifClass = Class.forName("android.media.ExifInterface");
				Constructor<?> exifConstructor = exifClass.getConstructor(new Class[]{String.class});
				Object exifInstance = exifConstructor.newInstance(new Object[]{src});
				Method getAttributeInt = exifClass.getMethod("getAttributeInt", new Class[]{String.class, int.class});
				Field tagOrientationField = exifClass.getField("TAG_ORIENTATION");
				String tagOrientation = (String) tagOrientationField.get(null);
				orientation = (Integer) getAttributeInt.invoke(exifInstance, new Object[]{tagOrientation, 1});
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}

		return orientation;
	}

	public static void sendMsgPlayListNext(Context context){
		Intent intent = new Intent();
		intent.setAction(MyConstants.MSG_PLAYLIST_LIST_NEXT);
		context.sendBroadcast(intent);
	}
	
	public static void sendMsgPlayListPrev(Context context){
		Intent intent = new Intent();
		intent.setAction(MyConstants.MSG_PLAYLIST_LIST_PREV);
		context.sendBroadcast(intent);
	}
	
	public static void sendMsgPlayListOne(Context context){
		Intent intent = new Intent();
		intent.setAction(MyConstants.MSG_PLAYLIST_LIST_ONE);
		context.sendBroadcast(intent);
	}
	
	public static int defineType(String fileName) {
        int type = -1;
        
        String fileExt = null;
        if (TextUtils.isEmpty(fileName))
            return type;

        int index = fileName.indexOf('?');
        if (index != -1)
        	fileName = fileName.substring(0, index);

        index = fileName.lastIndexOf(".");

        if (index != -1)
            fileExt = fileName.substring(index).toLowerCase(Locale.ENGLISH);

        if (!TextUtils.isEmpty(fileExt)) {
            if (Extensions.VIDEO.contains(fileExt)) {
            	type = MyConstants.TYPE_VIDEO;
            } else if (Extensions.AUDIO.contains(fileExt)) {
            	type = MyConstants.TYPE_AUDIO;
            } else if (Extensions.SUBTITLES.contains(fileExt)) {
            	type = MyConstants.TYPE_SUBTITLE;
            } else if (Extensions.PLAYLIST.contains(fileExt)) {
            	type = MyConstants.TYPE_PLAYLIST;
            } else if (Extensions.IMAGE.contains(fileExt)) {
				type = MyConstants.TYPE_IMAGE;
			}
        }
        
        return type;
    }
	
	public static boolean isFileExist(String path){
		boolean result;
		File file = new File(path);
		
		if(file != null && file.exists()){
			result = true;
		}else{
			result = false;
		}
		return result;
	}

	public static void showProg(Context ctx){
		if(mProgressDialog == null)
			mProgressDialog = ProgressDialog.show(ctx,"", "",true);
	}

	public static void hideProg(){
		if(mProgressDialog != null){
            /*try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            mProgressDialog.dismiss();
			mProgressDialog = null;
		}
	}

	public static void toast(Context context, String message){
		if(mToast != null)
			mToast.cancel();
		mToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
		mToast.show();
	}

	public static void toastLong(Context context, String message){
		Toast.makeText(context, message, Toast.LENGTH_LONG).show();
	}
	
	public static void startFileMediaScan(Context mContext, String path){ 
		mContext.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, 
				Uri.parse("file://" + path))); 
	}

}
