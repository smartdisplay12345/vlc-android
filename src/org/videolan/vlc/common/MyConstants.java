package org.videolan.vlc.common;

import org.videolan.vlc.items.FileItem;
import org.videolan.vlc.items.PlayListItem;

import java.util.ArrayList;

public class MyConstants {
	public final static int TYPE_VIDEO = 0;
    public final static int TYPE_AUDIO = 1;
    public final static int TYPE_SUBTITLE = 2;
    public final static int TYPE_PLAYLIST = 5;
    public final static int TYPE_IMAGE = 6;

    public final static int TYPE_DIR = 0;
    public final static int TYPE_FILE = 1;
    public final static int TYPE_ROOT_DIR = 2;

    public final static int MODE_PLAY_VIDEO = 0, MODE_PLAY_AUDIO = 1, MODE_PLAY_IMAGE = 2;

    public final static int REPEAT_NO = 200, REPEAT_ONE = 201, REPEAT_ALL = 202, REPEAT_FOLDER = 203, REPEAT_RANDOM = 204;

    public final static int CHECK_VIDEO_OK = 0, CHECK_VIDEO_TRACK_FAIL = 1, CHECK_VIDEO_RATE_FAIL = 2, CHECK_VIDEO_UHD = 3,
            CHECK_VIDEO_HEVC_RATE_FAIL = 4, CHECK_AUDIO_TRACK_FAIL = 5, CHECK_VIDEO_HEVC_OVER_HD = 6, CHECK_VIDEO_DIVX = 7;

    public static String MSG_PLAYLIST_LIST_NEXT = "MSG_PLAYLIST_LIST_NEXT";
    public static String MSG_PLAYLIST_LIST_PREV = "MSG_PLAYLIST_LIST_PREV";
    public static String MSG_PLAYLIST_LIST_ONE = "MSG_PLAYLIST_LIST_ONE";

    public static PlayListItem g_Sel_PlayListItem = null;

    public static FileItem g_SelAudioFileItem = null;
    public static FileItem g_SelVideoFileItem = null;
    public static FileItem g_SelImageFileItem = null;

    public static ArrayList<FileItem> g_ArrImageFile = new ArrayList<FileItem>();
    public static ArrayList<FileItem> g_ArrVideoFile = new ArrayList<FileItem>();

    public static String g_PlayListAudioFile = null;
    public static String g_PlayListVideoFile = null;

    public static String g_SelImageFile = null;

    public static String g_CurrPlayFilePath = null;
    public static String g_PlayPathParrent = null;
    public static String g_CurrPlayFileName = null;

    public static boolean g_SelPlayList = false;
    public static ArrayList<FileItem> g_ArrPlayList = null;
    public static int g_IdxPlayList = -1;

    public static float g_VideoPlayRate = 1;
    public static float g_AudioPlayRate = 1;

    public static boolean g_IsLastPlay = false;

    public static boolean g_IsVideoMute = false;

    public static int g_VideoPlayErr = -1;

    public static String g_VideoPlayInfo = "";
}
