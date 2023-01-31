package org.videolan.vlc;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.videolan.vlc.common.MyConstants;
import org.videolan.vlc.common.Function;
import org.videolan.vlc.common.kog;

import java.io.File;

import androidx.viewpager.widget.PagerAdapter;

public class ModImagePageAdapter extends PagerAdapter {
	private Context mContext = null;
	private LayoutInflater mInflater = null;

	public ModImagePageAdapter(Context context) {
		mContext = context;

		mInflater = LayoutInflater.from(mContext);
	}

	@Override
	public int getCount() {
		int size = 0;
		if(!MyConstants.g_SelPlayList){
			size = MyConstants.g_ArrImageFile.size();
		}
		else{
			size = 1;
		}
		
		return size;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		View view = mInflater.inflate(R.layout.item_image_pager, null);

		ImageView iv_image_pager = (ImageView)view.findViewById(R.id.iv_image_pager);

		File imgFile = null;
		
		if(!MyConstants.g_SelPlayList){
			imgFile = new File(MyConstants.g_ArrImageFile.get(position).path);
			MyConstants.g_CurrPlayFilePath = MyConstants.g_ArrImageFile.get(position).path;
		}
		else{
			imgFile = new File(MyConstants.g_CurrPlayFilePath);
		}
		kog.m("ModImagePageAdapter path : " + MyConstants.g_CurrPlayFilePath);

		if(imgFile.exists()){
			BitmapFactory.Options opt = new BitmapFactory.Options();
			opt.inSampleSize = 2;

			Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath(), opt);
			Bitmap modBitmap = Function.rotateBitmap(imgFile.getAbsolutePath(), myBitmap);
			iv_image_pager.setImageBitmap(modBitmap);
		}

		iv_image_pager.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
                kog.m("ModImagePageAdapter OnClickListener");

                Intent intentMsg = new Intent("MSG_IMAGE_CLICK");
                mContext.sendBroadcast(intentMsg);
			}
		});

		container.addView(view);  
		
		return view;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View)object);
	}

	@Override
	public boolean isViewFromObject(View v, Object obj) {
		return v == obj;
	}

}
